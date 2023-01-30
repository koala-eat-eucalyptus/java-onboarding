package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int A = man(pobi);
        int B = man(crong);
        if (A == -1 || B == -1) return -1;
        answer = compare(A, B);
        return answer;
    }
    //solution과 calculate 사이에 중간 메서드를 만들고, 안에서 -1 또는 calculate()를 출력할 수 있도록 만들면 더 깔끔해지지 않을까?

    public static int man(List<Integer> a) {
        if (exception(a.get(0), a.get(1))) return -1;
        return calculate(a.get(0), a.get(1));
    }

    public static int calculate(int a, int b) {        //양쪽 페이지의 각 자리를 더하거나 곱해 사람 1명의 점수를 구한다.
        int Pa = page(a);
        int Pb = page(b);

        int rst = Math.max(Pa, Pb);                   //메서드를 새로 만들 때 max(plus, mul)를 반환해서 여기에서 큰 수끼리만 비교하는게 더 나은 것 같아

        return rst;

    }

    public static int page(Integer num) {        //여기는 위에 코드랑 아래 코드가 서로 중복되는데, 메서드 하나를 만들어서 더 깔끔하게 구할 수 있을 것 같아
        int plus = 0;
        int mul = 1;
        int num_copy = num;

        while (num_copy >= 1) {
            plus += num_copy % 10;
            mul *= num_copy % 10;
            num_copy /= 10;

        }
        return Math.max(plus, mul);

    }

    public static int compare(int left, int right) {   //왼쪽페이지쪽수가 큰지 오른쪽 페이지쪽수가 큰지 비교

        if (left > right) return 1;
        else if (left < right) return 2;
        else return 0;

    }

    public static boolean exception(int a, int b) {    //왼쪽과 오른쪽 페이지 쪽수의 차이가 1이 아닌 예외 상황을 걸러낸다.

        return b - a != 1;

    }

}