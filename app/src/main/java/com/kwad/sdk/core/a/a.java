package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.t;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a implements g {
    private static String ayM;

    private static String EV() {
        if (!TextUtils.isEmpty(ayM)) {
            return ayM;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + bi.dn(context);
        ayM = str;
        return str;
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.g
    public final String an(String str) {
        try {
            String ec2 = t.ec(0);
            return new String(c.EW().encode(b.d(ec2.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void g(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", EV());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(t.ec(0), c.EY().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
