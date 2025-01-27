package com.opos.cmn.func.dl.base.a.a;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    com.opos.cmn.func.dl.base.f.a f17243a;

    /* renamed from: b */
    public e[] f17244b;

    /* renamed from: c */
    Context f17245c;

    public d(Context context, com.opos.cmn.func.dl.base.f.a aVar, int i2) {
        this.f17243a = aVar;
        this.f17245c = context;
        this.f17244b = new e[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f17244b[i3] = new e(this);
            aVar.f17335c.g().c().execute(this.f17244b[i3]);
        }
    }

    public final com.opos.cmn.func.dl.base.a.c a(int i2) {
        return this.f17243a.f17334b.get(Integer.valueOf(i2));
    }

    public final void b(int i2) {
        for (e eVar : this.f17244b) {
            if (eVar.f17248c.containsKey(Integer.valueOf(i2))) {
                ArrayList arrayList = new ArrayList();
                for (a aVar : eVar.f17249d) {
                    if (aVar.f17226b == i2) {
                        arrayList.add(aVar);
                    }
                }
                eVar.f17249d.removeAll(arrayList);
                com.opos.cmn.an.f.a.b(e.f17246a, "close buffer stream!downloadId:".concat(String.valueOf(i2)));
                com.opos.cmn.func.dl.base.h.a.a(eVar.f17248c.remove(Integer.valueOf(i2)));
            }
        }
    }
}
