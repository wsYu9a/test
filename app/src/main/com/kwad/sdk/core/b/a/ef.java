package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: classes3.dex */
public final class ef {
    @InvokeBy(invokerClass = gc.class, methodId = "registerHolder")
    public static void Fe() {
        gc.Ff().put(SdkConfigData.TemplateConfigMap.class, new kp());
        gc.Ff().put(h.a.class, new fh());
        gc.Ff().put(j.a.class, new fk());
        gc.Ff().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new fl());
        gc.Ff().put(ActivityInfo.class, new f());
        gc.Ff().put(SdkConfigData.CouponActiveConfig.class, new cv());
        gc.Ff().put(com.kwad.sdk.core.response.model.a.class, new Cif());
    }
}
