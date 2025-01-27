package com.vivo.push;

import android.net.Uri;
import com.kwai.sodler.lib.ext.PluginError;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a */
    public static final Uri f31044a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b */
    public static final Uri f31045b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c */
    public static final Uri f31046c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d */
    public static final Uri f31047d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    public static String a(int i2) {
        switch (i2) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case PluginError.ERROR_UPD_EXTRACT /* 2004 */:
                return "method_tag_bind";
            case PluginError.ERROR_UPD_CAPACITY /* 2005 */:
                return "method_tag_unbind";
            case PluginError.ERROR_UPD_REQUEST /* 2006 */:
                return "method_sdk_bind";
            case PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD /* 2007 */:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
