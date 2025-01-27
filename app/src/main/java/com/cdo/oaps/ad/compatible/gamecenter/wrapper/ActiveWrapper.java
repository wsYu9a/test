package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class ActiveWrapper extends IDWrapper {

    /* renamed from: a */
    final String f6530a;

    protected ActiveWrapper(Map<String, Object> map) {
        super(map);
        this.f6530a = OapsKey.KEY_ACTIVE_CODE;
    }

    public static ActiveWrapper wrapper(Map<String, Object> map) {
        return new ActiveWrapper(map);
    }

    public int getActiveCode() {
        try {
            return getInt(OapsKey.KEY_ACTIVE_CODE);
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public ActiveWrapper setActiveCode(int i2) {
        return (ActiveWrapper) set(OapsKey.KEY_ACTIVE_CODE, Integer.valueOf(i2));
    }
}
