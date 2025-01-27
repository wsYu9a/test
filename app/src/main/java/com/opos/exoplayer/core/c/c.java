package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.c.f.p;
import com.opos.exoplayer.core.c.f.t;
import java.lang.reflect.Constructor;

/* loaded from: classes4.dex */
public final class c implements h {

    /* renamed from: a */
    private static final Constructor<? extends e> f17832a;

    /* renamed from: b */
    private int f17833b;

    /* renamed from: c */
    private int f17834c;

    /* renamed from: d */
    private int f17835d;

    /* renamed from: e */
    private int f17836e;

    /* renamed from: f */
    private int f17837f = 1;

    /* renamed from: g */
    private int f17838g;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f17832a = constructor;
    }

    @Override // com.opos.exoplayer.core.c.h
    public e[] a() {
        e[] eVarArr;
        synchronized (this) {
            Constructor<? extends e> constructor = f17832a;
            eVarArr = new e[constructor == null ? 11 : 12];
            eVarArr[0] = new com.opos.exoplayer.core.c.b.a(this.f17833b);
            eVarArr[1] = new com.opos.exoplayer.core.c.d.b(this.f17835d);
            eVarArr[2] = new com.opos.exoplayer.core.c.d.c(this.f17834c);
            eVarArr[3] = new com.opos.exoplayer.core.c.c.a(this.f17836e);
            eVarArr[4] = new com.opos.exoplayer.core.c.f.c();
            eVarArr[5] = new com.opos.exoplayer.core.c.f.a();
            eVarArr[6] = new t(this.f17837f, this.f17838g);
            eVarArr[7] = new com.opos.exoplayer.core.c.a.a();
            eVarArr[8] = new com.opos.exoplayer.core.c.e.a();
            eVarArr[9] = new p();
            eVarArr[10] = new com.opos.exoplayer.core.c.g.a();
            if (constructor != null) {
                try {
                    eVarArr[11] = constructor.newInstance(new Object[0]);
                } catch (Exception e2) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                }
            }
        }
        return eVarArr;
    }
}
