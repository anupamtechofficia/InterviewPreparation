package topologicalSort;

import java.util.*;

public class AlenDic {


    static List<Character> getAlenDic(List<String> list){
        List<Character> ans = new ArrayList<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Set<Character>> parent = new HashMap<>();
        int maxLength = 0;
        for (String word : list){
            maxLength = Math.max(maxLength, word.length());
        }
        for(int j = 1 ; j< list.size();j++){
            if(list.get(j-1).charAt(0) != list.get(j).charAt(0)){
                fillTop(list, map, j, 0, parent);
            }
        }

        for (int i = 1 ; i< maxLength ;i++){
            for (int j = 1;j< list.size();j++){
                if(list.get(j-1).length() > i && list.get(j).length() > i && list.get(j).substring(0, i).equals(
                        list.get(j-1).substring(0,i))){
                    fillTop(list, map, j, i, parent);
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        queue.add(list.get(0).charAt(0));
        while (!queue.isEmpty()){
            Character parentNode = queue.poll();
            ans.add(parentNode);
            for (Character child : map.getOrDefault(parentNode,
                    new HashSet<>())){
                parent.get(child).remove(parentNode);
                if(parent.get(child).isEmpty()){
                    queue.add(child);
                }
            }


        }
        return ans;
    }

    private static void fillTop(List<String> list, Map<Character, Set<Character>> map,
                                int j, int i, Map<Character, Set<Character>> parent) {
        if(list.get(j).charAt(i) != list.get(j-1).charAt(i)){
            if(map.get(list.get(j -1).charAt(i)) == null){
                map.put(list.get(j -1).charAt(i), new HashSet<>());
            }
            map.get(list.get(j -1).charAt(i)).add(list.get(j).charAt(i));
            if( parent.get(list.get(j).charAt(i)) == null){
                parent.put(list.get(j).charAt(i), new HashSet<>());
            }
            parent.get(list.get(j).charAt(i)).add(list.get(j -1).charAt(i));
        }

    }

    public static void main(String ... s){
        System.out.println(getAlenDic(List.of("ba", "bc", "ac", "cab")));
        System.out.println(getAlenDic(List.of("cab", "aaa", "aab")));
        System.out.println(getAlenDic(List.of("ywx", "wz", "xww", "xz", "zyy", "zwz")));

    }


}
