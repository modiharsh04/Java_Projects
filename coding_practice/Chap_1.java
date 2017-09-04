import java.util.*;
import java.io.*;

class Chap_1{

	final int CHARSIZE = 26;
	final int ASCIISIZE = 128;

	boolean isUnique(String s){
		//if only small alphabets
		//if cannot use array too then can divide ASCIISIZE into 4 int and check using same algorithm.
		/*
			int checker = 0;
			for (char c : s.toCharArray()){
				int val = (1<<(c-'a'));
				if (checher && val == 1) return false;
				checker |= val;
			}
		*/
		if (s.length() > ASCIISIZE) return false;
		int len = s.length();
		boolean[] checker = new boolean[ASCIISIZE];
		for (char c : s.toCharArray()){
			if (checker[c]) return false;
			checker[c] = true;
		}
		return true;
	}

	boolean isPermutation(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		int[] checker = new int[ASCIISIZE];
		for (char c: s1.toCharArray())
			checker[c]++;
		for (char c: s2.toCharArray())
			if ((--checker[c]) < 0)
				return false;
		return true;
		// StraightForward answer but not for interviews
		// return (sorted(s1).equals(sorted(s2)));
	}

	String urliFy(String s, int strLen){
		int len = s.length();
		if (len < 2) return s;
		char[] str = s.toCharArray();
		int spaceCount = 0;
		for (int i=0;i<strLen;i++)
			if (str[i] == ' ') spaceCount++;
		int finalLen = (strLen-1) + 2*spaceCount;
		for (int i=strLen-1;i>=0;i--){
			if (str[i] == ' ') {
				str[finalLen--] = '0';
				str[finalLen--] = '2';
				str[finalLen--] = '%';
			} else {
				str[finalLen--] = str[i];
			}
		}
		return (new String(str));
	}

	boolean pallindromPerm(String s){
		int checker = 0;
		for (char c : s.toCharArray()){
			if (isLowerAlpha(c)){
				int mask = 1<<(c-'a');
				if ((checker & mask) == 0)
					checker |= mask;
				else
					checker &= ~mask;
			}
		}
		return ((checker & (checker-1)) == 0);
	}

	boolean isLowerAlpha(char c){
		return (c>='a' && c<='z');
	}

	boolean isOneAway(String s1, String s2){
		if (Math.abs(s1.length()-s2.length()) >1) return false;
		return (s1.length()>s2.length())?chckEditAway(s1,s2):chckEditAway(s2,s1);
	}

	private boolean chckEditAway(String s1, String s2){
		boolean edited = false;
		for (int i=0,j=0;i<s1.length() && j<s2.length(); i++,j++){
			if (s1.charAt(i) != s2.charAt(j)){
				if (edited) return false;
				else if (s1.length() != s2.length()) j--;
				edited = true;
			}
		}
		return true;
	}

	String compressStr(String s){
		if (s.length() < 3) return s;
		int[] map = new int[CHARSIZE];
		for (char c : s.toCharArray())
			map[c-'a']++;
		StringBuilder cs = new StringBuilder();
		for (char c : s.toCharArray()){
			int t = c-'a';
			if (map[t] > 0){
				cs.append(c);
				cs.append(map[t]);
				map[t] = 0;
			}
		}
		return (s.length()>cs.length())?cs.toString():s;
	}

	void zeroMatrix(int[][] matrix){
		boolean[] zeroTh = new boolean[2];
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i=0;i<m;i++) if (matrix[i][0] == 0)
		{ zeroTh[0] = true;break;}
		for (int i=0;i<n;i++) if (matrix[0][i] == 0)
			{zeroTh[1] = true;break;}
		for (int i=1;i<m;i++)
			for (int j=1;j<n ;j++ )
				if (matrix[i][j] == 0)
					{matrix[i][0] = 0;matrix[0][j] = 0;}
		for (int i=0;i<m;i++)
			if (matrix[i][0]) zeroWork(matrix,i,true);
		for (int i=0;i<m;i++)
			if (matrix[0][i]) zeroWork(matrix,i,false);
		if (zeroTh[0]) zeroWork(matrix,0,true);
		if (zeroTh[1]) zeroWork(matrix,0);
	}

	private void zeroWork(int[][] M, int index, boolean row){
		if (row){
			for (int i=1;i<n;i++)
				M[index][i] = 0;
		} else {
			for (int i=1;i<n;i++)
				M[i][index] = 0;
		}
	}

	boolean isRotation(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		s1 += s1;
		return s1.contains(s2);
	}

}