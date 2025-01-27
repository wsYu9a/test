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
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.a.a;
import com.ss.android.downloadlib.addownload.b.f;
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

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public static volatile String f8147a;

    /* renamed from: c */
    public static ITTDownloadVisitor f8149c;

    /* renamed from: f */
    private static Context f8152f;

    /* renamed from: g */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f8153g;

    /* renamed from: h */
    private static final com.ss.android.download.api.download.a.a f8154h;

    /* renamed from: d */
    private static final AtomicBoolean f8150d = new AtomicBoolean(false);

    /* renamed from: e */
    private static final AtomicBoolean f8151e = new AtomicBoolean(false);

    /* renamed from: b */
    public static boolean f8148b = true;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$1 */
    public static class AnonymousClass1 implements q {
        @Override // com.ss.android.download.api.config.q
        public byte[] a(byte[] bArr, int i10) {
            return new byte[0];
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$2 */
    public static class AnonymousClass2 implements com.ss.android.download.api.config.b {
        @Override // com.ss.android.download.api.config.b
        public boolean a() {
            if (c.f() != null) {
                return c.f().getAppIsBackground();
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$3 */
    public static class AnonymousClass3 implements j {
        @Override // com.ss.android.download.api.config.j
        public JSONObject a() {
            return c.h();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$4 */
    public static class AnonymousClass4 implements IInstallAppHandler {
        @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
        public boolean installApp(Intent intent) {
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$5 */
    public static class AnonymousClass5 implements IDownloadSettings {
        @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
        public JSONObject get() {
            return c.h();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$6 */
    public static class AnonymousClass6 implements com.ss.android.download.api.download.a.a {
        @Override // com.ss.android.download.api.download.a.a
        public void a(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
            com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadStart");
        }

        @Override // com.ss.android.download.api.download.a.a
        public void b(DownloadInfo downloadInfo, String str) {
            com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onInstalled");
            c.c(str);
        }

        @Override // com.ss.android.download.api.download.a.a
        public void a(DownloadInfo downloadInfo, String str) {
            com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadFinished");
        }

        @Override // com.ss.android.download.api.download.a.a
        public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
            com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadFailed");
        }

        @Override // com.ss.android.download.api.download.a.a
        public void a(DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onCanceled");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$7 */
    public static class AnonymousClass7 implements a.InterfaceC0636a {
        public AnonymousClass7() {
        }

        @Override // com.ss.android.downloadlib.addownload.a.a.InterfaceC0636a
        public void a() {
            ExitInstallListener exitInstallListener = ExitInstallListener.this;
            if (exitInstallListener != null) {
                exitInstallListener.onExitInstall();
            }
        }
    }

    public static class b implements h {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$b$1 */
        public class AnonymousClass1 implements ITTHttpCallback {

            /* renamed from: a */
            final /* synthetic */ r f8156a;

            public AnonymousClass1(r rVar) {
                rVar = rVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(Throwable th2) {
                r rVar = rVar;
                if (rVar != null) {
                    rVar.a(th2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(String str) {
                r rVar = rVar;
                if (rVar != null) {
                    rVar.a(str);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$b$2 */
        public class AnonymousClass2 implements ITTHttpCallback {

            /* renamed from: a */
            final /* synthetic */ r f8158a;

            public AnonymousClass2(r rVar) {
                rVar = rVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(Throwable th2) {
                r rVar = rVar;
                if (rVar != null) {
                    rVar.a(th2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(String str) {
                r rVar = rVar;
                if (rVar != null) {
                    rVar.a(str);
                }
            }
        }

        private b() {
        }

        @Override // com.ss.android.download.api.config.h
        public void a(String str, String str2, Map<String, Object> map, r rVar) {
            str.hashCode();
            int i10 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i10 = 1;
            }
            if (c.f() != null) {
                c.f().execute(i10, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.b.1

                    /* renamed from: a */
                    final /* synthetic */ r f8156a;

                    public AnonymousClass1(r rVar2) {
                        rVar = rVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th2) {
                        r rVar2 = rVar;
                        if (rVar2 != null) {
                            rVar2.a(th2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        r rVar2 = rVar;
                        if (rVar2 != null) {
                            rVar2.a(str3);
                        }
                    }
                });
            }
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.ss.android.download.api.config.h
        public void a(String str, byte[] bArr, String str2, int i10, r rVar) {
            if (c.f() != null) {
                c.f().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.b.2

                    /* renamed from: a */
                    final /* synthetic */ r f8158a;

                    public AnonymousClass2(r rVar2) {
                        rVar = rVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th2) {
                        r rVar2 = rVar;
                        if (rVar2 != null) {
                            rVar2.a(th2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        r rVar2 = rVar;
                        if (rVar2 != null) {
                            rVar2.a(str3);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$c */
    public static class C0240c implements i {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$c$1 */
        public class AnonymousClass1 implements ITTPermissionCallback {

            /* renamed from: a */
            final /* synthetic */ t f8160a;

            public AnonymousClass1(t tVar) {
                tVar = tVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onDenied(String str) {
                t tVar = tVar;
                if (tVar != null) {
                    tVar.a(str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onGranted() {
                t tVar = tVar;
                if (tVar != null) {
                    tVar.a();
                }
            }
        }

        @Override // com.ss.android.download.api.config.i
        public void a(Activity activity, int i10, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.i
        public void a(Activity activity, String[] strArr, t tVar) {
            if (c.f() != null) {
                c.f().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.c.1

                    /* renamed from: a */
                    final /* synthetic */ t f8160a;

                    public AnonymousClass1(t tVar2) {
                        tVar = tVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.a(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.a();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.i
        public boolean a(Context context, String str) {
            if (c.f() != null) {
                return c.f().hasPermission(context, str);
            }
            return false;
        }
    }

    public static class e implements IDownloadHttpService {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$e$1 */
        public class AnonymousClass1 implements IDownloadHttpConnection {

            /* renamed from: a */
            final /* synthetic */ b.a f8165a;

            public AnonymousClass1(b.a aVar) {
                a10 = aVar;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public void end() {
                try {
                    a10.f8146d.disconnect();
                } catch (Exception unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public InputStream getInputStream() {
                return a10.f8143a;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() {
                return a10.f8145c;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public String getResponseHeaderField(String str) {
                Map<String, String> map = a10.f8144b;
                if (map != null) {
                    return map.get(str);
                }
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public IDownloadHttpConnection downloadWithConnection(int i10, String str, List<HttpHeader> list) throws IOException {
            b.a a10 = com.bytedance.sdk.openadsdk.downloadnew.b.a(str, list);
            if (a10 != null) {
                return new IDownloadHttpConnection() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.e.1

                    /* renamed from: a */
                    final /* synthetic */ b.a f8165a;

                    public AnonymousClass1(b.a a102) {
                        a10 = a102;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public void end() {
                        try {
                            a10.f8146d.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public InputStream getInputStream() {
                        return a10.f8143a;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() {
                        return a10.f8145c;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        Map<String, String> map = a10.f8144b;
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

    static {
        try {
            f8147a = i().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f8154h = new com.ss.android.download.api.download.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.6
            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void b(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onInstalled");
                c.c(str);
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.c.b("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    public static void c(String str) {
        com.ss.android.downloadad.api.a.b a10;
        JSONObject g10;
        if (TextUtils.isEmpty(str) || (a10 = f.a().a(str)) == null || (g10 = a10.g()) == null || f() == null) {
            return;
        }
        f().checkAutoControl(g10, str);
    }

    public static ITTDownloadVisitor f() {
        ITTDownloadVisitor iTTDownloadVisitor = f8149c;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.a.a(1));
    }

    private static boolean g() {
        return false;
    }

    public static JSONObject h() {
        try {
            ITTDownloadVisitor f10 = f();
            if (f10 != null) {
                JSONObject downloadSettings = f10.getDownloadSettings();
                if (downloadSettings.optInt("enable_app_install_receiver", 1) == 0) {
                    downloadSettings.put("enable_app_install_receiver", 0);
                }
                return downloadSettings;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static Context i() {
        Context context = f8152f;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    public static class a implements g {
        private void c(com.ss.android.download.api.model.c cVar) {
            if (cVar == null) {
                return;
            }
            Object l10 = cVar.l();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(cVar.b()).setExtJson(cVar.h()).setMaterialMeta(l10 instanceof JSONObject ? (JSONObject) l10 : null).setLabel(cVar.c());
            boolean z10 = "download_notification".equals(cVar.b()) || "landing_h5_download_ad_button".equals(cVar.b());
            if (c.f() != null) {
                c.f().executeLogUpload(label, z10);
            }
        }

        @Override // com.ss.android.download.api.config.g
        public void a(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.c.b("LibEventLogger", "onV3Event");
            a(cVar, true);
        }

        @Override // com.ss.android.download.api.config.g
        public void b(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.c.b("LibEventLogger", "onEvent called");
            a(cVar, false);
            c(cVar);
        }

        private void a(com.ss.android.download.api.model.c cVar, boolean z10) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (c.f() == null || (tTDownloadEventLogger = c.f().getTTDownloadEventLogger()) == null || cVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && c.f().isOpenSdkEvent(cVar.toString())) {
                return;
            }
            if (z10) {
                tTDownloadEventLogger.onV3Event(c.b(cVar));
            } else {
                tTDownloadEventLogger.onEvent(c.b(cVar));
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        if (!f8150d.get()) {
            try {
                com.ss.android.socialbase.appdownloader.d.j().a(true);
            } catch (Throwable unused) {
            }
            synchronized (c.class) {
                try {
                    AtomicBoolean atomicBoolean = f8150d;
                    if (!atomicBoolean.get()) {
                        f8152f = context.getApplicationContext();
                        if (f() != null) {
                            String initPath = f().initPath(f8148b);
                            if (!TextUtils.isEmpty(initPath)) {
                                f8147a = initPath;
                            }
                        }
                        atomicBoolean.set(b(f8152f));
                    }
                } finally {
                }
            }
        }
        if (f8150d.get()) {
            AtomicBoolean atomicBoolean2 = f8151e;
            if (atomicBoolean2.compareAndSet(false, true)) {
                TTDownloadEventLogger tTDownloadEventLogger = f() != null ? f().getTTDownloadEventLogger() : null;
                if (tTDownloadEventLogger == null) {
                    atomicBoolean2.set(false);
                } else {
                    tTDownloadEventLogger.onDownloadConfigReady();
                }
            }
        }
    }

    public static void b() {
        a().g();
        if (f() != null) {
            f().clearAllData(f8147a);
        }
    }

    public static class d implements l {

        /* renamed from: a */
        private final WeakReference<Context> f8162a;

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.c$d$1 */
        public class AnonymousClass1 implements IDialogStatusChangedListener {

            /* renamed from: a */
            final /* synthetic */ com.ss.android.download.api.model.b f8163a;

            public AnonymousClass1(com.ss.android.download.api.model.b bVar) {
                bVar = bVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onCancel(DialogInterface dialogInterface) {
                b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                if (interfaceC0631b != null) {
                    interfaceC0631b.c(dialogInterface);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onNegativeBtnClick(DialogInterface dialogInterface) {
                b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                if (interfaceC0631b != null) {
                    try {
                        interfaceC0631b.b(dialogInterface);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onPositiveBtnClick(DialogInterface dialogInterface) {
                b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                if (interfaceC0631b != null) {
                    interfaceC0631b.a(dialogInterface);
                }
            }
        }

        public d(Context context) {
            this.f8162a = new WeakReference<>(context);
        }

        private DialogBuilder c(com.ss.android.download.api.model.b bVar) {
            return DialogBuilder.builder().setTitle(bVar.f20990b).setMessage(bVar.f20991c).setNegativeBtnText(bVar.f20993e).setPositiveBtnText(bVar.f20992d).setIcon(bVar.f20995g).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.d.1

                /* renamed from: a */
                final /* synthetic */ com.ss.android.download.api.model.b f8163a;

                public AnonymousClass1(com.ss.android.download.api.model.b bVar2) {
                    bVar = bVar2;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                    if (interfaceC0631b != null) {
                        interfaceC0631b.c(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                    if (interfaceC0631b != null) {
                        try {
                            interfaceC0631b.b(dialogInterface);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0631b interfaceC0631b = bVar.f20996h;
                    if (interfaceC0631b != null) {
                        interfaceC0631b.a(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.l
        public void a(int i10, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i11) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e10) {
                Logger.e("LibUIFactory", "showToastWithDuration e " + e10.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.l
        /* renamed from: a */
        public AlertDialog b(com.ss.android.download.api.model.b bVar) {
            if (bVar != null && c.f() != null) {
                Context context = bVar.f20989a;
                if (context != null && (context instanceof Activity)) {
                    return c.f().showDialogBySelf((Activity) bVar.f20989a, bVar.f20998j == 1, c(bVar));
                }
                c.f().showDialogByDelegate(this.f8162a, bVar.f20998j == 1, c(bVar));
            }
            return null;
        }
    }

    private static boolean b(Context context) {
        com.ss.android.download.api.a a10;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (g()) {
            try {
                a10 = com.ss.android.downloadlib.i.a(applicationContext).a("pangolin");
            } catch (Throwable unused) {
                a10 = com.ss.android.downloadlib.i.a(applicationContext).a();
            }
        } else {
            a10 = com.ss.android.downloadlib.i.a(applicationContext).a();
        }
        if (a10 == null) {
            return false;
        }
        a10.a(new C0240c()).a(new a()).a(new d(applicationContext)).a(new b()).a(new j() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.3
            @Override // com.ss.android.download.api.config.j
            public JSONObject a() {
                return c.h();
            }
        }).a(new com.ss.android.download.api.config.b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.2
            @Override // com.ss.android.download.api.config.b
            public boolean a() {
                if (c.f() != null) {
                    return c.f().getAppIsBackground();
                }
                return false;
            }
        }).a(new a.C0630a().b("143").a("open_news").c("6.4.1.1").d(String.valueOf(6411)).a()).a(new q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.1
            @Override // com.ss.android.download.api.config.q
            public byte[] a(byte[] bArr, int i10) {
                return new byte[0];
            }
        }).a(packageName + ".TTFileProvider").a(a(applicationContext, h())).a();
        com.ss.android.downloadlib.g.a.a();
        com.ss.android.downloadlib.i.a(applicationContext).d().a(1);
        com.ss.android.downloadlib.i.a(applicationContext).a(f8154h);
        com.ss.android.socialbase.appdownloader.d.j().a(new IInstallAppHandler() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.4
            @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
            public boolean installApp(Intent intent) {
                return false;
            }
        });
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c() {
        return f8153g;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f8147a = str;
    }

    public static com.ss.android.downloadlib.i a() {
        a(i());
        return com.ss.android.downloadlib.i.a(i());
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean a(Uri uri) {
        return com.ss.android.downloadlib.b.j.a(uri);
    }

    public static void a(int i10) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f8153g;
        if (map != null) {
            map.remove(Integer.valueOf(i10));
        }
    }

    public static void a(int i10, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f8153g == null) {
                f8153g = Collections.synchronizedMap(new WeakHashMap());
            }
            f8153g.put(Integer.valueOf(i10), onEventLogHandler);
        }
    }

    public static boolean a(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c10;
        boolean z10 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (c10 = c()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : c10.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z10 && !onEventLog) {
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    public static JSONObject b(com.ss.android.download.api.model.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", cVar.a());
            jSONObject.put(TTDownloadField.TT_TAG, cVar.b());
            jSONObject.put(TTDownloadField.TT_LABEL, cVar.c());
            jSONObject.put(TTDownloadField.TT_IS_AD, cVar.d());
            jSONObject.put("adId", cVar.e());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, cVar.f());
            jSONObject.put("extValue", cVar.g());
            jSONObject.put("extJson", cVar.h());
            jSONObject.put(TTDownloadField.TT_PARAMS_JSON, cVar.i());
            jSONObject.put("eventSource", cVar.k());
            jSONObject.put(TTDownloadField.TT_EXTRA_OBJECT, cVar.l());
            jSONObject.put(TTDownloadField.TT_CLICK_TRACK_URL, cVar.j());
            jSONObject.put("isV3", cVar.m());
            jSONObject.put("V3EventName", cVar.n());
            jSONObject.put("V3EventParams", cVar.o());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    private static DownloaderBuilder a(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new IDownloadSettings() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.5
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
            public JSONObject get() {
                return c.h();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new e());
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> b10 = com.ss.android.socialbase.appdownloader.d.j().b(context);
            if (!b10.isEmpty()) {
                for (DownloadInfo downloadInfo : b10) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(Activity activity, ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.a.a.a().a(activity, false, new a.InterfaceC0636a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.c.7
            public AnonymousClass7() {
            }

            @Override // com.ss.android.downloadlib.addownload.a.a.InterfaceC0636a
            public void a() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
