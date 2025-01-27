package com.kwad.sdk.core.videocache.b;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* loaded from: classes2.dex */
public final class a {
    private static f aom;

    public static f ba(Context context) {
        f fVar = aom;
        if (fVar != null) {
            return fVar;
        }
        f bb = bb(context);
        aom = bb;
        return bb;
    }

    private static f bb(Context context) {
        return new f.a(context).U(104857600L).yz();
    }
}
