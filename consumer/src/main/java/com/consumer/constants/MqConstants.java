package com.consumer.constants;

import org.springframework.stereotype.Component;

/*******************************
 * * 版权所有：快服科技
 * * 创建日期: 2019/8/23 10:38
 * * 创建作者: Kevin_Ge
 * * 版本:  1.0
 * * 功能:
 * * 最后修改时间:
 * * 修改记录:
 ********************************/
@Component
public class MqConstants {
    //模板
    public static final String MQ_SMS_TEMPLATE_QUEUE = "EIISYS_SMS_V3:MQ_SMS_TEMPLATE_QUEUE";

    public static final String MQ_SMS_TEMPLATE_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_TEMPLATE_EXCHANGE";

    public static final String MQ_SMS_TEMPLATE_KEY = "EIISYS_SMS_V3:MQ_SMS_TEMPLATE_KEY_";

    //签名
    public static final String MQ_SMS_SIGNATURE_QUEUE = "EIISYS_SMS_V3:MQ_SMS_SIGNATURE_QUEUE";

    public static final String MQ_SMS_SIGNATURE_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_SIGNATURE_EXCHANGE";

    public static final String MQ_SMS_SIGNATURE_KEY = "EIISYS_SMS_V3:MQ_SMS_SIGNATURE_KEY_";

    //发送任务记录
    public static final String MQ_SMS_SEND_TASK_WEB_QUEUE = "EIISYS_SMS_V3:MQ_SMS_SEND_TASK_WEB_QUEUE";

    public static final String MQ_SMS_SEND_TASK_WEB_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_SEND_TASK_WEB_EXCHANGE";

    public static final String MQ_SMS_SEND_TASK_WEB_KEY = "EIISYS_SMS_V3:MQ_SMS_SEND_TASK_WEB_KEY";

    //短信发送
    public static final String MQ_SMS_SEND_QUEUE = "EIISYS_SMS_V3:MQ_SMS_SEND_QUEUE";

    public static final String MQ_SMS_SEND_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_SEND_EXCHANGE";

    public static final String MQ_SMS_SEND_KEY = "EIISYS_SMS_V3:MQ_SMS_SEND_KEY_";

    //状态推送
    public static final String MQ_SMS_PUSH_QUEUE = "EIISYS_SMS_V3:MQ_SMS_PUSH_QUEUE";

    public static final String MQ_SMS_PUSH_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_PUSH_EXCHANGE";

    public static final String MQ_SMS_PUSH_KEY = "EIISYS_SMS_V3:MQ_SMS_PUSH_KEY";

    //延时重发
    public static final String DELAYED_LETTER_QUEUE = "latter_queue";

    public static final String DELAYED_LETTER_KEY = "direct_key";

    public static final String MQ_SMS_DIRECT_EXCHANGE = "direct_exchange";

    public static final String MQ_SMS_TRANS_QUEUE = "tran_queue";

    public static final String MQ_SMS_TRANS_KEY = "tran_key";
    
    
    // 针对发送短信超时, 设置死信队列 exchange + route key -> queue
    // exchange
    public static final String MQ_SMS_SEND_OT_EXCHANGE = "EIISYS_SMS_V3:MQ_SMS_SEND_OT_EXCHANGE";
    // route key
    public static final String MQ_SMS_SEND_OT_KEY = "EIISYS_SMS_V3:MQ_SMS_SEND_OT_KEY";
    // queue
    public static final String MQ_SMS_SEND_OT_QUEUE = "EIISYS_SMS_V3:MQ_SMS_SEND_OT_QUEUE";


}
