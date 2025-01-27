package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class c implements e {
    private ArrayList<a> aLD = new ArrayList<>();

    public static class a {
        private ExceptionMessage aLE;
        private int aLF;

        public a(ExceptionMessage exceptionMessage, int i10) {
            this.aLE = exceptionMessage;
            this.aLF = i10;
        }
    }

    private void JN() {
        if (this.aLD.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.aLD.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.aLE, next.aLF, null);
                it.remove();
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i10, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i10 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Jk = com.kwad.sdk.crash.e.Jk();
            if (Jk.Jp() != null && Jk.Jo() != 2) {
                List<com.kwad.sdk.crash.a> list = Jk.Jp().aJT;
                double d10 = Jk.Jp().aJu;
                String appId = Jk.getAppId();
                String sdkVersion = Jk.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null) {
                        if (!com.kwad.sdk.crash.utils.c.b(aVar.aJr) && !aVar.aJr.contains(appId)) {
                        }
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aJs) || aVar.aJs.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aJt) || a(exceptionMessage.mCrashDetail, aVar.aJt)) {
                                d10 = aVar.aJu;
                            }
                        }
                    }
                }
                return Math.random() < d10;
            }
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e10));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i10, @Nullable CountDownLatch countDownLatch) {
        try {
            JN();
            b(exceptionMessage, i10, countDownLatch);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            this.aLD.add(new a(exceptionMessage, i10));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
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
}
