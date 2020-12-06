
package personajes;

public class ClasePorBorrar {
    
    public static int[][] multiplicación (int [][] A, int [][] B){
   // columnas de la matriz A
   int n= A[0].length;
   // filas de la matriz A
   int m= A.length;
   // filas de la matriz B
   int n2= B.length;
   // columnas de la matriz B
   int o= B[0].length;
   // nueva matriz 
   int [][] C= new int [m][o];
   // se comprueba si las matrices se pueden multiplicar
   if (n==n2){
     for (int i=0; i<n-1;i++){
         int a=0;
        for (int j=0; j<n2-1;j++){
         //aqui se multiplica la matriz
         a= a+(A[i][j]*B[j][i]);
        }

        }
    }
   /**
    *  si no se cumple la condición se retorna una matriz vacía
    */
   return C;
}
}
