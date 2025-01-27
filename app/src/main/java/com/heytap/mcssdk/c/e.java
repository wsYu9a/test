package com.heytap.mcssdk.c;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.n.h;

/* loaded from: classes.dex */
public final class e extends c {
    @Override // com.heytap.mcssdk.c.d
    public final com.heytap.mcssdk.n.d a(Context context, int i2, Intent intent) {
        if (4103 != i2) {
            return null;
        }
        com.heytap.mcssdk.n.d b2 = b(intent);
        com.heytap.mcssdk.a.w0(context, (h) b2, com.heytap.mcssdk.a.f8876b);
        return b2;
    }

    @Override // com.heytap.mcssdk.c.c
    public final com.heytap.mcssdk.n.d b(Intent intent) {
        try {
            h hVar = new h();
            hVar.e(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.n))));
            hVar.g(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.o)));
            hVar.d(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.p)));
            hVar.m(com.heytap.mcssdk.o.a.a(intent.getStringExtra("content")));
            hVar.n(com.heytap.mcssdk.o.a.a(intent.getStringExtra("description")));
            hVar.l(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.C)));
            hVar.o(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.D)));
            return hVar;
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.a("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
