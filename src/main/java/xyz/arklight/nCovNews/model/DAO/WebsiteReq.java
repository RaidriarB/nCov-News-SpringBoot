package xyz.arklight.nCovNews.model.DAO;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="website_resquests")
public class WebsiteReq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotNull
    @Column(name = "start_url")
    private String surl;

    @NotNull
    private String name;

    @NotNull
    private String ip;

    @NotNull
    @Column(name = "request_datetime")
    private String rdtime;

    @NotNull
    @Column(name="add_or_delete")
    private Boolean op; // true为添加，False为删除

    public WebsiteReq() {
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRdtime() {
        return rdtime;
    }

    public void setRdtime(String rdtime) {
        this.rdtime = rdtime;
    }

    public Boolean getOp() {
        return op;
    }

    public void setOp(Boolean op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "WebsiteReq{" +
                "uid=" + uid +
                ", surl='" + surl + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", rdtime='" + rdtime + '\'' +
                ", op=" + op +
                '}';
    }
}
