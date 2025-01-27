package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC0868m;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.sa;

/* loaded from: classes4.dex */
public class BetaUploadStrategy implements Parcelable, Parcelable.Creator<BetaUploadStrategy> {
    public static final Parcelable.Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();

    /* renamed from: a */
    public sa f22140a;

    /* renamed from: b */
    public long f22141b;

    public BetaUploadStrategy() {
        sa saVar = new sa();
        this.f22140a = saVar;
        saVar.f22854e = true;
        saVar.f22855f = true;
        String str = StrategyBean.f22337a;
        saVar.f22856g = str;
        saVar.f22857h = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.f22140a.f22860k = currentTimeMillis;
        this.f22141b = currentTimeMillis;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(M.a((AbstractC0868m) this.f22140a));
        parcel.writeLong(this.f22141b);
    }

    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public BetaUploadStrategy[] newArray(int i10) {
        return new BetaUploadStrategy[i10];
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f22140a = (sa) M.a(parcel.createByteArray(), sa.class);
        this.f22141b = parcel.readLong();
    }
}
