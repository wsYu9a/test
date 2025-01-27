package com.opos.exoplayer.core.f.h;

import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a */
    private static final int f18760a = u.f("payl");

    /* renamed from: b */
    private static final int f18761b = u.f("sttg");

    /* renamed from: c */
    private static final int f18762c = u.f("vttc");

    /* renamed from: d */
    private final m f18763d;

    /* renamed from: e */
    private final c.a f18764e;

    public a() {
        super("Mp4WebvttDecoder");
        this.f18763d = new m();
        this.f18764e = new c.a();
    }

    private static com.opos.exoplayer.core.f.b a(m mVar, c.a aVar, int i2) {
        aVar.a();
        while (i2 > 0) {
            if (i2 < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete vtt cue box header found.");
            }
            int o = mVar.o();
            int o2 = mVar.o();
            int i3 = o - 8;
            String str = new String(mVar.f19048a, mVar.d(), i3);
            mVar.d(i3);
            i2 = (i2 - 8) - i3;
            if (o2 == f18761b) {
                d.a(str, aVar);
            } else if (o2 == f18760a) {
                d.a((String) null, str.trim(), aVar, (List<b>) Collections.emptyList());
            }
        }
        return aVar.b();
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public h a(byte[] bArr, int i2, boolean z) {
        this.f18763d.a(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.f18763d.b() > 0) {
            if (this.f18763d.b() < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int o = this.f18763d.o();
            if (this.f18763d.o() == f18762c) {
                arrayList.add(a(this.f18763d, this.f18764e, o - 8));
            } else {
                this.f18763d.d(o - 8);
            }
        }
        return new h(arrayList);
    }
}
