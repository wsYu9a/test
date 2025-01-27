package com.vivo.ic.webview;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class BridgeMsg {
    private static final String HANDLER_JAVA_STR = "handlerjaveName";
    private static final String HANDLER_JS_STR = "handlerjsName";
    private static final String REQUEST_CALLBACK_ID_STR = "requestcallback";
    private static final String REQUEST_DATA_STR = "requestdata";
    private static final String REQUEST_MSG_TYPE = "msgtype";
    private static final String RESPONSE_CALL_BACK_ID_STR = "responsecallback";
    private static final String RESPONSE_DATA_STR = "responsedata";
    private String mJavaHandler;
    private String mJsHandler;
    private String mRequestCallback;
    private String mRequestData;
    private String mRequestType;
    private String mResponseCallback;
    private String mResponseData;

    public static BridgeMsg toObject(String str) {
        BridgeMsg bridgeMsg = new BridgeMsg();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bridgeMsg.setJavaHandler(jSONObject.has(HANDLER_JAVA_STR) ? jSONObject.getString(HANDLER_JAVA_STR) : null);
            bridgeMsg.setJsHandler(jSONObject.has(HANDLER_JS_STR) ? jSONObject.getString(HANDLER_JS_STR) : null);
            bridgeMsg.setRequestCallback(jSONObject.has(REQUEST_CALLBACK_ID_STR) ? jSONObject.getString(REQUEST_CALLBACK_ID_STR) : null);
            bridgeMsg.setResponseCallback(jSONObject.has(RESPONSE_CALL_BACK_ID_STR) ? jSONObject.getString(RESPONSE_CALL_BACK_ID_STR) : null);
            bridgeMsg.setRequestData(jSONObject.has(REQUEST_DATA_STR) ? jSONObject.getString(REQUEST_DATA_STR) : null);
            bridgeMsg.setResponseData(jSONObject.has(RESPONSE_DATA_STR) ? jSONObject.getString(RESPONSE_DATA_STR) : null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bridgeMsg;
    }

    public String getJavaHandler() {
        return this.mJavaHandler;
    }

    public String getJsHandler() {
        return this.mJsHandler;
    }

    public String getRequestCallback() {
        return this.mRequestCallback;
    }

    public String getRequestData() {
        return this.mRequestData;
    }

    public String getResponseCallback() {
        return this.mResponseCallback;
    }

    public String getResponseData() {
        return this.mResponseData;
    }

    public void setJavaHandler(String str) {
        this.mJavaHandler = str;
    }

    public void setJsHandler(String str) {
        this.mJsHandler = str;
    }

    public void setRequestCallback(String str) {
        this.mRequestCallback = str;
    }

    public void setRequestData(String str) {
        this.mRequestData = str;
    }

    public void setRequestType(String str) {
        this.mRequestType = str;
    }

    public void setResponseCallback(String str) {
        this.mResponseCallback = str;
    }

    public void setResponseData(String str) {
        this.mResponseData = str;
    }

    public JSONObject toJson() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(REQUEST_CALLBACK_ID_STR, getRequestCallback());
            hashMap.put(RESPONSE_CALL_BACK_ID_STR, getResponseCallback());
            hashMap.put(HANDLER_JAVA_STR, getJavaHandler());
            hashMap.put(HANDLER_JS_STR, getJsHandler());
            hashMap.put(REQUEST_DATA_STR, getRequestData());
            hashMap.put(RESPONSE_DATA_STR, getResponseData());
            hashMap.put(REQUEST_MSG_TYPE, this.mRequestType);
            return new JSONObject(hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
