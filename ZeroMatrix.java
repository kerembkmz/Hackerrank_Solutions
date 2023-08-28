/*

Cracking the coding interview, Interview Questions 1.8

Zero Matrix: Write an algorithm such that if an element in an MxN 
matrix is 0, its entire row and column are set to 0.

Hints: #517, #74, #102
_________________________________________________________

--Mind Dump--

* when a 0 is found, inside the loop, first set all the column to zero, and record the row number. 
* my logic was working, but I needed to implement a effected matrix 
parallel to the original matrix, otherwise, everything becomes 0.



*/

public class ZeroMatrix{

		

	public static void setZeros(int[][] matrix){
    	int rowNum = matrix.length;
    	int colNum = matrix[0].length;
    	boolean[][] effected = new boolean[rowNum][colNum];

    	for (int i=0; i<effected.length; i++){
        	for (int j=0; j<effected[0].length; j++){
            	effected[i][j] = false;
        	}
    	}

    	for (int i=0; i<rowNum; i++){
        	for (int j=0; j<colNum; j++){
            	if (matrix[i][j] == 0 && !effected[i][j]){
	                // Set rows 0 first;
    	            for (int k=0; k<rowNum; k++){
        	            matrix[k][j] = 0;
            	        effected[k][j] = true;
	                }

                	// Set columns 0 second;
                	for (int k=0; k<colNum; k++){
                    	matrix[i][k] = 0;
                    	effected[i][k] = true;
                	}
            	}
        	}
    	}
	}
	public static void main(String[] args) {
    	int[][] matrix = {
        	{1, 2, 3, 4},
        	{5, 0, 7, 8},
        	{9, 10, 11, 12},
        	{13, 14, 15, 0}
    		};

    	System.out.println("Original Matrix: \n");
    
    	printMatrix(matrix);

    	setZeros(matrix);

    	System.out.println("\nMatrix after setZeros:");
    	printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
            	System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
    	}
	}




	}