package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class i extends h {

    /* renamed from: b */
    private Context f4715b;

    /* renamed from: a */
    private String f4714a = "devyok.DATA_PROVIDER";

    /* renamed from: c */
    private int f4716c = 1;

    public i(Context context) {
        this.f4715b = context;
    }

    public SharedPreferences a() {
        return this.f4715b.getSharedPreferences(this.f4714a, 0);
    }

    @Override // com.aggmoread.sdk.z.b.m.h
    public void b(String str, String str2) {
        SharedPreferences.Editor edit = a().edit();
        edit.putString(str, str2);
        a(edit);
    }

    @Override // com.aggmoread.sdk.z.b.m.h
    public void c(String str) {
        this.f4714a = str;
    }

    @Override // com.aggmoread.sdk.z.b.m.h
    public String a(String str, String str2) {
        return a().getString(str, str2);
    }

    @Override // com.aggmoread.sdk.z.b.m.h
    public boolean b(String str) {
        return a().contains(str);
    }

    private void a(SharedPreferences.Editor editor) {
        int i10 = this.f4716c;
        if (i10 != 1 && i10 == 2) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    @Override // com.aggmoread.sdk.z.b.m.h
    public boolean a(String str) {
        return a().edit().remove(str).commit();
    }
}
