#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'dayOfProgrammer' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER year as parameter.
 */

string dayOfProgrammer(int year) {
    bool leapYear = false;
    map<int, int> leapYearCal;
    map<int, int> nonLeapYearCal;
    string day;
    string month;
    int lastAddedDayNum = 0;
    int totalDay = 0;
    int wantedDay = 256;
    int currentMonth = 0;
    string returnString;
    
    leapYearCal[1] = 31;  // Jan
    leapYearCal[2] = 29;  // Feb
    leapYearCal[3] = 31;  // Mar
    leapYearCal[4] = 30;  // Apr
    leapYearCal[5] = 31;  // May
    leapYearCal[6] = 30;  // June
    leapYearCal[7] = 31;  // July
    leapYearCal[8] = 31;  // Augst
    leapYearCal[9] = 30;  // Sep
    leapYearCal[10] = 31; // Oct
    leapYearCal[11] = 30; // Nov
    leapYearCal[12] = 31; // Dec

    nonLeapYearCal[1] = 31;  // Jan
    nonLeapYearCal[2] = 28;  // Feb
    nonLeapYearCal[3] = 31;  // Mar
    nonLeapYearCal[4] = 30;  // Apr
    nonLeapYearCal[5] = 31;  // May
    nonLeapYearCal[6] = 30;  // June
    nonLeapYearCal[7] = 31;  // July
    nonLeapYearCal[8] = 31;  // Augst
    nonLeapYearCal[9] = 30;  // Sep
    nonLeapYearCal[10] = 31; // Oct
    nonLeapYearCal[11] = 30; // Nov
    nonLeapYearCal[12] = 31; // Dec

    if (year == 1918) {
        // Special case for transition year 1918
        return "26.09.1918";
    } else if ((year > 1918) && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) {
        leapYear = true;
    } else if ((year < 1918) && (year % 4 == 0)) {
        leapYear = true;
    }
    if (leapYear == true){
        for (int i = 1; i <= 12; i++) {
        if ((wantedDay - totalDay) > leapYearCal[i]) {
            totalDay += leapYearCal[i];
            currentMonth = i;
        } else if ((wantedDay - totalDay) <= leapYearCal[i]) {
            lastAddedDayNum = wantedDay - totalDay;
            currentMonth = i;
            break;
        }
    }
    }
    else{
        for (int i = 1; i <= 12; i++) {
        if ((wantedDay - totalDay) > nonLeapYearCal[i]) {
            totalDay += nonLeapYearCal[i];
            currentMonth = i;
        } else if ((wantedDay - totalDay) <= nonLeapYearCal[i]) {
            lastAddedDayNum = wantedDay - totalDay;
            currentMonth = i;
            break;
        }
    }
    }

    

    

    if (lastAddedDayNum < 10) {
        day = "0" + std::to_string(lastAddedDayNum);
    } else {
        day = std::to_string(lastAddedDayNum);
    }
    if (currentMonth < 10) {
        month = "0" + std::to_string(currentMonth);
    } else {
        month = std::to_string(currentMonth);
    }
    returnString = day + "." + month + "." + std::to_string(year);

    return returnString;
    
    
    
    
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string year_temp;
    getline(cin, year_temp);

    int year = stoi(ltrim(rtrim(year_temp)));

    string result = dayOfProgrammer(year);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
