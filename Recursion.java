//Victoria Severin
//1539768
//Recursion.java
//program1
//Implementing recursive algorithms in Java

public class Recursion {
	public static void main(String[] args){
		int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7}; 
		int[] B = new int[A.length];
		int[] C = new int[A.length];
		int minIndex = minArrayIndex(A, 0, A.length-1); 
		int maxIndex = maxArrayIndex(A, 0, A.length-1);

		for(int x: A) System.out.print(x+" "); 
		System.out.println();

		System.out.println( "minIndex = " + minIndex ); 
		System.out.println( "maxIndex = " + maxIndex ); 
		
		reverseArray1(A, A.length, B);
		for(int x: B) System.out.print(x+" ");
		System.out.println();

		reverseArray2(A, A.length, C);
		for(int x: C) System.out.print(x+" "); 
		System.out.println();

		reverseArray3(A, 0, A.length-1);
		for(int x: A) System.out.print(x+" "); 
		System.out.println();
	}
	//print out the reversal of the leftmost n elements in X
	static void reverseArray1(int[] X, int n, int[] Y){

	//if n==0 do nothing
	if (n==0) {
		return; 
	}	
	if (n >0) {
		//reverseArray1 notes
		//System.out.print(A[n-1] + " "); //print nth element from left
		//reverseArray(A, n-1); // print leftmost n-1 elements, reversed

		Y[Y.length-n] = X[n-1];
		reverseArray1(X, n-1, Y); 
	}
	}

	//print out the reversal of the rightmost n elements in A
	static void reverseArray2(int [] X, int n, int [] Y){
		
		//if n==0 do nothing
		if (n==0) {
			return;
		}
		
		if (n>0) {
		
		//reverseArray2 in notes
		//reverseArray2(A, n-1); //print the rightmost n-1 elements, reversed
		//System.out.print(X[X.length-n] + " "); //print the nth element from right

		//dual procedure from reverseArray1
		Y[n-1] = X[X.length-n];
		reverseArray2(X, n-1, Y); 
		}
	}

	static void reverseArray3(int [] X, int i, int j){
		if (i>=j){
			return;
		}
		if (i<j) {
			//swap the indexes
			int swap=X[j];
			X[j]=X[i];
			X[i]=swap;

		// move to the next index
		//call reverseArray
		reverseArray3(X, i+1, j-1);
		}
	}
		
	static int maxArrayIndex(int[] X, int p, int r){
		int q;
		q=(p+r)/2;

		if (r-p<=0){
			return r;
		}
		//finding greatest index of left side of the array
		int leftSide = maxArrayIndex(X,p,q);

		//finding greatest index of right side of the array, do q+1
		int rightSide = maxArrayIndex(X,q+1,r); 
	

		//returning the greatest index
		if (X[leftSide] > X[rightSide]) {
			return leftSide;
		}
		else {
			return rightSide;
		}
	}
	
	static int minArrayIndex(int[] X, int p, int r){
		//dual procedure with the function above
		int q; 
		q = (p+r)/2;

		if (r-p<=0){
			return r;
		}

		//finding the smallest index on the left side of the array
		int leftSide = minArrayIndex(X, p, q);
		
		//finding the smallest indec on the right side of the array, do q+1
		int rightSide = minArrayIndex(X, q+1, r);

		//returning the smallest index
		if (X[leftSide] < X[rightSide]){
			return leftSide;
		}
		else {
			return rightSide;

		}
	}
}


















