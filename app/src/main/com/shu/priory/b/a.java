package com.shu.priory.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.shu.priory.config.AdError;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYBaseAdListener;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class a<T> extends Handler {

    /* renamed from: a */
    private IFLYBaseAdListener<T> f16818a;

    public a() {
        super(Looper.getMainLooper());
    }

    public void a(int i10, Object obj) {
        sendMessage(obtainMessage(i10, obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IFLYBaseAdListener<T> iFLYBaseAdListener = this.f16818a;
        if (iFLYBaseAdListener == 0) {
            h.d(SDKConstants.TAG, "ad listener is null");
            return;
        }
        int i10 = message.what;
        if (i10 == 0) {
            iFLYBaseAdListener.onAdLoaded(message.obj);
        } else {
            if (i10 != 1) {
                return;
            }
            iFLYBaseAdListener.onAdFailed((AdError) message.obj);
        }
    }

    public void a(IFLYBaseAdListener<T> iFLYBaseAdListener) {
        this.f16818a = iFLYBaseAdListener;
    }
}
