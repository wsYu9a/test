package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private volatile boolean f21221a;

    /* renamed from: b */
    private final ConcurrentHashMap<Long, DownloadModel> f21222b;

    /* renamed from: c */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f21223c;

    /* renamed from: d */
    private final ConcurrentHashMap<Long, DownloadController> f21224d;

    /* renamed from: e */
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> f21225e;

    /* renamed from: com.ss.android.downloadlib.addownload.b.f$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f21221a) {
                return;
            }
            synchronized (f.class) {
                try {
                    if (!f.this.f21221a) {
                        f.this.f21225e.putAll(i.a().b());
                        f.this.f21221a = true;
                    }
                } finally {
                }
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private static f f21227a = new f();
    }

    public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    public DownloadController c(long j10) {
        return this.f21224d.get(Long.valueOf(j10));
    }

    public com.ss.android.downloadad.api.a.b d(long j10) {
        return this.f21225e.get(Long.valueOf(j10));
    }

    @NonNull
    public e e(long j10) {
        e eVar = new e();
        eVar.f21216a = j10;
        eVar.f21217b = a(j10);
        DownloadEventConfig b10 = b(j10);
        eVar.f21218c = b10;
        if (b10 == null) {
            eVar.f21218c = new com.ss.android.download.api.download.c();
        }
        DownloadController c10 = c(j10);
        eVar.f21219d = c10;
        if (c10 == null) {
            eVar.f21219d = new com.ss.android.download.api.download.b();
        }
        return eVar;
    }

    public void f(long j10) {
        this.f21222b.remove(Long.valueOf(j10));
        this.f21223c.remove(Long.valueOf(j10));
        this.f21224d.remove(Long.valueOf(j10));
    }

    private f() {
        this.f21221a = false;
        this.f21222b = new ConcurrentHashMap<>();
        this.f21223c = new ConcurrentHashMap<>();
        this.f21224d = new ConcurrentHashMap<>();
        this.f21225e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.d.a().a((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.f.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f21221a) {
                    return;
                }
                synchronized (f.class) {
                    try {
                        if (!f.this.f21221a) {
                            f.this.f21225e.putAll(i.a().b());
                            f.this.f21221a = true;
                        }
                    } finally {
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c() {
        return this.f21225e;
    }

    public static f a() {
        return a.f21227a;
    }

    public DownloadEventConfig b(long j10) {
        return this.f21223c.get(Long.valueOf(j10));
    }

    public void a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f21222b.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.a.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f21225e.values()) {
            if (bVar != null && str.equals(bVar.a())) {
                return bVar;
            }
        }
        return null;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f21222b.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void a(long j10, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f21223c.put(Long.valueOf(j10), downloadEventConfig);
        }
    }

    public void a(long j10, DownloadController downloadController) {
        if (downloadController != null) {
            this.f21224d.put(Long.valueOf(j10), downloadController);
        }
    }

    public synchronized void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f21225e.put(Long.valueOf(bVar.b()), bVar);
        i.a().a(bVar);
    }

    public DownloadModel a(long j10) {
        return this.f21222b.get(Long.valueOf(j10));
    }

    public com.ss.android.downloadad.api.a.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f21225e.values()) {
            if (bVar != null && str.equals(bVar.e())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f21225e.values()) {
            if (bVar != null && bVar.s() == downloadInfo.getId()) {
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long a10 = m.a(new JSONObject(downloadInfo.getExtra()), "extra");
                if (a10 != 0) {
                    for (com.ss.android.downloadad.api.a.b bVar2 : this.f21225e.values()) {
                        if (bVar2 != null && bVar2.b() == a10) {
                            return bVar2;
                        }
                    }
                    com.ss.android.downloadlib.e.c.a().a("getNativeModelByInfo");
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.a.b bVar3 : this.f21225e.values()) {
            if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                return bVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(int i10) {
        for (com.ss.android.downloadad.api.a.b bVar : this.f21225e.values()) {
            if (bVar != null && bVar.s() == i10) {
                return bVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.a.b> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.a.b bVar : this.f21225e.values()) {
                if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                    bVar.b(str2);
                    hashMap.put(Long.valueOf(bVar.b()), bVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void a(List<Long> list) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Long l10 : list) {
                arrayList.add(String.valueOf(l10.longValue()));
                this.f21225e.remove(l10);
            }
            i.a().a((List<String>) arrayList);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
