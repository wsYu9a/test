package com.opos.mobad.cmn.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: com.opos.mobad.cmn.a.b.g$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20277a;

        static {
            int[] iArr = new int[a.values().length];
            f20277a = iArr;
            try {
                iArr[a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20277a[a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20277a[a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20277a[a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20277a[a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20277a[a.Pendant.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static int a() {
        return View.generateViewId();
    }

    public static Bitmap a(int i2, Bitmap bitmap) {
        if (bitmap == null || i2 <= 0) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() * i2, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        for (int i3 = 0; i3 < i2; i3++) {
            canvas.drawBitmap(bitmap, bitmap.getWidth() * i3, 0.0f, (Paint) null);
        }
        return createBitmap;
    }

    public static Bitmap a(String str) {
        if (!com.opos.cmn.an.c.a.a(str)) {
            try {
                return BitmapFactory.decodeFile(str);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", th);
            }
        }
        return null;
    }

    public static Bitmap a(String str, int i2, int i3) {
        if (!com.opos.cmn.an.c.a.a(str)) {
            try {
                return com.opos.cmn.an.d.c.a.a(str, i2, i3);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", th);
            }
        }
        return null;
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return (Build.VERSION.SDK_INT < 15 || context == null) ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    public static Drawable a(Context context, String str) {
        Bitmap a2 = a(str);
        if (a2 != null) {
            return a(context, a2);
        }
        return null;
    }

    public static Drawable a(Context context, String str, int i2, int i3) {
        Bitmap a2 = a(str, i2, i3);
        if (a2 != null) {
            return a(context, a2);
        }
        return null;
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(637534208);
        gradientDrawable.setCornerRadius(9.0f);
        return new LayerDrawable(new Drawable[]{gradientDrawable, drawable});
    }

    public static String a(Context context, AdItemData adItemData, boolean z) {
        MaterialData materialData;
        String str = "立刻打开";
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
            if (!z) {
                if (TextUtils.isEmpty(materialData.Y())) {
                    switch (materialData.e()) {
                        case 1:
                            str = "点击查看";
                            break;
                        case 2:
                            if (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) {
                                str = "点击安装";
                                break;
                            }
                            break;
                        case 3:
                            if (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) {
                                str = "立即下载";
                                break;
                            }
                            break;
                        case 5:
                            str = "查看详情";
                            break;
                        case 6:
                            str = "秒开";
                            break;
                        case 7:
                            str = "打开";
                            break;
                    }
                } else {
                    str = materialData.Y();
                }
            }
            com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText=" + str);
            return str;
        }
        str = "";
        com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText=" + str);
        return str;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(TTAdConstant.EXT_PLUGIN_UNINSTALL);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor(str));
                }
                a(activity, true);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("ViewUtils", "setWhiteStatusBar", (Throwable) e2);
            }
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if (Build.VERSION.SDK_INT >= 23) {
                    systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", (Throwable) e2);
            }
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r3.ab().b() != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r3.W() != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r3.V() != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        if (r3.K() != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r3.e() != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r3.J() != 0) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.opos.mobad.model.data.AdItemData r3, com.opos.mobad.cmn.a.b.a r4) {
        /*
            r0 = 0
            r1 = 1
            if (r3 == 0) goto L50
            java.util.List r3 = r3.i()
            java.lang.Object r3 = r3.get(r0)
            com.opos.mobad.model.data.MaterialData r3 = (com.opos.mobad.model.data.MaterialData) r3
            if (r3 == 0) goto L50
            int[] r2 = com.opos.mobad.cmn.a.b.g.AnonymousClass1.f20277a
            int r4 = r4.ordinal()
            r4 = r2[r4]
            switch(r4) {
                case 1: goto L49;
                case 2: goto L42;
                case 3: goto L3b;
                case 4: goto L34;
                case 5: goto L2d;
                case 6: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L50
        L1c:
            com.opos.mobad.model.data.PendantData r4 = r3.ab()
            if (r4 == 0) goto L50
            com.opos.mobad.model.data.PendantData r3 = r3.ab()
            int r3 = r3.b()
            if (r3 == 0) goto L50
            goto L4f
        L2d:
            int r3 = r3.W()
            if (r3 == 0) goto L50
            goto L4f
        L34:
            int r3 = r3.V()
            if (r3 == 0) goto L50
            goto L4f
        L3b:
            int r3 = r3.K()
            if (r3 == 0) goto L50
            goto L4f
        L42:
            int r3 = r3.e()
            if (r3 == 0) goto L50
            goto L4f
        L49:
            int r3 = r3.J()
            if (r3 == 0) goto L50
        L4f:
            r0 = 1
        L50:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isValidClickWithInteraction result ="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "ViewUtils"
            com.opos.cmn.an.f.a.b(r4, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.g.a(com.opos.mobad.model.data.AdItemData, com.opos.mobad.cmn.a.b.a):boolean");
    }

    public static Drawable b(Context context, String str) {
        Drawable a2 = a(context, str);
        return a2 != null ? a(a2) : a2;
    }
}
