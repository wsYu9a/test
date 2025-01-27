package com.kwad.components.core.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import java.io.File;

/* loaded from: classes2.dex */
public final class h {
    public static boolean a(@NonNull String str, String str2, a.C0217a c0217a) {
        String eC = ad.eC(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "start cache video key:" + eC + "--url:" + str);
        boolean b2 = com.kwad.sdk.core.diskcache.a.a.vs().b(str, str2, c0217a);
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "finish cache video key:" + eC + "--cache time:" + (System.currentTimeMillis() - currentTimeMillis) + "--success:" + b2);
        return b2;
    }

    public static boolean i(@NonNull AdTemplate adTemplate) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return aX != null && aX.exists();
    }
}
