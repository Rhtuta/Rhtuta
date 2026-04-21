package StringDemo;

public class CountVowel {
    static String s = "Ravi Ranjan";
    static int  vowel = 0;
    static int constant = 0;

    public static void main(String[] args) {
        for (char c : s.toCharArray()){
            if ("aeiouAEIOU".indexOf(c)!= -1){
                vowel++;
            }
            else if (" ".indexOf(c)!= -1 ) {
                continue;
            } else{
                constant++;
            }
        }
        System.out.println("vowel: "+vowel);
        System.out.println("constant: "+constant);
    }
}
