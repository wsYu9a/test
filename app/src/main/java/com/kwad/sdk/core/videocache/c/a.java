package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
import com.sigmob.sdk.videocache.h;

/* loaded from: classes3.dex */
public final class a {
    private static f aGV;

    public static f b(Context context, int i10, int i11) {
        f fVar = aGV;
        if (fVar != null) {
            return fVar;
        }
        f c10 = c(context, i10, i11);
        aGV = c10;
        return c10;
    }

    public static f bC(Context context) {
        return b(context, 0, 0);
    }

    private static f c(Context context, int i10, int i11) {
        return new f.a(context).aB(h.b.f20616f).dw(i10).dx(i11).Ig();
    }
}
