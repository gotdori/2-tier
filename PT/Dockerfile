# Base image
FROM adoptopenjdk:11-jre-hotspot

# Set working directory
WORKDIR /app

# Copy application files to the container
COPY . /app

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