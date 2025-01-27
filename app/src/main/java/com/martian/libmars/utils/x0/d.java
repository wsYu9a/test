package com.martian.libmars.utils.x0;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/* loaded from: classes2.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final b f10288a;

    static class a extends C0258d {

        /* renamed from: a, reason: collision with root package name */
        private final b f10289a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        a() {
            /*
                r2 = this;
                r0 = 0
                r2.<init>(r0)
                com.martian.libmars.utils.x0.d$c r1 = new com.martian.libmars.utils.x0.d$c
                r1.<init>(r0)
                r2.f10289a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.utils.x0.d.a.<init>():void");
        }

        @Override // com.martian.libmars.utils.x0.d.C0258d, com.martian.libmars.utils.x0.d.b
        public void a(Window window, boolean lightStatusBar) {
            super.a(window, lightStatusBar);
            this.f10289a.a(window, lightStatusBar);
        }
    }

    interface b {
        void a(Window window, boolean lightStatusBar);
    }

    private static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private static final String f10290a = "ro.miui.ui.version.code";

        /* renamed from: b, reason: collision with root package name */
        private static final String f10291b = "ro.miui.ui.version.name";

        /* renamed from: c, reason: collision with root package name */
        private static final String f10292c = "ro.miui.internal.storage";

        private c() {
        }

        static boolean b() {
            boolean z;
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    if (properties.getProperty(f10290a) == null && properties.getProperty(f10291b) == null) {
                        if (properties.getProperty(f10292c) == null) {
                            z = false;
                            fileInputStream.close();
                            return z;
                        }
                    }
                    z = true;
                    fileInputStream.close();
                    return z;
                } finally {
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.martian.libmars.utils.x0.d.b
        public void a(Window window, boolean lightStatusBar) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(lightStatusBar ? i2 : 0);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: com.martian.libmars.utils.x0.d$d, reason: collision with other inner class name */
    private static class C0258d implements b {
        private C0258d() {
        }

        @Override // com.martian.libmars.utils.x0.d.b
        @TargetApi(11)
        public void a(Window window, boolean lightStatusBar) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(lightStatusBar ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }

        /* synthetic */ C0258d(a aVar) {
            this();
        }
    }

    private static class e implements b {
        private e() {
        }

        static boolean b() {
            return Build.DISPLAY.startsWith("Flyme");
        }

        @Override // com.martian.libmars.utils.x0.d.b
        public void a(Window window, boolean lightStatusBar) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, lightStatusBar ? i3 | i2 : (i2 ^ (-1)) & i3);
                window.setAttributes(attributes);
                declaredField.setAccessible(false);
                declaredField2.setAccessible(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        if (c.b()) {
            if (Build.VERSION.SDK_INT >= 23) {
                f10288a = new a();
                return;
            } else {
                f10288a = new c(aVar);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f10288a = new C0258d(aVar);
        } else if (e.b()) {
            f10288a = new e(aVar);
        } else {
            f10288a = new b() { // from class: com.martian.libmars.utils.x0.a
                @Override // com.martian.libmars.utils.x0.d.b
                public final void a(Window window, boolean z) {
                    d.a(window, z);
                }
            };
        }
    }

    d() {
    }

    static /* synthetic */ void a(Window window, boolean lightStatusBar) {
    }

    static void b(Window window, boolean lightStatusBar) {
        f10288a.a(window, lightStatusBar);
    }
}
