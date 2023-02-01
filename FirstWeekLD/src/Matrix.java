
public class Matrix {
	
	public static void main(String[] args) {
		// 6.4 Somme de Matrice
		int [][] firstMatrix = new int [2][3];
		for (int i = 0 ; i<2;i++) {
			for (int j = 0; j<3; j++) {
				firstMatrix[0][0]= 1 ;
				firstMatrix[0][1]= 2 ;
				firstMatrix[0][2]= 0 ;
				firstMatrix[1][0]= 4 ;
				firstMatrix[1][1]= 3 ;
				firstMatrix[1][2]= -1;
			}
		}
		int [][] secondMatrix = new int [2][3];
		for (int i = 0 ; i<2;i++) {
			for (int j = 0; j<3; j++) {
				secondMatrix[0][0]= 5 ;
				secondMatrix[0][1]= 2 ;
				secondMatrix[0][2]= 3 ;
				secondMatrix[1][0]= 1 ;
				secondMatrix[1][1]= 3 ;
				secondMatrix[1][2]= 4 ;
			}
		}

		int [][] addMatrix = new int [2][3];
		for (int i = 0 ; i<2;i++) {
			for (int j = 0; j<3; j++) {
				addMatrix[i][j]= firstMatrix[i][j]+secondMatrix[i][j] ;
		System.out.print(addMatrix[i][j]);
		//System.out.println();
			}
		}
		
		// 6.5 Soustraction de Matrice
		
		int [][] subMatrix = new int [2][3];
		for (int i = 0 ; i<2;i++) {
			for (int j = 0; j<3; j++) {
				subMatrix[i][j]= firstMatrix[i][j]-secondMatrix[i][j];
				System.out.print(subMatrix[i][j]);
				System.out.println();
			}
			
		}
		
		//6.6 Multiplication de Matrice (Scalaire)
		
		int [][] scalMatrix = new int [2][3];
		for (int i = 0 ; i<2;i++) {
			for (int j = 0; j<3; j++) {
				scalMatrix[i][j]= firstMatrix[i][j]-secondMatrix[i][j];
				System.out.print(scalMatrix[i][j]);
				System.out.println();
			}
			
		}
}
	
}

