package com.bytedance.pangle.f.a;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    int[] f7611a = new int[32];

    /* renamed from: b, reason: collision with root package name */
    int f7612b;

    /* renamed from: c, reason: collision with root package name */
    int f7613c;

    public final void a() {
        b();
        int i10 = this.f7612b;
        int[] iArr = this.f7611a;
        iArr[i10] = 0;
        iArr[i10 + 1] = 0;
        this.f7612b = i10 + 2;
        this.f7613c++;
    }

    public final void b() {
        int[] iArr = this.f7611a;
        int length = iArr.length;
        int i10 = this.f7612b;
        int i11 = length - i10;
        if (i11 <= 2) {
            int[] iArr2 = new int[(iArr.length + i11) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            this.f7611a = iArr2;
        }
    }
}
