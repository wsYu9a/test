package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import java.io.File;

/* loaded from: classes2.dex */
public final class a {
    public static Pair<Integer, String> h(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int Ag = d.Ag();
        int i10 = 1;
        String str = "";
        if (Ag < 0) {
            File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(K);
            if (!u.M(ca2)) {
                a.C0497a c0497a = new a.C0497a();
                int i11 = com.kwad.sdk.core.diskcache.b.a.EG().a(K, c0497a) ? 1 : 2;
                str = c0497a.msg;
                i10 = i11;
            }
            adTemplate.setDownloadSize(ca2 != null ? ca2.length() : 0L);
        } else if (Ag > 0) {
            a.C0497a c0497a2 = new a.C0497a();
            f bC = com.kwad.sdk.core.videocache.c.a.bC(ServiceProvider.getContext());
            if (!bC.eO(K)) {
                i10 = bC.a(K, (long) (Ag * 1024), c0497a2, null) ? 1 : 2;
            }
            str = c0497a2.msg;
            adTemplate.setDownloadSize(Ag * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i10), str);
    }
}
