package b.a.a.a.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

/* loaded from: classes.dex */
public class a implements TTAdManager {

    /* renamed from: a */
    private final TTAdManager f4163a;

    public a(TTAdManager tTAdManager) {
        this.f4163a = tTAdManager;
    }

    public boolean a(String str, int i2, String str2, String str3, String str4) {
        return this.f4163a.onlyVerityPlayable(str, i2, str2, str3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        TTAdNative createAdNative = this.f4163a.createAdNative(context);
        return b.a.a.a.a.b().a(1).a() ? createAdNative : new b(createAdNative);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        return this.f4163a.getBiddingToken(adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(Class<T> cls, Bundle bundle) {
        return (T) this.f4163a.getExtra(cls, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        return this.f4163a.getPluginVersion();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return this.f4163a.getSDKVersion();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        return this.f4163a.getThemeStatus();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(Object obj) {
        this.f4163a.register(obj);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        this.f4163a.requestPermissionIfNecessary(context);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        this.f4163a.setThemeStatus(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return this.f4163a.tryShowInstallDialogWhenExit(activity, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        this.f4163a.unregister(obj);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        return this.f4163a.getBiddingToken(adSlot, z, i2);
    }
}
