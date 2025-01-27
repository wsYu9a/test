package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class StrategyWrapper extends IDWrapper {

    /* renamed from: a */
    final String f6531a;

    protected StrategyWrapper(Map<String, Object> map) {
        super(map);
        this.f6531a = "tab";
    }

    public static StrategyWrapper wrapper(Map<String, Object> map) {
        return new StrategyWrapper(map);
    }

    public int getTab() {
        try {
            return getInt("tab");
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public StrategyWrapper setTab(int i2) {
        return (StrategyWrapper) set("tab", Integer.valueOf(i2));
    }
}
