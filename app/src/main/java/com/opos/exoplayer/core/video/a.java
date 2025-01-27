package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public final List<byte[]> f19219a;

    /* renamed from: b */
    public final int f19220b;

    /* renamed from: c */
    public final int f19221c;

    /* renamed from: d */
    public final int f19222d;

    /* renamed from: e */
    public final float f19223e;

    private a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.f19219a = list;
        this.f19220b = i2;
        this.f19221c = i3;
        this.f19222d = i4;
        this.f19223e = f2;
    }

    public static a a(m mVar) {
        int i2;
        int i3;
        float f2;
        try {
            mVar.d(4);
            int g2 = (mVar.g() & 3) + 1;
            if (g2 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int g3 = mVar.g() & 31;
            for (int i4 = 0; i4 < g3; i4++) {
                arrayList.add(b(mVar));
            }
            int g4 = mVar.g();
            for (int i5 = 0; i5 < g4; i5++) {
                arrayList.add(b(mVar));
            }
            if (g3 > 0) {
                k.b a2 = k.a((byte[]) arrayList.get(0), g2, ((byte[]) arrayList.get(0)).length);
                int i6 = a2.f19035b;
                int i7 = a2.f19036c;
                f2 = a2.f19037d;
                i2 = i6;
                i3 = i7;
            } else {
                i2 = -1;
                i3 = -1;
                f2 = 1.0f;
            }
            return new a(arrayList, g2, i2, i3, f2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new o("Error parsing AVC config", e2);
        }
    }

    private static byte[] b(m mVar) {
        int h2 = mVar.h();
        int d2 = mVar.d();
        mVar.d(h2);
        return com.opos.exoplayer.core.i.c.a(mVar.f19048a, d2, h2);
    }
}
