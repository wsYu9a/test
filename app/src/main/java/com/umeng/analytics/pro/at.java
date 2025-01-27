package com.umeng.analytics.pro;

/* loaded from: classes4.dex */
public class at {

    /* renamed from: a */
    private short[] f25703a;

    /* renamed from: b */
    private int f25704b = -1;

    public at(int i2) {
        this.f25703a = new short[i2];
    }

    private void d() {
        short[] sArr = this.f25703a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f25703a = sArr2;
    }

    public short a() {
        short[] sArr = this.f25703a;
        int i2 = this.f25704b;
        this.f25704b = i2 - 1;
        return sArr[i2];
    }

    public short b() {
        return this.f25703a[this.f25704b];
    }

    public void c() {
        this.f25704b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.f25703a.length; i2++) {
            if (i2 != 0) {
                sb.append(" ");
            }
            if (i2 == this.f25704b) {
                sb.append(">>");
            }
            sb.append((int) this.f25703a[i2]);
            if (i2 == this.f25704b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.f25703a.length == this.f25704b + 1) {
            d();
        }
        short[] sArr = this.f25703a;
        int i2 = this.f25704b + 1;
        this.f25704b = i2;
        sArr[i2] = s;
    }
}
