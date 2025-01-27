package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d implements n<f> {
    protected c aih;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aih = cVar;
    }

    private synchronized void c(f fVar) {
        com.kwad.sdk.core.d.b.d(getTag(), "deleteAction action = " + fVar);
        try {
            this.aih.getReadableDatabase().delete(wU(), "actionId=?", new String[]{fVar.actionId});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.n
    /* renamed from: b */
    public final synchronized void e(f fVar) {
        ContentValues contentValues;
        com.kwad.sdk.core.d.b.d(getTag(), "write = " + fVar);
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", fVar.actionId);
            contentValues.put("aLog", fVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        try {
            this.aih.getReadableDatabase().insert(wU(), null, contentValues);
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTrace(e3);
        }
    }

    protected abstract f e(@NonNull Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.n
    public final synchronized void o(List<f> list) {
        com.kwad.sdk.core.d.b.d(getTag(), "delete size= " + list.size());
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.aih.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<f> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.b.printStackTrace(e3);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.b.printStackTrace(e4);
                    }
                }
            }
        } finally {
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized long size() {
        long j2;
        Cursor cursor = null;
        try {
            cursor = this.aih.getReadableDatabase().rawQuery("select count(*) from " + wU(), null);
            cursor.moveToFirst();
            j2 = cursor.getLong(0);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            j2 = 0;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return j2;
    }

    protected abstract String wU();

    @Override // com.kwad.sdk.core.report.n
    public final synchronized List<f> wV() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.aih.getReadableDatabase().rawQuery("select  * from " + wU(), null);
                if (cursor != null) {
                    ArrayList<f> arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(e(cursor));
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                    com.kwad.sdk.core.d.b.d(getTag(), "read size= " + arrayList.size());
                    for (f fVar : arrayList) {
                        com.kwad.sdk.core.d.b.d(getTag(), "read action=" + fVar);
                    }
                    return arrayList;
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.b.printStackTrace(e3);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }
}
