package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.vivo.google.android.exoplayer3.drm.DrmInitData;
import com.vivo.google.android.exoplayer3.x2;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class g2 implements x2.c {

    /* renamed from: a */
    public final int f27420a;

    /* renamed from: b */
    public final List<Format> f27421b;

    public g2(int i2, List<Format> list) {
        this.f27420a = i2;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", null, -1, 0, null, null));
        }
        this.f27421b = list;
    }

    @Override // com.vivo.google.android.exoplayer3.x2.c
    public SparseArray<x2> a() {
        return new SparseArray<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final u2 a(x2.b bVar) {
        String str;
        int i2;
        if (a(32)) {
            return new u2(this.f27421b);
        }
        n6 n6Var = new n6(bVar.f28267d);
        ArrayList arrayList = this.f27421b;
        while (n6Var.a() > 0) {
            int l = n6Var.l();
            int l2 = n6Var.f27875b + n6Var.l();
            if (l == 134) {
                arrayList = new ArrayList();
                int l3 = n6Var.l() & 31;
                for (int i3 = 0; i3 < l3; i3++) {
                    String a2 = n6Var.a(3, Charset.defaultCharset());
                    int l4 = n6Var.l();
                    if ((l4 & 128) != 0) {
                        i2 = l4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    arrayList.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, a2, i2, (DrmInitData) null));
                    n6Var.e(2);
                }
            }
            n6Var.d(l2);
            arrayList = arrayList;
        }
        return new u2(arrayList);
    }

    @Override // com.vivo.google.android.exoplayer3.x2.c
    public x2 a(int i2, x2.b bVar) {
        if (i2 == 2) {
            return new q2(new k2());
        }
        if (i2 == 3 || i2 == 4) {
            return new q2(new o2(bVar.f28265b));
        }
        if (i2 == 15) {
            if (a(2)) {
                return null;
            }
            return new q2(new f2(false, bVar.f28265b));
        }
        if (i2 == 21) {
            return new q2(new n2());
        }
        if (i2 == 27) {
            if (a(4)) {
                return null;
            }
            return new q2(new l2(a(bVar), a(1), a(8)));
        }
        if (i2 == 36) {
            return new q2(new m2(a(bVar)));
        }
        if (i2 == 89) {
            return new q2(new i2(bVar.f28266c));
        }
        if (i2 != 138) {
            if (i2 != 129) {
                if (i2 != 130) {
                    if (i2 == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new t2(new v2());
                    }
                    if (i2 != 135) {
                        return null;
                    }
                }
            }
            return new q2(new d2(bVar.f28265b));
        }
        return new q2(new h2(bVar.f28265b));
    }

    public final boolean a(int i2) {
        return (i2 & this.f27420a) != 0;
    }
}
