FROM java:8u111-jre-alpine

RUN mkdir -p /usr/local/service

COPY . /usr/local/service/

WORKDIR /usr/local/service/bin

ENV PATH=${PATH}:/usr/local/service/bin

ENTRYPOINT ["sh", "start_docker.sh"]