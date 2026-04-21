package StringDemo;

public class StringBufferMethodsDemo {
    public static void main(String[] args) {
        StringBuffer strb = new StringBuffer("Hello");
        StringBuilder sbBuilder1 = new StringBuilder(strb.toString());  // ✅ Now it's a StringBuilder

        StringBuffer sb = new StringBuffer("Hello");
        String s = sb.toString(); // ✅ Correct
        System.out.println(s);    // Output: Hello

        // String s = sb; // ❌ Compilation error: incompatible types

        // 1. append(String s) - Adds a string or primitive at the end
        StringBuffer sb1 = new StringBuffer("Hello");
        sb1.append(" World");
        System.out.println("1. append(): " + sb1);  // Output: Hello World

        // 2. insert(int offset, String s) - Inserts at a specific index
        StringBuffer sb2 = new StringBuffer("Java");
        sb2.insert(2, "++");
        System.out.println("2. insert(): " + sb2);  // Output: Ja++va

        // 3. replace(int start, int end, String s) - Replaces characters from start to end-1
        StringBuffer sb3 = new StringBuffer("Hello Java");
        sb3.replace(6, 10, "World");
        System.out.println("3. replace(): " + sb3);  // Output: Hello World

        // 4. delete(int start, int end) - Deletes characters from start to end-1
        StringBuffer sb4 = new StringBuffer("Hello World");
        sb4.delete(5, 11);
        System.out.println("4. delete(): " + sb4);  // Output: Hello

        // 5. reverse() - Reverses the characters
        StringBuffer sb5 = new StringBuffer("ABC");
        sb5.reverse();
        System.out.println("5. reverse(): " + sb5);  // Output: CBA

        // 6. capacity() - Returns the current capacity of the buffer
        StringBuffer sb6 = new StringBuffer();
        System.out.println("6. capacity() (default): " + sb6.capacity());  // Output: 16 (default)

        // ensureCapacity(int min) - Ensures minimum capacity
        sb6.ensureCapacity(30);
        System.out.println("6. ensureCapacity(30): " + sb6.capacity());  // Output: >= 30

        // 7. length() - Returns number of characters in the buffer
        StringBuffer sb7 = new StringBuffer("Java");
        System.out.println("7. length(): " + sb7.length());  // Output: 4

        // charAt(int index) - Returns the character at a specific index
        System.out.println("7. charAt(2): " + sb7.charAt(2));  // Output: v

        // setCharAt(int index, char ch) - Sets a character at specific index
        sb7.setCharAt(2, 'x');
        System.out.println("7. setCharAt(2, 'x'): " + sb7);  // Output: Jaxa
        System.out.println(sb7.toString());
    }
}
