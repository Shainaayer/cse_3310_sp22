#include <iostream>

#include "poker.hpp"

hand::hand (std::string S)
{
   // the incoming string is JSON
   std::cout << "creating a hand from " << S << std::endl;
}

hand::~hand ()
{
}

bool hand::is_better_than (hand h)
{
   // this method will evaluate the hand, h, passed in, 
   // against this instance
   return false;
}


