package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.r;

/* loaded from: classes2.dex */
public final class a {
    public static k rT = new k("rewardSkipType", 0);
    public static k rU = new k("rewardActiveAppTaskMinSecond", 15);
    public static k rV = new k("rewardContentDetainType", 0);
    public static d rW = new d("forceGetAudioFocus", false);
    public static r rX = new r("rewardSkipTips", "");
    public static r rY = new r("fullscreenSkipTips", "");
    public static k rZ = new k("ecRewardAdOrderSwitch", 0);

    /* renamed from: sa */
    public static k f11653sa = new k("ecRewardAdFanSwitch", 0);

    /* renamed from: sb */
    public static k f11654sb = new k("ecRewardAdKwaishopStyle", 0);

    /* renamed from: sc */
    public static k f11655sc = new k("xdtCouponShowDuration", 3000);

    /* renamed from: sd */
    public static k f11656sd = new k("jinniuCloseDialogStyle", 1);

    /* renamed from: se */
    public static g f11657se = new g("interactionTimeInRewardedVideo", 0.0f);

    /* renamed from: sf */
    public static d f11658sf = new d("autoJumpInRewardedVideo", false);

    /* renamed from: sg */
    public static k f11659sg = new k("advanceJumpDirectDeliveryMaxCount", 0);

    /* renamed from: sh */
    public static d f11660sh = new d("advanceJumpDirectDeliverySwitch", false);

    /* renamed from: si */
    public static k f11661si = new k("shortVideoFollowRewardPlayStyle", 0);

    /* renamed from: sj */
    public static d f11662sj = new d("enableRewardLayoutOptimise", false);

    /* renamed from: sk */
    public static d f11663sk = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
