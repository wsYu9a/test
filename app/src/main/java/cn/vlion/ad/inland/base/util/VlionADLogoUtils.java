package cn.vlion.ad.inland.base.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionADLogoUtils {
    public static Bitmap getLogo(Context context) {
        Drawable drawable;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                if (resources != null && (drawable = resources.getDrawable(R.drawable.vlion_menta_ad_icon)) != null) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return null;
    }
}
