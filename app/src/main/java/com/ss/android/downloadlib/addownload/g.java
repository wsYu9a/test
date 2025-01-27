package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: j */
    private Handler f24140j;
    private com.ss.android.downloadlib.addownload.zx.q zx;

    /* renamed from: i */
    private AtomicBoolean f24139i = new AtomicBoolean(false);

    /* renamed from: g */
    private AtomicBoolean f24138g = new AtomicBoolean(false);

    /* renamed from: com.ss.android.downloadlib.addownload.g$1 */
    class AnonymousClass1 implements q.zx {

        /* renamed from: g */
        final /* synthetic */ long f24141g;

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24142i;

        /* renamed from: j */
        final /* synthetic */ int f24143j;
        final /* synthetic */ q.j q;
        final /* synthetic */ String zx;

        AnonymousClass1(int i2, String str, com.ss.android.downloadad.api.j.zx zxVar, long j2, q.j jVar) {
            i2 = i2;
            downloadUrl = str;
            zxVar = zxVar;
            j2 = j2;
            jVar = jVar;
        }

        @Override // com.ss.android.downloadlib.addownload.q.zx
        public void j(long j2) {
            g.this.j(i2, downloadUrl, j2, zxVar, j2, jVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.g$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ q.j f24144j;

        AnonymousClass2(q.j jVar) {
            jVar = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f24139i.get()) {
                return;
            }
            g.this.f24139i.set(true);
            jVar.j();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.g$3 */
    class AnonymousClass3 implements IFetchHttpHeadInfoListener {

        /* renamed from: j */
        final /* synthetic */ q.zx f24145j;

        AnonymousClass3(q.zx zxVar) {
            zxVar2 = zxVar;
        }

        @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
        public void onFetchFinished(Map<String, String> map) {
            if (g.this.f24139i.get()) {
                return;
            }
            g.this.f24139i.set(true);
            long j2 = g.this.j(map);
            if (j2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(j2));
                    jSONObject.putOpt("available_space", Long.valueOf(g.g()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            zxVar2.j(j2);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.g$4 */
    class AnonymousClass4 implements com.ss.android.downloadlib.addownload.i.q {

        /* renamed from: i */
        final /* synthetic */ String f24147i;

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24148j;
        final /* synthetic */ q.j zx;

        AnonymousClass4(com.ss.android.downloadad.api.j.zx zxVar, q.j jVar, String str) {
            zxVar = zxVar;
            jVar = jVar;
            j5 = str;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.g$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ q.j f24149j;

        AnonymousClass5(q.j jVar) {
            jVar = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            jVar.j();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.g$6 */
    static class AnonymousClass6 implements com.ss.android.downloadlib.addownload.i.q {
        AnonymousClass6() {
        }
    }

    g(Handler handler) {
        this.f24140j = handler;
    }

    public static long g() {
        return com.ss.android.downloadlib.lg.nt.j(0L);
    }

    public static long zx() {
        if (pa.nt() != null) {
            return pa.nt().j();
        }
        return 0L;
    }

    private void zx(com.ss.android.downloadad.api.j.zx zxVar, JSONObject jSONObject, long j2, long j3) {
        zxVar.nt("1");
        com.ss.android.downloadlib.addownload.zx.k.j().j(zxVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j3 - j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("cleanspace_download_after_quite_clean", jSONObject, zxVar);
    }

    public void j(com.ss.android.downloadlib.addownload.zx.q qVar) {
        this.zx = qVar;
    }

    public boolean j() {
        return this.f24138g.get();
    }

    public void j(boolean z) {
        this.f24138g.set(z);
    }

    void j(int i2, long j2, long j3, q.j jVar) {
        this.f24138g.set(false);
        if (jVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.lg.q.gv(i2) && com.ss.android.downloadlib.lg.q.q(i2)) {
            long i3 = com.ss.android.downloadlib.lg.q.i(i2);
            this.f24139i.set(false);
            String downloadUrl = this.zx.zx.getDownloadUrl();
            com.ss.android.downloadad.api.j.zx zx = com.ss.android.downloadlib.addownload.zx.gv.j().zx(downloadUrl);
            if (zx == null) {
                com.ss.android.downloadlib.addownload.zx.q qVar = this.zx;
                zx = new com.ss.android.downloadad.api.j.zx(qVar.zx, qVar.f24239i, qVar.f24238g, 0);
                com.ss.android.downloadlib.addownload.zx.gv.j().j(zx);
            }
            com.ss.android.downloadad.api.j.zx zxVar = zx;
            zxVar.q(false);
            if (pa.nt() != null) {
                pa.nt().j(zxVar.zx());
            }
            com.ss.android.downloadlib.addownload.i.g.j().j(zxVar.j());
            boolean g2 = com.ss.android.downloadlib.lg.q.g(i2);
            if (j3 > 0) {
                j(i2, downloadUrl, j3, zxVar, j2, jVar);
            } else if (g2) {
                j(downloadUrl, zxVar, new q.zx() { // from class: com.ss.android.downloadlib.addownload.g.1

                    /* renamed from: g */
                    final /* synthetic */ long f24141g;

                    /* renamed from: i */
                    final /* synthetic */ com.ss.android.downloadad.api.j.zx f24142i;

                    /* renamed from: j */
                    final /* synthetic */ int f24143j;
                    final /* synthetic */ q.j q;
                    final /* synthetic */ String zx;

                    AnonymousClass1(int i22, String downloadUrl2, com.ss.android.downloadad.api.j.zx zxVar2, long j22, q.j jVar2) {
                        i2 = i22;
                        downloadUrl = downloadUrl2;
                        zxVar = zxVar2;
                        j2 = j22;
                        jVar = jVar2;
                    }

                    @Override // com.ss.android.downloadlib.addownload.q.zx
                    public void j(long j22) {
                        g.this.j(i2, downloadUrl, j22, zxVar, j2, jVar);
                    }
                });
            } else {
                i3 = 0;
            }
            this.f24140j.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.2

                /* renamed from: j */
                final /* synthetic */ q.j f24144j;

                AnonymousClass2(q.j jVar2) {
                    jVar = jVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.f24139i.get()) {
                        return;
                    }
                    g.this.f24139i.set(true);
                    jVar.j();
                }
            }, i3);
            return;
        }
        jVar2.j();
    }

    private void j(String str, com.ss.android.downloadad.api.j.zx zxVar, q.zx zxVar2) {
        if (zxVar2 == null) {
            return;
        }
        DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new IFetchHttpHeadInfoListener() { // from class: com.ss.android.downloadlib.addownload.g.3

            /* renamed from: j */
            final /* synthetic */ q.zx f24145j;

            AnonymousClass3(q.zx zxVar22) {
                zxVar2 = zxVar22;
            }

            @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
            public void onFetchFinished(Map<String, String> map) {
                if (g.this.f24139i.get()) {
                    return;
                }
                g.this.f24139i.set(true);
                long j2 = g.this.j(map);
                if (j2 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(j2));
                        jSONObject.putOpt("available_space", Long.valueOf(g.g()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                zxVar2.j(j2);
            }
        });
    }

    public long j(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public void j(int i2, String str, long j2, com.ss.android.downloadad.api.j.zx zxVar, long j3, q.j jVar) {
        this.f24139i.set(true);
        boolean z = false;
        if (j2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            double j4 = com.ss.android.downloadlib.lg.q.j(i2) + 1.0d;
            double d2 = j2;
            Double.isNaN(d2);
            long longValue = (Double.valueOf(j4 * d2).longValue() + com.ss.android.downloadlib.lg.q.zx(i2)) - j3;
            long g2 = g();
            if (g2 < longValue) {
                j(zxVar, jSONObject, longValue, g2);
                j(zxVar);
                long g3 = g();
                if (g3 < longValue) {
                    zxVar.g(true);
                    String j5 = zxVar.j();
                    com.ss.android.downloadlib.addownload.i.g.j().j(j5, new com.ss.android.downloadlib.addownload.i.q() { // from class: com.ss.android.downloadlib.addownload.g.4

                        /* renamed from: i */
                        final /* synthetic */ String f24147i;

                        /* renamed from: j */
                        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24148j;
                        final /* synthetic */ q.j zx;

                        AnonymousClass4(com.ss.android.downloadad.api.j.zx zxVar2, q.j jVar2, String j52) {
                            zxVar = zxVar2;
                            jVar = jVar2;
                            j5 = j52;
                        }
                    });
                    z = j(i2, zxVar2, str, longValue);
                    if (z) {
                        zxVar2.q(true);
                    }
                } else {
                    zx(zxVar2, jSONObject, g2, g3);
                }
            }
        }
        if (z) {
            return;
        }
        this.f24140j.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.5

            /* renamed from: j */
            final /* synthetic */ q.j f24149j;

            AnonymousClass5(q.j jVar2) {
                jVar = jVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                jVar.j();
            }
        });
    }

    private boolean j(int i2, @NonNull com.ss.android.downloadad.api.j.zx zxVar, String str, long j2) {
        if (!com.ss.android.downloadlib.lg.q.gv(i2)) {
            return false;
        }
        if (pa.nt() != null) {
            return pa.nt().j(i2, str, true, j2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("cleanspace_window_show", jSONObject, zxVar);
        return false;
    }

    public static boolean j(DownloadInfo downloadInfo, long j2) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (!com.ss.android.downloadlib.lg.q.gv(id)) {
            return false;
        }
        if (pa.nt() != null && (z = pa.nt().j(id, downloadInfo.getUrl(), false, j2))) {
            com.ss.android.downloadlib.addownload.i.g.j().j(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.i.q() { // from class: com.ss.android.downloadlib.addownload.g.6
                AnonymousClass6() {
                }
            });
        }
        return z;
    }

    public static JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void j(int i2) {
        if (com.ss.android.downloadlib.lg.q.gv(i2) && pa.nt() != null && pa.nt().zx()) {
            pa.nt().i();
        }
    }

    private static void j(com.ss.android.downloadad.api.j.zx zxVar) {
        long g2 = g();
        if (pa.nt() != null) {
            pa.nt().q();
        }
        com.ss.android.downloadlib.addownload.i.i.j();
        com.ss.android.downloadlib.addownload.i.i.zx();
        if (com.ss.android.downloadlib.lg.q.lg(zxVar.v())) {
            com.ss.android.downloadlib.addownload.i.i.j(pa.getContext());
        }
        long g3 = g();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(g3 - g2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("clean_quite_finish", jSONObject, zxVar);
    }

    private void j(com.ss.android.downloadad.api.j.zx zxVar, JSONObject jSONObject, long j2, long j3) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j3));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("clean_space_no_enough_for_download", jSONObject, zxVar);
    }
}
