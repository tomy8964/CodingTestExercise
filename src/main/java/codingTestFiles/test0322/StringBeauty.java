package codingTestFiles.test0322;

/**
 * 문제 설명
 *  어떤 문자열 x의 "아름다움"을 다음과 같이 정의합니다.
 *  만약 x의 모든 글자가 전부 같다면, 0입니다.
 *  그렇지 않다면, 서로 다른 글자가 위치해 있는 두 인덱스 i, j를 골랐을
 * 때의 j-i 값들 중 최대값입니다.
 *  예를 들어, 문자열 "abbca"의 아름다움은 3입니다.
 *  인덱스 1(b)과 4(a)를 고르거나, 또는 0(a)과 3(c)를 고를 때 최대값이기
 * 때문입니다.
 *  영어 소문자로 이루어진 문자열 s가 매개변수로 주어집니다. s의 모든
 * 부분문자열의 아름다움의 합을 return 하도록 solution 함수를 완성해
 * 주세요.
 *  제한 사항 : s의 길이는 1 이상 300,000 이하입니다.
 */
/**
 * guide (참고만 할 것)
 *  문자열을 입력받아, 서로 다른 문자 사이의 부분 문자열들의 개수
 * 를 구함
 *  알파벳 인덱스(0부터 25까지 총 26개)마다 ArrayList를 선언하여,
 * 해당 알파벳이 나타나는 위치들의 인덱스를 저장
 *  알파벳 인덱스의 블록 크기를 저장하기 위한 ArrayList를 선언
 *  알파벳 인덱스마다, 블록 크기별 블록 개수를 저장하기 위한
 * HashMap을 선언
 */

import java.util.*;

public class StringBeauty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(beautySum(s));
        sc.close();
    }

    public static int beautySum(String s) {
        int n = s.length();
        ArrayList<Integer>[] indices = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            indices[s.charAt(i) - 'a'].add(i);
        }
        ArrayList<Integer> blockSizes = new ArrayList<Integer>();
        HashMap<Integer, Integer> blockCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            if (indices[i].size() > 0) {
                blockSizes.add(indices[i].size());
                if (blockCount.containsKey(indices[i].size())) {
                    blockCount.put(indices[i].size(), blockCount.get(indices[i].size()) + 1);
                } else {
                    blockCount.put(indices[i].size(), 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < blockSizes.size(); i++) {
            int blockSize = blockSizes.get(i);
            int count = blockCount.get(blockSize);
            int maxDist = 0;
            for (int j = 1; j < blockSize; j++) {
                int dist = indices[i].get(j) - indices[i].get(j - 1);
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
            res += count * maxDist;
        }
        return res;
    }
}

