package com.kwad.components.core.offline;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;

/* loaded from: classes2.dex */
public final class a {
    public static void at(int i2) {
        KSLoggerReporter.a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF("offline_component_performance").A(new b().au(i2).s(1L).toJson()).xa());
    }

    public static void b(int i2, long j2) {
        KSLoggerReporter.a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF("offline_component_performance").A(new b().au(i2).s(2L).t(j2).toJson()).xa());
    }
}
