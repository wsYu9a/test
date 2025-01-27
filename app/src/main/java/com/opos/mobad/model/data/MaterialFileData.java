package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class MaterialFileData extends a implements Parcelable {
    public static final Parcelable.Creator<MaterialFileData> CREATOR = new Parcelable.Creator<MaterialFileData>() { // from class: com.opos.mobad.model.data.MaterialFileData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(parcel.readString());
            materialFileData.b(parcel.readString());
            return materialFileData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData[] newArray(int i2) {
            return new MaterialFileData[i2];
        }
    };

    /* renamed from: a */
    private String f21737a;

    /* renamed from: b */
    private String f21738b;

    /* renamed from: com.opos.mobad.model.data.MaterialFileData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<MaterialFileData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(parcel.readString());
            materialFileData.b(parcel.readString());
            return materialFileData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialFileData[] newArray(int i2) {
            return new MaterialFileData[i2];
        }
    }

    public String a() {
        return this.f21737a;
    }

    public void a(String str) {
        this.f21737a = str;
    }

    public String b() {
        return this.f21738b;
    }

    public void b(String str) {
        this.f21738b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MaterialFileData{filePath='" + this.f21737a + "', md5='" + this.f21738b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21737a);
        parcel.writeString(this.f21738b);
    }
}
