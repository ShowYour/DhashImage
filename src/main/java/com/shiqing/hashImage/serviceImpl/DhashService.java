package com.shiqing.hashImage.serviceImpl;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author：xiaoyu
 * @create： 12:44 2019/5/11
 * @description:
 */
@Service
public class DhashService {
    /**
     * @param filePath
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public String getDhashOfImage(String filePath) throws IOException, InterruptedException {
        Resource resource = new ClassPathResource("pythonScript/dhash_image.py");
        String absolutePath = resource.getFile().getAbsolutePath();
        String[] command = new String[]{"python",absolutePath,filePath};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        in.close();
        process.waitFor();
        return buffer.toString();
    }

    /**
     * @param dhash1
     * @param dhash2
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public Integer getHanmDistance(String dhash1,String dhash2) throws IOException, InterruptedException{
        Resource resource = new ClassPathResource("pythonScript/hanm_image.py");
        String absolutePath = resource.getFile().getAbsolutePath();
        String[] command = new String[]{"python",absolutePath,dhash1,dhash1};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        in.close();
        process.waitFor();
        return Integer.valueOf(buffer.toString());
    }

    @Test
    public void test() throws IOException, InterruptedException {
        DhashService dhashService = new DhashService();
        String dhashOfImage = dhashService.getDhashOfImage("http://i5.qhimg.com/t019c3e49c9c9319c33.jpg");
        Integer hanmDistance = dhashService.getHanmDistance("c82c3783aaed55a3", "c82c3783aaed55a3");
        System.out.println("DHASH:"+dhashOfImage);
        System.out.println("汉明距离："+hanmDistance);
    }
}
