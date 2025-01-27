package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
class a implements Parcelable.Creator<StrategyBean> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    public StrategyBean createFromParcel(Parcel parcel) {
        return new StrategyBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public StrategyBean[] newArray(int i2) {
        return new StrategyBean[i2];
    }
}
