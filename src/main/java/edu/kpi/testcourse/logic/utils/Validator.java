package edu.kpi.testcourse.logic.utils;

import static io.micronaut.core.util.StringUtils.isEmpty;
import static java.util.regex.Pattern.compile;

import java.util.regex.Pattern;

/**
 * Simple validator class.
 */
public class Validator {

  public static boolean isValidByRegex(String compareString, String regex) {
    Pattern pattern = compile(regex);
    return !isEmpty(compareString) && pattern.matcher(compareString).matches();
  }

}
