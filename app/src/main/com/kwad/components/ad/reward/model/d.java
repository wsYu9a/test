package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cS(adInfo) ? ILivePush.ClickType.LIVE : com.kwad.sdk.core.response.b.a.bd(adInfo) ? "image" : com.kwad.sdk.core.response.b.a.ce(adInfo) ? "reward_preview" : "video";
    }
}
