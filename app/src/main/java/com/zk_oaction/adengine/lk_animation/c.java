package com.zk_oaction.adengine.lk_animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f34762a;

    /* renamed from: b */
    private ArrayList<b> f34763b = new ArrayList<>();

    /* renamed from: c */
    private Handler f34764c = new a(Looper.getMainLooper());

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.f34762a.f34882g) {
                removeMessages(0);
                return;
            }
            Iterator it = c.this.f34763b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).i();
            }
            sendEmptyMessageDelayed(0, c.this.f34762a.Q - 3);
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34762a = cVar;
    }

    public void b() {
        this.f34763b.clear();
        this.f34764c.removeMessages(0);
    }

    public void c(b bVar) {
        this.f34763b.add(bVar);
    }

    public void e() {
        if (this.f34763b.size() > 0) {
            Iterator<b> it = this.f34763b.iterator();
            while (it.hasNext()) {
                it.next().h();
            }
            this.f34764c.sendEmptyMessageDelayed(0, this.f34762a.Q);
        }
    }

    public void f() {
        this.f34764c.removeMessages(0);
        Iterator<b> it = this.f34763b.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }
}
