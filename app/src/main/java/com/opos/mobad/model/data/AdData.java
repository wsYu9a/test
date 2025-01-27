package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
public class AdData extends a implements Parcelable {
    public static final Parcelable.Creator<AdData> CREATOR = new Parcelable.Creator<AdData>() { // from class: com.opos.mobad.model.data.AdData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdData adData = new AdData();
            adData.b(parcel.readInt());
            adData.a(parcel.readString());
            adData.a(parcel.createTypedArrayList(AdItemData.CREATOR));
            adData.a(parcel.readLong());
            adData.c(parcel.readInt());
            adData.e(parcel.readInt());
            adData.f21679e = parcel.readInt();
            adData.d(parcel.readInt());
            adData.a(parcel.readInt() == 1);
            return adData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData[] newArray(int i2) {
            return new AdData[i2];
        }
    };

    /* renamed from: a */
    private int f21675a;

    /* renamed from: b */
    private String f21676b;

    /* renamed from: c */
    private List<AdItemData> f21677c;

    /* renamed from: d */
    private long f21678d;

    /* renamed from: e */
    private int f21679e;

    /* renamed from: f */
    private int f21680f;

    /* renamed from: g */
    private int f21681g;

    /* renamed from: h */
    private int f21682h;

    /* renamed from: i */
    private boolean f21683i;

    /* renamed from: j */
    private int f21684j;

    /* renamed from: com.opos.mobad.model.data.AdData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AdData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdData adData = new AdData();
            adData.b(parcel.readInt());
            adData.a(parcel.readString());
            adData.a(parcel.createTypedArrayList(AdItemData.CREATOR));
            adData.a(parcel.readLong());
            adData.c(parcel.readInt());
            adData.e(parcel.readInt());
            adData.f21679e = parcel.readInt();
            adData.d(parcel.readInt());
            adData.a(parcel.readInt() == 1);
            return adData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdData[] newArray(int i2) {
            return new AdData[i2];
        }
    }

    public AdData() {
        this.f21681g = 0;
        this.f21682h = 0;
        this.f21683i = false;
        this.f21684j = 0;
    }

    public AdData(int i2, String str) {
        this.f21681g = 0;
        this.f21682h = 0;
        this.f21683i = false;
        this.f21684j = 0;
        this.f21675a = i2;
        this.f21676b = str;
    }

    public AdData(int i2, String str, int i3, int i4) {
        this.f21681g = 0;
        this.f21682h = 0;
        this.f21683i = false;
        this.f21684j = 0;
        this.f21675a = i2;
        this.f21676b = str;
        this.f21680f = i3;
        this.f21681g = i4;
    }

    public void e(int i2) {
        this.f21681g = i2;
    }

    public int a() {
        return this.f21684j;
    }

    public void a(int i2) {
        this.f21684j = i2;
    }

    public void a(long j2) {
        this.f21678d = j2;
    }

    public void a(String str) {
        this.f21676b = str;
    }

    public void a(List<AdItemData> list) {
        this.f21677c = list;
    }

    public void a(boolean z) {
        this.f21683i = z;
    }

    public void b(int i2) {
        this.f21675a = i2;
    }

    public boolean b() {
        return this.f21683i;
    }

    public int c() {
        return this.f21681g;
    }

    public void c(int i2) {
        this.f21680f = i2;
    }

    public int d() {
        return this.f21675a;
    }

    public void d(int i2) {
        this.f21682h = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f21676b;
    }

    public List<AdItemData> f() {
        return this.f21677c;
    }

    public int g() {
        return this.f21680f;
    }

    public long h() {
        return this.f21678d;
    }

    public String toString() {
        return "AdData{code=" + this.f21675a + ", msg='" + this.f21676b + "', adItemDataList=" + this.f21677c + ", expTime=" + this.f21678d + ", requestInterval=" + this.f21680f + ", dispatchMode=" + this.f21681g + ", gameBoxType=" + this.f21682h + ", customSkip=" + this.f21683i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f21675a);
        parcel.writeString(this.f21676b);
        parcel.writeTypedList(this.f21677c);
        parcel.writeLong(this.f21678d);
        parcel.writeInt(this.f21680f);
        parcel.writeInt(this.f21681g);
        parcel.writeInt(this.f21679e);
        parcel.writeInt(this.f21682h);
        parcel.writeInt(this.f21683i ? 1 : 0);
    }
}
