package codingTestFiles.code.programers.re.rere;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        // progresses	            speeds	            return
        // [93, 30, 55]	            [1, 30, 5]	        [2, 1]
        // [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
        // [95, 95, 95, 95]         [4, 3, 2, 1]        [2, 1, 1]
        // [1, 95, 95, 95]	        [99, 1, 1, 1]	    [1, 3]
        System.out.println(Arrays.toString(new 기능개발().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(new 기능개발().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(new 기능개발().solution(new int[]{95, 95, 95, 95}, new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new 기능개발().solution(new int[]{1, 95, 95, 95}, new int[]{99, 1, 1, 1})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.add(day);
        }

        while (!queue.isEmpty()) {
            int count = 1;
            Integer finishJob = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer job = queue.peek();
                if (job <= finishJob) {
                    queue.poll();
                    count++;
                } else break;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
