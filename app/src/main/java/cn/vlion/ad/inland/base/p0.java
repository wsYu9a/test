package cn.vlion.ad.inland.base;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class p0 extends SQLiteOpenHelper {
    public p0(Context context) {
        super(context, "vlion_ad_adx_data", (SQLiteDatabase.CursorFactory) null, 3);
        LogVlion.e("VlionAdxSQLiteOpenHelper() :");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE vlion_ad_adx(KeyId TEXT ,EventUrl TEXT ,EventTime BIGINT ,ApiType TEXT ,EventUrlHeader TEXT)");
            LogVlion.e("VlionAdxSQLiteOpenHelper onCreate 创建成功:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        LogVlion.e("VlionAdxSQLiteOpenHelper onUpgrade oldVersion=" + i10 + " newVersion=" + i11);
        if (i10 == 1) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE vlion_ad_adx ADD EventTime BIGINT ");
                sQLiteDatabase.execSQL("ALTER TABLE vlion_ad_adx ADD ApiType TEXT ");
            } catch (SQLException e10) {
                StringBuilder a10 = l1.a("VlionAdxSQLiteOpenHelper onUpgrade =");
                a10.append(e10.getMessage());
                LogVlion.e(a10.toString());
                VlionSDkManager.getInstance().upLoadCatchException(e10);
                return;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        } else if (i10 != 2) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE vlion_ad_adx ADD EventUrlHeader TEXT ");
    }
}
