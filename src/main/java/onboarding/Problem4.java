package onboarding;

import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
        for (int i = 0; i<word.length() ; i++){
            if(arr[i] >=97 && arr[i]<=122){
                arr[i]= (char)(97+(122-arr[i]));
            }
            else if (arr[i] >= 65 && arr[i]<=90){
                arr[i]= (char)(65+(90-arr[i]));
            }
            answer+= arr[i];
        }
//        IntStream stream = word.chars();
//        stream.forEach(i->{
//            if (i>=97){
//                i-=25;
//
//            }
//            else if (i>=65){
//
//            }
//            else{
//
//            }
//        });

        return answer;
    }

}
