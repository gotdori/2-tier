# Build stage
FROM adoptopenjdk:11-jdk-hotspot as build
WORKDIR /workspace/app
COPY . /workspace/app
RUN ./gradlew build

# Package stage
FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Expose a port
EXPOSE 8082

# Set environment variables
ENV SERVER_PORT=8082
ENV SERVER_SERVLET_ENCODING_FORCE=true
ENV SPRING_THYMELEAF_PREFIX=classpath:/templates/
ENV SPRING_THYMELEAF_SUFFIX=.html
ENV SPRING_THYMELEAF_CACHE=false

# Define the command to run the application
CMD ["java", "-cp", "app:app/lib/*", "com.ds.project01.DsProject01Application"]