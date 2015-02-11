package pigtests;

import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;
import org.apache.pig.pigunit.PigTest;

import java.io.IOException;

public class TestPigDemo_PigUnit {

  @Test
  public void testPigScript() throws IOException, ParseException {
    String[] input = {"One\tTwo\tThree Four"};
    System.out.println("Working Directory = " +
            System.getProperty("user.dir"));

    String[] arguments = {
    };

    String[] argumentFiles = {
            "src/main/resources/AccessLogs.properties"
    };

    PigTest test = new PigTest("src/main/pig/demo.pig", arguments, argumentFiles);
    String[] output = {
            "(One,Two,Three)",
            "(One,Two,Four)",
    };
    test.assertOutput("Clicks", input, "Stuff", output);
  }

}
