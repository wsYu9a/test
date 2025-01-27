package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindNativeAdRequest extends WindAdRequest {
    @Deprecated
    public WindNativeAdRequest(String str, String str2, int i10, Map<String, Object> map) {
        super(str, str2, map);
        this.f20873d = i10;
        this.f20870a = 5;
    }

    public static WindNativeAdRequest getWindVideoAdRequest(WindAdRequest windAdRequest) {
        if (windAdRequest != null) {
            return new WindNativeAdRequest(windAdRequest.getPlacementId(), windAdRequest.getUserId(), 1, windAdRequest.getOptions());
        }
        return null;
    }

    public WindNativeAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f20870a = 5;
    }
}
