package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;

/* loaded from: classes4.dex */
public class i {
    public static boolean a(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.socialbase.appdownloader.f.e.e() && Build.VERSION.SDK_INT < 29 && k.m() != null && k.m().a() && com.ss.android.downloadlib.g.e.a(aVar).optInt("invoke_app_form_background_switch") == 1 && aVar.q();
    }
}
