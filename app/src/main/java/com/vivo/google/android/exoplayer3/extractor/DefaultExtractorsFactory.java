package com.vivo.google.android.exoplayer3.extractor;

import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.a1;
import com.vivo.google.android.exoplayer3.c2;
import com.vivo.google.android.exoplayer3.e2;
import com.vivo.google.android.exoplayer3.g0;
import com.vivo.google.android.exoplayer3.g2;
import com.vivo.google.android.exoplayer3.h1;
import com.vivo.google.android.exoplayer3.j1;
import com.vivo.google.android.exoplayer3.p0;
import com.vivo.google.android.exoplayer3.r1;
import com.vivo.google.android.exoplayer3.r2;
import com.vivo.google.android.exoplayer3.t0;
import com.vivo.google.android.exoplayer3.u6;
import com.vivo.google.android.exoplayer3.w0;
import com.vivo.google.android.exoplayer3.w2;
import com.vivo.google.android.exoplayer3.y2;
import java.lang.reflect.Constructor;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    public static final Constructor<? extends g0> FLAC_EXTRACTOR_CONSTRUCTOR;
    public int fragmentedMp4Flags;
    public int matroskaFlags;
    public int mp3Flags;
    public int tsFlags;
    public int tsMode = 1;

    static {
        Constructor<? extends g0> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(g0.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    @Override // com.vivo.google.android.exoplayer3.extractor.ExtractorsFactory
    public synchronized g0[] createExtractors() {
        g0[] g0VarArr;
        Constructor<? extends g0> constructor = FLAC_EXTRACTOR_CONSTRUCTOR;
        g0VarArr = new g0[constructor == null ? 11 : 12];
        g0VarArr[0] = new w0(new t0(), this.matroskaFlags);
        g0VarArr[1] = new h1(this.fragmentedMp4Flags, null, null);
        g0VarArr[2] = new j1();
        g0VarArr[3] = new a1(this.mp3Flags, C.TIME_UNSET);
        g0VarArr[4] = new e2(0L);
        g0VarArr[5] = new c2(0L);
        g0VarArr[6] = new w2(this.tsMode, new u6(0L), new g2(this.tsFlags, Collections.emptyList()));
        g0VarArr[7] = new p0();
        g0VarArr[8] = new r1();
        g0VarArr[9] = new r2(new u6(0L));
        g0VarArr[10] = new y2();
        if (constructor != null) {
            try {
                g0VarArr[11] = constructor.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return g0VarArr;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i2) {
        this.fragmentedMp4Flags = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i2) {
        this.matroskaFlags = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i2) {
        this.mp3Flags = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i2) {
        this.tsFlags = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i2) {
        this.tsMode = i2;
        return this;
    }
}
