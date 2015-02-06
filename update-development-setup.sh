#!/bin/bash

rm -rf develop
mkdir develop
mkdir develop/lib
mvn dependency:copy-dependencies -DoutputDirectory=develop/lib -DexcludeScope="provided" 

cd develop
ln -fs ../src/main/pig .
ln -fs ../src/main/bash/*.sh .
mkdir etc && cd etc 
find ../../src/main/resources/ -type f | while read configfile ; do ln -fs ${configfile} . ; done 
for develconfigfile in *devel ; do rm ${develconfigfile%\.devel} ; mv ${develconfigfile} ${develconfigfile%\.devel} ; done

