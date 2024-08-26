package topologicalSort;

import java.util.*;

public class TopologicalOrdering {


    static boolean findTopologicalOrderingTask(List<List<Integer>> edges, int v){
        Map<Integer, Integer> vertexToParentCount = new HashMap<>();
        Map<Integer, List<Integer>> vertexToChildMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> edge : edges){
            if (vertexToChildMap.get(edge.get(0)) == null) {
                vertexToChildMap.put(edge.get(0), new ArrayList<>());
            }
            vertexToChildMap.get(edge.get(0)).add(edge.get(1));
            vertexToParentCount.put(edge.get(1), vertexToParentCount.getOrDefault(edge.get(1),0)+1);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ;i< v;i++){
            if(vertexToParentCount.getOrDefault(i,0)==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer parent  = queue.poll();
            ans.add(parent);
            List<Integer> childs = vertexToChildMap.getOrDefault(parent, new ArrayList<>());
            for (Integer child : childs){
                vertexToParentCount.put(child, vertexToParentCount.get(child)-1);
                if(vertexToParentCount.get(child) ==0){
                    queue.add(child);
                }
            }
        }
        if(ans.size() != v){
            return false;
        }
        return true;


    }

    static List<Integer> findTopologicalOrderingTaskList(List<List<Integer>> edges, int v){
        Map<Integer, Integer> vertexToParentCount = new HashMap<>();
        Map<Integer, List<Integer>> vertexToChildMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> edge : edges){
            if (vertexToChildMap.get(edge.get(0)) == null) {
                vertexToChildMap.put(edge.get(0), new ArrayList<>());
            }
            vertexToChildMap.get(edge.get(0)).add(edge.get(1));
            vertexToParentCount.put(edge.get(1), vertexToParentCount.getOrDefault(edge.get(1),0)+1);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ;i< v;i++){
            if(vertexToParentCount.getOrDefault(i,0)==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer parent  = queue.poll();
            ans.add(parent);
            List<Integer> childs = vertexToChildMap.getOrDefault(parent, new ArrayList<>());
            for (Integer child : childs){
                vertexToParentCount.put(child, vertexToParentCount.get(child)-1);
                if(vertexToParentCount.get(child) ==0){
                    queue.add(child);
                }
            }
        }
        if(ans.size() != v){
            return new ArrayList<>();
        }
        return ans;


    }

    static List<List<Integer> > findTopologicalOrderingTaskListAll(List<List<Integer>> edges, int v){
        Map<Integer, Integer> vertexToParentCount = new HashMap<>();
        Map<Integer, List<Integer>> vertexToChildMap = new HashMap<>();
        Queue<List<Integer>> temp = new LinkedList<>();
        temp.add(new ArrayList<>());
        for (List<Integer> edge : edges){
            if (vertexToChildMap.get(edge.get(0)) == null) {
                vertexToChildMap.put(edge.get(0), new ArrayList<>());
            }
            vertexToChildMap.get(edge.get(0)).add(edge.get(1));
            vertexToParentCount.put(edge.get(1), vertexToParentCount.getOrDefault(edge.get(1),0)+1);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ;i< v;i++){
            if(vertexToParentCount.getOrDefault(i,0)==0){
                queue.add(i);
                List<Integer> a = new ArrayList<>();
                a.add(i);
            }
        }
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0 ; i< queueSize;i++) {
                int tempSize = temp.size();
                Integer parent = queue.poll();
                for(int j = 0;j< tempSize;j++){
                    List<Integer> li = temp.poll();
                    for(int k = li.size()-i;k<=li.size();k++){
                        List<Integer> latest = new ArrayList<>(li);
                        latest.add(k, parent);
                        temp.add(latest);

                    }
                }

                List<Integer> childs = vertexToChildMap.getOrDefault(parent, new ArrayList<>());
                for (Integer child : childs) {
                    vertexToParentCount.put(child, vertexToParentCount.get(child) - 1);
                    if (vertexToParentCount.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }


        }
        return temp.stream().toList();


    }

    static List<Integer> findTopologicalOrdering(List<List<Integer>> edges, int v){
        Map<Integer, Integer> vertexToParentCount = new HashMap<>();
        Map<Integer, List<Integer>> vertexToChildMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> edge : edges){
            if (vertexToChildMap.get(edge.get(0)) == null) {
                vertexToChildMap.put(edge.get(0), new ArrayList<>());
            }
            vertexToChildMap.get(edge.get(0)).add(edge.get(1));
            vertexToParentCount.put(edge.get(1), vertexToParentCount.getOrDefault(edge.get(1),0)+1);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ;i< v;i++){
            if(vertexToParentCount.getOrDefault(i,0)==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer parent  = queue.poll();
            ans.add(parent);
            List<Integer> childs = vertexToChildMap.getOrDefault(parent, new ArrayList<>());
            for (Integer child : childs){
                vertexToParentCount.put(child, vertexToParentCount.get(child)-1);
                if(vertexToParentCount.get(child) ==0){
                    queue.add(child);
                }
            }
        }
        if(ans.size() != v){
            return new ArrayList<>();
        }
        return ans;


    }



    static public void main(String ... args){

        System.out.println(findTopologicalOrdering(List.of(List.of(3,2), List.of(2,0), List.of(3,0), List.of(2,1)), 4));
        System.out.println(findTopologicalOrderingTask(List.of(List.of(0,1), List.of(1,2)), 3));
        System.out.println(findTopologicalOrderingTask(List.of(List.of(0,1), List.of(1,2), List.of(2,0)), 3));
        System.out.println(findTopologicalOrderingTaskList(List.of(List.of(0,1), List.of(1,2)), 3));
        System.out.println(findTopologicalOrderingTaskList(List.of(List.of(0,1), List.of(1,2), List.of(2,0)), 3));
        System.out.println(findTopologicalOrderingTaskListAll(List.of(List.of(2,5), List.of(0,5), List.of(0,4), List.of(1,4)
        ,List.of(3,2), List.of(1,3)), 6));
        System.out.println(findTopologicalOrderingTaskListAll(List.of(List.of(3,2), List.of(2,0), List.of(3,0),
                List.of(2,1)), 4));
        System.out.println(findTopologicalOrderingTaskListAll(List.of(List.of(2,5), List.of(0,5), List.of(0,4), List.of(1,4)
                ,List.of(3,2), List.of(1,3)), 6));

    }
}
