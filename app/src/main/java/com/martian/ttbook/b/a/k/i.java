package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class i extends h {

    /* renamed from: b */
    private Context f15062b;

    /* renamed from: a */
    private String f15061a = "devyok.DATA_PROVIDER";

    /* renamed from: c */
    private int f15063c = 1;

    public i(Context context) {
        this.f15062b = context;
    }

    private void i(SharedPreferences.Editor editor) {
        int i2 = this.f15063c;
        if (i2 != 1 && i2 == 2) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    @Override // com.martian.ttbook.b.a.k.h
    public String c(String str, String str2) {
        return h().getString(str, str2);
    }

    @Override // com.martian.ttbook.b.a.k.h
    public boolean d(String str) {
        return h().edit().remove(str).commit();
    }

    @Override // com.martian.ttbook.b.a.k.h
    public void e(String str, String str2) {
        SharedPreferences.Editor edit = h().edit();
        edit.putString(str, str2);
        i(edit);
    }

    @Override // com.martian.ttbook.b.a.k.h
    public boolean f(String str) {
        return h().contains(str);
    }

    @Override // com.martian.ttbook.b.a.k.h
    public void g(String str) {
        this.f15061a = str;
    }

    SharedPreferences h() {
        return this.f15062b.getSharedPreferences(this.f15061a, 0);
    }
}
