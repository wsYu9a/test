package com.ss.android.downloadlib.addownload.b;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: com.ss.android.downloadlib.addownload.b.i$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Collection f21232a;

        public AnonymousClass1(Collection collection) {
            collection = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = i.this.c().edit();
            for (com.ss.android.downloadad.api.a.b bVar : collection) {
                if (bVar != null && bVar.b() != 0) {
                    edit.putString(String.valueOf(bVar.b()), bVar.ah().toString());
                }
            }
            edit.apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.b.i$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21234a;

        public AnonymousClass2(List list) {
            list = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = i.this.c().edit();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                edit.remove((String) it.next());
            }
            edit.apply();
        }
    }

    public static class a {

        /* renamed from: a */
        private static i f21236a = new i();
    }

    public /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public SharedPreferences c() {
        return k.a().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> b() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = c().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    Long valueOf = Long.valueOf(entry.getKey());
                    long longValue = valueOf.longValue();
                    com.ss.android.downloadad.api.a.b b10 = com.ss.android.downloadad.api.a.b.b(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && b10 != null) {
                        concurrentHashMap.put(valueOf, b10);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private i() {
    }

    public static i a() {
        return a.f21236a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        a((Collection<com.ss.android.downloadad.api.a.b>) arrayList);
    }

    public synchronized void a(Collection<com.ss.android.downloadad.api.a.b> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.d.a().a((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.i.1

                    /* renamed from: a */
                    final /* synthetic */ Collection f21232a;

                    public AnonymousClass1(Collection collection2) {
                        collection = collection2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = i.this.c().edit();
                        for (com.ss.android.downloadad.api.a.b bVar : collection) {
                            if (bVar != null && bVar.b() != 0) {
                                edit.putString(String.valueOf(bVar.b()), bVar.ah().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.d.a().a((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.i.2

            /* renamed from: a */
            final /* synthetic */ List f21234a;

            public AnonymousClass2(List list2) {
                list = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = i.this.c().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        }, true);
    }
}
