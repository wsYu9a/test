package com.kwad.components.core.webview.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;

@KsJson
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String Li;
    public String Yw;
    public String Yx;
    public int Yy;

    public final AdInfo.SmallAppJumpInfo aK(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.Yw;
        smallAppJumpInfo.smallAppJumpUrl = this.Yx;
        return smallAppJumpInfo;
    }
}
