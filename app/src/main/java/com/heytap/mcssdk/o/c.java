package com.heytap.mcssdk.o;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static final String f8934a = "type";

    public void a(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(com.heytap.mcssdk.a.m0(context));
            intent.setPackage(com.heytap.mcssdk.a.e0(context));
            intent.putExtra(com.heytap.mcssdk.n.d.p, context.getPackageName());
            intent.putExtra(com.heytap.mcssdk.n.d.n, str);
            intent.putExtra("type", com.heytap.mcssdk.n.b.t0);
            context.startService(intent);
        } catch (Exception e2) {
            e.d("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
