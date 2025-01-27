package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new c();

    /* renamed from: a */
    public final String f24745a;

    /* renamed from: b */
    public final String f24746b;

    /* renamed from: c */
    public final String f24747c;

    public PlugInBean(String str, String str2, String str3) {
        this.f24745a = str;
        this.f24746b = str2;
        this.f24747c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f24745a + " plV:" + this.f24746b + " plUUID:" + this.f24747c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f24745a);
        parcel.writeString(this.f24746b);
        parcel.writeString(this.f24747c);
    }

    public PlugInBean(Parcel parcel) {
        this.f24745a = parcel.readString();
        this.f24746b = parcel.readString();
        this.f24747c = parcel.readString();
    }
}
