package com.vivo.ic.dm;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.NetworkInfo;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadIntercepter;
import com.vivo.ic.dm.impl.DownloadNotification;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class g implements DownloadIntercepter {

    /* renamed from: a */
    private static final String f28462a = Constants.PRE_TAG + "DownloadIntercepterDealer";

    /* renamed from: b */
    private static final byte[] f28463b = new byte[0];

    /* renamed from: c */
    private static final long f28464c = 1000;

    /* renamed from: d */
    private Context f28465d;

    /* renamed from: e */
    private DownloadNotification f28466e;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.c(gVar.f28465d.getContentResolver());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.a(gVar.f28465d.getContentResolver());
        }
    }

    private interface c {

        /* renamed from: a */
        public static final String[] f28469a = {"_id", Downloads.Column.CONTROL, "status", Downloads.Column.NETWORK_CHANGED, Downloads.Column.VISIBILITY, Downloads.Column.LAST_NETWORK};

        /* renamed from: b */
        public static final int f28470b = 0;

        /* renamed from: c */
        public static final int f28471c = 1;

        /* renamed from: d */
        public static final int f28472d = 2;

        /* renamed from: e */
        public static final int f28473e = 3;

        /* renamed from: f */
        public static final int f28474f = 4;

        /* renamed from: g */
        public static final int f28475g = 5;
    }

    public g(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0092, code lost:
    
        if (r10 != null) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.ContentResolver r13) {
        /*
            r12 = this;
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 0
            r0 = 0
            android.net.Uri r2 = com.vivo.ic.dm.Downloads.Impl.CONTENT_URI     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            java.lang.String[] r3 = com.vivo.ic.dm.g.c.f28469a     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            java.lang.String r4 = "status!=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            r1 = 200(0xc8, float:2.8E-43)
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            r5[r8] = r1     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            r6 = 0
            r1 = r13
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            if (r10 == 0) goto L92
            r10.moveToFirst()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
        L23:
            boolean r0 = r10.isAfterLast()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            if (r0 != 0) goto L80
            long r0 = r10.getLong(r8)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            int r2 = r10.getInt(r9)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r3 = 2
            int r3 = r10.getInt(r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r4 = 3
            int r4 = r10.getInt(r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r5 = com.vivo.ic.dm.g.f28462a     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r6.<init>()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r11 = "handleInNoNet currentId:"
            r6.append(r11)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r6.append(r0)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r11 = ", control:"
            r6.append(r11)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r6.append(r2)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r11 = ", status:"
            r6.append(r11)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r6.append(r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r11 = ", changed:"
            r6.append(r11)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r6.append(r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            com.vivo.ic.VLog.d(r5, r6)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            boolean r3 = com.vivo.ic.dm.Downloads.Impl.isStatusCompleted(r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            if (r3 != 0) goto L7c
            boolean r2 = com.vivo.ic.dm.Downloads.Impl.isPausedManually(r2, r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            if (r2 != 0) goto L7c
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            r7.add(r0)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
        L7c:
            r10.moveToNext()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            goto L23
        L80:
            r3 = 1
            r4 = 193(0xc1, float:2.7E-43)
            r5 = 3
            r6 = -1
            r0 = r12
            r1 = r13
            r2 = r7
            r0.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L8f
            goto L92
        L8c:
            r13 = move-exception
            r0 = r10
            goto Ld6
        L8f:
            r13 = move-exception
            r0 = r10
            goto L98
        L92:
            if (r10 == 0) goto La5
            goto La2
        L95:
            r13 = move-exception
            goto Ld6
        L97:
            r13 = move-exception
        L98:
            java.lang.String r1 = com.vivo.ic.dm.g.f28462a     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = "handleInNoNet error"
            com.vivo.ic.VLog.w(r1, r2, r13)     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto La5
            r10 = r0
        La2:
            r10.close()
        La5:
            int r13 = r7.size()
            if (r13 <= 0) goto Ld5
            int r13 = r7.size()
            long[] r13 = new long[r13]
            r0 = 0
        Lb2:
            int r1 = r7.size()
            if (r0 >= r1) goto Lc7
            java.lang.Object r1 = r7.get(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r13[r0] = r1
            int r0 = r0 + 1
            goto Lb2
        Lc7:
            com.vivo.ic.dm.f r0 = com.vivo.ic.dm.f.b()
            r0.a(r13)
            com.vivo.ic.dm.datareport.a r13 = com.vivo.ic.dm.datareport.a.a()
            r13.c(r7, r8)
        Ld5:
            return
        Ld6:
            if (r0 == 0) goto Ldb
            r0.close()
        Ldb:
            goto Ldd
        Ldc:
            throw r13
        Ldd:
            goto Ldc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.g.b(android.content.ContentResolver):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x009c, code lost:
    
        if (r10 != null) goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.ContentResolver r13) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.g.c(android.content.ContentResolver):void");
    }

    @Override // com.vivo.ic.dm.impl.DownloadIntercepter
    public boolean handleMediaMounted() {
        NetworkInfo a2 = com.vivo.ic.dm.util.b.a();
        if (a2 != null && a2.isConnected() && a2.getType() == 1) {
            com.vivo.ic.dm.util.e.b(this.f28465d, "ACTION_MEDIA_MOUNTED");
        } else {
            VLog.i(f28462a, "handleMediaMounted network not satisfied, do nothing");
        }
        return true;
    }

    @Override // com.vivo.ic.dm.impl.DownloadIntercepter
    public boolean handleNetChange() {
        synchronized (f28463b) {
            com.vivo.ic.dm.p.a.b().a(this.f28465d);
            com.vivo.ic.dm.p.a.a().a(this.f28465d);
            NetworkInfo a2 = com.vivo.ic.dm.util.b.a();
            if (a2 != null && a2.isConnected()) {
                if (!com.vivo.ic.dm.util.b.d()) {
                    com.vivo.ic.dm.util.e.b(this.f28465d, "net change remind false " + a2.getState());
                    VLog.i(f28462a, "just start service in handleNetChange because of user choose never remind ");
                    return true;
                }
                VLog.d(f28462a, "handleNetChange info state is " + a2.getState() + " info type is " + a2.getType());
                if (a2.isConnected()) {
                    int type = a2.getType();
                    if (type == 0) {
                        com.vivo.ic.dm.q.e.a(new b(), 1000L, 5);
                    } else if (type == 1) {
                        DownloadNotification downloadNotification = this.f28466e;
                        if (downloadNotification != null) {
                            downloadNotification.hideNetPauseNotification();
                        }
                        com.vivo.ic.dm.q.e.a(new a(), 1000L, 5);
                    }
                }
                return true;
            }
            VLog.i(f28462a, "handleNetChange() Network not connected");
            b(this.f28465d.getContentResolver());
            return true;
        }
    }

    public g(Context context, DownloadNotification downloadNotification) {
        this.f28465d = context.getApplicationContext();
        this.f28466e = downloadNotification;
    }

    public void a(DownloadNotification downloadNotification) {
        this.f28466e = downloadNotification;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x00e7, code lost:
    
        if (r12 != null) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.ContentResolver r17) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.g.a(android.content.ContentResolver):void");
    }

    private void a(ContentResolver contentResolver, ArrayList<Long> arrayList, int i2, int i3, int i4, int i5) {
        if (arrayList.size() > 0) {
            VLog.d(f28462a, "patchUpdate ids:" + arrayList);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Column.CONTROL, Integer.valueOf(i2));
            contentValues.put("status", Integer.valueOf(i3));
            contentValues.put(Downloads.Column.NETWORK_CHANGED, Integer.valueOf(i4));
            if (i5 != -1) {
                contentValues.put(Downloads.Column.LAST_NETWORK, Integer.valueOf(i5));
            }
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                arrayList2.add(ContentProviderOperation.newUpdate(Downloads.Impl.CONTENT_URI).withValues(contentValues).withSelection("_id =? ", new String[]{String.valueOf(arrayList.get(i6))}).build());
            }
            try {
                contentResolver.applyBatch(Downloads.Impl.AUTHOR, arrayList2);
            } catch (Exception e2) {
                VLog.e(f28462a, "pause download applyBatch exception:" + e2);
            }
        }
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        if (i2 == 1 && i3 == 193 && i4 == 2 && i5 != 3 && i5 != 2) {
            return l.j().t();
        }
        return false;
    }
}
