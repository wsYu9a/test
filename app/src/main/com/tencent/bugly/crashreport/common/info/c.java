package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class c implements Parcelable.Creator<PlugInBean> {
    @Override // android.os.Parcelable.Creator
    public PlugInBean createFromParcel(Parcel parcel) {
        return new PlugInBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public PlugInBean[] newArray(int i10) {
        return new PlugInBean[i10];
    }
}
