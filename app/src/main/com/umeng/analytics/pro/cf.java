package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class cf {

    /* renamed from: a */
    private short[] f23731a;

    /* renamed from: b */
    private int f23732b = -1;

    public cf(int i10) {
        this.f23731a = new short[i10];
    }

    private void d() {
        short[] sArr = this.f23731a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f23731a = sArr2;
    }

    public short a() {
        short[] sArr = this.f23731a;
        int i10 = this.f23732b;
        this.f23732b = i10 - 1;
        return sArr[i10];
    }

    public short b() {
        return this.f23731a[this.f23732b];
    }

    public void c() {
        this.f23732b = -1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<ShortStack vector:[");
        for (int i10 = 0; i10 < this.f23731a.length; i10++) {
            if (i10 != 0) {
                sb2.append(" ");
            }
            if (i10 == this.f23732b) {
                sb2.append(">>");
            }
            sb2.append((int) this.f23731a[i10]);
            if (i10 == this.f23732b) {
                sb2.append("<<");
            }
        }
        sb2.append("]>");
        return sb2.toString();
    }

    public void a(short s10) {
        if (this.f23731a.length == this.f23732b + 1) {
            d();
        }
        short[] sArr = this.f23731a;
        int i10 = this.f23732b + 1;
        this.f23732b = i10;
        sArr[i10] = s10;
    }
}
