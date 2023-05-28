# Base image
FROM adoptopenjdk:11-jre-hotspot  AS build

WORKDIR /workspace/app

COPY . /workspace/app
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build -x test
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM adoptopenjdk:11-jre-hotspot 
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Expose a port
EXPOSE 8082


# Define the command to run the application
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.ds.project01.DsProject01Application"]