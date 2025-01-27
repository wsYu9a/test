package com.kwad.components.core.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    private static volatile a HD;
    private final SQLiteDatabase HC;

    /* renamed from: com.kwad.components.core.b.a$a */
    static class C0163a extends SQLiteOpenHelper {
        private static int HE = 1;
        private String HF;
        private String HG;

        public C0163a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, HE);
            this.HF = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.HG = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.HF);
            sQLiteDatabase.execSQL(this.HG);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    private a(Context context) {
        this.HC = new C0163a(context).getWritableDatabase();
    }

    private <T extends h> void b(List<T> list, String str) {
        try {
            try {
                this.HC.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.b.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.HC.insertWithOnConflict(str, null, it.next().mj(), 5));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
                this.HC.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.HC;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.printStackTrace(e3);
                    }
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.d.b.printStackTrace(e4);
                SQLiteDatabase sQLiteDatabase2 = this.HC;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e5) {
                        com.kwad.sdk.core.d.b.printStackTrace(e5);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.HC;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.b.printStackTrace(e6);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a lW() {
        KsAdSDKImpl ksAdSDKImpl;
        if (HD == null) {
            synchronized (a.class) {
                if (HD == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                    try {
                        HD = new a(ksAdSDKImpl.getContext());
                    } catch (SQLiteException e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                        HD = null;
                    }
                }
            }
        }
        return HD;
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e ah(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.HC.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
            try {
                List<e> a2 = e.a(cursor);
                if (a2 != null && a2.size() > 0) {
                    e eVar = a2.get(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return eVar;
                }
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0093: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:42:0x0093 */
    @Nullable
    @WorkerThread
    public final List<g> b(String str, long j2, int i2) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.HC.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<g> a2 = g.a(cursor);
                if (a2 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (g gVar : a2) {
                    i3++;
                    if (i3 > i2) {
                        sb.append(" creativeId = ");
                        sb.append(gVar.mr());
                        sb.append(i3 == a2.size() ? ")" : " OR");
                    } else if (gVar.mp() >= j2) {
                        arrayList.add(gVar);
                    }
                }
                if (i3 > i2) {
                    this.HC.delete("ksad_ad_cache", sb.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    public final void f(List<g> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void lX() {
        try {
            this.HC.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @WorkerThread
    public final void m(long j2) {
        try {
            com.kwad.sdk.core.d.b.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.HC.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j2)}));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }
}
