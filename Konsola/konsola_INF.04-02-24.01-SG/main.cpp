#include <iostream>
#include <string>
/**
************************************************
 klasa: StringUtils
 opis: Klasa StingUtils reprezentuje dwie metody ZliczanieSamoglosek oraz UsuwanieDuplikatow
 metody: ZliczanieSamoglosek(const string& input) metoda zwraca liczbê samog³osek w podanym ci¹gu znaków,
    UsuwanieDuplikatow(const string& input) metoda usuwa duplikaty znaków
 autor: 00000000000000
************************************************
 */

using namespace std;

    class StringUtils{
        public:
            static int ZliczanieSamoglosek(const string& input){
                if (input.empty()) return 0;

                const string samogloski = "a¹eêiouóyA¥EÊIOUÓY";
                int count = 0;

                for (char ch: input){
                    if(samogloski.find(ch) != string::npos){
                        ++count;
                    }
                }

            cout << "Liczba samoglosek: " << count << endl;
            return count;
        }

            static string UsuwanieDuplikatow(const string& input){
                if (input.empty()) return "";

                string result;
                char lastChar = '\0';

                for (char ch: input){
                    if (ch != lastChar){
                        result += ch;
                        lastChar = ch;
                    }
                }

            return result;
            }
    };

int main()
{
        string userInput;

        cout << "Wprowadz lancuch znakow: ";
        getline(cin, userInput);


        int samogloskiCount = StringUtils::ZliczanieSamoglosek(userInput);

        string bezDuplikatow = StringUtils::UsuwanieDuplikatow(userInput);
        cout << "Lancuch po usunieciu powtorzen: " << bezDuplikatow << endl;

        return 0;
}
