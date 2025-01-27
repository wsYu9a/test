package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class p extends c {
    public static int KP = 1;
    private static String aDe = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(@Nullable Context context, int i10) {
        super(context, "ksadrep.db", i10, aDe);
    }
}
