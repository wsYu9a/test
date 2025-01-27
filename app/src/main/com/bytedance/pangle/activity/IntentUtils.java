package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class IntentUtils {

    /* renamed from: a */
    static HashMap<Long, WeakReference<Bundle>> f7468a = new HashMap<>();

    public static void a(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            f7468a.put(Long.valueOf(longExtra), new WeakReference<>(extras));
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    @Keep
    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void a(Intent intent) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra != 0) {
            WeakReference<Bundle> remove = f7468a.remove(Long.valueOf(longExtra));
            Bundle bundle = remove != null ? remove.get() : null;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        }
    }
}
