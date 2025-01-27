package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public abstract class c implements e {
    private ArrayList<a> asu = new ArrayList<>();

    static class a {
        private ExceptionMessage asv;
        private int asw;

        a(ExceptionMessage exceptionMessage, int i2) {
            this.asv = exceptionMessage;
            this.asw = i2;
        }
    }

    private void Ac() {
        if (this.asu.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.asu.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.asv, next.asw, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void b(ExceptionMessage exceptionMessage, int i2, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i2 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e zy = com.kwad.sdk.crash.e.zy();
            if (zy.zD() != null && zy.zC() != 2) {
                List<com.kwad.sdk.crash.a> list = zy.zD().aqU;
                double d2 = zy.zD().aqB;
                String appId = zy.getAppId();
                String sdkVersion = zy.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aqy) || aVar.aqy.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aqz) || aVar.aqz.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aqA) || a(exceptionMessage.mCrashDetail, aVar.aqA)) {
                                d2 = aVar.aqB;
                            }
                        }
                    }
                }
                return Math.random() < d2;
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("BaseExceptionUploader", Log.getStackTraceString(e2));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i2, @Nullable CountDownLatch countDownLatch) {
        try {
            Ac();
            b(exceptionMessage, i2, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            this.asu.add(new a(exceptionMessage, i2));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
