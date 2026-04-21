package StringDemo;

import java.util.Locale;

public class StringMethods {
    public static void main(String[] args) {
        String str = " java full stack ";
        String str1 = " java full stack ";
        String str2 = " JAVA FulL STACK ";
        System.out.println("length: " +str.length());
        System.out.println("charAt index 3: " +str.charAt(3));
        System.out.println("to uppercase: " +str.toUpperCase());
        System.out.println("to lowercase: " +str.toLowerCase());
        char[] course = str.toCharArray();
        System.out.print("str to char array named course: ");
        for (char c : course){
            System.out.print(c);
        }
        System.out.println();
        System.out.println("str Equals str1: " +str.equals(str1));
        System.out.println("str Equals str2: " +str.equals(str2));
        System.out.println("str EqualsIgnoreCase str2: " +str.equalsIgnoreCase(str2));
        System.out.println("str compareto str1: " +str.compareTo(str1));
        //compare alphabetwise both strings return 0 if alphabets are same of both strings
        // by checking one by one else return their alphabet ascii differences and A < a
        System.out.println("str compareto str2: " +str.compareTo(str2));
        System.out.println("str comparetoIgnoreCase str2: " +str.compareToIgnoreCase(str2));
        System.out.println("str contains 'full': " + str.contains("full"));
        //return true if str contains substring full
        System.out.println("str contains str1: " + str.contains(str1));
        // return true if str contains whole string str2 means both strings are same
        System.out.println("str contains str2: " + str.contains(str2));
        //return false due to str contains str2 but str2 have uppercase makes diff from str1
        System.out.println("str contains (str2 in lowecase): " + str.contains(str2.toLowerCase()));
        //return true due to str contains str2 because str2 is in lowercase also
        System.out.println("str starts with ' java': " +str.startsWith(" java"));
        System.out.println("str starts with ' j': " +str.startsWith(" j"));
        System.out.println("str2 start(' java' making in uprcase):"+str2.startsWith(" java".toUpperCase()));
        System.out.println("str ends with 'stack ': " +str.endsWith("stack "));
        System.out.println("str ends with 'k ': " +str.endsWith("k "));
        System.out.println("str2 end(' stack ' making in uprcase):"+str2.endsWith(" stack ".toUpperCase()));
        System.out.println("return indexof first of a  occurence from str: " +str.indexOf("a"));
        System.out.println("return last indexof a occurence from str: " +str.lastIndexOf("a"));
        System.out.println("return last indexof a occurence within 7 index means u from str: " +str.lastIndexOf("a",7));
        System.out.println("return substring from str from 6 index, means: "+str.substring(6));
        System.out.println("return substring from str from 6 to 10 (10 not included) index, means: "+str.substring(6 , 10));
        System.out.println("replace character 'f' with 'q' from str: "+str.replace('f','q'));
        System.out.println("replaceAll  substring 'full' with 'pqr' from str: "+str.replace("full","pqr"));
        System.out.println("trim leading(starting spaces) and trailing(ending spaces)from str: " +str.trim());
        String [] words = str.trim().split(" ");
        // now words have java,full,stack in words having having now three indexes
        System.out.println("str split from ' 'i.e.space in array having three words now in three indexes: 1.java 2.full 3.stack");
        for (String s : words){
            System.out.println(s);
        }
        String [] words1 = str.trim().split("v",str.length()-1);
        // now words have java,full,stack in words having having now three indexes
        System.out.println("str split from 'v' to end of str in array having two words: 1.ja (because v will not include after after splitting) 2. rest of str");
        for (String s : words1){
            System.out.println(s);
        }
        System.out.println("String.valueOf(any data type) converts any type to string");
        System.out.print("concat Rohit to str and store in str3: ");
        String str3 = str.concat("Rohit");
        System.out.println(str3);
        System.out.println(String.join("+","Rohit","Kumar","Ravi","Ranjan" ));
        System.out.println("content.Equals(String) compare contents between str and str1: "+str.contentEquals(str1));
        String ss1 = "";
        String ss2 = "   ";
        System.out.println("Is s1 is empty: "+ss1.isEmpty());   // true
        System.out.println("Is s2 is empty or having only blank spaces: "+ss2.isBlank());   // true
        System.out.println("Repeat str three times: "+ str.repeat(3));
        System.out.print("Use indent with int value to add no. of spaces in the beginning of string:"+str.indent(4));
        System.out.println("remove leading and trailing whitespaces from str: "+str.strip());
        System.out.println("remove leading whitespaces only from str: "+str.stripLeading());
        System.out.println("remove trailing whitespaces only from str: "+str.stripTrailing());
        System.out.println(str.matches("full"));  // true
        String s1 = "12345";
        System.out.println("Digits only: " + s1.matches("\\d+")); // true

        String s2 = "Java123";
        System.out.println("Alphanumeric 7 chars: " + s2.matches("[a-zA-Z0-9]{7}")); // true

        String email = "test@example.com";
        System.out.println("Valid email: " + email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")); // true

        String name = "Ravi";
        System.out.println("Starts with capital letter: " + name.matches("^[A-Z][a-z]+$")); // true

        /*
        Pattern	      Meaning
        .	          Any character
        \\d	          Any digit (0–9)
        \\w	          Any word character (a-z, A-Z, 0–9, _)
        +	          One or more
        *	          Zero or more
        $	          End of string
        ^	          Start of string        */


    }

}
