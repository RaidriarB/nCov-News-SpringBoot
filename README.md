# 疫情新闻收集系统—Java后端



## 公告

文档正在完善中

正在编写后台管理系统

修改了接口格式

## 接口

所有接口一律按照数据库建表语句顺序返回JSON数据。

```json
GET /statresult/list  返回网页信息对应的统计数据列表
示例：
[{"uid":1,"keyword":"输入","url":"http://www.baidu.com","hot_spot_degree":1.0E-6},{"uid":2,"keyword":null,"url":"http://www.baidu.com","hot_spot_degree":-1.0}]
注意：有的网页信息可能没有统计数据，此时keyword为null，而热度值（hot_spot_degree）为-1。

GET /websites/list  返回监测网站列表
示例:
[{"uid":1,"start_url":"souhu.com","name":"搜狐"},{"uid":2,"start_url":"sina.com.cn","name":"新浪"}]

GET /textstorage/list  返回网页信息列表
示例：
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"}]

GET /res/cluster  返回聚类图片
GET /res/wordcloud  返回词云JSON
```

## 使用方法

在项目目录`/target`下有一个jar包，名字是nCovNews-0.0.1-SNAPSHOT.jar，直接执行这个文件就可以。

```
java -jar nCovNews-0.0.1-SNAPSHOT.jar
```

注意在jar包的所在目录建一个文件夹`temp`，其中存放聚类和词云生成的图片。

