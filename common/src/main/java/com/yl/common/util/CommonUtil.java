package com.yl.common.util;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * @创建人 叶立
 * @创建时间 2023/2/13
 * @描述
 */
public class CommonUtil {

    /**
     * //计算指定对象及其引用树上的所有对象的综合大小，单位字节
     *         long s1 = RamUsageEstimator.sizeOf(rs)/1024/1024;
     *
     * //计算指定对象本身在堆空间的大小，单位字节
     *         long s2 = RamUsageEstimator.shallowSizeOf(rs);
     *
     * //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
     *         String s3 = RamUsageEstimator.humanSizeOf(rs);
     * @param o
     * @return
     */
    public static String getObjectSize(Object o){
        return RamUsageEstimator.humanSizeOf(o);

    }
}
