package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class e {
    private static volatile e agg;
    private String agh = we();

    private e() {
    }

    @WorkerThread
    private static void cd(String str) {
        try {
            com.kwad.sdk.utils.q.a(new File(av.cF(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public static e wc() {
        if (agg == null) {
            synchronized (e.class) {
                if (agg == null) {
                    agg = new e();
                }
            }
        }
        return agg;
    }

    @Nullable
    @WorkerThread
    private static String we() {
        try {
            return com.kwad.sdk.utils.q.a(new File(av.cF(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @WorkerThread
    public final void cc(String str) {
        if (bb.isEquals(this.agh, str)) {
            return;
        }
        this.agh = str;
        cd(str);
    }

    @Nullable
    @WorkerThread
    public final String wd() {
        return this.agh;
    }
}
