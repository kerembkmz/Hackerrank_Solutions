#include <bits/stdc++.h>
#include <string>
using namespace std;

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string timeConversion(string s) {
    string nonMilitary = s.substr(8,2);
    string hourTime = s.substr(0,2);
    int timeToConvert = stoi(hourTime);
    string convertedTime;
    string finalString;
    if (nonMilitary == "PM"){
        if (timeToConvert == 12){
            finalString = "12" + s.substr(2,6);
        }
        else {
            timeToConvert += 12;
            convertedTime = to_string(timeToConvert);
            finalString = convertedTime + s.substr(2,6);
        }
    }
    else if(nonMilitary == "AM"){
        if (timeToConvert == 12){
            finalString = "00" + s.substr(2,6);
        }
        else {
            finalString = s.substr(0,8);
        }
    }
    return finalString;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = timeConversion(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
