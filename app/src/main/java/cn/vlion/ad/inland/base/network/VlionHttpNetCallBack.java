package cn.vlion.ad.inland.base.network;

import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;

/* loaded from: classes.dex */
public interface VlionHttpNetCallBack {
    void onFail(VlionAdBaseError vlionAdBaseError, VlionADNetBodyParameter vlionADNetBodyParameter);

    void onSuccess(String str, VlionADNetBodyParameter vlionADNetBodyParameter);
}
