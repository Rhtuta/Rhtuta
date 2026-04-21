package Comparable;

public class NumberDemo implements Comparable<NumberDemo> {
    int value;

    public NumberDemo(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return
                "value=" + value ;
    }

    @Override
    public int compareTo(NumberDemo o) {
        return this.value - o.value;
    }
    /*
    What’s happening here?

            this.value → refers to the current object’s value (the one on the left side of comparison).

    o.value → refers to the other object’s value (the one you’re comparing with).

            ✅ Example with your list

    Suppose the list is:

            [value=5, value=2, value=9, value=6]


    When Collections.sort(al) runs, it compares objects pair by pair using compareTo.

    Case 1: Comparing 5 and 2
            this.value = 5
    o.value = 2
            return 5 - 2 = 3   // positive


            👉 Means: this (5) is greater than o (2).
    So order should be [2, 5].

    Case 2: Comparing 2 and 9
            this.value = 2
    o.value = 9
            return 2 - 9 = -7   // negative


            👉 Means: this (2) is smaller than o (9).
    So keep 2 before 9.

    Case 3: Comparing 9 and 6
            this.value = 9
    o.value = 6
            return 9 - 6 = 3   // positive


            👉 Means: this (9) is greater than o (6).
    So swap them → [6, 9].

            📌 General Rule for compareTo
    int result = this.value - o.value;


    result < 0 → this < o → this comes before o.

            result == 0 → this == o → both considered equal.

            result > 0 → this > o → this comes after o.

✅ Final sorted order

    Using the above comparisons repeatedly, sorting algorithm arranges your list as:

            [value=2, value=5, value=6, value=9]
*/
}

