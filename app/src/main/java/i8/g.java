package i8;

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
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ba.l;
import ba.m;
import com.martian.apptask.AppTaskManager;
import com.martian.apptask.data.AppTask;
import com.martian.libmars.R;
import com.martian.libmars.activity.TipActivity;
import com.martian.libmars.activity.WebViewActivity;
import com.martian.libmars.common.ConfigSingleton;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import l9.i0;
import l9.m0;
import l9.p0;
import l9.t0;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a */
    public static List<String> f26929a = Arrays.asList("taoyuewenhua.com", "taoyuewenhua.net", "taoyuewenhua.vip", "taoyuewenhua.ltd", "taoyuewenhua.cn");

    /* renamed from: b */
    public static final int f26930b = 1100;

    public static void A(Context context, String str, String str2, String str3, boolean z10) {
        if (z10 || context.getPackageName().equalsIgnoreCase(str2) || l.q(str3)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!(context instanceof Activity)) {
            z(context, str);
            return;
        }
        i0.z0((Activity) context, "跳转提醒", "即将跳转到" + str3 + "，是否继续？", new i0.l() { // from class: i8.f

            /* renamed from: a */
            public final /* synthetic */ Context f26927a;

            /* renamed from: b */
            public final /* synthetic */ String f26928b;

            public /* synthetic */ f(Context context2, String str4) {
                context = context2;
                str = str4;
            }

            @Override // l9.i0.l
            public final void a() {
                g.z(context, str);
            }
        });
    }

    public static void B(Activity activity, AppTask appTask, g8.a aVar) {
        h.b(appTask.clickReportUrls);
        if (!l.q(appTask.dplink) && h(activity, appTask.dplink)) {
            A(activity, appTask.dplink, appTask.packageName, appTask.name, false);
            return;
        }
        if (y(activity, appTask.packageName)) {
            return;
        }
        if (appTask.downloadDirectly) {
            I(activity, appTask, aVar);
            return;
        }
        if (aVar != null) {
            aVar.b(appTask);
        }
        WebViewActivity.A4(activity, appTask.homepageUrl, false);
    }

    public static void C(Activity activity, String str) {
        E(activity, str, null);
    }

    public static void D(Activity activity, String str, f8.b bVar) {
        F(activity, str, null, bVar);
    }

    public static void E(Activity activity, String str, String str2) {
        F(activity, str, str2, null);
    }

    public static void F(Activity activity, String str, String str2, f8.b bVar) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = j(str, ".apk");
        } else if (!str2.endsWith(".apk")) {
            str2 = str2 + ".apk";
        }
        new AlertDialog.Builder(activity).setTitle("文件下载").setMessage("是否下载 \"" + str2 + "-" + System.currentTimeMillis() + "\"").setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: i8.d

            /* renamed from: b */
            public final /* synthetic */ Activity f26920b;

            /* renamed from: c */
            public final /* synthetic */ String f26921c;

            /* renamed from: d */
            public final /* synthetic */ String f26922d;

            /* renamed from: e */
            public final /* synthetic */ f8.b f26923e;

            public /* synthetic */ d(Activity activity2, String str3, String str22, f8.b bVar2) {
                activity = activity2;
                str = str3;
                str2 = str22;
                bVar = bVar2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.t(activity, str, str2, bVar, dialogInterface, i10);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    public static void G(Activity activity) {
        H(activity, false);
    }

    public static void H(Activity activity, boolean z10) {
        if (m0.B(activity)) {
            View inflate = View.inflate(activity, com.martian.apptask.R.layout.dialog_open_access, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.martian.apptask.R.id.switch_icon);
            ImageView imageView2 = (ImageView) inflate.findViewById(com.martian.apptask.R.id.icon_dialog_close);
            TextView textView = (TextView) inflate.findViewById(com.martian.apptask.R.id.open_record_permission);
            if (z10) {
                textView.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            textView.setText(ConfigSingleton.D().s(r(activity) ? "设置好了" : "去开启"));
            AlertDialog G = i0.G(activity, inflate, true);
            if (G == null) {
                return;
            }
            imageView.postDelayed(new Runnable() { // from class: i8.a

                /* renamed from: b */
                public final /* synthetic */ ImageView f26916b;

                public /* synthetic */ a(ImageView imageView3) {
                    imageView = imageView3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.u(imageView);
                }
            }, 1000L);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: i8.b

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f26917b;

                public /* synthetic */ b(AlertDialog G2) {
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.dismiss();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: i8.c

                /* renamed from: b */
                public final /* synthetic */ Activity f26918b;

                /* renamed from: c */
                public final /* synthetic */ AlertDialog f26919c;

                public /* synthetic */ c(Activity activity2, AlertDialog G2) {
                    activity = activity2;
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.w(activity, G, view);
                }
            });
        }
    }

    public static void I(Activity activity, AppTask appTask, g8.a aVar) {
        String str = appTask.name;
        if (TextUtils.isEmpty(str)) {
            str = URLUtil.guessFileName(appTask.downloadUrl, null, null);
        }
        J(activity, appTask, str + "-" + System.currentTimeMillis() + ".apk", aVar);
    }

    public static void J(Activity activity, AppTask appTask, String str, g8.a aVar) {
        appTask.filename = str;
        if (AppTaskManager.y(activity, appTask.packageName)) {
            File file = new File(ba.b.f() + str);
            if (file.exists() && k(activity, file)) {
                if (aVar != null) {
                    aVar.a(appTask);
                    return;
                }
                return;
            }
        }
        if (!ConfigSingleton.D().N0() || appTask.downloadHint) {
            if (aVar != null) {
                aVar.b(appTask);
            }
            F(activity, appTask.downloadUrl, str, new f8.b() { // from class: i8.e

                /* renamed from: a */
                public final /* synthetic */ Activity f26924a;

                /* renamed from: b */
                public final /* synthetic */ AppTask f26925b;

                /* renamed from: c */
                public final /* synthetic */ g8.a f26926c;

                public /* synthetic */ e(Activity activity2, AppTask appTask2, g8.a aVar2) {
                    activity = activity2;
                    appTask = appTask2;
                    aVar = aVar2;
                }

                @Override // f8.b
                public final void a(String str2, String str3) {
                    g.x(activity, appTask, aVar, str2, str3);
                }
            });
            return;
        }
        if (aVar2 != null) {
            aVar2.b(appTask2);
            aVar2.d(appTask2);
        }
        p0.e("URL", "download started");
        h.b(appTask2.downloadStartedReportUrls);
        K(activity2, appTask2.downloadUrl, str);
        AppTaskManager.N(activity2, appTask2);
    }

    public static String K(Activity activity, String str, String str2) {
        File i10;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (i10 = ba.b.i()) == null) {
            return null;
        }
        File file = new File(i10, str2);
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            ((DownloadManager) activity.getSystemService("download")).enqueue(request);
            if (!activity.isFinishing()) {
                t0.b(activity, "开始下载" + str2);
            }
        } catch (Exception unused) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            activity.startActivity(intent);
        }
        return file.getAbsolutePath();
    }

    public static boolean L(Context context) {
        return m(context, "com.tencent.android.qqdownloader");
    }

    public static boolean g(Context context) {
        return m(context, "com.baidu.appsearch");
    }

    public static boolean h(Context context, String str) {
        if (n(str)) {
            try {
                new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456);
                return !context.getPackageManager().queryIntentActivities(r0, 0).isEmpty();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean i(Context context, Intent intent) {
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String j(String str, String str2) {
        String str3 = null;
        try {
            String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(str2) + str2.length());
            int lastIndexOf = substring.lastIndexOf("?");
            if (lastIndexOf != -1) {
                substring = substring.substring(lastIndexOf + 1);
            }
            int lastIndexOf2 = substring.lastIndexOf("=");
            if (lastIndexOf2 != -1) {
                substring = substring.substring(lastIndexOf2 + 1);
            }
            str3 = URLDecoder.decode(substring, "UTF-8");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        return l.s(str) + str2;
    }

    public static boolean k(Context context, File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Uri z10 = ba.g.z(context, file);
                    if (z10 == null) {
                        return false;
                    }
                    intent.setFlags(268435456);
                    int i10 = context.getApplicationInfo().targetSdkVersion;
                    if (m.o() && i10 >= 24) {
                        intent.addFlags(1);
                    }
                    intent.setDataAndType(z10, "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    return true;
                }
            } catch (ActivityNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean l(Context context, String str) {
        String str2 = "";
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                str2 = packageArchiveInfo.applicationInfo.packageName;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return !l.q(str2);
    }

    public static boolean m(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    public static boolean n(String str) {
        return !o(str);
    }

    public static boolean o(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("about:") || str.isEmpty()) {
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    public static boolean p(Context context) {
        return m(context, "com.tencent.mm");
    }

    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            Iterator<String> it = f26929a.iterator();
            while (it.hasNext()) {
                if (host.endsWith(it.next())) {
                    return true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public static boolean r(Context context) {
        return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    public static /* synthetic */ void t(Activity activity, String str, String str2, f8.b bVar, DialogInterface dialogInterface, int i10) {
        K(activity, str, str2);
        if (bVar != null) {
            bVar.a(str2, str);
        }
    }

    public static /* synthetic */ void u(ImageView imageView) {
        imageView.setImageResource(ConfigSingleton.D().e0());
    }

    public static /* synthetic */ void w(Activity activity, AlertDialog alertDialog, View view) {
        if (r(activity)) {
            t0.b(activity, "权限开启成功");
        } else {
            activity.startActivityForResult(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 1100);
            activity.startActivity(new Intent(activity, (Class<?>) TipActivity.class));
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void x(Activity activity, AppTask appTask, g8.a aVar, String str, String str2) {
        AppTaskManager.N(activity, appTask);
        if (aVar != null) {
            aVar.d(appTask);
        }
        p0.e("URL", "download started");
        h.b(appTask.downloadStartedReportUrls);
    }

    public static boolean y(Context context, String str) {
        Intent launchIntentForPackage;
        if (l.q(str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        try {
            launchIntentForPackage.addFlags(268435456);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void z(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
