package cn.vlion.ad.inland.jd;

import android.app.Application;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.jd.ad.sdk.bl.initsdk.JADInitCallback;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static volatile e f3835a;

    public class a implements JADInitCallback {

        /* renamed from: a */
        public final /* synthetic */ VlionMediaInitCallback f3836a;

        public a(VlionMediaInitCallback vlionMediaInitCallback) {
            this.f3836a = vlionMediaInitCallback;
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADInitCallback
        public final void onInitFailure(int i10, String str) {
            try {
                VlionMediaInitCallback vlionMediaInitCallback = this.f3836a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("code=" + i10 + "error=" + str);
                }
                LogVlion.e("VlionJdSdk onInitFailure code=" + i10 + "error=" + str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.bl.initsdk.JADInitCallback
        public final void onInitSuccess() {
            try {
                LogVlion.e("VlionJdSdk onInitSuccess ");
                VlionMediaInitCallback vlionMediaInitCallback = this.f3836a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static e a() {
        if (f3835a == null) {
            synchronized (e.class) {
                try {
                    if (f3835a == null) {
                        f3835a = new e();
                    }
                } finally {
                }
            }
        }
        return f3835a;
    }

    public static void b(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            JADYunSdkConfig.Builder builder = new JADYunSdkConfig.Builder();
            if (vlionAdapterInitConfig != null) {
                LogVlion.e("VlionJdSdk getAppId() =" + vlionAdapterInitConfig.getAppId() + " isEnableLog=" + VlionSDkManager.getInstance().isEnableLog());
                builder.setAppId(vlionAdapterInitConfig.getAppId()).setEnableLog(VlionSDkManager.getInstance().isEnableLog()).setPrivateController(new f());
            } else {
                LogVlion.e("VlionJdSdk vlionAdapterADConfig is null");
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("vlionAdapterADConfig is null");
                }
            }
            JADYunSdk.asyncInit(application, builder.build(), new a(vlionMediaInitCallback));
        } catch (Throwable th2) {
            LogVlion.e("VlionJdSdk initSDK Throwable=" + th2.getMessage());
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
        }
    }

    public static void a(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (!JADYunSdk.isInitSuccess()) {
                b(application, vlionAdapterInitConfig, vlionMediaInitCallback);
                return;
            }
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onSuccess();
            }
            LogVlion.e("VlionJdSdk initSDK  --isInitSuccess=");
        } catch (Throwable th2) {
            LogVlion.e("VlionJdSdk initSDK Throwable=" + th2.getMessage());
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
        }
    }
}
