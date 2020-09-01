package com.example.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
@Component
@Slf4j
public class WebSockerServer {
    //静态变量，用来记录当前在线连接数。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSockerServer> webSocketSet = new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //接收sid
    private String userId ="";

    /**
     * 连接建立成功调用的方法
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        this.session = session;
        this.userId =userId;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新窗口开始监听:"+userId+",当前在线人数为" + getOnlineCount());
        try {
            //向客户端发送消息
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常" + e.getMessage());
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息内容
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        //接收到消息后，在这里可以处理自己的业务
        log.info("收到来自窗口"+ userId +"的信息:"+message);
        //如果是一个聊天室，可以在这里群发消息（这个只是举例，具体业务逻辑看自己的需要）
        for (WebSockerServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 发生错误时调用的方法
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误:"+ error.getMessage());
        error.printStackTrace();
    }
    /**
     * 服务器主动推送到客户端，这个客户端时当前连接的客户端（this.session）
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * @param message
     * @throws IOException
     */
    public static void sendInfo(String message) throws IOException {
        for (WebSockerServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     * 群发一个对象信息
     *
     */
   /* public static void sendInfo(List<Student> studentList){
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(JSON.toJSONString(studentList));
            } catch (IOException e) {
                continue;
            }
        }
    }*/

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSockerServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSockerServer.onlineCount--;
    }
}
