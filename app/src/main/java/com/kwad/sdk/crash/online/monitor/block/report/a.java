package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends d {
    public static int HE = 1;
    private static volatile a asd;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.kwai.a(context, HE));
    }

    public static a bn(Context context) {
        if (asd == null) {
            synchronized (a.class) {
                if (asd == null) {
                    asd = new a(context);
                }
            }
        }
        return asd;
    }

    @Override // com.kwad.sdk.core.report.d
    /* renamed from: h */
    public synchronized BlockReportAction e(@NonNull Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("aLog");
        if (columnIndex < 0) {
            return new BlockReportAction("");
        }
        try {
            return new BlockReportAction(new JSONObject(cursor.getString(columnIndex)));
        } catch (JSONException e2) {
            b.printStackTrace(e2);
            return new BlockReportAction("");
        }
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String wU() {
        return "ksad_block_actions";
    }
}
