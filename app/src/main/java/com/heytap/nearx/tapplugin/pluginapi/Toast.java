package com.heytap.nearx.tapplugin.pluginapi;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
public class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    public static android.widget.Toast makeText(Context context, int i2, int i3) {
        return makeText(context, context.getResources().getText(i2), i3);
    }

    public static android.widget.Toast makeText(Context context, CharSequence charSequence, int i2) {
        Activity proxyActivity = (PluginApi.sPluginMode && (context instanceof Activity)) ? PluginApi.getProxyActivity((Activity) context) : null;
        if (proxyActivity != null) {
            context = proxyActivity;
        }
        return android.widget.Toast.makeText(context, charSequence, i2);
    }
}
