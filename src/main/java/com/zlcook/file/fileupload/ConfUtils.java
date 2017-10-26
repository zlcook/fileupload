package com.zlcook.file.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhouliang6 on 2017/10/25.
 */
public class ConfUtils {
    //配置文件没有配置时，使用该默认值
    private static String DEFAULT_SAVTH_PATH="D://upload/";
    /**
     * 文件保存路径
     */
    private static Properties config = new Properties();

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 加载存放网页地址的文件
     */
    static{
        //获取文件
        InputStream is=ConfUtils.class.getClassLoader().getResourceAsStream("conf.properties");
        try {
            config.load(is);
        }catch (IOException e) {
            e.printStackTrace();
            System.out.print("加载配置文件出错！");
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getSavePath(){
        String path = config.getProperty("save.path");
        if(null == path || path.trim().length()==0)
            return DEFAULT_SAVTH_PATH;
        return  path + generateSubDirName();
    }

    /**
     * 二级存储目录名称
     * @return
     */
    public static String generateSubDirName(){
         return sdf.format(new Date());
    }
}
