# 疫情新闻收集系统—Java后端



## 公告

文档正在完善中

正在编写后台管理系统

修改了接口格式

下一步工作：更新一下sql，可信度编程百分比

## 接口

所有接口一律按照数据库建表语句的「字段名称」作为属性名，返回JSON数据。

考虑到前端适配，接口并非REST风格。所有接口都使用GET方法请求，不需要PUT、DELETE等方法。

**监测网站反馈信息 /webreq/...**

```
1.提出一个添加或删除监测网站的请求，后台会记录IP与请求时间。
【注意！】{url}参数应该使用base64进行编码！否则会出错
GET /webreq/add/{url}/{name}
GET /webreq/delete/{url}/{name}

示例： 
GET webreq/add/aHR0cDovL3Rlc3QuMTIzLmNvbQo=/testname
{"code":1,"message":"操作成功"}
GET webreq/add/http://test.com/testname
{"code":-1,"message":"操作失败"}
```



**网页统计信息 /statresult/...**

```
1.返回按照热度降序排序的网页统计信息列表的前num条
GET /statresult/list/{num}
返回结果示例：
[{"uid":180,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-28/doc-iircuyvk0885954.shtml","hot_spot_degree":"4655","confidence":"0.954316"},{"uid":335,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-29/doc-iirczymk9606132.shtml","hot_spot_degree":"4297","confidence":"0.952713"},{"uid":186,"keyword":"新冠","url":"https://news.sina.com.cn/c/2020-06-28/doc-iirczymk9412741.shtml","hot_spot_degree":"4034","confidence":"0.954198"},{"uid":169,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-28/doc-iircuyvk0883475.shtml","hot_spot_degree":"4031","confidence":"0.953492"}]
```

**监测网站列表 /websites/...**

```
1.返回监测网站列表
GET /websites/list
返回结果示例:
[{"uid":1,"start_url":"souhu.com","name":"搜狐"},{"uid":2,"start_url":"sina.com.cn","name":"新浪"}]


2.添加检测网站，返回操作是否成功的信息
GET /websites/add/{name}/{url}
示例：
GET /websites/add/testname/testurl
{"code":1,"message":"操作成功"}


3.根据uid来删除监测网站，返回操作是否成功信息
GET /websites/delete/{uid} 
示例1 
GET /websites/delete/41
{"code":1,"message":"操作成功"}
示例2 
GET /websites/delete/1000
{"code":-1,"message":"操作失败"}

```

**网页爬取信息 /textstorage/...**

```
1.返回网页信息列表
GET /textstorage/list
返回结果示例：
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"},{"uid":2,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶两下，你就知道。"}]


2.返回特定uid的网页信息
GET /textstorage/{uid}
示例1
GET /textstorage/1
{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"}
示例2
GET /textstorage/2
{"uid":2,"url":"http://www.baidu.com","hash":"4c3cf3b5285dd5253029ef20a","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶两下，你就知道。"}

3.返回前num条网页消息，按照最新时间排序，注意num不能超过总个数哦
GET /textstorage/top/{num}
示例  GET /textstorage/top/2
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-29 12:00:00","content":"双叶两下，你就知道。"},{"uid":2,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-27 12:00:00","content":"双叶一下，你就知道。"}]

```

**其他资源 /res/...**

```
这部分正在修改中

1.返回聚类图片
GET /res/cluster

2.返回词云JSON
GET /res/wordcloud
```



## 使用方法

### 部署

在项目目录`/target`下有一个jar包，名字是nCovNews-0.0.1-SNAPSHOT.jar，直接执行这个文件就可以。

```
java -jar nCovNews-0.0.1-SNAPSHOT.jar
```

但这样子会随着会话结束而导致进程退出，因此写了个启动脚本，直接执行目录下的`run`就可以了。

注意在jar包的所在目录建一个文件夹`temp`，其中存放聚类和词云生成的图片。

### 如果你要打开项目源代码

本项目由IDEA构建，开始需要maven构建一会，如果觉得太慢可以百度下maven换镜像源。

