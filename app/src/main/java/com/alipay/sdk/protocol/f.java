package com.alipay.sdk.protocol;

/* loaded from: classes.dex */
public enum f {
    SUCCESS("0"),
    TID_REFRESH("tid_refresh_invalid"),
    POP_TYPE("pop_type"),
    NOT_POP_TYPE("not_pop_type");


    /* renamed from: e, reason: collision with root package name */
    private String f5426e;

    f(String str) {
        this.f5426e = str;
    }

    public static f a(String str) {
        f fVar = null;
        for (f fVar2 : values()) {
            if (str.startsWith(fVar2.f5426e)) {
                fVar = fVar2;
            }
        }
        return fVar;
    }

    private String a() {
        return this.f5426e;
    }
}
