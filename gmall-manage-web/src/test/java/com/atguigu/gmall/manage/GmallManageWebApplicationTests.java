package com.atguigu.gmall.manage;




import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

	@Test
	public void contextLoads ()throws Exception {
		URL resource = GmallManageWebApplicationTests.class.getClassLoader().getResource("tracker.properties");
		ClientGlobal.init(resource.getPath());

		//建立tracker
		TrackerClient tc = new TrackerClient();
		TrackerServer ts = tc.getConnection();

		//建立storage客户端
		StorageClient storageClient = new StorageClient(ts, null);

		//4使用storage客户端上传
		String testPath="d://fyl.jpg";
		String[] pngs = storageClient.upload_file(testPath, "png", null);
		String url="http://192.168.83.110";
		for (String png : pngs) {
			url+="/"+png;
		}
		System.out.println(url);

	}

}
