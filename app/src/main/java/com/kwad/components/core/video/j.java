package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class j {
    private static Map<String, Integer> XI = new ConcurrentHashMap();

    public static boolean a(@NonNull String str, String str2, a.C0497a c0497a) {
        String by = ai.by(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + by + "--url:" + str);
        boolean b10 = com.kwad.sdk.core.diskcache.b.a.EG().b(str, str2, c0497a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + by + "--cache time:" + (System.currentTimeMillis() - currentTimeMillis) + "--success:" + b10);
        return b10;
    }

    public static boolean aE(@NonNull AdTemplate adTemplate) {
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        return ca2 != null && ca2.exists();
    }

    private static int aH(String str) {
        Integer num = XI.get(str);
        return num != null ? num.intValue() : com.kwad.sdk.core.config.d.Ag();
    }

    public static String g(Context context, @NonNull AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.er(adTemplate), com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
    }

    public static void m(String str, int i10) {
        XI.put(str, Integer.valueOf(i10));
    }

    public static String g(Context context, String str) {
        return a(context, aH(str), str);
    }

    private static String a(Context context, int i10, String str) {
        if (i10 >= 0) {
            return i10 > 0 ? com.kwad.sdk.core.videocache.c.a.bC(context).eM(str) : str;
        }
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
        return (ca2 == null || !ca2.exists()) ? str : ca2.getAbsolutePath();
    }
}
