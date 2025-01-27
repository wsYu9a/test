package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: classes.dex */
public class OnlineServiceWrapper extends BaseWrapper {

    /* renamed from: a */
    private static final String f6576a = "gr";

    protected OnlineServiceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OnlineServiceWrapper wrapper(Map<String, Object> map) {
        return new OnlineServiceWrapper(map);
    }

    public int getGrade() {
        try {
            return getInt(f6576a);
        } catch (ag | NumberFormatException unused) {
            return 0;
        }
    }

    public OnlineServiceWrapper setGrade(int i2) {
        return (OnlineServiceWrapper) set(f6576a, Integer.valueOf(i2));
    }
}
