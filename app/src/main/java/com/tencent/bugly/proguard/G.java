package com.tencent.bugly.proguard;

import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f22595a;

    /* renamed from: b */
    final /* synthetic */ H f22596b;

    public G(H h10, int i10) {
        this.f22596b = h10;
        this.f22595a = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b10;
        SharedPreferences sharedPreferences;
        String str;
        b10 = this.f22596b.b(this.f22595a);
        sharedPreferences = this.f22596b.f22602f;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f22595a);
        sb2.append(hf.e.f26694a);
        str = this.f22596b.f22600d;
        sb2.append(str);
        edit.putBoolean(sb2.toString(), !b10).commit();
    }
}
