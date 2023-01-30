package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int tmp = 1; tmp <= number; tmp++) {
            answer += evaluate(tmp);

        }

        return answer;
    }

    public static int evaluate(int number) {
        int ans = 0;
        int number_copy = number;
        while (number_copy >= 1) {
            if ((number_copy % 10) % 3 == 0 && (number_copy % 10) / 3 >= 1) {
                ans += 1;
            }
            number_copy /= 10;

        }
        return ans;
    }
}
