package com.ss.android.download.api.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.t;

/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a */
    private t f20942a;

    @Override // com.ss.android.download.api.config.i
    public void a(@NonNull Activity activity, @NonNull String[] strArr, t tVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f20942a = tVar;
            activity.requestPermissions(strArr, 1);
        } else if (tVar != null) {
            tVar.a();
        }
    }

    @Override // com.ss.android.download.api.config.i
    public boolean a(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.i
    public void a(@NonNull Activity activity, int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        t tVar;
        if (iArr.length <= 0 || (tVar = this.f20942a) == null) {
            return;
        }
        int i11 = iArr[0];
        if (i11 == -1) {
            tVar.a(strArr[0]);
        } else if (i11 == 0) {
            tVar.a();
        }
    }
}
