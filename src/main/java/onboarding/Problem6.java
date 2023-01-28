package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<forms.size(); i++){
            for(int j = 0; j<forms.size(); j++){
                if(i!=j) {
                    if (!evaluate(forms.get(i).get(1), forms.get(j).get(1))) {
                        answer.add(forms.get(i).get(0));
                        System.out.println(forms.get(i).get(0));
                        break;
                    }
                }

            }


        }
        Collections.sort(answer);
        //System.out.println(forms.size());//이차원리스트해보니까 리스트개수인 5나옴
        return answer;
    }

    public static boolean evaluate(String str, String str2){
        char [] arr = str.toCharArray();
        char [] arr2 = str2.toCharArray();
        for (int i =0; i<str.length()-1; i++){
            for (int j =0; j<str2.length()-1; j++){
                if (arr[i] == arr2[j] && arr[i+1] == arr2[j+1]){
                    return false;

                }
            }
        }
        return true;
    }

}
