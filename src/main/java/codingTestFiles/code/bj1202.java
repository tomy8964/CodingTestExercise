package codingTestFiles.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj1202 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        jewel[] jewels = new jewel[N];
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] split1 = line.split(" ");
            jewels[i] = new jewel(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewels, (o1, o2) -> {
            // 무게가 같을 경우 값이 더 높은 것부터 정렬
            if (o1.weight - o2.weight == 0) {
                return o2.cost - o1.cost;
            }

            return o1.weight - o2.weight;
        });

        Queue<jewel> queue = new PriorityQueue<>((o1, o2) -> {
            if (o2.cost - o1.cost == 0) {
                return o1.weight - o2.weight;
            }
            return o2.cost - o1.cost;
        });

        long answer = 0;
        for (int k = 0, i = 0; k < K; k++) {
            while (i < N && jewels[i].weight <= bag[k]) {
                queue.add(jewels[i]);
                // 이제 다음 보석부터 보면 되므로
                i++;
            }
            if (!queue.isEmpty()) {
                answer += queue.poll().cost;
            }
        }

        System.out.println(answer);
        br.close();
    }

    public static class jewel {
        int weight;
        int cost;

        public jewel(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }
}

