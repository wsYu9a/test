package com.opos.mobad.ad;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;

/* loaded from: classes4.dex */
public interface c {

    public static class a {

        /* renamed from: a */
        public final boolean f19473a;

        /* renamed from: b */
        public final String f19474b;

        public a(boolean z, String str) {
            this.f19473a = z;
            this.f19474b = str;
        }
    }

    com.opos.mobad.ad.a.a a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.b bVar);

    com.opos.mobad.ad.b.a a(Activity activity, String str, String str2, com.opos.mobad.ad.b.b bVar);

    com.opos.mobad.ad.b.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.b.d dVar);

    a a(Context context);

    com.opos.mobad.ad.c.c a(Context context, String str, String str2, com.opos.mobad.ad.c.f fVar);

    com.opos.mobad.ad.c.g a(Context context, String str, String str2, int i2, int i3, j jVar, com.opos.mobad.ad.privacy.a aVar);

    n a(Context context, s sVar, String str, String str2, o oVar);

    com.opos.mobad.ad.d.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.d.b bVar);

    com.opos.mobad.ad.e.a a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar);

    com.opos.mobad.ad.e.b a(Activity activity, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar);

    void a(Context context, String str, String str2, String str3, boolean z);

    void b();
}
