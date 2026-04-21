package StringDemo;

public class CapitalizeFirstLetter {
    public static void main(String[] args) {
        String s = " java full stack ";
        System.out.println(s);
        String s2="";

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0) && (" ".indexOf(s.charAt(i)) == -1)) {
                s2 += String.valueOf(s.charAt(i)).toUpperCase();
            }
            else if (" ".indexOf(s.charAt(i)) != -1) {
                s2 += s.charAt(i);
                if (i != s.length()-1){
                    s2 += String.valueOf(s.charAt(i+1)).toUpperCase();
                    i++;
                }


            }
            else {
                s2 += s.charAt(i);
            }


        }

        System.out.println(s2);
    }
}
