package com.vivo.mobilead.manager;

import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes.dex */
public interface VInitCallback {
    void failed(@NonNull VivoAdError vivoAdError);

    void suceess();
}
