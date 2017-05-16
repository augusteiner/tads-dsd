
FROM openjdk:latest

RUN apt-get update \
  && apt-get --yes install omniidl omniidl-python

RUN useradd -M -u 1000 corba

USER corba
