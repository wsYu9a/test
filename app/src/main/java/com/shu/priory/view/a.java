package com.shu.priory.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.shu.priory.config.AdError;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYAdListener;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class a extends Handler {

    /* renamed from: a */
    private IFLYAdListener f17446a;

    /* renamed from: b */
    private com.shu.priory.listener.a f17447b;

    public a() {
        super(Looper.getMainLooper());
    }

    public void a(int i10, int i11) {
        sendMessageDelayed(obtainMessage(i10), i11);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IFLYAdListener iFLYAdListener = this.f17446a;
        if (iFLYAdListener == null) {
            h.d(SDKConstants.TAG, "htmlAd listener is null");
            return;
        }
        int i10 = message.what;
        if (i10 == 0) {
            iFLYAdListener.onAdReceive();
            return;
        }
        if (i10 == 1) {
            iFLYAdListener.onAdFailed((AdError) message.obj);
            return;
        }
        if (i10 == 2) {
            iFLYAdListener.onAdClick();
        } else if (i10 == 3) {
            iFLYAdListener.onAdClose();
        } else {
            if (i10 != 4) {
                return;
            }
            this.f17447b.a();
        }
    }

    public void a(int i10, Object obj) {
        sendMessage(obtainMessage(i10, obj));
    }

    public void a(IFLYAdListener iFLYAdListener) {
        this.f17446a = iFLYAdListener;
    }

    public void a(com.shu.priory.listener.a aVar) {
        this.f17447b = aVar;
    }
}
