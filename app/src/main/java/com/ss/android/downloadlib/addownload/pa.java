package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.ei;
import com.ss.android.download.api.config.hm;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.v;
import com.ss.android.download.api.config.w;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class pa {

    /* renamed from: e */
    private static p f24196e;
    private static r ei;

    /* renamed from: f */
    private static v f24197f;

    /* renamed from: g */
    private static com.ss.android.download.api.config.i f24198g;
    private static com.ss.android.download.api.zx.j gm;
    private static com.ss.android.download.api.config.y gv;
    private static ei hm;

    /* renamed from: i */
    private static com.ss.android.download.api.config.lg f24199i;

    /* renamed from: j */
    public static final JSONObject f24200j = new JSONObject();
    private static com.ss.android.download.api.model.j k;
    private static com.ss.android.download.api.config.k lg;
    private static com.ss.android.download.api.config.g nt;
    private static com.ss.android.download.api.config.q p;
    private static com.ss.android.download.api.config.zx pa;
    private static com.ss.android.download.api.config.nt q;
    private static w r;
    private static hm s;
    private static com.ss.android.socialbase.appdownloader.i.y t;
    private static s v;
    private static com.ss.android.download.api.config.t w;
    private static com.ss.android.download.api.config.pa y;
    private static Context zx;

    /* renamed from: com.ss.android.downloadlib.addownload.pa$1 */
    static class AnonymousClass1 implements com.ss.android.download.api.config.i {
        AnonymousClass1() {
        }

        @Override // com.ss.android.download.api.config.i
        public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        }

        @Override // com.ss.android.download.api.config.i
        public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.pa$2 */
    static class AnonymousClass2 implements com.ss.android.socialbase.appdownloader.i.y {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.appdownloader.i.y
        public void j(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.pa$3 */
    static class AnonymousClass3 implements s {
        AnonymousClass3() {
        }

        @Override // com.ss.android.download.api.config.s
        public void j(String str, int i2, JSONObject jSONObject) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.pa$4 */
    static class AnonymousClass4 implements com.ss.android.download.api.zx.j {
        AnonymousClass4() {
        }

        @Override // com.ss.android.download.api.zx.j
        public void j(Throwable th, String str) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.pa$5 */
    static class AnonymousClass5 implements v {
        AnonymousClass5() {
        }

        @Override // com.ss.android.download.api.config.v
        public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
        }
    }

    public static hm e() {
        return s;
    }

    @NonNull
    public static ei ei() {
        return hm;
    }

    public static boolean f() {
        return (f24199i == null || gv == null || y == null || pa == null || hm == null) ? false : true;
    }

    public static com.ss.android.download.api.config.y g() {
        return gv;
    }

    public static Context getContext() {
        Context context = zx;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static v gm() {
        if (f24197f == null) {
            f24197f = new v() { // from class: com.ss.android.downloadlib.addownload.pa.5
                AnonymousClass5() {
                }

                @Override // com.ss.android.download.api.config.v
                public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return f24197f;
    }

    public static com.ss.android.socialbase.appdownloader.i.y gv() {
        if (t == null) {
            t = new com.ss.android.socialbase.appdownloader.i.y() { // from class: com.ss.android.downloadlib.addownload.pa.2
                AnonymousClass2() {
                }

                @Override // com.ss.android.socialbase.appdownloader.i.y
                public void j(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return t;
    }

    public static String hm() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + k().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static com.ss.android.download.api.config.nt i() {
        if (q == null) {
            q = new com.ss.android.download.api.j.j();
        }
        return q;
    }

    public static void j(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        zx = context.getApplicationContext();
    }

    @NonNull
    public static JSONObject k() {
        com.ss.android.download.api.config.pa paVar = y;
        return (paVar == null || paVar.j() == null) ? f24200j : y.j();
    }

    public static w lg() {
        return r;
    }

    @Nullable
    public static r nt() {
        return ei;
    }

    public static String p() {
        return "1.7.0";
    }

    public static p pa() {
        return f24196e;
    }

    @NonNull
    public static com.ss.android.download.api.config.k q() {
        if (lg == null) {
            lg = new com.ss.android.download.api.j.zx();
        }
        return lg;
    }

    public static com.ss.android.download.api.config.g r() {
        return nt;
    }

    public static com.ss.android.download.api.config.t s() {
        return w;
    }

    @Nullable
    public static com.ss.android.download.api.config.zx t() {
        return pa;
    }

    @NonNull
    public static com.ss.android.download.api.zx.j v() {
        if (gm == null) {
            gm = new com.ss.android.download.api.zx.j() { // from class: com.ss.android.downloadlib.addownload.pa.4
                AnonymousClass4() {
                }

                @Override // com.ss.android.download.api.zx.j
                public void j(Throwable th, String str) {
                }
            };
        }
        return gm;
    }

    public static com.ss.android.download.api.config.q w() {
        return p;
    }

    @NonNull
    public static s y() {
        if (v == null) {
            v = new s() { // from class: com.ss.android.downloadlib.addownload.pa.3
                AnonymousClass3() {
                }

                @Override // com.ss.android.download.api.config.s
                public void j(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return v;
    }

    public static void zx(Context context) {
        if (zx != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        zx = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.i zx() {
        if (f24198g == null) {
            f24198g = new com.ss.android.download.api.config.i() { // from class: com.ss.android.downloadlib.addownload.pa.1
                AnonymousClass1() {
                }

                @Override // com.ss.android.download.api.config.i
                public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.i
                public void j(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f24198g;
    }

    public static void j(@NonNull com.ss.android.download.api.config.lg lgVar) {
        f24199i = lgVar;
    }

    public static void j(@NonNull com.ss.android.download.api.config.nt ntVar) {
        q = ntVar;
    }

    public static void j(@NonNull com.ss.android.download.api.config.y yVar) {
        gv = yVar;
    }

    public static void j(@NonNull com.ss.android.download.api.config.k kVar) {
        lg = kVar;
    }

    public static void j(@NonNull com.ss.android.download.api.config.pa paVar) {
        y = paVar;
    }

    public static void j(@NonNull com.ss.android.download.api.model.j jVar) {
        k = jVar;
    }

    public static void j(@NonNull com.ss.android.download.api.config.zx zxVar) {
        pa = zxVar;
    }

    public static com.ss.android.download.api.config.lg j() {
        return f24199i;
    }

    public static void j(String str) {
        com.ss.android.socialbase.appdownloader.g.pa().j(str);
    }

    public static void j(ei eiVar) {
        hm = eiVar;
    }

    public static void j(com.ss.android.download.api.zx.j jVar) {
        gm = jVar;
    }
}
