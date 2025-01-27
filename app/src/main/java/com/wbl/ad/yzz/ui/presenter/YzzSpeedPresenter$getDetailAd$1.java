package com.wbl.ad.yzz.ui.presenter;

import androidx.core.app.NotificationCompat;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.vivo.ic.webview.BridgeUtils;
import com.wbl.ad.yzz.network.b.b.m;
import com.wbl.ad.yzz.network.c.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/wbl/ad/yzz/ui/presenter/YzzSpeedPresenter$getDetailAd$1", "Lcom/wbl/ad/yzz/network/c/d$b0;", "Lcom/wbl/ad/yzz/network/b/b/m;", "", ProcessBridgeProvider.KEY_RESULT_MSG, BridgeUtils.CALL_JS_RESPONSE, "", "onSuccess", "(Ljava/lang/String;Lcom/wbl/ad/yzz/network/b/b/m;)V", "code", NotificationCompat.CATEGORY_ERROR, "onFailed", "(Ljava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class YzzSpeedPresenter$getDetailAd$1 implements d.b0<m> {
    public final /* synthetic */ boolean $isOnlyBanner;
    public final /* synthetic */ YzzSpeedPresenter this$0;

    public YzzSpeedPresenter$getDetailAd$1(YzzSpeedPresenter yzzSpeedPresenter, boolean z) {
        this.this$0 = yzzSpeedPresenter;
        this.$isOnlyBanner = z;
    }

    @Override // com.wbl.ad.yzz.network.c.d.b0
    public void onFailed(String code, String r4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9065, this, code, r4);
    }

    /* renamed from: onSuccess */
    public void onSuccess2(String r3, m r4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9068, this, r3, r4);
    }

    @Override // com.wbl.ad.yzz.network.c.d.b0
    public /* bridge */ /* synthetic */ void onSuccess(String str, m mVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9067, this, str, mVar);
    }
}
