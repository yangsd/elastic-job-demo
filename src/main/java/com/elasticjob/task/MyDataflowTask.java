package com.elasticjob.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdyang
 * @create 2018-01-07 10:02
 **/
public class MyDataflowTask implements DataflowJob<String> {

    private static Logger logger = LoggerFactory.getLogger(MyDataflowTask.class);

    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        return this.find(shardingContext.getShardingItem());
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> list) {
        for(String str:list) {
            logger.info(String.format("任务分片【%s】,处理数据：%s",shardingContext.getShardingParameter(),str));
        }
    }

    private List<String> find(int param) {
        List<String> result = new ArrayList<String>();
        switch (param) {
            case 0:
                result.add("广州");
                break;
            case 1:
//                result.add("深圳");
                break;
            case 2:
//                result.add("惠州");
                break;
        }
        return result;
    }
}
