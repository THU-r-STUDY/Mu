
import java.util.*; 

public class B1931_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int lastFin = 0;
        int[] allocatedTasks = new int[N];
        int allocatedTasksIndex = 0;

        //초기화
        int[][] tasks = new int[N][2];
        for(int i=0; i<N; i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }

        //종료시각에 대해 오름차순으로 정리
        Arrays.sort(tasks, (a,b) -> Integer.compare(a[1], b[1]));

        //비교연산
        for(int i=0; i<tasks.length; i++){
            if(tasks[i][0] >= lastFin){
                lastFin = tasks[i][1];
                allocatedTasks[allocatedTasksIndex++] = i;
            }
        }
        
        // for(int i=0; i<allocatedTasksIndex; i++){
        //     System.out.println("("+tasks[allocatedTasks[i]][0]+", "+tasks[allocatedTasks[i]][1]+")");
        // }
        System.out.println(allocatedTasksIndex);
    }
}
