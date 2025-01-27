package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a {
    private static volatile a KO;
    private final SQLiteDatabase KN;

    /* renamed from: com.kwad.components.core.c.a$a */
    public static class C0417a extends SQLiteOpenHelper {
        private static int KP = 1;
        private String KQ;
        private String KR;

        public C0417a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, KP);
            this.KQ = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.KR = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.KQ);
            sQLiteDatabase.execSQL(this.KR);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        }
    }

    private a(Context context) {
        this.KN = new C0417a(context).getWritableDatabase();
    }

    private <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.KN.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.KN.insertWithOnConflict(str, null, it.next().ns(), 5));
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
                this.KN.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.KN;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e11) {
                        com.kwad.sdk.core.d.c.printStackTrace(e11);
                    }
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase2 = this.KN;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e12) {
                        com.kwad.sdk.core.d.c.printStackTrace(e12);
                    }
                }
                throw th2;
            }
        } catch (Exception e13) {
            com.kwad.sdk.core.d.c.printStackTrace(e13);
            SQLiteDatabase sQLiteDatabase3 = this.KN;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e14) {
                    com.kwad.sdk.core.d.c.printStackTrace(e14);
                }
            }
        }
    }

    @Nullable
    public static a nj() {
        if (KO == null) {
            synchronized (a.class) {
                if (KO == null) {
                    try {
                        KO = new a(ServiceProvider.MA());
                    } catch (SQLiteException e10) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                        KO = null;
                    }
                }
            }
        }
        return KO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e Z(String str) {
        Throwable th2;
        Cursor cursor;
        try {
            try {
                cursor = this.KN.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e10) {
                e = e10;
                cursor = null;
            } catch (Throwable th3) {
                th2 = th3;
                str = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th2;
            }
            try {
                List<e> a10 = e.a(cursor);
                if (a10 != null && a10.size() > 0) {
                    e eVar = a10.get(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return eVar;
                }
            } catch (Exception e11) {
                e = e11;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
            throw th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:45:0x0057 */
    @Nullable
    @WorkerThread
    public final List<h> a(String str, long j10, int i10) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.KN.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e10) {
                e = e10;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<h> a10 = h.a(cursor);
                if (a10 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb2 = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i11 = 0;
                for (h hVar : a10) {
                    i11++;
                    if (i11 > i10) {
                        sb2.append(" creativeId = ");
                        sb2.append(hVar.nB());
                        if (i11 == a10.size()) {
                            sb2.append(")");
                        } else {
                            sb2.append(" OR");
                        }
                    } else if (hVar.nz() >= j10) {
                        arrayList.add(hVar);
                    }
                }
                if (i11 > i10) {
                    this.KN.delete("ksad_ad_cache", sb2.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e11) {
                e = e11;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    public final void i(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void nk() {
        try {
            this.KN.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    @WorkerThread
    public final void r(long j10) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.KN.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j10)}));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }
}
