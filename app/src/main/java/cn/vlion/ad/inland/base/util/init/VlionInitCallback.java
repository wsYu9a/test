package cn.vlion.ad.inland.base.util.init;

import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;

/* loaded from: classes.dex */
public interface VlionInitCallback {
    void onInitFailure(VlionAdBaseError vlionAdBaseError);

    void onInitSuccess();
}
