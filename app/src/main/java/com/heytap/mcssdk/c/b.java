package com.heytap.mcssdk.c;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class b extends c {
    @Override // com.heytap.mcssdk.c.d
    public final com.heytap.mcssdk.n.d a(Context context, int i2, Intent intent) {
        if (4105 == i2) {
            return b(intent);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.c.c
    public final com.heytap.mcssdk.n.d b(Intent intent) {
        try {
            com.heytap.mcssdk.n.b bVar = new com.heytap.mcssdk.n.b();
            bVar.u(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.b.P))));
            bVar.y(Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra("code"))));
            bVar.v(com.heytap.mcssdk.o.a.a(intent.getStringExtra("content")));
            bVar.s(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.b.Q)));
            bVar.t(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.b.R)));
            bVar.d(com.heytap.mcssdk.o.a.a(intent.getStringExtra(com.heytap.mcssdk.n.d.p)));
            com.heytap.mcssdk.o.e.a("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.a("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
