package com.youyuan.argus.job.utils;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @Auther: GaoHY
 * @Date: 2019/1/8 16:08
 * @Description: 获取job中心配置的参数
 */
public class JobUtils {

    public static  <T> T  getJobParam(String key,Map<String, Object> jobDataMap, Class<T> clazz) {

        T result = null;
        if (jobDataMap == null) {
            return result;
        }
        Object obj = jobDataMap.get(key);
        if (obj != null) {
            boolean b = obj.toString().endsWith("\r");
            if (b) {
                String s = StringUtils.substringBefore(obj.toString(), "\r");
                result = TypeUtils.cast(s, clazz, ParserConfig.getGlobalInstance());
            } else {
                result = TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance());
            }
        }
        return result;
    }
}
