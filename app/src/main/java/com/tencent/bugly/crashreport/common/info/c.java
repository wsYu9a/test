package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
class c implements Parcelable.Creator<PlugInBean> {
    c() {
    }

    @Override // android.os.Parcelable.Creator
    public PlugInBean createFromParcel(Parcel parcel) {
        return new PlugInBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public PlugInBean[] newArray(int i2) {
        return new PlugInBean[i2];
    }
}
