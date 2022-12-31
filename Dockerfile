FROM parkseungchul/centos8:package

MAINTAINER parkseungchul@gmail.com

RUN ["mkdir", "-p", "/app/regiview"]

WORKDIR /app/regiview

RUN ["git", "init"]

RUN ["git", "pull", "https://github.com/parkseungchul/regiView"]

RUN ["mvn", "install"]

WORKDIR /app/regiview/target

ENTRYPOINT java -jar /app/regiview/target/regiView-1.0.jar -D FOREGROUND

EXPOSE 8080