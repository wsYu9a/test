package com.opos.mobad.ad.privacy;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class ComplianceInfo implements Parcelable {
    public static final Parcelable.Creator<ComplianceInfo> CREATOR = new Parcelable.Creator<ComplianceInfo>() { // from class: com.opos.mobad.ad.privacy.ComplianceInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ComplianceInfo complianceInfo = new ComplianceInfo();
            complianceInfo.a(parcel.readString());
            complianceInfo.b(parcel.readString());
            complianceInfo.a(parcel.readHashMap(HashMap.class.getClassLoader()));
            return complianceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo[] newArray(int i2) {
            return new ComplianceInfo[i2];
        }
    };

    /* renamed from: a */
    private String f19507a;

    /* renamed from: b */
    private String f19508b;

    /* renamed from: c */
    private Map<String, String> f19509c;

    /* renamed from: com.opos.mobad.ad.privacy.ComplianceInfo$1 */
    class AnonymousClass1 implements Parcelable.Creator<ComplianceInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ComplianceInfo complianceInfo = new ComplianceInfo();
            complianceInfo.a(parcel.readString());
            complianceInfo.b(parcel.readString());
            complianceInfo.a(parcel.readHashMap(HashMap.class.getClassLoader()));
            return complianceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo[] newArray(int i2) {
            return new ComplianceInfo[i2];
        }
    }

    private ComplianceInfo() {
    }

    /* synthetic */ ComplianceInfo(AnonymousClass1 anonymousClass1) {
        this();
    }

    public ComplianceInfo(String str, String str2) {
        this.f19507a = str;
        this.f19508b = str2;
    }

    public String a() {
        return this.f19507a;
    }

    public void a(String str) {
        this.f19507a = str;
    }

    public void a(HashMap<String, String> hashMap) {
        this.f19509c = hashMap;
    }

    public String b() {
        return this.f19508b;
    }

    public void b(String str) {
        this.f19508b = str;
    }

    public Map<String, String> c() {
        return this.f19509c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ComplianceInfo{privacyUrl='" + this.f19507a + "', permissionUrl='" + this.f19508b + "', permissionMap=" + this.f19509c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19507a);
        parcel.writeString(this.f19508b);
        parcel.writeMap(this.f19509c);
    }
}
