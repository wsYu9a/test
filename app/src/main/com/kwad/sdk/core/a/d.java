package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.h;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {
    private static g azb;

    public static void a(String str, Map<String, String> map, String str2) {
        pm().a(str, map, str2);
    }

    public static String an(String str) {
        return pm().an(str);
    }

    public static void g(@NonNull Map<String, String> map) {
        pm().g(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return pm().getResponseData(str);
    }

    private static g pm() {
        g gVar = azb;
        if (gVar != null) {
            return gVar;
        }
        h hVar = (h) com.kwad.sdk.components.d.f(h.class);
        if (hVar != null) {
            hVar.pm();
            azb = hVar.pm();
        } else {
            azb = new a();
        }
        return azb;
    }
}
