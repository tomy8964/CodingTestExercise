package codingTestFiles.test0322;

import java.util.*;

public class CuttingLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int arr[] = new int[n];

        long max = 0;

        for (int i = 0; i < n; i++) {
            arr[i]= in.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max++;

        //탐색 길이 최솟값
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long count = 0;

            //구해진 중간 길이로 잘라서 나오는 갯수 확인
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            /*
             *  [upper bound 형식]
             *
             *  mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if(count < m) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
