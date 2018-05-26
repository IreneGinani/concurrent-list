#!/bin/bash
cd src

javac concurrent/list/*.java 

jar -cfm ../concurrentlist.jar ../Manifest.mf concurrent/list/*.class

java -jar ../concurrentlist.jar
