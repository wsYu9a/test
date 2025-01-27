package com.sigmob.windad.Splash;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindSplashAdRequest extends WindAdRequest {

    /* renamed from: i */
    public int f20858i;

    /* renamed from: j */
    public boolean f20859j;

    public WindSplashAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f20858i = 5;
        this.f20859j = false;
        this.f20870a = 2;
    }

    public int getFetchDelay() {
        int i10 = this.f20858i;
        if (i10 < 3) {
            return 3;
        }
        return i10;
    }

    public boolean isDisableAutoHideAd() {
        return this.f20859j;
    }

    public void setDisableAutoHideAd(boolean z10) {
        this.f20859j = z10;
    }

    public void setFetchDelay(int i10) {
        this.f20858i = i10;
    }
}
