package com.ss.android.downloadlib.zx;

import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class k {
    public static boolean j(@NonNull com.ss.android.downloadad.api.j.j jVar) {
        return com.ss.android.socialbase.appdownloader.gv.q.g() && Build.VERSION.SDK_INT < 29 && com.ss.android.downloadlib.addownload.pa.t() != null && com.ss.android.downloadlib.addownload.pa.t().j() && com.ss.android.downloadlib.lg.q.j(jVar).optInt("invoke_app_form_background_switch") == 1 && jVar.ei();
    }
}
