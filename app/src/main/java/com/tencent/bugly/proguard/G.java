package com.tencent.bugly.proguard;

import android.content.SharedPreferences;

/* loaded from: classes4.dex */
class G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24954a;

    /* renamed from: b */
    final /* synthetic */ H f24955b;

    G(H h2, int i2) {
        this.f24955b = h2;
        this.f24954a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        SharedPreferences sharedPreferences;
        String str;
        b2 = this.f24955b.b(this.f24954a);
        sharedPreferences = this.f24955b.f24961f;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24954a);
        sb.append("_");
        str = this.f24955b.f24959d;
        sb.append(str);
        edit.putBoolean(sb.toString(), !b2).commit();
    }
}
