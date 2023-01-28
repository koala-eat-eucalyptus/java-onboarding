package onboarding;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = check(cryptogram,make(cryptogram));

//        IntStream stream = cryptogram.chars();
//        stream.forEach(System.out::println);

        return answer;
    }

    public static String make(String str){
        char[] arr = str.toCharArray();
        char std = ' ';
        if (arr.length>0) std = arr[0];
        else return str;
        int point = 0;
        //char[] arr_2 = arr.clone();
        int count = 0;
        //System.out.println(arr);

        for (int i = 1; i<arr.length; i++){
            if (arr[i] == std){
                arr[i]='A';
                count+=1;
                if (i==arr.length-1)
                    arr[point]='A';
            }
            else{

                if (count>0) arr[point]='A';
                std = arr[i];
                point = i;
                count=0;
            }

        }

        StringBuilder builder = new StringBuilder();
        for (char spell : arr){
            if (spell!='A'){
                builder.append(spell);
            }
        }
        String rst = builder.toString();
        return rst;
    }

    public static String check(String before, String after){
        if (Objects.equals(before, after)) return before;
        else return check(after, make(after));

    }

}
