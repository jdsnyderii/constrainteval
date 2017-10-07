package org.jim.evaluation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class EvaluationContext {

  private HashMap<String, String> courses;

  public Collection<String> getCourses() {
    return Collections.unmodifiableSet(courses.keySet());
  }
}
