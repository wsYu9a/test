package com.shu.priory.download.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a */
    private static final String[] f17004a = {"_id", "uri", t8.a.f30751f};

    /* renamed from: b */
    private static final String f17005b = String.format("REPLACE INTO %s (_id,uri,path) VALUES(?,?,?);", "download_info");

    /* renamed from: c */
    private c f17006c;

    /* renamed from: d */
    private SQLiteDatabase f17007d;

    /* renamed from: e */
    private SQLiteDatabase f17008e;

    public b(Context context) {
        c cVar = new c(context);
        this.f17006c = cVar;
        this.f17007d = cVar.getWritableDatabase();
        this.f17008e = this.f17006c.getReadableDatabase();
    }

    @Override // com.shu.priory.download.c.a
    public com.shu.priory.download.d.a a(int i10) {
        Cursor query = this.f17008e.query("download_info", f17004a, "_id=?", new String[]{String.valueOf(i10)}, null, null, null);
        com.shu.priory.download.d.a aVar = null;
        if (query != null && query.getCount() > 0) {
            while (query.moveToNext()) {
                aVar = new com.shu.priory.download.d.a();
                a(query, aVar);
            }
            query.close();
        }
        return aVar;
    }

    @Override // com.shu.priory.download.c.a
    public void b(com.shu.priory.download.d.a aVar) {
        this.f17007d.delete("download_info", "_id=?", new String[]{String.valueOf(aVar.h())});
    }

    @Override // com.shu.priory.download.c.a
    public List<com.shu.priory.download.d.a> a() {
        Cursor query = this.f17008e.query("download_info", null, null, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (query != null && query.getCount() > 0) {
            while (query.moveToNext()) {
                com.shu.priory.download.d.a aVar = new com.shu.priory.download.d.a();
                a(query, aVar);
                arrayList.add(aVar);
            }
            query.close();
        }
        return arrayList;
    }

    private void a(Cursor cursor, com.shu.priory.download.d.a aVar) {
        aVar.b(cursor.getInt(0));
        aVar.a(cursor.getString(1));
        aVar.b(cursor.getString(2));
    }

    @Override // com.shu.priory.download.c.a
    public void a(com.shu.priory.download.d.a aVar) {
        this.f17007d.execSQL(f17005b, new Object[]{Integer.valueOf(aVar.h()), aVar.b(), aVar.c()});
    }
}
