# Base image
FROM adoptopenjdk:11-jre-hotspot

# Set working directory
WORKDIR /app

# Copy application files to the container
COPY . /app

# Expose a port
EXPOSE 8081

# Set environment variables
ENV SERVER_PORT=8081
ENV SERVER_SERVLET_ENCODING_FORCE=true
ENV SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE=4
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://34.125.227.99:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=1234
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS=false
ENV SPRING_THYMELEAF_PREFIX=classpath:/templates/
ENV SPRING_THYMELEAF_SUFFIX=.html
ENV SPRING_THYMELEAF_CACHE=false
ENV SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true

# Define the command to run the application
CMD ["java", "-cp", "app:app/lib/*", "com.ds.project01.DsProject01Application"]