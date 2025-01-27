package cn.vlion.ad.inland.kd;

import android.app.Application;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.shu.priory.IFLYAdSDK;
import com.shu.priory.config.AdKeys;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: b */
    public static volatile q f3962b;

    /* renamed from: a */
    public volatile boolean f3963a;

    public class a implements IFLYAdSDK.OnStartListener {

        /* renamed from: a */
        public final /* synthetic */ VlionMediaInitCallback f3964a;

        public a(VlionMediaInitCallback vlionMediaInitCallback) {
            this.f3964a = vlionMediaInitCallback;
        }

        @Override // com.shu.priory.IFLYAdSDK.OnStartListener
        public final void onStartFailed(int i10, String str) {
            try {
                VlionMediaInitCallback vlionMediaInitCallback = this.f3964a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("code=" + i10 + "msg =" + str);
                }
                LogVlion.e("VlionKdSdk start fail:code=" + i10 + "msg =" + str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.IFLYAdSDK.OnStartListener
        public final void onStartSuccess() {
            try {
                VlionMediaInitCallback vlionMediaInitCallback = this.f3964a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onSuccess();
                }
                q.this.f3963a = true;
                LogVlion.e("VlionKdSdk onInitSuccess ");
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static q a() {
        if (f3962b == null) {
            synchronized (q.class) {
                try {
                    if (f3962b == null) {
                        f3962b = new q();
                    }
                } finally {
                }
            }
        }
        return f3962b;
    }

    public final void b(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        if (vlionAdapterInitConfig != null) {
            try {
                LogVlion.e("VlionKdSdk getAppId() =" + vlionAdapterInitConfig.getAppId() + " isEnableLog=" + VlionSDkManager.getInstance().isEnableLog());
            } catch (Throwable th2) {
                LogVlion.e("VlionKdSdk initSDK Throwable=" + th2.getMessage());
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail(th2.getMessage());
                    return;
                }
                return;
            }
        }
        try {
            IFLYAdSDK.setParameter(AdKeys.DOWNLOAD_CONTROL, Boolean.TRUE);
            IFLYAdSDK.setPersonalizedState(!VlionSDkManager.getInstance().isEnablePersonalizedAdState() ? 1 : 0);
            LogVlion.e("VlionKdSdk IFLYAdSDK.start");
            IFLYAdSDK.initWithoutStart(application);
            IFLYAdSDK.start(new a(vlionMediaInitCallback));
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (!this.f3963a) {
                b(application, vlionAdapterInitConfig, vlionMediaInitCallback);
                return;
            }
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onSuccess();
            }
            LogVlion.e("VlionKdSdk initSDK  --isInitSuccess=");
        } catch (Throwable th2) {
            LogVlion.e("VlionKdSdk initSDK Throwable=" + th2.getMessage());
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
            this.f3963a = false;
        }
    }
}
