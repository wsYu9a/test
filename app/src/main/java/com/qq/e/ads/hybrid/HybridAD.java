package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: f */
    private HybridADListener f23915f;

    /* renamed from: g */
    private CountDownLatch f23916g = new CountDownLatch(1);

    /* renamed from: h */
    private HybridADSetting f23917h;

    /* renamed from: com.qq.e.ads.hybrid.HybridAD$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23918a;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HybridAD.this.f23916g.await(30L, TimeUnit.SECONDS);
                if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).f23859a == null) {
                    GDTLogger.e("初始化错误：广告实例未被初始化");
                    HybridAD.this.a(2001);
                } else {
                    ((HADI) ((AbstractAD) HybridAD.this).f23859a).loadUrl(str);
                }
            } catch (InterruptedException unused) {
                GDTLogger.e("初始化错误：广告实例未被初始化");
                HybridAD.this.a(2001);
            }
        }
    }

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f23917h = hybridADSetting;
        this.f23915f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    protected HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f23917h, this.f23915f);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        HybridADListener hybridADListener = this.f23915f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
        this.f23916g.countDown();
    }

    protected void c() {
        this.f23916g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1

                    /* renamed from: a */
                    final /* synthetic */ String f23918a;

                    AnonymousClass1(String str2) {
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f23916g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).f23859a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(2001);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).f23859a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                ((HADI) t).loadUrl(str2);
            } else {
                a("loadUrl");
            }
        }
    }
}
