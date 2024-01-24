#include <unordered_map>
#include <vector>

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rowSize = board.size();
        int colSize = board[0].size();

        // Row Check
        for (int i = 0; i < rowSize; i++) {
            unordered_map<char, int> freqMap;
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] != '.' &&
                    freqMap.find(board[i][j]) != freqMap.end()) {
                    return false;
                }
                freqMap[board[i][j]]++;
            }
        }

        // Col Check
        for (int i = 0; i < colSize; i++) {
            unordered_map<char, int> freqMap;
            for (int j = 0; j < rowSize; j++) {
                if (board[j][i] != '.' &&
                    freqMap.find(board[j][i]) != freqMap.end()) {
                    return false;
                }
                freqMap[board[j][i]]++;
            }
        }

        // Box Check
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                unordered_map<char, int> freqMap;
                for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                    for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                        if (board[i][j] != '.' &&
                            freqMap.find(board[i][j]) != freqMap.end()) {
                            return false;
                        }
                        freqMap[board[i][j]]++;
                    }
                }
            }
        }

        return true;
    }
};
