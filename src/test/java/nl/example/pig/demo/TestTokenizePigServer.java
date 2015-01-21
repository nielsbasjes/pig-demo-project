package nl.example.pig.demo;

import org.apache.pig.ExecType;
import org.apache.pig.PigServer;
import org.apache.pig.builtin.mock.Storage;
import org.apache.pig.data.Tuple;
import org.junit.Test;

import java.util.List;

import static org.apache.pig.builtin.mock.Storage.resetData;
import static org.apache.pig.builtin.mock.Storage.tuple;
import static org.junit.Assert.assertTrue;

public class TestTokenizePigServer {

  /**
   * Basic example on how to test a UDF via the PigServer route.
   * @throws Exception
   */
  @Test
  public void testTokenizeUsingPigServer() throws Exception {
    PigServer pigServer = new PigServer(ExecType.LOCAL);
    Storage.Data data = resetData(pigServer);

    data.set("input", "line:chararray",
            tuple("one two three"),
            tuple("four five")
            );

    pigServer.registerQuery(
            "InputLines = LOAD 'input' USING mock.Storage();"
    );

    pigServer.registerQuery(
            "Result = " +
            "    FOREACH InputLines " +
            "    GENERATE FLATTEN(nl.example.pig.demo.myudf.Tokenize(line)) AS tokens:chararray;"
    );

    pigServer.registerQuery(
            "STORE Result INTO 'Tokenized' USING mock.Storage();"
    );

    List<Tuple> out = data.get("Tokenized");

    // Check the result
    assertTrue("Missing One",   out.contains(tuple("one")));
    assertTrue("Missing Two",   out.contains(tuple("two")));
    assertTrue("Missing Three", out.contains(tuple("three")));
    assertTrue("Missing Four",  out.contains(tuple("four")));
    assertTrue("Missing Five",  out.contains(tuple("five")));
  }

}
