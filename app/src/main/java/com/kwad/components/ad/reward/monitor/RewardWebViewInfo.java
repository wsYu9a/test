package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: classes.dex */
public class RewardWebViewInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String source = "";
    public String sceneId = "";
    public String pageType = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public RewardWebViewInfo setDurationMs(long j2) {
        this.durationMs = j2;
        return this;
    }

    public RewardWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public RewardWebViewInfo setPageType(String str) {
        this.pageType = str;
        return this;
    }

    public RewardWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public RewardWebViewInfo setSource(String str) {
        this.source = str;
        return this;
    }

    public RewardWebViewInfo setStatus(int i2) {
        this.status = i2;
        return this;
    }

    public RewardWebViewInfo setTimeType(int i2) {
        this.timeType = i2;
        return this;
    }

    public RewardWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
