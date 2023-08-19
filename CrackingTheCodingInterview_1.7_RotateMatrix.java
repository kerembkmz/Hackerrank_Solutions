import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.7

Rotate Matrix: Given an image represented by an NxN matrix,
 where each pixel in the image is 4 bytes, write a method to
 rotate the image by 90 degrees. Can you do this in place ?

Hints: #51, #100
_________________________________________________________

--Mind Dump--

* I have assumed that I have a 3x3 matrix given, and the matrix
is in the following structure,

1 1 1  90 deg rot.   3 2 1
2 2 2  ------------> 3 2 1
3 3 3 				 3 2 1

I have though of other examples as well, it seems like there is 
a general pattern.
N'th column -> 1'st row.
N-1'th column -> 2'nd row.
.
.
.
1'st column -> N'th row.

I will try implementing this in place(without using additional memory).

My solution works, however, it is not in place, I am returning a new
matrix. 

 * Will try using hint 100 for the in place solution.

 Hint 100: Rotating a spesific layer would just mean swapping the values 
 in four arrays. If you were asked to swap the values in two arrays, could
 you do this? Can you then extend it to four arrays?

*/

public class InterviewTemplate{

		



		public static int[][] rotate(int[][] matrix){
			int[][] returnMatrix = new int[matrix.length][matrix.length];
			for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    returnMatrix[j][matrix.length - 1 - i] = matrix[i][j];
                }   
            }
			return returnMatrix;
		}

		public static void rotateInPlace(int[][] matrix){
			int temp = 0;
			int temp2 = 0;
			for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
					temp = matrix[i][j];
					temp2 = matrix[j][matrix.length - 1 - i];
					matrix[i][j] = temp2;
					matrix[j][matrix.length - 1 -i] = temp;
				}
			}
			// only exception is the [0][0] and [n][n]'th elements.
			temp = matrix[0][0];
			temp2 = matrix[matrix.length - 1][matrix.length - 1];
			matrix[0][0] = temp2;
			matrix[matrix.length - 1][matrix.length - 1] = temp;
		}



		public static void main(String[] args) {
			int[][] matrix = {  {1,1,1},
			                    {2,2,2},
			                    {3,3,3}};
			for (int i=0; i<matrix.length ; i++){
			    for (int j=0; j<matrix.length; j++){
			        System.out.print(matrix[i][j] + " ");
			    }
			    System.out.print("\n");
			}
			//int[][] newMatrix = rotate(matrix);
			rotateInPlace(matrix);
			System.out.println("\n");
			for (int i=0; i<matrix.length ; i++){
			    for (int j=0; j<matrix.length; j++){
			        System.out.print(matrix[i][j] + " ");
			    }
			    System.out.print("\n");
			}
		}
		

		

	}