package algorithm.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//단지수 세기
public class BFSexample {
    public static void main(String[] args) {
        input();
        pro();
    }

    static Scanner scanner = new Scanner(System.in);
    static StringBuilder stringBuilder = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> group;

    //백준 문제라서 input 필요
    static void input(){
        N = scanner.nextInt();
        a = new String[N];
        for(int i=0; i<N; i++){
            a[i] = scanner.nextLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs(int x, int y){
        group_cnt++;
        visit[x][y] = true;

        //인접한 블럭이 4개라서 4번만 돈다.
        for(int k=0; k<4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            //nx, ny가 실제로 존재하는지 범위 체크
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            //이 위치에 집이 있는가
            if(a[nx].charAt(ny) == '0') continue;
            //이미 방문한 곳인가
            if(visit[nx][ny]) continue;;
            dfs(nx,ny);
        }
    }

    static void pro(){
        group = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && a[i].charAt(j) == '1'){
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
        stringBuilder.append(group.size()).append('\n');
        for(int cnt : group) stringBuilder.append(cnt).append('\n');
        System.out.println(stringBuilder);
    }
}
