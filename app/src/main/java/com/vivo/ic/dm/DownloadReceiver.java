package com.vivo.ic.dm;

import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.impl.DownloadIntercepter;
import com.vivo.ic.dm.impl.DownloadNotiDealer;

/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f28362a = Constants.PRE_TAG + "DownloadReceiver";

    /* renamed from: b */
    private static volatile Handler f28363b;

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f28364a;

        /* renamed from: b */
        final /* synthetic */ Intent f28365b;

        /* renamed from: c */
        final /* synthetic */ DownloadNotiDealer f28366c;

        /* renamed from: d */
        final /* synthetic */ BroadcastReceiver.PendingResult f28367d;

        a(Context context, Intent intent, DownloadNotiDealer downloadNotiDealer, BroadcastReceiver.PendingResult pendingResult) {
            this.f28364a = context;
            this.f28365b = intent;
            this.f28366c = downloadNotiDealer;
            this.f28367d = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadReceiver.this.a(this.f28364a, this.f28365b, this.f28366c);
            this.f28367d.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadNotiDealer l;
        DownloadIntercepter h2;
        if (f28363b == null) {
            HandlerThread handlerThread = new HandlerThread("DownloadReceiver");
            handlerThread.start();
            f28363b = new Handler(handlerThread.getLooper());
        }
        String action = intent.getAction();
        String str = f28362a;
        VLog.i(str, "onReceive action: " + action);
        if (ShutDownReceiver.a()) {
            VLog.i(str, "already shutdown, return");
        }
        l j2 = l.j();
        l = j2.l();
        h2 = j2.h();
        action.hashCode();
        switch (action) {
            case "android.intent.action.MEDIA_MOUNTED":
                if (h2 != null) {
                    h2.handleMediaMounted();
                    break;
                }
                break;
            case "DM_ACTION_NOTI_CONFIRM":
                l.onNotiNetPauseClicked(context);
                break;
            case "android.net.conn.CONNECTIVITY_CHANGE":
                com.vivo.ic.dm.network.h.a().c(context);
                if (h2 != null) {
                    h2.handleNetChange();
                    break;
                }
                break;
            case "DM_ACTION_NOTI_HIDE":
            case "DM_ACTION_NOTI_DOWNLOAD_CLICKED":
            case "DM_ACTION_NOTI_COMPLETE_CLICKED":
                BroadcastReceiver.PendingResult goAsync = goAsync();
                if (goAsync != null) {
                    f28363b.post(new a(context, intent, l, goAsync));
                    break;
                } else {
                    a(context, intent, l);
                    break;
                }
            case "DM_ACTION_DOWNLOAD_RETRY":
                com.vivo.ic.dm.util.e.b(context, "DOWNLOAD_RETRY");
                break;
            default:
                VLog.w(str, "onReceive unknow action >> " + action);
                break;
        }
    }

    private static int a(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(str));
    }

    public void a(Context context, Intent intent, DownloadNotiDealer downloadNotiDealer) {
        String action;
        action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "DM_ACTION_NOTI_HIDE":
                long parseId = ContentUris.parseId(intent.getData());
                VLog.i(f28362a, "NOTI_HIDE of id " + parseId);
                a(context, parseId);
                downloadNotiDealer.onNotiCompleteHidden(context, parseId);
                break;
            case "DM_ACTION_NOTI_DOWNLOAD_CLICKED":
                long parseId2 = ContentUris.parseId(intent.getData());
                VLog.i(f28362a, "NOTI_DOWNLOAD_CLICKED of id " + parseId2);
                downloadNotiDealer.onNotiDownloadClicked(context, parseId2);
                break;
            case "DM_ACTION_NOTI_COMPLETE_CLICKED":
                long parseId3 = ContentUris.parseId(intent.getData());
                VLog.i(f28362a, "NOTI_COMPLETE_CLICKED of id " + parseId3);
                a(context, parseId3);
                downloadNotiDealer.onNotiCompleteClicked(context, parseId3);
                break;
            default:
                VLog.w(f28362a, "handleNotificationBroadcast unknow action >> " + action);
                break;
        }
    }

    private void a(Context context, long j2) {
        Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2);
        Cursor cursor = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(withAppendedId, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            int a2 = a(query, "status");
                            int a3 = a(query, Downloads.Column.VISIBILITY);
                            query.close();
                            if (Downloads.Impl.isStatusCompleted(a2)) {
                                if (a3 == 2 || a3 == 0) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(Downloads.Column.VISIBILITY, (Integer) 1);
                                    context.getContentResolver().update(withAppendedId, contentValues, null, null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        VLog.w(f28362a, "hideNotification error", e);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                VLog.w(f28362a, "Missing details for download " + j2);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
