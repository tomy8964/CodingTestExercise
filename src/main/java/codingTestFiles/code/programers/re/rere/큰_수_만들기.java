package codingTestFiles.code.programers.re.rere;

public class 큰_수_만들기 {

    public static void main(String[] args) {
        // number	k	return
        //"1924"	2	"94"
        //"1231234"	3	"3234"
        //"4177252841"	4	"775841"
        System.out.println(new 큰_수_만들기().solution("1924", 2));
        System.out.println(new 큰_수_만들기().solution("1231234", 3));
        System.out.println(new 큰_수_만들기().solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for (int j = index; j <= i + k; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
