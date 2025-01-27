package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.sigmob.sdk.a;

/* loaded from: classes4.dex */
public final class PointEntitySigmobError extends PointEntitySigmob {

    /* renamed from: g0 */
    public String f18311g0;

    public static PointEntitySigmobError SigmobError(String str, int i10, String str2) {
        PointEntitySigmobError pointEntitySigmobError = new PointEntitySigmobError();
        pointEntitySigmobError.setAc_type("9");
        pointEntitySigmobError.setCategory(str);
        pointEntitySigmobError.setError_code(String.valueOf(i10));
        pointEntitySigmobError.setError_message(str2);
        return pointEntitySigmobError;
    }

    @Override // com.sigmob.sdk.base.mta.PointEnitySigmobBase, com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return a.e();
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public String getError_message() {
        return this.f18311g0;
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public void setError_message(String str) {
        this.f18311g0 = str;
    }
}
