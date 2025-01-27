package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.bd;

/* loaded from: classes3.dex */
public final class m {
    private static int aoC;

    /* renamed from: com.kwad.sdk.m$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ long aoD;

        public AnonymousClass1(long j10) {
            currentTimeMillis = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(m.aoC).setInitStatus(0));
        }
    }

    /* renamed from: com.kwad.sdk.m$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ long aoE;

        public AnonymousClass2(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(1));
        }
    }

    /* renamed from: com.kwad.sdk.m$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ long aoE;

        public AnonymousClass3(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(6));
        }
    }

    /* renamed from: com.kwad.sdk.m$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ long aoE;

        public AnonymousClass4(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(3));
        }
    }

    /* renamed from: com.kwad.sdk.m$5 */
    public class AnonymousClass5 extends bd {
        final /* synthetic */ long aoE;

        public AnonymousClass5(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(4));
        }
    }

    /* renamed from: com.kwad.sdk.m$6 */
    public class AnonymousClass6 extends bd {
        final /* synthetic */ long aoE;

        public AnonymousClass6(long j10) {
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(5));
        }
    }

    /* renamed from: com.kwad.sdk.m$7 */
    public class AnonymousClass7 extends bd {
        final /* synthetic */ String Lx;

        public AnonymousClass7(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(m.aoC).setErrorReason(str).setInitStatus(2));
        }
    }

    public static void a(com.kwai.adclient.kscommerciallogger.model.d dVar, String str) {
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.7
            final /* synthetic */ String Lx;

            public AnonymousClass7(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(m.aoC).setErrorReason(str).setInitStatus(2));
            }
        });
    }

    public static void ad(long j10) {
        long currentTimeMillis = j10 > 0 ? System.currentTimeMillis() - j10 : -1L;
        aoC++;
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.1
            final /* synthetic */ long aoD;

            public AnonymousClass1(long currentTimeMillis2) {
                currentTimeMillis = currentTimeMillis2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(m.aoC).setInitStatus(0));
            }
        });
    }

    public static void ae(long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.2
            final /* synthetic */ long aoE;

            public AnonymousClass2(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(1));
            }
        });
    }

    public static void af(long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.3
            final /* synthetic */ long aoE;

            public AnonymousClass3(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(6));
            }
        });
    }

    public static void ag(long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.4
            final /* synthetic */ long aoE;

            public AnonymousClass4(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(3));
            }
        });
    }

    public static void ah(long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.5
            final /* synthetic */ long aoE;

            public AnonymousClass5(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(4));
            }
        });
    }

    public static void ai(long j10) {
        if (j10 > 10000) {
            j10 = -1;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.m.6
            final /* synthetic */ long aoE;

            public AnonymousClass6(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aYs, new SDKInitMsg().setTotalDurationTime(j10).setInitCount(m.aoC).setInitStatus(5));
            }
        });
    }
}
