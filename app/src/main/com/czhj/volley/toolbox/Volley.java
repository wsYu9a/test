package com.czhj.volley.toolbox;

import android.content.Context;
import com.czhj.volley.Network;
import com.czhj.volley.RequestQueue;

/* loaded from: classes2.dex */
public class Volley {

    /* renamed from: a */
    public static final String f8838a = "volley";

    /* renamed from: b */
    public static boolean f8839b;

    public static RequestQueue a(Context context, Network network) {
        RequestQueue requestQueue = new RequestQueue(network);
        requestQueue.start();
        return requestQueue;
    }

    public static boolean isEnableOkhttp3() {
        return f8839b;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }

    public static void setEnableOkhttp3(boolean z10) {
        f8839b = z10;
    }

    public static RequestQueue newRequestQueue(Context context, BaseHttpStack baseHttpStack) {
        return a(context, baseHttpStack == null ? new BasicNetwork(new HurlStack()) : new BasicNetwork(baseHttpStack));
    }
}
