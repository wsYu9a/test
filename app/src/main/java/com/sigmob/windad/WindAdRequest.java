package com.sigmob.windad;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindAdRequest {

    /* renamed from: b */
    public String f20871b;

    /* renamed from: c */
    public String f20872c;

    /* renamed from: e */
    public String f20874e;

    /* renamed from: f */
    public Map<String, Object> f20875f;

    /* renamed from: g */
    public Map<String, Object> f20876g;

    /* renamed from: h */
    public boolean f20877h;

    /* renamed from: d */
    public int f20873d = 1;

    /* renamed from: a */
    public int f20870a = 1;

    public WindAdRequest(String str, String str2, Map<String, Object> map) {
        this.f20871b = str;
        this.f20872c = str2;
        this.f20875f = map;
    }

    public static boolean isPlacementEmpty(WindAdRequest windAdRequest) {
        return windAdRequest == null || TextUtils.isEmpty(windAdRequest.getPlacementId());
    }

    public int getAdCount() {
        return this.f20873d;
    }

    public int getAdType() {
        return this.f20870a;
    }

    public String getAdxId() {
        Map<String, Object> map = this.f20876g;
        if (map == null) {
            return null;
        }
        Object obj = map.get(WindAds.ADX_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String getLoadId() {
        Map<String, Object> map = this.f20876g;
        if (map == null) {
            return null;
        }
        Object obj = map.get(Constants.LOAD_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Map<String, Object> getOptions() {
        return this.f20875f;
    }

    public String getPlacementId() {
        return this.f20871b;
    }

    public String getUserId() {
        return this.f20872c;
    }

    public boolean hasOptions() {
        return this.f20875f != null;
    }

    public boolean isHalfInterstitial() {
        return this.f20877h;
    }

    public void setExtOptions(Map<String, Object> map) {
        this.f20876g = map;
    }

    public void setHalfInterstitial(boolean z10) {
        this.f20877h = z10;
    }

    public void setOptions(Map<String, Object> map) {
        this.f20875f = map;
    }

    public void setUserId(String str) {
        this.f20872c = str;
    }
}
