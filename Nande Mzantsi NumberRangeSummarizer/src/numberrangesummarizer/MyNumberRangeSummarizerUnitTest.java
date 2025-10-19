package numberrangesummarizer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

//TESTS TO VERIFY THAT EVERYTHING WORKS CORRECTLY
public class MyNumberRangeSummarizerUnitTest {
    //INSTANCE OF SUMMARIZER IS CREATED FOR TESTING
    private final MyNumberRangeSummarizer summarizer = new MyNumberRangeSummarizer();

    // TESTING THAT collect() CONVERTS A STRING OF COMMA SEPERATED NUMBERS CORRECTLY INTO A SORTED COLLECTION OF INT
    @Test
    public void testCollect(){
        String input = "1,3,6,7,8,12,13,14,15";
        Collection<Integer> expected = Arrays.asList(1,3,6,7,8,12,13,14,15);
        assertEquals(expected, summarizer.collect(input));
    }

    // TESTING THAT summarizeCollection() CORRECTLY GROUPS SEQUENTIAL NUMBERS INTO RANGES AND RETURNS THE STRING
    @Test
    public void testSummarizerCollection(){
        Collection<Integer> input = Arrays.asList(1,3,6,7,8,12,13,14,15);
        String expected = "1,3,6-8,12-15";
        assertEquals(expected, summarizer.summarizeCollection(input));
    }

    // TESTS THAT summarizeCollection() RETURNS EMPTY STRING WHEN INPUT COLLECTION IS EMPTY
    @Test
    public void testEmptyInput(){
        Collection<Integer> input = new ArrayList<>();
        assertEquals("", summarizer.summarizeCollection(input));
    }

    // TESTS THAT summarizeCollection() HANDLES A SINGLE NUMBER INPUT CORRECTLY
    @Test
    public void testSingleNumber(){
        Collection<Integer> input = Arrays.asList(1,3,6,7,8,12,13,14,15);
        assertEquals("5", summarizer.summarizeCollection(input));
    }

    // TESTS THAT summarizeCollection() SUMMARISES A CONTINUOUS SEQUENCE OF NUMBERS INTO A SINGLE RANGE
    @Test
    public void testContinuousNumbers(){
        Collection<Integer> input = Arrays.asList(1,3,6,7,8,12,13,14,15);
        assertEquals("1-5", summarizer.summarizeCollection(input));
    }
}
