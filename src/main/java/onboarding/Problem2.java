package onboarding;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = check(cryptogram, make(cryptogram));

//        IntStream stream = cryptogram.chars();
//        stream.forEach(System.out::println);

        return answer;
    }

    public static String make(String str) {       //arr.length는 str로도 할 수 있으니 조건문을 맨 위에 두고, 변수 선언이랑 초기화를 그 다음에 하면 예쁠 것 같아
        if (str.length() == 0) return str;        //바꾸고나니 else를 쓸필요없어짐.
        char[] arr = str.toCharArray();
        char std = arr[0];
        int point = 0;
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == std) {
                arr[i] = 'A';
                count += 1;
                if (i == arr.length - 1)
                    arr[point] = 'A';
            } else {

                if (count > 0) arr[point] = 'A';
                std = arr[i];
                point = i;
                count = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char spell : arr) {
            if (spell != 'A') {
                builder.append(spell);
            }
        }
        return builder.toString();
    }

    public static String check(String before, String after) {   //중복을 제거하는 make함수를 적용했을때 전후가 같다면 리턴해서 멈추게된다.
        if (Objects.equals(before, after)) return before;
        else return check(after, make(after));

    }

}
