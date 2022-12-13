package algorithm.bfs;

import java.util.*;

public class BFSSearch {
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

        System.out.println(funcBFS(graph,"A"));
    }

    public static Queue<String> funcBFS(HashMap<String, ArrayList<String>> graph, String startNode){
//        ArrayList<String> visited = new ArrayList<>();
//        ArrayList<String> needVisited = new ArrayList<>();

        Queue<String> visited = new LinkedList<>();
        Queue<String> needVisited = new LinkedList<>();

        needVisited.add(startNode);

        while(!needVisited.isEmpty()){
            String node = needVisited.poll();
            if(!visited.contains(node)){
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
