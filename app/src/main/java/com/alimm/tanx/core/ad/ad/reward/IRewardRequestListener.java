package com.alimm.tanx.core.ad.ad.reward;

import com.alimm.tanx.core.request.TanxError;
import java.util.Map;

/* loaded from: classes.dex */
public interface IRewardRequestListener {
    void onError(TanxError tanxError);

    void onRewardArrived(boolean z10, int i10, Map<String, Object> map);
}
