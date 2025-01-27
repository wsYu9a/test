package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class AbstractAD<T> {

    /* renamed from: g */
    private static final AtomicBoolean f16366g = new AtomicBoolean(true);

    /* renamed from: a */
    protected T f16367a;

    /* renamed from: e */
    private volatile boolean f16371e;

    /* renamed from: c */
    private volatile boolean f16369c = false;

    /* renamed from: d */
    private volatile boolean f16370d = false;

    /* renamed from: f */
    private volatile long f16372f = -1;

    /* renamed from: b */
    private final Handler f16368b = new Handler(Looper.getMainLooper());

    /* renamed from: com.qq.e.ads.AbstractAD$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16373a;

        /* renamed from: b */
        final /* synthetic */ String f16374b;

        /* renamed from: c */
        final /* synthetic */ String f16375c;

        /* renamed from: d */
        final /* synthetic */ String f16376d;

        /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
        public class RunnableC05461 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ POFactory f16378a;

            public RunnableC05461(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    POFactory pOFactory = pOFactory;
                    if (pOFactory != null) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AbstractAD abstractAD = AbstractAD.this;
                        abstractAD.f16367a = (T) abstractAD.a(context, pOFactory, a10, str, str2);
                        AbstractAD.this.f16369c = true;
                        AbstractAD abstractAD2 = AbstractAD.this;
                        if (abstractAD2.f16367a == null) {
                            abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                        } else {
                            AbstractAD.a(abstractAD2);
                            AbstractAD abstractAD3 = AbstractAD.this;
                            abstractAD3.a((AbstractAD) abstractAD3.f16367a);
                        }
                    } else {
                        AbstractAD.this.f16369c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                } catch (Throwable th2) {
                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th2);
                    AbstractAD.this.f16369c = true;
                    AbstractAD.this.a(2001);
                }
            }
        }

        public AnonymousClass1(Context context, String str, String str2, String str3) {
            context = context;
            a10 = str;
            str = str2;
            str2 = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractAD.this.f16368b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                    /* renamed from: a */
                    final /* synthetic */ POFactory f16378a;

                    public RunnableC05461(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            POFactory pOFactory = pOFactory;
                            if (pOFactory != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AbstractAD abstractAD = AbstractAD.this;
                                abstractAD.f16367a = (T) abstractAD.a(context, pOFactory, a10, str, str2);
                                AbstractAD.this.f16369c = true;
                                AbstractAD abstractAD2 = AbstractAD.this;
                                if (abstractAD2.f16367a == null) {
                                    abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                } else {
                                    AbstractAD.a(abstractAD2);
                                    AbstractAD abstractAD3 = AbstractAD.this;
                                    abstractAD3.a((AbstractAD) abstractAD3.f16367a);
                                }
                            } else {
                                AbstractAD.this.f16369c = true;
                                AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                            }
                        } catch (Throwable th2) {
                            GDTLogger.e("初始化错误：初始化广告实例时发生异常", th2);
                            AbstractAD.this.f16369c = true;
                            AbstractAD.this.a(2001);
                        }
                    }
                });
            } catch (Throwable th2) {
                GDTLogger.e("初始化错误：初始化插件时发生异常", th2);
                AbstractAD.this.f16369c = true;
                AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
            }
        }
    }

    /* renamed from: com.qq.e.ads.AbstractAD$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f16380a;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractAD.this.b(i10);
        }
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(int i10) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i10);
        } else {
            this.f16368b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2

                /* renamed from: a */
                final /* synthetic */ int f16380a;

                public AnonymousClass2(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i10);
                }
            });
        }
    }

    public abstract void a(T t10);

    public abstract void b(int i10);

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public final boolean b() {
        if (!this.f16369c && f16366g.compareAndSet(true, false)) {
            this.f16372f = SystemClock.elapsedRealtime();
        }
        return this.f16369c;
    }

    private void b(Context context, String str, String str2) {
        this.f16371e = true;
        if (a.b().d()) {
            String a10 = a.b().a();
            if (com.qq.e.comm.a.a(context)) {
                this.f16370d = true;
                a.f16557g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1

                    /* renamed from: a */
                    final /* synthetic */ Context f16373a;

                    /* renamed from: b */
                    final /* synthetic */ String f16374b;

                    /* renamed from: c */
                    final /* synthetic */ String f16375c;

                    /* renamed from: d */
                    final /* synthetic */ String f16376d;

                    /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
                    public class RunnableC05461 implements Runnable {

                        /* renamed from: a */
                        final /* synthetic */ POFactory f16378a;

                        public RunnableC05461(POFactory pOFactory) {
                            pOFactory = pOFactory;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                POFactory pOFactory = pOFactory;
                                if (pOFactory != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AbstractAD abstractAD = AbstractAD.this;
                                    abstractAD.f16367a = (T) abstractAD.a(context, pOFactory, a10, str, str2);
                                    AbstractAD.this.f16369c = true;
                                    AbstractAD abstractAD2 = AbstractAD.this;
                                    if (abstractAD2.f16367a == null) {
                                        abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                    } else {
                                        AbstractAD.a(abstractAD2);
                                        AbstractAD abstractAD3 = AbstractAD.this;
                                        abstractAD3.a((AbstractAD) abstractAD3.f16367a);
                                    }
                                } else {
                                    AbstractAD.this.f16369c = true;
                                    AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                }
                            } catch (Throwable th2) {
                                GDTLogger.e("初始化错误：初始化广告实例时发生异常", th2);
                                AbstractAD.this.f16369c = true;
                                AbstractAD.this.a(2001);
                            }
                        }
                    }

                    public AnonymousClass1(Context context2, String a102, String str3, String str22) {
                        context = context2;
                        a10 = a102;
                        str = str3;
                        str2 = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AbstractAD.this.f16368b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                                /* renamed from: a */
                                final /* synthetic */ POFactory f16378a;

                                public RunnableC05461(POFactory pOFactory) {
                                    pOFactory = pOFactory;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory = pOFactory;
                                        if (pOFactory != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.f16367a = (T) abstractAD.a(context, pOFactory, a10, str, str2);
                                            AbstractAD.this.f16369c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            if (abstractAD2.f16367a == null) {
                                                abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                AbstractAD.a(abstractAD2);
                                                AbstractAD abstractAD3 = AbstractAD.this;
                                                abstractAD3.a((AbstractAD) abstractAD3.f16367a);
                                            }
                                        } else {
                                            AbstractAD.this.f16369c = true;
                                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th2) {
                                        GDTLogger.e("初始化错误：初始化广告实例时发生异常", th2);
                                        AbstractAD.this.f16369c = true;
                                        AbstractAD.this.a(2001);
                                    }
                                }
                            });
                        } catch (Throwable th2) {
                            GDTLogger.e("初始化错误：初始化插件时发生异常", th2);
                            AbstractAD.this.f16369c = true;
                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            } else {
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                a(4002);
                return;
            }
        }
        a(2003);
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.f16371e && this.f16370d;
    }

    public static void a(AbstractAD abstractAD) {
        if (abstractAD.f16372f > 0) {
            try {
                GlobalSetting.getSettings().putOpt("gdtwict", Long.valueOf(SystemClock.elapsedRealtime() - abstractAD.f16372f));
            } catch (Throwable unused) {
            }
        }
    }
}
