package cn.wjs.config;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Test {

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("abc")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
//        XxlJobHelper.log("XXL-JOB, Hello World.");
        System.out.println("aaaa");
        for (int i = 0; i < 5; i++) {
//            XxlJobHelper.log("beat at:" + i);
        }
        // default success
        return ReturnT.SUCCESS;
    }

}
