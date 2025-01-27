package com.nostra13.universalimageloader.core.assist;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final int f15917a = 9;

    /* renamed from: b */
    private static final String f15918b = "x";

    /* renamed from: c */
    private final int f15919c;

    /* renamed from: d */
    private final int f15920d;

    public c(int i2, int i3) {
        this.f15919c = i2;
        this.f15920d = i3;
    }

    public int a() {
        return this.f15920d;
    }

    public int b() {
        return this.f15919c;
    }

    public c c(float f2) {
        return new c((int) (this.f15919c * f2), (int) (this.f15920d * f2));
    }

    public c d(int i2) {
        return new c(this.f15919c / i2, this.f15920d / i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f15919c);
        sb.append(f15918b);
        sb.append(this.f15920d);
        return sb.toString();
    }

    public c(int i2, int i3, int i4) {
        if (i4 % TinkerReport.KEY_APPLIED_VERSION_CHECK == 0) {
            this.f15919c = i2;
            this.f15920d = i3;
        } else {
            this.f15919c = i3;
            this.f15920d = i2;
        }
    }
}
