package com.martian.apptask.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.apptask.AppTaskManager;
import com.martian.apptask.R;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.activity.TipActivity;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.q0;
import com.martian.libmars.utils.w0;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a */
    public static List<String> f9653a = Arrays.asList("taoyuewenhua.com", "taoyuewenhua.net", "taoyuewenhua.vip", "taoyuewenhua.ltd", "taoyuewenhua.cn");

    /* renamed from: b */
    public static final int f9654b = 1100;

    public static void A(Activity activity) {
        B(activity, false);
    }

    public static void B(final Activity activity, boolean darkText) {
        if (n0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_open_access, null);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.switch_icon);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.icon_dialog_close);
            TextView textView = (TextView) inflate.findViewById(R.id.open_record_permission);
            if (darkText) {
                textView.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            textView.setText(l(activity) ? "设置好了" : "去开启");
            final AlertDialog b2 = k0.b(activity, inflate, true);
            if (b2 == null) {
                return;
            }
            imageView.postDelayed(new Runnable() { // from class: com.martian.apptask.g.b
                @Override // java.lang.Runnable
                public final void run() {
                    imageView.setImageResource(com.martian.libmars.d.h.F().m0());
                }
            }, 1000L);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.apptask.g.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b2.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.apptask.g.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.q(activity, b2, view);
                }
            });
        }
    }

    public static void C(final j1 activity, final AppTask app, final com.martian.apptask.e.c listener) {
        String str = app.name;
        if (TextUtils.isEmpty(str)) {
            str = URLUtil.guessFileName(app.downloadUrl, null, null);
        }
        D(activity, app, str + "-" + System.currentTimeMillis() + ".apk", listener);
    }

    public static void D(final j1 activity, final AppTask app, final String filename, final com.martian.apptask.e.c listener) {
        app.filename = filename;
        if (AppTaskManager.y(activity, app.packageName)) {
            File file = new File(com.martian.libmars.d.h.F().u() + filename);
            if (file.exists() && e(activity, file)) {
                if (listener != null) {
                    listener.onAppTaskInstalled(app);
                    return;
                }
                return;
            }
        }
        if (!com.martian.libmars.d.h.F().U0() || app.downloadHint) {
            if (listener != null) {
                listener.onAppTaskClick(app);
            }
            z(activity, app.downloadUrl, filename, new com.martian.apptask.d() { // from class: com.martian.apptask.g.c
                @Override // com.martian.apptask.d
                public final void a(String str, String str2) {
                    g.r(j1.this, app, listener, str, str2);
                }
            });
            return;
        }
        if (listener != null) {
            listener.onAppTaskClick(app);
            listener.onAppTaskDownload(app);
        }
        q0.i("URL", "download started");
        h.b(app.downloadStartedReportUrls);
        E(activity, app.downloadUrl, filename);
        AppTaskManager.N(activity, app);
    }

    public static String E(j1 activity, String url, String filename) {
        return F(activity, url, filename, com.martian.libmars.d.h.F().P());
    }

    public static String F(j1 activity, String url, String filename, String path) {
        if (k.p(url)) {
            return path + File.separator + filename;
        }
        try {
            com.martian.libsupport.e.i(com.martian.libmars.d.h.F().u());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(path, filename);
            ((DownloadManager) activity.getSystemService("download")).enqueue(request);
            activity.k1("开始下载" + filename);
        } catch (Exception unused) {
            activity.n1(url);
        }
        return path + File.separator + filename;
    }

    public static boolean G(Context context) {
        return g(context, "com.tencent.android.qqdownloader");
    }

    public static boolean a(Context context) {
        return g(context, "com.baidu.appsearch");
    }

    public static boolean b(Context context, String dplink) {
        if (h(dplink)) {
            try {
                new Intent("android.intent.action.VIEW", Uri.parse(dplink)).setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                return !context.getPackageManager().queryIntentActivities(r0, 0).isEmpty();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean c(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static String d(String url, String suffix) {
        String str = null;
        try {
            String substring = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(suffix) + suffix.length());
            int lastIndexOf = substring.lastIndexOf("?");
            if (lastIndexOf != -1) {
                substring = substring.substring(lastIndexOf + 1);
            }
            int lastIndexOf2 = substring.lastIndexOf("=");
            if (lastIndexOf2 != -1) {
                substring = substring.substring(lastIndexOf2 + 1);
            }
            str = URLDecoder.decode(substring, "UTF-8");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return k.r(url) + suffix;
    }

    public static boolean e(Context context, File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Uri z = com.martian.libsupport.e.z(context, file);
                    if (z == null) {
                        return false;
                    }
                    intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    int i2 = context.getApplicationInfo().targetSdkVersion;
                    if (l.u() && i2 >= 24) {
                        intent.addFlags(1);
                    }
                    intent.setDataAndType(z, AdBaseConstants.MIME_APK);
                    context.startActivity(intent);
                    return true;
                }
            } catch (ActivityNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean f(Context context, String filePath) {
        String str = "";
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(filePath, 1);
            if (packageArchiveInfo != null) {
                str = packageArchiveInfo.applicationInfo.packageName;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return !k.p(str);
    }

    public static boolean g(Context context, String packageName) {
        return context.getPackageManager().getLaunchIntentForPackage(packageName) != null;
    }

    public static boolean h(final String url) {
        return !i(url);
    }

    public static boolean i(final String url) {
        if (url == null) {
            return false;
        }
        if (url.startsWith("about:") || url.equals("")) {
            return true;
        }
        String scheme = Uri.parse(url).getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || b.b.a.b.b.f4198a.equalsIgnoreCase(scheme);
    }

    public static boolean j(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (l.q()) {
                return true;
            }
            return powerManager.isScreenOn();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean k(String activityUrl) {
        if (TextUtils.isEmpty(activityUrl)) {
            return false;
        }
        try {
            String host = new URL(activityUrl).getHost();
            Iterator<String> it = f9653a.iterator();
            while (it.hasNext()) {
                if (host.endsWith(it.next())) {
                    return true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public static boolean l(Context context) {
        return l.r() && ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    static /* synthetic */ void n(final j1 activity, final String url, final String apkFileName, final com.martian.apptask.d receiver, DialogInterface dialog, int which) {
        F(activity, url, apkFileName, com.martian.libmars.d.h.F().P());
        if (receiver != null) {
            receiver.a(apkFileName, url);
        }
    }

    static /* synthetic */ void q(final Activity activity, final AlertDialog alertDialog, View view1) {
        if (l(activity)) {
            w0.a(activity, "权限开启成功");
        } else {
            activity.startActivityForResult(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 1100);
            activity.startActivity(new Intent(activity, (Class<?>) TipActivity.class));
        }
        alertDialog.dismiss();
    }

    static /* synthetic */ void r(final j1 activity, final AppTask app, final com.martian.apptask.e.c listener, String name, String url) {
        AppTaskManager.N(activity, app);
        if (listener != null) {
            listener.onAppTaskDownload(app);
        }
        q0.i("URL", "download started");
        h.b(app.downloadStartedReportUrls);
    }

    public static boolean s(Context context, String packageName) {
        Intent launchIntentForPackage;
        if (k.p(packageName) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName)) == null) {
            return false;
        }
        try {
            launchIntentForPackage.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void t(Context context, String deeplink) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(deeplink));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void u(final Context context, final String deeplink, String packageName, final String name, boolean openDirectly) {
        if (openDirectly || context.getPackageName().equalsIgnoreCase(packageName) || k.p(name)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(deeplink));
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!(context instanceof Activity)) {
            t(context, deeplink);
            return;
        }
        k0.P((Activity) context, "跳转提醒", "即将跳转到" + name + "，是否继续？", new k0.l() { // from class: com.martian.apptask.g.a
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                g.t(context, deeplink);
            }
        });
    }

    public static void v(final j1 activity, final AppTask appTask, final com.martian.apptask.e.c l) {
        h.b(appTask.clickReportUrls);
        if (!k.p(appTask.dplink) && b(activity, appTask.dplink)) {
            u(activity, appTask.dplink, appTask.packageName, appTask.name, false);
            return;
        }
        if (s(activity, appTask.packageName)) {
            return;
        }
        if (appTask.downloadDirectly) {
            C(activity, appTask, l);
            return;
        }
        if (l != null) {
            l.onAppTaskClick(appTask);
        }
        WebViewActivity.c4(activity, appTask.homepageUrl, false);
    }

    public static void w(final j1 activity, final String url) {
        y(activity, url, null);
    }

    public static void x(final j1 activity, final String url, final com.martian.apptask.d receiver) {
        z(activity, url, null, receiver);
    }

    public static void y(final j1 activity, final String url, String filename) {
        z(activity, url, filename, null);
    }

    public static void z(final j1 activity, final String url, final String filename, final com.martian.apptask.d receiver) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(filename)) {
            filename = d(url, ".apk");
        } else if (!filename.endsWith(".apk")) {
            filename = filename + ".apk";
        }
        new AlertDialog.Builder(activity).setTitle("文件下载").setMessage("是否下载 \"" + filename + "-" + System.currentTimeMillis() + "\"").setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.martian.apptask.g.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                g.n(j1.this, url, filename, receiver, dialogInterface, i2);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }
}
