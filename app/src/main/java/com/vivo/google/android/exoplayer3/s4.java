package com.vivo.google.android.exoplayer3;

import android.text.Layout;

/* loaded from: classes4.dex */
public final class s4 {

    /* renamed from: a */
    public String f28047a;

    /* renamed from: b */
    public int f28048b;

    /* renamed from: c */
    public boolean f28049c;

    /* renamed from: d */
    public int f28050d;

    /* renamed from: e */
    public boolean f28051e;

    /* renamed from: f */
    public int f28052f = -1;

    /* renamed from: g */
    public int f28053g = -1;

    /* renamed from: h */
    public int f28054h = -1;

    /* renamed from: i */
    public int f28055i = -1;

    /* renamed from: j */
    public int f28056j = -1;
    public float k;
    public String l;
    public Layout.Alignment m;

    public int a() {
        int i2 = this.f28054h;
        if (i2 == -1 && this.f28055i == -1) {
            return -1;
        }
        return (i2 == 1 ? 1 : 0) | (this.f28055i == 1 ? 2 : 0);
    }

    public s4 a(s4 s4Var) {
        if (s4Var != null) {
            if (!this.f28049c && s4Var.f28049c) {
                int i2 = s4Var.f28048b;
                g1.b(true);
                this.f28048b = i2;
                this.f28049c = true;
            }
            if (this.f28054h == -1) {
                this.f28054h = s4Var.f28054h;
            }
            if (this.f28055i == -1) {
                this.f28055i = s4Var.f28055i;
            }
            if (this.f28047a == null) {
                this.f28047a = s4Var.f28047a;
            }
            if (this.f28052f == -1) {
                this.f28052f = s4Var.f28052f;
            }
            if (this.f28053g == -1) {
                this.f28053g = s4Var.f28053g;
            }
            if (this.m == null) {
                this.m = s4Var.m;
            }
            if (this.f28056j == -1) {
                this.f28056j = s4Var.f28056j;
                this.k = s4Var.k;
            }
            if (!this.f28051e && s4Var.f28051e) {
                this.f28050d = s4Var.f28050d;
                this.f28051e = true;
            }
        }
        return this;
    }
}
