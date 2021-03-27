package edu.kpi.testcourse.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.kpi.testcourse.entities.UrlAlias;

import java.util.List;

public record UrlsAliasesResponse(@JsonProperty("urls_aliases") List<UrlAlias> urlsAliases) {

}
