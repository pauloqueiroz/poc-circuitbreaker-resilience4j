FROM eclipse-temurin:17-jre

ADD target/kanto-service-0.0.1-SNAPSHOT.jar /app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENTRYPOINT java -javaagent:/opentelemetry-javaagent.jar \
                -Dotel.traces.exporter=logging \
                -Dotel.metrics.exporter=logging \
                -Dotel.logs.exporter=logging \
                -jar /app.jar