package com.kwad.sdk.core.network;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public int agA = 0;
    public String agB;
    public String agz;
    public String errorMsg;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return toJson().toString();
    }
}
