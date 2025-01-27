package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aua = new ConcurrentHashMap();
    private static SharedPreferences aub = null;

    private static SharedPreferences CR() {
        if (aub == null) {
            aub = bl.hc("ksadsdk_config");
        }
        return aub;
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> du = du(key);
        if (du == null) {
            du = new CopyOnWriteArraySet<>();
            aua.put(key, du);
        }
        du.add(bVar);
    }

    @WorkerThread
    public static synchronized void bh(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences CR = CR();
                if (CR != null) {
                    SharedPreferences.Editor edit = CR.edit();
                    a(edit);
                    edit.commit();
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    @WorkerThread
    public static synchronized void bi(Context context) {
        synchronized (b.class) {
            SharedPreferences CR = CR();
            if (CR != null) {
                a(CR);
            }
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> du(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aua.get(str);
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aua.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aua.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.k(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = aua.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aua.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = aua.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = aua.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e10) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences CR;
        if (bVar == null || (CR = CR()) == null) {
            return;
        }
        try {
            bVar.a(CR);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
