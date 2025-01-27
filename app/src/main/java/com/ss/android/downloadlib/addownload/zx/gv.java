package com.ss.android.downloadlib.addownload.zx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: g */
    private final ConcurrentHashMap<Long, DownloadController> f24222g;

    /* renamed from: i */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f24223i;

    /* renamed from: j */
    private volatile boolean f24224j;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> q;
    private final ConcurrentHashMap<Long, DownloadModel> zx;

    /* renamed from: com.ss.android.downloadlib.addownload.zx.gv$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gv.this.f24224j) {
                return;
            }
            synchronized (gv.class) {
                if (!gv.this.f24224j) {
                    gv.this.q.putAll(k.j().zx());
                    gv.this.f24224j = true;
                }
            }
        }
    }

    private static class j {

        /* renamed from: j */
        private static gv f24226j = new gv();
    }

    /* synthetic */ gv(AnonymousClass1 anonymousClass1) {
        this();
    }

    public com.ss.android.downloadad.api.j.zx g(long j2) {
        return this.q.get(Long.valueOf(j2));
    }

    public void gv(long j2) {
        this.zx.remove(Long.valueOf(j2));
        this.f24223i.remove(Long.valueOf(j2));
        this.f24222g.remove(Long.valueOf(j2));
    }

    public DownloadController i(long j2) {
        return this.f24222g.get(Long.valueOf(j2));
    }

    @NonNull
    public q q(long j2) {
        q qVar = new q();
        qVar.f24240j = j2;
        qVar.zx = j(j2);
        DownloadEventConfig zx = zx(j2);
        qVar.f24239i = zx;
        if (zx == null) {
            qVar.f24239i = new com.ss.android.download.api.download.i();
        }
        DownloadController i2 = i(j2);
        qVar.f24238g = i2;
        if (i2 == null) {
            qVar.f24238g = new com.ss.android.download.api.download.zx();
        }
        return qVar;
    }

    private gv() {
        this.f24224j = false;
        this.zx = new ConcurrentHashMap<>();
        this.f24223i = new ConcurrentHashMap<>();
        this.f24222g = new ConcurrentHashMap<>();
        this.q = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.j.zx> i() {
        return this.q;
    }

    public void zx() {
        com.ss.android.downloadlib.g.j().j((Runnable) new Runnable() { // from class: com.ss.android.downloadlib.addownload.zx.gv.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (gv.this.f24224j) {
                    return;
                }
                synchronized (gv.class) {
                    if (!gv.this.f24224j) {
                        gv.this.q.putAll(k.j().zx());
                        gv.this.f24224j = true;
                    }
                }
            }
        }, true);
    }

    public static gv j() {
        return j.f24226j;
    }

    public DownloadEventConfig zx(long j2) {
        return this.f24223i.get(Long.valueOf(j2));
    }

    public void j(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.zx.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.j.zx zx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.j.zx zxVar : this.q.values()) {
            if (zxVar != null && str.equals(zxVar.j())) {
                return zxVar;
            }
        }
        return null;
    }

    public void zx(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.zx.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void j(long j2, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f24223i.put(Long.valueOf(j2), downloadEventConfig);
        }
    }

    public void j(long j2, DownloadController downloadController) {
        if (downloadController != null) {
            this.f24222g.put(Long.valueOf(j2), downloadController);
        }
    }

    public synchronized void j(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        this.q.put(Long.valueOf(zxVar.zx()), zxVar);
        k.j().j(zxVar);
    }

    public DownloadModel j(long j2) {
        return this.zx.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.j.zx j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.j.zx zxVar : this.q.values()) {
            if (zxVar != null && str.equals(zxVar.q())) {
                return zxVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.j.zx j(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.j.zx zxVar : this.q.values()) {
            if (zxVar != null && zxVar.v() == downloadInfo.getId()) {
                return zxVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long j2 = nt.j(new JSONObject(downloadInfo.getExtra()), "extra");
                if (j2 != 0) {
                    for (com.ss.android.downloadad.api.j.zx zxVar2 : this.q.values()) {
                        if (zxVar2 != null && zxVar2.zx() == j2) {
                            return zxVar2;
                        }
                    }
                    com.ss.android.downloadlib.q.i.j().j("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.j.zx zxVar3 : this.q.values()) {
            if (zxVar3 != null && TextUtils.equals(zxVar3.j(), downloadInfo.getUrl())) {
                return zxVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.j.zx j(int i2) {
        for (com.ss.android.downloadad.api.j.zx zxVar : this.q.values()) {
            if (zxVar != null && zxVar.v() == i2) {
                return zxVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.j.zx> j(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.j.zx zxVar : this.q.values()) {
                if (zxVar != null && TextUtils.equals(zxVar.j(), str)) {
                    zxVar.zx(str2);
                    hashMap.put(Long.valueOf(zxVar.zx()), zxVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void j(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            arrayList.add(String.valueOf(longValue));
            this.q.remove(Long.valueOf(longValue));
        }
        k.j().j((List<String>) arrayList);
    }
}
