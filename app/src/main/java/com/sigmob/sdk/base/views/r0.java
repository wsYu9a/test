package com.sigmob.sdk.base.views;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class r0 {

    /* renamed from: c */
    public static r0 f18879c;

    /* renamed from: d */
    public static final AtomicReference<r0> f18880d = new AtomicReference<>();

    /* renamed from: e */
    public static int f18881e = 0;

    /* renamed from: a */
    public Queue<g> f18882a;

    /* renamed from: b */
    public Object f18883b = new Object();

    public r0() {
        if (f18881e > 0) {
            this.f18882a = new LinkedBlockingQueue(f18881e);
        }
    }

    public g a(Context context) {
        return b(context);
    }

    public final g b(Context context) {
        g gVar;
        Queue<g> queue = this.f18882a;
        g poll = queue != null ? queue.poll() : null;
        SigmobLog.i("acquireWebViewInternal  webview:" + poll);
        if (poll != null) {
            ((MutableContextWrapper) poll.getContext()).setBaseContext(context);
            return poll;
        }
        synchronized (this.f18883b) {
            gVar = new g(new MutableContextWrapper(context));
        }
        return gVar;
    }

    public static r0 a() {
        AtomicReference<r0> atomicReference;
        do {
            r0 r0Var = f18879c;
            if (r0Var != null) {
                return r0Var;
            }
            atomicReference = f18880d;
        } while (!k0.e.a(atomicReference, null, new r0()));
        r0 r0Var2 = atomicReference.get();
        f18879c = r0Var2;
        return r0Var2;
    }

    public final void b(g gVar) {
        try {
            if (gVar.getContext() instanceof MutableContextWrapper) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) gVar.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                SigmobLog.i("enqueue  webview:" + gVar);
                if (f18881e <= 0 || this.f18882a == null) {
                    gVar.destroy();
                } else {
                    gVar.h();
                    this.f18882a.offer(gVar);
                }
            }
            if (gVar.getContext() instanceof Activity) {
                SigmobLog.i("Abandon this webview  ， It will cause leak if enqueue !");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a(g gVar) {
        b(gVar);
    }
}
