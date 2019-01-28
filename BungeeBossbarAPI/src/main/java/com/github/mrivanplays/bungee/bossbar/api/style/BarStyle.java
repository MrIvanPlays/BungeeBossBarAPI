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

package com.github.mrivanplays.bungee.bossbar.api.style;

import com.github.mrivanplays.bungee.bossbar.util.FromVersion;

/** Represents a bossbar style */
@FromVersion("1.0.0")
public enum BarStyle {
  /** Represents a solid bossbar */
  SOLID(0),
  /** Represents a segmented by 6 pieces bossbar */
  SEGMENTED_6(1),
  /** Represents a segmented by 10 pieces bossbar */
  SEGMENTED_10(2),
  /** Represents a segmented by 12 pieces bossbar */
  SEGMENTED_12(3),
  /** Represents a segmented by 20 pieces bossbar */
  SEGMENTED_20(4);

  private int num;

  BarStyle(int intNum) {
    this.num = intNum;
  }

  /**
   * Gets the style as integer how {@link net.md_5.bungee.protocol.packet.BossBar} requires the
   * color
   *
   * @return style as int
   */
  public int toInt() {
    return num;
  }
}
