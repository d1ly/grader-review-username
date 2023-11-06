import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class StringCheck implements StringChecker {
  public boolean checkString(String s) {
    if (s instanceof String) {
      return true;
    }
    else {
      return false;
    }
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  
	@Test 
	public void testFilter1() {
    StringCheck sc = new StringCheck();
    List<String> testList = new ArrayList<>();

    testList.add("1234");
    testList.add("this is a string!");
    testList.add("stringtest");

    assertEquals(testList, ListExamples.filter(testList, sc));
  }

  @Test 
	public void testFilter2() {
    StringCheck sc = new StringCheck();
    List<String> testList = new ArrayList<>();

    testList.add("only one string");

    assertEquals(testList, ListExamples.filter(testList, sc));
  }
}
