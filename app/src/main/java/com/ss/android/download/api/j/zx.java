package com.ss.android.download.api.j;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.k;

/* loaded from: classes4.dex */
public class zx implements k {

    /* renamed from: j */
    private gm f24067j;

    @Override // com.ss.android.download.api.config.k
    public void j(@NonNull Activity activity, @NonNull String[] strArr, gm gmVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f24067j = gmVar;
            activity.requestPermissions(strArr, 1);
        } else if (gmVar != null) {
            gmVar.j();
        }
    }

    @Override // com.ss.android.download.api.config.k
    public boolean j(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.k
    public void j(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        gm gmVar;
        if (iArr.length <= 0 || (gmVar = this.f24067j) == null) {
            return;
        }
        if (iArr[0] == -1) {
            gmVar.j(strArr[0]);
        } else if (iArr[0] == 0) {
            gmVar.j();
        }
    }
}
