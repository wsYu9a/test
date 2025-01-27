package com.kwad.sdk;

import com.alimm.tanx.core.constant.AdType;

/* loaded from: classes3.dex */
public final class e {
    public static final e anK = new e(10000, "其他异常");
    public static final e anL = new e(10001, "初始化参数异常");
    public static final e anM = new e(AdType.COMMON_AD, "SDK未调用init方法");
    public int code;
    public String msg;

    public e(int i10, String str) {
        this.code = i10;
        this.msg = str;
    }
}
