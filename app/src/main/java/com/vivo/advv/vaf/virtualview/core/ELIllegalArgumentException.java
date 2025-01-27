package com.vivo.advv.vaf.virtualview.core;

/* loaded from: classes4.dex */
public class ELIllegalArgumentException extends IllegalArgumentException {
    public static final int CODE_KEY_ERROR = 1;
    public static final int CODE_VALUE_ERROR = 2;
    private int mCode;

    public ELIllegalArgumentException(int i2, String str) {
        super(str);
        this.mCode = i2;
    }
}
