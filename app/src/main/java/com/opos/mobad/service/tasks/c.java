package com.opos.mobad.service.tasks;

import android.content.Context;
import com.omes.scorpion.OmasStub;
import com.opos.cmn.i.m;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private Context f23776b;

    /* renamed from: c */
    private boolean f23777c = false;

    /* renamed from: d */
    private int f23778d = 0;

    /* renamed from: e */
    private b f23779e = new b();

    /* renamed from: a */
    private m f23775a = new m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.service.tasks.c.1

        /* renamed from: com.opos.mobad.service.tasks.c$1$1 */
        class RunnableC04881 implements Runnable {
            RunnableC04881() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OmasStub.omasVoid(23, new Object[]{this});
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OmasStub.omasVoid(22, new Object[]{this});
        }
    });

    /* renamed from: com.opos.mobad.service.tasks.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: com.opos.mobad.service.tasks.c$1$1 */
        class RunnableC04881 implements Runnable {
            RunnableC04881() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OmasStub.omasVoid(23, new Object[]{this});
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OmasStub.omasVoid(22, new Object[]{this});
        }
    }

    static /* synthetic */ Context a(c cVar) {
        return (Context) OmasStub.omasObject(29, new Object[]{cVar});
    }

    static /* synthetic */ b d(c cVar) {
        return (b) OmasStub.omasObject(32, new Object[]{cVar});
    }

    static /* synthetic */ m e(c cVar) {
        return (m) OmasStub.omasObject(33, new Object[]{cVar});
    }

    public void a() {
        OmasStub.omasVoid(34, new Object[]{this});
    }

    public void a(Context context, boolean z, int i2) {
        OmasStub.omasVoid(35, new Object[]{this, context, Boolean.valueOf(z), Integer.valueOf(i2)});
    }
}
