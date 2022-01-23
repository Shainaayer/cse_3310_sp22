JAVAC=javac
JAVA=java
CLASS_PATH=bin:jars/gson-2.8.9.jar:jars/log4j-api-2.17.1.jar:jars/log4j-core-2.17.1.jar

all: bin/Main.class bin/Assignment1Test.class

bin/Main.class:src/Main.java bin/poker/Hand.class 
	$(shell mkdir -p bin)
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Main.java

bin/Assignment1Test.class:src/Assignment1Test.java ./bin/poker/Hand.class
	$(shell mkdir -p bin)
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH}:jars/junit-platform-console-standalone-1.8.2.jar \
                 ./src/Assignment1Test.java

bin/poker/Hand.class:src/Hand.java ./bin/poker/Card.class
	$(shell mkdir -p bin)
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Hand.java

bin/poker/Card.class:src/Card.java
	$(shell mkdir -p bin)
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Card.java

bin/log4j2.xml:src/log4j2.xml
	cp src/log4j2.xml bin/log4j2.xml

.PHONY:run_tests
.PHONY:run_main

run_tests: all bin/log4j2.xml
	${JAVA} -jar jars/junit-platform-console-standalone-1.8.2.jar \
                -cp ${CLASS_PATH} \
                -c Assignment1Test

#log4j-1.2-api-2.17.1.jar  log4j-api-2.17.1.jar 

run_main: all
	${JAVA} -cp ${CLASS_PATH} Main

clean:
	@rm -rf bin/
