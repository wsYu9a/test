package com.shu.priory.conn;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.g.a;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;

/* loaded from: classes3.dex */
public class SplashDataRef {
    private final a mAdData;
    private final Context mContext;

    public SplashDataRef(Context context, a aVar) {
        this.mContext = context;
        this.mAdData = aVar;
    }

    public double getPrice() {
        return this.mAdData.f17076c;
    }

    public void onBiddingFailure(int i10, String str) {
        a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.O)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "unkonwn";
        }
        String replace = this.mAdData.O.replace("__TYPE__", Integer.toString(i10)).replace("__REASON__", str);
        h.a(SDKConstants.TAG, "竞价成功");
        j.a(replace, this.mContext, 1);
    }

    public void onBiddingSuccess() {
        a aVar = this.mAdData;
        if (aVar == null || TextUtils.isEmpty(aVar.O)) {
            return;
        }
        h.a(SDKConstants.TAG, "竞价成功");
        j.a(this.mAdData.O.replace("__TYPE__", "0"), this.mContext, 1);
    }
}
