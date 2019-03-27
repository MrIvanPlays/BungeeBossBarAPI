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

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a multifunctional bossbar title supporting the Chat Component API
 */
public final class BarTitle {

    /**
     * String title empty if title is a {@link BaseComponent} or {@link BaseComponent[]}
     */
    private String title;

    /**
     * Component title null if title is a {@link String} or {@link BaseComponent[]}
     */
    private BaseComponent baseComponent;

    /**
     * Components title null if title is a {@link String} or {@link BaseComponent}
     */
    private BaseComponent[] baseComponents;

    /**
     * String title constructor
     *
     * @param title set title
     */
    public BarTitle(String title) {
        this.title = title;
    }

    /**
     * Component type title constructor
     *
     * @param component set title's component
     */
    public BarTitle(BaseComponent component) {
        this.baseComponent = component;
    }

    /**
     * Components type title constructor
     *
     * @param components set title's components
     */
    public BarTitle(BaseComponent[] components) {
        this.baseComponents = components;
    }

    /**
     * Gets the {@link BarTitle}'s title builder for more easier creating of titles with strings for
     * your bossbar
     *
     * @return title builder
     * @deprecated should not be used.
     */
    @Deprecated
    public static TitleBuilder builder() {
        return new TitleBuilder();
    }

    /**
     * Gets the set title as {@link String}
     *
     * @return the title as string
     */
    @Nullable
    public String asString() {
        if (title != null) {
            return title;
        } else {
            if (baseComponent != null) {
                return baseComponent.toLegacyText();
            } else {
                return ComponentSerializer.toString(baseComponents);
            }
        }
    }

    @Override
    public String toString() {
        if (title.equalsIgnoreCase("")) {
            if (baseComponent != null) {
                return "BarTitle=(component=" + baseComponent + ")";
            } else {
                if (baseComponents != null) {
                    return "BarTitle=(components=" + baseComponents + ")";
                }
            }
        } else {
            return "BarTitle=(title=" + title + ")";
        }
        return "";
    }

    /**
     * Gets the set title as {@link BaseComponent}
     *
     * @return set title as {@link BaseComponent}.
     */
    @NotNull
    public BaseComponent asComponent() {
        if (baseComponent != null) {
            return baseComponent;
        } else {
            if (title != null) {
                return new TextComponent(title);
            } else {
                return new TextComponent(baseComponents);
            }
        }
    }

    /**
     * Gets the set title as {@link BaseComponent[]}
     *
     * @return set title as {@link BaseComponent[]}.
     */
    @NotNull
    public BaseComponent[] asComponents() {
        if (baseComponents != null) {
            return baseComponents;
        } else {
            if (baseComponent != null) {
                return new BaseComponent[]{baseComponent};
            } else {
                if (title != null) {
                    return TextComponent.fromLegacyText(title);
                }
            }
        }
        return new BaseComponent[0]; // this will never happen
    }

    /**
     * Represents a title builder for more easier creating of string titles for your bossbar
     */
    public static class TitleBuilder {

        /**
         * Title represented as {@link String}
         */
        private String text;

        // Title color
        private ChatColor color = ChatColor.WHITE;

        // Do you want your text be underlined?
        private boolean isUnderlined = false;

        // Do you want your text be obfuscated?
        private boolean isObfuscated = false;

        // Do you want your text be bold?
        private boolean isBold = false;

        // Do you want your text be italic?
        private boolean isItalic = false;

        // Do you want your text be stroked out?
        private boolean isStrikeout = false;

        private List<String> extras = new ArrayList<>();

        /**
         * Sets the title as {@link String}
         *
         * @param text title
         * @return current instance of builder
         */
        public TitleBuilder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * Sets the {@link ChatColor} of your {@link BarTitle}
         *
         * @param color new color
         * @return current instance of builder
         */
        public TitleBuilder color(ChatColor color) {
            this.color = color;
            return this;
        }

        /***
         * Sets the text underlined
         *
         * @param underline value
         * @return current instance of builder
         */
        public TitleBuilder underline(boolean underline) {
            this.isUnderlined = underline;
            return this;
        }

        /**
         * Sets the text obufuscated
         *
         * @param obfuscated value
         * @return current instance of builder
         */
        public TitleBuilder obfuscated(boolean obfuscated) {
            this.isObfuscated = obfuscated;
            return this;
        }

        /**
         * Sets the text bold
         *
         * @param bold value
         * @return current instance of builder
         */
        public TitleBuilder bold(boolean bold) {
            this.isBold = bold;
            return this;
        }

        /**
         * Sets the text italic
         *
         * @param italic value
         * @return current instance of builder
         */
        public TitleBuilder italic(boolean italic) {
            this.isItalic = italic;
            return this;
        }

        /**
         * Sets the text strikeout
         *
         * @param strikeout value
         * @return current instance of builder
         */
        public TitleBuilder strikeout(boolean strikeout) {
            this.isStrikeout = strikeout;
            return this;
        }

        /**
         * Adds extra text. Don't use any other modifiers after this except
         * the build one.
         *
         * @param extra extra
         * @return current instance of builder
         */
        public TitleBuilder addExtra(String extra) {
            extras.add(extra);
            return this;
        }

        /**
         * Creates the current settings as a {@link BarTitle}
         *
         * @return {@link BarTitle} to create bossbars with it (Kappa123)
         */
        public BarTitle build() {
            ComponentBuilder builder = new ComponentBuilder(text).color(color).bold(isBold).underlined(isUnderlined).obfuscated(isObfuscated)
                    .italic(isItalic).strikethrough(isStrikeout);
            for (String extra : extras) {
                builder.append(extra);
            }
            return new BarTitle(builder.create());
        }

    }

}
