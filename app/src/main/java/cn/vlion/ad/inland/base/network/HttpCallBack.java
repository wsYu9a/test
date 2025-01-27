package cn.vlion.ad.inland.base.network;

import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;

/* loaded from: classes.dex */
public interface HttpCallBack<T> {
    void onFail(VlionAdBaseError vlionAdBaseError);

    void onSuccess(T t10);
}
