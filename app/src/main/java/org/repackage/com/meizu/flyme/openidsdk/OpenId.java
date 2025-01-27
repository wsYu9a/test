package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes4.dex */
class OpenId {

    /* renamed from: a */
    long f29367a;

    /* renamed from: b */
    String f29368b;

    /* renamed from: c */
    String f29369c;

    /* renamed from: d */
    int f29370d;

    public OpenId(String str) {
        this.f29369c = str;
    }

    public void a(int i10) {
        this.f29370d = i10;
    }

    public void b() {
        this.f29367a = 0L;
    }

    public void a(long j10) {
        this.f29367a = j10;
    }

    public void a(String str) {
        this.f29368b = str;
    }

    public boolean a() {
        return this.f29367a > System.currentTimeMillis();
    }
}
