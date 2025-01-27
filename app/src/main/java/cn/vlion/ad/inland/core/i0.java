package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class i0 implements VlionAdDownStrategyUtils.AdDownStrategyListener {
    @Override // cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils.AdDownStrategyListener
    public final void initCompleted() {
        LogVlion.e("Down 策略 : 启智能归因功能*------ ");
        VlionAdDownStrategyUtils.getInstance().startEventUpload();
    }
}
