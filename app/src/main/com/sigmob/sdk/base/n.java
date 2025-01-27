package com.sigmob.sdk.base;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class n extends WindAdRequest {
    public n(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f20870a = 1;
    }

    @Deprecated
    public n(String str, String str2, boolean z10, Map<String, Object> map) {
        this(str, str2, map);
        this.f20870a = z10 ? 1 : 4;
    }
}
