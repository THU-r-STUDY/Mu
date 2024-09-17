package Greedy.B12904;

import java.util.*;

public class B12904 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        int end;

        while(S.length() != T.length()){
            end = T.charAt(T.length() - 1); //문자열 T의 마지막 글자. A또는 B
            T = T.substring(0, T.length() - 1);
            if(end =='B'){
                T = new StringBuilder(T).reverse().toString();
            }
        }

        if(S.equals(T)){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}
