package com.martian.libxianplay.wowan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.martian.libsupport.permission.TipInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.Iterator;

@SuppressLint({"NewApi"})
@TargetApi(16)
/* loaded from: classes3.dex */
public class X5JavaScriptInterface {
    public static final String mStringKey = "fdsmkfshdik423432";
    public static WebView mWebView;
    private final Activity mActivity;
    private final Handler mHandler = new Handler();

    /* renamed from: com.martian.libxianplay.wowan.X5JavaScriptInterface$1 */
    class AnonymousClass1 implements com.martian.libsupport.permission.f {
        final /* synthetic */ Context val$context;
        final /* synthetic */ File val$file;

        AnonymousClass1(final Context val$file, final File val$context) {
            context = val$file;
            file = val$context;
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            X5JavaScriptInterface.this.installApk(context, file);
        }
    }

    /* renamed from: com.martian.libxianplay.wowan.X5JavaScriptInterface$2 */
    class AnonymousClass2 implements com.martian.libsupport.permission.f {
        final /* synthetic */ int val$isInstall;
        final /* synthetic */ String val$url;
        final /* synthetic */ int val$whichTask;

        AnonymousClass2(final int val$url, final int val$isInstall, final String val$whichTask) {
            whichTask = val$url;
            isInstall = val$isInstall;
            url = val$whichTask;
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            X5JavaScriptInterface.this.showShortToast();
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            X5JavaScriptInterface.this.downloadFile(whichTask, isInstall, url);
        }
    }

    public X5JavaScriptInterface(Activity activity, WebView webview) {
        this.mActivity = activity;
        mWebView = webview;
    }

    public void downloadFile(final int whichTask, final int isInstall, String url) {
        String str;
        Uri uriForDownloadedFile;
        String str2 = url;
        try {
            if (this.mActivity != null && mWebView != null) {
                if (!str2.contains(".apk")) {
                    str2 = redirectPath(str2);
                }
                File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
                if (externalStorageDirectory != null) {
                    str = externalStorageDirectory.getAbsolutePath() + File.separator + "wowan";
                } else {
                    str = "";
                }
                if (com.martian.libsupport.k.p(str)) {
                    Toast.makeText(this.mActivity, "请插入SD卡", 1).show();
                    return;
                }
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
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
                long j2 = sharedPreferences.getLong(whichTask + "", 0L);
                if (j2 != 0 && PlayMeUtils.getBytesAndStatus(j2, downloadManager)[2] == 8 && (uriForDownloadedFile = downloadManager.getUriForDownloadedFile(j2)) != null && !TextUtils.isEmpty(uriForDownloadedFile.toString())) {
                    File file2 = new File(str, str3);
                    if (file2.exists()) {
                        PlayMeUtils.installThroughUri(this.mActivity, file2);
                        if (mWebView != null) {
                            final String string = sharedPreferences.getString(j2 + OapsWrapper.KEY_PATH, "");
                            final String string2 = sharedPreferences.getString(j2 + OapsKey.KEY_ADID, "");
                            mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    X5JavaScriptInterface.mWebView.loadUrl("javascript:downloadApkFileFinishListener(" + string2 + ",'" + string + "')");
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
                request.setDestinationInExternalPublicDir("/wowan/", str3);
                request.allowScanningByMediaScanner();
                long enqueue = downloadManager.enqueue(request);
                sharedPreferences.edit().putLong(whichTask + "", enqueue).commit();
                sharedPreferences.edit().putString(enqueue + OapsWrapper.KEY_PATH, str + "/" + str3).commit();
                sharedPreferences.edit().putString(enqueue + OapsKey.KEY_ADID, whichTask + "").commit();
                Activity activity = this.mActivity;
                if (activity instanceof WowanDetailActivity) {
                    ((WowanDetailActivity) activity).startCheckProgressStates();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void installApk(Context context, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri z = com.martian.libsupport.e.z(this.mActivity, file);
        if (z == null) {
            return;
        }
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (com.martian.libsupport.l.u() && i2 >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(z, AdBaseConstants.MIME_APK);
        context.startActivity(intent);
    }

    public static boolean isAPKinstall(Context context, String packageName) {
        boolean z;
        PackageInfo packageInfo;
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(8192).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (packageName.equalsIgnoreCase(it.next().packageName)) {
                z = true;
                break;
            }
        }
        if (z) {
            return z;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    static /* synthetic */ void lambda$CheckAppIsInstall$0(final String packageName, final String[] versionCodeArray) {
        String encrypt = PlayMeUtils.encrypt(packageName + versionCodeArray[0] + mStringKey);
        mWebView.loadUrl("javascript:CheckAppCallback('" + packageName + "','" + versionCodeArray[0] + "','" + encrypt + "')");
    }

    static /* synthetic */ void lambda$RefreshWeb$6() {
        String url = mWebView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        mWebView.loadUrl(url);
    }

    public void showShortToast() {
        Toast.makeText(this.mActivity, "缺少存储权限", 0).show();
    }

    @JavascriptInterface
    public void Browser(String url) {
        if (this.mActivity == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(url);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (this.mActivity.getPackageManager().resolveActivity(intent, 65536) != null) {
                this.mActivity.startActivity(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void CheckAppIsInstall(final String packageName) {
        Activity activity = this.mActivity;
        if (activity == null || mWebView == null) {
            return;
        }
        final String[] strArr = new String[1];
        boolean z = false;
        for (PackageInfo packageInfo : activity.getPackageManager().getInstalledPackages(8192)) {
            if (packageName.equalsIgnoreCase(packageInfo.packageName)) {
                strArr[0] = String.valueOf(packageInfo.versionCode);
                z = true;
            }
        }
        if (z) {
            mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.l
                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.lambda$CheckAppIsInstall$0(packageName, strArr);
                }
            });
        } else {
            mWebView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.g
                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.mWebView.loadUrl("javascript:CheckAppNoInstall()");
                }
            });
        }
    }

    @JavascriptInterface
    public void GetCopyContent() {
        final String copyBoradContent = getCopyBoradContent();
        WebView webView = mWebView;
        if (webView != null) {
            webView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.k
                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.mWebView.loadUrl("javascript:APPReturnClipboard('" + copyBoradContent + "')");
                }
            });
        }
    }

    @JavascriptInterface
    public void InstallApk(final int whichTask, String path) {
        if (com.martian.libsupport.k.p(path)) {
            WebView webView = mWebView;
            if (webView != null) {
                webView.post(new Runnable() { // from class: com.martian.libxianplay.wowan.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        X5JavaScriptInterface.mWebView.loadUrl("javascript:InstallApkListener(" + whichTask + ",0,'安装路径为空')");
                    }
                });
                return;
            }
            return;
        }
        File file = new File(path);
        if (!file.exists()) {
            WebView webView2 = mWebView;
            if (webView2 != null) {
                webView2.post(new Runnable() { // from class: com.martian.libxianplay.wowan.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        X5JavaScriptInterface.mWebView.loadUrl("javascript:InstallApkListener(" + whichTask + ",0,'安装路径不存在')");
                    }
                });
                return;
            }
            return;
        }
        install(this.mActivity, file);
        WebView webView3 = mWebView;
        if (webView3 != null) {
            webView3.post(new Runnable() { // from class: com.martian.libxianplay.wowan.h
                @Override // java.lang.Runnable
                public final void run() {
                    X5JavaScriptInterface.mWebView.loadUrl("javascript:InstallApkListener(" + whichTask + ",1,'唤起安装成功')");
                }
            });
        }
    }

    @JavascriptInterface
    public void RefreshWeb() {
        if (mWebView == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.martian.libxianplay.wowan.i
            @Override // java.lang.Runnable
            public final void run() {
                X5JavaScriptInterface.lambda$RefreshWeb$6();
            }
        });
    }

    @JavascriptInterface
    public void copyContent(String officialaccount, String tips) {
        if (officialaccount == null) {
            return;
        }
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                return;
            }
            ((ClipboardManager) activity.getSystemService("clipboard")).setText(officialaccount);
            if (TextUtils.isEmpty(tips)) {
                return;
            }
            Toast.makeText(this.mActivity, tips, 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    @TargetApi(11)
    public void downloadApkFile(final int whichTask, final int isInstall, final String url) {
        com.martian.libsupport.permission.g.h(this.mActivity, new com.martian.libsupport.permission.f() { // from class: com.martian.libxianplay.wowan.X5JavaScriptInterface.2
            final /* synthetic */ int val$isInstall;
            final /* synthetic */ String val$url;
            final /* synthetic */ int val$whichTask;

            AnonymousClass2(final int whichTask2, final int isInstall2, final String url2) {
                whichTask = whichTask2;
                isInstall = isInstall2;
                url = url2;
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionDenied() {
                X5JavaScriptInterface.this.showShortToast();
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionGranted() {
                X5JavaScriptInterface.this.downloadFile(whichTask, isInstall, url);
            }
        }, new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能正常使用下载功能\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
    }

    public String getCopyBoradContent() {
        String str;
        try {
            Activity activity = this.mActivity;
            if (activity == null) {
                return "";
            }
            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
            if (!clipboardManager.getPrimaryClipDescription().hasMimeType("text/plain") && !clipboardManager.getPrimaryClipDescription().hasMimeType("text/html")) {
                return null;
            }
            try {
                str = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
            } catch (Exception unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void install(final Context context, final File file) {
        com.martian.libsupport.permission.g.f(this.mActivity, new com.martian.libsupport.permission.f() { // from class: com.martian.libxianplay.wowan.X5JavaScriptInterface.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ File val$file;

            AnonymousClass1(final Context context2, final File file2) {
                context = context2;
                file = file2;
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionDenied() {
            }

            @Override // com.martian.libsupport.permission.f
            public void permissionGranted() {
                X5JavaScriptInterface.this.installApk(context, file);
            }
        });
    }

    @JavascriptInterface
    public void openAdDetail(String url) {
        Activity activity;
        if (com.martian.libsupport.k.p(url) || (activity = this.mActivity) == null) {
            return;
        }
        WowanDetailActivity.startWebViewActivity(activity, url);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String redirectPath(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r0 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            r1.setReadTimeout(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            java.lang.String r0 = "User-Agent"
            java.lang.String r2 = "PacificHttpClient"
            r1.setRequestProperty(r0, r2)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            r0 = 1
            r1.setInstanceFollowRedirects(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            r1.getResponseCode()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            java.net.URL r0 = r1.getURL()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3f
            r1.disconnect()
            return r5
        L2e:
            r0 = move-exception
            goto L36
        L30:
            r5 = move-exception
            goto L41
        L32:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L36:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L3e
            r1.disconnect()
        L3e:
            return r5
        L3f:
            r5 = move-exception
            r0 = r1
        L41:
            if (r0 == 0) goto L46
            r0.disconnect()
        L46:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libxianplay.wowan.X5JavaScriptInterface.redirectPath(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public void startAnotherApp(String packageName) {
        try {
            if (this.mActivity == null || TextUtils.isEmpty(packageName) || !isAPKinstall(this.mActivity, packageName)) {
                return;
            }
            startAnotherApp(this.mActivity, packageName);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void uninstallApk(String packName) {
        if (TextUtils.isEmpty(packName) || this.mActivity == null) {
            return;
        }
        this.mActivity.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + packName)));
    }

    public static void startAnotherApp(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                ActivityInfo activityInfo = next.activityInfo;
                String str = activityInfo.packageName;
                String str2 = activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent2.setComponent(new ComponentName(str, str2));
                context.startActivity(intent2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
