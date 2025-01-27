package cn.vlion.ad.inland.base.network;

import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public interface VideoCallback {
    void onFail(VlionAdBaseError vlionAdBaseError);

    void onSuccess(ResponseBody responseBody);
}
