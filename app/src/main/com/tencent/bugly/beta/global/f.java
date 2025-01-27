package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.C0871p;
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
    public static f f22131a = new f();

    /* renamed from: b */
    private List<Runnable> f22132b = new ArrayList();

    /* renamed from: c */
    final Map<String, DownloadTask> f22133c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d */
    Handler f22134d = new Handler(Looper.getMainLooper());

    public synchronized void a(Runnable runnable, int i10) {
        try {
            if (this.f22133c.size() == 0) {
                runnable.run();
            } else {
                d dVar = new d(6, Boolean.FALSE, runnable);
                this.f22134d.postDelayed(dVar, i10);
                a(dVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void b() {
        synchronized (this) {
            try {
                Iterator<Runnable> it = this.f22132b.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                Iterator<DownloadTask> it2 = this.f22133c.values().iterator();
                while (it2.hasNext()) {
                    it2.next().delete(false);
                }
                this.f22132b.clear();
                this.f22133c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void a(Runnable runnable) {
        try {
            if (this.f22133c.size() == 0) {
                runnable.run();
            } else {
                this.f22132b.add(runnable);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(com.tencent.bugly.beta.download.c cVar, Map<String, String> map) {
        DownloadTask downloadTask;
        if (cVar == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f22133c.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f22133c.clear();
            com.tencent.bugly.beta.download.a aVar = new com.tencent.bugly.beta.download.a(1, this, this.f22133c);
            for (String str : ResBean.f22089b) {
                if (!map.containsKey(str)) {
                    this.f22133c.clear();
                    ResBean resBean = new ResBean();
                    ResBean.f22088a = resBean;
                    a.a("rb.bch", resBean);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.f22088a.a(str, "");
                    Iterator<DownloadTask> it2 = this.f22133c.values().iterator();
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
                        downloadTask = cVar.a(str2, e.f22100b.f22125u.getAbsolutePath(), null, null);
                    }
                    if (downloadTask != null) {
                        downloadTask.addListener(aVar);
                        downloadTask.setNeededNotify(false);
                        this.f22133c.put(str, downloadTask);
                    }
                } else {
                    ResBean.f22088a.a(str, str2);
                }
            }
            a.a("rb.bch", ResBean.f22088a);
            if (this.f22133c.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f22133c.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f22133c.clear();
        ResBean resBean2 = new ResBean();
        ResBean.f22088a = resBean2;
        a.a("rb.bch", resBean2);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f22089b) {
            String a10 = ResBean.f22088a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(a10)) {
                arrayList.add(a10);
            }
        }
        File[] listFiles = e.f22100b.f22125u.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            Iterator it = arrayList.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z10 = false;
                }
            }
            if (z10) {
                C0871p.f22799a.b(file.getAbsolutePath());
                if (!file.delete()) {
                    X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}
