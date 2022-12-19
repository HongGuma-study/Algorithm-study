package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {
    public static void main(String[] args) {

    }

    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] dist;
    static String[] a;
    static int N; //가로
    static int M; //세로

    static void input(){

    }

    static void bfs(int x, int y){
        //dist 배열 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dist[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        //bfs 시작
        while(!Q.isEmpty()){
            x = Q.poll();
            y = Q.poll();
            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(a[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro(){
        bfs(0,0);

        //최소 이동 횟수 출력
        System.out.println(dist[N-1][M-1]);
    }
}
