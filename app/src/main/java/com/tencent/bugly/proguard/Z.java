package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
class Z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f25022a;

    /* renamed from: b */
    final /* synthetic */ String f25023b;

    /* renamed from: c */
    final /* synthetic */ String f25024c;

    Z(String str, String str2, String str3) {
        this.f25022a = str;
        this.f25023b = str2;
        this.f25024c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.f(this.f25022a, this.f25023b, this.f25024c);
    }
}
