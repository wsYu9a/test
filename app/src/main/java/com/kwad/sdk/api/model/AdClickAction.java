package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface AdClickAction {
    public static final int CLICK = 1;
    public static final int NOT_CLICK = 0;
    public static final int UNKNOWN = 2;
}
