package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

// CONVERTS STRING OF NUMBERS INTO A COLLECTION AND SUMMARISES SEQUENTIAL NUMBERS INTO RANGES
public class MyNumberRangeSummarizer implements NumberRangeSummarizer{

    // INPUT STRING WILL BE TURNED INTO A LIST OF NUMBERS
    @Override
    public Collection<Integer> collect(String input) {
        // RETURNS EMPTY LIST IF INPUT IS NULL OR CONTAINS WHITESPACE
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }

    // SPLITTING STRING BY COMMAS, REMOVING SPACES, CONVERTING TO INT
    return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());

    }

    //TAKES THE LIST OF NUMBERS AND GROUPS IT INTO RANGES
    @Override
    public String summarizeCollection(Collection<Integer> input){
        // RETURNS EMPTY STRING IF INPUT IS NULL OR EMPTY
        if(input == null || input.isEmpty()) {
            return "";
        }

        // CONVERTS INPUT TO A LIST AND PREPARES StringBuilder FOR THE RESULT
        List<Integer> numbers = new ArrayList<>(input);
        StringBuilder result = new StringBuilder();

        // INITIALISE START AND END OF THE CURRENT RANGE
        int start = numbers.get(0);
        int end = start;

        // ITERATES THROUGH THE LIST TO FIND SEQUENTIAL NUMBERS
        for(int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current == end + 1) {
                // EXTENDING THE CURRENT RANGE
                end = current;
            }else {
                // ADDS PREVIOUS RANGE TO THE RESULT TO START A NEW RANGE
                appendRange(result, start, end);
                start = end = current;
            }
        }

        // ADDS FINAL RANGE
        appendRange(result, start, end);

        return result.toString();
    }

    //HELPER TO FORMAT THE RANGE BY ADDING A SINGLE NUMBER OR RANGE TO THE RESULT
    private void appendRange(StringBuilder result, int start, int end)  {
        // COMMA IS ADDED IF IT IS NOT THE FIRST ELEMENT
        if(result.length() > 0) {
            result.append(",");
        }
        // ADDS A SINGLE NUMBER OR A RANGE
        if(start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
    }

}
