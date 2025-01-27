package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class s extends c {
    public static int HE = 1;
    private static String ajP = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public s(@Nullable Context context, int i2) {
        super(context, "ksadrep.db", i2, ajP);
    }
}
