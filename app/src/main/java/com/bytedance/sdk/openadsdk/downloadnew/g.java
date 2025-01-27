package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.downloadnew.i;
import com.opos.acs.st.STManager;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.ei;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.lg;
import com.ss.android.download.api.config.nt;
import com.ss.android.download.api.config.pa;
import com.ss.android.download.api.config.y;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.j;
import com.ss.android.download.api.model.zx;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.j.j;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> gv;

    /* renamed from: i */
    public static ITTDownloadVisitor f6458i;

    /* renamed from: j */
    public static volatile String f6459j;
    private static final com.ss.android.download.api.download.j.j lg;
    private static Context q;

    /* renamed from: g */
    private static final AtomicBoolean f6457g = new AtomicBoolean(false);
    public static boolean zx = true;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$1 */
    static class AnonymousClass1 implements ei {
        AnonymousClass1() {
        }

        @Override // com.ss.android.download.api.config.ei
        public byte[] j(byte[] bArr, int i2) {
            return new byte[0];
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$2 */
    static class AnonymousClass2 implements com.ss.android.download.api.config.zx {
        AnonymousClass2() {
        }

        @Override // com.ss.android.download.api.config.zx
        public boolean j() {
            if (g.q() != null) {
                return g.q().getAppIsBackground();
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$3 */
    static class AnonymousClass3 implements pa {
        AnonymousClass3() {
        }

        @Override // com.ss.android.download.api.config.pa
        public JSONObject j() {
            return g.q() != null ? g.q().getDownloadSettings() : new JSONObject();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$4 */
    static class AnonymousClass4 implements IInstallAppHandler {
        AnonymousClass4() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
        public boolean installApp(Intent intent) {
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$5 */
    static class AnonymousClass5 implements IDownloadSettings {
        AnonymousClass5() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
        public JSONObject get() {
            return g.q() != null ? g.q().getDownloadSettings() : new JSONObject();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$6 */
    static class AnonymousClass6 implements com.ss.android.download.api.download.j.j {
        AnonymousClass6() {
        }

        @Override // com.ss.android.download.api.download.j.j
        public void j(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadStart");
        }

        @Override // com.ss.android.download.api.download.j.j
        public void zx(DownloadInfo downloadInfo, String str) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onInstalled");
            g.i(str);
        }

        @Override // com.ss.android.download.api.download.j.j
        public void j(DownloadInfo downloadInfo, String str) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadFinished");
        }

        @Override // com.ss.android.download.api.download.j.j
        public void j(DownloadInfo downloadInfo, BaseException baseException, String str) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadFailed");
        }

        @Override // com.ss.android.download.api.download.j.j
        public void j(DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onCanceled");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$7 */
    static class AnonymousClass7 implements j.InterfaceC0494j {
        AnonymousClass7() {
        }

        @Override // com.ss.android.downloadlib.addownload.j.j.InterfaceC0494j
        public void j() {
            ExitInstallListener exitInstallListener = ExitInstallListener.this;
            if (exitInstallListener != null) {
                exitInstallListener.onExitInstall();
            }
        }
    }

    public static class q implements IDownloadHttpService {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$q$1 */
        class AnonymousClass1 implements IDownloadHttpConnection {

            /* renamed from: j */
            final /* synthetic */ i.j f6464j;

            AnonymousClass1(i.j jVar) {
                j2 = jVar;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public void end() {
                try {
                    j2.f6467g.disconnect();
                } catch (Exception unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public InputStream getInputStream() {
                return j2.f6469j;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() {
                return j2.f6468i;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public String getResponseHeaderField(String str) {
                Map<String, String> map = j2.zx;
                if (map != null) {
                    return map.get(str);
                }
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public IDownloadHttpConnection downloadWithConnection(int i2, String str, List<HttpHeader> list) throws IOException {
            i.j j2 = com.bytedance.sdk.openadsdk.downloadnew.i.j(str, list);
            if (j2 != null) {
                return new IDownloadHttpConnection() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.q.1

                    /* renamed from: j */
                    final /* synthetic */ i.j f6464j;

                    AnonymousClass1(i.j j22) {
                        j2 = j22;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public void end() {
                        try {
                            j2.f6467g.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public InputStream getInputStream() {
                        return j2.f6469j;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() {
                        return j2.f6468i;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        Map<String, String> map = j2.zx;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    private static class zx implements y {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$zx$1 */
        class AnonymousClass1 implements ITTHttpCallback {

            /* renamed from: j */
            final /* synthetic */ e f6465j;

            AnonymousClass1(e eVar) {
                eVar = eVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(Throwable th) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.j(th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(String str) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.j(str);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$zx$2 */
        class AnonymousClass2 implements ITTHttpCallback {

            /* renamed from: j */
            final /* synthetic */ e f6466j;

            AnonymousClass2(e eVar) {
                eVar = eVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(Throwable th) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.j(th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(String str) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.j(str);
                }
            }
        }

        private zx() {
        }

        @Override // com.ss.android.download.api.config.y
        public void j(String str, String str2, Map<String, Object> map, e eVar) {
            str.hashCode();
            int i2 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i2 = 1;
            }
            if (g.q() != null) {
                g.q().execute(i2, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.zx.1

                    /* renamed from: j */
                    final /* synthetic */ e f6465j;

                    AnonymousClass1(e eVar2) {
                        eVar = eVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.j(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.j(str3);
                        }
                    }
                });
            }
        }

        /* synthetic */ zx(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.ss.android.download.api.config.y
        public void j(String str, byte[] bArr, String str2, int i2, e eVar) {
            if (g.q() != null) {
                g.q().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.zx.2

                    /* renamed from: j */
                    final /* synthetic */ e f6466j;

                    AnonymousClass2(e eVar2) {
                        eVar = eVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.j(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.j(str3);
                        }
                    }
                });
            }
        }
    }

    static {
        try {
            f6459j = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        lg = new com.ss.android.download.api.download.j.j() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.6
            AnonymousClass6() {
            }

            @Override // com.ss.android.download.api.download.j.j
            public void j(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.j.j
            public void zx(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onInstalled");
                g.i(str);
            }

            @Override // com.ss.android.download.api.download.j.j
            public void j(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.j.j
            public void j(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.j.j
            public void j(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.j.zx("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    private static Context getContext() {
        Context context = q;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    private static boolean gv() {
        return false;
    }

    public static void i(String str) {
        com.ss.android.downloadad.api.j.zx j2;
        JSONObject lg2;
        if (TextUtils.isEmpty(str) || (j2 = gv.j().j(str)) == null || (lg2 = j2.lg()) == null || q() == null) {
            return;
        }
        q().checkAutoControl(lg2, str);
    }

    public static ITTDownloadVisitor q() {
        ITTDownloadVisitor iTTDownloadVisitor = f6458i;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.zx.j(1));
    }

    private static class i implements k {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$i$1 */
        class AnonymousClass1 implements ITTPermissionCallback {

            /* renamed from: j */
            final /* synthetic */ gm f6463j;

            AnonymousClass1(gm gmVar) {
                gmVar = gmVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onDenied(String str) {
                gm gmVar = gmVar;
                if (gmVar != null) {
                    gmVar.j(str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onGranted() {
                gm gmVar = gmVar;
                if (gmVar != null) {
                    gmVar.j();
                }
            }
        }

        @Override // com.ss.android.download.api.config.k
        public void j(Activity activity, int i2, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.k
        public void j(Activity activity, String[] strArr, gm gmVar) {
            if (g.q() != null) {
                g.q().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.i.1

                    /* renamed from: j */
                    final /* synthetic */ gm f6463j;

                    AnonymousClass1(gm gmVar2) {
                        gmVar = gmVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.j(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.j();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.k
        public boolean j(Context context, String str) {
            if (g.q() != null) {
                return g.q().hasPermission(context, str);
            }
            return false;
        }
    }

    public static class j implements lg {
        private void i(com.ss.android.download.api.model.i iVar) {
            if (iVar == null) {
                return;
            }
            Object nt = iVar.nt();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(iVar.zx()).setExtJson(iVar.y()).setMaterialMeta(nt instanceof JSONObject ? (JSONObject) nt : null).setLabel(iVar.i());
            boolean z = "download_notification".equals(iVar.zx()) || "landing_h5_download_ad_button".equals(iVar.zx());
            if (g.q() != null) {
                g.q().executeLogUpload(label, z);
            }
        }

        @Override // com.ss.android.download.api.config.lg
        public void j(com.ss.android.download.api.model.i iVar) {
            com.bytedance.sdk.openadsdk.api.j.zx("LibEventLogger", "onV3Event");
            j(iVar, true);
        }

        @Override // com.ss.android.download.api.config.lg
        public void zx(com.ss.android.download.api.model.i iVar) {
            com.bytedance.sdk.openadsdk.api.j.zx("LibEventLogger", "onEvent called");
            j(iVar, false);
            i(iVar);
        }

        private void j(com.ss.android.download.api.model.i iVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (g.q() == null || (tTDownloadEventLogger = g.q().getTTDownloadEventLogger()) == null || iVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && g.q().isOpenSdkEvent(iVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(g.zx(iVar));
            } else {
                tTDownloadEventLogger.onEvent(g.zx(iVar));
            }
        }
    }

    public static void j(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f6457g;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (g.class) {
            if (!atomicBoolean.get()) {
                q = context.getApplicationContext();
                if (q() != null) {
                    String initPath = q().initPath(zx);
                    if (!TextUtils.isEmpty(initPath)) {
                        f6459j = initPath;
                    }
                }
                atomicBoolean.set(zx(q));
            }
        }
    }

    public static void zx() {
        j().lg();
        if (q() != null) {
            q().clearAllData(f6459j);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$g */
    public static class C0078g implements nt {

        /* renamed from: j */
        private final WeakReference<Context> f6461j;

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.g$g$1 */
        class AnonymousClass1 implements IDialogStatusChangedListener {

            /* renamed from: j */
            final /* synthetic */ com.ss.android.download.api.model.zx f6462j;

            AnonymousClass1(com.ss.android.download.api.model.zx zxVar) {
                zxVar = zxVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onCancel(DialogInterface dialogInterface) {
                zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                if (interfaceC0493zx != null) {
                    interfaceC0493zx.i(dialogInterface);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onNegativeBtnClick(DialogInterface dialogInterface) {
                zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                if (interfaceC0493zx != null) {
                    try {
                        interfaceC0493zx.zx(dialogInterface);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onPositiveBtnClick(DialogInterface dialogInterface) {
                zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                if (interfaceC0493zx != null) {
                    interfaceC0493zx.j(dialogInterface);
                }
            }
        }

        public C0078g(Context context) {
            this.f6461j = new WeakReference<>(context);
        }

        private DialogBuilder i(com.ss.android.download.api.model.zx zxVar) {
            return DialogBuilder.builder().setTitle(zxVar.zx).setMessage(zxVar.f24083i).setNegativeBtnText(zxVar.q).setPositiveBtnText(zxVar.f24082g).setIcon(zxVar.lg).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.g.1

                /* renamed from: j */
                final /* synthetic */ com.ss.android.download.api.model.zx f6462j;

                AnonymousClass1(com.ss.android.download.api.model.zx zxVar2) {
                    zxVar = zxVar2;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                    if (interfaceC0493zx != null) {
                        interfaceC0493zx.i(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                    if (interfaceC0493zx != null) {
                        try {
                            interfaceC0493zx.zx(dialogInterface);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    zx.InterfaceC0493zx interfaceC0493zx = zxVar.y;
                    if (interfaceC0493zx != null) {
                        interfaceC0493zx.j(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.nt
        public void j(int i2, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                Logger.e("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.nt
        /* renamed from: j */
        public AlertDialog zx(com.ss.android.download.api.model.zx zxVar) {
            if (zxVar != null && g.q() != null) {
                Context context = zxVar.f24084j;
                if (context != null && (context instanceof Activity)) {
                    return g.q().showDialogBySelf((Activity) zxVar.f24084j, zxVar.pa == 1, i(zxVar));
                }
                g.q().showDialogByDelegate(this.f6461j, zxVar.pa == 1, i(zxVar));
            }
            return null;
        }
    }

    private static boolean zx(Context context) {
        com.ss.android.download.api.j j2;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (gv()) {
            try {
                j2 = com.ss.android.downloadlib.y.j(applicationContext).j(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable unused) {
                j2 = com.ss.android.downloadlib.y.j(applicationContext).j();
            }
        } else {
            j2 = com.ss.android.downloadlib.y.j(applicationContext).j();
        }
        if (j2 == null) {
            return false;
        }
        j2.j(new i()).j(new j()).j(new C0078g(applicationContext)).j(new zx()).j(new pa() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.3
            AnonymousClass3() {
            }

            @Override // com.ss.android.download.api.config.pa
            public JSONObject j() {
                return g.q() != null ? g.q().getDownloadSettings() : new JSONObject();
            }
        }).j(new com.ss.android.download.api.config.zx() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.2
            AnonymousClass2() {
            }

            @Override // com.ss.android.download.api.config.zx
            public boolean j() {
                if (g.q() != null) {
                    return g.q().getAppIsBackground();
                }
                return false;
            }
        }).j(new j.C0492j().zx("143").j(TTAdConstant.APP_NAME).i("5.2.0.5").g(String.valueOf(5205)).j()).j(new ei() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.1
            AnonymousClass1() {
            }

            @Override // com.ss.android.download.api.config.ei
            public byte[] j(byte[] bArr, int i2) {
                return new byte[0];
            }
        }).j(packageName + ".TTFileProvider").j(j(applicationContext, q() != null ? q().getDownloadSettings() : new JSONObject())).j();
        com.ss.android.downloadlib.lg.j.j();
        com.ss.android.downloadlib.y.j(applicationContext).g().j(1);
        com.ss.android.downloadlib.y.j(applicationContext).j(lg);
        com.ss.android.socialbase.appdownloader.g.pa().j(new IInstallAppHandler() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.4
            AnonymousClass4() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
            public boolean installApp(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = q().getTTDownloadEventLogger();
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> i() {
        return gv;
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f6459j = str;
    }

    public static com.ss.android.downloadlib.y j() {
        j(getContext());
        return com.ss.android.downloadlib.y.j(getContext());
    }

    public static boolean j(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return j().q().j(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean j(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return j().q().j(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean j(Uri uri) {
        return com.ss.android.downloadlib.zx.pa.j(uri);
    }

    public static void j(int i2) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = gv;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    public static void j(int i2, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (gv == null) {
                gv = Collections.synchronizedMap(new WeakHashMap());
            }
            gv.put(Integer.valueOf(i2), onEventLogHandler);
        }
    }

    public static boolean j(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> i2;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (i2 = i()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : i2.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !onEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static DownloaderBuilder j(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new IDownloadSettings() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.5
            AnonymousClass5() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
            public JSONObject get() {
                return g.q() != null ? g.q().getDownloadSettings() : new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new q());
    }

    public static JSONObject zx(com.ss.android.download.api.model.i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", iVar.j());
            jSONObject.put("tag", iVar.zx());
            jSONObject.put(TTDownloadField.TT_LABEL, iVar.i());
            jSONObject.put("isAd", iVar.g());
            jSONObject.put(STManager.KEY_AD_ID, iVar.q());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, iVar.gv());
            jSONObject.put("extValue", iVar.lg());
            jSONObject.put("extJson", iVar.y());
            jSONObject.put("paramsJson", iVar.k());
            jSONObject.put("eventSource", iVar.t());
            jSONObject.put("extraObject", iVar.nt());
            jSONObject.put("clickTrackUrl", iVar.pa());
            jSONObject.put("isV3", iVar.p());
            jSONObject.put("V3EventName", iVar.r());
            jSONObject.put("V3EventParams", iVar.w());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean j(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> zx2 = com.ss.android.socialbase.appdownloader.g.pa().zx(context);
            if (!zx2.isEmpty()) {
                for (DownloadInfo downloadInfo : zx2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean j(Activity activity, ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.j.j.j().j(activity, false, new j.InterfaceC0494j() { // from class: com.bytedance.sdk.openadsdk.downloadnew.g.7
            AnonymousClass7() {
            }

            @Override // com.ss.android.downloadlib.addownload.j.j.InterfaceC0494j
            public void j() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
