package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.x;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.a.b bVar) {
        ad.a(context, "ksadsdk_idc", "idc_data", bVar == null ? "" : bVar.toJson().toString());
    }

    public static com.kwad.sdk.core.network.idc.a.b bq(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.a.b.ei(h.K(context, "ksad_idc.json"));
        } catch (IOException e10) {
            c.printStackTraceOnly(e10);
            return new com.kwad.sdk.core.network.idc.a.b();
        }
    }

    public static com.kwad.sdk.core.network.idc.a.b br(Context context) {
        return com.kwad.sdk.core.network.idc.a.b.ei(ad.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> bs(Context context) {
        return x.parseJSON2MapString(ad.b(context, "ksadsdk_idc", "idc_current", ""));
    }

    public static void a(Context context, Map<String, String> map) {
        String str;
        if (map != null && !map.isEmpty()) {
            str = new JSONObject(map).toString();
        } else {
            str = "";
        }
        ad.a(context, "ksadsdk_idc", "idc_current", str);
    }
}
