package com.wbl.ad.yzz.network.bean.response;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.bean.request.SceneReq;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class RequestWithdrawalReq extends SceneReq implements Serializable {
    private int amount;
    private int user_id;

    public int getAmount() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11213, this, null);
    }

    public int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11216, this, null);
    }

    public void setAmount(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11215, this, Integer.valueOf(i2));
    }

    public void setUser_id(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11210, this, Integer.valueOf(i2));
    }
}
