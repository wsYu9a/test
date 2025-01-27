package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class cu implements Serializable {

    /* renamed from: a */
    private final boolean f23764a;

    /* renamed from: b */
    public final byte f23765b;

    /* renamed from: c */
    private final String f23766c;

    /* renamed from: d */
    private final boolean f23767d;

    public cu(byte b10, boolean z10) {
        this.f23765b = b10;
        this.f23764a = false;
        this.f23766c = null;
        this.f23767d = z10;
    }

    public boolean a() {
        return this.f23764a;
    }

    public String b() {
        return this.f23766c;
    }

    public boolean c() {
        return this.f23765b == 12;
    }

    public boolean d() {
        byte b10 = this.f23765b;
        return b10 == 15 || b10 == 13 || b10 == 14;
    }

    public boolean e() {
        return this.f23767d;
    }

    public cu(byte b10) {
        this(b10, false);
    }

    public cu(byte b10, String str) {
        this.f23765b = b10;
        this.f23764a = true;
        this.f23766c = str;
        this.f23767d = false;
    }
}
