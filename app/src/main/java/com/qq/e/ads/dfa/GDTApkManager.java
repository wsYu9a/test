package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class GDTApkManager {

    /* renamed from: a */
    private DFA f23906a;

    /* renamed from: b */
    private boolean f23907b = false;

    /* renamed from: c */
    private boolean f23908c = false;

    /* renamed from: d */
    private AtomicInteger f23909d = new AtomicInteger(0);

    /* renamed from: e */
    private Context f23910e;

    /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ IGDTApkListener f23911a;

        /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1$1 */
        class RunnableC04911 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ POFactory f23913a;

            RunnableC04911(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (pOFactory != null) {
                        GDTApkManager.this.f23906a = b.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                        GDTApkManager.this.f23908c = true;
                        while (GDTApkManager.this.f23909d.getAndDecrement() > 0) {
                            GDTApkManager.this.loadGDTApk();
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        AnonymousClass1(IGDTApkListener iGDTApkListener) {
            iGDTApkListener = iGDTApkListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1

                    /* renamed from: a */
                    final /* synthetic */ POFactory f23913a;

                    RunnableC04911(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (pOFactory != null) {
                                GDTApkManager.this.f23906a = b.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                GDTApkManager.this.f23908c = true;
                                while (GDTApkManager.this.f23909d.getAndDecrement() > 0) {
                                    GDTApkManager.this.loadGDTApk();
                                }
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                GDTLogger.e("初始化错误：初始化时发生异常", th);
            }
        }
    }

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (b.b().d()) {
            a(context, b.b().a(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.f23907b = true;
            this.f23910e = context;
            b.f24009g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1

                /* renamed from: a */
                final /* synthetic */ IGDTApkListener f23911a;

                /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1$1 */
                class RunnableC04911 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ POFactory f23913a;

                    RunnableC04911(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (pOFactory != null) {
                                GDTApkManager.this.f23906a = b.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                GDTApkManager.this.f23908c = true;
                                while (GDTApkManager.this.f23909d.getAndDecrement() > 0) {
                                    GDTApkManager.this.loadGDTApk();
                                }
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                }

                AnonymousClass1(IGDTApkListener iGDTApkListener2) {
                    iGDTApkListener = iGDTApkListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1

                            /* renamed from: a */
                            final /* synthetic */ POFactory f23913a;

                            RunnableC04911(POFactory pOFactory) {
                                pOFactory = pOFactory;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f23906a = b.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f23908c = true;
                                        while (GDTApkManager.this.f23909d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化时发生异常", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (this.f23907b) {
            if (!this.f23908c) {
                this.f23909d.incrementAndGet();
                return;
            }
            DFA dfa = this.f23906a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f23906a;
        if (dfa != null) {
            dfa.startInstall(this.f23910e, gDTApk);
        }
    }
}
