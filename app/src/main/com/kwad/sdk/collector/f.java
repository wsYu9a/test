package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class f {
    @Nullable
    public static JSONArray BV() {
        Context context = ServiceProvider.getContext();
        List<g> bc2 = bc(context);
        bc2.add(bb(context));
        return g.t(bc2);
    }

    private static g bb(Context context) {
        boolean cJ = ar.cJ(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + cJ);
        return new g(com.kuaishou.weapon.p0.g.f11110k, cJ ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> bc(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        String[] cI = ao.cI(context);
        if (cI != null) {
            for (String str : cI) {
                int ar = ar.ar(context, str);
                arrayList.add(new g(str, ar == 0 ? g.PERMISSION_GRANTED : ar == -1 ? g.PERMISSION_DENIED : g.ara));
            }
        }
        return arrayList;
    }
}
