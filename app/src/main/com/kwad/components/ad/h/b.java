package com.kwad.components.ad.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.o;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends e implements o {
    @Override // com.kwad.sdk.components.o
    public final Map<String, AppPackageInfo> M(Context context) {
        return a.M(context);
    }

    @Override // com.kwad.sdk.components.o
    public final void a(Context context, com.kwad.sdk.f.a<JSONArray> aVar) {
        a.a(context, aVar);
    }

    @Override // com.kwad.sdk.components.o
    public final JSONArray[] b(Context context, List<String> list) {
        return a.b(context, list);
    }

    @Override // com.kwad.sdk.components.o
    @NonNull
    public final JSONArray c(@NonNull Map<String, AppPackageInfo> map) {
        return a.c(map);
    }

    @Override // com.kwad.sdk.components.o
    public final JSONObject e(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = ao.getPackageInfo(context, str, 0);
            if (packageInfo != null) {
                return a.a(a.a(packageInfo, packageManager));
            }
            return null;
        } catch (Throwable th2) {
            c.printStackTrace(th2);
            ServiceProvider.reportSdkCaughtException(th2);
            return null;
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return o.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.o
    public final JSONObject y(String str) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = str;
        return a.a(appPackageInfo);
    }
}
