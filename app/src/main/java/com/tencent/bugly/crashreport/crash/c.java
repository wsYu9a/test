package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
class c implements Parcelable.Creator<CrashDetailBean> {
    c() {
    }

    @Override // android.os.Parcelable.Creator
    public CrashDetailBean createFromParcel(Parcel parcel) {
        return new CrashDetailBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public CrashDetailBean[] newArray(int i2) {
        return new CrashDetailBean[i2];
    }
}
