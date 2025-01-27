package com.heytap.mcssdk.o;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private static final String f8955a = "type";

    /* renamed from: b */
    private static final String f8956b = "count";

    /* renamed from: c */
    private static final String f8957c = "list";

    /* renamed from: d */
    private static final int f8958d = 1017;

    private static boolean a(Context context) {
        String e0 = com.heytap.mcssdk.a.e0(context);
        return i.i(context, e0) && i.f(context, e0) >= 1017;
    }

    public static void b(Context context, com.heytap.mcssdk.n.e eVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(eVar);
        c(context, linkedList);
    }

    public static void c(Context context, List<com.heytap.mcssdk.n.e> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        e.a("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !a(context)) {
            return;
        }
        d(context, linkedList);
    }

    private static void d(Context context, List<com.heytap.mcssdk.n.e> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(com.heytap.mcssdk.a.m0(context));
            intent.setPackage(com.heytap.mcssdk.a.e0(context));
            intent.putExtra(com.heytap.mcssdk.n.d.p, context.getPackageName());
            intent.putExtra("type", com.heytap.mcssdk.n.b.Y);
            intent.putExtra(f8956b, list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<com.heytap.mcssdk.n.e> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().p());
            }
            intent.putStringArrayListExtra(f8957c, arrayList);
            context.startService(intent);
        } catch (Exception e2) {
            e.d("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
