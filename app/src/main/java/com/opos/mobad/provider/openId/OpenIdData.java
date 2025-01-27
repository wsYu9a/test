package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class OpenIdData implements Parcelable {
    public static final Parcelable.Creator<OpenIdData> CREATOR = new Parcelable.Creator<OpenIdData>() { // from class: com.opos.mobad.provider.openId.OpenIdData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData createFromParcel(Parcel parcel) {
            return new OpenIdData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData[] newArray(int i2) {
            return new OpenIdData[i2];
        }
    };

    /* renamed from: a */
    public String f23135a;

    /* renamed from: b */
    public String f23136b;

    /* renamed from: c */
    public String f23137c;

    /* renamed from: com.opos.mobad.provider.openId.OpenIdData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<OpenIdData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData createFromParcel(Parcel parcel) {
            return new OpenIdData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData[] newArray(int i2) {
            return new OpenIdData[i2];
        }
    }

    OpenIdData(String str, String str2, String str3) {
        this.f23135a = str;
        this.f23136b = str2;
        this.f23137c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(TextUtils.isEmpty(this.f23135a) ? "" : this.f23135a);
        parcel.writeString(TextUtils.isEmpty(this.f23136b) ? "" : this.f23136b);
        parcel.writeString(TextUtils.isEmpty(this.f23137c) ? "" : this.f23137c);
    }
}
