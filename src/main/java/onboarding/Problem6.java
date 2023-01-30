package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.size(); j++) {
                if (i != j) {
                    if (!evaluate(checknickname(forms, i), checknickname(forms, j))) {
                        answer.add(findemail(forms, i));
                        break;
                    }
                }

            }

        }
        Collections.sort(answer);        //리스트 answer를 정렬한다.
        //System.out.println(forms.size());//이차원리스트해보니까 리스트개수인 5나옴
        return answer;
    }

    public static String findemail(List<List<String>> forms, Integer num) {   //이 부분은 forms.get(i).get(0), forms.get(i).get(1)을 따로 따로 구하는 메서드를 만들어서 사용하면 더 읽기 쉬워질 것 같아
        return forms.get(num).get(0);

    }

    public static String checknickname(List<List<String>> forms, Integer num) {
        return forms.get(num).get(1);
    }

    public static boolean evaluate(String str, String str2) {
        char[] arr = str.toCharArray();
        char[] arr2 = str2.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = 0; j < str2.length() - 1; j++) {
                if (arr[i] == arr2[j] && arr[i + 1] == arr2[j + 1]) {
                    return false;

                }
            }
        }
        return true;
    }

}
