package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: classes3.dex */
public interface INet {
    public static final int HTTP_STATUS_CODE_INVALID = -1;

    public @interface HostType {
        public static final String API = "api";
        public static final String CDN = "cdn";
        public static final String ULOG = "ulog";
        public static final String ZT = "zt";
    }

    int getActiveNetworkType(Context context);

    String getCurrHost(@HostType String str, String str2);

    void handleSwitchHost(String str, @HostType String str2, int i10, Throwable th2);

    boolean isMobileConnected(Context context);

    boolean isNetworkConnected(Context context);

    boolean isWifiConnected(Context context);
}
