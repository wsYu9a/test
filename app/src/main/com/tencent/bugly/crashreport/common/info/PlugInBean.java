package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new c();

    /* renamed from: a */
    public final String f22279a;

    /* renamed from: b */
    public final String f22280b;

    /* renamed from: c */
    public final String f22281c;

    public PlugInBean(String str, String str2, String str3) {
        this.f22279a = str;
        this.f22280b = str2;
        this.f22281c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f22279a + " plV:" + this.f22280b + " plUUID:" + this.f22281c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f22279a);
        parcel.writeString(this.f22280b);
        parcel.writeString(this.f22281c);
    }

    public PlugInBean(Parcel parcel) {
        this.f22279a = parcel.readString();
        this.f22280b = parcel.readString();
        this.f22281c = parcel.readString();
    }
}
