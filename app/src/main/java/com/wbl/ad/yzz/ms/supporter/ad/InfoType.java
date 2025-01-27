package com.wbl.ad.yzz.ms.supporter.ad;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public enum InfoType {
    FEED(1),
    FEED_PRE_RENDER(2),
    BANNER(3),
    SPLASH(4),
    INTERSTITIAL(5),
    PASTER(6),
    REWARD(7),
    DRAW(8),
    FULL_SCREEN_VIDEO(9);

    private int value;

    InfoType(int i2) {
        this.value = i2;
    }

    public static InfoType valueOf(String str) {
        return (InfoType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11387, null, str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static InfoType[] valuesCustom() {
        return (InfoType[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11382, null, null);
    }

    public int value() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11381, this, null);
    }
}
