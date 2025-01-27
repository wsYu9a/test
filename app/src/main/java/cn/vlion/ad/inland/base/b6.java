package cn.vlion.ad.inland.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b6 extends SQLiteOpenHelper {
    public b6(Context context) {
        super(context, "vlion_ad_event_data", (SQLiteDatabase.CursorFactory) null, 1);
        LogVlion.e("VlionSQLiteOpenHelper() :");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE vlion_ad_event(KeyId TEXT ,EventType TEXT ,EventString TEXT)");
            LogVlion.e("VlionSQLiteOpenHelper onCreate 创建成功:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
