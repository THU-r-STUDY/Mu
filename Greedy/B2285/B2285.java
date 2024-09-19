package Greedy.B2285;

import java.util.*;

public class B2285 {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

       int[][] data = new int[N][2];
       int total = 0, sum = 0, half;

       for(int i = 0; i<N; i++){
        data[i][0] = sc.nextInt();
        data[i][1] = sc.nextInt();
        total += data[i][1];
       }

       Arrays.sort(data, Comparator.comparingInt(o -> o[0]));
       half = (total+1)/2;

       for(int i = 0; i<N; i++){
        sum += data[i][1];
        if(sum >= half){
            System.out.println(data[i][0]);
            break;
        }
       }
    }
}
