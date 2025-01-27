package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public class Z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22682a;

    /* renamed from: b */
    final /* synthetic */ String f22683b;

    /* renamed from: c */
    final /* synthetic */ String f22684c;

    public Z(String str, String str2, String str3) {
        this.f22682a = str;
        this.f22683b = str2;
        this.f22684c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.f(this.f22682a, this.f22683b, this.f22684c);
    }
}
