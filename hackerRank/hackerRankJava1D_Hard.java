//Able to pass testcases #0,1,2,5,6

import java.util.Scanner;

public class Solution {
    
    static String checkWin(int[] arr, int n, int m){
        int currPos = 0;
        int lastPos = currPos;
        boolean backJump = false;
        while (true){
            if (currPos + m >= n || currPos + 1 >= n){
                return "YES";
            }
            if (currPos + m  < n && arr[currPos+m]==0 && m!=0){
                backJump = false;
                lastPos = currPos;
                currPos += m;
            } else if (currPos + 1 < n && arr[currPos+1] == 0 && backJump == false){
                currPos += 1;
                lastPos = currPos;
            } else if (currPos - 1 > 0 && currPos-1 > lastPos && arr[currPos-1] == 0){
                currPos--;
                backJump = true;
            } else {
                return "NO";
            }
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int j=0;j<n;j++){
                arr[j] = in.nextInt();
            }
            System.out.println(checkWin(arr, n, m));
        }
        in.close();
    }
}
