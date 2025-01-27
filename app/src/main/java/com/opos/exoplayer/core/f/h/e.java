package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class e extends com.opos.exoplayer.core.f.c {

    /* renamed from: a */
    private final d f18796a;

    /* renamed from: b */
    private final m f18797b;

    /* renamed from: c */
    private final c.a f18798c;

    /* renamed from: d */
    private final g f18799d;

    /* renamed from: e */
    private final List<b> f18800e;

    public e() {
        super("WebvttDecoder");
        this.f18796a = new d();
        this.f18797b = new m();
        this.f18798c = new c.a();
        this.f18799d = new g();
        this.f18800e = new ArrayList();
    }

    private static int a(m mVar) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = mVar.d();
            String z = mVar.z();
            i2 = z == null ? 0 : "STYLE".equals(z) ? 2 : "NOTE".startsWith(z) ? 1 : 3;
        }
        mVar.c(i3);
        return i2;
    }

    private static void b(m mVar) {
        while (!TextUtils.isEmpty(mVar.z())) {
        }
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public i a(byte[] bArr, int i2, boolean z) {
        this.f18797b.a(bArr, i2);
        this.f18798c.a();
        this.f18800e.clear();
        f.a(this.f18797b);
        while (!TextUtils.isEmpty(this.f18797b.z())) {
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = a(this.f18797b);
            if (a2 == 0) {
                return new i(arrayList);
            }
            if (a2 == 1) {
                b(this.f18797b);
            } else if (a2 == 2) {
                if (!arrayList.isEmpty()) {
                    throw new com.opos.exoplayer.core.f.f("A style block was found after the first cue.");
                }
                this.f18797b.z();
                b a3 = this.f18799d.a(this.f18797b);
                if (a3 != null) {
                    this.f18800e.add(a3);
                }
            } else if (a2 == 3 && this.f18796a.a(this.f18797b, this.f18798c, this.f18800e)) {
                arrayList.add(this.f18798c.b());
                this.f18798c.a();
            }
        }
    }
}
