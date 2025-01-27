package com.vivo.mobilead.c;

import android.text.TextUtils;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.DownloadManager;
import com.vivo.ic.dm.StopRequestException;
import com.vivo.ic.dm.impl.DownloadLifeListener;
import com.vivo.ic.dm.network.IHttpDownload;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: c */
    private static volatile b f28703c;

    /* renamed from: a */
    private ConcurrentHashMap<String, com.vivo.mobilead.c.a> f28704a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private DownloadLifeListener f28705b = new a();

    class a implements DownloadLifeListener {
        a() {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onAfterRequest(DownloadInfo downloadInfo) throws StopRequestException {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onBeforeDownload(DownloadInfo downloadInfo) throws StopRequestException {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onBeforeRequest(DownloadInfo downloadInfo) throws StopRequestException {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadFailed(DownloadInfo downloadInfo, int i2) {
            com.vivo.mobilead.c.a aVar;
            if (TextUtils.isEmpty(downloadInfo.getAppExtraOne()) || (aVar = (com.vivo.mobilead.c.a) b.this.f28704a.get(downloadInfo.getAppExtraOne())) == null) {
                return;
            }
            aVar.a(i2);
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadPaused(DownloadInfo downloadInfo, int i2) {
            TextUtils.isEmpty(downloadInfo.getAppExtraOne());
            com.vivo.mobilead.c.a aVar = (com.vivo.mobilead.c.a) b.this.f28704a.get(downloadInfo.getAppExtraOne());
            if (aVar != null) {
                aVar.b(i2);
            }
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadPausedByNetChange(long[] jArr) {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadSizeChange(DownloadInfo downloadInfo, long j2, long j3, long j4) {
            com.vivo.mobilead.c.a aVar;
            if (TextUtils.isEmpty(downloadInfo.getAppExtraOne()) || (aVar = (com.vivo.mobilead.c.a) b.this.f28704a.get(downloadInfo.getAppExtraOne())) == null) {
                return;
            }
            aVar.a(j2, j3);
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadSpeedChange(DownloadInfo downloadInfo, long j2) {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadStartByNetChange(long[] jArr) {
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadStatusChanged(DownloadInfo downloadInfo, int i2) {
            com.vivo.mobilead.c.a aVar;
            if (TextUtils.isEmpty(downloadInfo.getAppExtraOne()) || (aVar = (com.vivo.mobilead.c.a) b.this.f28704a.get(downloadInfo.getAppExtraOne())) == null) {
                return;
            }
            aVar.c(i2);
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onDownloadSucceed(DownloadInfo downloadInfo, int i2) {
            com.vivo.mobilead.c.a aVar;
            if (TextUtils.isEmpty(downloadInfo.getAppExtraOne()) || (aVar = (com.vivo.mobilead.c.a) b.this.f28704a.get(downloadInfo.getAppExtraOne())) == null) {
                return;
            }
            aVar.d(i2);
        }

        @Override // com.vivo.ic.dm.impl.DownloadLifeListener
        public void onRequestFailed(DownloadInfo downloadInfo, IHttpDownload iHttpDownload) throws StopRequestException {
        }
    }

    private b() {
        DownloadManager.getInstance().addDownloadListener(this.f28705b);
    }

    public static b e() {
        if (f28703c == null) {
            synchronized (b.class) {
                if (f28703c == null) {
                    f28703c = new b();
                }
            }
        }
        return f28703c;
    }

    public void b(com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.y() == null || TextUtils.isEmpty(bVar.y().k()) || TextUtils.isEmpty(bVar.y().a())) {
            return;
        }
        String a2 = bVar.y().a();
        com.vivo.mobilead.c.a aVar = this.f28704a.get(a2);
        if (aVar == null) {
            aVar = new com.vivo.mobilead.c.a(bVar);
            this.f28704a.put(a2, aVar);
        }
        aVar.d();
    }

    public void c() {
        com.vivo.mobilead.c.a value;
        for (Map.Entry<String, com.vivo.mobilead.c.a> entry : this.f28704a.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.m();
            }
        }
    }

    public void d() {
        com.vivo.mobilead.c.a value;
        if (this.f28704a.size() <= 0) {
            return;
        }
        for (Map.Entry<String, com.vivo.mobilead.c.a> entry : this.f28704a.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.n();
            }
        }
    }

    public void a(com.vivo.mobilead.unified.base.view.a aVar, com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.y() == null || TextUtils.isEmpty(bVar.y().k()) || TextUtils.isEmpty(bVar.y().a())) {
            return;
        }
        String a2 = bVar.y().a();
        com.vivo.mobilead.c.a aVar2 = this.f28704a.get(a2);
        if (aVar2 != null) {
            aVar2.a(aVar);
            return;
        }
        com.vivo.mobilead.c.a aVar3 = new com.vivo.mobilead.c.a(bVar);
        aVar3.a(aVar);
        this.f28704a.put(a2, aVar3);
    }

    public boolean b(String str) {
        com.vivo.mobilead.c.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f28704a.get(str)) == null) {
            return true;
        }
        return aVar.f();
    }

    public void a(String str, com.vivo.mobilead.unified.base.view.a aVar) {
        com.vivo.mobilead.c.a aVar2;
        if (TextUtils.isEmpty(str) || aVar == null || (aVar2 = this.f28704a.get(str)) == null) {
            return;
        }
        aVar2.b(aVar);
    }

    public void b() {
        com.vivo.mobilead.c.a value;
        for (Map.Entry<String, com.vivo.mobilead.c.a> entry : this.f28704a.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.l();
            }
        }
    }

    public void a() {
        if (this.f28704a.entrySet() != null) {
            Iterator<Map.Entry<String, com.vivo.mobilead.c.a>> it = this.f28704a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.vivo.mobilead.c.a> next = it.next();
                if (next != null && !next.getValue().e()) {
                    it.remove();
                }
            }
        }
    }

    public void a(com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.y() == null || TextUtils.isEmpty(bVar.y().k()) || TextUtils.isEmpty(bVar.y().a())) {
            return;
        }
        String a2 = bVar.y().a();
        com.vivo.mobilead.c.a aVar = this.f28704a.get(a2);
        if (aVar == null) {
            aVar = new com.vivo.mobilead.c.a(bVar);
            this.f28704a.put(a2, aVar);
        }
        aVar.b();
    }

    public boolean a(String str) {
        com.vivo.mobilead.c.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f28704a.get(str)) == null) {
            return true;
        }
        return aVar.c();
    }
}
