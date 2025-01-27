package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public class q extends d {
    private static volatile q aDf;
    private o aDg;

    private q(Context context) {
        super(new p(context, p.KP));
        this.aDg = new i();
    }

    public static q bw(Context context) {
        if (aDf == null) {
            synchronized (q.class) {
                try {
                    if (aDf == null) {
                        aDf = new q(context);
                    }
                } finally {
                }
            }
        }
        return aDf;
    }

    @Override // com.kwad.sdk.core.report.d
    /* renamed from: h */
    public synchronized n g(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ae()) {
            return this.aDg.Z(string2, string);
        }
        return this.aDg.Z(string2, string);
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Gm() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Gn() {
        return "select aLog, actionId from " + Gm();
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "ReportActionDBManager";
    }
}
