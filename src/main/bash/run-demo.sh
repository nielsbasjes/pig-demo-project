#!/bin/bash

# NOTE: The -x local is here FOR THE DEMO ONLY
pig -x local -param_file etc/AccessLogs.properties pig/demo.pig

