package com.heytap.mcssdk.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class a extends c {
    @Override // com.heytap.mcssdk.c.d
    public final com.heytap.mcssdk.n.d a(Context context, int i2, Intent intent) {
        if (4098 != i2) {
            return null;
        }
        com.heytap.mcssdk.n.d b2 = b(intent);
        com.heytap.mcssdk.a.u0(context, (com.heytap.mcssdk.n.a) b2, com.heytap.mcssdk.a.f8876b);
        return b2;
    }

    @Override // com.heytap.mcssdk.c.c
    public final com.heytap.mcssdk.n.d b(Intent intent) {
        try {
            com.heytap.mcssdk.n.a aVar = new com.heytap.mcssdk.n.a();
            aVar.e(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.n))));
            aVar.g(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.o)));
            aVar.d(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.p)));
            aVar.r(com.heytap.mcssdk.o.a.a(intent.getStringExtra("content")));
            aVar.q(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.t))));
            aVar.w(Long.parseLong(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.y))));
            aVar.t(Long.parseLong(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.z))));
            aVar.x(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.u)));
            aVar.y(com.heytap.mcssdk.o.a.a(intent.getStringExtra("title")));
            aVar.v(com.heytap.mcssdk.o.a.a(intent.getStringExtra("rule")));
            aVar.u(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.w))));
            aVar.s(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.x))));
            com.heytap.mcssdk.o.e.a("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.a("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
