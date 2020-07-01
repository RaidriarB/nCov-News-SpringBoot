# 疫情新闻收集系统—Java后端



## 公告

文档正在完善中

正在编写后台管理系统

修改了接口格式

## 接口

所有接口一律按照数据库建表语句顺序返回JSON数据。

考虑到前端适配，接口并非REST风格。所有接口都使用GET方法请求，不需要PUT、DELETE等方法。

```json
GET /statresult/list  返回网页信息对应的统计数据列表
返回结果示例：
[{"uid":1,"keyword":"输入","url":"http://www.baidu.com","hot_spot_degree":1.0E-6},{"uid":2,"keyword":null,"url":"http://www.baidu.com","hot_spot_degree":-1.0}]
注意：有的网页信息可能没有统计数据，此时keyword为null，而热度值（hot_spot_degree）为-1。

GET /websites/list  返回监测网站列表
返回结果示例:
[{"uid":1,"start_url":"souhu.com","name":"搜狐"},{"uid":2,"start_url":"sina.com.cn","name":"新浪"}]

GET /websites/add/{name}/{url}  添加检测网站，返回操作是否成功的信息
示例：GET /websites/add/testname/testurl
{"code":1,"message":"操作成功"}

GET /websites/delete/{uid}  根据uid来删除监测网站，返回操作是否成功信息
示例1 GET /websites/delete/41
{"code":1,"message":"操作成功"}
示例2 GET /websites/delete/1000
{"code":-1,"message":"操作失败"}

GET /textstorage/list  返回网页信息列表
返回结果示例：
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"}]


GET /res/cluster  返回聚类图片
GET /res/wordcloud  返回词云JSON
```

## 使用方法

### Deploy

在项目目录`/target`下有一个jar包，名字是nCovNews-0.0.1-SNAPSHOT.jar，直接执行这个文件就可以。

```
java -jar nCovNews-0.0.1-SNAPSHOT.jar
```

注意在jar包的所在目录建一个文件夹`temp`，其中存放聚类和词云生成的图片。

### 项目源代码

需要修改一下配置文件中的数据库连接信息。

