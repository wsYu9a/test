package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.al;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class f {
    private static g ay(Context context) {
        boolean ch = al.ch(context);
        com.kwad.sdk.core.d.b.d("InfoCollector", "queryAccessibilityServicePermission result: " + ch);
        return new g(com.kuaishou.weapon.p0.g.k, ch ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> az(Context context) {
        String[] cg;
        ArrayList arrayList = new ArrayList();
        if (context != null && (cg = aj.cg(context)) != null) {
            for (String str : cg) {
                int al = al.al(context, str);
                arrayList.add(new g(str, al == 0 ? g.PERMISSION_GRANTED : al == -1 ? g.PERMISSION_DENIED : g.abg));
            }
        }
        return arrayList;
    }

    @Nullable
    public static JSONArray tG() {
        Context context = ServiceProvider.getContext();
        List<g> az = az(context);
        az.add(ay(context));
        return g.k(az);
    }
}
