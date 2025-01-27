package com.martian.mipush;

import android.content.Context;
import com.martian.libmars.utils.q0;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

/* loaded from: classes4.dex */
public class VivoMessageReceiverImpl extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage msg) {
        q0.e("通知点击 msgId " + msg.getMsgId() + " ;customContent=" + msg.getSkipContent());
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String regId) {
        q0.e("onReceiveRegId regId = " + regId);
        c.i().t(c.f14881b, regId);
    }
}
