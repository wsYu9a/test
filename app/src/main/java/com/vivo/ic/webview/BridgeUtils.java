package com.vivo.ic.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.authjs.a;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class BridgeUtils {
    public static final String BRIDGE_COMMON_INTERFACAE = "javacommon";
    public static final String BRIDGE_JAVA_CALL = "javacall";
    public static final String BRIDGE_JAVA_RESPONSE = "javaresponse";
    public static final String BRIDGE_SCHEME = "jsbridge";
    public static final String CALL_JS_REQUEST = "request";
    public static final String CALL_JS_RESPONSE = "response";
    static final String JS_FETCH_MSG_QUEUE = "javascript:window.WeiwoJSBridge._continueSendMsg();";
    static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:window.WeiwoJSBridge._handleMessageFromNative('%s');";
    public static final String NOT_COMPATIBLITY_CALLBACK = "notcompatiblity";
    public static final int jS_CALL_TYPE = 1;
    public static final int jS_COMMON_TYPE = 3;
    public static final int jS_RESPONSE_TYPE = 2;
    public static final int jS_UNKNOW_TYPE = 0;

    public static int getBridgeType(String str) {
        if (str.contains(BRIDGE_JAVA_CALL)) {
            return 1;
        }
        if (str.contains(BRIDGE_JAVA_RESPONSE)) {
            return 2;
        }
        return str.contains(BRIDGE_COMMON_INTERFACAE) ? 3 : 0;
    }

    public static String getCallBack(String str) {
        return Uri.parse(str).getQueryParameter(a.f5376c);
    }

    public static String getData(String str) {
        return Uri.parse(str).getQueryParameter(MiConfigSingleton.t0);
    }

    public static String getNotCompatiblityJsCallBack(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).getString(NOT_COMPATIBLITY_CALLBACK);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isJsBridge(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(BRIDGE_SCHEME);
    }

    public static String parseHandler(String str) {
        return Uri.parse(str).getPath().replace("/", "");
    }
}
