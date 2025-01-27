package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class g implements Parcelable.Creator<UserInfoBean> {
    @Override // android.os.Parcelable.Creator
    public UserInfoBean createFromParcel(Parcel parcel) {
        return new UserInfoBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public UserInfoBean[] newArray(int i10) {
        return new UserInfoBean[i10];
    }
}
