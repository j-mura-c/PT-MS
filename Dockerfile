FROM alpine:3.14

     RUN  apk update \
       && apk upgrade \
       && apk add --update openjdk11 tzdata curl unzip bash \
       && rm -rf /var/cache/apk/*
MAINTAINER globant.com
COPY build/libs/PT-MS-1.0-SNAPSHOT.jar PT-MS-1.0.jar
ENTRYPOINT ["java","-jar","/PT-MS-1.0.jar"]