package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.TextInformationFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19141a;

    /* renamed from: b */
    public final String f19142b;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.TextInformationFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<TextInformationFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.f19141a = parcel.readString();
        this.f19142b = parcel.readString();
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f19141a = str2;
        this.f19142b = str3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || TextInformationFrame.class != obj.getClass()) {
                return false;
            }
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (!this.f19138f.equals(textInformationFrame.f19138f) || !u.a(this.f19141a, textInformationFrame.f19141a) || !u.a(this.f19142b, textInformationFrame.f19142b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f19138f.hashCode();
        String str = this.f19141a;
        int hashCode2 = str != null ? str.hashCode() : 0;
        String str2 = this.f19142b;
        return ((hashCode2 + ((hashCode + 527) * 31)) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19138f);
        parcel.writeString(this.f19141a);
        parcel.writeString(this.f19142b);
    }
}
