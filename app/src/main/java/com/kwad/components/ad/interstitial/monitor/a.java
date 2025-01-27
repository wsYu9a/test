package com.kwad.components.ad.interstitial.monitor;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdTemplate r7) {
        /*
            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.sdk.core.response.a.d.cb(r7)
            java.lang.String r0 = com.kwad.sdk.core.response.a.a.E(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L10
            r7 = 0
            return r7
        L10:
            com.kwad.components.ad.interstitial.monitor.b.cR()
            com.kwad.components.ad.interstitial.monitor.b.g(r7)
            int r1 = com.kwad.sdk.core.config.d.ux()
            java.lang.String r2 = ""
            r3 = 0
            r5 = 1
            if (r1 >= 0) goto L4b
            com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.a.a.vs()
            java.io.File r1 = r1.aX(r0)
            boolean r6 = com.kwad.sdk.utils.q.G(r1)
            if (r6 == 0) goto L30
            goto L40
        L30:
            com.kwad.sdk.core.network.kwai.a$a r2 = new com.kwad.sdk.core.network.kwai.a$a
            r2.<init>()
            com.kwad.sdk.core.diskcache.a.a r5 = com.kwad.sdk.core.diskcache.a.a.vs()
            boolean r0 = r5.a(r0, r2)
            java.lang.String r2 = r2.msg
            r5 = r0
        L40:
            if (r1 == 0) goto L46
            long r3 = r1.length()
        L46:
            r7.setDownloadSize(r3)
            r0 = 2
            goto L74
        L4b:
            if (r1 <= 0) goto L78
            com.kwad.sdk.core.network.kwai.a$a r2 = new com.kwad.sdk.core.network.kwai.a$a
            r2.<init>()
            com.kwad.sdk.KsAdSDKImpl r3 = com.kwad.sdk.KsAdSDKImpl.get()
            android.content.Context r3 = r3.getContext()
            com.kwad.sdk.core.videocache.f r3 = com.kwad.sdk.core.videocache.b.a.ba(r3)
            boolean r4 = r3.cU(r0)
            if (r4 != 0) goto L6b
            int r4 = r1 * 1024
            boolean r0 = r3.a(r0, r4, r2)
            r5 = r0
        L6b:
            java.lang.String r2 = r2.msg
            int r1 = r1 * 1024
            long r0 = (long) r1
            r7.setDownloadSize(r0)
            r0 = 3
        L74:
            r7.setDownloadType(r0)
            goto L7e
        L78:
            r7.setDownloadSize(r3)
            r7.setDownloadType(r5)
        L7e:
            if (r5 != 0) goto L86
            com.kwad.components.ad.interstitial.monitor.b.cR()
            com.kwad.components.ad.interstitial.monitor.b.a(r7, r2)
        L86:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.monitor.a.f(com.kwad.sdk.core.response.model.AdTemplate):boolean");
    }
}
