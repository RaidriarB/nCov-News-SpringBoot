package xyz.arklight.nCovNews.model.bean;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 实体类，用来对应数据库的textstorage表，存储网页内容
 */
@Entity
public class TextStorage {

    @Id
    private Long uid;

    @NotNull
    private String url;

    @NotNull
    private String hash;

    @NotNull
    private String title;

    @NotNull
    private String publish_time;

    @NotNull
    private String content;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextStorage{" +
                "uid=" + uid +
                ", url='" + url + '\'' +
                ", hash='" + hash + '\'' +
                ", title='" + title + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
