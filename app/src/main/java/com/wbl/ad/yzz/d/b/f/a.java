package com.wbl.ad.yzz.d.b.f;

import android.content.Context;
import com.wbl.ad.yzz.network.bean.request.BindcpnReq;
import com.wbl.ad.yzz.network.bean.request.WithdrawalCenterReq;
import com.wbl.ad.yzz.network.bean.response.RequestWithdrawalReq;
import f.b.a.e;

/* loaded from: classes5.dex */
public interface a<V, M> extends com.wbl.ad.yzz.d.b.b<V, M> {
    void a(@e Context context, @e BindcpnReq bindcpnReq);

    void a(@e Context context, @e BindcpnReq bindcpnReq, int i2);

    void a(@e Context context, @e WithdrawalCenterReq withdrawalCenterReq);

    void a(@e Context context, @e RequestWithdrawalReq requestWithdrawalReq, boolean z);
}
