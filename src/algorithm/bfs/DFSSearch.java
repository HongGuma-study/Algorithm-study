package algorithm.bfs;

import java.util.*;

public class DFSSearch {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A",new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B",new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C",new ArrayList<>(Arrays.asList("A","G","H","I")));
        graph.put("D",new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E",new ArrayList<>(List.of("D")));
        graph.put("F",new ArrayList<>(List.of("D")));
        graph.put("G",new ArrayList<>(List.of("C")));
        graph.put("H",new ArrayList<>(List.of("C")));
        graph.put("I",new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J",new ArrayList<>(List.of("I")));

        System.out.println(funcDFS(graph,"A"));
    }

    public static Queue<String> funcDFS(HashMap<String,ArrayList<String>> graph, String startNode){
        Queue<String> visited = new LinkedList<>(); //visited는 stack, queue, arrayList 아무거나 사용해도 상관 없다.
        Stack<String> needVisit = new Stack<>();

        needVisit.add(startNode);

        while(!needVisit.isEmpty()){
            String node = needVisit.pop();
            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }
}
