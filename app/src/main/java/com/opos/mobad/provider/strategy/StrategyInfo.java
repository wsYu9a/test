package com.opos.mobad.provider.strategy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class StrategyInfo implements Parcelable {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new Parcelable.Creator<StrategyInfo>() { // from class: com.opos.mobad.provider.strategy.StrategyInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo createFromParcel(Parcel parcel) {
            return new StrategyInfo(parcel.readLong(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo[] newArray(int i2) {
            return new StrategyInfo[i2];
        }
    };

    /* renamed from: a */
    public final long f23164a;

    /* renamed from: b */
    public final Bundle f23165b;

    /* renamed from: com.opos.mobad.provider.strategy.StrategyInfo$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<StrategyInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo createFromParcel(Parcel parcel) {
            return new StrategyInfo(parcel.readLong(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo[] newArray(int i2) {
            return new StrategyInfo[i2];
        }
    }

    public StrategyInfo(long j2, Bundle bundle) {
        this.f23164a = j2;
        this.f23165b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f23164a);
        parcel.writeBundle(this.f23165b);
    }
}
