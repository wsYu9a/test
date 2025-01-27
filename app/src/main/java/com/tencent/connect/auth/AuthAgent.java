package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class AuthAgent extends BaseApi {
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* renamed from: c */
    private IUiListener f25209c;

    /* renamed from: d */
    private String f25210d;

    /* renamed from: e */
    private WeakReference<Activity> f25211e;

    /* renamed from: com.tencent.connect.auth.AuthAgent$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f25212a;

        /* renamed from: b */
        final /* synthetic */ IUiListener f25213b;

        /* renamed from: com.tencent.connect.auth.AuthAgent$1$1 */
        class RunnableC05251 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Activity f25215a;

            RunnableC05251(Activity activity) {
                activity = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity = activity;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f25282b);
                Activity activity2 = activity;
                if (activity2 == null || activity2.isFinishing()) {
                    return;
                }
                aVar.show();
            }
        }

        AnonymousClass1(String str, IUiListener iUiListener) {
            str2 = str;
            cVar = iUiListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
            Activity activity = (Activity) AuthAgent.this.f25211e.get();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1

                    /* renamed from: a */
                    final /* synthetic */ Activity f25215a;

                    RunnableC05251(Activity activity2) {
                        activity = activity2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity2 = activity;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f25282b);
                        Activity activity22 = activity;
                        if (activity22 == null || activity22.isFinishing()) {
                            return;
                        }
                        aVar.show();
                    }
                });
            }
        }
    }

    private class a implements IUiListener {

        /* renamed from: a */
        IUiListener f25217a;

        public a(IUiListener iUiListener) {
            this.f25217a = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f25217a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i2 = jSONObject.getInt("ret");
                String string = i2 == 0 ? bw.o : jSONObject.getString("msg");
                IUiListener iUiListener = this.f25217a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new JSONObject().put("ret", i2).put("msg", string));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f25217a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    private class c implements IUiListener {

        /* renamed from: b */
        private final IUiListener f25236b;

        /* renamed from: c */
        private final boolean f25237c;

        /* renamed from: d */
        private final Context f25238d;

        public c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.f25238d = context;
            this.f25236b = iUiListener;
            this.f25237c = z;
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f25236b.onCancel();
            f.b();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString(Constants.PARAM_ACCESS_TOKEN);
                String string2 = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f25282b != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f25282b.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f25282b.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.f25238d, ((BaseApi) AuthAgent.this).f25282b);
                }
                String string4 = jSONObject.getString(Constants.PARAM_PLATFORM_ID);
                if (string4 != null) {
                    try {
                        this.f25238d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString(Constants.PARAM_PLATFORM_ID, string4).commit();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
                    }
                }
                if (this.f25237c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e3);
            }
            this.f25236b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            f.b();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f25236b.onError(uiError);
            f.b();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
            return;
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener) {
        return doLogin(activity, str, iUiListener, false, null);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f25211e = null;
        this.f25209c = null;
    }

    private int a(boolean z, IUiListener iUiListener) {
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(d.a());
        Bundle a2 = a();
        if (z) {
            a2.putString("isadd", "1");
        }
        a2.putString(Constants.PARAM_SCOPE, this.f25210d);
        a2.putString(Constants.PARAM_CLIENT_ID, this.f25282b.getAppId());
        if (BaseApi.isOEM) {
            a2.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + BaseApi.installChannel + "-" + BaseWrapper.BASE_PKG_SYSTEM + "-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
        } else {
            a2.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        a2.putString("sign", g.b(d.a(), str));
        a2.putString(com.alipay.mobilesecuritysdk.deviceID.c.y, str);
        a2.putString("display", "mobile");
        a2.putString("response_type", OapsKey.KEY_TOKEN);
        a2.putString("redirect_uri", "auth://tauth.qq.com/");
        a2.putString("cancel_display", "1");
        a2.putString("switch", "1");
        a2.putString("status_userip", i.a());
        String str2 = com.tencent.open.utils.f.a().a(d.a(), "http://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a2);
        c cVar = new c(d.a(), iUiListener, true, false);
        f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        h.a(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1

            /* renamed from: a */
            final /* synthetic */ String f25212a;

            /* renamed from: b */
            final /* synthetic */ IUiListener f25213b;

            /* renamed from: com.tencent.connect.auth.AuthAgent$1$1 */
            class RunnableC05251 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Activity f25215a;

                RunnableC05251(Activity activity2) {
                    activity = activity2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f25282b);
                    Activity activity22 = activity;
                    if (activity22 == null || activity22.isFinishing()) {
                        return;
                    }
                    aVar.show();
                }
            }

            AnonymousClass1(String str22, IUiListener cVar2) {
                str2 = str22;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
                Activity activity2 = (Activity) AuthAgent.this.f25211e.get();
                if (activity2 != null) {
                    activity2.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1

                        /* renamed from: a */
                        final /* synthetic */ Activity f25215a;

                        RunnableC05251(Activity activity22) {
                            activity = activity22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Activity activity22 = activity;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity22, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f25282b);
                            Activity activity222 = activity;
                            if (activity222 == null || activity222.isFinishing()) {
                                return;
                            }
                            aVar.show();
                        }
                    });
                }
            }
        });
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    protected void b(IUiListener iUiListener) {
        Bundle a2 = a();
        a2.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f25282b, d.a(), "https://openmobile.qq.com/v3/user/get_info", a2, "GET", new BaseApi.TempRequestListener(new a(iUiListener)));
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment) {
        this.f25210d = str;
        this.f25211e = new WeakReference<>(activity);
        this.f25209c = iUiListener;
        if (a(activity, fragment, z)) {
            f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            com.tencent.open.b.d.a().a(this.f25282b.getOpenId(), this.f25282b.getAppId(), "2", "1", "5", "0", "0", "0");
            return 1;
        }
        com.tencent.open.b.d.a().a(this.f25282b.getOpenId(), this.f25282b.getAppId(), "2", "1", "5", "1", "0", "0");
        f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        b bVar = new b(this.f25209c);
        this.f25209c = bVar;
        return a(z, bVar);
    }

    private class b implements IUiListener {

        /* renamed from: a */
        IUiListener f25219a;

        /* renamed from: c */
        private final String f25221c = "sendinstall";

        /* renamed from: d */
        private final String f25222d = "installwording";

        /* renamed from: e */
        private final String f25223e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$1 */
        class AnonymousClass1 extends a {

            /* renamed from: a */
            final /* synthetic */ IUiListener f25224a;

            /* renamed from: b */
            final /* synthetic */ Object f25225b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Dialog dialog, IUiListener iUiListener, Object obj) {
                super(dialog);
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a();
                Dialog dialog = this.f25233d;
                if (dialog != null && dialog.isShowing()) {
                    this.f25233d.dismiss();
                }
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$2 */
        class AnonymousClass2 extends a {

            /* renamed from: a */
            final /* synthetic */ IUiListener f25227a;

            /* renamed from: b */
            final /* synthetic */ Object f25228b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Dialog dialog, IUiListener iUiListener, Object obj) {
                super(dialog);
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialog = this.f25233d;
                if (dialog != null && dialog.isShowing()) {
                    this.f25233d.dismiss();
                }
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$3 */
        class AnonymousClass3 implements DialogInterface.OnCancelListener {

            /* renamed from: a */
            final /* synthetic */ IUiListener f25230a;

            /* renamed from: b */
            final /* synthetic */ Object f25231b;

            AnonymousClass3(IUiListener iUiListener, Object obj) {
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        private abstract class a implements View.OnClickListener {

            /* renamed from: d */
            Dialog f25233d;

            a(Dialog dialog) {
                this.f25233d = dialog;
            }
        }

        public b(IUiListener iUiListener) {
            this.f25219a = iUiListener;
        }

        private void a(String str, IUiListener iUiListener, Object obj) {
            PackageInfo packageInfo;
            Activity activity = (Activity) AuthAgent.this.f25211e.get();
            if (activity == null) {
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener anonymousClass1 = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1

                /* renamed from: a */
                final /* synthetic */ IUiListener f25224a;

                /* renamed from: b */
                final /* synthetic */ Object f25225b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Dialog dialog2, IUiListener iUiListener2, Object obj2) {
                    super(dialog2);
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.a();
                    Dialog dialog2 = this.f25233d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f25233d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener anonymousClass2 = new a(dialog2) { // from class: com.tencent.connect.auth.AuthAgent.b.2

                /* renamed from: a */
                final /* synthetic */ IUiListener f25227a;

                /* renamed from: b */
                final /* synthetic */ Object f25228b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Dialog dialog2, IUiListener iUiListener2, Object obj2) {
                    super(dialog2);
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f25233d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f25233d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog2.getWindow().setBackgroundDrawable(colorDrawable);
            dialog2.setContentView(a(activity, loadIcon, str, anonymousClass1, anonymousClass2));
            dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3

                /* renamed from: a */
                final /* synthetic */ IUiListener f25230a;

                /* renamed from: b */
                final /* synthetic */ Object f25231b;

                AnonymousClass3(IUiListener iUiListener2, Object obj2) {
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            });
            if (activity.isFinishing()) {
                return;
            }
            dialog2.show();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f25219a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            if (obj != null) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    r2 = jSONObject.getInt("sendinstall") == 1;
                    str = jSONObject.getString("installwording");
                } catch (JSONException unused) {
                    f.d("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                }
                String decode = URLDecoder.decode(str);
                f.a("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx");
                if (r2 && !TextUtils.isEmpty(decode)) {
                    a(decode, this.f25219a, obj);
                    return;
                }
                IUiListener iUiListener = this.f25219a;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f25219a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }

        private Drawable a(String str, Context context) {
            InputStream open;
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                try {
                    bitmap = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                    bitmap = null;
                }
                if (bitmap == null) {
                    return null;
                }
                byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                NinePatch.isNinePatchChunk(ninePatchChunk);
                return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
            }
            drawable = Drawable.createFromStream(open, str);
            open.close();
            return drawable;
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i2 = (int) (60.0f * f2);
            int i3 = (int) (f2 * 14.0f);
            int i4 = (int) (18.0f * f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i4, (int) (6.0f * f2), i4);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f2));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f3 = 5.0f * f2;
            layoutParams2.setMargins(0, 0, (int) f3, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i5 = (int) (12.0f * f2);
            layoutParams3.setMargins(0, 0, 0, i5);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, TTAdConstant.IMAGE_MODE_SPLASH));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i6 = (int) (45.0f * f2);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i6);
            layoutParams5.rightMargin = i3;
            int i7 = (int) (4.0f * f2);
            layoutParams5.leftMargin = i7;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i6);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i7;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f2), (int) (f2 * 163.0f));
            relativeLayout.setPadding(i3, 0, i5, i5);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            paintDrawable.setCornerRadius(f3);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        protected void a() {
            Bundle b2 = AuthAgent.this.b();
            Activity activity = (Activity) AuthAgent.this.f25211e.get();
            if (activity != null) {
                HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f25282b, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b2, "POST", null);
            }
        }
    }

    private boolean a(Activity activity, Fragment fragment, boolean z) {
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent b2 = b("com.tencent.open.agent.AgentActivity");
        if (b2 != null) {
            Bundle a2 = a();
            if (z) {
                a2.putString("isadd", "1");
            }
            a2.putString(Constants.PARAM_SCOPE, this.f25210d);
            a2.putString(Constants.PARAM_CLIENT_ID, this.f25282b.getAppId());
            if (BaseApi.isOEM) {
                a2.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + BaseApi.installChannel + "-" + BaseWrapper.BASE_PKG_SYSTEM + "-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                a2.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
            a2.putString("need_pay", "1");
            a2.putString(Constants.KEY_APP_NAME, g.a(d.a()));
            b2.putExtra(Constants.KEY_ACTION, "action_login");
            b2.putExtra(Constants.KEY_PARAMS, a2);
            if (a(b2)) {
                this.f25209c = new b(this.f25209c);
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_LOGIN, this.f25209c);
                if (fragment != null) {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, b2, Constants.REQUEST_LOGIN);
                } else {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, b2, Constants.REQUEST_LOGIN);
                }
                f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                com.tencent.open.b.d.a().a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f25282b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        com.tencent.open.b.d.a().a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f25282b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    protected void a(IUiListener iUiListener) {
        String str;
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f25282b.getAccessToken();
        String openId = this.f25282b.getOpenId();
        String appId = this.f25282b.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = i.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(str)) {
            f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle a2 = a();
        a2.putString("encrytoken", str);
        HttpUtils.requestAsync(this.f25282b, d.a(), "https://openmobile.qq.com/user/user_login_statis", a2, "POST", null);
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
