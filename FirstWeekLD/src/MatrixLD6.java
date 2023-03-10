public class MatrixLD6 {

	public static void main(String[] args) {
		// Initialization des matrices.
		int[][] firstMatrix = {{5,2,0},
				{0,1,1},
				{6,3,1}};
		int[][] secondMatrix = {{1,1,3},
				{2,5,6},
				{3,0,5}};
		int[][] thirdMatrix = {{8,7},
				{5,4},
				{2,1}};
		int[][] fourthMatrix = {{0,2},
				{1,2},
				{1,1}};

		addMatrix(firstMatrix,secondMatrix);
		System.out.println("--------------------");
		addMatrix(firstMatrix,thirdMatrix);
		System.out.println("--------------------");
		subMatrix(thirdMatrix,fourthMatrix);
		System.out.println("--------------------");
		mulScalMatrix(fourthMatrix,2);
	}// Fonction de test de la validité de l'opération
	public static boolean testMatrix(int[][] mat1, int[][] mat2) {
		if (mat1[0].length != mat2[0].length || mat1.length != mat2.length) {
			return false;
		} else {
			return true;
		}
	}
	// Fonction addition
	public static void addMatrix(int[][] mat1, int[][] mat2) {
		if (testMatrix(mat1,mat2)==false) {
			System.out.println("Pour les additionner, les matrices doivent avoir le même nombre de col/ligne.");
		} else {
			int[][] answer = new int[mat1.length][mat2[0].length];
			for (int row = 0; row<mat1.length; row++) {
				for (int column = 0; column <mat2[0].length; column++) {
					answer[row][column] = mat1[row][column] + mat2[row][column];
				}
			}
			printMatrix("Addition de matrice",mat1,"+");
			printMatrix("",mat2,"=");
			printMatrix("",answer,"");
		}
	}
	// Fonction soustraction
	public static void subMatrix(int[][] mat1, int[][] mat2) {
		if (testMatrix(mat1,mat2)==false) {
			System.out.println("Pour les soustraire, les matrices doivent avoir le même nombre de col/ligne.");
		} else {
			int[][] answer = new int[mat1.length][mat2[0].length];
			for (int row = 0; row<mat1.length; row++) {
				for (int column = 0; column <mat2[0].length; column++) {
					answer[row][column] = mat1[row][column] - mat2[row][column];
				}}
			printMatrix("Soustraction de matrice",mat1,"-");
			printMatrix("",mat2,"=");
			printMatrix("",answer,"");
		}
	}
	//Fonction scalaire
	public static void mulScalMatrix(int[][] mat1, int s) {
		int[][] answer = new int[mat1.length][mat1[0].length];
		for (int row = 0; row<mat1.length; row++) {
			for (int column = 0; column<mat1[0].length; column++)
				answer[row][column] = mat1[row][column]*s;
		}
		printMatrix("Multiplication de matrice \n"+ s + " *\n",mat1,"=");
		printMatrix("",answer,"");
	} 
	// Fonction de mise en page et d'impression de matrice	
	public static void printMatrix(String bef,int[][] mat, String aft) {
		System.out.println(bef);
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		System.out.println(aft);
	}
}
