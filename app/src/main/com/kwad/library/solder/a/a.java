package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* loaded from: classes3.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, b.c cVar) {
        i.ym().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a j(Context context, String str) {
        com.kwad.library.solder.lib.a.a l10 = i.ym().l(context, str);
        if (l10 != null && l10.isLoaded() && (l10 instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) l10;
        }
        return null;
    }

    public static void k(Context context, String str) {
        i.ym().k(context, str);
    }

    public static void a(Context context, @NonNull com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.ym().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
