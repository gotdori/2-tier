# Base image
FROM adoptopenjdk:11-jre-hotspot

# Set working directory
WORKDIR /workspace/app

# Copy application files to the container
COPY . /workspace/app

FROM adoptopenjdk:11-jre-hotspot
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Expose a port
EXPOSE 8082

# Define the command to run the application
CMD ["java", "-cp", "app:app/lib/*", "com.ds.project01.DsProject01Application"]