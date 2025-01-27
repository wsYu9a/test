package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.sigmob.sdk.base.common.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: com.kwad.sdk.crash.online.monitor.block.f$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aLj;
        final /* synthetic */ boolean aLk;

        /* renamed from: com.kwad.sdk.crash.online.monitor.block.f$1$1 */
        public class C05061 implements b.a {
            final /* synthetic */ List aBD;
            final /* synthetic */ Context hB;

            public C05061(Context context, List list) {
                context = context;
                Go = list;
            }

            @Override // com.kwad.sdk.crash.report.request.b.a
            public final void onError(int i10, String str) {
                com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i10 + " errorMsg:" + str);
            }

            @Override // com.kwad.sdk.crash.report.request.b.a
            public final void onSuccess() {
                com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).x(Go);
            }
        }

        public AnonymousClass1(String str, boolean z10) {
            str = str;
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z10 || f.JH() == 1) {
                com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "report now :" + str);
                h.ah("perf-block", str);
                return;
            }
            BlockReportAction blockReportAction = new BlockReportAction(str);
            com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            if (context == null) {
                return;
            }
            com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).j(blockReportAction);
            if (f.Gg()) {
                List<com.kwad.sdk.core.report.e> Go = com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).Go();
                ArrayList arrayList = new ArrayList();
                Iterator<com.kwad.sdk.core.report.e> it = Go.iterator();
                while (it.hasNext()) {
                    arrayList.add(((BlockReportAction) it.next()).msg);
                }
                h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                    final /* synthetic */ List aBD;
                    final /* synthetic */ Context hB;

                    public C05061(Context context2, List Go2) {
                        context = context2;
                        Go = Go2;
                    }

                    @Override // com.kwad.sdk.crash.report.request.b.a
                    public final void onError(int i10, String str) {
                        com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i10 + " errorMsg:" + str);
                    }

                    @Override // com.kwad.sdk.crash.report.request.b.a
                    public final void onSuccess() {
                        com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).x(Go);
                    }
                });
            }
        }
    }

    public static boolean Gg() {
        int JH = JH();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).size();
        com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + JH);
        return size >= ((long) JH);
    }

    public static int JH() {
        com.kwad.sdk.crash.online.monitor.a.a JF = e.JF();
        if (JF != null) {
            return JF.aLu;
        }
        return 20;
    }

    public static void a(String str, long j10, long j11, String str2, String str3, boolean z10) {
        try {
            h(b(str, j10, j11, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j10, long j11, String str2, String str3) {
        try {
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e10));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = fN(b.fL(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j11 == 0) {
            j11 = y.f.f18076n;
        }
        return c(str, j10, j11, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j10, long j11, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j11;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aKZ = str;
        if (j10 == 0) {
            j10 = System.currentTimeMillis();
        }
        aVar.aKX = j10;
        aVar.repeatCount = (int) (j11 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    private static String fN(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + "\n";
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains("\n")) {
                replaceAll = replaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (replaceAll + hf.e.f26694a).replaceAll("\n\tat _", "\n");
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", Log.getStackTraceString(e10));
            return str;
        }
    }

    public static void fO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (e.JG()) {
            d dVar = new d();
            dVar.aLf = str;
            dVar.aLh = a.JE();
            com.kwad.sdk.commercial.b.p(dVar);
        }
    }

    public static void fP(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aLh = a.JE();
            com.kwad.sdk.commercial.b.p(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", str);
    }

    private static void h(String str, boolean z10) {
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            final /* synthetic */ String aLj;
            final /* synthetic */ boolean aLk;

            /* renamed from: com.kwad.sdk.crash.online.monitor.block.f$1$1 */
            public class C05061 implements b.a {
                final /* synthetic */ List aBD;
                final /* synthetic */ Context hB;

                public C05061(Context context2, List Go2) {
                    context = context2;
                    Go = Go2;
                }

                @Override // com.kwad.sdk.crash.report.request.b.a
                public final void onError(int i10, String str) {
                    com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i10 + " errorMsg:" + str);
                }

                @Override // com.kwad.sdk.crash.report.request.b.a
                public final void onSuccess() {
                    com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).x(Go);
                }
            }

            public AnonymousClass1(String str2, boolean z102) {
                str = str2;
                z10 = z102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z10 || f.JH() == 1) {
                    com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "report now :" + str);
                    h.ah("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                Context context2 = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                if (context2 == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.bN(context2).j(blockReportAction);
                if (f.Gg()) {
                    List Go2 = com.kwad.sdk.crash.online.monitor.block.report.a.bN(context2).Go();
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.kwad.sdk.core.report.e> it = Go2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                        final /* synthetic */ List aBD;
                        final /* synthetic */ Context hB;

                        public C05061(Context context22, List Go22) {
                            context = context22;
                            Go = Go22;
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i10, String str2) {
                            com.kwad.sdk.core.d.c.w("perfMonitor.Reporter", "errorCode:" + i10 + " errorMsg:" + str2);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.bN(context).x(Go);
                        }
                    });
                }
            }
        });
    }
}
