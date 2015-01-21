mvn clean package
mkdir tmp
cd tmp
tar xzf ../target/*.tar.gz
cd demo*
./run-demo.sh
