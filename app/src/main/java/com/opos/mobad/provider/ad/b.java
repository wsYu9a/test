package com.opos.mobad.provider.ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "opos_mobad_ad", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void b(String str) {
        try {
            com.opos.cmn.an.f.a.b("", "delete:" + str + ",result:" + getWritableDatabase().delete("mobad_ad", "posId=" + str, new String[0]));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("", "", e2);
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00c4: MOVE (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:48:0x00c4 */
    public com.opos.mobad.provider.ad.AdEntity a(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.ad.b.a(java.lang.String):com.opos.mobad.provider.ad.AdEntity");
    }

    public void a(String str, AdEntity adEntity) {
        synchronized (this) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("posId", str);
            contentValues.put(MiConfigSingleton.t0, adEntity.f23120b);
            contentValues.put("validTime", Long.valueOf(adEntity.f23121c));
            contentValues.put("posData", adEntity.f23119a);
            getWritableDatabase().replace("mobad_ad", null, contentValues);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE mobad_ad(posId TEXT PRIMARY KEY,data BLOB,posData BLOB,validTime INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
