package com.martian.mipush;

import android.content.Context;
import b7.a;
import b7.b;
import b7.h;
import com.heytap.mcssdk.AppPushService;

/* loaded from: classes3.dex */
public class OppoPushMessageService extends AppPushService {
    @Override // com.heytap.mcssdk.AppPushService, a7.a
    public void a(Context context, b bVar) {
        super.a(context, bVar);
    }

    @Override // com.heytap.mcssdk.AppPushService, a7.a
    public void b(Context context, a aVar) {
        super.b(context, aVar);
    }

    @Override // com.heytap.mcssdk.AppPushService, a7.a
    public void c(Context context, h hVar) {
        super.c(context.getApplicationContext(), hVar);
    }
}
