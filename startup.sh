#!/bin/bash

echo "Starting Tech-Blogs"
export TECH-BLOGS-CLASSPATH="/home/ryan/Learning/SpringBootTutorial/tech-blogs/target/tech-blogs-0.0.1-SNAPSHOT.jar;/home/ryan/Learning/SpringBootTutorial/key-store"
exec java  -cp "${TECH-BLOGS-CLASSPATH}"  -Dloader.main=com.qiusuo.techblogs.TechBlogsApplication  org.springframework.boot.loader.PropertiesLauncher