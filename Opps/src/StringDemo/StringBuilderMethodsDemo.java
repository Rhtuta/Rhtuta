package StringDemo;

public class StringBuilderMethodsDemo {
    public static void main(String[] args) {
        StringBuilder strb = new StringBuilder("Hello");
        StringBuffer sbBuilder1 = new StringBuffer(strb.toString());  // ✅ Now it's a StringBuffer


        StringBuilder sb = new StringBuilder("Hello");
        String s = sb.toString(); // ✅ Correct
        System.out.println(s);    // Output: Hello

       // String s = sb; // ❌ Compilation error: incompatible types

        // 1. append(String s) – Adds string or primitive at the end
        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.append(" World");
        System.out.println("1. append(): " + sb1);  // Output: Hello World

        // 2. insert(int offset, String s) – Inserts string at a specific index
        StringBuilder sb2 = new StringBuilder("Java");
        sb2.insert(2, "++");
        System.out.println("2. insert(): " + sb2);  // Output: Ja++va

        // 3. replace(int start, int end, String s) – Replaces characters from start to end-1
        StringBuilder sb3 = new StringBuilder("Hello Java");
        sb3.replace(6, 10, "World");
        System.out.println("3. replace(): " + sb3);  // Output: Hello World

        // 4. delete(int start, int end) – Deletes characters from start to end-1
        StringBuilder sb4 = new StringBuilder("Hello World");
        sb4.delete(5, 11);
        System.out.println("4. delete(): " + sb4);  // Output: Hello

        // 5. reverse() – Reverses the entire string
        StringBuilder sb5 = new StringBuilder("ABC");
        sb5.reverse();
        System.out.println("5. reverse(): " + sb5);  // Output: CBA

        // 6. capacity() – Returns current buffer capacity
        StringBuilder sb6 = new StringBuilder();
        System.out.println("6. capacity() (default): " + sb6.capacity());  // Default = 16

        // ensureCapacity(int min) – Increases capacity if needed
        sb6.ensureCapacity(40);
        System.out.println("6. ensureCapacity(40): " + sb6.capacity());  // At least 40

        // 7. length() – Returns current length of the string
        StringBuilder sb7 = new StringBuilder("Java");
        System.out.println("7. length(): " + sb7.length());  // Output: 4

        // 8. charAt(int index) – Returns character at a given index
        System.out.println("8. charAt(2): " + sb7.charAt(2));  // Output: v

        // 9. setCharAt(int index, char ch) – Modifies character at given index
        sb7.setCharAt(2, 'x');
        System.out.println("9. setCharAt(2, 'x'): " + sb7);  // Output: Jaxa

        // 10. toString() – Returns the final string representation
        String result = sb7.toString();
        System.out.println("10. toString(): " + result);  // Output: Jaxa
    }
}

