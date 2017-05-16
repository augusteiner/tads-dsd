
FROM debian:jessie-slim

RUN apt-get update \
  && apt-get --yes install omniidl omniidl-python python-omniorb

RUN useradd -M -u 1000 corba

USER corba
