#!/usr/bin/env sh

alias mvn='docker run --rm -it -v "$HOME/.m2:/root/.m2" -v "$PWD:/wd" -w "/wd" maven:alpine mvn'
alias java='docker run --rm -it -v "$PWD:/wd" -w "/wd" openjdk:alpine java'
