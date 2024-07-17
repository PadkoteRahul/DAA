




















//simple approach of a longest palindrome in given string 
#include<bits/stdc++.h>
using namespace std;

void printsubstr(string str, int low, int high)
{
    for(int i=low; i <= high; i++)
    {
        cout<<str[i];
    }
}
int longestpalsubstr(string str)
{
    //get the length of the input string
    int n = str.size();

    //all substring of length 1 are palindrome
    int maxlen = 1, start = 0;

    //nested loop to mark start and end mark
    for(int i=0; i<n; i++)
    {
        for(int j=i; j<n; j++)
        {
            int flag = 1;

            //checking the palindrome
            for(int k = 0; k<(j-i+1); k++)
            {
                if(str[i+k] != str[j-k])
                {
                    flag = 0;
                }
            }

            //palindrome
            if(flag && (j-i+1) > maxlen)
            {
                start = i;
                maxlen = j-i+1;
            }
        }
    }
    cout<<"longest palindrome substring is: ";
    printsubstr(str, start, start+maxlen-1);
}
int main()
{
    string s = "forgeeksskeegfor";
    cout<<"\nlength id : "<<longestpalsubstr(s);
    return 0;
}