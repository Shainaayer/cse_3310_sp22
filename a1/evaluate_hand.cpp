#include "poker.hpp"
#include "json.hpp"

#define BOOST_TEST_MODULE poker
#include <boost/test/included/unit_test.hpp>

using namespace nlohmann;

BOOST_AUTO_TEST_CASE( evaluate_hand )
{
   json h1;
   h1["cards"] = { 
                   { {"SUITE","HEARTS"}, {"CARD","KING"} },
                   { {"SUITE","CLUBS"}, {"CARD","KING"} },
                   { {"SUITE","DIAMONDS"}, {"CARD","KING"} },
                   { {"SUITE","SPADES"}, {"CARD","KING"} },
                   { {"SUITE","HEARTS"}, {"CARD","ONE"} }
                 };
   json h2;
   h2["cards"] = { 
                   { {"SUITE","HEARTS"}, {"CARD","FIVE"} },
                   { {"SUITE","CLUBS"}, {"CARD","FIVE"} },
                   { {"SUITE","DIAMONDS"}, {"CARD","FIVE"} },
                   { {"SUITE","SPADES"}, {"CARD","FIVE"} },
                   { {"SUITE","HEARTS"}, {"CARD","ONE"} }
                 };
   std::cout << h2.dump () << std::endl;

   // convert from a json object to whatever datastructure is
   // needed for the C++ class
   hand H1 = hand ( h1.dump () );
   hand H2 = hand ( h2.dump () );
   // examples of one way to test..
   //BOOST_CHECK( H1.is_better_than ( H2 ) );
   BOOST_CHECK( ! H2.is_better_than ( H1 ) );
}

