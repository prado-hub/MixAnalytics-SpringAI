FROM amazoncorretto:21
LABEL maintainer="prado-hub"
WORKDIR /application
COPY target/MixAnalytics-0.0.1-SNAPSHOT.jar /application/MixAnalyticsDocker.jar
ENTRYPOINT ["java","-jar","MixAnalyticsDocker.jar"]

