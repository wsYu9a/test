package com.sigmob.sdk.base.services;

import android.content.Context;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.IntentUtil;
import com.sigmob.sdk.base.services.j;

/* loaded from: classes4.dex */
public class l implements j.a {

    /* renamed from: b */
    public k f18397b = k.STOP;

    /* renamed from: a */
    public WifiScanReceiver f18396a = new WifiScanReceiver();

    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        IntentUtil.registerReceiver(context, this.f18396a, intentFilter);
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void b() {
        if (this.f18397b == k.RUNNING) {
            b(com.sigmob.sdk.a.d());
            this.f18397b = k.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k c() {
        return this.f18397b;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error d() {
        return null;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean a() {
        k kVar = this.f18397b;
        k kVar2 = k.RUNNING;
        if (kVar == kVar2) {
            return false;
        }
        a(com.sigmob.sdk.a.d());
        this.f18397b = kVar2;
        return true;
    }

    public void b(Context context) {
        context.unregisterReceiver(this.f18396a);
    }
}
