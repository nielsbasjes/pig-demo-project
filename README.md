README
====
This is (in terms of the actual application) a “Hello world” project. It does nothing useful.

This project intends to show a possible way of making PIG based project more managable by managing them with Maven.

So this project shows/provides:
# A reliable build environment part of the project for use by the developer (uses Docker).
# Automatically download external dependencies from maven central.
# How to write a custom Pig UDF 
    - unit test the UDF.
    - load in into the pig script.
# How to write a pig script that 
    - uses a Loader that was written externally ( https://github.com/nielsbasjes/logparser ) 
    - tries to keep the pig scripts as clean as possible by 
        - using property files.
        - only loading the JAR files that it really needs.
# Packaging your pig project with ALL required dependencies as a tar.gz and RPM
    - The RPM build also shows how to separate the BUILD of the RPM (done by developers) from the BUILD+SIGN (done only during a  release)

So the the result of simply running 'mvn package' is a tar.gz file AND an RPM that contains the 
entire project with all the required dependencies in a lib directory.


TODO
====
# Add a PigUnit test for the pig script itself.

