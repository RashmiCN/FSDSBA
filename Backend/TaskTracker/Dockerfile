
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/TaskTracker-0.0.1-SNAPSHOT.war tasktracker.war
EXPOSE 8083
#ENTRYPOINT exec java $JAVA_OPTS -war tasktracker.war
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -war tasktracker.war
