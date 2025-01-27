package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* renamed from: com.umeng.analytics.process.UMProcessDBHelper$1 */
    public class AnonymousClass1 implements DBFileTraversalUtil.a {
        public AnonymousClass1() {
        }

        @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
        public void a() {
            if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
            }
        }
    }

    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        public /* synthetic */ InsertEventCallback(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f24201c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f24202d, ""), (JSONArray) obj);
            return true;
        }
    }

    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        public /* synthetic */ ProcessToMainCallback(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f24201c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f24202d, ""));
            return true;
        }
    }

    public class a implements Serializable {

        /* renamed from: a */
        int f24190a;

        /* renamed from: b */
        String f24191b;

        /* renamed from: c */
        String f24192c;

        /* renamed from: d */
        String f24193d;

        /* renamed from: e */
        int f24194e;

        /* renamed from: f */
        String f24195f;

        /* renamed from: g */
        String f24196g;

        /* renamed from: h */
        String f24197h;

        private a() {
        }

        public /* synthetic */ a(UMProcessDBHelper uMProcessDBHelper, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                a aVar = new a();
                aVar.f24192c = jSONObject.optString("id");
                aVar.f24196g = UMUtils.getAppVersionName(this.mContext);
                aVar.f24197h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f24191b = jSONObject.optString("__i");
                aVar.f24194e = jSONObject.optInt("__t");
                aVar.f24195f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f24193d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new UMProcessDBHelper(context);
                    }
                } finally {
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase a10;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a10 = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                a10.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f24191b);
                        contentValues.put("__e", aVar.f24192c);
                        contentValues.put("__t", Integer.valueOf(aVar.f24194e));
                        contentValues.put(a.InterfaceC0669a.f24212f, aVar.f24195f);
                        contentValues.put("__av", aVar.f24196g);
                        contentValues.put("__vc", aVar.f24197h);
                        contentValues.put("__s", aVar.f24193d);
                        a10.insert(a.InterfaceC0669a.f24207a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                a10.setTransactionSuccessful();
                try {
                    a10.endTransaction();
                } catch (Throwable unused3) {
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = a10;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused4) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused5) {
            sQLiteDatabase = a10;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            return false;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f24206h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b9, code lost:
    
        if (r2 != null) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:36:0x00bf, B:30:0x00c4), top: B:35:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> Laa java.lang.Exception -> Lad
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> Laa java.lang.Exception -> Lad
            android.database.sqlite.SQLiteDatabase r2 = r2.a(r13)     // Catch: java.lang.Throwable -> Laa java.lang.Exception -> Lad
            r2.beginTransaction()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "__et_p"
            r9 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r3 == 0) goto L91
        L22:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            if (r4 == 0) goto L91
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.<init>()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24190a = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24191b = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24192c = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24193d = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24194e = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24195f = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24196g = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4.f24197h = r5     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r0.add(r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            goto L22
        L8c:
            r0 = move-exception
            r1 = r3
            goto Lbd
        L8f:
            r1 = move-exception
            goto Lb1
        L91:
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.lang.Exception -> L99
        L96:
            r2.endTransaction()     // Catch: java.lang.Exception -> L99
        L99:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            goto Lbc
        La3:
            r0 = move-exception
            goto Lbd
        La5:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto Lb1
        Laa:
            r0 = move-exception
            r2 = r1
            goto Lbd
        Lad:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        Lb1:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto Lb9
            r3.close()     // Catch: java.lang.Exception -> L99
        Lb9:
            if (r2 == 0) goto L99
            goto L96
        Lbc:
            return r0
        Lbd:
            if (r1 == 0) goto Lc2
            r1.close()     // Catch: java.lang.Exception -> Lc7
        Lc2:
            if (r2 == 0) goto Lc7
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc7
        Lc7:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th2 = th3;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i10).f24190a);
                }
            } else {
                sQLiteDatabase.delete(a.InterfaceC0669a.f24207a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th4) {
            th2 = th4;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th2;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r1 == null) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r5.mContext     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
        L14:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r2 == 0) goto L34
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.delete(r3, r4, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            goto L14
        L30:
            r6 = move-exception
            goto L44
        L32:
            goto L53
        L34:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
        L37:
            r1.endTransaction()
        L3a:
            android.content.Context r6 = r5.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.c.a(r6)
            r6.b(r0)
            goto L56
        L44:
            if (r1 == 0) goto L49
            r1.endTransaction()
        L49:
            android.content.Context r1 = r5.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r6
        L53:
            if (r1 == 0) goto L3a
            goto L37
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                public AnonymousClass1() {
                }

                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6 A[Catch: all -> 0x00a9, Exception -> 0x00ac, TryCatch #6 {Exception -> 0x00ac, all -> 0x00a9, blocks: (B:6:0x0016, B:8:0x0028, B:10:0x002f, B:12:0x0035, B:15:0x0078, B:18:0x007f, B:27:0x0089, B:29:0x00a0, B:32:0x00d0, B:34:0x00d6, B:35:0x00e0, B:37:0x00ef, B:39:0x00f6, B:61:0x00db, B:62:0x00b3, B:43:0x010b, B:45:0x0111, B:46:0x011a, B:48:0x0120, B:51:0x013d, B:56:0x0141, B:58:0x0147, B:68:0x014c), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db A[Catch: all -> 0x00a9, Exception -> 0x00ac, TryCatch #6 {Exception -> 0x00ac, all -> 0x00a9, blocks: (B:6:0x0016, B:8:0x0028, B:10:0x002f, B:12:0x0035, B:15:0x0078, B:18:0x007f, B:27:0x0089, B:29:0x00a0, B:32:0x00d0, B:34:0x00d6, B:35:0x00e0, B:37:0x00ef, B:39:0x00f6, B:61:0x00db, B:62:0x00b3, B:43:0x010b, B:45:0x0111, B:46:0x011a, B:48:0x0120, B:51:0x013d, B:56:0x0141, B:58:0x0147, B:68:0x014c), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        ?? r32 = 0;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        Cursor cursor = null;
        r32 = 0;
        try {
            try {
                sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f24206h);
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0669a.f24207a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e10) {
                                        e = e10;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f24206h);
                                                r32 = jSONObject;
                                                return r32;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f24206h);
                                        r32 = jSONObject;
                                        return r32;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                jSONObject = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r32 = query;
                            if (r32 != 0) {
                                try {
                                    r32.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.f24206h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.f24206h);
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f24206h);
                    r32 = jSONObject2;
                } catch (Exception e12) {
                    e = e12;
                    jSONObject = null;
                }
            } catch (Exception e13) {
                e = e13;
                sQLiteDatabase = null;
                jSONObject = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
            return r32;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
