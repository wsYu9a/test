package com.oplus.quickgame.sdk.engine.callback;

import android.database.Cursor;
import com.oplus.quickgame.sdk.engine.utils.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class Callback {

    public static class Response {
        public static final int DENIED = -8;
        public static final int ENGINE_VERSION_TOO_LOW = -16;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* renamed from: a */
        int f16202a;

        /* renamed from: b */
        String f16203b;

        /* renamed from: c */
        Map<String, Object> f16204c = new HashMap();

        public int getCode() {
            return this.f16202a;
        }

        public String getMsg() {
            return this.f16203b;
        }

        public Map<String, Object> getParams() {
            return this.f16204c;
        }

        public void putParams(Map<String, Object> map) {
            this.f16204c.putAll(map);
        }

        public void setCode(int i2) {
            this.f16202a = i2;
        }

        public void setMsg(String str) {
            this.f16203b = str;
        }

        public String toString() {
            return this.f16202a + "#" + this.f16203b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        Map<String, Object> b2 = k.b(cursor);
        Response response = new Response();
        if (b2 != null) {
            response.f16202a = Long.valueOf(((Long) b2.get("code")).longValue()).intValue();
            response.f16203b = (String) b2.get("msg");
            response.putParams(b2);
        } else {
            response.f16202a = -1;
            response.f16203b = "fail to get response";
        }
        onResponse(response);
    }
}
