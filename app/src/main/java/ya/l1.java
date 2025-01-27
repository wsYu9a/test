package ya;

import android.content.Context;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.martian.ads.ad.AdConfig;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.Map;

/* loaded from: classes3.dex */
public class l1 extends b8.p {

    /* renamed from: b */
    public static volatile boolean f33297b;

    public class a implements TTAdSdk.Callback {

        /* renamed from: a */
        public final /* synthetic */ TTAdSdk.Callback f33298a;

        public a(TTAdSdk.Callback callback) {
            this.f33298a = callback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i10, String str) {
            l1.f33297b = false;
            this.f33298a.fail(i10, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            this.f33298a.success();
        }
    }

    public class b extends TTCustomController {

        /* renamed from: b */
        public final /* synthetic */ boolean f33299b;

        public b(boolean z10) {
            this.f33299b = z10;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return !this.f33299b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getAndroidId() {
            return ConfigSingleton.D().j();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            return ConfigSingleton.D().A();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            return ConfigSingleton.D().M();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getMacAddress() {
            return this.f33299b ? super.getMacAddress() : ConfigSingleton.D().I();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public LocationProvider getTTLocation() {
            return super.getTTLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            return !this.f33299b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return super.isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePermissionRecordAudio() {
            return super.isCanUsePermissionRecordAudio();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return super.isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return !this.f33299b;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public Map<String, Object> userPrivacyConfig() {
            return super.userPrivacyConfig();
        }
    }

    public static TTAdConfig c() {
        return new TTAdConfig.Builder().appId(MiConfigSingleton.b2().f2().g(AdConfig.UnionType.CSJ, e0.f33164n)).appName(e0.f33138a).titleBarTheme(0).allowShowNotify(true).directDownloadNetworkType(4).debug(ConfigSingleton.D().B0()).customController(d()).supportMultiProcess(false).build();
    }

    public static TTCustomController d() {
        return new b(MiConfigSingleton.b2().C2());
    }

    public static void e(Context context, TTAdSdk.Callback callback) {
        if (!f33297b) {
            f33297b = true;
            synchronized (b8.p.class) {
                TTAdSdk.init(context, c());
                TTAdSdk.start(new a(callback));
            }
        }
        b8.p.f1450a = TTAdSdk.getAdManager();
    }
}
