/*
 * *
 *  * Copyright 2018-2019 MrIvanPlays
 *  * <p>
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 *  * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *  * <p>
 *  * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *  * <p>
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.mrivanplays.bungee.bossbar.api.keyed;

import com.github.mrivanplays.bungee.bossbar.util.DeprecateReason;
import com.github.mrivanplays.bungee.bossbar.util.DeprecatedSince;
import com.github.mrivanplays.bungee.bossbar.util.FromVersion;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.UUID;

/** Represents a bossbar key */
@FromVersion("1.3.3")
public final class BarKey {
  /** Plugin, assigned to * */
  private Plugin plugin;
  /** Keys are now stored as UUIDs from 1.5.0 * */
  private UUID key;

  /**
   * Creates a new key
   *
   * @param plugin assigned to
   * @param key key
   * @deprecated Can have 2 separate same keys (the bars will {@link Override} each other if that
   *     happens) & Keys are now stored as UUIDs
   */
  @Deprecated
  @DeprecateReason(
      "Can have 2 separate same keys (the bars will Override each other if that happens) & Keys are now stored as UUIDs")
  @DeprecatedSince("1.4.0")
  public BarKey(Plugin plugin, String key) {
    this.plugin = plugin;
    this.key = UUID.fromString(key);
  }

  /**
   * Creates a random key
   *
   * @param plugin plugin assigned to
   */
  public BarKey(Plugin plugin) {
    this.plugin = plugin;
    this.key = UUID.randomUUID();
  }

  /**
   * Gets the plugin where the key is assigned to
   *
   * @return plugin
   */
  public Plugin getPlugin() {
    return plugin;
  }

  /**
   * Gets the key via UUID
   *
   * @return key via UUID
   */
  @FromVersion("1.5.0")
  public UUID getKey() {
    return key;
  }

  @Override
  public String toString() {
    String pluginName =
        plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion();
    return "BarKey=(Plugin="
        + pluginName
        + ", Key="
        + key.toString()
        + ")";
  }

  /**
   * Gets the key via string
   *
   * @return key via string
   * @deprecated Keys are now stored as UUIDs
   * @see UUID#toString()
   */
  @Deprecated
  @DeprecateReason(" Keys are now stored as UUIDs ('UUID#toString') ")
  @DeprecatedSince("1.5.0")
  public String getKeyString() {
    return key.toString();
  }

  /**
   * Override the {@link Object} equals
   *
   * @param object checked object
   * @return does it equal or no
   */
  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    } else if (getClass() != object.getClass()) {
      return false;
    } else if (!(object instanceof BarKey)) {
      return false;
    } else {
      BarKey otherKey = (BarKey) object;
      return key.equals(otherKey.getKey())
          && plugin
              .getDescription()
              .getName()
              .equalsIgnoreCase(otherKey.getPlugin().getDescription().getName());
    }
  }
}
