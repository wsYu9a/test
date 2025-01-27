package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class j0 extends Enum<j0> {

    /* renamed from: a */
    public final boolean f17915a;

    /* renamed from: b */
    public static final j0 f17906b = new a("IGNORE_ABOUT_SCHEME", 0, false);

    /* renamed from: c */
    public static final j0 f17907c = new j0("MINI_PROGRAM", 1, false) { // from class: com.sigmob.sdk.base.common.j0.b
        public b(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getWXProgramRes() == null) {
                return null;
            }
            return baseAdUnit.getWXProgramRes().wx_app_path;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() != 7) {
                throw new Exception("performAction interaction_type is not right with " + baseAdUnit.getInteractionType());
            }
            WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
            if (wXProgramRes != null) {
                try {
                    Method method = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
                    method.setAccessible(true);
                    Object invoke = method.invoke(WXAPIFactory.class, context, wXProgramRes.wx_app_id);
                    Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
                    Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
                    declaredField.setAccessible(true);
                    declaredField.set(newInstance, wXProgramRes.wx_app_username);
                    Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField(t8.a.f30751f);
                    declaredField2.setAccessible(true);
                    declaredField2.set(newInstance, wXProgramRes.wx_app_path);
                    Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
                    declaredField3.setAccessible(true);
                    declaredField3.set(newInstance, 0);
                    Method method2 = invoke.getClass().getMethod("sendReq", newInstance.getClass().getSuperclass());
                    method2.setAccessible(true);
                    boolean booleanValue = ((Boolean) method2.invoke(invoke, newInstance)).booleanValue();
                    Log.d("lance", "openB:isSendReq " + booleanValue);
                    if (booleanValue) {
                        return;
                    }
                    throw new Exception("get mini_program error: " + uri.toString());
                } catch (Throwable th2) {
                    SigmobLog.e("get mini_program error " + th2.getMessage());
                    throw new Exception("get mini_program error: " + uri.toString());
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || i10 != 7) ? false : true;
        }
    };

    /* renamed from: d */
    public static final j0 f17908d = new j0("FOLLOW_DEEP_LINK", 2, true) { // from class: com.sigmob.sdk.base.common.j0.c
        public c(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getDeeplinkUrl();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 8) {
                u.b(context, uri, com.sigmob.sdk.a.f());
            } else {
                u.a(context, uri);
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return i10 == 8 ? "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || "HAP".equalsIgnoreCase(scheme) : ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    };

    /* renamed from: e */
    public static final j0 f17909e = new d("FOLLOW_PACKAGE_NAME", 3, true);

    /* renamed from: f */
    public static final j0 f17910f = new j0("MARKET_SCHEME", 4, false) { // from class: com.sigmob.sdk.base.common.j0.e
        public e(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getAndroidMarket() == null) {
                return null;
            }
            return baseAdUnit.getAndroidMarket().market_url;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            AndroidMarket androidMarket = baseAdUnit.getAndroidMarket();
            if (androidMarket != null) {
                int intValue = ((Integer) Wire.get(androidMarket.type, 0)).intValue();
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(androidMarket.appstore_package_name)) {
                    try {
                        if (AppPackageUtil.getPackageManager(context).getPackageInfo(androidMarket.appstore_package_name, 0) != null) {
                            intent.setPackage(androidMarket.appstore_package_name);
                        }
                    } catch (Throwable th2) {
                        SigmobLog.e("get store package error " + th2.getMessage());
                    }
                }
                intent.setData(Uri.parse(androidMarket.market_url));
                if (intValue != 1) {
                    u.b(context, intent);
                    return;
                }
                new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.a.d(), baseAdUnit);
                Activity h10 = com.sigmob.sdk.a.h();
                if (h10 == null) {
                    h10 = com.sigmob.sdk.a.g();
                }
                if (h10 != null) {
                    h10.startActivity(intent);
                } else {
                    context.startActivity(intent);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    };

    /* renamed from: g */
    public static final j0 f17911g = new j0("DOWNLOAD_APK", 5, true) { // from class: com.sigmob.sdk.base.common.j0.f
        public f(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 2 || baseAdUnit.getInteractionType() == 3) {
                return;
            }
            throw new Exception("Could not handle download Scheme url: " + uri);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    };

    /* renamed from: h */
    public static final j0 f17912h = new j0("OPEN_WITH_BROWSER", 6, true) { // from class: com.sigmob.sdk.base.common.j0.g
        public g(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 8) {
                u.b(context, uri, com.sigmob.sdk.a.f());
            } else if (k0Var.d()) {
                u.b(context, new Intent("android.intent.action.VIEW", uri));
            } else {
                com.sigmob.sdk.base.common.h.a(baseAdUnit);
                BaseAdActivity.b(context, AdActivity.class, baseAdUnit.getUuid());
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    };

    /* renamed from: i */
    public static final j0 f17913i = new j0("NOOP", 7, false) { // from class: com.sigmob.sdk.base.common.j0.h
        public h(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) {
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            return false;
        }
    };

    /* renamed from: j */
    public static final /* synthetic */ j0[] f17914j = a();

    public enum a extends j0 {
        public a(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) {
            SigmobLog.d("Link to about page ignored.");
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }
    }

    public enum b extends j0 {
        public b(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getWXProgramRes() == null) {
                return null;
            }
            return baseAdUnit.getWXProgramRes().wx_app_path;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() != 7) {
                throw new Exception("performAction interaction_type is not right with " + baseAdUnit.getInteractionType());
            }
            WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
            if (wXProgramRes != null) {
                try {
                    Method method = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
                    method.setAccessible(true);
                    Object invoke = method.invoke(WXAPIFactory.class, context, wXProgramRes.wx_app_id);
                    Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
                    Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
                    declaredField.setAccessible(true);
                    declaredField.set(newInstance, wXProgramRes.wx_app_username);
                    Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField(t8.a.f30751f);
                    declaredField2.setAccessible(true);
                    declaredField2.set(newInstance, wXProgramRes.wx_app_path);
                    Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
                    declaredField3.setAccessible(true);
                    declaredField3.set(newInstance, 0);
                    Method method2 = invoke.getClass().getMethod("sendReq", newInstance.getClass().getSuperclass());
                    method2.setAccessible(true);
                    boolean booleanValue = ((Boolean) method2.invoke(invoke, newInstance)).booleanValue();
                    Log.d("lance", "openB:isSendReq " + booleanValue);
                    if (booleanValue) {
                        return;
                    }
                    throw new Exception("get mini_program error: " + uri.toString());
                } catch (Throwable th2) {
                    SigmobLog.e("get mini_program error " + th2.getMessage());
                    throw new Exception("get mini_program error: " + uri.toString());
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || i10 != 7) ? false : true;
        }
    }

    public enum c extends j0 {
        public c(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getDeeplinkUrl();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 8) {
                u.b(context, uri, com.sigmob.sdk.a.f());
            } else {
                u.a(context, uri);
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return i10 == 8 ? "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || "HAP".equalsIgnoreCase(scheme) : ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    }

    public enum d extends j0 {

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ BaseAdUnit f17916a;

            public a(BaseAdUnit baseAdUnit) {
                this.f17916a = baseAdUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.sigmob.sdk.base.common.h.m() != null) {
                    b0.a("open_pkg", "0", this.f17916a);
                    com.sigmob.sdk.base.common.h.f((BaseAdUnit) null);
                }
            }
        }

        public d(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            return i10 == 2;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return TextUtils.isEmpty(baseAdUnit.getApkPackageName()) ? baseAdUnit.getProductId() : baseAdUnit.getApkPackageName();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            PackageManager packageManager;
            String productId;
            if (baseAdUnit.getsubInteractionType() == 2 || !TextUtils.isEmpty(baseAdUnit.getApkPackageName())) {
                if (TextUtils.isEmpty(baseAdUnit.getApkPackageName())) {
                    packageManager = context.getPackageManager();
                    productId = baseAdUnit.getProductId();
                } else {
                    packageManager = context.getPackageManager();
                    productId = baseAdUnit.getApkPackageName();
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(productId);
                if (launchIntentForPackage != null) {
                    com.sigmob.sdk.base.common.h.f(baseAdUnit);
                    new Handler().postDelayed(new a(baseAdUnit), 3000L);
                    u.b(context, launchIntentForPackage);
                    return;
                }
            }
            throw new Exception("can't launch application for packageName" + baseAdUnit.getProductId());
        }
    }

    public enum e extends j0 {
        public e(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getAndroidMarket() == null) {
                return null;
            }
            return baseAdUnit.getAndroidMarket().market_url;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            AndroidMarket androidMarket = baseAdUnit.getAndroidMarket();
            if (androidMarket != null) {
                int intValue = ((Integer) Wire.get(androidMarket.type, 0)).intValue();
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(androidMarket.appstore_package_name)) {
                    try {
                        if (AppPackageUtil.getPackageManager(context).getPackageInfo(androidMarket.appstore_package_name, 0) != null) {
                            intent.setPackage(androidMarket.appstore_package_name);
                        }
                    } catch (Throwable th2) {
                        SigmobLog.e("get store package error " + th2.getMessage());
                    }
                }
                intent.setData(Uri.parse(androidMarket.market_url));
                if (intValue != 1) {
                    u.b(context, intent);
                    return;
                }
                new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.a.d(), baseAdUnit);
                Activity h10 = com.sigmob.sdk.a.h();
                if (h10 == null) {
                    h10 = com.sigmob.sdk.a.g();
                }
                if (h10 != null) {
                    h10.startActivity(intent);
                } else {
                    context.startActivity(intent);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    }

    public enum f extends j0 {
        public f(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 2 || baseAdUnit.getInteractionType() == 3) {
                return;
            }
            throw new Exception("Could not handle download Scheme url: " + uri);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    }

    public enum g extends j0 {
        public g(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception {
            if (baseAdUnit.getInteractionType() == 8) {
                u.b(context, uri, com.sigmob.sdk.a.f());
            } else if (k0Var.d()) {
                u.b(context, new Intent("android.intent.action.VIEW", uri));
            } else {
                com.sigmob.sdk.base.common.h.a(baseAdUnit);
                BaseAdActivity.b(context, AdActivity.class, baseAdUnit.getUuid());
            }
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    }

    public enum h extends j0 {
        public h(String str, int i10, boolean z10) {
            super(str, i10, z10, null);
        }

        @Override // com.sigmob.sdk.base.common.j0
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.j0
        public void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) {
        }

        @Override // com.sigmob.sdk.base.common.j0
        public boolean a(Uri uri, int i10) {
            return false;
        }
    }

    public j0(String str, int i10, boolean z10) {
        super(str, i10);
        this.f17915a = z10;
    }

    public static /* synthetic */ j0[] a() {
        return new j0[]{f17906b, f17907c, f17908d, f17909e, f17910f, f17911g, f17912h, f17913i};
    }

    public static j0 valueOf(String str) {
        return (j0) Enum.valueOf(j0.class, str);
    }

    public static j0[] values() {
        return (j0[]) f17914j.clone();
    }

    public abstract String a(BaseAdUnit baseAdUnit);

    public abstract void a(Context context, Uri uri, k0 k0Var, BaseAdUnit baseAdUnit) throws Exception;

    public abstract boolean a(Uri uri, int i10);

    public /* synthetic */ j0(String str, int i10, boolean z10, a aVar) {
        this(str, i10, z10);
    }

    public void a(k0 k0Var, Context context, Uri uri, boolean z10, BaseAdUnit baseAdUnit) throws Exception {
        SigmobLog.d("Ad event URL: " + uri);
        if (this.f17915a && !z10) {
            throw new Exception("Attempted to handle action without user interaction.");
        }
        a(context, uri, k0Var, baseAdUnit);
    }
}
