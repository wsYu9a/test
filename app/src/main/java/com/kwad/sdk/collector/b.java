package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {

    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i2 = 0; i2 < size; i2++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i2);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i2] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.tF()) {
                try {
                    long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                    sb.append(analysis);
                    com.kwad.sdk.core.d.b.d("AppStatusAnalyserNative", sb.toString());
                    for (long j2 : analysis) {
                        arrayList.add(new AppRunningInfoNative(j2));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.d.b.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j2, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i2 = 0; i2 < size; i2++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i2);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i2] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.tF()) {
                try {
                    for (long j3 : AppStatusNative.nativeGetUploadEntry(jArr, j2, str)) {
                        arrayList.add(new UploadEntryNative(j3));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }

    public static com.kwad.sdk.collector.a tD() {
        return new a();
    }
}
