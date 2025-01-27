package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.sdk.crash.report.request.b$1 */
    static class AnonymousClass1 extends m<com.kwad.sdk.crash.report.request.a, CrashReportResult> {
        final /* synthetic */ List asA;

        AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: Ad */
        public com.kwad.sdk.crash.report.request.a createRequest() {
            return new com.kwad.sdk.crash.report.request.a(list);
        }

        @NonNull
        private static CrashReportResult dT(String str) {
            JSONObject jSONObject = new JSONObject(str);
            CrashReportResult crashReportResult = new CrashReportResult();
            crashReportResult.parseJson(jSONObject);
            return crashReportResult;
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ CrashReportResult parseData(String str) {
            return dT(str);
        }
    }

    /* renamed from: com.kwad.sdk.crash.report.request.b$2 */
    static class AnonymousClass2 extends p<com.kwad.sdk.crash.report.request.a, CrashReportResult> {
        final /* synthetic */ List asA;
        final /* synthetic */ CountDownLatch asB;
        final /* synthetic */ a asC;

        AnonymousClass2(List list, CountDownLatch countDownLatch, a aVar) {
            list = list;
            countDownLatch = countDownLatch;
            aVar = aVar;
        }

        private void Ae() {
            a aVar = aVar;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }

        private void k(int i2, String str) {
            CountDownLatch countDownLatch = countDownLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.onError(i2, str);
            }
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
            k(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
            Ae();
        }
    }

    public interface a {
        void onError(int i2, String str);

        void onSuccess();
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch, a aVar) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new m<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            final /* synthetic */ List asA;

            AnonymousClass1(List list2) {
                list = list2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Ad */
            public com.kwad.sdk.crash.report.request.a createRequest() {
                return new com.kwad.sdk.crash.report.request.a(list);
            }

            @NonNull
            private static CrashReportResult dT(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ CrashReportResult parseData(String str) {
                return dT(str);
            }
        }.request(new p<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            final /* synthetic */ List asA;
            final /* synthetic */ CountDownLatch asB;
            final /* synthetic */ a asC;

            AnonymousClass2(List list2, CountDownLatch countDownLatch2, a aVar2) {
                list = list2;
                countDownLatch = countDownLatch2;
                aVar = aVar2;
            }

            private void Ae() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            private void k(int i2, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(i2, str);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                k(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                Ae();
            }
        });
    }
}
