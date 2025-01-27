package com.sntech.net;

import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public class NetRequest {
    private boolean checkReqId;
    private JSONObject requestJSON;
    private String url;

    @Keep
    public static class Builder {
        private boolean checkReqId;
        private JSONObject requestJSON;
        private String url;

        @Keep
        public NetRequest build() {
            if (this.url != null) {
                return new NetRequest(this);
            }
            throw new IllegalStateException("url == null");
        }

        @Keep
        public Builder checkReqId(boolean z10) {
            this.checkReqId = z10;
            return this;
        }

        @Keep
        public Builder requestJSON(JSONObject jSONObject) {
            this.requestJSON = jSONObject;
            return this;
        }

        @Keep
        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    public NetRequest(Builder builder) {
        this.url = builder.url;
        this.requestJSON = builder.requestJSON;
        this.checkReqId = builder.checkReqId;
    }

    public JSONObject getRequestJSON() {
        return this.requestJSON;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCheckReqId() {
        return this.checkReqId;
    }
}
