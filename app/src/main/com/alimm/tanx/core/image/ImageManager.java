package com.alimm.tanx.core.image;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class ImageManager implements NotConfused {
    private static volatile ILoader loader;

    public static ILoader getLoader() {
        if (loader == null) {
            loader = TanxCoreInstanceConfig.getInstance().getImageLoader();
        }
        return loader;
    }

    public static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static void setLoader(ILoader iLoader) {
        Log.d("ImageManager", iLoader == null ? "loader==null" : "loader!=null");
        loader = iLoader;
    }

    public static ImageConfig.Builder with(Context context) {
        return isValidContextForGlide(context) ? new ImageConfig.Builder(context) : new ImageConfig.Builder(context.getApplicationContext());
    }
}
