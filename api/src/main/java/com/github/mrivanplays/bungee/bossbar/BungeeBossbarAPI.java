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

package com.github.mrivanplays.bungee.bossbar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.github.mrivanplays.bungee.bossbar.api.BarTitle;
import com.github.mrivanplays.bungee.bossbar.api.Bossbar;
import com.github.mrivanplays.bungee.bossbar.api.keyed.BarKey;
import com.github.mrivanplays.bungee.bossbar.api.keyed.KeyedBossbar;
import com.github.mrivanplays.bungee.bossbar.api.style.BarColor;
import com.github.mrivanplays.bungee.bossbar.api.style.BarStyle;
import com.github.mrivanplays.bungee.bossbar.exception.ProgressException;

/**
 * Represents API things
 */
public abstract class BungeeBossbarAPI
{

    /**
     * Class's instance *
     */
    private static BungeeBossbarAPI instance;

    /**
     * Gets instance of this class
     *
     * @return instance of this class
     */
    @NotNull
    public static BungeeBossbarAPI getInstance()
    {
        return instance;
    }

    /**
     * Sets instance for this class
     *
     * @param instance new instance
     */
    public static void setInstance(@NotNull BungeeBossbarAPI instance)
    {
        Preconditions.checkNotNull( instance, "instance" );
        Preconditions.checkArgument( BungeeBossbarAPI.instance == null, "Instance already set" );
        BungeeBossbarAPI.instance = instance;
    }

    /**
     * Creates a bossbar with the newest {@link BarTitle} thing
     *
     * @param title    set title
     * @param color    set color
     * @param style    set style
     * @param progress bossbar title progress
     * @return new bossbar
     * @throws ProgressException if progress is bigger than 1
     */
    @NotNull
    public abstract Bossbar createBossbar(BarTitle title, BarColor color, BarStyle style, float progress);

    /**
     * Creates a bossbar with {@link String} title
     *
     * @param title    set title
     * @param color    set color
     * @param style    set style
     * @param progress bossbar title progress
     * @return new bossbar
     * @throws ProgressException if progress is bigger than 1
     * @deprecated string title. Use {@link #createBossbar(BarTitle, BarColor, BarStyle, float)}
     */
    @NotNull
    @Deprecated
    public Bossbar createBossbar(String title, BarColor color, BarStyle style, float progress)
    {
        return createBossbar( new BarTitle( title ), color, style, progress );
    }

    /**
     * Gets a {@link KeyedBossbar}
     *
     * @param key key
     * @return bossbar
     * @throws NullPointerException if the specified key does not belong to any of the {@link
     *                              #getBossbars()}
     */
    @Nullable
    public abstract KeyedBossbar getBossbar(BarKey key) throws NullPointerException;

    /**
     * Creates a {@link KeyedBossbar} which is removable
     *
     * @param key      key
     * @param title    title
     * @param color    color
     * @param style    style
     * @param progress progress
     * @return new keyed bossbar
     */
    @NotNull
    public abstract KeyedBossbar createBossbar(BarKey key, BarTitle title, BarColor color, BarStyle style, float progress);

    /**
     * Creates a {@link KeyedBossbar} with a string title which is removable
     *
     * @param key      key
     * @param title    title in string
     * @param color    color
     * @param style    style
     * @param progress progress
     * @return new keyed bossbar
     * @deprecated string title. Use {@link #createBossbar(BarKey, BarTitle, BarColor, BarStyle, float)}
     */
    @Deprecated
    @NotNull
    public KeyedBossbar createBossbar(BarKey key, String title, BarColor color, BarStyle style, float progress)
    {
        return createBossbar( key, new BarTitle( title ), color, style, progress );
    }

    /**
     * Gets all {@link KeyedBossbar}s
     *
     * @return all keyed bossbars
     */
    @NotNull
    public Set<KeyedBossbar> getBossbars()
    {
        return Collections.unmodifiableSet( new HashSet<>( getBossbarsRaw().values() ) );
    }

    /**
     * Gets all {@link KeyedBossbar}s with the keys
     *
     * @return all keyed bossbars and keys
     */
    @NotNull
    public abstract Map<BarKey, KeyedBossbar> getBossbarsRaw();

    /**
     * Removes a {@link Bossbar} with a specified key
     *
     * @param key key
     * @return success or no
     * @throws NullPointerException if the key does not belong to any of the
     * @see #getBossbars()
     * @deprecated {@link KeyedBossbar#removeAllPlayers()}
     */
    @Deprecated
    @Nullable
    public abstract boolean removeBossbar(BarKey key);

    /**
     * Removes a {@link Bossbar} with a specified key after a time specified in unit
     *
     * @param key    key
     * @param plugin plugin assigned to
     * @param delay  delay in unit
     * @param unit   delay's unit
     * @deprecated {@link KeyedBossbar#removeAllPlayersAfter(Plugin, int, TimeUnit)}
     */
    @Deprecated
    @Nullable
    public abstract void removeBossbarAfter(BarKey key, Plugin plugin, int delay, TimeUnit unit);

    /**
     * Gets the version
     * Usually by format BungeeBossbarAPI:v{version}
     *
     * @return version
     */
    @Nullable
    public abstract String getVersion();

    /**
     * Creates a new key, used for keyed bossbars.
     *
     * @param plugin plugin
     * @param key    key
     * @return new key
     */
    @NotNull
    public abstract BarKey createKey(Plugin plugin, UUID key);

    /**
     * Creates a new random key
     *
     * @param plugin plugin
     * @return new key
     */
    @NotNull
    public abstract BarKey createKey(Plugin plugin);

}
