package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.a5;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class x4 extends w3 {
    public static final int p = Util.getIntegerCodeForString("payl");
    public static final int q = Util.getIntegerCodeForString("sttg");
    public static final int r = Util.getIntegerCodeForString("vttc");
    public final n6 n;
    public final a5.b o;

    public x4() {
        super("Mp4WebvttDecoder");
        this.n = new n6();
        this.o = new a5.b();
    }

    @Override // com.vivo.google.android.exoplayer3.w3
    public y3 a(byte[] bArr, int i2, boolean z) {
        n6 n6Var = this.n;
        n6Var.f27874a = bArr;
        n6Var.f27876c = i2;
        n6Var.f27875b = 0;
        ArrayList arrayList = new ArrayList();
        while (this.n.a() > 0) {
            if (this.n.a() < 8) {
                throw new a4("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int c2 = this.n.c();
            if (this.n.c() == r) {
                n6 n6Var2 = this.n;
                a5.b bVar = this.o;
                int i3 = c2 - 8;
                bVar.b();
                while (i3 > 0) {
                    if (i3 < 8) {
                        throw new a4("Incomplete vtt cue box header found.");
                    }
                    int c3 = n6Var2.c();
                    int c4 = n6Var2.c();
                    int i4 = c3 - 8;
                    String str = new String(n6Var2.f27874a, n6Var2.f27875b, i4);
                    n6Var2.e(i4);
                    i3 = (i3 - 8) - i4;
                    if (c4 == q) {
                        b5.a(str, bVar);
                    } else if (c4 == p) {
                        b5.a(null, str.trim(), bVar, Collections.emptyList());
                    }
                }
                arrayList.add(bVar.a());
            } else {
                this.n.e(c2 - 8);
            }
        }
        return new y4(arrayList);
    }
}
