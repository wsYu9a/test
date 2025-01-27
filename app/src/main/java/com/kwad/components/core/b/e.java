package com.kwad.components.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class e implements h {
    private static volatile e Ib;

    @Nullable
    private String Ic;
    private int Id = 0;
    private int Ie = 1;
    private long If = 1800;
    private boolean Ig = false;

    private e() {
    }

    private e(long j2) {
        this.Ic = String.valueOf(j2);
    }

    public static e E(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j2 = adTemplate.posId;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        e eVar = new e(j2);
        AdInfo.AdBaseInfo adBaseInfo = cb.adBaseInfo;
        eVar.Id = adBaseInfo.adCacheStrategy;
        eVar.If = adBaseInfo.adCacheSecond;
        eVar.Ie = adBaseInfo.adCacheSize;
        eVar.Ig = adBaseInfo.adCacheSwitch == 1;
        return eVar;
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
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
            }
            return arrayList;
        }
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i2 = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i3 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j2 = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z = false;
            }
            eVar = new e();
            eVar.Ic = string;
            eVar.Id = i2;
            eVar.Ie = i3;
            eVar.If = j2;
            eVar.Ig = z;
        }
        return eVar;
    }

    @NonNull
    private static e mf() {
        if (Ib == null) {
            synchronized (e.class) {
                if (Ib == null) {
                    Ib = new e();
                }
            }
        }
        return Ib;
    }

    @NonNull
    @WorkerThread
    public static e n(long j2) {
        e ah;
        return (a.lW() == null || (ah = a.lW().ah(String.valueOf(j2))) == null) ? mf() : ah;
    }

    public final boolean isDefault() {
        return equals(mf());
    }

    public final boolean isEnable() {
        return this.Ig;
    }

    public final int mg() {
        return this.Id;
    }

    public final int mh() {
        return this.Ie;
    }

    public final long mi() {
        return this.If;
    }

    @Override // com.kwad.components.core.b.h
    public final ContentValues mj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.Ic);
        contentValues.put("strategyCode", Integer.valueOf(this.Id));
        contentValues.put("cacheSize", Integer.valueOf(this.Ie));
        contentValues.put("cacheSecond", Long.valueOf(this.If));
        contentValues.put("enable", Integer.valueOf(this.Ig ? 1 : 0));
        return contentValues;
    }
}
