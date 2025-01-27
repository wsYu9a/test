package com.vivo.mobilead.e.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.vivo.mobilead.e.c.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: g */
    private static volatile a f28798g;

    /* renamed from: a */
    private Context f28799a;

    /* renamed from: b */
    private String f28800b;

    /* renamed from: c */
    private String f28801c;

    /* renamed from: e */
    private boolean f28803e;

    /* renamed from: d */
    private int f28802d = -1;

    /* renamed from: f */
    private com.vivo.mobilead.e.a.b f28804f = new b();

    /* renamed from: com.vivo.mobilead.e.b.a$a */
    class C0590a implements InvocationHandler {
        C0590a() {
        }

        private void a(Object obj) {
            if (obj instanceof IdSupplier) {
                IdSupplier idSupplier = (IdSupplier) obj;
                try {
                    a.this.f28800b = idSupplier.getOAID();
                    a.this.f28801c = idSupplier.getVAID();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (objArr == null) {
                return null;
            }
            if (objArr.length == 1) {
                a(objArr[0]);
                return null;
            }
            if (objArr.length != 2) {
                return null;
            }
            a(objArr[1]);
            return null;
        }
    }

    private a() {
    }

    public static a d() {
        if (f28798g == null) {
            synchronized (a.class) {
                if (f28798g == null) {
                    f28798g = new a();
                }
            }
        }
        return f28798g;
    }

    private void e() {
        e.d(this.f28799a);
        this.f28800b = e.a(this.f28799a);
        this.f28801c = e.c(this.f28799a);
        this.f28802d = c(this.f28799a);
    }

    private static boolean f() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public String c() {
        return this.f28801c;
    }

    class b implements com.vivo.mobilead.e.a.b {
        b() {
        }

        @Override // com.vivo.mobilead.e.a.b
        public void a(String str) {
            a.this.f28803e = true;
            a.this.f28800b = str;
        }

        @Override // com.vivo.mobilead.e.a.b
        public void a(Exception exc) {
            a.this.f28803e = false;
        }
    }

    private int c(Context context) {
        String b2;
        try {
            b2 = e.b(context);
        } catch (Exception unused) {
        }
        if ("1".equals(b2)) {
            return 1;
        }
        return "0".equals(b2) ? 0 : 2;
    }

    public void b(Context context) {
        try {
            if (f()) {
                e();
                return;
            }
            try {
                Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
                Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                MdidSdkHelper.InitSdk(context, true, (IIdentifierListener) Proxy.newProxyInstance(IIdentifierListener.class.getClassLoader(), new Class[]{IIdentifierListener.class}, new C0590a()));
            } catch (Throwable unused) {
                j.a.b.c("IdUtil", "MSA库没有引入");
            }
            com.vivo.mobilead.e.a.a.a(context, this.f28804f);
        } catch (Exception unused2) {
        }
    }

    public void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        this.f28799a = context;
    }

    public String a() {
        return this.f28800b;
    }

    public int b() {
        return this.f28802d;
    }
}
