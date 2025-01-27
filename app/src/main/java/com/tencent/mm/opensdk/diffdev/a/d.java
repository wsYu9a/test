package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes4.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* renamed from: a */
    private int f25361a;

    d(int i2) {
        this.f25361a = i2;
    }

    public int a() {
        return this.f25361a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f25361a;
    }
}
