package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService aBx;

    /* renamed from: hf */
    private static volatile Handler f11969hf;
    private T aBA;
    private Context mContext;
    private volatile long VN = 120000;
    protected l aBw = new m();
    private AtomicInteger aBy = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int aBz = 5;

    /* renamed from: com.kwad.sdk.core.report.b$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ k aBB;

        public AnonymousClass1(k kVar) {
            kVar = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.f11969hf != null && !b.f11969hf.hasMessages(R.attr.childDivider)) {
                b bVar = b.this;
                bVar.az(bVar.VN);
            }
            e Gl = kVar.Gl();
            if (Gl != null) {
                b.this.aBw.j(Gl);
            }
            if (b.this.Gg()) {
                b.this.Gh();
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.network.l<R, BatchReportResult> {
        final /* synthetic */ List aBD;

        public AnonymousClass2(List list) {
            list = list;
        }

        @NonNull
        private static BatchReportResult ez(String str) {
            JSONObject jSONObject = new JSONObject(str);
            BatchReportResult batchReportResult = new BatchReportResult();
            batchReportResult.parseJson(jSONObject);
            return batchReportResult;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final R createRequest() {
            return (R) b.this.w(list);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.a
        public final ExecutorService getExecutor() {
            return b.aBx;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ BatchReportResult parseData(String str) {
            return ez(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$3 */
    public class AnonymousClass3 extends com.kwad.sdk.core.network.o<R, BatchReportResult> {
        final /* synthetic */ List aBD;
        final /* synthetic */ u.a aBE;
        final /* synthetic */ AtomicBoolean aBF;

        public AnonymousClass3(List list, u.a aVar, AtomicBoolean atomicBoolean) {
            list = list;
            aVar = aVar;
            atomicBoolean = atomicBoolean;
        }

        private void a(@NonNull BatchReportResult batchReportResult) {
            b.this.aBw.x(list);
            u.a aVar = aVar;
            if (aVar != null) {
                aVar.GE();
            }
            if (b.this.aBy.decrementAndGet() == 0 && atomicBoolean.get()) {
                b.this.Gi();
            }
            b.this.ay(batchReportResult.getInterval());
            b bVar = b.this;
            bVar.az(bVar.VN);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final void onError(@NonNull R r10, int i10, String str) {
            atomicBoolean.set(true);
            if (b.this.aBy.decrementAndGet() == 0) {
                b.this.Gi();
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            a((BatchReportResult) baseResultData);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$4 */
    public class AnonymousClass4 extends com.kwad.sdk.core.network.l<R, BatchReportResult> {
        final /* synthetic */ k aBB;

        public AnonymousClass4(k kVar) {
            kVar = kVar;
        }

        @NonNull
        private static BatchReportResult ez(String str) {
            JSONObject jSONObject = new JSONObject(str);
            BatchReportResult batchReportResult = new BatchReportResult();
            batchReportResult.parseJson(jSONObject);
            return batchReportResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final R createRequest() {
            e Gl = kVar.Gl();
            b.this.aBA = Gl;
            return (R) b.this.a((b) Gl);
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.a
        public final ExecutorService getExecutor() {
            return b.aBx;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ BatchReportResult parseData(String str) {
            return ez(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$5 */
    public class AnonymousClass5 extends com.kwad.sdk.core.network.o<R, BatchReportResult> {

        /* renamed from: com.kwad.sdk.core.report.b$5$1 */
        public class AnonymousClass1 implements k<T> {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.report.k
            @NonNull
            public final T Gl() {
                return (T) b.this.aBA;
            }
        }

        public AnonymousClass5() {
        }

        private void a(@NonNull BatchReportResult batchReportResult) {
            com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aBA + " result " + batchReportResult.getResult());
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final void onError(@NonNull R r10, int i10, String str) {
            com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i10 + " errorMsg:" + str + "\naction=" + b.this.aBA);
            b.this.a(new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.report.k
                @NonNull
                public final T Gl() {
                    return (T) b.this.aBA;
                }
            });
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            a((BatchReportResult) baseResultData);
        }
    }

    public b() {
        if (aBx == null) {
            aBx = GlobalThreadPools.Hn();
        }
    }

    public void Gi() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.aBz) {
            if (andIncrement > 0) {
                this.VN *= 2;
            }
            az(this.VN);
        }
    }

    public synchronized void az(long j10) {
        if (f11969hf == null) {
            return;
        }
        f11969hf.removeMessages(R.attr.childDivider);
        Message obtain = Message.obtain(f11969hf, a(this.mContext, this.aBw, this.aBy));
        obtain.what = R.attr.childDivider;
        f11969hf.sendMessageDelayed(obtain, j10);
    }

    public final boolean Gg() {
        int i10 = this.mRetryCount.get();
        if (i10 > 16) {
            i10 = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.aBw.size() >= (sVar != null ? (long) (sVar.zy() << i10) : 20L);
    }

    public final void Gh() {
        az(0L);
    }

    public final void ay(long j10) {
        if (j10 < 60) {
            this.VN = 60000L;
        } else {
            this.VN = j10 * 1000;
        }
    }

    public synchronized void j(Context context, int i10) {
        this.mContext = context;
        if (f11969hf == null) {
            f11969hf = com.kwad.sdk.core.threads.a.Hg();
        }
    }

    public abstract R w(List<T> list);

    private void c(@NonNull k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            final /* synthetic */ k aBB;

            public AnonymousClass4(k kVar2) {
                kVar = kVar2;
            }

            @NonNull
            private static BatchReportResult ez(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                e Gl = kVar.Gl();
                b.this.aBA = Gl;
                return (R) b.this.a((b) Gl);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aBx;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return ez(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5

            /* renamed from: com.kwad.sdk.core.report.b$5$1 */
            public class AnonymousClass1 implements k<T> {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.report.k
                @NonNull
                public final T Gl() {
                    return (T) b.this.aBA;
                }
            }

            public AnonymousClass5() {
            }

            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aBA + " result " + batchReportResult.getResult());
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r10, int i10, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i10 + " errorMsg:" + str + "\naction=" + b.this.aBA);
                b.this.a(new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.report.k
                    @NonNull
                    public final T Gl() {
                        return (T) b.this.aBA;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th2) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th2);
        }
    }

    public final void a(l lVar) {
        this.aBw = lVar;
    }

    public final void a(@NonNull k<T> kVar) {
        aBx.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            final /* synthetic */ k aBB;

            public AnonymousClass1(k kVar2) {
                kVar = kVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.f11969hf != null && !b.f11969hf.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.az(bVar.VN);
                }
                e Gl = kVar.Gl();
                if (Gl != null) {
                    b.this.aBw.j(Gl);
                }
                if (b.this.Gg()) {
                    b.this.Gh();
                }
            }
        });
    }

    public Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(List<T> list, AtomicBoolean atomicBoolean, u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.aBy.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            final /* synthetic */ List aBD;

            public AnonymousClass2(List list2) {
                list = list2;
            }

            @NonNull
            private static BatchReportResult ez(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.w(list);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aBx;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return ez(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            final /* synthetic */ List aBD;
            final /* synthetic */ u.a aBE;
            final /* synthetic */ AtomicBoolean aBF;

            public AnonymousClass3(List list2, u.a aVar2, AtomicBoolean atomicBoolean2) {
                list = list2;
                aVar = aVar2;
                atomicBoolean = atomicBoolean2;
            }

            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.aBw.x(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.GE();
                }
                if (b.this.aBy.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.Gi();
                }
                b.this.ay(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.az(bVar.VN);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r10, int i10, String str) {
                atomicBoolean.set(true);
                if (b.this.aBy.decrementAndGet() == 0) {
                    b.this.Gi();
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public R a(T t10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t10);
        return w(arrayList);
    }
}
