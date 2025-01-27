package com.vivo.ic.dm.database;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class DbMoverManager {
    private static final String TAG = Constants.PRE_TAG + "DbMoverManager";
    private static DbMoverManager sInstance = new DbMoverManager();
    private b mMovedDbInfo;
    private boolean mStarted;
    private HashMap<String, String> mTableMap = new HashMap<>();
    private List<c> mTableProperty = new ArrayList();

    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ j f28423a;

        /* renamed from: b */
        final /* synthetic */ Context f28424b;

        a(j jVar, Context context) {
            this.f28423a = jVar;
            this.f28424b = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.vivo.ic.dm.database.a aVar;
            long currentTimeMillis;
            synchronized (this.f28423a) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    aVar = new com.vivo.ic.dm.database.a(this.f28424b, DbMoverManager.this.mMovedDbInfo, DbMoverManager.this.mTableMap, DbMoverManager.this.mTableProperty);
                } catch (Throwable th) {
                    th = th;
                    aVar = null;
                }
                try {
                    if (aVar.e(this.f28423a)) {
                        VLog.i(DbMoverManager.TAG, "db move time uesd:" + (System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        VLog.i(DbMoverManager.TAG, "db move time over:" + (System.currentTimeMillis() - currentTimeMillis) + ", failed");
                        aVar.d(this.f28423a);
                        VLog.i(DbMoverManager.TAG, "db removed");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (aVar != null) {
                        aVar.d(this.f28423a);
                        VLog.i(DbMoverManager.TAG, "db move exception, db removed");
                    }
                }
            }
        }
    }

    static class b {

        /* renamed from: a */
        public String f28426a;

        /* renamed from: b */
        public String f28427b;

        b(String str, String str2) {
            this.f28426a = str;
            this.f28427b = str2;
        }
    }

    static class c {

        /* renamed from: a */
        public String f28428a;

        /* renamed from: b */
        public String f28429b;

        /* renamed from: c */
        public String f28430c;

        c(String str, String str2, String str3) {
            this.f28428a = str;
            this.f28429b = str2;
            this.f28430c = str3;
        }

        public String toString() {
            return "colname:" + this.f28428a + ", original value:" + this.f28429b + ", new value:" + this.f28430c;
        }
    }

    private DbMoverManager() {
    }

    public static DbMoverManager getInstance() {
        return sInstance;
    }

    public synchronized void addChangedProperty(String str, String str2, String str3) {
        if (!this.mStarted && !TextUtils.isEmpty(str)) {
            this.mTableProperty.add(new c(str, str2, str3));
        }
    }

    public synchronized void moveTo(Context context, j jVar) {
        if (context != null && jVar != null) {
            b bVar = this.mMovedDbInfo;
            if (bVar != null) {
                File databasePath = context.getDatabasePath(bVar.f28426a);
                if (databasePath.exists() && databasePath.isFile()) {
                    new a(jVar, context).start();
                    this.mStarted = true;
                    return;
                }
                VLog.i(TAG, "move not needed, return");
            }
        }
    }

    public synchronized void setDefinedTableMap(HashMap<String, String> hashMap) {
        if (!this.mStarted && hashMap != null && !hashMap.isEmpty()) {
            this.mTableMap = (HashMap) hashMap.clone();
            VLog.i(TAG, "setDefinedTableMap mTableMap:" + this.mTableMap);
        }
    }

    public synchronized void setMovedDbInfo(String str, String str2) {
        if (this.mStarted) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mMovedDbInfo = new b(str, str2);
        }
    }
}
