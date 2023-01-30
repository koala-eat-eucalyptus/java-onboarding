package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> list = new ArrayList<>(9);
        int ans = 0;
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int j : arr) {
            list.add(money / j);
            money = money % j;

        }
        System.out.println(ans);
        answer = list;

        return answer;
    }


}
