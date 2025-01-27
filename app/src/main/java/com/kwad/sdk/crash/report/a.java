package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: classes2.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        q qVar = new q(10211L);
        qVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.h.a2(qVar);
    }
}
