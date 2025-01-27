package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.X;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static f f24630a = new f();

    /* renamed from: b */
    private List<Runnable> f24631b = new ArrayList();

    /* renamed from: c */
    final Map<String, DownloadTask> f24632c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d */
    Handler f24633d = new Handler(Looper.getMainLooper());

    public synchronized void a(Runnable runnable, int i2) {
        if (this.f24632c.size() == 0) {
            runnable.run();
        } else {
            d dVar = new d(6, Boolean.FALSE, runnable);
            this.f24633d.postDelayed(dVar, i2);
            a(dVar);
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<Runnable> it = this.f24631b.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Iterator<DownloadTask> it2 = this.f24632c.values().iterator();
            while (it2.hasNext()) {
                it2.next().delete(false);
            }
            this.f24631b.clear();
            this.f24632c.clear();
        }
    }

    public synchronized void a(Runnable runnable) {
        if (this.f24632c.size() == 0) {
            runnable.run();
        } else {
            this.f24631b.add(runnable);
        }
    }

    public void a(com.tencent.bugly.beta.download.c cVar, Map<String, String> map) {
        DownloadTask downloadTask;
        if (cVar == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f24632c.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f24632c.clear();
            com.tencent.bugly.beta.download.a aVar = new com.tencent.bugly.beta.download.a(1, this, this.f24632c);
            for (String str : ResBean.f24610b) {
                if (!map.containsKey(str)) {
                    this.f24632c.clear();
                    ResBean resBean = new ResBean();
                    ResBean.f24609a = resBean;
                    a.a("rb.bch", resBean);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.f24609a.a(str, "");
                    Iterator<DownloadTask> it2 = this.f24632c.values().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            downloadTask = it2.next();
                            if (downloadTask.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        } else {
                            downloadTask = null;
                            break;
                        }
                    }
                    if (downloadTask == null) {
                        downloadTask = cVar.a(str2, e.f24621b.u.getAbsolutePath(), null, null);
                    }
                    if (downloadTask != null) {
                        downloadTask.addListener(aVar);
                        downloadTask.setNeededNotify(false);
                        this.f24632c.put(str, downloadTask);
                    }
                } else {
                    ResBean.f24609a.a(str, str2);
                }
            }
            a.a("rb.bch", ResBean.f24609a);
            if (this.f24632c.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f24632c.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f24632c.clear();
        ResBean resBean2 = new ResBean();
        ResBean.f24609a = resBean2;
        a.a("rb.bch", resBean2);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f24610b) {
            String a2 = ResBean.f24609a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(a2)) {
                arrayList.add(a2);
            }
        }
        File[] listFiles = e.f24621b.u.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                C0912p.f25111a.b(file.getAbsolutePath());
                if (!file.delete()) {
                    X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}
