import java.util.*;
import java.io.*;

class Solution {
	String replace(String s){

		if (s.length() < 2) return s;
		if (s.length() == 2)
			if (s.charAt(0) == 'A' && s.charAt(1) == 'B') return "c";
		int i=1;
		while (i<s.length()){
			if (s.charAt(i) == 'A')
				if (s.charAt(i+1) == 'B')
					s = s.substring(0,i).concat("C").concat(s.substring(i+2));
			i++;
		}
		return s;
	}

	int isValidPwd(String s){
		BitSet valid = new BitSet(1);
		int maxLen = 0;
		int sum = 0;
		for (char c: s.toCharArray()){
			if (!isAlpha(c)) {
				if (valid.get(0))
					maxLen = max(maxLen, sum);
				sum = 0;
				valid.clear();
			}
			else {
				if (isUpper(c))
					valid.set(0);
				sum+=1;
			}
		}
		if (valid.get(0))
			maxLen = max(maxLen, sum);
		return maxLen;
	}

	int getTotalCountries(int[][] matrix){
		Set<Integer> set = new HashSet<>(matrix.length);
		for (int i=0;i<matrix.length;i++){
			for (int j=0;j<matrix[i].length;j++){
				int val = matrix[i][j];
				if ( val != -1){
					set.add(val);
					colorMap(matrix,i,j,val);
				}
			}
		}
		return set.size();
	}

	void colorMap(int[][] matrix,int i,int j,int val){
		if (i<0 || j<0 || i>= matrix.length || j>= matrix[0].length) return;
		if (matrix[i][j] != val) return;
		matrix[i][j] = -1;
		colorMap(matrix,i+1,j,val);
		colorMap(matrix,i,j+1,val);
		colorMap(matrix,i,j-1,val);
		colorMap(matrix,i-1,j,val);
	}

	boolean isAlpha(char c){
		return ((c >= 'a' && c <='z') || (c >= 'A' && c <= 'Z'));
	}

	boolean isUpper(char c){
		return (c >= 'A' && c <= 'Z');
	}

	static int max (int a, int b){
		return (a>b)?a:b;
	}
}