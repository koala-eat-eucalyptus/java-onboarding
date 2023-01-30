package onboarding;

import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {   //왜냐하면 저 코드를 보면 아스키 코드인건 알 수 있지만, 97, 122 가 어떤 내용인지는 모르기 때문에 검색을 해서 시간 낭비가 생기기 때문
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) ('a' + ('z' - arr[i]));
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) ('A' + ('Z' - arr[i]));
            }
            answer.append(arr[i]);
        }

        return answer.toString();
    }

}
