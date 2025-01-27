package com.martian.mipush.e;

import com.martian.mipush.request.SendPushTokenParams;

/* loaded from: classes4.dex */
public abstract class b extends a<SendPushTokenParams, Boolean> {
    public b() {
        super(SendPushTokenParams.class, Boolean.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(Boolean success) {
        if (success == null) {
            return false;
        }
        return super.onPreDataReceived(success);
    }
}
