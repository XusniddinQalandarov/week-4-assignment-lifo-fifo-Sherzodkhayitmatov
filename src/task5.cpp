#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

void displayColors(const string& matrix) {
    unordered_map<char, string> colorMap = {{'b', "blue"}, {'y', "yellow"}, {'w', "white"}};
    vector<vector<char>> symbols;
    stringstream ss(matrix);

    string line;
    while (getline(ss, line)) {
        vector<char> row;
        stringstream rowSs(line);
        char symbol;
        while (rowSs >> symbol) {
            row.push_back(symbol);
        }
        symbols.push_back(row);
    }

    for (const auto& row : symbols) {
        for (const auto& symbol : row) {
            cout << colorMap[symbol] << " ";
        }
        cout << endl;
    }
}

int main() {
    string matrix = "b b w b b y w w w\n"
                    "b b w w b y y b b\n"
                    "y y y w w b b b b\n"
                    "y e y e y w w b b\n"
                    "w b b w w b w w w\n"
                    "B b w w w w w y w";

    displayColors(matrix);

    return 0;
}