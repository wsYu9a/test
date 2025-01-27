package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static volatile d f21248a;

    /* renamed from: b */
    private long f21249b = 0;

    /* renamed from: c */
    private ConcurrentHashMap<String, e> f21250c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private HashMap<String, Integer> f21251d = new HashMap<>();

    /* renamed from: e */
    private List<String> f21252e = new CopyOnWriteArrayList();

    public static d a() {
        if (f21248a == null) {
            synchronized (d.class) {
                try {
                    if (f21248a == null) {
                        f21248a = new d();
                    }
                } finally {
                }
            }
        }
        return f21248a;
    }

    public long b() {
        return this.f21249b;
    }

    public void c() {
        this.f21249b = System.currentTimeMillis();
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f21251d == null) {
            this.f21251d = new HashMap<>();
        }
        if (this.f21251d.containsKey(str)) {
            return this.f21251d.get(str).intValue();
        }
        return 0;
    }

    public void a(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f21250c.put(str, eVar);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f21250c.remove(str);
    }

    @WorkerThread
    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || bVar.b() <= 0 || (downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(bVar.s())) == null) {
            return;
        }
        a(downloadInfo);
    }

    @WorkerThread
    public static void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
