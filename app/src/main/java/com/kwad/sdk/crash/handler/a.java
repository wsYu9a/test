package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class a {
    private static void a(ExceptionMessage exceptionMessage) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, null);
    }

    public static void p(@NonNull Throwable th2) {
        CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
        caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
        caughtExceptionMessage.mCrashDetail = th2.toString();
        caughtExceptionMessage.mCrashSource = 1;
        g.b(th2, caughtExceptionMessage, e.Jk().getContext());
        g.a(caughtExceptionMessage, 2);
        a(caughtExceptionMessage);
    }
}
