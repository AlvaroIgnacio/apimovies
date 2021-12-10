#FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine@sha256:b6ab039066382d39cfc843914ef1fc624aa60e2a16ede433509ccadd6d995b1f
FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.13_8@sha256:aa9eddb062db030b831cf461d488746cc92f6adee21b9f191f0f7de42e8677df
RUN mkdir /app
RUN addgroup --system 1000 && adduser -S -s /bin/false -G 1000 1000
COPY target/apimovies-*.jar /app/apimovies.jar
WORKDIR /app
RUN chown -R 1000:1000 /app
USER 1000
CMD "java" "-jar" "apimovies.jar"