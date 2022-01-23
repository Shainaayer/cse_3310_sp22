JAVAC=javac
JAVA=java
CLASS_PATH=bin:jars/gson-2.8.9.jar

bin/Main.class:src/Main.java bin/Hand.class
	@mkdir -p bin
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Main.java

bin/Assignment1Test.class:src/Assignment1Test.java ./bin/Hand.class
	@mkdir -p bin
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH}:jars/junit-platform-console-standalone-1.8.2.jar \
                 ./src/Assignment1Test.java

bin/Hand.class:src/Hand.java
	@mkdir -p bin
	${JAVAC} -d bin \
                 -cp ${CLASS_PATH} \
                 ./src/Hand.java

run_tests: bin/Assignment1Test.class bin/Hand.class
	${JAVA} -jar jars/junit-platform-console-standalone-1.8.2.jar \
                -cp bin  \
                -c Assignment1Test


run_main: bin/Main.class
	${JAVA} -cp ${CLASS_PATH} Main

clean:
	@rm -rf bin/
