package com.kwad.components.ad.c;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.p;

/* loaded from: classes.dex */
public final class a {
    public static p bR = new p("kwaiLogoUrl", null);
    public static p bS = new p("attentionTips", "去关注TA");
    public static p bT = new p("viewHomeTips", "查看TA的主页");
    public static p bU = new p("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
