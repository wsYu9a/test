package com.martian.libmars.utils;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.webkit.URLUtil;
import com.martian.libmars.activity.j1;
import java.io.IOException;

/* loaded from: classes2.dex */
public class l0 {

    public interface a {
        void a(String name, String url);
    }

    static /* synthetic */ void a(DialogInterface dialog, int which) {
    }

    private static void c(final j1 activity, final String url, final String filename, final String path, final a receiver) {
        String str = !com.martian.libmars.d.h.F().U0() ? "\n(wifi未连接, 将使用流量下载)" : "";
        com.martian.dialog.g.i(activity).q("文件下载").A("是否下载 \"" + filename + "\"？" + str).C(new DialogInterface.OnClickListener() { // from class: com.martian.libmars.utils.d0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                l0.a(dialogInterface, i2);
            }
        }).H(new DialogInterface.OnClickListener() { // from class: com.martian.libmars.utils.e0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                l0.e(j1.this, url, filename, path, receiver);
            }
        }).k();
    }

    public static void d(final j1 activity, final String url, final String filename, final a receiver, boolean downloadHint) {
        String P = com.martian.libmars.d.h.F().P();
        if (downloadHint || !com.martian.libmars.d.h.F().U0()) {
            c(activity, url, filename, P, receiver);
        } else {
            e(activity, url, filename, P, receiver);
        }
    }

    @TargetApi(11)
    public static void e(j1 activity, String url, String filename, String path, a receiver) {
        try {
            com.martian.libsupport.e.i(path);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(path, filename);
            ((DownloadManager) activity.getSystemService("download")).enqueue(request);
        } catch (Exception unused) {
            activity.n1(url);
        }
        if (receiver != null) {
            receiver.a(filename, url);
        }
    }

    public static void f(final j1 activity, final String url, String contentDisposition, String mime, final a receiver, boolean downloadHint) {
        d(activity, url, URLUtil.guessFileName(url, contentDisposition, mime), receiver, downloadHint);
    }
}
