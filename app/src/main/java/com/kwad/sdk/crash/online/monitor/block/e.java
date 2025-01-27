package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: com.kwad.sdk.crash.online.monitor.block.e$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ String asa;
        final /* synthetic */ boolean asb;

        /* renamed from: com.kwad.sdk.crash.online.monitor.block.e$1$1 */
        final class C02261 implements b.a {
            final /* synthetic */ List aid;
            final /* synthetic */ Context jN;

            C02261(Context context, List list) {
                context = context;
                wV = list;
            }

            @Override // com.kwad.sdk.crash.report.request.b.a
            public final void onError(int i2, String str) {
                com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i2 + " errorMsg:" + str);
            }

            @Override // com.kwad.sdk.crash.report.request.b.a
            public final void onSuccess() {
                com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).o(wV);
            }
        }

        AnonymousClass1(String str, boolean z) {
            str = str;
            z = z;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z || e.zW() == 1) {
                com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "report now :" + str);
                h.R("perf-block", str);
                return;
            }
            BlockReportAction blockReportAction = new BlockReportAction(str);
            com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
            Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
            if (context == null) {
                return;
            }
            com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).e(blockReportAction);
            if (e.wO()) {
                List<f> wV = com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).wV();
                ArrayList arrayList = new ArrayList();
                Iterator<f> it = wV.iterator();
                while (it.hasNext()) {
                    arrayList.add(((BlockReportAction) it.next()).msg);
                }
                h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1.1
                    final /* synthetic */ List aid;
                    final /* synthetic */ Context jN;

                    C02261(Context context2, List wV2) {
                        context = context2;
                        wV = wV2;
                    }

                    @Override // com.kwad.sdk.crash.report.request.b.a
                    public final void onError(int i2, String str) {
                        com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i2 + " errorMsg:" + str);
                    }

                    @Override // com.kwad.sdk.crash.report.request.b.a
                    public final void onSuccess() {
                        com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).o(wV);
                    }
                });
            }
        }
    }

    public static void a(String str, long j2, long j3, String str2, String str3, boolean z) {
        try {
            e(b(str, j2, j3, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j2, long j3, String str2, String str3) {
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = dM(b.dH(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j3 == 0) {
            j3 = 2000;
        }
        return c(str, j2, j3, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j2, long j3, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j3;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.arP = str;
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        aVar.arN = j2;
        aVar.repeatCount = (int) (j3 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    public static void d(String str, boolean z) {
        String dJ = dJ(str);
        if (TextUtils.isEmpty(dJ)) {
            return;
        }
        e(dJ, false);
    }

    @Nullable
    private static String dJ(String str) {
        String dK = dK(b.dH(str));
        return !TextUtils.isEmpty(dK) ? c(dK, 0L, 2000L, "", "").toJson().toString() : "";
    }

    private static String dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (str.contains("at ")) {
                str = str.substring(str.indexOf("at "));
            }
            String replaceAll = dL(str.replaceAll("at ", "")).replaceAll("\\)", "\\)\n");
            if (replaceAll.contains("\n")) {
                replaceAll = replaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e2) {
            Log.e("perfMonitor.Reporter", Log.getStackTraceString(e2));
            return str;
        }
    }

    private static String dL(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    private static String dM(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
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
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e2));
            return str;
        }
    }

    public static void dN(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (d.zV()) {
            c cVar = new c();
            cVar.arW = str;
            cVar.arY = a.zT();
            KSLoggerReporter.x(cVar.toJson());
        }
    }

    public static void dO(String str) {
        try {
            c cVar = new c();
            cVar.errorMsg = str;
            cVar.arY = a.zT();
            KSLoggerReporter.x(cVar.toJson());
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", str);
    }

    private static void e(String str, boolean z) {
        g.execute(new aw() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1
            final /* synthetic */ String asa;
            final /* synthetic */ boolean asb;

            /* renamed from: com.kwad.sdk.crash.online.monitor.block.e$1$1 */
            final class C02261 implements b.a {
                final /* synthetic */ List aid;
                final /* synthetic */ Context jN;

                C02261(Context context2, List wV2) {
                    context = context2;
                    wV = wV2;
                }

                @Override // com.kwad.sdk.crash.report.request.b.a
                public final void onError(int i2, String str) {
                    com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i2 + " errorMsg:" + str);
                }

                @Override // com.kwad.sdk.crash.report.request.b.a
                public final void onSuccess() {
                    com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).o(wV);
                }
            }

            AnonymousClass1(String str2, boolean z2) {
                str = str2;
                z = z2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z || e.zW() == 1) {
                    com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "report now :" + str);
                    h.R("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                Context context2 = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                if (context2 == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.bn(context2).e(blockReportAction);
                if (e.wO()) {
                    List wV2 = com.kwad.sdk.crash.online.monitor.block.report.a.bn(context2).wV();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = wV2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1.1
                        final /* synthetic */ List aid;
                        final /* synthetic */ Context jN;

                        C02261(Context context22, List wV22) {
                            context = context22;
                            wV = wV22;
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i2, String str2) {
                            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i2 + " errorMsg:" + str2);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).o(wV);
                        }
                    });
                }
            }
        });
    }

    public static boolean wO() {
        int zW = zW();
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).size();
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "size:" + size + " limit:" + zW);
        return size >= ((long) zW);
    }

    public static int zW() {
        com.kwad.sdk.crash.online.monitor.kwai.a zU = d.zU();
        if (zU != null) {
            return zU.asl;
        }
        return 20;
    }
}
