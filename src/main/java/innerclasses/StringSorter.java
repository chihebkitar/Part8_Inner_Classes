package innerclasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {
    private List<String> strings;  // Private variable to store a list of strings.

    public List<String> getStrings() {
        return strings;  // Getter method that returns the list of strings.
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;  // Setter method to set the list of strings.
    }

    public List<String> naturalSort() {
        Collections.sort(strings);  // Sorts the list in natural order (alphabetically).
        return strings;  // Returns the sorted list.
    }

    public List<String> naturalSortWithStreams() {
        // Uses Java Streams to sort the list in natural order and collects the result into a new list.
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> lengthSort() {
        // Sorts the list by the length of each string using a custom comparator defined as an anonymous inner class.
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();  // Comparison based on string length.
            }
        });
        return strings;  // Returns the sorted list.
    }

    public List<String> lengthSortWithLambda() {
        // Sorts the list by string length using a lambda expression, providing a more concise version of a comparator.
        Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
        return strings;  // Returns the sorted list.
    }

    public List<String> lengthReverseSortWithStreams() {
        // Uses Java Streams to sort the list by string length in reverse order using a lambda comparator, then collects results into a new list.
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .collect(Collectors.toList());
    }
}
