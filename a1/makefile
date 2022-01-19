CPPFLAGS=-std=c++11 -Wall -g

# note this creates no intermediate object files
evaluate_hand: evaluate_hand.cpp poker.cpp poker.hpp
	${CXX} ${CPPFLAGS} -o evaluate_hand evaluate_hand.cpp poker.cpp

clean:
	rm -f evaluate_hand
