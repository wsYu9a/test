package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class d implements l<e> {
    private static boolean aBI = false;
    protected c aBJ;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aBJ = cVar;
    }

    private synchronized void c(e eVar) {
        if (aBI) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.aBJ.getReadableDatabase().delete(Gm(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    public abstract String Gm();

    public abstract String Gn();

    public final synchronized List<e> Go() {
        try {
            try {
                String Gn = Gn();
                r0 = TextUtils.isEmpty(Gn) ? null : this.aBJ.getReadableDatabase().rawQuery(Gn, null);
                if (r0 != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (r0.moveToNext()) {
                        try {
                            arrayList.add(g(r0));
                        } catch (Exception e10) {
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                    if (aBI) {
                        Log.d(getTag(), "read size= " + arrayList.size());
                        for (e eVar : arrayList) {
                            Log.d(getTag(), "read action=" + eVar);
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(r0);
                    return arrayList;
                }
            } catch (Exception e11) {
                com.kwad.sdk.core.d.c.printStackTrace(e11);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(r0);
            return new ArrayList();
        } catch (Throwable th2) {
            com.kwad.sdk.crash.utils.b.closeQuietly(r0);
            throw th2;
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b */
    public final synchronized void j(e eVar) {
        if (aBI) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.aBJ.getReadableDatabase().insert(Gm(), null, contentValues);
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        } catch (Exception e11) {
            com.kwad.sdk.core.d.c.printStackTrace(e11);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> dn(int i10) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                String Gn = Gn();
                if (!TextUtils.isEmpty(Gn)) {
                    cursor = this.aBJ.getReadableDatabase().rawQuery(Gn + " LIMIT ? OFFSET ?", new String[]{"200", "0"});
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(g(cursor));
                        } catch (Exception e10) {
                            com.kwad.sdk.core.d.c.printStackTrace(e10);
                        }
                    }
                }
            } catch (Exception e11) {
                com.kwad.sdk.core.d.c.printStackTrace(e11);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return arrayList;
    }

    public abstract e g(@NonNull Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j10;
        Cursor cursor = null;
        try {
            try {
                cursor = this.aBJ.getReadableDatabase().rawQuery("select count(*) from " + Gm(), null);
                cursor.moveToFirst();
                j10 = cursor.getLong(0);
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            j10 = 0;
        }
        return j10;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<e> list) {
        if (aBI) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.aBJ.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
            } catch (Exception e11) {
                com.kwad.sdk.core.d.c.printStackTrace(e11);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e12) {
                        com.kwad.sdk.core.d.c.printStackTrace(e12);
                    }
                }
            }
        } finally {
        }
    }
}
