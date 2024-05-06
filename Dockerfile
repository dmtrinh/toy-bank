FROM bitnami/java:17

LABEL org.opencontainers.image.source=https://github.com/dmtrinh/toy-bank \
      org.opencontainers.image.vendor="The Dark Side" \
      org.opencontainers.image.title="toy-bank" \
      org.opencontainers.image.description="Telepathic Bank"

EXPOSE 8080

WORKDIR /app

COPY /build/libs/toy-bank-0.0.1-SNAPSHOT.jar /app/toy-bank-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./toy-bank-0.0.1-SNAPSHOT.jar"]
