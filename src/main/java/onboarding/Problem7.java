package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> already = cal(user, friends);        //user와 이미 친구인 사람들을 리스트로 뽑음.

        HashMap neighbor = finish(user, already, friends);

        HashMap result = visited(neighbor, visitors, already);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (i == 5) {
                break;
            }
            answer.add(list.get(i).getKey());
        }
        return answer;
    }

    public static List<String> cal(String name, List<List<String>> data) {
        HashMap<String, Integer> codes = new HashMap<String, Integer>();
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String tmp = getLeft(data, i);
            String tmp2 = getRight(data, i);
            if (Objects.equals(tmp, name)) {
                rst.add(tmp2);
            } else if (Objects.equals(tmp2, name)) {
                rst.add(tmp);
            }

        }
        return rst;
    }

    public static String getLeft(List<List<String>> data, Integer num) {  //[a,b]중 a구하기
        return data.get(num).get(0);
    }

    public static String getRight(List<List<String>> data, Integer num) {  //[a,b]중 b구하기
        return data.get(num).get(1);
    }

    public static HashMap finish(String name, List<String> already, List<List<String>> friends) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            String tmp = getLeft(friends, i);
            String tmp2 = getRight(friends, i);
            if (already.contains(tmp) && !Objects.equals(tmp2, name)) {
                putName(hash, tmp2);
            } else if (already.contains(tmp2) && !Objects.equals(tmp, name)) {
                putName(hash, tmp);
            }

        }
        return hash;

    }

    public static void putName(HashMap<String, Integer> info, String key) {
        if (info.containsKey(key)) {
            info.put(key, info.get(key) + 10);

        } else info.put(key, 0);

    }

    public static HashMap visited(HashMap<String, Integer> gg, List<String> ls, List<String> net) {
        for (String s : ls) {
            if (!net.contains(s)) {

                if (gg.containsKey(s)) {
                    gg.put(s, gg.get(s) + 1);
                } else {
                    gg.put(s, 0);
                }
            }
        }
        return gg;
    }
}
