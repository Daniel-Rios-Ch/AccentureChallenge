FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/corner-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/corner-service.jar"]

EXPOSE 6000