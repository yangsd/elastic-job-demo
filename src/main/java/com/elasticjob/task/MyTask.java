package com.elasticjob.task;

import com.SpringBootStart;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author sdyang
 * @create 2018-01-06 16:08
 **/
public class MyTask implements SimpleJob {

    private static Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Override
    public void execute(ShardingContext context) {
        logger.info("-------   开始分配分片任务  -------");
        switch (context.getShardingItem()) {
            case 0:
                beginTask(context.getShardingParameter());
                break;
            case 1:
                beginTask(context.getShardingParameter());
                break;
            case 2:
                beginTask(context.getShardingParameter());
                break;
        }
        logger.info("-------   分配分片任务完成  -------");
    }

    private void beginTask(String param){
        logger.info(String.format("开始执行定时任务：%s",param));
        Long beginTime = new Date().getTime();

        logger.info(param);

        Long endTime = new Date().getTime();
        logger.info(String.format("定时任务【%s】执行结束，耗时%sms",param,endTime-beginTime));
    }
}
