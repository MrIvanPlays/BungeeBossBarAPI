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

package com.github.mrivanplays.bungee.bossbar.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import com.github.mrivanplays.bungee.bossbar.api.style.BarColor;
import com.github.mrivanplays.bungee.bossbar.api.style.BarStyle;
import com.github.mrivanplays.bungee.bossbar.exception.ProgressException;

/**
 * Represents a new bossbar different than the {@link net.md_5.bungee.protocol.packet.BossBar}
 * provided one
 */
public interface Bossbar
{

    /**
     * Adds all online {@link ProxiedPlayer} to the bossbar
     */
    void addOnlinePlayers();

    /**
     * Adds all online {@link ProxiedPlayer} to the bossbar after some time specified in the unit
     *
     * @param plugin plugin assigned to
     * @param delay  delay in unit
     * @param unit   delay's unit
     */
    void addOnlinePlayersAfter(Plugin plugin, int delay, TimeUnit unit);

    /**
     * Adds a {@link ProxiedPlayer} to the bossbar
     *
     * @param player player added
     */
    void addPlayer(ProxiedPlayer player);

    /**
     * Adds a {@link ProxiedPlayer} to the bossbar after some amount of time Useful if you use the
     * bossbar on join and send to the players a title
     *
     * @param player added player
     * @param plugin plugin assigned to
     * @param delay  delay in the unit specified
     * @param unit   delay's unit
     */
    void addPlayerAfter(ProxiedPlayer player, Plugin plugin, int delay, TimeUnit unit);

    /**
     * Removes a {@link ProxiedPlayer} from the bossbar
     *
     * @param player removed player
     */
    void removePlayer(ProxiedPlayer player);

    /**
     * Removes the {@link ProxiedPlayer} from the bossbar after some amount of time
     *
     * @param player removed player
     * @param plugin plugin assigned to
     * @param delay  delay in the unit specified
     * @param unit   delay's unit
     */
    void removePlayerAfter(ProxiedPlayer player, Plugin plugin, int delay, TimeUnit unit);

    /**
     * Removes all players from the bossbar after some amount of time
     *
     * @param plugin plugin assigned to
     * @param delay  delay in the unit specified
     * @param unit   delay's unit
     */
    void removeAllPlayersAfter(Plugin plugin, int delay, TimeUnit unit);

    /**
     * Gets all {@link ProxiedPlayer}s added into the bossbar
     *
     * @return all players in the bossbar
     */
    @NotNull
    List<ProxiedPlayer> getPlayers();

    /**
     * Removes all players from the bossbar and clears {@link #getPlayers()} Removes the bossbar
     */
    void removeAllPlayers();

    /**
     * Gets the {@link BarColor} of the bossbar
     *
     * @return color of the bossbar
     */
    @NotNull
    BarColor getColor();

    /**
     * Sets a new {@link BarColor} of the bossbar
     *
     * @param color set color
     */
    void setColor(BarColor color);

    /**
     * Gets the {@link BarStyle} of the bossbar
     *
     * @return style of the bossbar
     */
    @NotNull
    BarStyle getStyle();

    /**
     * Sets a new {@link BarStyle} of the bossbar
     *
     * @param style set style
     */
    void setStyle(BarStyle style);

    /**
     * Gets the bossbar title as {@link BarTitle}
     *
     * @return bossbar title
     */
    @NotNull
    BarTitle getTitle();

    /**
     * Sets a new bossbar {@link BarTitle}
     *
     * @param title new title
     */
    void setTitle(BarTitle title);

    /**
     * Checks if the bossbar is visible or no
     *
     * @return true/false
     */
    boolean isVisible();

    /**
     * Sets the bossbar visibility
     *
     * @param visible new visibility
     */
    void setVisible(boolean visible);

    /**
     * Gets the progress of the bossbar
     *
     * @return bossbar progress
     */
    float getProgress();

    /**
     * Sets a new bossbar progress
     *
     * @param newProgress new progress
     * @throws ProgressException if the progress is more than 1
     */
    void setProgress(float newProgress);

}
