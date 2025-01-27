package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.video.VlionBaseVideoView;
import cn.vlion.ad.inland.base.j7;
import cn.vlion.ad.inland.base.network.VideoCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public final class e7 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f2767a;

    /* renamed from: b */
    public final /* synthetic */ String f2768b;

    /* renamed from: c */
    public final /* synthetic */ d7 f2769c;

    public class a implements VideoCallback {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.network.VideoCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
            try {
                g0 g0Var = e7.this.f2769c.f2712a;
                if (g0Var == null || vlionAdBaseError == null) {
                    return;
                }
                g0Var.a(new i1(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.network.VideoCallback
        public final void onSuccess(ResponseBody responseBody) {
            try {
                String str = e7.this.f2768b;
                j7.b bVar = new j7.b(new C0025a());
                try {
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    j7.f2999a = newSingleThreadExecutor;
                    newSingleThreadExecutor.execute(new i7(str, responseBody, bVar));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }

        /* renamed from: cn.vlion.ad.inland.base.e7$a$a */
        public class C0025a implements j7.a {
            public C0025a() {
            }

            @Override // cn.vlion.ad.inland.base.j7.a
            public final void a(VlionAdBaseError vlionAdBaseError) {
                try {
                    g0 g0Var = e7.this.f2769c.f2712a;
                    if (g0Var != null) {
                        g0Var.a(new i1(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.j7.a
            public final void b() {
            }

            @Override // cn.vlion.ad.inland.base.j7.a
            public final void a() {
                String str;
                try {
                    e7 e7Var = e7.this;
                    d7 d7Var = e7Var.f2769c;
                    VlionBaseVideoView vlionBaseVideoView = d7Var.f2715d;
                    if (vlionBaseVideoView != null && d7Var.f2717f != null && (str = e7Var.f2768b) != null) {
                        vlionBaseVideoView.setDataSource(str);
                    }
                    d7 d7Var2 = e7.this.f2769c;
                    g0 g0Var = d7Var2.f2712a;
                    if (g0Var != null) {
                        g0Var.onAdRenderSuccess(d7Var2.f2715d);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public e7(d7 d7Var, String str, String str2) {
        this.f2769c = d7Var;
        this.f2767a = str;
        this.f2768b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            HttpRequestUtil.downloadVideo(this.f2767a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
