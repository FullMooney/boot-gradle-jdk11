FROM image-registry.openshift-image-registry.svc:5000/sample/amazoncorretto-11-0-22@sha256:99bb4e884223237cc48111708a4d2a2e04d51605c1dfb683b96d3b1a39800b53
COPY target/*SNAPSHOT.jar /app.jar
EXPOSE 8080
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /mnt/apps
RUN chmod -R 755 /mnt/apps
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=cloud"]
