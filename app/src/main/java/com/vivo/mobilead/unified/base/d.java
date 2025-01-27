package com.vivo.mobilead.unified.base;

import android.text.TextUtils;
import com.vivo.ad.model.y;
import com.vivo.mobilead.i.t;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class d implements Callable {

    /* renamed from: a */
    private com.vivo.ad.model.b f29745a;

    /* renamed from: b */
    private int f29746b = 1;

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f29747a;

        a(d dVar, String str) {
            this.f29747a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (com.vivo.mobilead.h.b.a().g(this.f29747a)) {
                return;
            }
            try {
                new com.vivo.mobilead.i.b(new t(this.f29747a)).a(1);
            } catch (Throwable unused) {
            }
        }
    }

    public d a(com.vivo.ad.model.b bVar) {
        this.f29745a = bVar;
        return this;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        String b2;
        String c2;
        com.vivo.ad.model.b bVar = this.f29745a;
        if (bVar == null) {
            return null;
        }
        y M = bVar.M();
        if (M != null) {
            if (this.f29746b == 1) {
                b2 = M.c();
                c2 = M.b();
            } else {
                b2 = M.b();
                c2 = M.c();
            }
            if (!TextUtils.isEmpty(b2) && !com.vivo.mobilead.h.b.a().g(b2)) {
                try {
                    new com.vivo.mobilead.i.b(new t(b2)).a(1);
                } catch (Throwable unused) {
                }
            }
            if (!TextUtils.isEmpty(c2) && !c2.equals(b2)) {
                com.vivo.mobilead.util.f1.c.b(new a(this, c2));
            }
        }
        return Boolean.FALSE;
    }

    public d a(int i2) {
        this.f29746b = i2;
        return this;
    }

    public static d a() {
        return new d();
    }
}
