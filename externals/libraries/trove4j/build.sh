#!/bin/bash
ARTIFACT=trove

mvn install:install-file -DpomFile=pom.xml -Dfile=${ARTIFACT}.jar 
mvn install:install-file -DpomFile=pom.xml -Dfile=${ARTIFACT}-sources.jar -Dclassifier=sources
mvn install:install-file -DpomFile=pom.xml -Dfile=${ARTIFACT}-javadocs.jar -Dclassifier=javadocs
