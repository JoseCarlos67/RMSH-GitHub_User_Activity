package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubEvent(
        String type,
        Repo repo
) {
  @Override
  public String toString() {
    return "Type -> " + type + " -- Repo -> " + repo.name();
  }
}

