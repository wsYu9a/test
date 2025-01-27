package com.vivo.mobilead.lottie.d;

/* loaded from: classes4.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");


    /* renamed from: c */
    public final String f29413c;

    a(String str) {
        this.f29413c = str;
    }

    public String a() {
        return ".temp" + this.f29413c;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f29413c;
    }
}
