JAVAC=javac
JAVA=java


bin/Main.class:src/Main.java bin/Hand.class
	${JAVAC} -d bin \
                 -cp jars/gson-2.8.9.jar:bin \
                 ./src/Main.java
# java -cp ./:bin:jars/gson-2.8.9.jar Main

bin/Assignment1Test.class:src/Assignment1Test.java
	${JAVAC} -cp ./src/:jars/junit-platform-console-standalone-1.8.2.jar \
                 -d bin ./src/Assignment1Test.java

bin/Hand.class:src/Hand.java
	${JAVAC} -d bin ./src/Hand.java \
                 -cp jars/gson-2.8.9.jar

tests: bin/Assignment1Test.class bin/Hand.class
	${JAVA} -jar jars/junit-platform-console-standalone-1.8.2.jar \
                 -cp ./:bin/ \
                 -c Assignment1Test


#evaluate_hand: evaluate_hand.cpp poker.cpp poker.hpp
#	${CXX} ${CPPFLAGS} -o evaluate_hand evaluate_hand.cpp poker.cpp

clean:
	@rm -rf bin/
	mkdir bin
