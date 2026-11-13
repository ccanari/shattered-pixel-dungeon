/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.shatteredpixel.shatteredpixeldungeon.SPDSettings;
import com.watabou.noosa.Image;
import com.watabou.noosa.particles.Emitter;

public class BlobShade extends Image {

    public BlobShade() {
        super(Effects.get(Effects.Type.BLOBSHADE));
        origin.set(width / 2, height / 2);
    }

    public void reset(int color, float x, float y) {
        revive();

        this.x = x + 8 - origin.x;
        this.y = y + 8 - origin.y;
        alpha((float) SPDSettings.blobShadeOpacity() / 8);

        hardlight(color);

    }

    @Override
    public void update() {
        super.update();

    }

    public static Emitter.Factory factory(int color) {

        Emitter.Factory factory;

        factory =  new Emitter.Factory() {
            @Override
            public void emit ( Emitter emitter, int index, float x, float y ) {
                BlobShade p = (BlobShade)emitter.recycle( BlobShade.class );
                p.reset(color,x,y);
            }
        };
        return factory;
    }
}