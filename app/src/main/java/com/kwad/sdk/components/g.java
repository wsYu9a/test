package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: classes3.dex */
public final class g {
    public static boolean db(String str) {
        DevelopMangerComponents.DevelopValue da2 = d.da(str);
        return da2 != null && ((Boolean) da2.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return db("KEY_HOST_ENCRYPT_DISABLE");
    }
}
