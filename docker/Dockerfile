
FROM centos:7

WORKDIR /root

ENV INSIDE_DOCKER Yes

# Install required tools
# Basics
RUN yum install -y curl tar vim-enhanced

# RPM Development
RUN yum install -y expect rpm-build rpm-sign

# Java Development
java-1.7.0-openjdk-devel

# Install Maven
RUN mkdir -p /usr/local/apache-maven
ENV M2_HOME /usr/local/apache-maven
ENV PATH ${M2_HOME}/bin:${PATH}
RUN curl -O http://archive.apache.org/dist/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz
RUN tar xzf apache-maven-3.2.5-bin.tar.gz --strip-components 1 -C /usr/local/apache-maven

