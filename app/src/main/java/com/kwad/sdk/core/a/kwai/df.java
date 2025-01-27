package com.kwad.sdk.core.a.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: classes2.dex */
public final class df {
    @InvokeBy(invokerClass = ev.class, methodId = "registerHolder")
    public static void vO() {
        ev.vP().put(h.a.class, new ee());
        ev.vP().put(SdkConfigData.CouponActiveConfig.class, new bz());
        ev.vP().put(ActivityInfo.class, new f());
        ev.vP().put(j.a.class, new eg());
        ev.vP().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new eh());
        ev.vP().put(com.kwad.sdk.core.response.model.a.class, new gq());
        ev.vP().put(SdkConfigData.TemplateConfigMap.class, new ir());
    }
}
