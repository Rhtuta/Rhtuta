package StringDemo;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Rohit";
        for(int i = 0 ; i<s.length() ; i++){
            System.out.print(s.charAt(i));
        }
        System.out.println();
        for(int i = s.length()-1 ; i>=0 ; i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
        String reverseString = "";
        for(int i = s.length()-1 ; i>=0 ; i--){
            reverseString += s.charAt(i);
        }
        System.out.println(reverseString);
        System.out.println();
        String reverseString2 = "";

        for(int i = s.length()-1 ; i>=0 ; i--){

            reverseString2 = reverseString2.concat(String.valueOf(s.charAt(i)));
        }
        System.out.println(reverseString2);
    }
}
