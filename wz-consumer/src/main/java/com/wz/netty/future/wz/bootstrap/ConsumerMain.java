package com.wz.netty.future.wz.bootstrap;

import com.wz.dubbo.api.DemoService;
import com.wz.dubbo.api.MsgInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * TODO
 * wangzhen23
 * 2018/3/10.
 */
public class ConsumerMain {
    public static void main(String[] args) {
        String configLocation = "dubbo-consumer.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        DemoService ds = (DemoService) context.getBean("consumer1");

        System.out.println("===============================================");
        MsgInfo info = new MsgInfo();
        info.setId(1);
        info.setName("zhangsan");
        info.setMsgs(new ArrayList<String>());
        System.out.println(ds.returnMsgInfo(info));

        System.out.println("===============================================");
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}