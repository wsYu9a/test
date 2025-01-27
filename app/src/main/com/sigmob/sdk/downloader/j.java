package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.connection.a;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    public static final int f19435a = 10;

    /* renamed from: b */
    public static final int f19436b = 307;

    /* renamed from: c */
    public static final int f19437c = 308;

    public static boolean a(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == 307 || i10 == 308;
    }

    public static String a(a.InterfaceC0584a interfaceC0584a, int i10) throws IOException {
        String c10 = interfaceC0584a.c(m5.c.f28347t0);
        if (c10 != null) {
            return c10;
        }
        throw new ProtocolException("Response code is " + i10 + " but can't find Location field");
    }
}
