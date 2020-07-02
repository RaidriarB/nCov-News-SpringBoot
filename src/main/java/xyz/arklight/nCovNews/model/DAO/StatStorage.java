package xyz.arklight.nCovNews.model.DAO;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics_storage")
public class StatStorage {

    @Id
    @Column(name = "add_datetime")
    private String addtime;

    @NotNull
    @Column(name = "word_cloud")
    private String word_cloud;

    @NotNull
    @Column(name = "cluster_graph")
    private String cluster_graph;

    @NotNull
    @Column(name = "keywords")
    private String keywords;

    public StatStorage() {
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getWord_cloud() {
        return word_cloud;
    }

    public void setWord_cloud(String word_cloud) {
        this.word_cloud = word_cloud;
    }

    public String getCluster_graph() {
        return cluster_graph;
    }

    public void setCluster_graph(String cluster_graph) {
        this.cluster_graph = cluster_graph;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
