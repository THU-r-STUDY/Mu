package Greedy.B11000;
import java.util.*;

public class B11000 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        //lectures: 강의들의 시작시각과 종료시각 저장
        List<int[]> lectures = new ArrayList<>();

        for(int i=0; i<N; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            lectures.add(new int[] {s, t});
        }

        // 시작시각 기준으로 오름차순 정렬
        Collections.sort(lectures, (a,b) -> a[0]-b[0]);

        //endTimes: 사용되는 강의실 별 종료시각 저장
        List<Integer> endTimes = new ArrayList<>();


        for(int i=0; i<lectures.size(); i++){
            int s = lectures.get(i)[0];
            int e = lectures.get(i)[1];

            boolean assigned = false;//새로운 강의실의 필요 여부를 판단

            //현재 강의의 시작 시각이 endTimes의 종료시각보다 나중이면
            for(int j = 0; j<endTimes.size(); j++){
                if(endTimes.get(j) <= s){ 
                    endTimes.set(j, e);//해당 강의실 종료 시각 갱신
                    assigned = true;// 배정 완료로 바꿈
                    break;
                }
            }
            //기존 강의실에 배정할 수 없으면 새로운 강의실 생성
            if(!assigned){
                endTimes.add(e);
            }
        }

        System.out.println(endTimes.size());

    }
}
