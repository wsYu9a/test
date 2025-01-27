package com.ss.android.downloadlib.addownload.i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: j */
    private static volatile g f24163j;
    private long zx = 0;

    /* renamed from: i */
    private ConcurrentHashMap<String, q> f24165i = new ConcurrentHashMap<>();

    /* renamed from: g */
    private HashMap<String, Integer> f24164g = new HashMap<>();
    private List<String> q = new CopyOnWriteArrayList();

    public static g j() {
        if (f24163j == null) {
            synchronized (g.class) {
                if (f24163j == null) {
                    f24163j = new g();
                }
            }
        }
        return f24163j;
    }

    void i() {
        this.zx = System.currentTimeMillis();
    }

    long zx() {
        return this.zx;
    }

    public int zx(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f24164g == null) {
            this.f24164g = new HashMap<>();
        }
        if (this.f24164g.containsKey(str)) {
            return this.f24164g.get(str).intValue();
        }
        return 0;
    }

    public void j(String str, q qVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24165i.put(str, qVar);
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24165i.remove(str);
    }

    @WorkerThread
    public static void j(com.ss.android.downloadad.api.j.zx zxVar) {
        DownloadInfo downloadInfo;
        if (zxVar == null || zxVar.zx() <= 0 || (downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(zxVar.v())) == null) {
            return;
        }
        j(downloadInfo);
    }

    @WorkerThread
    public static void j(DownloadInfo downloadInfo) {
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
