package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* loaded from: classes4.dex */
public class IdModelIdentify implements IBridgeTargetIdentify {
    public static final Parcelable.Creator<IdModelIdentify> CREATOR = new Parcelable.Creator<IdModelIdentify>() { // from class: com.opos.mobad.provider.openId.IdModelIdentify.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IdModelIdentify createFromParcel(Parcel parcel) {
            return new IdModelIdentify(parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IdModelIdentify[] newArray(int i2) {
            return new IdModelIdentify[i2];
        }
    };

    /* renamed from: a */
    public final boolean f23133a;

    /* renamed from: b */
    public final String f23134b;

    /* renamed from: com.opos.mobad.provider.openId.IdModelIdentify$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<IdModelIdentify> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IdModelIdentify createFromParcel(Parcel parcel) {
            return new IdModelIdentify(parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IdModelIdentify[] newArray(int i2) {
            return new IdModelIdentify[i2];
        }
    }

    public IdModelIdentify(boolean z, String str) {
        this.f23133a = z;
        this.f23134b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f23133a ? 1 : 0);
        parcel.writeString(this.f23134b);
    }
}
