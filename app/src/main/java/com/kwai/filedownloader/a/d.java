package com.kwai.filedownloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.cdo.oaps.ad.OapsWrapper;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.vivo.ic.dm.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class d implements com.kwai.filedownloader.a.a {
    private static boolean aGE = false;
    private SQLiteDatabase aGD;

    public class a implements a.InterfaceC0237a {
        private final SparseArray<com.kwai.filedownloader.c.c> aGF;
        private b aGG;
        private final SparseArray<com.kwai.filedownloader.c.c> aGt;
        private final SparseArray<List<com.kwai.filedownloader.c.a>> aGu;

        a(d dVar) {
            this(null, null);
        }

        a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
            this.aGF = new SparseArray<>();
            this.aGt = sparseArray;
            this.aGu = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void Hy() {
            b bVar = this.aGG;
            if (bVar != null) {
                bVar.Hy();
            }
            if (d.this.aGD == null) {
                return;
            }
            int size = this.aGF.size();
            try {
                if (size < 0) {
                    return;
                }
                try {
                    d.this.aGD.beginTransaction();
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = this.aGF.keyAt(i2);
                        com.kwai.filedownloader.c.c cVar = this.aGF.get(keyAt);
                        d.this.aGD.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                        d.this.aGD.insert("ksad_file_download", null, cVar.Iz());
                        if (cVar.ID() > 1) {
                            List<com.kwai.filedownloader.c.a> cJ = d.this.cJ(keyAt);
                            if (cJ.size() > 0) {
                                d.this.aGD.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                for (com.kwai.filedownloader.c.a aVar : cJ) {
                                    aVar.setId(cVar.getId());
                                    d.this.aGD.insert("ksad_file_download_connection", null, aVar.Iz());
                                }
                            }
                        }
                    }
                    SparseArray<com.kwai.filedownloader.c.c> sparseArray = this.aGt;
                    if (sparseArray != null && this.aGu != null) {
                        synchronized (sparseArray) {
                            int size2 = this.aGt.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                int id = this.aGt.valueAt(i3).getId();
                                List<com.kwai.filedownloader.c.a> cJ2 = d.this.cJ(id);
                                if (cJ2 != null && cJ2.size() > 0) {
                                    synchronized (this.aGu) {
                                        this.aGu.put(id, cJ2);
                                    }
                                }
                            }
                        }
                    }
                    d.this.aGD.setTransactionSuccessful();
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e2) {
                            d.printStackTrace(e2);
                        }
                    }
                } catch (SQLiteException e3) {
                    d.this.a(e3);
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e4) {
                            d.printStackTrace(e4);
                        }
                    }
                } catch (Exception e5) {
                    d.printStackTrace(e5);
                    if (d.this.aGD != null) {
                        try {
                            d.this.aGD.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                }
            } catch (Throwable th) {
                if (d.this.aGD != null) {
                    try {
                        d.this.aGD.endTransaction();
                    } catch (Exception e7) {
                        d.printStackTrace(e7);
                    }
                }
                throw th;
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void a(int i2, com.kwai.filedownloader.c.c cVar) {
            this.aGF.put(i2, cVar);
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0237a
        public final void c(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray = this.aGt;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aGt.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            b bVar = d.this.new b();
            this.aGG = bVar;
            return bVar;
        }
    }

    class b implements Iterator<com.kwai.filedownloader.c.c> {
        private Cursor aGI;
        private final List<Integer> aGJ = new ArrayList();
        private int aGK;

        b() {
            if (d.this.aGD != null) {
                try {
                    this.aGI = d.this.aGD.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e2) {
                    d.this.a(e2);
                } catch (Exception e3) {
                    d.printStackTrace(e3);
                }
            }
        }

        @Override // java.util.Iterator
        /* renamed from: Hz */
        public com.kwai.filedownloader.c.c next() {
            com.kwai.filedownloader.c.c j2 = d.j(this.aGI);
            this.aGK = j2.getId();
            return j2;
        }

        final void Hy() {
            Cursor cursor;
            if (d.this.aGD == null || (cursor = this.aGI) == null) {
                return;
            }
            cursor.close();
            if (this.aGJ.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.aGJ);
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "delete %s", join);
            }
            try {
                d.this.aGD.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                d.this.aGD.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                d.this.a(e2);
            } catch (Exception e3) {
                d.printStackTrace(e3);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.aGI;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.aGJ.add(Integer.valueOf(this.aGK));
        }
    }

    public d() {
        try {
            this.aGD = new e(com.kwai.filedownloader.e.c.IZ()).getWritableDatabase();
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    private void a(int i2, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
            } catch (SQLiteException e2) {
                a(i2, e2);
            } catch (Exception e3) {
                printStackTrace(e3);
            }
        }
    }

    private void a(int i2, @Nullable SQLiteException sQLiteException) {
        if (!(sQLiteException instanceof SQLiteFullException)) {
            printStackTrace(sQLiteException);
            return;
        }
        if (i2 != -1) {
            cL(i2);
            cK(i2);
        }
        o(sQLiteException);
        aGE = true;
    }

    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("ksad_file_download", null, cVar.Iz());
            } catch (SQLiteException e2) {
                cVar.fw(e2.toString());
                cVar.e((byte) -1);
                a(cVar.getId(), e2);
            } catch (Exception e3) {
                printStackTrace(e3);
            }
        }
    }

    public static com.kwai.filedownloader.c.c j(Cursor cursor) {
        com.kwai.filedownloader.c.c cVar = new com.kwai.filedownloader.c.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.g(cursor.getString(cursor.getColumnIndex(OapsWrapper.KEY_PATH)), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.e((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.ao(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.aq(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.fw(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.fv(cursor.getString(cursor.getColumnIndex(Downloads.Column.ETAG)));
        cVar.fx(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.db(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    private static void o(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    public static void printStackTrace(Throwable th) {
        o(th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void A(int i2, int i3) {
        if (this.aGD == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        try {
            this.aGD.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0237a Hx() {
        return new a(this);
    }

    public final a.InterfaceC0237a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        if (this.aGD == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        try {
            this.aGD.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put(Downloads.Column.ETAG, str);
        contentValues.put("filename", str2);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put(Downloads.Column.ETAG, str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        if (aVar == null || (sQLiteDatabase = this.aGD) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.Iz());
        } catch (SQLiteException e2) {
            a(aVar.getId(), e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (this.aGD == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cI(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            this.aGD.update("ksad_file_download", cVar.Iz(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e2) {
            cVar.fw(e2.toString());
            cVar.e((byte) -1);
            a(cVar.getId(), e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cI(int i2) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = this.aGD;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i2)});
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(sQLiteDatabase2);
                throw th;
            }
            try {
                if (cursor.moveToNext()) {
                    com.kwai.filedownloader.c.c j2 = j(cursor);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return j2;
                }
            } catch (SQLiteException e4) {
                e = e4;
                a(i2, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            } catch (Exception e5) {
                e = e5;
                printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cJ(int i2) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i2)});
                    while (cursor.moveToNext()) {
                        com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                        aVar.setId(i2);
                        aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                        aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET)));
                        aVar.am(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                        aVar.an(cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET)));
                        arrayList.add(aVar);
                    }
                } catch (Exception e2) {
                    printStackTrace(e2);
                }
            } catch (SQLiteException e3) {
                a(i2, e3);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cK(int i2) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i2);
        } catch (SQLiteException e2) {
            printStackTrace(e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cL(int i2) {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
        } catch (SQLiteException | Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cM(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        SQLiteDatabase sQLiteDatabase = this.aGD;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("ksad_file_download", null, null);
            } catch (SQLiteException e2) {
                a(e2);
            }
            try {
                this.aGD.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e3) {
                a(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
        cL(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void g(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }
}
