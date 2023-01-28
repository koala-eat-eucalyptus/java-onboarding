package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (exception(pobi.get(0), pobi.get(1)) || exception(crong.get(0), crong.get(1))) answer = -1;
        else{
            answer = compare(calculate(pobi.get(0),pobi.get(1)),calculate(crong.get(0),crong.get(1)));


        }
        System.out.println(pobi.get(0));
        System.out.println(calculate(pobi.get(0), pobi.get(1)));
        return answer;
    }

    public static int calculate(int a, int b){
        int plus = 0;
        int mul = 1;
        int a_copy=a;

        while (a_copy>=1){
            plus+=a_copy%10;
            mul*=a_copy%10;
            a_copy/=10;

        }

        int plus2 = 0;
        int mul2 = 1;
        int b_copy=b;

        while (b_copy>=1){
            plus2+=b_copy%10;
            mul2*=b_copy%10;
            b_copy/=10;
        }

        int rst = Math.max(plus,mul);
        rst = Math.max(rst,plus2);
        rst = Math.max(rst,mul2);


        return rst;

    }

    public static int compare(int left, int right){

        if (left>right) return 1;
        else if (left<right) return 2;
        else return 0;

    }

    public static boolean exception (int a, int b){

        return b - a != 1;

    }

}