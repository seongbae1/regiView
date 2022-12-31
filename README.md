# [Docker Registry View](https://hub.docker.com/repository/docker/parkseungchul/regiview)

### 도커 레지스트리에 등록 된 이미지와 태그를 볼 수 있는 웹 어플리케이션

#### Installation
<pre><code>git clone https://github.com/parkseungchul/regiView
cd regiView
docker-compose up</code></pre>

#### Image Push for Test
<pre><code>docker pull nginx
docker pull httpd
docker pull centos
docker tag nginx localhost:5000/web:v1
docker tag httpd localhost:5000/web:v2
docker tag centos localhost:5000/centos
docker push localhost:5000/web:v1
docker push localhost:5000/web:v2
docker push localhost:5000/centos</code></pre>
#### 이미지 리스트 보기
![업로드 된 이미지 리스트](https://github.com/parkseungchul/regiView/blob/master/image/1.JPG)

#### 이미지 태크 리스트
![이미지의 태그 리스트](https://github.com/parkseungchul/regiView/blob/master/image/2.JPG)



