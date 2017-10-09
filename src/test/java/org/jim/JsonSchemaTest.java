package org.jim;

import junit.framework.TestCase;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonSchemaTest {

  private static Iterable<String> data() {
    return Arrays.asList("json-schema-files/catalog1.json", "json-schema-files/plan1.json");
  }

  private List<String> failedFiles = new ArrayList<>();
  private static final String schemaName = "json-schema/degree-planning.json";

  @Test
  public void testFiles() throws Exception {
    Schema schema = buildSchema(schemaName);
    data().forEach(f -> testFile(f, schema));
    if (failedFiles.size() > 0) {
      TestCase.fail("Some files failed to validate");
    }
  }

  private Schema buildSchema(String name) throws Exception {
    InputStream inputStream = getResourceAsStream(name);
    JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
    SchemaLoader schemaLoader = SchemaLoader.builder()
        .schemaJson(rawSchema)
        .build();

    return schemaLoader.load().build();
  }

  private void testFile(String fileName, Schema schema) {
    try (InputStream inputStream = getResourceAsStream(fileName)) {

      JSONObject vertex = new JSONObject(new JSONTokener(inputStream));
      try {
        schema.validate(vertex);
      } catch (ValidationException e) {
        logValidationException(fileName, e);
        failedFiles.add(fileName);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void logValidationCausingExceptions(String fileName, List<ValidationException> exceptions) {
    exceptions.forEach(v -> logValidationException(fileName, v));
  }

  private void logValidationException(String fileName, ValidationException e) {
    System.out.println(String.format("Error in file '%s' : '%s'", fileName, e.getMessage()));
    if (e.getCausingExceptions().size() > 0) {
      logValidationCausingExceptions(fileName, e.getCausingExceptions());
    }
  }

  private InputStream getResourceAsStream(String name) throws Exception {
    return getClass().getClassLoader().getResourceAsStream(name);
  }
}
