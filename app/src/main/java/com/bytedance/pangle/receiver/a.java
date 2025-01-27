package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.d.e;

/* loaded from: classes2.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: com.bytedance.pangle.receiver.a$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7735a;

        /* renamed from: b */
        final /* synthetic */ Intent f7736b;

        public AnonymousClass1(Context context, Intent intent) {
            context = context;
            intent = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a().a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (c.a().f7742c.contains(Integer.valueOf(hashCode()))) {
            c.a().a(context, intent);
        } else {
            e.b(new Runnable() { // from class: com.bytedance.pangle.receiver.a.1

                /* renamed from: a */
                final /* synthetic */ Context f7735a;

                /* renamed from: b */
                final /* synthetic */ Intent f7736b;

                public AnonymousClass1(Context context2, Intent intent2) {
                    context = context2;
                    intent = intent2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.a().a(context, intent);
                }
            });
        }
    }
}
