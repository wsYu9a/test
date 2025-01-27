package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class a {
    private static AdHttpProxy aAw;

    /* renamed from: com.kwad.sdk.core.network.a.a$a */
    public static class C0497a {
        public String msg;
    }

    private static boolean Fw() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.Ab();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0497a c0497a, long j10, AdHttpResponseListener adHttpResponseListener) {
        boolean Fw = Fw();
        AdHttpProxy adHttpProxy = aAw;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "isAdCacheEnable:" + Fw);
            adHttpProxy = Fw ? g.zc() : new com.kwad.sdk.core.network.c.a();
            aAw = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.ns.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j10 + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j10, adHttpResponseListener);
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", Log.getStackTraceString(e10));
            c0497a.msg = e10.getMessage();
            return false;
        }
    }
}
