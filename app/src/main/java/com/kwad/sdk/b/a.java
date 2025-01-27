package com.kwad.sdk.b;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;

/* loaded from: classes2.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.b.kwai.a.Hk.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }
}
