package cn.vlion.ad.inland.ku;

import android.app.Application;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b */
    public static volatile g f4004b;

    /* renamed from: a */
    public volatile boolean f4005a = false;

    public class a implements KsInitCallback {

        /* renamed from: a */
        public final /* synthetic */ VlionMediaInitCallback f4006a;

        public a(VlionMediaInitCallback vlionMediaInitCallback) {
            this.f4006a = vlionMediaInitCallback;
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public final void onFail(int i10, String str) {
            try {
                g.this.f4005a = false;
                VlionMediaInitCallback vlionMediaInitCallback = this.f4006a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("code=error=fail");
                }
                LogVlion.e("VlionKUSDk onInitFailure ");
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public final void onSuccess() {
            try {
                LogVlion.e("VlionKUSDk onInitSuccess ");
                g.this.f4005a = true;
                VlionMediaInitCallback vlionMediaInitCallback = this.f4006a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements KsInitCallback {
        @Override // com.kwad.sdk.api.KsInitCallback
        public final void onFail(int i10, String str) {
            LogVlion.e("VlionKUSDk init fail code:" + i10 + "--msg:" + str);
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public final void onSuccess() {
            LogVlion.e(" VlionKUSDkinit success time: ");
        }
    }

    public static g a() {
        if (f4004b == null) {
            synchronized (g.class) {
                try {
                    if (f4004b == null) {
                        f4004b = new g();
                    }
                } finally {
                }
            }
        }
        return f4004b;
    }

    public final void b(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (vlionAdapterInitConfig != null) {
                LogVlion.e("VlionKUSDk getAppId() =" + vlionAdapterInitConfig.getAppId() + " isEnableLog=" + VlionSDkManager.getInstance().isEnableLog() + " isEnablePersonalizedAdState=" + VlionSDkManager.getInstance().isEnablePersonalizedAdState());
                KsAdSDK.setPersonalRecommend(VlionSDkManager.getInstance().isEnablePersonalizedAdState());
                KsAdSDK.setProgrammaticRecommend(VlionSDkManager.getInstance().isEnablePersonalizedAdState());
                KsAdSDK.init(application, new SdkConfig.Builder().appId(vlionAdapterInitConfig.getAppId()).showNotification(true).debug(VlionSDkManager.getInstance().isEnableLog()).customController(new h(application)).setInitCallback(new b()).setStartCallback(new a(vlionMediaInitCallback)).build());
                KsAdSDK.start();
            } else {
                LogVlion.e("VlionKUSDk vlionAdapterADConfig is null");
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("vlionAdapterADConfig is null");
                }
            }
        } catch (Throwable th2) {
            LogVlion.e("VlionKUSDk initSDK Throwable=" + th2.getMessage());
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
        }
    }

    public final void a(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (!vlionAdapterInitConfig.isInitPlatformEach() && this.f4005a) {
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onSuccess();
                }
                LogVlion.e("VlionKUSDk initSDK  --isInitSuccess=");
                return;
            }
            b(application, vlionAdapterInitConfig, vlionMediaInitCallback);
        } catch (Throwable th2) {
            LogVlion.e("VlionKUSDk initSDK Throwable=" + th2.getMessage());
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
        }
    }
}
