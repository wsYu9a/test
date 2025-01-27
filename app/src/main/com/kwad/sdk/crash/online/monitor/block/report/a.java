package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends d {
    public static int KP = 1;
    private static volatile a aLm;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, KP));
    }

    public static a bN(Context context) {
        if (aLm == null) {
            synchronized (a.class) {
                try {
                    if (aLm == null) {
                        aLm = new a(context);
                    }
                } finally {
                }
            }
        }
        return aLm;
    }

    @Override // com.kwad.sdk.core.report.d
    /* renamed from: j */
    public synchronized BlockReportAction g(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e10) {
            c.printStackTrace(e10);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Gm() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Gn() {
        return "select aLog from " + Gm();
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}
