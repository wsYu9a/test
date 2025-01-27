package com.martian.mipush;

import android.content.Context;
import com.heytap.mcssdk.AppPushService;
import com.heytap.mcssdk.n.h;
import com.martian.libmars.utils.q0;

/* loaded from: classes4.dex */
public class OppoPushMessageService extends AppPushService {
    @Override // com.heytap.mcssdk.AppPushService, com.heytap.mcssdk.h.a
    public void a(Context context, com.heytap.mcssdk.n.b commandMessage) {
        super.a(context, commandMessage);
        q0.e("processMessage:" + commandMessage.toString());
    }

    @Override // com.heytap.mcssdk.AppPushService, com.heytap.mcssdk.h.a
    public void b(Context context, com.heytap.mcssdk.n.a appMessage) {
        super.b(context, appMessage);
        q0.e("Receive AppMessage:" + appMessage.i());
    }

    @Override // com.heytap.mcssdk.AppPushService, com.heytap.mcssdk.h.a
    public void c(Context context, h sptDataMessage) {
        super.c(context.getApplicationContext(), sptDataMessage);
        q0.e("Receive SptDataMessage:" + sptDataMessage.i());
    }
}
