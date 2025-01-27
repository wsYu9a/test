package com.wbl.ad.yzz.wigdet.k.e.u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.k.e.m;
import com.wbl.ad.yzz.wigdet.k.e.q;

/* loaded from: classes5.dex */
public class a extends SQLiteOpenHelper implements c {

    /* renamed from: a */
    public static final String[] f34641a = {"_id", "url", "length", "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        m.a(context);
    }

    public final ContentValues a(q qVar) {
        return (ContentValues) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7763, this, qVar);
    }

    public final q a(Cursor cursor) {
        return (q) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7854, this, cursor);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.u.c
    public q a(String str) {
        return (q) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7853, this, str);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.u.c
    public void a(String str, q qVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7856, this, str, qVar);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7855, this, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7850, this, sQLiteDatabase, Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
