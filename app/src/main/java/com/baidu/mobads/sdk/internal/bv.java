package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bv implements Parcelable.Creator<bu> {
    bv() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bu createFromParcel(Parcel parcel) {
        return new bu(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bu[] newArray(int i2) {
        return new bu[i2];
    }
}
