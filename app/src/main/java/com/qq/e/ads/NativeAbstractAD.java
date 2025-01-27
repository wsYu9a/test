package com.qq.e.ads;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;

/* loaded from: classes4.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {

    /* renamed from: f */
    private DownAPPConfirmPolicy f23874f;

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f23874f;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f23874f = downAPPConfirmPolicy;
        T t = this.f23859a;
        if (t == 0 || downAPPConfirmPolicy == null) {
            return;
        }
        ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
