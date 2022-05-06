FROM amazoncorretto:11
VOLUME /tmp
ARG APP_DEPENDENCY_DIR
ARG APP_CLASS=${package}.app.Application
ENV SPRINGBOOT_APPLICATION_CLASS=${APP_CLASS}
COPY ${APP_DEPENDENCY_DIR}/BOOT-INF/lib /app/lib
COPY ${APP_DEPENDENCY_DIR}/META-INF /app/META-INF
COPY ${APP_DEPENDENCY_DIR}/BOOT-INF/classes /app
HEALTHCHECK --interval=10s --timeout=5s CMD curl -f http://localhost:8077/actuator/health || exit 1
EXPOSE 8079
EXPOSE 8077
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -cp app:app/lib/* ${SPRINGBOOT_APPLICATION_CLASS}"]
