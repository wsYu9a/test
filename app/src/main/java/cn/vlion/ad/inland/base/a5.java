package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.j7;
import cn.vlion.ad.inland.base.network.VideoCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.File;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public final class a5 implements VideoCallback {

    /* renamed from: a */
    public final /* synthetic */ String f2612a;

    /* renamed from: b */
    public final /* synthetic */ b5 f2613b;

    public a5(b5 b5Var, String str) {
        this.f2613b = b5Var;
        this.f2612a = str;
    }

    @Override // cn.vlion.ad.inland.base.network.VideoCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            z4 z4Var = this.f2613b.f2671c;
            if (z4Var != null) {
                z4Var.a(vlionAdBaseError);
            }
            LogVlion.e("VlionDownloadVideoContextState 初始化  下载已失败 ：" + this.f2612a);
            this.f2613b.f2669a = 1;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.VideoCallback
    public final void onSuccess(ResponseBody responseBody) {
        String str = "";
        LogVlion.e("VlionDownloadVideoContextState downVideo end= ");
        if (this.f2613b.f2672d) {
            return;
        }
        try {
            String concat = String.valueOf(System.currentTimeMillis()).concat(new Random().nextInt(10000) + "");
            b5 b5Var = this.f2613b;
            StringBuilder sb2 = new StringBuilder();
            try {
                str = t.d(VlionSDkManager.getInstance().getApplication()) + "reward" + File.separator;
                File file = new File(str);
                if (!file.exists()) {
                    LogVlion.e("getDownRewardVideoPath mkdirs is" + file.mkdirs());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            sb2.append(str);
            sb2.append(concat.concat(".mp4"));
            b5Var.f2670b = sb2.toString();
            String str2 = this.f2613b.f2670b;
            j7.b bVar = new j7.b(new a());
            try {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                j7.f2999a = newSingleThreadExecutor;
                newSingleThreadExecutor.execute(new i7(str2, responseBody, bVar));
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
            this.f2613b.f2669a = 1;
        }
    }

    public class a implements j7.a {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.j7.a
        public final void a(VlionAdBaseError vlionAdBaseError) {
            z4 z4Var = a5.this.f2613b.f2671c;
            if (z4Var != null) {
                z4Var.a(vlionAdBaseError);
            }
            a5.this.f2613b.f2669a = 1;
            StringBuilder a10 = l1.a("VlionDownloadVideoContextState 初始化  下载已失败 ：");
            a10.append(a5.this.f2612a);
            LogVlion.e(a10.toString());
        }

        @Override // cn.vlion.ad.inland.base.j7.a
        public final void b() {
            z4 z4Var = a5.this.f2613b.f2671c;
            if (z4Var != null) {
                z4Var.a(1);
            }
            LogVlion.e("VlionDownloadVideoContextState 初始化 正在下载 ....：");
        }

        @Override // cn.vlion.ad.inland.base.j7.a
        public final void a() {
            b5 b5Var = a5.this.f2613b;
            b5Var.f2669a = 3;
            z4 z4Var = b5Var.f2671c;
            if (z4Var != null) {
                z4Var.a(b5Var.f2670b);
            }
            StringBuilder a10 = l1.a("VlionDownloadVideoContextState 初始化  下载已完成 下载路径 ：");
            a10.append(a5.this.f2613b.f2670b);
            LogVlion.e(a10.toString());
        }
    }
}
