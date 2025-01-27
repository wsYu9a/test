package com.kwad.components.core.proxy.launchdialog;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {
    private static d TC = new d();
    private a TD;
    private com.kwad.components.core.proxy.b TE;

    /* renamed from: com.kwad.components.core.proxy.launchdialog.d$1 */
    public class AnonymousClass1 implements e {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass1(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void j(com.kwad.components.core.proxy.a aVar) {
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void k(com.kwad.components.core.proxy.a aVar) {
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
            d dVar = d.this;
            d.aA(adTemplate);
            d.this.n(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void l(com.kwad.components.core.proxy.a aVar) {
            d.this.n(aVar);
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void m(com.kwad.components.core.proxy.a aVar) {
            d.this.n(aVar);
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.d$2 */
    public class AnonymousClass2 implements e {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass2(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void j(com.kwad.components.core.proxy.a aVar) {
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void k(com.kwad.components.core.proxy.a aVar) {
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
            d dVar = d.this;
            d.az(adTemplate);
            d.this.n(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void l(com.kwad.components.core.proxy.a aVar) {
            d.this.n(aVar);
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
        }

        @Override // com.kwad.components.core.proxy.launchdialog.e
        public final void m(com.kwad.components.core.proxy.a aVar) {
            d.this.n(aVar);
            com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
        }
    }

    public d() {
        a aVar = new a();
        this.TD = aVar;
        this.TE = new com.kwad.components.core.proxy.b(aVar);
    }

    public static void aA(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(231).cU(25));
    }

    public static void az(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(230).cU(25));
    }

    public static d rg() {
        return TC;
    }

    public final void ay(AdTemplate adTemplate) {
        n(this.TD.ra());
        rg().a(DetectEventType.USER_CANCEL, new e() { // from class: com.kwad.components.core.proxy.launchdialog.d.1
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass1(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
                d dVar = d.this;
                d.aA(adTemplate);
                d.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void l(com.kwad.components.core.proxy.a aVar) {
                d.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void m(com.kwad.components.core.proxy.a aVar) {
                d.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
            }
        });
        rg().a(DetectEventType.USER_CONFIRM, new e() { // from class: com.kwad.components.core.proxy.launchdialog.d.2
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass2(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
                d dVar = d.this;
                d.az(adTemplate);
                d.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void l(com.kwad.components.core.proxy.a aVar) {
                d.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.e
            public final void m(com.kwad.components.core.proxy.a aVar) {
                d.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
            }
        });
    }

    public final void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.TE);
        }
    }

    public final void n(com.kwad.components.core.proxy.a aVar) {
        this.TD.i(aVar);
        this.TD.h(aVar);
    }

    private void a(DetectEventType detectEventType, e eVar) {
        b a10 = this.TD.a(detectEventType);
        if (a10 != null) {
            a10.a(eVar);
            a10.start();
        }
    }
}
