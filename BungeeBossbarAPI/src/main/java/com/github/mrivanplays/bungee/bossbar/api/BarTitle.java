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

import com.github.mrivanplays.bungee.bossbar.util.FromVersion;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.util.Arrays;

/** Represents a multifunctional bossbar title supporting the Chat Component API */
@FromVersion("1.3.0")
public final class BarTitle {

  /** String title empty if title is a {@link BaseComponent} or {@link BaseComponent[]} */
  private String title;

  /** Component title null if title is a {@link String} or {@link BaseComponent[]} */
  private BaseComponent baseComponent;

  /** Components title null if title is a {@link String} or {@link BaseComponent} */
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
   * Gets the set title as {@link String}
   *
   * @return the title as string
   */
  public String asString() {
    if (title != null) {
      return title;
    } else {
      if (baseComponent != null) {
        return baseComponent.toLegacyText();
      } else {
        return Arrays.toString(baseComponents);
      }
    }
  }

  @Override
  public String toString() {
    if (title.equalsIgnoreCase("")) {
      if (baseComponent != null) {
        BaseComponent component = baseComponent;
        String title = component.toLegacyText();
        String color = component.getColor().toString().toLowerCase();
        boolean isBold = component.isBold();
        boolean isUnderline = component.isUnderlined();
        boolean isItalic = component.isItalic();
        boolean isStrikethrough = component.isStrikethrough();
        boolean isObfuscated = component.isObfuscated();
        ClickEvent clickEvent = component.getClickEvent();
        HoverEvent hoverEvent = component.getHoverEvent();
        return "BarTitle=(Text="
            + title
            + ", Color="
            + color
            + ", Bold="
            + isBold
            + ", Underline="
            + isUnderline
            + ", Italic="
            + isItalic
            + ", "
            + "Strikethrough="
            + isStrikethrough
            + ", Obfuscated="
            + isObfuscated
            + ", ClickEvent=("
            + "action="
            + clickEvent.getAction().toString().toLowerCase()
            + ", value="
            + clickEvent.getValue()
            + "), HoverEvent=("
            + "action="
            + hoverEvent.getAction().toString().toLowerCase()
            + ", value="
            + Arrays.deepToString(hoverEvent.getValue())
            + "))";
      } else {
        return "BarTitle=("
            + ComponentSerializer.toString(baseComponents).replace("{", "").replace("}", "")
            + ")";
      }
    } else {
      return "BarTitle=(Text="
          + title
          + ", Color=unknown, Bold=unknown, Underline=unknown, Italic=unknown, "
          + "Strikethrough=unknown, Obfuscated=unknown, ClickEvent=unknown, "
          + "HoverEvent=unknown)";
    }
  }

  /**
   * Gets the set title as {@link BaseComponent}
   *
   * @return set title as {@link BaseComponent}.
   */
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
  public BaseComponent[] asComponents() {
    if (baseComponents != null) {
      return baseComponents;
    } else {
      if (baseComponent != null) {
        return new BaseComponent[] {baseComponent};
      } else {
        if (title != null) {
          return TextComponent.fromLegacyText(title);
        }
      }
    }
    return new BaseComponent[0]; // this will never happen
  }

  /**
   * Gets the {@link BarTitle}'s title builder for more easier creating of titles with strings for
   * your bossbar
   *
   * @return title builder
   */
  public static TitleBuilder builder() {
    return new TitleBuilder();
  }

  /** Represents a title builder for more easier creating of string titles for your bossbar */
  @FromVersion("1.3.1")
  public static class TitleBuilder {
    /** Title represented as {@link String} */
    private String text;

    /** Title represented as {@link BaseComponent} */
    private BaseComponent baseComponent;

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

    /**
     * Sets the title as {@link String}
     *
     * @param text title
     * @return this class
     */
    public TitleBuilder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Sets the title as {@link BaseComponent}
     *
     * @param component set {@link BarTitle} component
     * @return this class
     */
    public TitleBuilder text(BaseComponent component) {
      this.baseComponent = component;
      return this;
    }

    /**
     * Sets the {@link ChatColor} of your {@link BarTitle}
     *
     * @param color new color
     * @return this class
     */
    public TitleBuilder color(ChatColor color) {
      this.color = color;
      return this;
    }

    // Sets the text underlined
    public TitleBuilder underline(boolean underline) {
      this.isUnderlined = underline;
      return this;
    }

    // Sets the text obfuscated
    public TitleBuilder obfuscated(boolean obfuscated) {
      this.isObfuscated = obfuscated;
      return this;
    }

    // Sets the text bold
    public TitleBuilder bold(boolean bold) {
      this.isBold = bold;
      return this;
    }

    // Sets the text italic
    public TitleBuilder italic(boolean italic) {
      this.isItalic = italic;
      return this;
    }

    // Sets the text stroked out
    public TitleBuilder strikeout(boolean strikeout) {
      this.isStrikeout = strikeout;
      return this;
    }

    /**
     * Creates the current settings as a {@link BarTitle}
     *
     * @return {@link BarTitle} to create bossbars with it (Kappa123)
     */
    public BarTitle build() {
      if (!text.equalsIgnoreCase("")) {
        TextComponent component = new TextComponent(text);
        component.setColor(color);
        component.setUnderlined(isUnderlined);
        component.setObfuscated(isObfuscated);
        component.setBold(isBold);
        component.setItalic(isItalic);
        component.setStrikethrough(isStrikeout);
        return new BarTitle(component);
      } else {
        TextComponent component = new TextComponent(baseComponent);
        component.setColor(color);
        component.setUnderlined(isUnderlined);
        component.setObfuscated(isObfuscated);
        component.setBold(isBold);
        component.setItalic(isItalic);
        component.setStrikethrough(isStrikeout);
        return new BarTitle(component);
      }
    }
  }
}
