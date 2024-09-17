//B1931. Task Scheduling
import java.util.*;

public class B1931{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //작업 갯수

        int [][] tasks= new int[N][2]; //입력받은 모든 작업들
        boolean[] taskAllocated = new boolean[N]; //할당 완료 여부
        
        int count = 0, lastFinTime = 0;
        int currentIndex = 0;

        //초기화
        for(int i=0; i<N; i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
            taskAllocated[i] = false;
        }
        while(!isAllTasksAllocated(taskAllocated)){
            int minFin = Integer.MAX_VALUE;
            int minStart = Integer.MAX_VALUE;

            //종료 시간이 제일 빠른 작업 탐색, 종료 시간 값을 리턴 받음
            for(int i=0; i<N; i++){
                if(!taskAllocated[i] && minFin > tasks[i][1]) {
                    minFin = tasks[i][1];
                } 
            }

            //해당 종료 시간 값을 가진 여러 개의 인덱스 중 다음 조건에 맞는 하나를 선정
            //lastFinTime보다는 늦은 시작 시각을 가지면서, 제일 빠르게 시작할 것.
            for(int i = 0; i<N; i++){
                if(!taskAllocated[i] && tasks[i][1] == minFin && tasks[i][0] > lastFinTime){
                    if(tasks[i][0] < minStart) {
                        minStart = tasks[i][0];
                        currentIndex = i;
                    }
                }
            }

            count++;
            lastFinTime = minFin;

            //할당처리
            taskAllocated[currentIndex] = true;
            for(int i = 0; i<N; i++){
                if(!taskAllocated[i] && tasks[i][0] < lastFinTime) taskAllocated[i] = true;
            }
 
        }
        System.out.println(count);
    }
    
    private static boolean isAllTasksAllocated(boolean[] taskAllocated){
        for(int i=0; i<taskAllocated.length; i++){
            if(!taskAllocated[i]) return false;
        }
        return true;
    }
}