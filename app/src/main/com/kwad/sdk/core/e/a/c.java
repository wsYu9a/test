package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.kwad.sdk.core.e.b.c;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class c {
    public C0494c aBh;
    public final a aBi = new a();
    public final b aBj = new b();
    public final CountDownLatch aBk = new CountDownLatch(2);
    public Context mContext;

    public class a extends c.a {
        public a() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i10, Bundle bundle) {
            Objects.toString(bundle);
            if (i10 == 0) {
                try {
                    C0494c c0494c = c.this.aBh;
                    if (c0494c != null) {
                        c0494c.akr = bundle.getString("oa_id_flag");
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            }
            c.a(c.this);
        }
    }

    public class b extends c.a {
        public b() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i10, Bundle bundle) {
            Objects.toString(bundle);
            if (i10 == 0) {
                try {
                    if (c.this.aBh != null) {
                        c.this.aBh.aBm = bundle.getBoolean(xg.a.f32009c);
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            }
            c.a(c.this);
        }
    }

    /* renamed from: com.kwad.sdk.core.e.a.c$c */
    public static final class C0494c {
        public boolean aBm;
        public String akr;
    }

    public static void a(c cVar) {
        try {
            cVar.aBk.countDown();
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        PackageManager packageManager;
        Intent intent;
        try {
            packageManager = context.getPackageManager();
            intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
        } catch (Exception unused) {
        }
        return !packageManager.queryIntentServices(intent, 0).isEmpty();
    }
}
