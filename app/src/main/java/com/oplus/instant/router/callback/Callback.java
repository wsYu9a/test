package com.oplus.instant.router.callback;

import android.database.Cursor;
import com.oplus.instant.router.h.f;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class Callback {

    public static class Response {
        public static final int DENIED = -8;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* renamed from: a */
        int f16051a;

        /* renamed from: b */
        String f16052b;

        public int getCode() {
            return this.f16051a;
        }

        public String getMsg() {
            return this.f16052b;
        }

        public void setCode(int i2) {
            this.f16051a = i2;
        }

        public void setMsg(String str) {
            this.f16052b = str;
        }

        public String toString() {
            return this.f16051a + "#" + this.f16052b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        String str;
        Object obj;
        Map<String, Object> a2 = f.a(cursor);
        Response response = new Response();
        if (a2 == null || (obj = a2.get("code")) == null) {
            response.f16051a = -1;
            str = "fail to get response";
        } else {
            response.f16051a = Long.valueOf(((Long) obj).longValue()).intValue();
            str = (String) a2.get("msg");
        }
        response.f16052b = str;
        onResponse(response);
    }
}
