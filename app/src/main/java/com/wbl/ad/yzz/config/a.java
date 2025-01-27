package com.wbl.ad.yzz.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.wbl.ad.yzz.adit.f;
import f.b.a.e;

/* loaded from: classes5.dex */
public final class a implements f {
    @Override // com.wbl.ad.yzz.adit.f
    public boolean a() {
        Log.e("AdInitialize", "isEnableLog 空实现");
        return false;
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(boolean z) {
        Log.e("AdInitialize", "setAutoPlayMuted 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public boolean b() {
        return false;
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(boolean z) {
        Log.e("AdInitialize", "enableLog 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(boolean z, @e String str) {
        Log.e("AdInitialize", "enableLog 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(@e Activity activity, @e PageOptions pageOptions) {
        Log.e("AdInitialize", "checkNextChapter 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(@e String str) {
        Log.e("AdInitialize", "debugLog 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(boolean z) {
        Log.e("AdInitialize", "sdkVersionName 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(@e String str) {
        Log.e("AdInitialize", "setAppChannel 空实现 " + str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c() {
        Log.e("AdInitialize", "willShowAd 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(Application application, AdInitConfig adInitConfig) {
        Log.e("AdInitialize", "initialize config 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(@e Activity activity, @e PageOptions pageOptions) {
        Log.e("AdInitialize", "startAdPage 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e IAdEventListener iAdEventListener) {
        Log.e("AdInitialize", "setAdEventListener 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e IPersonalAdSettingListener iPersonalAdSettingListener) {
        Log.e("AdInitialize", "setPersonalAdSettingListener 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e Context context) {
        Log.e("AdInitialize", "requestPermission 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(int i2) {
        Log.e("AdInitialize", "setUserType 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e Activity activity, @e PageOptions pageOptions) {
        Log.e("AdInitialize", "turningUpADPage 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e IConfigAdFilter iConfigAdFilter) {
        Log.e("AdInitialize", "setAdFilterCall 空实现");
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e Activity activity, @e String str) {
        Log.e("AdInitialize", "openWalletPage 空实现" + str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e String str) {
        Log.e("AdInitialize", "membershipApplySucceed 空实现 " + str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(@e OnAdClickListener onAdClickListener) {
        Log.e("AdInitialize", "setOnAdClickListener 空实现 ");
    }
}
