package com.wbl.ad.yzz.network.b.a;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import f.b.a.e;

/* loaded from: classes5.dex */
public abstract class a {

    @e
    private String imei;

    @e
    private String oaid;

    public final String getImei() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11525, this, null);
    }

    public final String getOaid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11528, this, null);
    }

    @d
    public abstract String getSubSign();

    public final void setImei(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11527, this, str);
    }

    public final void setOaid(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11522, this, str);
    }
}
