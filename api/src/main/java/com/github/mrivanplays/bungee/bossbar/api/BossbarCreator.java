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

import com.github.mrivanplays.bungee.bossbar.BungeeBossbarAPI;
import com.github.mrivanplays.bungee.bossbar.api.keyed.BarKey;
import com.github.mrivanplays.bungee.bossbar.api.keyed.KeyedBossbar;
import com.github.mrivanplays.bungee.bossbar.api.style.BarColor;
import com.github.mrivanplays.bungee.bossbar.api.style.BarStyle;

/**
 * Represents a bossbar creator
 *
 * @deprecated use {@link BungeeBossbarAPI#createBossbar(BarTitle, BarColor, BarStyle, float)}
 */
@Deprecated
public class BossbarCreator
{

    /**
     * Creator which the plugin uses
     */
    private static BungeeBossbarAPI creator = BungeeBossbarAPI.getInstance();

    /**
     * Creates a bossbar with only parameter title
     *
     * @param title the title
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(BarTitle title)
    {
        return createBossbar( title, BarColor.PINK );
    }

    /**
     * Creates a bossbar with only parameters title and color
     *
     * @param title the title
     * @param color set color
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(BarTitle title, BarColor color)
    {
        return createBossbar( title, color, BarStyle.SOLID );
    }

    /**
     * Creates a bossbar with only parameters title and style
     *
     * @param title the title
     * @param style set style
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(BarTitle title, BarStyle style)
    {
        return createBossbar( title, BarColor.PINK, style );
    }

    /**
     * Creates a bossbar with only parameters title color and style
     *
     * @param title the title
     * @param color set color
     * @param style set style
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(BarTitle title, BarColor color, BarStyle style)
    {
        return createBossbar( title, color, style, 1 );
    }

    /**
     * Creates a bossbar with all parameters
     *
     * @param title    the title
     * @param color    set color
     * @param style    set style
     * @param progress set progress
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(BarTitle title, BarColor color, BarStyle style, float progress)
    {
        return creator.createBossbar( title, color, style, progress );
    }

    /**
     * Creates a normal bossbar with string title
     *
     * @param title    set title as string
     * @param color    set color
     * @param style    set style
     * @param progress set progress
     * @return new bossbar
     */
    @Deprecated
    public static Bossbar createBossbar(String title, BarColor color, BarStyle style, float progress)
    {
        return creator.createBossbar( title, color, style, progress );
    }

    // --------------------------------------------------------------------------------------------------------------------
    // Keyed bossbars start
    // Everything downside is from version 1.3.3

    /**
     * @param key   bar key
     * @param title title
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, BarTitle title)
    {
        return createBossbar( key, title, BarColor.PINK );
    }

    /**
     * @param key   bar key
     * @param title title
     * @param style style
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, BarTitle title, BarStyle style)
    {
        return createBossbar( key, title, BarColor.PINK, style );
    }

    /**
     * @param key   bar key
     * @param title title
     * @param color color
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, BarTitle title, BarColor color)
    {
        return createBossbar( key, title, color, BarStyle.SOLID );
    }

    /**
     * @param key   bar key
     * @param title title
     * @param color color
     * @param style style
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, BarTitle title, BarColor color, BarStyle style)
    {
        return createBossbar( key, title, color, style, 1 );
    }

    /**
     * Creates a new {@link KeyedBossbar} which is removable
     *
     * @param key      bar key
     * @param title    title
     * @param color    color
     * @param style    style
     * @param progress progress
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, BarTitle title, BarColor color, BarStyle style, float progress)
    {
        return creator.createBossbar( key, title, color, style, progress );
    }

    /**
     * Creates a new {@link KeyedBossbar} with string title which is removable
     *
     * @param key      bar key
     * @param title    string title
     * @param color    color
     * @param style    style
     * @param progress progress
     * @return new keyed bossbar
     */
    @Deprecated
    public static KeyedBossbar createBossbar(BarKey key, String title, BarColor color, BarStyle style, float progress)
    {
        return creator.createBossbar( key, title, color, style, progress );
    }
}
