package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.report.b;
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
    public static boolean n(@NonNull AdTemplate adTemplate) {
        boolean z10;
        String K = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        if (TextUtils.isEmpty(K)) {
            b.ek().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.ek().s(adTemplate);
        int Ag = d.Ag();
        String str = "";
        if (Ag < 0) {
            File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(K);
            if (u.M(ca2)) {
                z10 = true;
            } else {
                a.C0497a c0497a = new a.C0497a();
                z10 = com.kwad.sdk.core.diskcache.b.a.EG().a(K, c0497a);
                str = c0497a.msg;
            }
            adTemplate.setDownloadSize(ca2 != null ? ca2.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (Ag > 0) {
            a.C0497a c0497a2 = new a.C0497a();
            f b10 = d.Ef() == 1 ? com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0) : d.Ef() == 2 ? com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1) : com.kwad.sdk.core.videocache.c.a.bC(ServiceProvider.getContext());
            z10 = !b10.eO(K) ? b10.a(K, Ag * 1024, c0497a2, null) : true;
            str = c0497a2.msg;
            adTemplate.setDownloadSize(Ag * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z10 = true;
        }
        if (z10) {
            adTemplate.setDownloadStatus(1);
        } else {
            adTemplate.setDownloadStatus(2);
            b.ek().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.eq();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        }
        return z10;
    }
}
