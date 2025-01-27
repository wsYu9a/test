package com.kwad.components.offline.adLive;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.n.f;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.core.offline.init.a {

    /* renamed from: com.kwad.components.offline.adLive.a$1 */
    final class AnonymousClass1 implements InitCallBack {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            a.this.nO();
        }
    }

    /* renamed from: com.kwad.components.offline.adLive.a$2 */
    final class AnonymousClass2 implements f.a {
        final /* synthetic */ SdkConfigData Xg;
        final /* synthetic */ AdLiveCompoImpl Xh;
        final /* synthetic */ Context jN;

        AnonymousClass2(SdkConfigData sdkConfigData, AdLiveCompoImpl adLiveCompoImpl, Context context) {
            uu = sdkConfigData;
            adLiveCompoImpl = adLiveCompoImpl;
            context = context;
        }

        @Override // com.kwad.components.core.n.f.a
        public final void a(@NonNull SdkConfigData sdkConfigData) {
            Log.d("AdLiveInitModule", "onConfigRefresh");
            adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
        }

        @Override // com.kwad.components.core.n.f.a
        public final void nP() {
            Log.d("AdLiveInitModule", "onCacheLoaded");
            SdkConfigData sdkConfigData = uu;
            if (sdkConfigData != null) {
                adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
            }
        }
    }

    /* renamed from: com.kwad.components.offline.adLive.a$a */
    static final class C0198a {
        private static final a Xi = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.init.b.class, methodId = "initOC")
    public static void ak(Context context) {
        rL().init(context);
    }

    private static a rL() {
        return C0198a.Xi;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        IAdLiveOfflineCompo iAdLiveOfflineCompo = (IAdLiveOfflineCompo) a(classLoader, IAdLiveOfflineCompo.IMPL);
        if (iAdLiveOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("AdLiveInitModule", "onPluginLoaded components is null");
            return false;
        }
        com.kwad.sdk.core.d.b.d(getTag(), "offlineComponent load components classLoader: " + iAdLiveOfflineCompo.getClass().getClassLoader());
        AdLiveCompoImpl adLiveCompoImpl = new AdLiveCompoImpl(iAdLiveOfflineCompo);
        c.a(com.kwad.components.core.offline.api.kwai.a.class, adLiveCompoImpl);
        com.kwad.sdk.core.d.b.i(getTag(), "offlineComponent load success");
        iAdLiveOfflineCompo.initReal(context, ServiceProvider.CB(), new b(), new InitCallBack() { // from class: com.kwad.components.offline.adLive.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                a.this.nO();
            }
        });
        SdkConfigData uu = d.uu();
        if (uu != null) {
            adLiveCompoImpl.onConfigRefresh(context, uu.toJson());
        }
        f.a(new f.a() { // from class: com.kwad.components.offline.adLive.a.2
            final /* synthetic */ SdkConfigData Xg;
            final /* synthetic */ AdLiveCompoImpl Xh;
            final /* synthetic */ Context jN;

            AnonymousClass2(SdkConfigData uu2, AdLiveCompoImpl adLiveCompoImpl2, Context context2) {
                uu = uu2;
                adLiveCompoImpl = adLiveCompoImpl2;
                context = context2;
            }

            @Override // com.kwad.components.core.n.f.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                Log.d("AdLiveInitModule", "onConfigRefresh");
                adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
            }

            @Override // com.kwad.components.core.n.f.a
            public final void nP() {
                Log.d("AdLiveInitModule", "onCacheLoaded");
                SdkConfigData sdkConfigData = uu;
                if (sdkConfigData != null) {
                    adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
                }
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.acK)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final int nG() {
        return 2;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nJ() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nK() {
        return "3.3.40";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nL() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.40-c04ae50398-274.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nM() {
        return "c858e8b68e0fddffe563602161bb8f8d";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nN() {
        return "ks_live_ed677b1b2";
    }
}
