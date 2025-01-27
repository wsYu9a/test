package com.martian.libxianplay.wowan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import ba.g;
import ba.l;
import ba.m;
import com.baidu.mobads.sdk.internal.am;
import com.martian.libxianplay.util.XianWanSystemUtil;
import com.martian.libxianplay.wowan.X5JavaScriptInterface;
import ea.c;
import java.io.File;
import java.util.Iterator;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class X5JavaScriptInterface {
    public static final String mStringKey = "fdsmkfshdik423432";
    public static WebView mWebView;
    private final Activity mActivity;
    private final Handler mHandler = new Handler();

    /* renamed from: com.martian.libxianplay.wowan.X5JavaScriptInterface$1 */
    public class AnonymousClass1 implements ea.b {
        final /* synthetic */ Context val$context;
        final /* synthetic */ File val$file;

        public AnonymousClass1(Context context, File file) {
            context = context;
            file = file;
        }

        @Override // ea.b
        public void permissionDenied() {
        }

        @Override // ea.b
        public void permissionGranted() {
            X5JavaScriptInterface.this.installApk(context, file);
        }
    }

    public X5JavaScriptInterface(Activity activity, WebView webView) {
        this.mActivity = activity;
        mWebView = webView;
    }

    private void downloadFile(int i10, int i11, String str) {
        Uri uriForDownloadedFile;
        String str2 = str;
        try {
            if (!XianWanSystemUtil.hasSD()) {
                Toast.makeText(this.mActivity, "您还没有没有内存卡哦!", 0).show();
                return;
            }
            if (this.mActivity != null && mWebView != null) {
                if (!str2.contains(".apk")) {
                    str2 = redirectPath(str2);
                }
                File i12 = ba.b.i();
                if (i12 == null) {
                    Toast.makeText(this.mActivity, "请插入SD卡", 1).show();
                    return;
                }
                String path = i12.getPath();
                String[] split = str2.split(File.separator);
                String str3 = split[split.length - 1];
                if (!str3.contains(".apk")) {
                    if (str3.length() > 10) {
                        str3 = str3.substring(str3.length() - 10);
                    }
                    str3 = str3 + ".apk";
                }
                DownloadManager downloadManager = (DownloadManager) this.mActivity.getSystemService("download");
                SharedPreferences sharedPreferences = this.mActivity.getSharedPreferences("wowan", 0);
                long j10 = sharedPreferences.getLong(i10 + "", 0L);
                if (j10 != 0 && PlayMeUtils.getBytesAndStatus(j10, downloadManager)[2] == 8 && (uriForDownloadedFile = downloadManager.getUriForDownloadedFile(j10)) != null && !TextUtils.isEmpty(uriForDownloadedFile.toString())) {
                    File file = new File(path, str3);
                    if (file.exists()) {
                        PlayMeUtils.installThroughUri(this.mActivity, file);
                        if (mWebView != null) {
                            mWebView.post(new Runnable() { // from class: la.d

                                /* renamed from: b */
                                public final /* synthetic */ String f28056b;

                                /* renamed from: c */
                                public final /* synthetic */ String f28057c;

                                public /* synthetic */ d(String str4, String str5) {
                                    string2 = str4;
                                    string = str5;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    X5JavaScriptInterface.lambda$downloadFile$2(string2, string);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str2));
                request.setAllowedOverRoaming(false);
                request.setAllowedNetworkTypes(3);
                request.setNotificationVisibility(0);
                request.setVisibleInDownloadsUi(true);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                request.setDestinationUri(Uri.fromFile(new File(ba.b.i(), str3)));
                request.allowScanningByMediaScanner();
                long enqueue = downloadManager.enqueue(request);
                sharedPreferences.edit().putLong(i10 + "", enqueue).commit();
                sharedPreferences.edit().putString(enqueue + t8.a.f30751f, path + "/" + str3).commit();
                sharedPreferences.edit().putString(enqueue + "adid", i10 + "").commit();
                Activity activity = this.mActivity;
                if (activity instanceof WowanDetailActivity) {
                    ((WowanDetailActivity) activity).startCheckProgressStates();
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void installApk(Context context, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z10 = g.z(this.mActivity, file);
        if (z10 == null) {
            return;
        }
        intent.setFlags(268435456);
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (m.o() && i10 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z10, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static boolean isAPKinstall(Context context, String str) {
        boolean z10;
        PackageInfo packageInfo;
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(8192).iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (str.equalsIgnoreCase(it.next().packageName)) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            return z10;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static /* synthetic */ void lambda$CheckAppIsInstall$0(String str, String[] strArr) {
        String encrypt = PlayMeUtils.encrypt(str + strArr[0] + mStringKey);
        mWebView.loadUrl("javascript:CheckAppCallback('" + str + "','" + strArr[0] + "','" + encrypt + "')");
    }

    public static /* synthetic */ void lambda$CheckAppIsInstall$1() {
        mWebView.loadUrl("javascript:CheckAppNoInstall()");
    }

    public static /* synthetic */ void lambda$GetCopyContent$7(String str) {
        mWebView.loadUrl("javascript:APPReturnClipboard('" + str + "')");
    }

    public static /* synthetic */ void lambda$InstallApk$3(int i10) {
        mWebView.loadUrl("javascript:InstallApkListener(" + i10 + ",0,'安装路径为空')");
    }

    public static /* synthetic */ void lambda$InstallApk$4(int i10) {
        mWebView.loadUrl("javascript:InstallApkListener(" + i10 + ",0,'安装路径不存在')");
    }

    public static /* synthetic */ void lambda$InstallApk$5(int i10) {
        mWebView.loadUrl("javascript:InstallApkListener(" + i10 + ",1,'唤起安装成功')");
    }

    public static /* synthetic */ void lambda$RefreshWeb$6() {
        String url = mWebView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        mWebView.loadUrl(url);
    }

    public static /* synthetic */ void lambda$downloadFile$2(String str, String str2) {
        mWebView.loadUrl("javascript:downloadApkFileFinishListener(" + str + ",'" + str2 + "')");
    }

    private void showShortToast() {
        Toast.makeText(this.mActivity, "缺少存储权限", 0).show();
    }

    @JavascriptInterface
    public void Browser(String str) {
        if (this.mActivity == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (this.mActivity.getPackageManager().resolveActivity(intent, 65536) != null) {
                this.mActivity.startActivity(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public void CheckAppIsInstall(String str) {
        Activity activity = this.mActivity;
        if (activity == null || mWebView == null) {
            return;
        }
        String[] strArr = new String[1];
        boolean z10 = false;
        for (PackageInfo packageInfo : activity.getPackageManager().getInstalledPackages(8192)) {
            if (str.equalsIgnoreCase(packageInfo.packageName)) {
                strArr[0] = String.valueOf(packageInfo.versionCode);
                z10 = true;
            }
        }
        if (z10) {
            mWebView.post(new Runnable() { // from class: la.i

                /* renamed from: b */
                public final /* synthetic */ String f28062b;

                /* renamed from: c */
                public final /* synthetic */ String[] f28063c;

                public /* synthetic */ i(String str2, String[] strArr2) {
                    str = str2;
                    strArr = strArr2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.lambda$CheckAppIsInstall$0(str, strArr);
                }
            });
        } else {
            mWebView.post(new Runnable() { // from class: la.j
                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.lambda$CheckAppIsInstall$1();
                }
            });
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: la.e.<init>(java.lang.String):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.webkit.JavascriptInterface
    public void GetCopyContent() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCopyBoradContent()
            android.webkit.WebView r1 = com.martian.libxianplay.wowan.X5JavaScriptInterface.mWebView
            if (r1 == 0) goto L10
            la.e r2 = new la.e
            r2.<init>()
            r1.post(r2)
        L10:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libxianplay.wowan.X5JavaScriptInterface.GetCopyContent():void");
    }

    @JavascriptInterface
    public void InstallApk(int i10, String str) {
        if (l.q(str)) {
            WebView webView = mWebView;
            if (webView != null) {
                webView.post(new Runnable() { // from class: la.f

                    /* renamed from: b */
                    public final /* synthetic */ int f28059b;

                    public /* synthetic */ f(int i102) {
                        i10 = i102;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        X5JavaScriptInterface.lambda$InstallApk$3(i10);
                    }
                });
                return;
            }
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            WebView webView2 = mWebView;
            if (webView2 != null) {
                webView2.post(new Runnable() { // from class: la.g

                    /* renamed from: b */
                    public final /* synthetic */ int f28060b;

                    public /* synthetic */ g(int i102) {
                        i10 = i102;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        X5JavaScriptInterface.lambda$InstallApk$4(i10);
                    }
                });
                return;
            }
            return;
        }
        install(this.mActivity, file);
        WebView webView3 = mWebView;
        if (webView3 != null) {
            webView3.post(new Runnable() { // from class: la.h

                /* renamed from: b */
                public final /* synthetic */ int f28061b;

                public /* synthetic */ h(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.lambda$InstallApk$5(i10);
                }
            });
        }
    }

    @JavascriptInterface
    public void RefreshWeb() {
        if (mWebView == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: la.k
            @Override // java.lang.Runnable
            public final void run() {
                X5JavaScriptInterface.lambda$RefreshWeb$6();
            }
        });
    }

    @JavascriptInterface
    public void copyContent(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                return;
            }
            ((ClipboardManager) activity.getSystemService("clipboard")).setText(str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Toast.makeText(this.mActivity, str2, 0).show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public void downloadApkFile(int i10, int i11, String str) {
        downloadFile(i10, i11, str);
    }

    public String getCopyBoradContent() {
        String str;
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                return "";
            }
            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
            if (!clipboardManager.getPrimaryClipDescription().hasMimeType(am.f6739e) && !clipboardManager.getPrimaryClipDescription().hasMimeType("text/html")) {
                return null;
            }
            try {
                str = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
            } catch (Exception unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void install(Context context, File file) {
        c.j(this.mActivity, new ea.b() { // from class: com.martian.libxianplay.wowan.X5JavaScriptInterface.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ File val$file;

            public AnonymousClass1(Context context2, File file2) {
                context = context2;
                file = file2;
            }

            @Override // ea.b
            public void permissionDenied() {
            }

            @Override // ea.b
            public void permissionGranted() {
                X5JavaScriptInterface.this.installApk(context, file);
            }
        });
    }

    @JavascriptInterface
    public void openAdDetail(String str) {
        Activity activity;
        if (l.q(str) || (activity = this.mActivity) == null) {
            return;
        }
        WowanDetailActivity.startWebViewActivity(activity, str);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002f: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:48), block:B:18:0x002f */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String redirectPath(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r0 = "User-Agent"
            java.lang.String r2 = "PacificHttpClient"
            r1.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r0 = 1
            r1.setInstanceFollowRedirects(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1.getResponseCode()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.net.URL r0 = r1.getURL()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1.disconnect()
            return r5
        L2e:
            r5 = move-exception
            r0 = r1
            goto L42
        L31:
            r0 = move-exception
            goto L39
        L33:
            r5 = move-exception
            goto L42
        L35:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L39:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L41
            r1.disconnect()
        L41:
            return r5
        L42:
            if (r0 == 0) goto L47
            r0.disconnect()
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libxianplay.wowan.X5JavaScriptInterface.redirectPath(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public void startAnotherApp(String str) {
        try {
            if (this.mActivity == null || TextUtils.isEmpty(str) || !isAPKinstall(this.mActivity, str)) {
                return;
            }
            startAnotherApp(this.mActivity, str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public void uninstallApk(String str) {
        if (TextUtils.isEmpty(str) || this.mActivity == null) {
            return;
        }
        this.mActivity.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)));
    }

    public static void startAnotherApp(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                ActivityInfo activityInfo = next.activityInfo;
                String str2 = activityInfo.packageName;
                String str3 = activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(268435456);
                intent2.setComponent(new ComponentName(str2, str3));
                context.startActivity(intent2);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
