FROM eclipse-temurin:17-jre

ADD target/kanto-service-0.0.1-SNAPSHOT.jar /app.jar
ADD curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENTRYPOINT java -javaagent:/opentelemetry-javaagent.jar \
                -DOTEL_TRACES_EXPORTER=logging \
                -DOTEL_METRICS_EXPORTER=logging \
                -DOTEL_LOGS_EXPORTER=logging \
                -DOTEL_METRIC_EXPORT_INTERVAL=15000
                -jar /app.jar