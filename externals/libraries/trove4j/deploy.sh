#!/bin/bash
ARTIFACT=trove
REPO_ID="-DrepositoryId=release.aaloa.org"
REPO_URL="-Durl=http://nexus.aaloa.org/content/repositories/releases"
POM="-DpomFile=pom.xml"
FILE="-Dfile=${ARTIFACT}.jar"
SRC="-Dsources=${ARTIFACT}-sources.jar"
DOC="-Djavadoc=${ARTIFACT}-javadocs.jar"
OPT="$REPO_ID $REPO_URL $POM $FILE $SRC $DOC"

mvn org.apache.maven.plugins:maven-deploy-plugin:2.6:deploy-file $OPT
