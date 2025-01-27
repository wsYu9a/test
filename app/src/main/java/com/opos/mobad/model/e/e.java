package com.opos.mobad.model.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.j;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static Map<String, com.opos.mobad.model.b.e> f21753a = new ConcurrentHashMap();

    /* renamed from: com.opos.mobad.model.e.e$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21754a;

        /* renamed from: b */
        final /* synthetic */ Context f21755b;

        AnonymousClass1(List list, Context context) {
            list = list;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (x xVar : list) {
                if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, xVar.f19904d, xVar.f19905e))) {
                    String a2 = com.opos.cmn.d.c.a(xVar.f19904d);
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + e.f21753a.size());
                    if (e.f21753a.size() >= 2 || e.f21753a.containsKey(a2) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.d.b.a.c() <= 2147483648L) {
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                        return;
                    }
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + xVar.toString());
                    HashSet hashSet = new HashSet();
                    com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
                    eVar.a(xVar.f19904d);
                    eVar.b(xVar.f19905e);
                    eVar.c(com.opos.cmn.d.d.b(context, xVar.f19904d));
                    hashSet.add(eVar);
                    e.f21753a.put(a2, eVar);
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + xVar.toString() + ",result=" + new j(context).a(hashSet));
                    e.f21753a.remove(a2);
                    return;
                }
            }
        }
    }

    public static void a(Context context, y yVar) {
        List<x> list = yVar.aq;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.e.e.1

            /* renamed from: a */
            final /* synthetic */ List f21754a;

            /* renamed from: b */
            final /* synthetic */ Context f21755b;

            AnonymousClass1(List list2, Context context2) {
                list = list2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (x xVar : list) {
                    if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, xVar.f19904d, xVar.f19905e))) {
                        String a2 = com.opos.cmn.d.c.a(xVar.f19904d);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + e.f21753a.size());
                        if (e.f21753a.size() >= 2 || e.f21753a.containsKey(a2) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.d.b.a.c() <= 2147483648L) {
                            com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                            return;
                        }
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + xVar.toString());
                        HashSet hashSet = new HashSet();
                        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
                        eVar.a(xVar.f19904d);
                        eVar.b(xVar.f19905e);
                        eVar.c(com.opos.cmn.d.d.b(context, xVar.f19904d));
                        hashSet.add(eVar);
                        e.f21753a.put(a2, eVar);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + xVar.toString() + ",result=" + new j(context).a(hashSet));
                        e.f21753a.remove(a2);
                        return;
                    }
                }
            }
        });
    }

    public static final boolean a(Context context, AdData adData) {
        if (context != null && adData != null) {
            try {
                List<AdItemData> f2 = adData.f();
                if (f2 != null && f2.size() > 0) {
                    for (int i2 = 0; i2 < f2.size(); i2++) {
                        if (1 == f2.get(i2).r()) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("VideoCacheUtils", "", e2);
            }
        }
        return false;
    }
}
