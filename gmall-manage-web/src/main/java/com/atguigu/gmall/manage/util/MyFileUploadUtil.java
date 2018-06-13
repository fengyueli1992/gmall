package com.atguigu.gmall.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public class MyFileUploadUtil {
    public static String uploadImage(MultipartFile file)throws Exception{
        URL resource = MyFileUploadUtil.class.getClassLoader().getResource("tracker.properties");
        ClientGlobal.init(resource.getPath());

        //建立tracker
        TrackerClient tc = new TrackerClient();
        TrackerServer ts = tc.getConnection();

        //建立storage客户端
        StorageClient storageClient = new StorageClient(ts, null);

        //4使用storage客户端上传
        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String[] pngs = storageClient.upload_file(file.getBytes(), split[1], null);
        String url="http://192.168.83.110";
        for (String png : pngs) {
            url+="/"+png;
        }
        System.out.println(url);
        return url;
    }
}
