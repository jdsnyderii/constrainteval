package org.jim;

import junit.framework.TestCase;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class JsonSchemaTest {

  @Test
  public void testSchema() throws Exception {

    InputStream inputStream = getResourceAsStream("json-schema/degree-planning.json");

    JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
    SchemaLoader schemaLoader = SchemaLoader.builder()
        .schemaJson(rawSchema)
        .build();

    Schema schema = schemaLoader.load().build();

    JSONObject plan = new JSONObject(new JSONTokener(getResourceAsStream("json-schema-files/plan1.json")));

    try {
      schema.validate(plan);
    } catch (ValidationException e) {
      logValidationException(e);
      TestCase.fail(e.getMessage());
    }

  }

  private void logValidationCausingExceptions(List<ValidationException> exceptions) {
    exceptions.forEach(this::logValidationException);
  }

  private void logValidationException(ValidationException e) {
    System.out.println(e.getMessage());
    if (e.getCausingExceptions().size() > 0) {
      logValidationCausingExceptions(e.getCausingExceptions());
    }
  }

  private InputStream getResourceAsStream(String name) throws Exception {
    return getClass().getClassLoader().getResourceAsStream(name);
  }
}
