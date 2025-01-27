package com.heytap.mcssdk.c;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements d {
    public static List<com.heytap.mcssdk.n.d> c(Context context, Intent intent) {
        com.heytap.mcssdk.n.d a2;
        if (intent == null) {
            return null;
        }
        int i2 = 4096;
        try {
            i2 = Integer.parseInt(com.heytap.mcssdk.o.a.a(intent.getStringExtra("type")));
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.d("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        com.heytap.mcssdk.o.e.a("MessageParser--getMessageByIntent--type:" + i2);
        ArrayList arrayList = new ArrayList();
        for (d dVar : com.heytap.mcssdk.a.c0().g0()) {
            if (dVar != null && (a2 = dVar.a(context, i2, intent)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public abstract com.heytap.mcssdk.n.d b(Intent intent);
}
