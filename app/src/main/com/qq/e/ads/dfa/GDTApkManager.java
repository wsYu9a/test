package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class GDTApkManager {

    /* renamed from: a */
    private DFA f16417a;

    /* renamed from: b */
    private boolean f16418b = false;

    /* renamed from: c */
    private boolean f16419c = false;

    /* renamed from: d */
    private AtomicInteger f16420d = new AtomicInteger(0);

    /* renamed from: e */
    private Context f16421e;

    /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ IGDTApkListener f16422a;

        /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1$1 */
        public class RunnableC05471 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ POFactory f16424a;

            public RunnableC05471(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (pOFactory != null) {
                        GDTApkManager.this.f16417a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                        GDTApkManager.this.f16419c = true;
                        while (GDTApkManager.this.f16420d.getAndDecrement() > 0) {
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

        public AnonymousClass1(IGDTApkListener iGDTApkListener) {
            iGDTApkListener = iGDTApkListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1

                    /* renamed from: a */
                    final /* synthetic */ POFactory f16424a;

                    public RunnableC05471(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (pOFactory != null) {
                                GDTApkManager.this.f16417a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                GDTApkManager.this.f16419c = true;
                                while (GDTApkManager.this.f16420d.getAndDecrement() > 0) {
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
            } catch (Throwable th2) {
                GDTLogger.e("初始化错误：初始化时发生异常", th2);
            }
        }
    }

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (a.b().d()) {
            a(context, a.b().a(), iGDTApkListener);
        }
    }

    public final void loadGDTApk() {
        if (this.f16418b) {
            if (!this.f16419c) {
                this.f16420d.incrementAndGet();
                return;
            }
            DFA dfa = this.f16417a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f16417a;
        if (dfa != null) {
            dfa.startInstall(this.f16421e, gDTApk);
        }
    }

    private void a(Context context, String str, IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!com.qq.e.comm.a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.f16418b = true;
            this.f16421e = context;
            a.f16557g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1

                /* renamed from: a */
                final /* synthetic */ IGDTApkListener f16422a;

                /* renamed from: com.qq.e.ads.dfa.GDTApkManager$1$1 */
                public class RunnableC05471 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ POFactory f16424a;

                    public RunnableC05471(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (pOFactory != null) {
                                GDTApkManager.this.f16417a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                GDTApkManager.this.f16419c = true;
                                while (GDTApkManager.this.f16420d.getAndDecrement() > 0) {
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

                public AnonymousClass1(IGDTApkListener iGDTApkListener2) {
                    iGDTApkListener = iGDTApkListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1

                            /* renamed from: a */
                            final /* synthetic */ POFactory f16424a;

                            public RunnableC05471(POFactory pOFactory) {
                                pOFactory = pOFactory;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f16417a = a.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f16419c = true;
                                        while (GDTApkManager.this.f16420d.getAndDecrement() > 0) {
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
                    } catch (Throwable th2) {
                        GDTLogger.e("初始化错误：初始化时发生异常", th2);
                    }
                }
            });
        }
    }
}
