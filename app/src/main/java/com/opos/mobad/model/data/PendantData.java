package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.y;

/* loaded from: classes4.dex */
public class PendantData extends a implements Parcelable {
    public static final Parcelable.Creator<PendantData> CREATOR = new Parcelable.Creator<PendantData>() { // from class: com.opos.mobad.model.data.PendantData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new PendantData((MaterialFileData) parcel.readParcelable(PendantData.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData[] newArray(int i2) {
            return new PendantData[i2];
        }
    };

    /* renamed from: a */
    private MaterialFileData f21739a;

    /* renamed from: b */
    private int f21740b;

    /* renamed from: c */
    private int f21741c;

    /* renamed from: com.opos.mobad.model.data.PendantData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<PendantData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new PendantData((MaterialFileData) parcel.readParcelable(PendantData.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PendantData[] newArray(int i2) {
            return new PendantData[i2];
        }
    }

    /* renamed from: com.opos.mobad.model.data.PendantData$2 */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f21742a;

        static {
            int[] iArr = new int[y.i.b.values().length];
            f21742a = iArr;
            try {
                iArr[y.i.b.UPPER_LEFT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21742a[y.i.b.BOTTOM_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PendantData() {
    }

    public PendantData(MaterialFileData materialFileData, int i2, int i3) {
        this.f21739a = materialFileData;
        this.f21740b = i2;
        this.f21741c = i3;
    }

    public PendantData(MaterialFileData materialFileData, y.i iVar) {
        this.f21739a = materialFileData;
        this.f21740b = MaterialData.a(iVar.f19981h);
        this.f21741c = a(iVar.f19979f);
    }

    private int a(y.i.b bVar) {
        return (bVar == null || AnonymousClass2.f21742a[bVar.ordinal()] != 2) ? 1 : 0;
    }

    public MaterialFileData a() {
        return this.f21739a;
    }

    public int b() {
        return this.f21740b;
    }

    public int c() {
        return this.f21741c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PendantData{imgFile=" + this.f21739a + ", actionType=" + this.f21740b + ", pendantPosition=" + this.f21741c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f21739a, i2);
        parcel.writeInt(this.f21740b);
        parcel.writeInt(this.f21741c);
    }
}
