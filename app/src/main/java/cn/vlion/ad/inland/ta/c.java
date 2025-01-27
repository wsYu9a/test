package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.ta.i;

/* loaded from: classes.dex */
public final class c implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ ImageCallback f4028a;

    public c(i.a aVar) {
        this.f4028a = aVar;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        ImageCallback imageCallback = this.f4028a;
        if (imageCallback != null) {
            imageCallback.onFail(vlionAdBaseError);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        ImageCallback imageCallback = this.f4028a;
        if (imageCallback != null) {
            imageCallback.onSuccess(vlionImageSuccessData);
        }
    }
}
