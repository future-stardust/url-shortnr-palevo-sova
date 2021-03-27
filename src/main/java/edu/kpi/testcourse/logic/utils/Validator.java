package edu.kpi.testcourse.logic.utils;

import static io.micronaut.core.util.StringUtils.isEmpty;
import static java.util.regex.Pattern.compile;

import java.util.regex.Pattern;

/**
 * Simple validator class.
 */
public class Validator {

  public static boolean isValidByRegex(String compareUrl, String regex) {
    Pattern pattern = compile(regex);
    return !isEmpty(compareUrl) && pattern.matcher(compareUrl).matches();
  }

}
