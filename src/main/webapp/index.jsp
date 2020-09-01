<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>WebSocket 聊天室</title>
</head>
<body>
<script type="text/javascript">
    var socket;
    if (!window.WebSocket) {
        window.WebSocket = window.MozWebSocket;
    }
    if (window.WebSocket) {
        socket = new WebSocket("ws://127.0.0.1:8088/moyundong/websocket");
        socket.onmessage = function(event) {
            var ta = document.getElementById('responseText');
            ta.value = ta.value + '\n' + event.data
        };
        socket.onopen = function(event) {
            var ta = document.getElementById('responseText');
            ta.value = "连接开启!";
        };
        socket.onclose = function(event) {
            var ta = document.getElementById('responseText');
            ta.value = ta.value + "连接被关闭";
        };
    } else {
        alert("你的浏览器不支持 WebSocket！");
    }

    function send(message) {
        if (!window.WebSocket) {
            return;
        }
        if (socket.readyState == WebSocket.OPEN) {
            socket.send(message);
        } else {
            alert("连接没有开启.");
        }
    }
</script>
<form οnsubmit="return false;">
    <h3>WebSocket 聊天室：</h3>
    <textarea id="responseText" style="width: 500px; height: 300px;"></textarea>
    <br>
    <input type="text" name="message"  style="width: 300px" value='随便输入:'>
    <input type="button" value="发送消息" οnclick="send(this.form.message.value)">
    <input type="button" οnclick="javascript:document.getElementById('responseText').value=''" value="清空聊天记录">
</form>
</body>
</html>