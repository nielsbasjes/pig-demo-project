
FROM centos:7

WORKDIR /root

ENV INSIDE_DOCKER Yes

# Install required tools
# Basics
RUN yum install -y curl tar vim-enhanced

# RPM Development
RUN yum install -y expect rpm-build rpm-sign

# Java Development
RUN yum install -y java-1.7.0-openjdk-devel

# Install Maven
RUN mkdir -p /usr/local/apache-maven
ENV M2_HOME /usr/local/apache-maven
ENV PATH ${M2_HOME}/bin:${PATH}
RUN curl -O http://archive.apache.org/dist/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz
RUN tar xzf apache-maven-3.2.5-bin.tar.gz --strip-components 1 -C /usr/local/apache-maven

# Install HDP repo and the required tools
RUN curl http://public-repo-1.hortonworks.com/HDP/centos6/2.x/GA/2.2.0.0/hdp.repo > /etc/yum.repos.d/hdp.repo
RUN mkdir /etc/yum.repos.keys/ && cd /etc/yum.repos.keys/ && fgrep 'gpgkey=' /etc/yum.repos.d/hdp.repo | cut -d'=' -f2 | sort -u | while read file ; do curl -O ${file} ; done
RUN cd /etc/yum.repos.keys/ && for file in * ; do rpm --import ${file} ; done
RUN yum install -y pig
ENV JAVA_HOME /usr/lib/jvm/java

