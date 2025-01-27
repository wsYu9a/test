package com.opos.cmn.func.b.b;

import android.content.Context;
import com.opos.cmn.func.b.a.f;

/* loaded from: classes4.dex */
public class b implements com.opos.cmn.func.b.a.d, com.opos.cmn.func.b.a.e {

    /* renamed from: b */
    private static b f17151b;

    /* renamed from: a */
    f f17152a = com.opos.cmn.func.b.a.a.a.a();

    private b() {
    }

    public static b a() {
        b bVar = f17151b;
        if (bVar == null) {
            synchronized (b.class) {
                if (f17151b == null) {
                    f17151b = new b();
                }
                bVar = f17151b;
            }
        }
        return bVar;
    }

    @Override // com.opos.cmn.func.b.a.e
    public e a(Context context, d dVar) {
        f fVar = this.f17152a;
        if (fVar != null) {
            return fVar.a(context, dVar);
        }
        return null;
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        f fVar = this.f17152a;
        if (fVar != null) {
            fVar.a(context);
        }
    }
}
