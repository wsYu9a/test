package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes5.dex */
class OpenId {

    /* renamed from: a */
    long f35557a;

    /* renamed from: b */
    String f35558b;

    /* renamed from: c */
    String f35559c;

    /* renamed from: d */
    int f35560d;

    OpenId(String str) {
        this.f35559c = str;
    }

    void a(int i2) {
        this.f35560d = i2;
    }

    void a(long j2) {
        this.f35557a = j2;
    }

    void a(String str) {
        this.f35558b = str;
    }

    boolean a() {
        return this.f35557a > System.currentTimeMillis();
    }

    void b() {
        this.f35557a = 0L;
    }
}
