package cn.vlion.ad.inland.ta;

import android.app.Application;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.SettingConfig;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.ui.TanxSdk;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: b */
    public static volatile l f4061b;

    /* renamed from: a */
    public volatile boolean f4062a;

    public class a implements TanxInitListener {

        /* renamed from: a */
        public final /* synthetic */ VlionMediaInitCallback f4063a;

        public a(VlionMediaInitCallback vlionMediaInitCallback) {
            this.f4063a = vlionMediaInitCallback;
        }

        @Override // com.alimm.tanx.core.TanxInitListener
        public final void error(int i10, String str) {
            try {
                l.this.f4062a = false;
                VlionMediaInitCallback vlionMediaInitCallback = this.f4063a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("code=" + i10 + "error=" + str);
                }
                LogVlion.e("VlionTaSdk onInitFailure code=" + i10 + "error=" + str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.TanxInitListener
        public final void succ() {
            try {
                LogVlion.e("VlionTaSdk onInitSuccess ");
                l.this.f4062a = true;
                VlionMediaInitCallback vlionMediaInitCallback = this.f4063a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public final void b(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (vlionAdapterInitConfig != null) {
                LogVlion.e("VlionTaSdk getAppId() =" + vlionAdapterInitConfig.getAppId() + " vlionAdapterADConfig.getAppKey()=" + vlionAdapterInitConfig.getAppKey());
                TanxSdk.init(application, new TanxConfig.Builder().appName(VlionAppInfo.getInstance().getAppName(application)).appId(vlionAdapterInitConfig.getAppId()).appKey(vlionAdapterInitConfig.getAppKey()).appSecret(vlionAdapterInitConfig.getAppSecret()).imei(VlionPrivateInfo.getImei()).oaid(VlionPrivateInfo.getOaid()).oaidSwitch(true).imeiSwitch(VlionPrivateInfo.isCanUsePhoneState()).netDebug(false).debug(true).dark(new SettingConfig().setNightConfig()).build(), new a(vlionMediaInitCallback));
            } else {
                LogVlion.e("VlionTaSdk vlionAdapterADConfig is null");
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail("vlionAdapterADConfig is null");
                }
            }
        } catch (Throwable th2) {
            LogVlion.e("VlionTaSdk initSDK Throwable=" + th2.getMessage());
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
        }
    }

    public static l a() {
        if (f4061b == null) {
            synchronized (l.class) {
                try {
                    if (f4061b == null) {
                        f4061b = new l();
                    }
                } finally {
                }
            }
        }
        return f4061b;
    }

    public final void a(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            if (!this.f4062a) {
                b(application, vlionAdapterInitConfig, vlionMediaInitCallback);
                return;
            }
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onSuccess();
            }
            LogVlion.e("VlionTaSdk initSDK  --isInitSuccess=");
        } catch (Throwable th2) {
            LogVlion.e("VlionTaSdk initSDK Throwable=" + th2.getMessage());
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onFail(th2.getMessage());
            }
            this.f4062a = false;
        }
    }
}
