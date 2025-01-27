package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
final class by implements Parcelable.Creator<bx> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bx createFromParcel(Parcel parcel) {
        return new bx(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bx[] newArray(int i10) {
        return new bx[i10];
    }
}
