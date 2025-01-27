package com.vivo.ic.dm;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class ShutDownReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f28390a = Constants.PRE_TAG + "ShutDownReceiver";

    /* renamed from: b */
    private static final String[] f28391b = {"_id", "status", Downloads.Column.CONTROL, Downloads.Column.NETWORK_CHANGED};

    /* renamed from: c */
    private static boolean f28392c = false;

    class a extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f28393a;

        a(Context context) {
            this.f28393a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ShutDownReceiver.this.b(this.f28393a);
        }
    }

    public static synchronized void b() {
        synchronized (ShutDownReceiver.class) {
            f28392c = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.ACTION_SHUTDOWN".equals(intent.getAction()) && !a()) {
            b();
            a(context);
        }
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (ShutDownReceiver.class) {
            z = f28392c;
        }
        return z;
    }

    public void b(Context context) {
        Cursor cursor;
        if (context == null) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor2 = null;
        try {
            try {
                cursor = contentResolver.query(Downloads.Impl.CONTENT_URI, f28391b, "status!=?", new String[]{String.valueOf(200)}, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (cursor != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                cursor2 = cursor;
                VLog.w(f28390a, "pauseAllDownload error", e);
                if (cursor2 != null) {
                    cursor = cursor2;
                    cursor.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    long j2 = cursor.getLong(0);
                    int i2 = cursor.getInt(1);
                    int i3 = cursor.getInt(2);
                    int i4 = cursor.getInt(3);
                    VLog.i(f28390a, "pauseAllDownload currentId is " + j2 + ", control is " + i3 + ", status is " + i2 + ", changed is " + i4);
                    if (!Downloads.Impl.isStatusCompleted(i2) && !Downloads.Impl.isPausedManually(i3, i4)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Downloads.Column.CONTROL, (Integer) 1);
                        contentValues.put("status", Integer.valueOf(Downloads.Impl.STATUS_PAUSED_BY_APP));
                        contentValues.put(Downloads.Column.NETWORK_CHANGED, (Integer) 2);
                        contentResolver.update(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2), contentValues, null, null);
                    }
                    cursor.moveToNext();
                }
                cursor.close();
                return;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    private void a(Context context) {
        new a(context).start();
    }
}
