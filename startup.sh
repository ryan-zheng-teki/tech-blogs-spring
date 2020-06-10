#!/bin/bash

#########Put key store path into environment variable.
####Use Bash to read the environment variable.
####Set the TECH_BLOG HOME environment variable
source
echo "Starting Tech-Blogs"
if [ -z "$TECH_BLOG_HOME" ]
then
  echo "TECH_BLOG_HOME not set"
  exit
fi

if [ -z "$KEY_STORE" ]
then
  echo "KEY_STORE not set"
  exit
fi

if [ -z "$CONFIG" ]
then
  echo "CONFIG not set"
  exit
fi

export TECH_BLOGS_CLASSPATH="${TECH_BLOG_HOME}:${KEY_STORE}:${CONFIG}"
exec java  -classpath "${TECH_BLOGS_CLASSPATH}" $JAVA_OPTS  -Dloader.main=com.qiusuo.techblogs.TechBlogsApplication  org.springframework.boot.loader.PropertiesLauncher
