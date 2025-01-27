package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b<T extends f, R extends com.kwad.sdk.core.network.g> {
    private static ExecutorService ahX;
    private static volatile Handler mHandler;
    private T aia;
    private Context mContext;
    private volatile long ahV = 120000;
    private n ahW = new p();
    private AtomicInteger ahY = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int ahZ = 5;

    /* renamed from: com.kwad.sdk.core.report.b$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ m aib;

        AnonymousClass1(m mVar) {
            mVar = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.mHandler != null && !b.mHandler.hasMessages(R.attr.childDivider)) {
                b bVar = b.this;
                bVar.R(bVar.ahV);
            }
            f wT = mVar.wT();
            if (wT != null) {
                b.this.ahW.e(wT);
            }
            if (b.this.wO()) {
                b.this.wP();
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$2 */
    final class AnonymousClass2 extends com.kwad.sdk.core.network.m<R, BatchReportResult> {
        final /* synthetic */ List aid;

        AnonymousClass2(List list) {
            list = list;
        }

        @NonNull
        private static BatchReportResult cx(String str) {
            JSONObject jSONObject = new JSONObject(str);
            BatchReportResult batchReportResult = new BatchReportResult();
            batchReportResult.parseJson(jSONObject);
            return batchReportResult;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final R createRequest() {
            return (R) b.this.n(list);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.a
        public final ExecutorService getExecutor() {
            return b.ahX;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ BatchReportResult parseData(String str) {
            return cx(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$3 */
    final class AnonymousClass3 extends com.kwad.sdk.core.network.p<R, BatchReportResult> {
        final /* synthetic */ List aid;
        final /* synthetic */ AtomicBoolean aie;

        AnonymousClass3(List list, AtomicBoolean atomicBoolean) {
            list = list;
            atomicBoolean = atomicBoolean;
        }

        private void a(@NonNull BatchReportResult batchReportResult) {
            b.this.ahW.o(list);
            if (b.this.ahY.decrementAndGet() == 0 && atomicBoolean.get()) {
                b.this.wQ();
            }
            b.this.Q(batchReportResult.getInterval());
            b bVar = b.this;
            bVar.R(bVar.ahV);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final void onError(@NonNull R r, int i2, String str) {
            atomicBoolean.set(true);
            if (b.this.ahY.decrementAndGet() == 0) {
                b.this.wQ();
            }
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
            a((BatchReportResult) baseResultData);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$4 */
    final class AnonymousClass4 extends com.kwad.sdk.core.network.m<R, BatchReportResult> {
        final /* synthetic */ m aib;

        AnonymousClass4(m mVar) {
            mVar = mVar;
        }

        @NonNull
        private static BatchReportResult cx(String str) {
            JSONObject jSONObject = new JSONObject(str);
            BatchReportResult batchReportResult = new BatchReportResult();
            batchReportResult.parseJson(jSONObject);
            return batchReportResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final R createRequest() {
            f wT = mVar.wT();
            b.this.aia = wT;
            return (R) b.this.a((b) wT);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.a
        public final ExecutorService getExecutor() {
            return b.ahX;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ BatchReportResult parseData(String str) {
            return cx(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.b$5 */
    final class AnonymousClass5 extends com.kwad.sdk.core.network.p<R, BatchReportResult> {

        /* renamed from: com.kwad.sdk.core.report.b$5$1 */
        final class AnonymousClass1 implements m<T> {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.report.m
            @NonNull
            public final T wT() {
                return (T) b.this.aia;
            }
        }

        AnonymousClass5() {
        }

        private void a(@NonNull BatchReportResult batchReportResult) {
            com.kwad.sdk.core.d.b.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aia + " result " + batchReportResult.getResult());
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final void onError(@NonNull R r, int i2, String str) {
            b.this.a(new m<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.report.m
                @NonNull
                public final T wT() {
                    return (T) b.this.aia;
                }
            });
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
            a((BatchReportResult) baseResultData);
        }
    }

    protected b() {
        if (ahX == null) {
            ahX = GlobalThreadPools.xP();
        }
    }

    public synchronized void R(long j2) {
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(R.attr.childDivider);
        Message obtain = Message.obtain(mHandler, a(this.mContext, this.ahW, this.ahY));
        obtain.what = R.attr.childDivider;
        mHandler.sendMessageDelayed(obtain, j2);
    }

    private void c(@NonNull m<T> mVar) {
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            final /* synthetic */ m aib;

            AnonymousClass4(m mVar2) {
                mVar = mVar2;
            }

            @NonNull
            private static BatchReportResult cx(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                f wT = mVar.wT();
                b.this.aia = wT;
                return (R) b.this.a((b) wT);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahX;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cx(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5

            /* renamed from: com.kwad.sdk.core.report.b$5$1 */
            final class AnonymousClass1 implements m<T> {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.report.m
                @NonNull
                public final T wT() {
                    return (T) b.this.aia;
                }
            }

            AnonymousClass5() {
            }

            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.b.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aia + " result " + batchReportResult.getResult());
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i2, String str) {
                b.this.a(new m<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.report.m
                    @NonNull
                    public final T wT() {
                        return (T) b.this.aia;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public boolean wO() {
        int i2 = this.mRetryCount.get();
        if (i2 > 16) {
            i2 = 16;
        }
        v vVar = (v) ServiceProvider.get(v.class);
        return this.ahW.size() >= (vVar != null ? (long) (vVar.su() << i2) : 20L);
    }

    public void wQ() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.ahZ) {
            if (andIncrement > 0) {
                this.ahV *= 2;
            }
            R(this.ahV);
        }
    }

    protected final void Q(long j2) {
        this.ahV = j2 < 60 ? 60000L : j2 * 1000;
    }

    protected R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return n(arrayList);
    }

    protected Runnable a(Context context, n<T> nVar, AtomicInteger atomicInteger) {
        return new z(context, nVar, this, atomicInteger);
    }

    public final void a(@NonNull m<T> mVar) {
        ahX.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            final /* synthetic */ m aib;

            AnonymousClass1(m mVar2) {
                mVar = mVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.mHandler != null && !b.mHandler.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.R(bVar.ahV);
                }
                f wT = mVar.wT();
                if (wT != null) {
                    b.this.ahW.e(wT);
                }
                if (b.this.wO()) {
                    b.this.wP();
                }
            }
        });
    }

    protected final void a(n nVar) {
        this.ahW = nVar;
    }

    public final void a(List<T> list, AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ahY.getAndIncrement();
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            final /* synthetic */ List aid;

            AnonymousClass2(List list2) {
                list = list2;
            }

            @NonNull
            private static BatchReportResult cx(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.n(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahX;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cx(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            final /* synthetic */ List aid;
            final /* synthetic */ AtomicBoolean aie;

            AnonymousClass3(List list2, AtomicBoolean atomicBoolean2) {
                list = list2;
                atomicBoolean = atomicBoolean2;
            }

            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.ahW.o(list);
                if (b.this.ahY.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.wQ();
                }
                b.this.Q(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.R(bVar.ahV);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(@NonNull R r, int i2, String str) {
                atomicBoolean.set(true);
                if (b.this.ahY.decrementAndGet() == 0) {
                    b.this.wQ();
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull m<T> mVar) {
        try {
            c(mVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
    }

    public synchronized void i(Context context, int i2) {
        this.mContext = context;
        if (mHandler == null) {
            mHandler = com.kwad.sdk.core.threads.a.xJ();
        }
    }

    protected abstract R n(List<T> list);

    public final void wP() {
        R(0L);
    }
}
