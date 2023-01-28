package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> caled = cal(user, friends);

        HashMap finished = finish(user, caled, friends);

        HashMap realfinished = realfinal(finished,visitors,caled);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(realfinished.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                return comparison == 0? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });

        for (int i=0;i<list.size();i++)
        {
            if (i==5){
                break;
            }
            answer.add(list.get(i).getKey());
        }
        return answer;
    }

    public static List<String> cal(String name, List<List<String>> data){
        HashMap<String,Integer> codes = new HashMap<String, Integer>();
        List<String> doit = new ArrayList<>();
        for (int i = 0; i<data.size(); i++){
            String tmp = (data.get(i).get(0));
            String tmp2 = (data.get(i).get(1));
            if (tmp==name){
                doit.add(tmp2);
            }
            else if (tmp2==name){
                doit.add(tmp);
            }

        }
        return doit;
    }
    public static HashMap finish(String name, List<String> list ,List<List<String>> friends){
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i=0; i<friends.size();i++){
            String tmp = (friends.get(i).get(0));
            String tmp2= (friends.get(i).get(1));
            if (list.contains(tmp) &&tmp2 !=name ){
                if (hash.containsKey(tmp2)){
                    hash.put(tmp2, hash.get(tmp2)+10);

                }
                else hash.put(tmp2, 0);
            }
            else if (list.contains(tmp2) &&tmp !=name){
                if (hash.containsKey(tmp)) {
                    hash.put(tmp, hash.get(tmp) + 10);
                }
                else hash.put(tmp, 0);
            }

        }
        return hash;

    }
    public static HashMap realfinal(HashMap<String,Integer> gg, List<String> ls, List<String> net){
        HashMap<String,Integer> copyhash= gg;
        for(String s: ls){
            if (net.contains(s)){
                continue;
            }
            else{
                if (copyhash.containsKey(s)){
                    copyhash.put(s,copyhash.get(s)+1);
                }
                else{
                    copyhash.put(s,0);
                }
            }

        }
        return copyhash;
    }
}
