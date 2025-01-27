package com.kwad.sdk.collector;

import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class e {
    public static String cz(String str) {
        try {
            return new String(com.kwad.sdk.core.a.c.EW().encode(o.k(u.V(new File(str)))));
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return null;
        }
    }
}
