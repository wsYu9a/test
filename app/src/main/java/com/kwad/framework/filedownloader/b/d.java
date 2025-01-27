package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean aiG = false;
    private final e aiH = new e(com.kwad.framework.filedownloader.f.c.xT());
    private SQLiteDatabase aiI;

    public class a implements a.InterfaceC0463a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> aiJ = new SparseArray<>();
        private b aiK;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> aiw;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aix;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.aiw = sparseArray;
            this.aix = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void a(int i10, com.kwad.framework.filedownloader.d.c cVar) {
            this.aiJ.put(i10, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aiw;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aiw.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.aiK = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0463a
        public final void wo() {
            b bVar = this.aiK;
            if (bVar != null) {
                bVar.wo();
            }
            try {
                SQLiteDatabase wp = d.this.wp();
                if (wp == null) {
                    return;
                }
                int size = this.aiJ.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        wp.beginTransaction();
                        for (int i10 = 0; i10 < size; i10++) {
                            int keyAt = this.aiJ.keyAt(i10);
                            com.kwad.framework.filedownloader.d.c cVar = this.aiJ.get(keyAt);
                            wp.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            wp.insert("ksad_file_download", null, cVar.xr());
                            if (cVar.xw() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> bm = d.this.bm(keyAt);
                                if (bm.size() > 0) {
                                    wp.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : bm) {
                                        aVar.setId(cVar.getId());
                                        wp.insert("ksad_file_download_connection", null, aVar.xr());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aiw;
                        if (sparseArray != null && this.aix != null) {
                            synchronized (sparseArray) {
                                try {
                                    int size2 = this.aiw.size();
                                    for (int i11 = 0; i11 < size2; i11++) {
                                        int id2 = this.aiw.valueAt(i11).getId();
                                        List<com.kwad.framework.filedownloader.d.a> bm2 = d.this.bm(id2);
                                        if (bm2 != null && bm2.size() > 0) {
                                            synchronized (this.aix) {
                                                this.aix.put(id2, bm2);
                                            }
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        wp.setTransactionSuccessful();
                        try {
                            wp.endTransaction();
                        } catch (Exception e10) {
                            d.printStackTrace(e10);
                        }
                    } catch (SQLiteException e11) {
                        d.this.a(e11);
                        try {
                            wp.endTransaction();
                        } catch (Exception e12) {
                            d.printStackTrace(e12);
                        }
                    } catch (Exception e13) {
                        d.printStackTrace(e13);
                        try {
                            wp.endTransaction();
                        } catch (Exception e14) {
                            d.printStackTrace(e14);
                        }
                    }
                } finally {
                    try {
                        wp.endTransaction();
                    } catch (Exception e15) {
                        d.printStackTrace(e15);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor aiM;
        private final List<Integer> aiN = new ArrayList();
        private int aiO;

        public b() {
            try {
                this.aiM = d.this.wp().rawQuery("SELECT * FROM ksad_file_download", null);
            } catch (SQLiteException e10) {
                d.this.a(e10);
            } catch (Exception e11) {
                d.printStackTrace(e11);
            }
        }

        @Override // java.util.Iterator
        /* renamed from: wq */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c d10 = d.d(this.aiM);
            this.aiO = d10.getId();
            return d10;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.aiM;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th2) {
                d.printStackTrace(th2);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.aiN.add(Integer.valueOf(this.aiO));
        }

        public final void wo() {
            Cursor cursor = this.aiM;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.aiN.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.aiN);
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                SQLiteDatabase wp = d.this.wp();
                wp.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                wp.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e10) {
                d.this.a(e10);
            } catch (Exception e11) {
                d.printStackTrace(e11);
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            wp().insert("ksad_file_download", null, cVar.xr());
        } catch (SQLiteException e10) {
            cVar.bs(e10.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    private static void h(Throwable th2) {
        if (th2 != null) {
            th2.printStackTrace();
        }
    }

    public static void printStackTrace(Throwable th2) {
        h(th2);
    }

    public SQLiteDatabase wp() {
        if (this.aiI == null) {
            this.aiI = this.aiH.getWritableDatabase();
        }
        return this.aiI;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bl(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            wp().update("ksad_file_download", cVar.xr(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e10) {
            cVar.bs(e10.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bk(int i10) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:52), block:B:28:0x0033 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bl(int i10) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                try {
                } catch (Exception e10) {
                    e = e10;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
            }
            try {
                cursor = wp().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i10)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwad.framework.filedownloader.d.c d10 = d(cursor);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return d10;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    a(i10, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                } catch (Exception e13) {
                    e = e13;
                    printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (SQLiteException e14) {
                e = e14;
                cursor = null;
                a(i10, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({"Range"})
    public final List<com.kwad.framework.filedownloader.d.a> bm(int i10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = wp().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i10)});
                while (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i10);
                    aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET)));
                    aVar.R(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.S(cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET)));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e10) {
                a(i10, e10);
            } catch (Exception e11) {
                printStackTrace(e11);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bn(int i10) {
        try {
            wp().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i10);
        } catch (SQLiteException e10) {
            printStackTrace(e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bo(int i10) {
        try {
            return wp().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i10)}) != 0;
        } catch (SQLiteException e10) {
            printStackTrace(e10);
            return false;
        } catch (Exception e11) {
            printStackTrace(e11);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bp(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        bo(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            wp().delete("ksad_file_download", null, null);
        } catch (SQLiteException e10) {
            a(e10);
        }
        try {
            wp().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e11) {
            a(e11);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i11));
        try {
            wp().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i10)});
        } catch (SQLiteException e10) {
            a(i10, e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0463a wn() {
        return new a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                wp().insert("ksad_file_download_connection", null, aVar.xr());
            } catch (SQLiteException e10) {
                a(aVar.getId(), e10);
            } catch (Exception e11) {
                printStackTrace(e11);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j10));
        try {
            wp().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11)});
        } catch (SQLiteException e10) {
            a(i10, e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    @SuppressLint({"Range"})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex(t8.a.f30751f)), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.T(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.V(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.bs(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.br(cursor.getString(cursor.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f19041c)));
        cVar.bt(cursor.getString(cursor.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f19043e)));
        cVar.bE(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j10));
        contentValues.put("total", Long.valueOf(j11));
        contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f19041c, str);
        contentValues.put("connectionCount", Integer.valueOf(i11));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j10));
        contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f19041c, str);
        contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f19043e, str2);
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th2.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j10));
        a(i10, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th2.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i10, contentValues);
    }

    public final a.InterfaceC0463a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i10, ContentValues contentValues) {
        try {
            wp().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i10)});
        } catch (SQLiteException e10) {
            a(i10, e10);
        } catch (Exception e11) {
            printStackTrace(e11);
        }
    }

    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i10, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i10 != -1) {
                bo(i10);
                bn(i10);
            }
            h(sQLiteException);
            aiG = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
