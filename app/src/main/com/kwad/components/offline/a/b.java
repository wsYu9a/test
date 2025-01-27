package com.kwad.components.offline.a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class b extends com.kwad.components.core.n.b.a<IAdLiveOfflineCompo> {

    /* renamed from: com.kwad.components.offline.a.b$1 */
    public class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ IAdLiveOfflineCompo afF;

        public AnonymousClass1(IAdLiveOfflineCompo iAdLiveOfflineCompo) {
            iAdLiveOfflineCompo = iAdLiveOfflineCompo;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i10) {
            b.this.av(i10);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z10) {
            try {
                d.a(com.kwad.components.core.n.a.a.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                b.this.pC();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static final class a {
        private static final b afH = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void ay(Context context) {
        uM().init(context);
    }

    private static b uM() {
        return a.afH;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z10, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.avo)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pD() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pE() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pF() {
        return "3.3.68";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.68-9a2e5abfa5-559.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pH() {
        return "7e64bbc2d34dbb7975a5cec4be1faa99";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pI() {
        return "ks_live_3368";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pJ() {
        return IAdLiveOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            final /* synthetic */ IAdLiveOfflineCompo afF;

            public AnonymousClass1(IAdLiveOfflineCompo iAdLiveOfflineCompo2) {
                iAdLiveOfflineCompo = iAdLiveOfflineCompo2;
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i10) {
                b.this.av(i10);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z10) {
                try {
                    d.a(com.kwad.components.core.n.a.a.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.pC();
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }
}
