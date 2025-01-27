package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends d {
    public a(List<ReportEvent> list) {
        ReportEvent.StatPackage statPackage;
        ReportEvent.CustomStatEvent customStatEvent;
        putBody("eventList", list);
        if (com.kwad.sdk.crash.utils.c.b(list) || list.get(0) == null || (statPackage = list.get(0).statPackage) == null || (customStatEvent = statPackage.customStatEvent) == null || !"perf-block".equals(customStatEvent.key)) {
            return;
        }
        putBody("versionForKeep", ExceptionMessage.getSdkCrashVersionName("3.3.40", 1));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sj();
    }
}
