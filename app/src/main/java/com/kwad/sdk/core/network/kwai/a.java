package com.kwad.sdk.core.network.kwai;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class a {
    private static AdHttpProxy ahf;

    /* renamed from: com.kwad.sdk.core.network.kwai.a$a */
    public static class C0217a {
        public String msg;
    }

    public static boolean a(String str, OutputStream outputStream, C0217a c0217a, int i2) {
        boolean wj = wj();
        AdHttpProxy adHttpProxy = ahf;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "isAdCacheEnable:" + wj);
            adHttpProxy = wj ? com.kwad.sdk.b.rZ() : new com.kwad.sdk.core.network.b.a();
            ahf = adHttpProxy;
        }
        if (com.kwad.b.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", adHttpProxy instanceof com.kwad.sdk.core.network.b.b ? "okHttp" : "Http");
        }
        try {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "downloadUrlToStream success size:" + i2 + " url:" + str);
            adHttpProxy.downloadUrlToStream(str, outputStream, i2);
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", Log.getStackTraceString(e2));
            c0217a.msg = e2.getMessage();
            return false;
        }
    }

    private static boolean wj() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            return fVar.sN();
        }
        return false;
    }
}
