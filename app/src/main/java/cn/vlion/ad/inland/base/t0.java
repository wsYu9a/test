package cn.vlion.ad.inland.base;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.File;

/* loaded from: classes.dex */
public final class t0 {

    public static class a {

        /* renamed from: a */
        public long f3369a;

        /* renamed from: b */
        public String f3370b;

        public a(String str, long j10) {
            this.f3369a = j10;
            this.f3370b = str;
        }
    }

    public static int a(Context context) {
        Cursor query;
        int i10 = 0;
        if (context == null) {
            return 0;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getApplicationContext().getSystemService("download");
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterByStatus(8);
            query = downloadManager.query(query2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (query == null) {
            return 0;
        }
        if (query.moveToFirst()) {
            do {
                i10++;
            } while (query.moveToNext());
        }
        LogVlion.e("VlionApkQueryUtils  checkDownSuccess size=" + i10);
        query.close();
        return i10;
    }

    public static boolean b(Context context, long j10) {
        if (context == null) {
            return false;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getApplicationContext().getSystemService("download");
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j10);
            query.setFilterByStatus(8);
            Cursor query2 = downloadManager.query(query);
            if (query2 == null) {
                return false;
            }
            if (query2.moveToFirst()) {
                return true;
            }
            query2.close();
            LogVlion.e("VlionApkQueryUtils !cursor.moveToFirst()=true");
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static boolean c(Context context, long j10) {
        if (context == null) {
            return false;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getApplicationContext().getSystemService("download");
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j10);
            Cursor query2 = downloadManager.query(query);
            if (query2 == null) {
                return false;
            }
            if (query2.moveToFirst()) {
                return true;
            }
            query2.close();
            LogVlion.e("VlionApkQueryUtils !cursor.moveToFirst()=true");
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static a a(Context context, String str, String str2) {
        String string;
        int i10 = 0;
        try {
            if (context == null) {
                return new a("", 0L);
            }
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setNotificationVisibility(1);
            request.setVisibleInDownloadsUi(true);
            request.setAllowedNetworkTypes(3);
            request.setDestinationUri(Uri.fromFile(new File(t.a(context) + str2.concat(".apk"))));
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            long enqueue = downloadManager.enqueue(request);
            LogVlion.e("VlionApkQueryUtils downloadId=" + enqueue);
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(enqueue);
            Cursor query2 = downloadManager.query(query);
            if (query2 == null) {
                return new a("", enqueue);
            }
            if (query2.moveToFirst()) {
                int columnIndex = query2.getColumnIndex(Build.VERSION.SDK_INT >= 24 ? "local_uri" : "local_filename");
                if (columnIndex >= 0) {
                    i10 = columnIndex;
                }
                string = query2.getString(i10);
            } else {
                query2.close();
                LogVlion.e("VlionApkQueryUtils !cursor.moveToFirst()=true");
                string = "";
            }
            return new a(string, enqueue);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return new a("", 0L);
        }
    }

    public static void a(Context context, long j10) {
        if (context == null) {
            return;
        }
        try {
            ((DownloadManager) context.getApplicationContext().getSystemService("download")).remove(j10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(Context context, long j10, DownloadApkData.a.C0022a c0022a) {
        if (context == null) {
            return;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getApplicationContext().getSystemService("download");
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j10);
            Cursor query2 = downloadManager.query(query);
            if (query2 == null) {
                return;
            }
            if (!query2.moveToFirst()) {
                query2.close();
                LogVlion.e("VlionApkQueryUtils !cursor.moveToFirst()=true");
                c0022a.b();
                return;
            }
            int columnIndex = query2.getColumnIndex("_id");
            if (columnIndex > 0) {
                query2.getLong(columnIndex);
            }
            long j11 = query2.getColumnIndex("status") > 0 ? query2.getInt(r8) : -1L;
            int columnIndex2 = query2.getColumnIndex("bytes_so_far");
            long j12 = columnIndex2 > 0 ? query2.getLong(columnIndex2) : -1L;
            int columnIndex3 = query2.getColumnIndex("total_size");
            long j13 = columnIndex3 > 0 ? query2.getLong(columnIndex3) : -1L;
            int columnIndex4 = query2.getColumnIndex(Build.VERSION.SDK_INT >= 24 ? "local_uri" : "local_filename");
            if (columnIndex4 < 0) {
                return;
            }
            String string = query2.getString(columnIndex4);
            query2.close();
            LogVlion.e("VlionApkQueryUtils status=" + j11);
            if (j11 == 8) {
                c0022a.onDownloadSuccess(string);
                return;
            }
            if (j11 == 16) {
                c0022a.onDownloadFailed();
                return;
            }
            if (j11 == 1) {
                c0022a.a();
                return;
            }
            if (j11 != 2) {
                if (j11 == 4) {
                    c0022a.onDownloadPaused();
                    return;
                }
                return;
            }
            int i10 = (int) ((100 * j12) / j13);
            LogVlion.e("VlionApkQueryUtils downloadedSoFar=" + j12 + " totalSize=" + j13 + " percent=" + i10);
            c0022a.onDownloadApkProgress(i10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
