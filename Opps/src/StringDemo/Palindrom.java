package StringDemo;

public class Palindrom {
    public static void main(String[] args) {
        String s = "madam";
        boolean isPalindrom = true;
        int j = s.length()-1;
        for (int i =0; i<s.length()/2; i++){
            if (s.charAt(i) != s.charAt(j)){
                isPalindrom = false;
                break;
            }
            else {

            }
            j--;

        }
        if (isPalindrom){
            System.out.println(s + " is palindrom?: " +isPalindrom);
        }
        else {
            System.out.println(s + " is palindrom?: " +isPalindrom);
        }
    }
}
