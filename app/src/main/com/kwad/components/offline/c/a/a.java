package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction agm;

    /* renamed from: com.kwad.components.offline.c.a.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.b agn;

        /* renamed from: com.kwad.components.offline.c.a.a$1$1 */
        public class RunnableC04591 implements Runnable {
            final /* synthetic */ String agp;

            public RunnableC04591(String str) {
                jSONObject = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.agm != null) {
                    a.this.agm.onSuccess(jSONObject);
                }
            }
        }

        public AnonymousClass1(com.kwad.sdk.core.b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1.1
                final /* synthetic */ String agp;

                public RunnableC04591(String str) {
                    jSONObject = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.agm != null) {
                        a.this.agm.onSuccess(jSONObject);
                    }
                }
            });
        }
    }

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.agm = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i10, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.c.e(i10, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.agm;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.d.Dv()) {
            GlobalThreadPools.Hp().submit(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1
                final /* synthetic */ com.kwad.sdk.core.b agn;

                /* renamed from: com.kwad.components.offline.c.a.a$1$1 */
                public class RunnableC04591 implements Runnable {
                    final /* synthetic */ String agp;

                    public RunnableC04591(String str) {
                        jSONObject = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.agm != null) {
                            a.this.agm.onSuccess(jSONObject);
                        }
                    }
                }

                public AnonymousClass1(com.kwad.sdk.core.b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1.1
                        final /* synthetic */ String agp;

                        public RunnableC04591(String str) {
                            jSONObject = str;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.agm != null) {
                                a.this.agm.onSuccess(jSONObject);
                            }
                        }
                    });
                }
            });
            return;
        }
        String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar2).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.agm;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }
}
