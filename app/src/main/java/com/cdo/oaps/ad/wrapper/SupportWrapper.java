package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: classes.dex */
public class SupportWrapper extends BaseWrapper {
    protected SupportWrapper(Map<String, Object> map) {
        super(map);
    }

    public static SupportWrapper wrapper(Map<String, Object> map) {
        return new SupportWrapper(map);
    }

    public String getType() {
        try {
            return (String) get(OapsKey.KEY_TYPE);
        } catch (ag unused) {
            return "";
        }
    }

    public BaseWrapper setType(String str) {
        return (BaseWrapper) set(OapsKey.KEY_TYPE, str);
    }
}
