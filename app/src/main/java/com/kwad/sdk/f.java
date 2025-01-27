package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;

/* loaded from: classes2.dex */
public final class f {
    private static int Yu;

    /* renamed from: com.kwad.sdk.f$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ long Yv;

        AnonymousClass1(long j2) {
            currentTimeMillis = j2;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(f.Yu).setInitStatus(0).toJson());
        }
    }

    /* renamed from: com.kwad.sdk.f$2 */
    static class AnonymousClass2 extends aw {
        final /* synthetic */ long Yw;

        AnonymousClass2(long j2) {
            j2 = j2;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setTotalDurationTime(j2).setInitCount(f.Yu).setInitStatus(1).toJson());
        }
    }

    /* renamed from: com.kwad.sdk.f$3 */
    static class AnonymousClass3 extends aw {
        final /* synthetic */ String HZ;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(f.Yu).setErrorReason(str).setInitStatus(2).toJson());
        }
    }

    public static void F(long j2) {
        long currentTimeMillis = j2 > 0 ? System.currentTimeMillis() - j2 : -1L;
        Yu++;
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.1
            final /* synthetic */ long Yv;

            AnonymousClass1(long currentTimeMillis2) {
                currentTimeMillis = currentTimeMillis2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(f.Yu).setInitStatus(0).toJson());
            }
        });
    }

    public static void G(long j2) {
        if (j2 > 10000) {
            j2 = -1;
        }
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.2
            final /* synthetic */ long Yw;

            AnonymousClass2(long j22) {
                j2 = j22;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setTotalDurationTime(j2).setInitCount(f.Yu).setInitStatus(1).toJson());
            }
        });
    }

    public static void a(com.kwai.adclient.kscommerciallogger.model.d dVar, String str) {
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.3
            final /* synthetic */ String HZ;

            AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(f.Yu).setErrorReason(str).setInitStatus(2).toJson());
            }
        });
    }
}
