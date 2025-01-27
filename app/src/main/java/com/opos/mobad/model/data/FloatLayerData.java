package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.r;
import java.util.List;

/* loaded from: classes4.dex */
public class FloatLayerData extends a implements Parcelable {
    public static final Parcelable.Creator<FloatLayerData> CREATOR = new Parcelable.Creator<FloatLayerData>() { // from class: com.opos.mobad.model.data.FloatLayerData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            FloatLayerData floatLayerData = new FloatLayerData();
            floatLayerData.a((MaterialFileData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            floatLayerData.a(parcel.readString());
            floatLayerData.b(parcel.readString());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            floatLayerData.a(parcel.createTypedArrayList(creator));
            floatLayerData.f21715e = parcel.createTypedArrayList(creator);
            return floatLayerData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData[] newArray(int i2) {
            return new FloatLayerData[i2];
        }
    };

    /* renamed from: a */
    private MaterialFileData f21711a;

    /* renamed from: b */
    private String f21712b;

    /* renamed from: c */
    private String f21713c;

    /* renamed from: d */
    private List<MaterialFileData> f21714d;

    /* renamed from: e */
    private List<MaterialFileData> f21715e;

    /* renamed from: com.opos.mobad.model.data.FloatLayerData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<FloatLayerData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            FloatLayerData floatLayerData = new FloatLayerData();
            floatLayerData.a((MaterialFileData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            floatLayerData.a(parcel.readString());
            floatLayerData.b(parcel.readString());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            floatLayerData.a(parcel.createTypedArrayList(creator));
            floatLayerData.f21715e = parcel.createTypedArrayList(creator);
            return floatLayerData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatLayerData[] newArray(int i2) {
            return new FloatLayerData[i2];
        }
    }

    private FloatLayerData() {
    }

    public FloatLayerData(r rVar, MaterialFileData materialFileData, List<MaterialFileData> list, List<MaterialFileData> list2) {
        this.f21711a = materialFileData;
        this.f21714d = list;
        this.f21715e = list2;
        String str = rVar.f19858e;
        this.f21712b = str == null ? "" : str;
        String str2 = rVar.f19859f;
        this.f21713c = str2 != null ? str2 : "";
    }

    /* synthetic */ FloatLayerData(AnonymousClass1 anonymousClass1) {
        this();
    }

    public MaterialFileData a() {
        return this.f21711a;
    }

    public void a(MaterialFileData materialFileData) {
        this.f21711a = materialFileData;
    }

    public void a(String str) {
        this.f21712b = str;
    }

    public void a(List<MaterialFileData> list) {
        this.f21714d = list;
    }

    public String b() {
        return this.f21712b;
    }

    public void b(String str) {
        this.f21713c = str;
    }

    public String c() {
        return this.f21713c;
    }

    public List<MaterialFileData> d() {
        return this.f21714d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<MaterialFileData> e() {
        return this.f21715e;
    }

    public String toString() {
        return "FloatLayerData{iconFile='" + this.f21711a + "'title='" + this.f21712b + "'desc='" + this.f21713c + "'imgFileList='" + this.f21714d + "'interactiveFileList='" + this.f21715e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f21711a, i2);
        parcel.writeString(this.f21712b);
        parcel.writeString(this.f21713c);
        parcel.writeTypedList(this.f21714d);
        parcel.writeTypedList(this.f21715e);
    }
}
