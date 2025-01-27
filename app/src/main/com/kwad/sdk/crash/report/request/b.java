package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: com.kwad.sdk.crash.report.request.b$1 */
    public class AnonymousClass1 extends l<com.kwad.sdk.crash.report.request.a, CrashReportResult> {
        final /* synthetic */ List aLL;

        /* renamed from: com.kwad.sdk.crash.report.request.b$1$1 */
        public class C05071 extends com.kwad.sdk.crash.report.request.a {
            public C05071(List list) {
                super(list);
            }

            @Override // com.kwad.sdk.core.network.b
            public final boolean enableCrashReport() {
                return false;
            }
        }

        public AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: JO */
        public com.kwad.sdk.crash.report.request.a createRequest() {
            return new com.kwad.sdk.crash.report.request.a(list) { // from class: com.kwad.sdk.crash.report.request.b.1.1
                public C05071(List list) {
                    super(list);
                }

                @Override // com.kwad.sdk.core.network.b
                public final boolean enableCrashReport() {
                    return false;
                }
            };
        }

        @NonNull
        private static CrashReportResult fU(String str) {
            JSONObject jSONObject = new JSONObject(str);
            CrashReportResult crashReportResult = new CrashReportResult();
            crashReportResult.parseJson(jSONObject);
            return crashReportResult;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean enableCrashReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ CrashReportResult parseData(String str) {
            return fU(str);
        }
    }

    /* renamed from: com.kwad.sdk.crash.report.request.b$2 */
    public class AnonymousClass2 extends o<com.kwad.sdk.crash.report.request.a, CrashReportResult> {
        final /* synthetic */ List aLL;
        final /* synthetic */ CountDownLatch aLN;
        final /* synthetic */ a aLO;

        public AnonymousClass2(List list, CountDownLatch countDownLatch, a aVar) {
            list = list;
            countDownLatch = countDownLatch;
            aVar = aVar;
        }

        private void JP() {
            CountDownLatch countDownLatch = countDownLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }

        private void v(int i10, String str) {
            CountDownLatch countDownLatch = countDownLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.onError(i10, str);
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
            v(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            JP();
        }
    }

    public interface a {
        void onError(int i10, String str);

        void onSuccess();
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch, a aVar) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new l<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            final /* synthetic */ List aLL;

            /* renamed from: com.kwad.sdk.crash.report.request.b$1$1 */
            public class C05071 extends com.kwad.sdk.crash.report.request.a {
                public C05071(List list) {
                    super(list);
                }

                @Override // com.kwad.sdk.core.network.b
                public final boolean enableCrashReport() {
                    return false;
                }
            }

            public AnonymousClass1(List list2) {
                list = list2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: JO */
            public com.kwad.sdk.crash.report.request.a createRequest() {
                return new com.kwad.sdk.crash.report.request.a(list) { // from class: com.kwad.sdk.crash.report.request.b.1.1
                    public C05071(List list2) {
                        super(list2);
                    }

                    @Override // com.kwad.sdk.core.network.b
                    public final boolean enableCrashReport() {
                        return false;
                    }
                };
            }

            @NonNull
            private static CrashReportResult fU(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableCrashReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ CrashReportResult parseData(String str) {
                return fU(str);
            }
        }.request(new o<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            final /* synthetic */ List aLL;
            final /* synthetic */ CountDownLatch aLN;
            final /* synthetic */ a aLO;

            public AnonymousClass2(List list2, CountDownLatch countDownLatch2, a aVar2) {
                list = list2;
                countDownLatch = countDownLatch2;
                aVar = aVar2;
            }

            private void JP() {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            private void v(int i10, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(i10, str);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                v(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                JP();
            }
        });
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }
}
