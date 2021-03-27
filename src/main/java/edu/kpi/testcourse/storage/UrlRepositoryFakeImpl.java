package edu.kpi.testcourse.storage;

import edu.kpi.testcourse.entities.UrlAlias;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * An in-memory fake implementation of {@link UrlRepository}.
 */
public class UrlRepositoryFakeImpl implements UrlRepository {
  private final HashMap<String, UrlAlias> aliases = new HashMap<>();

  @Override
  public void createUrlAlias(UrlAlias urlAlias) {
    if (aliases.containsKey(urlAlias.alias())) {
      throw new UrlRepository.AliasAlreadyExist();
    }

    aliases.put(urlAlias.alias(), urlAlias);
  }

  @Override
  public @Nullable
  UrlAlias findUrlAlias(String alias) {
    return aliases.get(alias);
  }

  @Override
  public void deleteUrlAlias(String email, String alias) {
    for (UrlAlias currentAlias :
        getAllAliasesForUser(email)) {
      if (currentAlias.alias().equals(alias)) {
        aliases.remove(alias);
        return;
      }
    }
    throw new RuntimeException("Alias " + alias + " was not found among created by the user");
  }

  @Override
  public List<UrlAlias> getAllAliasesForUser(String userEmail) {
    return aliases.values()
      .stream()
      .filter(urlAlias -> urlAlias.email().equals(userEmail))
      .collect(Collectors.toList());
  }
}
