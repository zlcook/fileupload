
# 配置文件
* 位置：fileupload/src/main/resources/conf.properties
* 配置了文件存储路径和上传文件大小

# 上传文件接口
* URL：http://localhost:8080/fileupload/upload.html
* 方式：POST
* 参数：myfile
* Content-Type: multipart/form-data

* 返回格式：json格式数据
```
{"status":1,"message":"ok"}
```
* 返回值可选值

|status|message|
|---|---|
|1|ok|
|0|上传失败|


# 上传文件HTTP请求信息
* 上传文件"test.txt"
* 对应的HTTP请求信息如下：

```
POST /fileupload/upload.html HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="myfile"; filename="test.txt"
Content-Type: application/vnd.openxmlformats-officedocument.presentationml.presentation


------WebKitFormBoundary7MA4YWxkTrZu0gW--
```

# 通过浏览器上传
* 系统启动后提供一个上传文件操作界面
* 地址：http://localhost:8080/fileupload/index.jsp

# 通过curl命令上传文件
* 上传当前目录下的pom.xml文件
* 执行命令如下：
```
 curl -F "myfile=@pom.xml" http://localhost:8080/fileupload/upload.html
```

