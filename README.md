# 疫情新闻收集系统—Java后端



## 公告

文档正在完善中

正在编写后台管理系统

修改了接口格式

下一步工作：更新一下sql，可信度编程百分比

## 接口

所有接口一律按照数据库建表语句顺序返回JSON数据。

考虑到前端适配，接口并非REST风格。所有接口都使用GET方法请求，不需要PUT、DELETE等方法。

**网页统计信息 /statresult/...**

```json
1.返回网页信息对应的统计数据列表
GET /statresult/list
返回结果示例：
[{"uid":4,"keyword":null,"url":"https://news.sina.com.cn/c/2020-07-01/doc-iircuyvk1342632.shtml","hot_spot_degree":"14837","confidence":"1.000000"},{"uid":6,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-07-01/doc-iircuyvk1346566.shtml","hot_spot_degree":"14410","confidence":"1.000000"},{"uid":9,"keyword":"新增","url":"https://news.sina.com.cn/c/2020-07-01/doc-iircuyvk1347939.shtml","hot_spot_degree":"8912","confidence":"1.000000"}]
已经修复null信息的bug。只要数据库正确，所有网页都有对应的统计信息。

2.返回按照热度降序排序的网页统计信息列表
GET /statresult/sortedlist
返回结果示例：
[{"uid":180,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-28/doc-iircuyvk0885954.shtml","hot_spot_degree":"4655","confidence":"0.954316"},{"uid":335,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-29/doc-iirczymk9606132.shtml","hot_spot_degree":"4297","confidence":"0.952713"},{"uid":186,"keyword":"新冠","url":"https://news.sina.com.cn/c/2020-06-28/doc-iirczymk9412741.shtml","hot_spot_degree":"4034","confidence":"0.954198"},{"uid":169,"keyword":"确诊","url":"https://news.sina.com.cn/c/2020-06-28/doc-iircuyvk0883475.shtml","hot_spot_degree":"4031","confidence":"0.953492"}]
```

**监测网站列表 /websites/...**

```json
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

```json
1.返回网页信息列表
GET /textstorage/list
返回结果示例：
[{"uid":1,"url":"http://www.baidu.com","hash":"1a3cf4124cd5253a904f23c","title":"http://www.baidu.com","publish_time":"2020-06-28 12:00:00","content":"双叶一下，你就知道。"}]
```

**其他资源 /res/...**

```
1.返回聚类图片
GET /res/cluster

2.返回词云JSON
GET /res/wordcloud
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

