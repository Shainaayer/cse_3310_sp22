JAVAC=javac
JAVA=java
CLASS_PATH=bin:jars/gson-2.8.9.jar:jars/log4j-1.2-api-2.17.1.jar:jars/log4j-api-2.17.1.jar:jars/log4j-core-2.17.1.jar

all: bin/Main.class ./bin/Card.class bin/Assignment1Test.class

bin/Main.class:src/Main.java bin/Hand.class ./bin/Card.class
	@[ -d bin ] || mkdir -p bin 
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Main.java

bin/Assignment1Test.class:src/Assignment1Test.java ./bin/Hand.class ./bin/Card.class
	@[ -d bin ] || mkdir -p bin 
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH}:jars/junit-platform-console-standalone-1.8.2.jar \
                 ./src/Assignment1Test.java

bin/Hand.class:src/Hand.java ./bin/Card.class
	@[ -d bin ] || mkdir -p bin 
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH}:./bin/Card.class \
                 ./src/Hand.java
bin:
	@mkdir -p bin

bin/Card.class:src/Card.java bin
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Card.java

run_tests: 
	${JAVA} -jar jars/junit-platform-console-standalone-1.8.2.jar \
                -cp ${CLASS_PATH} \
                -c Assignment1Test
#log4j-1.2-api-2.17.1.jar  log4j-api-2.17.1.jar 

run_main: 
	${JAVA} -cp ${CLASS_PATH} Main

clean:
	@rm -rf bin/
