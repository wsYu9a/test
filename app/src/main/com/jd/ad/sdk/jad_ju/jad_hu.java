package com.jd.ad.sdk.jad_ju;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public interface jad_hu {
    public static final Charset jad_an = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void jad_an(@NonNull MessageDigest messageDigest);
}
