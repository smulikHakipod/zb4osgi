To update the weka library please follow the istruction below:
1 - Overwrite the weka.jar file with the new version
2 - Update the pom.xml according to the overwritten weka.jar, in particular updated the version number
3 - Execute mvn deploy:deploy-file -DpomFile=pom.xml -DrepositoryId=thirdparty -Dfile=trove.jar 
3 - Execute mvn deploy:deploy-file -DpomFile=pom.xml -DrepositoryId=thirdparty -Dfile=trove-sources.jar -Dclassifier=sources
3 - Execute mvn deploy:deploy-file -DpomFile=pom.xml -DrepositoryId=thirdparty -Dfile=trove-javadocs.jar -Dclassifier=javadocs
4 - Tag the new version with the command svn copy 
