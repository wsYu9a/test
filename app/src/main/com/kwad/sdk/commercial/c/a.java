package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.el(adTemplate);
        this.llsid = e.dY(adTemplate);
        this.posId = e.dU(adTemplate);
        AdInfo eb2 = e.eb(adTemplate);
        this.campaignType = com.kwad.sdk.core.response.b.a.dp(eb2);
        this.ocpcActionType = com.kwad.sdk.core.response.b.a.dq(eb2);
        this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dr(eb2);
        this.adOperationType = com.kwad.sdk.core.response.b.a.aQ(eb2);
        this.webUriSourceType = com.kwad.sdk.core.response.b.a.ds(eb2);
        AdMatrixInfo.MatrixTemplate ba2 = d.ba(adTemplate);
        if (ba2 != null) {
            this.templateId = ba2.templateId;
            this.templateVersion = String.valueOf(ba2.templateVersionCode);
            this.tkPublishType = ba2.publishType;
        }
        return this;
    }

    public a setErrorCode(int i10) {
        this.errorCode = i10;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j10) {
        this.llsid = j10;
        return this;
    }

    public a setPosId(long j10) {
        this.posId = j10;
        return this;
    }
}
