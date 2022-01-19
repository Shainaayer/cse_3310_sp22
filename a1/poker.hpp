#include <string>

class hand
{
 public:
   hand (std::string);
   ~hand ();
   bool is_better_than (hand h);
};
