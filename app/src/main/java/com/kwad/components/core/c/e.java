package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class e implements i {
    private static volatile e KY;

    @Nullable
    private String KZ;
    private int La = 0;
    private int cacheSize = 1;
    private long Lb = 1800;
    private boolean Lc = false;

    private e() {
    }

    public static synchronized List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
            }
            return arrayList;
        }
    }

    public static e an(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j10 = adTemplate.posId;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        e eVar = new e(j10);
        AdInfo.AdBaseInfo adBaseInfo = eb2.adBaseInfo;
        eVar.La = adBaseInfo.adCacheStrategy;
        eVar.Lb = adBaseInfo.adCacheSecond;
        eVar.cacheSize = adBaseInfo.adCacheSize;
        eVar.Lc = adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i10 = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i11 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j10 = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z10 = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z10 = false;
            }
            eVar = new e();
            eVar.KZ = string;
            eVar.La = i10;
            eVar.cacheSize = i11;
            eVar.Lb = j10;
            eVar.Lc = z10;
        }
        return eVar;
    }

    @NonNull
    private static e no() {
        if (KY == null) {
            synchronized (e.class) {
                try {
                    if (KY == null) {
                        KY = new e();
                    }
                } finally {
                }
            }
        }
        return KY;
    }

    @NonNull
    @WorkerThread
    public static e s(long j10) {
        e Z;
        return (a.nj() == null || (Z = a.nj().Z(String.valueOf(j10))) == null) ? no() : Z;
    }

    public final boolean isDefault() {
        return equals(no());
    }

    public final boolean isEnable() {
        return this.Lc;
    }

    public final int np() {
        return this.La;
    }

    public final int nq() {
        return this.cacheSize;
    }

    public final long nr() {
        return this.Lb;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ns() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.KZ);
        contentValues.put("strategyCode", Integer.valueOf(this.La));
        contentValues.put("cacheSize", Integer.valueOf(this.cacheSize));
        contentValues.put("cacheSecond", Long.valueOf(this.Lb));
        contentValues.put("enable", Integer.valueOf(this.Lc ? 1 : 0));
        return contentValues;
    }

    private e(long j10) {
        this.KZ = String.valueOf(j10);
    }
}
