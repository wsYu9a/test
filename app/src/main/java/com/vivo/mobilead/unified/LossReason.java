package com.vivo.mobilead.unified;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface LossReason {
    public static final int LOW_PRICE = 1;
    public static final int NO_DATA = 3;
    public static final int OTHER = 10001;
    public static final int TIME_OUT = 2;
}
