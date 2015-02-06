#!/bin/bash

#rm -rf develop
mkdir develop
mkdir develop/lib

# If you have a custom UDF you MUST build and include it
mvn clean package -DskipTests=true
( cd develop/lib/ && ln -fs ../../target/*.jar . )

# Put all other dependencies in aswell
mvn dependency:copy-dependencies -DoutputDirectory=develop/lib -DexcludeScope="provided"

cd develop
ln -fs ../demolog .
ln -fs ../src/main/pig .
ln -fs ../src/main/bash/*.sh .
mkdir etc && cd etc 
find ../../src/main/resources/ -type f | while read configfile ; do ln -fs ${configfile} . ; done

# Now we overrule the config files with the "devel" versions.
for develconfigfile in *devel ; do rm ${develconfigfile%\.devel} ; mv ${develconfigfile} ${develconfigfile%\.devel} ; done

