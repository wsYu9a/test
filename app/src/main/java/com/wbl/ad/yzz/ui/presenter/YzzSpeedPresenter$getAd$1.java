package com.wbl.ad.yzz.ui.presenter;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.kuaishou.weapon.p0.t;
import com.wbl.ad.yzz.adapter.d.b;
import com.wbl.ad.yzz.network.b.b.m;
import com.wbl.ad.yzz.network.c.a;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/wbl/ad/yzz/ui/presenter/YzzSpeedPresenter$getAd$1", "Lcom/wbl/ad/yzz/network/c/a$a;", "", "Lcom/wbl/ad/yzz/adapter/d/b;", t.k, "", "loadAdSuccess", "(Ljava/util/List;)V", "", "code", "", "msg", "loadAdError", "(ILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class YzzSpeedPresenter$getAd$1 implements a.InterfaceC0770a {
    public final /* synthetic */ m $response;
    public final /* synthetic */ YzzSpeedPresenter this$0;

    public YzzSpeedPresenter$getAd$1(YzzSpeedPresenter yzzSpeedPresenter, m mVar) {
        this.this$0 = yzzSpeedPresenter;
        this.$response = mVar;
    }

    @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
    public void loadAdError(int code, String msg) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8980, this, Integer.valueOf(code), msg);
    }

    @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
    public void loadAdSuccess(List<b> r3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8979, this, r3);
    }
}
