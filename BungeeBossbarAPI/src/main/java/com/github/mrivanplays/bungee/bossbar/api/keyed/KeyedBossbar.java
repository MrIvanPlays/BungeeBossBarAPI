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

import com.github.mrivanplays.bungee.bossbar.BungeeBossbarAPI;
import com.github.mrivanplays.bungee.bossbar.api.Bossbar;
import com.github.mrivanplays.bungee.bossbar.util.DeprecateReason;
import com.github.mrivanplays.bungee.bossbar.util.DeprecatedSince;
import com.github.mrivanplays.bungee.bossbar.util.FromVersion;
import com.github.mrivanplays.bungee.bossbar.api.keyed.BarKey;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.concurrent.TimeUnit;

/** A keyed bossbar which is gettable and removable via key */
@FromVersion("1.3.3")
public interface KeyedBossbar extends Bossbar {
  /**
   * Gets the {@link Bossbar} key
   *
   * @return bossbar key
   */
  BarKey getKey();

  /**
   * Removes the current bossbar
   *
   * @see BungeeBossbarAPI#removeBossbar(BarKey)
   * @deprecated can be a wrong key
   */
  @Deprecated
  @DeprecatedSince("1.3.3")
  @DeprecateReason("see 'BungeeBossbarAPI removeBossbar(BarKey)'")
  void removeBossbar();

  /** We override the {@link Bossbar} one to remove this bossbar also * */
  void removeAllPlayers();

  /**
   * We override the {@link Bossbar} one to remove the bossbar also
   *
   * @param plugin plugin assigned to
   * @param delay delay in the unit specified
   * @param unit delay's unit
   */
  void removeAllPlayersAfter(Plugin plugin, int delay, TimeUnit unit);

  String toString();
}
