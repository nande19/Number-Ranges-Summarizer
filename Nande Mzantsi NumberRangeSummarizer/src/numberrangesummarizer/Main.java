package numberrangesummarizer;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        // AN INSTANCE OF THE SUMMARIZER CLASS WHICH IMPLEMENTS THE NumberRangeSummarizer INTERFACE
        MyNumberRangeSummarizer summarizer = new MyNumberRangeSummarizer();

        //EXAMPLE INPUT INSTRUCTED TO USE
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        //CONVERTING INPUT INTO A COLLECTION OF INTEGERS
        Collection<Integer> numbers = summarizer.collect(input);
        // GENERATING SUMMARISED STRING SHOWING NUMBER RANGES
        String result = summarizer.summarizeCollection(numbers);

        //DISPLAYING INPUT AND RESULTING SUMMARISED OUTPUT
        System.out.println("Input - " + input);
        System.out.println("Result - " + result);

    }
    }
