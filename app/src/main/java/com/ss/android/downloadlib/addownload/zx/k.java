package com.ss.android.downloadlib.addownload.zx;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.pa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: com.ss.android.downloadlib.addownload.zx.k$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Collection f24233j;

        AnonymousClass1(Collection collection) {
            collection = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = k.this.i().edit();
            for (com.ss.android.downloadad.api.j.zx zxVar : collection) {
                if (zxVar != null && zxVar.zx() != 0) {
                    edit.putString(String.valueOf(zxVar.zx()), zxVar.gs().toString());
                }
            }
            edit.apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.zx.k$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ List f24234j;

        AnonymousClass2(List list) {
            list = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = k.this.i().edit();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                edit.remove((String) it.next());
            }
            edit.apply();
        }
    }

    private static class j {

        /* renamed from: j */
        private static k f24235j = new k();
    }

    /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public SharedPreferences i() {
        return pa.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> zx() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = i().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.j.zx zx = com.ss.android.downloadad.api.j.zx.zx(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && zx != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), zx);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private k() {
    }

    public static k j() {
        return j.f24235j;
    }

    public void j(com.ss.android.downloadad.api.j.zx zxVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(zxVar);
        j((Collection<com.ss.android.downloadad.api.j.zx>) arrayList);
    }

    public synchronized void j(Collection<com.ss.android.downloadad.api.j.zx> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.g.j().j((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.zx.k.1

                    /* renamed from: j */
                    final /* synthetic */ Collection f24233j;

                    AnonymousClass1(Collection collection2) {
                        collection = collection2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = k.this.i().edit();
                        for (com.ss.android.downloadad.api.j.zx zxVar : collection) {
                            if (zxVar != null && zxVar.zx() != 0) {
                                edit.putString(String.valueOf(zxVar.zx()), zxVar.gs().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.g.j().j((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.zx.k.2

            /* renamed from: j */
            final /* synthetic */ List f24234j;

            AnonymousClass2(List list2) {
                list = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = k.this.i().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        }, true);
    }
}
