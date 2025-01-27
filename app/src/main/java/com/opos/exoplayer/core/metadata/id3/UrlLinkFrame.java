package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.UrlLinkFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19143a;

    /* renamed from: b */
    public final String f19144b;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.UrlLinkFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<UrlLinkFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.f19143a = parcel.readString();
        this.f19144b = parcel.readString();
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f19143a = str2;
        this.f19144b = str3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || UrlLinkFrame.class != obj.getClass()) {
                return false;
            }
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (!this.f19138f.equals(urlLinkFrame.f19138f) || !u.a(this.f19143a, urlLinkFrame.f19143a) || !u.a(this.f19144b, urlLinkFrame.f19144b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f19138f.hashCode();
        String str = this.f19143a;
        int hashCode2 = str != null ? str.hashCode() : 0;
        String str2 = this.f19144b;
        return ((hashCode2 + ((hashCode + 527) * 31)) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19138f);
        parcel.writeString(this.f19143a);
        parcel.writeString(this.f19144b);
    }
}
