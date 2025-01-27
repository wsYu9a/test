package com.bytedance.pangle.f.a;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    int[] f6109a = new int[32];

    /* renamed from: b, reason: collision with root package name */
    int f6110b;

    /* renamed from: c, reason: collision with root package name */
    int f6111c;

    public final void a() {
        b();
        int i2 = this.f6110b;
        int[] iArr = this.f6109a;
        iArr[i2] = 0;
        iArr[i2 + 1] = 0;
        this.f6110b = i2 + 2;
        this.f6111c++;
    }

    final void b() {
        int[] iArr = this.f6109a;
        int length = iArr.length;
        int i2 = this.f6110b;
        int i3 = length - i2;
        if (i3 <= 2) {
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f6109a = iArr2;
        }
    }
}
