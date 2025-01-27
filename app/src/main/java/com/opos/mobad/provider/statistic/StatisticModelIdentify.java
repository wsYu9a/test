package com.opos.mobad.provider.statistic;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* loaded from: classes4.dex */
public class StatisticModelIdentify implements IBridgeTargetIdentify {
    public static final Parcelable.Creator<StatisticModelIdentify> CREATOR = new Parcelable.Creator<StatisticModelIdentify>() { // from class: com.opos.mobad.provider.statistic.StatisticModelIdentify.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StatisticModelIdentify createFromParcel(Parcel parcel) {
            return new StatisticModelIdentify(parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StatisticModelIdentify[] newArray(int i2) {
            return new StatisticModelIdentify[i2];
        }
    };

    /* renamed from: a */
    public final boolean f23157a;

    /* renamed from: b */
    public final String f23158b;

    /* renamed from: com.opos.mobad.provider.statistic.StatisticModelIdentify$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<StatisticModelIdentify> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StatisticModelIdentify createFromParcel(Parcel parcel) {
            return new StatisticModelIdentify(parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StatisticModelIdentify[] newArray(int i2) {
            return new StatisticModelIdentify[i2];
        }
    }

    public StatisticModelIdentify(boolean z, String str) {
        this.f23157a = z;
        this.f23158b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f23157a ? 1 : 0);
        parcel.writeString(this.f23158b);
    }
}
