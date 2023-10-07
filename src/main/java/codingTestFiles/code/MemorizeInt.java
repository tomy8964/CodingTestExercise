package codingTestFiles.code;

import java.util.*;

public class MemorizeInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n = in.nextInt();

        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            map1.put(i, in.nextInt());
        }

        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            map2.put(i, in.nextInt());
        }

        ArrayList<Integer> arr = new ArrayList<>();
        Integer[] arr2 = new Integer[n];

        for (Integer v: map2.values()) {
            if (map1.containsValue(v)) {
                arr.add(1);
            }
            else {
                arr.add(0);
            }
        }

        arr2 = arr.toArray(new Integer[0]);

        for (int i = 0; i < arr2.length; i++){
            if(i==arr2.length-1){
                System.out.print(arr2[i]);
            }
            else {
                System.out.println(arr2[i]);
            }
        }
    }
}
