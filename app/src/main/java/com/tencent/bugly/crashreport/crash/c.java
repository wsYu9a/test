package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class c implements Parcelable.Creator<CrashDetailBean> {
    @Override // android.os.Parcelable.Creator
    public CrashDetailBean createFromParcel(Parcel parcel) {
        return new CrashDetailBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public CrashDetailBean[] newArray(int i10) {
        return new CrashDetailBean[i10];
    }
}
