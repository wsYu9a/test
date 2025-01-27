package com.kuaishou.weapon.p0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.cw;
import com.kuaishou.weapon.p0.cx;
import com.kuaishou.weapon.p0.cy;
import com.kuaishou.weapon.p0.cz;
import com.kuaishou.weapon.p0.da;
import com.kuaishou.weapon.p0.db;
import com.kuaishou.weapon.p0.dc;
import com.kuaishou.weapon.p0.n;

/* loaded from: classes.dex */
public class WeaponRECE extends BroadcastReceiver {

    /* renamed from: com.kuaishou.weapon.p0.receiver.WeaponRECE$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f9388a;

        /* renamed from: b */
        final /* synthetic */ Context f9389b;

        AnonymousClass1(Intent intent, Context context) {
            intent = intent;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals(bp.f9128f)) {
                cz.a(context).a(0, 0);
                db.a(context).a(0);
                cx.a(context).a(0);
                cy.a(context).a();
                dc.a(context).a();
                cw.a(context).a(0);
                da.a(context).a(0);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.receiver.WeaponRECE.1

                /* renamed from: a */
                final /* synthetic */ Intent f9388a;

                /* renamed from: b */
                final /* synthetic */ Context f9389b;

                AnonymousClass1(Intent intent2, Context context2) {
                    intent = intent2;
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action) && action.equals(bp.f9128f)) {
                        cz.a(context).a(0, 0);
                        db.a(context).a(0);
                        cx.a(context).a(0);
                        cy.a(context).a();
                        dc.a(context).a();
                        cw.a(context).a(0);
                        da.a(context).a(0);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
