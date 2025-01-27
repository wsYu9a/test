package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindNewInterstitialAdRequest extends WindAdRequest {

    /* renamed from: i */
    public boolean f20903i;

    /* renamed from: j */
    public boolean f20904j;

    public WindNewInterstitialAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f20870a = 6;
    }

    public boolean isEnableKeepOn() {
        return this.f20904j;
    }

    public boolean isEnableScreenLockDisPlayAd() {
        return this.f20903i;
    }

    public void setEnableKeepOn(boolean z10) {
        this.f20904j = z10;
    }

    public void setEnableScreenLockDisPlayAd(boolean z10) {
        this.f20903i = z10;
    }
}
