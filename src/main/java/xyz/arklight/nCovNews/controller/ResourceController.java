package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/res")
public class ResourceController {

    private String cloudPath = "temp/wordcloud.html";
    private String clusterPath = "temp/cluster.png";

    @RequestMapping(value = "/wordcloud",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public byte[] getWordcloudImage() throws IOException {
        File file = new File(cloudPath);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
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
