#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
    if (s.length() != t.length()) {
        return false;
    }
    int letters[26] = {0};
    for(int i = 0; i < s.length(); i++) {
        letters[s[i] - 'a'] ++;
        letters[t[i] - 'a'] --;
    }

    for (auto count : letters)
    {
        if (count != 0)
        {
           return false;
        }
        
    }

    return true;
    }
};

int main(int argc, char const *argv[])
{
    string s = "anagram", t = "nagaram";
    Solution solution;
    bool ret = solution.isAnagram(s, t);
    cout<<ret<<endl;
    return 0;
}
