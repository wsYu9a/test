package com.jd.ad.sdk.jad_ju;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class jad_er extends IOException {
    public jad_er(String str, int i10, @Nullable Throwable th2) {
        super(str + ", status code: " + i10, th2);
    }
}
