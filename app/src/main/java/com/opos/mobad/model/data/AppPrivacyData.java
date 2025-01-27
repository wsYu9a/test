package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AppPrivacyData extends a implements Parcelable {
    public static final Parcelable.Creator<AppPrivacyData> CREATOR = new Parcelable.Creator<AppPrivacyData>() { // from class: com.opos.mobad.model.data.AppPrivacyData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new AppPrivacyData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData[] newArray(int i2) {
            return new AppPrivacyData[i2];
        }
    };

    /* renamed from: a */
    public final String f21705a;

    /* renamed from: b */
    public final String f21706b;

    /* renamed from: c */
    public final String f21707c;

    /* renamed from: d */
    public final String f21708d;

    /* renamed from: com.opos.mobad.model.data.AppPrivacyData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AppPrivacyData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new AppPrivacyData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData[] newArray(int i2) {
            return new AppPrivacyData[i2];
        }
    }

    public AppPrivacyData(String str, String str2, String str3, String str4) {
        this.f21705a = str;
        this.f21706b = str2;
        this.f21707c = str3;
        this.f21708d = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppPrivacyData{permissionUrl=" + this.f21705a + ", privacyUrl='" + this.f21706b + "', developerName=" + this.f21707c + ", verName=" + this.f21708d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21705a);
        parcel.writeString(this.f21706b);
        parcel.writeString(this.f21707c);
        parcel.writeString(this.f21708d);
    }
}
