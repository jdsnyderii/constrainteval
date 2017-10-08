package org.jim;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.InputStream;

public class JsonSchemaTest {

  @Test
  public void testSchema() throws Exception {
    
    InputStream inputStream = getResourceAsStream("json-schema/degree-planning.json");

    JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
    SchemaLoader schemaLoader = SchemaLoader.builder()
        .schemaJson(rawSchema)
        .resolutionScope("http://jim.org/") // setting the default resolution scope
        .build();
    
    Schema schema = schemaLoader.load().build();

    JSONObject plan = new JSONObject(new JSONTokener(getResourceAsStream("json-schema-files/plan1.json")));
    
    try {
      schema.validate(plan);
    } catch (ValidationException e) {
      System.out.println(e.getMessage());
      e.getCausingExceptions().stream().map(ValidationException::getMessage).forEach(System.out::println);
    }

  }

  private InputStream getResourceAsStream(String name) throws Exception {
    return getClass().getClassLoader().getResourceAsStream(name);
  }
}
