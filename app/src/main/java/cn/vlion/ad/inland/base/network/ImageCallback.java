package cn.vlion.ad.inland.base.network;

import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;

/* loaded from: classes.dex */
public interface ImageCallback {
    void onFail(VlionAdBaseError vlionAdBaseError);

    void onSuccess(VlionImageSuccessData vlionImageSuccessData);
}
