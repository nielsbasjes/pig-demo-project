README
====
This is example shows a lost of things combined together:

- How to write a pig script that 
    - uses a custom Loader implementation ( https://github.com/nielsbasjes/logparser ) 
    - tries to keep the pig scripts as clean as possible by using property files.
- How to write a custom dissector and load in into a pig script.
- Managing pig projects with maven (downloading the Loader from maven central).
- Packaging your pig project with ALL required dependencies as a tar.gz and RPM
- Making a 'reliable' build environment part of your project by means of Docker.

The result of 'mvn package' is a tar.gz file AND an RPM that contains the 
entire project with all the required dependencies in a lib directory.
