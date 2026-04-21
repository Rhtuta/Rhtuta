package StringDemo;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "Ravi Ranjan";
        System.out.println("String 1 : "+s1 );
        String s2 = "jaRa viRann";
        System.out.println("String 2 : "+s2 );
        char ch;
        int i=0;
        int j=0;
        boolean isAnagram = true;
        for (char c : s1.toCharArray()){
            ch = c ;
            if (s2.contains(String.valueOf(c))){

            }
            else{
                isAnagram = false;
                break;
            }
            if(isAnagram) {

                for (char c1 : s1.toCharArray()) {
                    if (ch == c1) {
                        i++;
                    }
                }

                for (char c2 : s2.toCharArray()) {
                    if (ch == c2) {
                        j++;
                    }

                }

                if (i != j) {
                    isAnagram = false;
                    break;
                }
                i = 0;
                j = 0;
            }
        }
        if (isAnagram){
            System.out.println("Is string 1 and String is Anagram?: "+isAnagram);
        }
        else {
            System.out.println("Is string 1 and String is Anagram?: "+isAnagram);
        }



    }
}
