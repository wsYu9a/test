package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class f {
    private static volatile f aEf;
    private String aEg = GR();

    private f() {
    }

    public static f GP() {
        if (aEf == null) {
            synchronized (f.class) {
                try {
                    if (aEf == null) {
                        aEf = new f();
                    }
                } finally {
                }
            }
        }
        return aEf;
    }

    @Nullable
    @WorkerThread
    private static String GR() {
        try {
            return u.a(new File(bb.di(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    @WorkerThread
    private static void eD(String str) {
        try {
            u.a(new File(bb.di(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    @Nullable
    @WorkerThread
    public final String GQ() {
        return this.aEg;
    }

    @WorkerThread
    public final void eC(String str) {
        if (bm.isEquals(this.aEg, str)) {
            return;
        }
        this.aEg = str;
        eD(str);
    }
}
