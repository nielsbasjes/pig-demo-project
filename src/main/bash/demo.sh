#!/bin/bash

# NOTE: The -x local is here FOR THE DEMO ONLY

. ./etc/pig.properties

pig ${RUNTIME} -param_file etc/AccessLogs.properties pig/demo.pig

