package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class b extends com.kwad.components.core.n.b.a<IObiwanOfflineCompo> {

    /* renamed from: com.kwad.components.offline.b.b$1 */
    public class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ IObiwanOfflineCompo afR;

        /* renamed from: com.kwad.components.offline.b.b$1$1 */
        public class C04581 implements g.a {
            final /* synthetic */ com.kwad.components.offline.b.a afT;

            public C04581(com.kwad.components.offline.b.a aVar) {
                aVar = aVar;
            }

            private void updateConfigs() {
                com.kwad.sdk.core.d.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avP) ? new c(aVar.getLog()) : null);
                aVar.updateConfigs();
            }

            @Override // com.kwad.components.core.request.g.a
            public final void d(@NonNull SdkConfigData sdkConfigData) {
                updateConfigs();
            }

            @Override // com.kwad.components.core.request.g.a
            public final void rw() {
                updateConfigs();
            }
        }

        public AnonymousClass1(IObiwanOfflineCompo iObiwanOfflineCompo) {
            iObiwanOfflineCompo = iObiwanOfflineCompo;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i10) {
            b.this.av(i10);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z10) {
            try {
                com.kwad.components.offline.b.a aVar = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                com.kwad.sdk.components.d.a(com.kwad.components.core.n.a.c.a.class, aVar);
                com.kwad.sdk.core.d.c.a(new c(aVar.getLog()));
                b.this.pC();
                g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                    final /* synthetic */ com.kwad.components.offline.b.a afT;

                    public C04581(com.kwad.components.offline.b.a aVar2) {
                        aVar = aVar2;
                    }

                    private void updateConfigs() {
                        com.kwad.sdk.core.d.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avP) ? new c(aVar.getLog()) : null);
                        aVar.updateConfigs();
                    }

                    @Override // com.kwad.components.core.request.g.a
                    public final void d(@NonNull SdkConfigData sdkConfigData) {
                        updateConfigs();
                    }

                    @Override // com.kwad.components.core.request.g.a
                    public final void rw() {
                        updateConfigs();
                    }
                });
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static final class a {
        private static final b afV = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void ay(Context context) {
        uP().init(context);
    }

    private static b uP() {
        return a.afV;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z10, IObiwanOfflineCompo iObiwanOfflineCompo) {
        a(context, iObiwanOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.avP)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pD() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pE() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pF() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pH() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pI() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pJ() {
        return IObiwanOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            final /* synthetic */ IObiwanOfflineCompo afR;

            /* renamed from: com.kwad.components.offline.b.b$1$1 */
            public class C04581 implements g.a {
                final /* synthetic */ com.kwad.components.offline.b.a afT;

                public C04581(com.kwad.components.offline.b.a aVar2) {
                    aVar = aVar2;
                }

                private void updateConfigs() {
                    com.kwad.sdk.core.d.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avP) ? new c(aVar.getLog()) : null);
                    aVar.updateConfigs();
                }

                @Override // com.kwad.components.core.request.g.a
                public final void d(@NonNull SdkConfigData sdkConfigData) {
                    updateConfigs();
                }

                @Override // com.kwad.components.core.request.g.a
                public final void rw() {
                    updateConfigs();
                }
            }

            public AnonymousClass1(IObiwanOfflineCompo iObiwanOfflineCompo2) {
                iObiwanOfflineCompo = iObiwanOfflineCompo2;
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i10) {
                b.this.av(i10);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z10) {
                try {
                    com.kwad.components.offline.b.a aVar2 = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.d.a(com.kwad.components.core.n.a.c.a.class, aVar2);
                    com.kwad.sdk.core.d.c.a(new c(aVar2.getLog()));
                    b.this.pC();
                    g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                        final /* synthetic */ com.kwad.components.offline.b.a afT;

                        public C04581(com.kwad.components.offline.b.a aVar22) {
                            aVar = aVar22;
                        }

                        private void updateConfigs() {
                            com.kwad.sdk.core.d.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avP) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void rw() {
                            updateConfigs();
                        }
                    });
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }
}
