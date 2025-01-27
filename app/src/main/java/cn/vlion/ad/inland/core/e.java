package cn.vlion.ad.inland.core;

import android.content.Context;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public final class e {
    public static VlionAdError a(Context context, j0 j0Var) {
        try {
            if (context == null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL;
                return new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            if (j0Var == null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.LOAD_AD_SLOT_IS_NULL;
                return new VlionAdError(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
            if (TextUtils.isEmpty(VlionSDkManager.getInstance().getAppId())) {
                VlionAdBaseError vlionAdBaseError3 = VlionAdBaseError.AD_APP_ID_IS_EMPTY;
                return new VlionAdError(vlionAdBaseError3.getErrorCode(), vlionAdBaseError3.getErrorMessage());
            }
            if (!TextUtils.isEmpty(j0Var.e())) {
                return null;
            }
            VlionAdBaseError vlionAdBaseError4 = VlionAdBaseError.AD_TAG_ID_IS_EMPTY;
            return new VlionAdError(vlionAdBaseError4.getErrorCode(), vlionAdBaseError4.getErrorMessage());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }
}
