package com.opos.mobad.d.a;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final String f20394a;

    /* renamed from: b */
    public final String f20395b;

    /* renamed from: c */
    public final int f20396c;

    /* renamed from: d */
    public int f20397d = 0;

    /* renamed from: e */
    public int f20398e;

    /* renamed from: f */
    public d f20399f;

    public b(String str, String str2, int i2, d dVar) {
        this.f20394a = str;
        this.f20395b = str2;
        this.f20396c = i2;
        this.f20399f = dVar;
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f20395b) || !str.equals(this.f20395b)) ? false : true;
    }
}
