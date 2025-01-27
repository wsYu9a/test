package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import com.oplus.quickgame.sdk.hall.Constant;
import com.vivo.ic.dm.Downloads;
import java.io.Serializable;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString("key");
            this.value = jSONObject.optString(Downloads.RequestHeaders.COLUMN_VALUE);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "key", this.key);
            t.putValue(jSONObject, Downloads.RequestHeaders.COLUMN_VALUE, this.value);
            return jSONObject;
        }
    }

    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString(com.heytap.mcssdk.n.d.l);
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "type", this.type);
            t.putValue(jSONObject, com.heytap.mcssdk.n.d.l, this.message);
            t.a(jSONObject, "urlPackage", this.urlPackage);
            t.putValue(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            t.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString(HTTP.IDENTITY_CODING);
            this.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "page", this.page);
            t.putValue(jSONObject, "params", this.params);
            t.putValue(jSONObject, HTTP.IDENTITY_CODING, this.identity);
            t.putValue(jSONObject, Constant.Param.KEY_RPK_PAGE_TYPE, this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        t.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        t.putValue(jSONObject, "sessionId", this.sessionId);
        t.a(jSONObject, "statPackage", this.statPackage);
        t.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
