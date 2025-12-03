package plugily.projects.minigamesbox.classic.utils.scoreboard.common;

import plugily.projects.minigamesbox.classic.utils.scoreboard.type.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight replacement for the legacy EntryBuilder utility that collected
 * scoreboard lines.
 */
public class EntryBuilder {

  private final List<Entry> entries = new ArrayList<>();

  public EntryBuilder next(String text) {
    entries.add(new Entry(text));
    return this;
  }

  public List<Entry> build() {
    return new ArrayList<>(entries);
  }
}
