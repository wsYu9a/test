package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC0909m;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.sa;

/* loaded from: classes4.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();

    /* renamed from: a */
    public sa f24639a;

    /* renamed from: b */
    public long f24640b;

    public BetaUploadStrategy() {
        sa saVar = new sa();
        this.f24639a = saVar;
        saVar.f25150e = true;
        saVar.f25151f = true;
        String str = StrategyBean.f24763a;
        saVar.f25152g = str;
        saVar.f25153h = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.f24639a.k = currentTimeMillis;
        this.f24640b = currentTimeMillis;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(M.a((AbstractC0909m) this.f24639a));
        parcel.writeLong(this.f24640b);
    }

    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy[] newArray(int i2) {
        return new BetaUploadStrategy[i2];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f24639a = (sa) M.a(parcel.createByteArray(), sa.class);
        this.f24640b = parcel.readLong();
    }
}
