package xyz.arklight.nCovNews.controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * 资源文件的Controller
 * 返回词云JSON和聚类图片
 */
@Controller
@RequestMapping("/oldres")
@Component
public class OldResourceController {


    private String cloudPath = "temp/疫情新闻词云图.html";
    private String clusterPath = "temp/cluster.png";

    /**
     * 获取资源文件 词云JSON
     * @return JSON的byte数组
     * @throws IOException 在返回Bytes时可能出现不支持的Encoding，而encoding已经设置好了，不会出现异常。
     */
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
            int pend = content.lastIndexOf("}")+1;

            String new_content = content.substring(pstart,pend);
            System.out.println(new_content);
            byte[] new_bytes = new_content.getBytes("utf-8");
            return new_bytes;
        }catch (Exception e){
            e.printStackTrace();
            return "{\"msg\":\"error\"}".getBytes("utf-8");
        }
    }

    /**
     * 返回聚类图片
     * @return 聚类图片
     * @throws IOException 文件读取时可能发生错误
     */
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
