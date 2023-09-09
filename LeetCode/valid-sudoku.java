class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //Row Check
        for (int i=0; i<board.length; i++){
            Map<Character, Integer> numberFrequency = new HashMap<>();
            for (int j=0; j<board[i].length; j++){
                if (Character.isDigit(board[i][j])){
                    numberFrequency.put(board[i][j], numberFrequency.getOrDefault(board[i][j],0) + 1);
                }
            }
            for (int k : numberFrequency.values()){
                if (k>1){
                    System.out.print("Stuck in row check");
                    return false;
                }
            }
        }

        //Column Check
        for (int j=0; j<board[0].length; j++){
            Map<Character, Integer> numberFrequency = new HashMap<>();
            for (int i=0; i<board.length; i++){
                if (Character.isDigit(board[i][j])){
                    numberFrequency.put(board[i][j], numberFrequency.getOrDefault(board[i][j],0) + 1);
                }
            }
            for (int k : numberFrequency.values()){
                if (k>1){
                    System.out.print("Stuck in row check");
                    return false;
                }
            }
        }

        // Sub-Box Check
        for (int area = 0; area < 9; area++) {
            Map<Character, Integer> numberFrequency = new HashMap<>();
            
            int rowStart = (area / 3) * 3;
            int colStart = (area % 3) * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Character.isDigit(board[rowStart + i][colStart + j])) {
                        numberFrequency.put(board[rowStart + i][colStart + j], numberFrequency.getOrDefault(board[rowStart + i][colStart + j], 0) + 1);
                    }
                }
            }

            for (int k : numberFrequency.values()) {
                if (k > 1) {
                    System.out.print("Stuck in grid check");
                    return false;
                }
            }
        }
        return true;
    }
}