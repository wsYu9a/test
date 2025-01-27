package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: h */
    private HybridADListener f16426h;

    /* renamed from: i */
    private CountDownLatch f16427i = new CountDownLatch(1);

    /* renamed from: j */
    private HybridADSetting f16428j;

    /* renamed from: com.qq.e.ads.hybrid.HybridAD$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16429a;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HybridAD.this.f16427i.await(30L, TimeUnit.SECONDS);
                if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).f16367a == null) {
                    GDTLogger.e("初始化错误：广告实例未被初始化");
                    HybridAD.this.a(2001);
                } else {
                    ((HADI) ((AbstractAD) HybridAD.this).f16367a).loadUrl(str);
                }
            } catch (InterruptedException unused) {
                GDTLogger.e("初始化错误：广告实例未被初始化");
                HybridAD.this.a(2001);
            }
        }
    }

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f16428j = hybridADSetting;
        this.f16426h = hybridADListener;
        a(context, "NO_POS_ID");
    }

    public HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f16428j, this.f16426h);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        HybridADListener hybridADListener = this.f16426h;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i10));
        }
        this.f16427i.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1

                    /* renamed from: a */
                    final /* synthetic */ String f16429a;

                    public AnonymousClass1(String str2) {
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f16427i.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).f16367a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(2001);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).f16367a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((HADI) t10).loadUrl(str2);
            } else {
                a("loadUrl");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    public void c() {
        this.f16427i.countDown();
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }
}
