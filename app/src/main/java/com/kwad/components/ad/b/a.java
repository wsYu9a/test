package com.kwad.components.ad.b;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdTemplate r7, boolean r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.sdk.core.response.a.d.cb(r7)
            r1 = 1
            if (r8 == 0) goto Le
            boolean r2 = com.kwad.sdk.core.response.a.a.bJ(r0)
            if (r2 == 0) goto Le
            return r1
        Le:
            java.lang.String r0 = com.kwad.sdk.core.response.a.a.E(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L1a
            r7 = 0
            return r7
        L1a:
            int r2 = com.kwad.sdk.core.config.d.ux()
            java.lang.String r3 = ""
            r4 = 0
            if (r2 >= 0) goto L4f
            com.kwad.sdk.core.diskcache.a.a r2 = com.kwad.sdk.core.diskcache.a.a.vs()
            java.io.File r2 = r2.aX(r0)
            boolean r6 = com.kwad.sdk.utils.q.G(r2)
            if (r6 == 0) goto L33
            goto L44
        L33:
            com.kwad.sdk.core.network.kwai.a$a r1 = new com.kwad.sdk.core.network.kwai.a$a
            r1.<init>()
            com.kwad.sdk.core.diskcache.a.a r3 = com.kwad.sdk.core.diskcache.a.a.vs()
            boolean r0 = r3.a(r0, r1)
            java.lang.String r1 = r1.msg
            r3 = r1
            r1 = r0
        L44:
            if (r2 == 0) goto L4a
            long r4 = r2.length()
        L4a:
            r0 = 2
            r7.setDownloadType(r0)
            goto L77
        L4f:
            if (r2 <= 0) goto L74
            com.kwad.sdk.core.network.kwai.a$a r1 = new com.kwad.sdk.core.network.kwai.a$a
            r1.<init>()
            com.kwad.sdk.KsAdSDKImpl r3 = com.kwad.sdk.KsAdSDKImpl.get()
            android.content.Context r3 = r3.getContext()
            com.kwad.sdk.core.videocache.f r3 = com.kwad.sdk.core.videocache.b.a.ba(r3)
            int r2 = r2 * 1024
            boolean r0 = r3.a(r0, r2, r1)
            java.lang.String r3 = r1.msg
            r1 = 3
            r7.setDownloadType(r1)
            long r1 = (long) r2
            r7.setDownloadSize(r1)
            r1 = r0
            goto L7a
        L74:
            r7.setDownloadType(r1)
        L77:
            r7.setDownloadSize(r4)
        L7a:
            if (r1 != 0) goto L7f
            com.kwad.components.ad.reward.monitor.a.a(r8, r7, r3)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.b.a.a(com.kwad.sdk.core.response.model.AdTemplate, boolean):boolean");
    }
}
