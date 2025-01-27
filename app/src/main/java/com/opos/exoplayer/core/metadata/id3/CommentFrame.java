package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.CommentFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19131a;

    /* renamed from: b */
    public final String f19132b;

    /* renamed from: c */
    public final String f19133c;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.CommentFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<CommentFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f19131a = parcel.readString();
        this.f19132b = parcel.readString();
        this.f19133c = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f19131a = str;
        this.f19132b = str2;
        this.f19133c = str3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || CommentFrame.class != obj.getClass()) {
                return false;
            }
            CommentFrame commentFrame = (CommentFrame) obj;
            if (!u.a(this.f19132b, commentFrame.f19132b) || !u.a(this.f19131a, commentFrame.f19131a) || !u.a(this.f19133c, commentFrame.f19133c)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f19131a;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f19132b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f19133c;
        return ((hashCode2 + ((hashCode + 527) * 31)) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19138f);
        parcel.writeString(this.f19131a);
        parcel.writeString(this.f19133c);
    }
}
