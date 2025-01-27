package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class bi implements Serializable {

    /* renamed from: a */
    private final boolean f25738a;

    /* renamed from: b */
    public final byte f25739b;

    /* renamed from: c */
    private final String f25740c;

    /* renamed from: d */
    private final boolean f25741d;

    public bi(byte b2, boolean z) {
        this.f25739b = b2;
        this.f25738a = false;
        this.f25740c = null;
        this.f25741d = z;
    }

    public boolean a() {
        return this.f25738a;
    }

    public String b() {
        return this.f25740c;
    }

    public boolean c() {
        return this.f25739b == 12;
    }

    public boolean d() {
        byte b2 = this.f25739b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f25741d;
    }

    public bi(byte b2) {
        this(b2, false);
    }

    public bi(byte b2, String str) {
        this.f25739b = b2;
        this.f25738a = true;
        this.f25740c = str;
        this.f25741d = false;
    }
}
