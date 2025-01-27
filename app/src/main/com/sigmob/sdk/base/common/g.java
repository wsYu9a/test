package com.sigmob.sdk.base.common;

import android.os.Parcel;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    public int f17759a;

    /* renamed from: b */
    public int f17760b;

    public g(int i10, int i11) {
        this.f17759a = i10;
        this.f17760b = i11;
    }

    public int a() {
        return this.f17760b;
    }

    public int b() {
        return this.f17759a;
    }

    public g(Parcel parcel) {
        this.f17759a = parcel.readInt();
        this.f17760b = parcel.readInt();
    }

    public void a(int i10) {
        this.f17760b = i10;
    }

    public void b(int i10) {
        this.f17759a = i10;
    }
}
