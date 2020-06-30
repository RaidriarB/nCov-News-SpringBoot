# 疫情新闻收集系统—Java后端



## 公告

文档正在完善中

正在编写后台管理系统

## 接口

所有接口一律按照数据库建表语句顺序返回JSON数据。

```json
GET /statresult/list  返回统计数据列表
示例：
[{"no":1,"category":2,"confidence":0.999999,"hot_spot_degree":1.0E-6,"time_of_updage":"2020-06-28 17:17:00"}]

GET /textstorage/list  返回网页信息列表
示例：
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"}]

GET /res/cluster  返回聚类图片
GET /res/wordcloud  返回词云html
```



