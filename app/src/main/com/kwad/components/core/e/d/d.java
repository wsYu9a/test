package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {
    private static boolean Nd = false;
    private static final b Ne = new b() { // from class: com.kwad.components.core.e.d.d.3
        long Nk;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Nk = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Nk != 0) {
                com.kwad.sdk.core.adlog.c.m(getAdTemplate(), System.currentTimeMillis() - this.Nk);
            }
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.Ne);
            setAdTemplate(null);
            this.Nk = 0L;
        }
    };

    /* renamed from: com.kwad.components.core.e.d.d$1 */
    public class AnonymousClass1 implements b.a {
        final /* synthetic */ String Nf;
        final /* synthetic */ int Ng;
        final /* synthetic */ a.C0427a Nh;

        public AnonymousClass1(String str, int i10, a.C0427a c0427a) {
            a11 = str;
            i11 = i10;
            c0427a = c0427a;
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onError(Throwable th2) {
            com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", i11, null);
            com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a11, bt.t(th2));
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
            com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a11);
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onStart() {
            com.kwad.components.core.proxy.launchdialog.d.rg().ay(AdTemplate.this);
            d.Ne.setAdTemplate(AdTemplate.this);
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.a(d.Ne);
            com.kwad.sdk.core.adlog.c.asO = d.aj(a11);
            com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a11);
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onSuccess() {
            com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a11);
            com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", i11, c0427a.oz());
            d.a(AdTemplate.this, a11, i11);
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void pd() {
            com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a11);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.d$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int Ng;
        final /* synthetic */ String Nj;

        public AnonymousClass2(int i10, String str) {
            i10 = i10;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.az(false);
            com.kwad.sdk.core.c.b.Fi();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i10);
            com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
        }
    }

    /* renamed from: com.kwad.components.core.e.d.d$3 */
    public class AnonymousClass3 extends b {
        long Nk;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Nk = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Nk != 0) {
                com.kwad.sdk.core.adlog.c.m(getAdTemplate(), System.currentTimeMillis() - this.Nk);
            }
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.Ne);
            setAdTemplate(null);
            this.Nk = 0L;
        }
    }

    public static int a(a.C0427a c0427a, int i10) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        String a10 = a(c0427a, adTemplate);
        if (TextUtils.isEmpty(a10)) {
            return 0;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        Activity dH = m.dH(context);
        if (dH == null || !com.kwad.sdk.core.response.b.a.T(eb2) || c0427a.oo()) {
            String a11 = a(a10, c0427a, eb2);
            return com.kwad.sdk.core.download.a.b.a(context, a11, new b.a() { // from class: com.kwad.components.core.e.d.d.1
                final /* synthetic */ String Nf;
                final /* synthetic */ int Ng;
                final /* synthetic */ a.C0427a Nh;

                public AnonymousClass1(String a112, int i102, a.C0427a c0427a2) {
                    a11 = a112;
                    i11 = i102;
                    c0427a = c0427a2;
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th2) {
                    com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", i11, null);
                    com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a11, bt.t(th2));
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onPreStart() {
                    com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a11);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    com.kwad.components.core.proxy.launchdialog.d.rg().ay(AdTemplate.this);
                    d.Ne.setAdTemplate(AdTemplate.this);
                    com.kwad.sdk.core.c.b.Fi();
                    com.kwad.sdk.core.c.b.a(d.Ne);
                    com.kwad.sdk.core.adlog.c.asO = d.aj(a11);
                    com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a11);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a11);
                    com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", i11, c0427a.oz());
                    d.a(AdTemplate.this, a11, i11);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void pd() {
                    com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a11);
                }
            });
        }
        c0427a2.al(1);
        com.kwad.components.core.e.e.e.a(dH, c0427a2);
        return 2;
    }

    public static JSONObject aj(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ay(boolean z10) {
        com.kwad.sdk.core.adlog.c.asP = z10;
    }

    public static void az(boolean z10) {
        Nd = z10;
    }

    private static String l(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean pb() {
        return Nd;
    }

    private static String b(a.C0427a c0427a, AdInfo adInfo, String str) {
        long j10 = c0427a.getAdTemplate().getmCurPlayTime();
        if (j10 > 0) {
            j10 = Math.max(j10 - com.kwad.sdk.core.response.b.a.bm(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j10)).toString();
    }

    private static String a(String str, a.C0427a c0427a, AdInfo adInfo) {
        AdTemplate adTemplate = c0427a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bl(adInfo)) {
            str = b(c0427a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cS(adInfo)) {
            str = a(c0427a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cK(adInfo) || com.kwad.sdk.core.response.b.a.cQ(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0427a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0427a c0427a, AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : eb2.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0427a.dt()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0427a.os()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + eb2.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cU(eb2);
    }

    public static void a(AdTemplate adTemplate, String str, int i10) {
        if (pb()) {
            return;
        }
        az(true);
        int Ds = com.kwad.sdk.core.config.d.Ds();
        com.kwad.sdk.core.config.d.Dt();
        int abs = Math.abs(Ds);
        if (abs > 0) {
            bt.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                final /* synthetic */ int Ng;
                final /* synthetic */ String Nj;

                public AnonymousClass2(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.az(false);
                    com.kwad.sdk.core.c.b.Fi();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i10);
                    com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
                }
            }, null, abs * 1000);
        } else {
            az(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(com.kwad.components.core.e.d.a.C0427a r3, com.kwad.sdk.core.response.model.AdInfo r4, java.lang.String r5) {
        /*
            boolean r0 = com.kwad.sdk.core.response.b.a.bi(r4)
            if (r0 != 0) goto L7
            return r5
        L7:
            java.util.concurrent.Callable r0 = r3.on()
            if (r0 == 0) goto L14
            java.lang.Object r0 = r0.call()     // Catch: java.lang.Exception -> L14
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L14
            goto L15
        L14:
            r0 = 0
        L15:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L1f
            java.lang.String r0 = r3.om()
        L1f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "__simpleItemId__"
            java.lang.String r2 = "__itemId__"
            if (r3 == 0) goto L3c
            boolean r3 = r5.contains(r2)
            if (r3 != 0) goto L37
            boolean r3 = r5.contains(r1)
            if (r3 == 0) goto L36
            goto L37
        L36:
            return r5
        L37:
            java.lang.String r3 = com.kwad.sdk.core.response.b.a.cU(r4)
            return r3
        L3c:
            long r3 = com.kwad.components.core.e.b.a.ae(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L45
            goto L46
        L45:
            r3 = r0
        L46:
            java.lang.String r4 = r5.replaceAll(r2, r0)
            java.lang.String r3 = r4.replaceAll(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.e.d.d.a(com.kwad.components.core.e.d.a$a, com.kwad.sdk.core.response.model.AdInfo, java.lang.String):java.lang.String");
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i10 = 0;
        if (!ap.an(context, "com.smile.gifmaker") && ap.an(context, "com.kuaishou.nebula")) {
            i10 = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i10, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i10, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i10 == 0 || i10 == 3) ? l(str, str2) : str;
    }
}
