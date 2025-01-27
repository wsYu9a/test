package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
class aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f25025a;

    /* renamed from: b */
    final /* synthetic */ String f25026b;

    /* renamed from: c */
    final /* synthetic */ String f25027c;

    aa(String str, String str2, String str3) {
        this.f25025a = str;
        this.f25026b = str2;
        this.f25027c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.d(this.f25025a, this.f25026b, this.f25027c);
    }
}
