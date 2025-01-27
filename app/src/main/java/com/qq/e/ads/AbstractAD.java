package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public abstract class AbstractAD<T> {

    /* renamed from: a */
    protected T f23859a;

    /* renamed from: e */
    private volatile boolean f23863e;

    /* renamed from: c */
    private volatile boolean f23861c = false;

    /* renamed from: d */
    private volatile boolean f23862d = false;

    /* renamed from: b */
    private final Handler f23860b = new Handler(Looper.getMainLooper());

    /* renamed from: com.qq.e.ads.AbstractAD$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f23864a;

        /* renamed from: b */
        final /* synthetic */ String f23865b;

        /* renamed from: c */
        final /* synthetic */ String f23866c;

        /* renamed from: d */
        final /* synthetic */ String f23867d;

        /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
        class RunnableC04901 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ POFactory f23869a;

            RunnableC04901(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    POFactory pOFactory = pOFactory;
                    if (pOFactory != null) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AbstractAD abstractAD = AbstractAD.this;
                        abstractAD.f23859a = (T) abstractAD.a(context, pOFactory, a2, str, str2);
                        AbstractAD.this.f23861c = true;
                        AbstractAD abstractAD2 = AbstractAD.this;
                        T t = abstractAD2.f23859a;
                        if (t == null) {
                            abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                        } else {
                            abstractAD2.a((AbstractAD) t);
                        }
                    } else {
                        AbstractAD.this.f23861c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                } catch (Throwable th) {
                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                    AbstractAD.this.f23861c = true;
                    AbstractAD.this.a(2001);
                }
            }
        }

        AnonymousClass1(Context context, String str, String str2, String str3) {
            context = context;
            a2 = str;
            str = str2;
            str2 = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractAD.this.f23860b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                    /* renamed from: a */
                    final /* synthetic */ POFactory f23869a;

                    RunnableC04901(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            POFactory pOFactory = pOFactory;
                            if (pOFactory != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AbstractAD abstractAD = AbstractAD.this;
                                abstractAD.f23859a = (T) abstractAD.a(context, pOFactory, a2, str, str2);
                                AbstractAD.this.f23861c = true;
                                AbstractAD abstractAD2 = AbstractAD.this;
                                T t = abstractAD2.f23859a;
                                if (t == null) {
                                    abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                } else {
                                    abstractAD2.a((AbstractAD) t);
                                }
                            } else {
                                AbstractAD.this.f23861c = true;
                                AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                            }
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                            AbstractAD.this.f23861c = true;
                            AbstractAD.this.a(2001);
                        }
                    }
                });
            } catch (Throwable th) {
                GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                AbstractAD.this.f23861c = true;
                AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
            }
        }
    }

    /* renamed from: com.qq.e.ads.AbstractAD$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23871a;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractAD.this.b(i2);
        }
    }

    private void b(Context context, String str, String str2) {
        this.f23863e = true;
        if (!b.b().d()) {
            a(2003);
            return;
        }
        String a2 = b.b().a();
        if (a.a(context)) {
            this.f23862d = true;
            b.f24009g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1

                /* renamed from: a */
                final /* synthetic */ Context f23864a;

                /* renamed from: b */
                final /* synthetic */ String f23865b;

                /* renamed from: c */
                final /* synthetic */ String f23866c;

                /* renamed from: d */
                final /* synthetic */ String f23867d;

                /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
                class RunnableC04901 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ POFactory f23869a;

                    RunnableC04901(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            POFactory pOFactory = pOFactory;
                            if (pOFactory != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AbstractAD abstractAD = AbstractAD.this;
                                abstractAD.f23859a = (T) abstractAD.a(context, pOFactory, a2, str, str2);
                                AbstractAD.this.f23861c = true;
                                AbstractAD abstractAD2 = AbstractAD.this;
                                T t = abstractAD2.f23859a;
                                if (t == null) {
                                    abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                } else {
                                    abstractAD2.a((AbstractAD) t);
                                }
                            } else {
                                AbstractAD.this.f23861c = true;
                                AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                            }
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                            AbstractAD.this.f23861c = true;
                            AbstractAD.this.a(2001);
                        }
                    }
                }

                AnonymousClass1(Context context2, String a22, String str3, String str22) {
                    context = context2;
                    a2 = a22;
                    str = str3;
                    str2 = str22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AbstractAD.this.f23860b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                            /* renamed from: a */
                            final /* synthetic */ POFactory f23869a;

                            RunnableC04901(POFactory pOFactory) {
                                pOFactory = pOFactory;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory = pOFactory;
                                    if (pOFactory != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD abstractAD = AbstractAD.this;
                                        abstractAD.f23859a = (T) abstractAD.a(context, pOFactory, a2, str, str2);
                                        AbstractAD.this.f23861c = true;
                                        AbstractAD abstractAD2 = AbstractAD.this;
                                        T t = abstractAD2.f23859a;
                                        if (t == null) {
                                            abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        } else {
                                            abstractAD2.a((AbstractAD) t);
                                        }
                                    } else {
                                        AbstractAD.this.f23861c = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f23861c = true;
                                    AbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f23861c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i2);
        } else {
            this.f23860b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2

                /* renamed from: a */
                final /* synthetic */ int f23871a;

                AnonymousClass2(int i22) {
                    i2 = i22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i2);
                }
            });
        }
    }

    protected final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    protected final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    protected abstract void a(T t);

    protected final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    protected final boolean a() {
        return this.f23863e && this.f23862d;
    }

    protected abstract void b(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f23861c;
    }
}
