package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t extends d {
    private static volatile t ajQ;
    private final List<r> ajR;

    private t(Context context) {
        super(new s(context, s.HE));
        ArrayList arrayList = new ArrayList();
        this.ajR = arrayList;
        arrayList.add(new k());
    }

    public static t aU(Context context) {
        if (ajQ == null) {
            synchronized (t.class) {
                if (ajQ == null) {
                    ajQ = new t(context);
                }
            }
        }
        return ajQ;
    }

    @Override // com.kwad.sdk.core.report.d
    /* renamed from: f */
    public synchronized q e(@NonNull Cursor cursor) {
        try {
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("aLog")));
            int size = this.ajR.size() - 1;
            if (size >= 0) {
                return this.ajR.get(size).h(jSONObject);
            }
            return new q(jSONObject);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return new q("");
        }
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String wU() {
        return "ksad_actions";
    }
}
