package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public class aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22685a;

    /* renamed from: b */
    final /* synthetic */ String f22686b;

    /* renamed from: c */
    final /* synthetic */ String f22687c;

    public aa(String str, String str2, String str3) {
        this.f22685a = str;
        this.f22686b = str2;
        this.f22687c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.d(this.f22685a, this.f22686b, this.f22687c);
    }
}
