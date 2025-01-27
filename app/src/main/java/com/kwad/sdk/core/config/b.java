package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> abF = new ConcurrentHashMap();
    private static SharedPreferences abG = null;

    static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences aE;
        if (bVar == null || (aE = aE(context)) == null) {
            return;
        }
        try {
            bVar.a(aE);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = abF.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = abF.get(it.next());
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
            Iterator<String> it = abF.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = abF.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e2) {
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> bA = bA(key);
        if (bA == null) {
            bA = new CopyOnWriteArraySet<>();
            abF.put(key, bA);
        }
        bA.add(bVar);
    }

    private static SharedPreferences aE(Context context) {
        if (abG == null && context != null) {
            abG = context.getSharedPreferences("ksadsdk_config", 0);
        }
        return abG;
    }

    @WorkerThread
    public static synchronized boolean aF(Context context) {
        synchronized (b.class) {
            SharedPreferences aE = aE(context);
            if (aE == null) {
                return false;
            }
            SharedPreferences.Editor edit = aE.edit();
            a(edit);
            return edit.commit();
        }
    }

    @WorkerThread
    public static synchronized void aG(Context context) {
        synchronized (b.class) {
            SharedPreferences aE = aE(context);
            if (aE != null) {
                a(aE);
            }
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> bA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return abF.get(str);
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : abF.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = abF.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.g(jSONObject);
                    }
                }
            }
        }
    }
}
