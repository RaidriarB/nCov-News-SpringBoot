package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@RequestMapping("/res")
@Component
public class ResourceController {

    private String cloudPath = "temp/疫情新闻词云图.html";
    private String clusterPath = "temp/cluster.png";

    @RequestMapping(value = "/wordcloud",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public byte[] getWordcloudJson() throws IOException {

        try{
            File file = new File(cloudPath);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            String content = new String(bytes,"utf-8");
            //json起始位置，根据文件结构是第二个大括号
            int pstart = content.indexOf("{",content.indexOf("{")+1);
            //json终止位置，根据文件结构是倒数第一个反大括号
            int pend = content.lastIndexOf("}");
            String new_content = content.substring(pstart,pend);
            System.out.println(new_content);
            byte[] new_bytes = new_content.getBytes("utf-8");
            return new_bytes;
        }catch (Exception e){
            e.printStackTrace();
            return "{\"msg\":\"error\"}".getBytes("utf-8");
        }

    }

    @RequestMapping(value = "/cluster",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getClusterImage() throws IOException {
        File file = new File(clusterPath);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
