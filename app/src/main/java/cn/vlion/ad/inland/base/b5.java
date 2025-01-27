package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b5 {

    /* renamed from: c */
    public z4 f2671c;

    /* renamed from: a */
    public int f2669a = 1;

    /* renamed from: b */
    public String f2670b = "";

    /* renamed from: d */
    public boolean f2672d = false;

    public final synchronized void a(String str, z4 z4Var) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f2672d = false;
            this.f2671c = z4Var;
            int i10 = this.f2669a;
            if (i10 != 1) {
                if (i10 == 2) {
                    z4Var.a(0);
                    str2 = "VlionDownloadVideoContextState 已存在 正在下载。。。。：";
                } else if (i10 == 3) {
                    z4Var.a(this.f2670b);
                    str2 = "VlionDownloadVideoContextState 已存在  下载已完成 下载路径 ：" + this.f2670b;
                }
                LogVlion.e(str2);
            } else {
                LogVlion.e("VlionDownloadVideoContextState Initial 下载= ");
                this.f2669a = 2;
                synchronized (this) {
                    try {
                        HttpRequestUtil.downloadVideo(str, new a5(this, str));
                    } finally {
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            this.f2669a = 1;
        }
    }
}
