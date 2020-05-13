#!/bin/bash

#########Put key store path into environment variable.
####Use Bash to read the environment variable.
####Set the TECH_BLOG HOME environment variable.

export JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=n $JAVA_OPTS"
exec ./startup.sh