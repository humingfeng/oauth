package com.humingfeng.util;

import java.io.Closeable;
import java.io.IOException;

/**
     * @ProjectName:    IOUtils
     * @Package:        com.humingfeng.util
     * @ClassName:      IOUtils
     * @Description:    流工具类，继承自Spring
     * @Author:         胡铭锋
     * @CreateDate:     2018/9/25 17:28
     * @Version:        1.0
     */
public class IOUtils extends org.springframework.util.StreamUtils {

    /**
     * closeQuietly
     * @param closeable 自动关闭
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}
