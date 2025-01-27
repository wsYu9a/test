package com.shu.priory.download;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.media3.session.SessionCommand;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.d.a;
import com.shu.priory.utils.f;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import com.shu.priory.webclient.WebViewDialogFragment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import q.a0;
import q.z;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: h */
    private static boolean f16957h;

    /* renamed from: k */
    private static c f16958k;

    /* renamed from: a */
    private Context f16959a;

    /* renamed from: b */
    private Handler f16960b;

    /* renamed from: c */
    private HashMap<String, a> f16961c;

    /* renamed from: d */
    private HashMap<String, a> f16962d;

    /* renamed from: e */
    private HandlerThread f16963e;

    /* renamed from: f */
    private DialogListener f16964f;

    /* renamed from: g */
    private boolean f16965g;

    /* renamed from: l */
    private com.shu.priory.download.a.b f16968l;

    /* renamed from: m */
    private NotificationManager f16969m;

    /* renamed from: n */
    private HashMap<Integer, Object> f16970n;

    /* renamed from: o */
    private d f16971o;

    /* renamed from: s */
    private final BroadcastReceiver f16975s;

    /* renamed from: i */
    private final int f16966i = 0;

    /* renamed from: j */
    private final int f16967j = SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT;

    /* renamed from: p */
    private final BroadcastReceiver f16972p = new BroadcastReceiver() { // from class: com.shu.priory.download.c.4
        public AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    h.a(SDKConstants.TAG, "app add" + intent.getDataString());
                    for (Map.Entry entry : c.this.f16962d.entrySet()) {
                        if (((a) entry.getValue()).f17000i == 1) {
                            h.a(SDKConstants.TAG, ((a) entry.getValue()).f16994c + "//" + intent.getDataString());
                            if (!intent.getDataString().contains(((a) entry.getValue()).f16994c)) {
                                if ("noPackage".equals(((a) entry.getValue()).f16994c)) {
                                }
                                c.this.f16962d.remove(((a) entry.getValue()).f16993b);
                                h.a(SDKConstants.TAG, "安装完成监控");
                            }
                            ((a) entry.getValue()).f17000i = 2;
                            c.this.a(((a) entry.getValue()).f16999h);
                            c.this.f16962d.remove(((a) entry.getValue()).f16993b);
                            h.a(SDKConstants.TAG, "安装完成监控");
                        }
                    }
                    c.this.c();
                }
            } catch (Exception e10) {
                h.d(SDKConstants.TAG, "ACTION_PACKAGE_ADDED exception " + e10.getMessage());
            }
        }
    };

    /* renamed from: q */
    private final int f16973q = 24;

    /* renamed from: r */
    private final int f16974r = 26;

    /* renamed from: com.shu.priory.download.c$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                try {
                    c.this.c();
                    h.a(SDKConstants.TAG, "移除广播 end");
                } catch (Throwable unused) {
                    h.d(SDKConstants.TAG, "移除广播 end");
                }
            }
        }
    }

    /* renamed from: com.shu.priory.download.c$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadDialogInfo f16977a;

        /* renamed from: b */
        final /* synthetic */ a f16978b;

        /* renamed from: c */
        final /* synthetic */ boolean f16979c;

        /* renamed from: d */
        final /* synthetic */ Activity f16980d;

        /* renamed from: com.shu.priory.download.c$2$1 */
        public class AnonymousClass1 implements DownLoadDialogCallback {
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.download.DownLoadDialogCallback
            public void onConfirmDownload() {
                c.this.f16964f.onConfirm();
                c.this.f16964f = null;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                c.this.a(aVar, z10);
                if (c.this.f16971o != null) {
                    c.this.f16971o.a();
                }
            }

            @Override // com.shu.priory.download.DownLoadDialogCallback
            public void onDismiss() {
                if (c.this.f16971o != null) {
                    c.this.f16971o.a();
                }
            }

            @Override // com.shu.priory.download.DownLoadDialogCallback
            public void onOpenDetail(int i10) {
                String str = i10 == 0 ? aVar.f17002k : i10 == 2 ? aVar.f17003l : aVar.f17001j;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                c.this.a(b10, str);
            }
        }

        public AnonymousClass2(DownloadDialogInfo downloadDialogInfo, a aVar, boolean z10, Activity activity) {
            downloadDialogInfo = downloadDialogInfo;
            aVar = aVar;
            z10 = z10;
            b10 = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f16964f != null) {
                if (!c.this.f16964f.onShowDownloadDialog(downloadDialogInfo, new DownLoadDialogCallback() { // from class: com.shu.priory.download.c.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onConfirmDownload() {
                        c.this.f16964f.onConfirm();
                        c.this.f16964f = null;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        c.this.a(aVar, z10);
                        if (c.this.f16971o != null) {
                            c.this.f16971o.a();
                        }
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onDismiss() {
                        if (c.this.f16971o != null) {
                            c.this.f16971o.a();
                        }
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onOpenDetail(int i10) {
                        String str = i10 == 0 ? aVar.f17002k : i10 == 2 ? aVar.f17003l : aVar.f17001j;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        c.this.a(b10, str);
                    }
                })) {
                    c.this.a(aVar, z10);
                } else if (c.this.f16971o != null) {
                    c.this.f16971o.b();
                }
            }
        }
    }

    /* renamed from: com.shu.priory.download.c$3 */
    public class AnonymousClass3 implements com.shu.priory.download.a.a {

        /* renamed from: a */
        final /* synthetic */ a f16983a;

        /* renamed from: b */
        final /* synthetic */ boolean f16984b;

        /* renamed from: c */
        final /* synthetic */ String f16985c;

        /* renamed from: e */
        private int f16987e;

        /* renamed from: f */
        private boolean f16988f;

        /* renamed from: g */
        private long f16989g;

        public AnonymousClass3(a aVar, boolean z10, String str) {
            aVar = aVar;
            z10 = z10;
            str3 = str;
        }

        @Override // com.shu.priory.download.a.a
        public void a(int i10) {
            c.this.a(aVar.f16995d, i10);
            this.f16989g = System.currentTimeMillis();
        }

        @Override // com.shu.priory.download.a.a
        public void b(int i10) {
            this.f16988f = true;
            c.this.a(aVar.f16995d, i10, true, this.f16987e);
            this.f16989g = System.currentTimeMillis();
        }

        @Override // com.shu.priory.download.a.a
        public void c(int i10) {
            this.f16988f = false;
            c.this.a(aVar.f16995d, i10, false, this.f16987e);
            this.f16989g = System.currentTimeMillis();
        }

        @Override // com.shu.priory.download.a.a
        public void d(int i10) {
            c.this.f16961c.remove(aVar.f16993b);
        }

        @Override // com.shu.priory.download.a.a
        public void e(int i10) {
            c.this.a(i10);
            c.this.f16961c.remove(aVar.f16993b);
            if (z10) {
                c.this.b();
                HashMap hashMap = c.this.f16962d;
                a aVar = aVar;
                hashMap.put(aVar.f16993b, aVar);
                c.this.a(aVar.f16993b);
                c.this.b(aVar.f16993b);
            }
            c cVar = c.this;
            cVar.a(cVar.f16959a, new File(str3));
        }

        @Override // com.shu.priory.download.a.a
        public void a(long j10, long j11, int i10) {
            this.f16987e = (int) ((j10 * 100) / j11);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f16989g > 1000) {
                c.this.a(aVar.f16995d, i10, this.f16988f, this.f16987e);
                this.f16989g = currentTimeMillis;
            }
        }

        @Override // com.shu.priory.download.a.a
        public void a(com.shu.priory.download.e.a aVar, int i10) {
            h.a(SDKConstants.TAG, "download failed " + aVar.getMessage());
            c.this.a(i10);
            c.this.f16961c.remove(aVar.f16993b);
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: com.shu.priory.download.c$4 */
    public class AnonymousClass4 extends BroadcastReceiver {
        public AnonymousClass4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    h.a(SDKConstants.TAG, "app add" + intent.getDataString());
                    for (Map.Entry entry : c.this.f16962d.entrySet()) {
                        if (((a) entry.getValue()).f17000i == 1) {
                            h.a(SDKConstants.TAG, ((a) entry.getValue()).f16994c + "//" + intent.getDataString());
                            if (!intent.getDataString().contains(((a) entry.getValue()).f16994c)) {
                                if ("noPackage".equals(((a) entry.getValue()).f16994c)) {
                                }
                                c.this.f16962d.remove(((a) entry.getValue()).f16993b);
                                h.a(SDKConstants.TAG, "安装完成监控");
                            }
                            ((a) entry.getValue()).f17000i = 2;
                            c.this.a(((a) entry.getValue()).f16999h);
                            c.this.f16962d.remove(((a) entry.getValue()).f16993b);
                            h.a(SDKConstants.TAG, "安装完成监控");
                        }
                    }
                    c.this.c();
                }
            } catch (Exception e10) {
                h.d(SDKConstants.TAG, "ACTION_PACKAGE_ADDED exception " + e10.getMessage());
            }
        }
    }

    /* renamed from: com.shu.priory.download.c$5 */
    public class AnonymousClass5 extends BroadcastReceiver {
        public AnonymousClass5() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("info_id", 0);
            com.shu.priory.download.a.b a10 = com.shu.priory.download.a.a(c.this.f16959a);
            com.shu.priory.download.d.a a11 = a10.a(intExtra);
            if (TextUtils.isEmpty(action) || a11 == null) {
                return;
            }
            action.hashCode();
            if (action.equals("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL")) {
                a10.e(a11);
                c.this.a(intExtra);
            } else if (action.equals("com.iflytek.voiceads.actions.DOWNLOAD_STATE_CHANGE")) {
                if (a11.g() == 6) {
                    a10.d(a11);
                } else {
                    a10.c(a11);
                }
            }
        }
    }

    public static class a {

        /* renamed from: a */
        public String f16992a;

        /* renamed from: b */
        public String f16993b;

        /* renamed from: c */
        public String f16994c;

        /* renamed from: d */
        public String f16995d;

        /* renamed from: e */
        public JSONArray f16996e;

        /* renamed from: f */
        public JSONArray f16997f;

        /* renamed from: g */
        public JSONArray f16998g;

        /* renamed from: h */
        public JSONArray f16999h;

        /* renamed from: i */
        public int f17000i;

        /* renamed from: j */
        String f17001j;

        /* renamed from: k */
        String f17002k;

        /* renamed from: l */
        String f17003l;

        private a() {
        }

        public void a(String str) {
            this.f17003l = str;
        }

        public void b(String str) {
            this.f17001j = str;
        }

        public void c(String str) {
            this.f17002k = str;
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private c(Context context) {
        AnonymousClass5 anonymousClass5 = new BroadcastReceiver() { // from class: com.shu.priory.download.c.5
            public AnonymousClass5() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("info_id", 0);
                com.shu.priory.download.a.b a10 = com.shu.priory.download.a.a(c.this.f16959a);
                com.shu.priory.download.d.a a11 = a10.a(intExtra);
                if (TextUtils.isEmpty(action) || a11 == null) {
                    return;
                }
                action.hashCode();
                if (action.equals("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL")) {
                    a10.e(a11);
                    c.this.a(intExtra);
                } else if (action.equals("com.iflytek.voiceads.actions.DOWNLOAD_STATE_CHANGE")) {
                    if (a11.g() == 6) {
                        a10.d(a11);
                    } else {
                        a10.c(a11);
                    }
                }
            }
        };
        this.f16975s = anonymousClass5;
        this.f16959a = context;
        this.f16969m = (NotificationManager) context.getSystemService("notification");
        this.f16970n = new HashMap<>();
        this.f16961c = new HashMap<>();
        this.f16962d = new HashMap<>();
        a();
        if (f16957h) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.iflytek.voiceads.actions.DOWNLOAD_STATE_CHANGE");
                intentFilter.addAction("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL");
                this.f16959a.registerReceiver(anonymousClass5, intentFilter);
            } catch (Throwable unused) {
                h.a(SDKConstants.TAG, "registe control receiver error");
            }
        }
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f16958k == null) {
                    f16958k = new c(context);
                }
                cVar = f16958k;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    private PendingIntent b(String str, int i10) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.f16959a.getPackageName());
        intent.putExtra("info_id", i10);
        return PendingIntent.getBroadcast(this.f16959a, i10, intent, 134217728);
    }

    public void c() {
        try {
            this.f16959a.unregisterReceiver(this.f16972p);
            HashMap<String, a> hashMap = this.f16962d;
            if (hashMap != null) {
                hashMap.clear();
            }
            h.a(SDKConstants.TAG, "注销安装广播");
        } catch (Exception unused) {
            h.d(SDKConstants.TAG, "注销安装广播 error");
        }
    }

    private void a() {
        HandlerThread handlerThread = new HandlerThread("download");
        this.f16963e = handlerThread;
        handlerThread.start();
        this.f16960b = new Handler(this.f16963e.getLooper()) { // from class: com.shu.priory.download.c.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    try {
                        c.this.c();
                        h.a(SDKConstants.TAG, "移除广播 end");
                    } catch (Throwable unused) {
                        h.d(SDKConstants.TAG, "移除广播 end");
                    }
                }
            }
        };
    }

    private static void c(String str) {
        try {
            new ProcessBuilder("chmod", "777", str).start();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(int i10) {
        if (this.f16970n.containsKey(Integer.valueOf(i10))) {
            this.f16969m.cancel(i10);
            this.f16970n.remove(Integer.valueOf(i10));
        }
    }

    public void b() {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.f16959a.registerReceiver(this.f16972p, intentFilter);
            h.a(SDKConstants.TAG, "注册广播");
        } catch (Exception unused) {
            h.d(SDKConstants.TAG, "注册广播");
        }
    }

    @TargetApi(26)
    private boolean c(Context context) {
        boolean canRequestPackageInstalls;
        if (context == null) {
            return false;
        }
        canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
        return canRequestPackageInstalls;
    }

    public void a(Activity activity, String str) {
        WebViewDialogFragment.a(str).show(activity.getFragmentManager(), "WebViewDialog");
    }

    private void a(Context context, a aVar, DownloadDialogInfo downloadDialogInfo, boolean z10) {
        if (this.f16961c.containsKey(aVar.f16993b)) {
            DialogListener dialogListener = this.f16964f;
            if (dialogListener != null) {
                dialogListener.onDownloading();
                this.f16964f = null;
                return;
            }
            return;
        }
        Activity b10 = b(context);
        if (this.f16965g && b10 != null && !b10.isFinishing()) {
            b10.runOnUiThread(new Runnable() { // from class: com.shu.priory.download.c.2

                /* renamed from: a */
                final /* synthetic */ DownloadDialogInfo f16977a;

                /* renamed from: b */
                final /* synthetic */ a f16978b;

                /* renamed from: c */
                final /* synthetic */ boolean f16979c;

                /* renamed from: d */
                final /* synthetic */ Activity f16980d;

                /* renamed from: com.shu.priory.download.c$2$1 */
                public class AnonymousClass1 implements DownLoadDialogCallback {
                    public AnonymousClass1() {
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onConfirmDownload() {
                        c.this.f16964f.onConfirm();
                        c.this.f16964f = null;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        c.this.a(aVar, z10);
                        if (c.this.f16971o != null) {
                            c.this.f16971o.a();
                        }
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onDismiss() {
                        if (c.this.f16971o != null) {
                            c.this.f16971o.a();
                        }
                    }

                    @Override // com.shu.priory.download.DownLoadDialogCallback
                    public void onOpenDetail(int i10) {
                        String str = i10 == 0 ? aVar.f17002k : i10 == 2 ? aVar.f17003l : aVar.f17001j;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        c.this.a(b10, str);
                    }
                }

                public AnonymousClass2(DownloadDialogInfo downloadDialogInfo2, a aVar2, boolean z102, Activity b102) {
                    downloadDialogInfo = downloadDialogInfo2;
                    aVar = aVar2;
                    z10 = z102;
                    b10 = b102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f16964f != null) {
                        if (!c.this.f16964f.onShowDownloadDialog(downloadDialogInfo, new DownLoadDialogCallback() { // from class: com.shu.priory.download.c.2.1
                            public AnonymousClass1() {
                            }

                            @Override // com.shu.priory.download.DownLoadDialogCallback
                            public void onConfirmDownload() {
                                c.this.f16964f.onConfirm();
                                c.this.f16964f = null;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                c.this.a(aVar, z10);
                                if (c.this.f16971o != null) {
                                    c.this.f16971o.a();
                                }
                            }

                            @Override // com.shu.priory.download.DownLoadDialogCallback
                            public void onDismiss() {
                                if (c.this.f16971o != null) {
                                    c.this.f16971o.a();
                                }
                            }

                            @Override // com.shu.priory.download.DownLoadDialogCallback
                            public void onOpenDetail(int i10) {
                                String str = i10 == 0 ? aVar.f17002k : i10 == 2 ? aVar.f17003l : aVar.f17001j;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                c.this.a(b10, str);
                            }
                        })) {
                            c.this.a(aVar, z10);
                        } else if (c.this.f16971o != null) {
                            c.this.f16971o.b();
                        }
                    }
                }
            });
            return;
        }
        DialogListener dialogListener2 = this.f16964f;
        if (dialogListener2 != null) {
            dialogListener2.onConfirm();
            this.f16964f = null;
        }
        a(aVar2, z102);
    }

    public void b(String str) {
        h.a(SDKConstants.TAG, "start installation");
        for (Map.Entry<String, a> entry : this.f16962d.entrySet()) {
            if (str.equals(entry.getValue().f16993b)) {
                entry.getValue().f17000i = 1;
                a(entry.getValue().f16998g);
                h.a(SDKConstants.TAG, "开始安装监控");
            }
        }
    }

    public static void b(boolean z10) {
        f16957h = z10;
    }

    public synchronized void a(Context context, com.shu.priory.g.a aVar, Object... objArr) {
        String str;
        if (aVar == null || context == null) {
            return;
        }
        a aVar2 = new a();
        DownloadDialogInfo downloadDialogInfo = new DownloadDialogInfo();
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    str = (String) objArr[0];
                    aVar2.f16992a = str;
                    aVar2.f16993b = f.a(aVar2.f16992a);
                    aVar2.f16995d = aVar.f17090q;
                    aVar2.f16994c = aVar.E;
                    h.d(SDKConstants.TAG, "Download info " + aVar.J.toString());
                    aVar2.f16996e = aVar.J.optJSONArray("download_start_urls");
                    aVar2.f16997f = aVar.J.optJSONArray("download_complete_urls");
                    aVar2.f16998g = aVar.J.optJSONArray("install_start_urls");
                    aVar2.f16999h = aVar.J.optJSONArray("install_complete_urls");
                    aVar2.c(aVar.f17094u);
                    aVar2.b(aVar.T);
                    aVar2.a(aVar.V);
                    aVar2.f17000i = 0;
                    downloadDialogInfo.setAppName(aVar.f17090q);
                    downloadDialogInfo.setAppVer(aVar.f17095v);
                    downloadDialogInfo.setIconUrl(aVar.f17087n.optString("url"));
                    downloadDialogInfo.setDeveloperName(aVar.U);
                    a(context, aVar2, downloadDialogInfo, true);
                }
            } catch (Throwable th2) {
                h.d(SDKConstants.TAG, "parse downExpInfo" + th2.getMessage());
                return;
            }
        }
        str = aVar.L;
        aVar2.f16992a = str;
        aVar2.f16993b = f.a(aVar2.f16992a);
        aVar2.f16995d = aVar.f17090q;
        aVar2.f16994c = aVar.E;
        h.d(SDKConstants.TAG, "Download info " + aVar.J.toString());
        aVar2.f16996e = aVar.J.optJSONArray("download_start_urls");
        aVar2.f16997f = aVar.J.optJSONArray("download_complete_urls");
        aVar2.f16998g = aVar.J.optJSONArray("install_start_urls");
        aVar2.f16999h = aVar.J.optJSONArray("install_complete_urls");
        aVar2.c(aVar.f17094u);
        aVar2.b(aVar.T);
        aVar2.a(aVar.V);
        aVar2.f17000i = 0;
        downloadDialogInfo.setAppName(aVar.f17090q);
        downloadDialogInfo.setAppVer(aVar.f17095v);
        downloadDialogInfo.setIconUrl(aVar.f17087n.optString("url"));
        downloadDialogInfo.setDeveloperName(aVar.U);
        a(context, aVar2, downloadDialogInfo, true);
    }

    public void a(Context context, File file) {
        Uri fromFile;
        if (context == null || file == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            int i10 = Build.VERSION.SDK_INT;
            int i11 = context.getApplicationInfo().targetSdkVersion;
            if (i10 < 24 || i11 < 24) {
                c(file.getAbsolutePath());
                intent.setFlags(268435456);
                fromFile = Uri.fromFile(file);
            } else {
                if (i10 >= 26 && i11 >= 26 && !c(context)) {
                    Intent intent2 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    if (context instanceof Activity) {
                        ((Activity) context).startActivityForResult(intent2, 0);
                    }
                }
                intent.addFlags(1);
                String str = this.f16959a.getPackageName() + ".iFlyFileProvider";
                h.a(SDKConstants.TAG, "file authority : " + str);
                fromFile = FileProvider.getUriForFile(context, str, file);
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "installApp error " + e10.getMessage());
        }
    }

    public synchronized void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            a aVar = new a();
            aVar.f16992a = str;
            aVar.f16993b = f.a(str);
            a(context, aVar, (DownloadDialogInfo) null, false);
        }
    }

    public void a(DialogListener dialogListener) {
        this.f16964f = dialogListener;
    }

    public synchronized void a(a aVar, boolean z10) {
        String str;
        String str2;
        h.a(SDKConstants.TAG, "start download ad");
        try {
            String str3 = b.a(this.f16959a) + File.separator + aVar.f16993b + ".apk";
            File file = new File(str3);
            if (file.exists()) {
                if (com.shu.priory.utils.b.a(this.f16959a, str3)) {
                    if (z10) {
                        a(aVar.f16996e);
                        a(aVar.f16997f);
                        this.f16962d.put(aVar.f16993b, aVar);
                        b();
                        b(aVar.f16993b);
                    }
                    a(this.f16959a, file);
                    return;
                }
                file.delete();
            }
            com.shu.priory.download.d.a a10 = new a.C0553a().a(aVar.f16992a).b(str3).a();
            this.f16968l = com.shu.priory.download.a.a(this.f16959a);
            a10.a(new com.shu.priory.download.a.a() { // from class: com.shu.priory.download.c.3

                /* renamed from: a */
                final /* synthetic */ a f16983a;

                /* renamed from: b */
                final /* synthetic */ boolean f16984b;

                /* renamed from: c */
                final /* synthetic */ String f16985c;

                /* renamed from: e */
                private int f16987e;

                /* renamed from: f */
                private boolean f16988f;

                /* renamed from: g */
                private long f16989g;

                public AnonymousClass3(a aVar2, boolean z102, String str32) {
                    aVar = aVar2;
                    z10 = z102;
                    str3 = str32;
                }

                @Override // com.shu.priory.download.a.a
                public void a(int i10) {
                    c.this.a(aVar.f16995d, i10);
                    this.f16989g = System.currentTimeMillis();
                }

                @Override // com.shu.priory.download.a.a
                public void b(int i10) {
                    this.f16988f = true;
                    c.this.a(aVar.f16995d, i10, true, this.f16987e);
                    this.f16989g = System.currentTimeMillis();
                }

                @Override // com.shu.priory.download.a.a
                public void c(int i10) {
                    this.f16988f = false;
                    c.this.a(aVar.f16995d, i10, false, this.f16987e);
                    this.f16989g = System.currentTimeMillis();
                }

                @Override // com.shu.priory.download.a.a
                public void d(int i10) {
                    c.this.f16961c.remove(aVar.f16993b);
                }

                @Override // com.shu.priory.download.a.a
                public void e(int i10) {
                    c.this.a(i10);
                    c.this.f16961c.remove(aVar.f16993b);
                    if (z10) {
                        c.this.b();
                        HashMap hashMap = c.this.f16962d;
                        a aVar2 = aVar;
                        hashMap.put(aVar2.f16993b, aVar2);
                        c.this.a(aVar.f16993b);
                        c.this.b(aVar.f16993b);
                    }
                    c cVar = c.this;
                    cVar.a(cVar.f16959a, new File(str3));
                }

                @Override // com.shu.priory.download.a.a
                public void a(long j10, long j11, int i10) {
                    this.f16987e = (int) ((j10 * 100) / j11);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f16989g > 1000) {
                        c.this.a(aVar.f16995d, i10, this.f16988f, this.f16987e);
                        this.f16989g = currentTimeMillis;
                    }
                }

                @Override // com.shu.priory.download.a.a
                public void a(com.shu.priory.download.e.a aVar2, int i10) {
                    h.a(SDKConstants.TAG, "download failed " + aVar2.getMessage());
                    c.this.a(i10);
                    c.this.f16961c.remove(aVar.f16993b);
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            });
            this.f16961c.put(aVar2.f16993b, aVar2);
            this.f16968l.a(a10);
            if (z102) {
                a(aVar2.f16996e);
                str = SDKConstants.TAG;
                str2 = "开始下载监控 下载地址：" + aVar2.f16992a;
            } else {
                str = SDKConstants.TAG;
                str2 = "下载地址：" + aVar2.f16992a;
            }
            h.a(str, str2);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "startDownloadAd error " + th2.getMessage());
        }
    }

    public void a(d dVar) {
        this.f16971o = dVar;
    }

    public void a(String str) {
        h.a(SDKConstants.TAG, "download finished");
        for (Map.Entry<String, a> entry : this.f16962d.entrySet()) {
            if (str.equals(entry.getValue().f16993b)) {
                entry.getValue().f17000i = 1;
                a(entry.getValue().f16997f);
                h.a(SDKConstants.TAG, "下载完成监控");
            }
        }
        h.a(SDKConstants.TAG, "移除广播 start");
        this.f16960b.removeMessages(0);
        this.f16960b.sendEmptyMessageDelayed(0, 50000L);
    }

    public void a(String str, int i10) {
        Notification.Builder channelId;
        try {
            if (this.f16970n.containsKey(Integer.valueOf(i10))) {
                return;
            }
            int i11 = Build.VERSION.SDK_INT;
            int i12 = this.f16959a.getApplicationInfo().targetSdkVersion;
            if (i11 < 26 || i12 < 26) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f16959a);
                if (f16957h) {
                    builder.setContentIntent(b("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL", i10));
                }
                builder.setContentTitle("准备下载").setProgress(100, 0, false).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.stat_sys_download).setDefaults(16);
                this.f16969m.notify(i10, builder.build());
                this.f16970n.put(Integer.valueOf(i10), builder);
                return;
            }
            Notification.Builder builder2 = new Notification.Builder(this.f16959a);
            a0.a();
            this.f16969m.createNotificationChannel(z.a("iflyad", "iflyad", 2));
            if (f16957h) {
                builder2.setContentIntent(b("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL", i10));
            }
            channelId = builder2.setContentTitle("准备下载").setProgress(100, 0, false).setChannelId("iflyad");
            channelId.setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.stat_sys_download).setDefaults(16);
            this.f16969m.notify(i10, builder2.build());
            this.f16970n.put(Integer.valueOf(i10), builder2);
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "showNotification error " + e10.getMessage());
        }
    }

    public void a(String str, int i10, boolean z10, int i11) {
        NotificationCompat.Builder contentTitle;
        StringBuilder sb2;
        NotificationManager notificationManager;
        Notification build;
        Notification.Builder contentTitle2;
        StringBuilder sb3;
        int i12 = Build.VERSION.SDK_INT;
        int i13 = this.f16959a.getApplicationInfo().targetSdkVersion;
        int i14 = z10 ? R.drawable.ic_media_pause : R.drawable.stat_sys_download;
        if (i12 < 26 || i13 < 26) {
            NotificationCompat.Builder builder = (NotificationCompat.Builder) this.f16970n.get(Integer.valueOf(i10));
            if (builder == null) {
                return;
            }
            if (f16957h) {
                builder.setContentIntent(b("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL", i10));
                contentTitle = builder.setContentTitle("正在下载");
                sb2 = new StringBuilder();
            } else {
                contentTitle = builder.setContentTitle("正在下载");
                sb2 = new StringBuilder();
            }
            sb2.append(i11);
            sb2.append("%");
            contentTitle.setContentText(sb2.toString()).setProgress(100, i11, false);
            builder.setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.stat_sys_download).setDefaults(16);
            notificationManager = this.f16969m;
            build = builder.build();
        } else {
            Notification.Builder builder2 = (Notification.Builder) this.f16970n.get(Integer.valueOf(i10));
            if (builder2 == null) {
                return;
            }
            if (f16957h) {
                builder2.setContentIntent(b("com.iflytek.voiceads.actions.DOWNLOAD_CANCEL", i10));
                contentTitle2 = builder2.setContentTitle("正在下载");
                sb3 = new StringBuilder();
            } else {
                contentTitle2 = builder2.setContentTitle("正在下载");
                sb3 = new StringBuilder();
            }
            sb3.append(i11);
            sb3.append("%");
            contentTitle2.setContentText(sb3.toString()).setProgress(100, i11, false);
            builder2.setWhen(System.currentTimeMillis()).setSmallIcon(i14).setDefaults(16);
            notificationManager = this.f16969m;
            build = builder2.build();
        }
        notificationManager.notify(i10, build);
    }

    public synchronized void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    String string = jSONArray.getString(i10);
                    j.b(string);
                    h.a(SDKConstants.TAG, "report url: " + string);
                } catch (JSONException e10) {
                    h.d(SDKConstants.TAG, "report url: " + e10.getMessage());
                }
            }
        } else {
            h.a(SDKConstants.TAG, "monitor: no valid url");
        }
    }

    public void a(boolean z10) {
        this.f16965g = z10;
    }
}
