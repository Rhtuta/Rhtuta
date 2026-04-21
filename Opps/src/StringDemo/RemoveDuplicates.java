package StringDemo;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "Ravi ranjan Kumar";
        System.out.println(s);
        String s2 = "";
        String s3 = "";

        for (char c : s.toCharArray()){
            if (s2.indexOf(c) == -1){
                s2 += c;
            }
        }

        for (char c : s.toCharArray()) {
            if (s3.contains(String.valueOf(c))) {

            }
            else{
                s3 += c;
            }
        }


        System.out.println("Removed duplicates: ");
        System.out.println(s2);
        System.out.println("Removed duplicates: ");
        System.out.println(s3);
    }
}
