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

    SchemaLoader schemaLoader = SchemaLoader.builder()
        .schemaJson(jsonSchema)
        .resolutionScope("http://jim.org/") // setting the default resolution scope
        .build();
    
    InputStream inputStream = getResourceAsStream("json-schema/degree-planning.json");
    JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
    Schema schema = schemaLoader.load(rawSchema);

    JSONObject plan = new JSONObject(new JSONTokener(getResourceAsStream("json-schema-files/plan1.json")));
    schema.validate(plan); // throws a ValidationException if this object is invalid

  }

  private InputStream getResourceAsStream(String name) throws Exception {
    return getClass().getClassLoader().getResourceAsStream(name);
  }
}
