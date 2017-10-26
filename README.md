
# 配置文件
* 位置：fileupload/src/main/resources/conf.properties
* 配置了文件存储路径和上传文件大小

# 上传文件接口
* URL：http://localhost:8080/fileupload/upload.html
* 方式：POST
* 参数：myfile
* Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

* 返回格式：json格式数据
````
{"status":1,"message":"ok"}
````
* 返回值可选值

|status|message|
|---|---|
|1|ok|
|0|上传失败|


# 案例
* 上传文件"test.txt"
* 对应的HTTP请求信息如下：

````
POST /fileupload/upload.html HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="myfile"; filename="test.txt"
Content-Type: application/vnd.openxmlformats-officedocument.presentationml.presentation


------WebKitFormBoundary7MA4YWxkTrZu0gW--
````