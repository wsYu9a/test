package com.kwad.components.ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class a {
    public static void a(@NonNull AdTemplate adTemplate, int i2, long j2, int i3, String str) {
        KSLoggerReporter.i(new RewardCheckMonitorInfo(adTemplate.posId).setRequestStatus(2).setCheckType(i2).setEnviType(0).setDataLoadInterval(j2).setCode(i3).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))).toJson());
    }

    public static void c(@NonNull AdTemplate adTemplate, int i2) {
        KSLoggerReporter.i(new RewardCheckMonitorInfo(adTemplate.posId).setRequestStatus(1).setCheckType(i2).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))).toJson());
    }
}
