package b.a.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.vivo.mobilead.manager.e;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.x0;

/* loaded from: classes.dex */
public class c implements b.a.a.a.b<TTAdConfig> {

    /* renamed from: a */
    private String f4165a;

    /* renamed from: b */
    private String f4166b;

    /* renamed from: c */
    private String f4167c;

    /* renamed from: d */
    private String f4168d;

    @Override // b.a.a.a.b
    public boolean a() {
        return !TextUtils.isEmpty(this.f4165a) && TextUtils.equals(this.f4165a, e.c().a());
    }

    @Override // b.a.a.a.b
    /* renamed from: c */
    public void b(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null) {
            try {
                this.f4165a = tTAdConfig.getAppId();
            } catch (Exception e2) {
                x0.e("TTInitWatcher", "onInit: " + e2.getMessage());
            }
        }
        if (a()) {
            return;
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        this.f4166b = packageInfo.packageName;
        this.f4167c = packageInfo.versionName;
        this.f4168d = String.valueOf(packageInfo.versionCode);
        k0.a(1, this.f4165a, this.f4166b, this.f4167c, this.f4168d);
    }

    @Override // b.a.a.a.b
    public String getAppId() {
        return this.f4165a;
    }

    @Override // b.a.a.a.b
    public String getPackageName() {
        return this.f4166b;
    }

    @Override // b.a.a.a.b
    public String getVersionCode() {
        return this.f4168d;
    }

    @Override // b.a.a.a.b
    public String getVersionName() {
        return this.f4167c;
    }
}
