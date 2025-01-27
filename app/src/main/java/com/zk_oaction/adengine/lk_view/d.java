package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class d extends ViewGroup {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35104a;

    /* renamed from: b */
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> f35105b;

    /* renamed from: c */
    private HashMap<com.zk_oaction.adengine.lk_sdk.interfaces.a, Long> f35106c;

    /* renamed from: d */
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> f35107d;

    /* renamed from: e */
    private List<com.zk_oaction.adengine.lk_sdk.interfaces.a> f35108e;

    /* renamed from: f */
    private ArrayList<View.OnTouchListener> f35109f;

    /* renamed from: g */
    private Scroller f35110g;

    /* renamed from: h */
    private Rect f35111h;

    /* renamed from: i */
    private int f35112i;

    /* renamed from: j */
    private Handler f35113j;
    private long k;
    private float l;
    private float m;
    private GestureDetector n;
    private boolean o;
    private boolean p;
    private float q;
    private float r;
    private ArrayList<View> s;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            try {
                if (i2 == 0) {
                    if (d.this.f35108e.isEmpty()) {
                        return;
                    }
                    Iterator it = d.this.f35108e.iterator();
                    while (it.hasNext()) {
                        ((com.zk_oaction.adengine.lk_sdk.interfaces.a) it.next()).d();
                    }
                    return;
                }
                if (i2 == 1) {
                    if (d.this.f35107d != null) {
                        d.this.f35107d.clear();
                    }
                    if (d.this.f35108e != null) {
                        d.this.f35108e.clear();
                    }
                    if (d.this.f35104a == null || d.this.f35104a.G == null) {
                        return;
                    }
                    d.this.f35104a.G.d();
                    return;
                }
                if (i2 == 2) {
                    if (d.this.f35107d.isEmpty() || d.this.f35108e.isEmpty()) {
                        for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : d.this.f35105b) {
                            g gVar = (g) message.obj;
                            aVar.h(gVar.f35122a, gVar.f35123b);
                            aVar.j(gVar.f35122a, gVar.f35123b);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.k();
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f35116a;

        c(View view) {
            this.f35116a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.addView(this.f35116a);
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_view.d$d */
    class RunnableC0820d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f35118a;

        RunnableC0820d(View view) {
            this.f35118a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.removeView(this.f35118a);
        }
    }

    class e implements GestureDetector.OnGestureListener {
        e() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            try {
                if (d.this.f35104a != null && d.this.f35104a.G != null) {
                    d.this.f35104a.G.g(motionEvent, motionEvent2, f2, f3);
                    d.this.o = true;
                }
                for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : d.this.f35105b) {
                    if (aVar instanceof com.zk_oaction.adengine.lk_unlock.b) {
                        aVar.h(d.this.q, d.this.r);
                        aVar.j(d.this.q, d.this.r);
                    }
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.f35104a == null || d.this.f35104a.G == null) {
                return;
            }
            d.this.f35104a.G.d();
            d.this.p = true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.n == null) {
                return true;
            }
            d.this.n.onTouchEvent(motionEvent);
            return true;
        }
    }

    private class g {

        /* renamed from: a */
        private float f35122a;

        /* renamed from: b */
        private float f35123b;

        public g(d dVar, float f2, float f3) {
            this.f35122a = f2;
            this.f35123b = f3;
        }
    }

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.F);
        this.k = 0L;
        this.q = 0.0f;
        this.r = 0.0f;
        this.f35104a = cVar;
        this.s = new ArrayList<>();
        this.f35105b = new CopyOnWriteArrayList();
        this.f35106c = new HashMap<>();
        this.f35107d = new CopyOnWriteArrayList();
        this.f35108e = new CopyOnWriteArrayList();
        this.f35109f = new ArrayList<>();
        this.f35113j = new a(Looper.getMainLooper());
        this.f35110g = new Scroller(this.f35104a.F, new BounceInterpolator());
        if (this.f35104a != null) {
            Thread currentThread = Thread.currentThread();
            com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f35104a;
            if (currentThread == cVar2.S) {
                k();
            } else {
                cVar2.U.post(new b());
            }
        }
    }

    private void d(MotionEvent motionEvent) {
        try {
            this.f35108e.clear();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it = this.f35104a.M.iterator();
            while (it.hasNext()) {
                com.zk_oaction.adengine.lk_sdk.interfaces.a next = it.next();
                if (!next.c() && next.a(x, y) && !this.f35107d.contains(next) && this.f35105b.contains(next) && uptimeMillis - this.f35106c.get(next).longValue() <= 100) {
                    this.f35108e.add(next);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void e(MotionEvent motionEvent, float f2, float f3) {
        this.l = f2;
        this.m = f3;
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
        float f4 = cVar.P;
        cVar.u("touch_x", "" + (f2 / f4));
        this.f35104a.u("touch_y", "" + (f3 / f4));
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f35104a.G;
        if (aVar != null) {
            aVar.h(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f35104a;
        if (cVar2.W) {
            cVar2.u("touch_pressure", "" + motionEvent.getPressure());
        }
    }

    public void k() {
        this.n = new GestureDetector(getContext(), new e());
        f(new f());
    }

    private void l(MotionEvent motionEvent, float f2, float f3) {
        this.f35104a.u("touch_x", "" + (f2 / this.f35104a.P));
        this.f35104a.u("touch_y", "" + (f3 / this.f35104a.P));
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f35104a.G;
        if (aVar != null) {
            aVar.i(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
        if (cVar.W) {
            cVar.u("touch_pressure", "" + motionEvent.getPressure());
        }
        if (this.f35107d.isEmpty()) {
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it = this.f35105b.iterator();
            while (it.hasNext()) {
                it.next().h(f2, f3);
            }
        }
        try {
            float f4 = f2 - this.l;
            float f5 = f3 - this.m;
            if (Math.sqrt((f4 * f4) + (f5 * f5)) > this.f35104a.F.getResources().getDisplayMetrics().density * 10.0f) {
                this.f35113j.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    private void p(MotionEvent motionEvent, float f2, float f3) {
        Handler handler;
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
        float f4 = cVar.P;
        cVar.u("touch_x", "" + (f2 / f4));
        this.f35104a.u("touch_y", "" + (f3 / f4));
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.f35104a.G;
        if (aVar != null) {
            aVar.o(motionEvent, (int) f2, (int) f3);
        }
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f35104a;
        if (cVar2.W) {
            cVar2.u("touch_pressure", "" + motionEvent.getPressure());
        }
        Handler handler2 = this.f35113j;
        if (handler2 != null) {
            handler2.removeMessages(1);
            this.f35113j.removeMessages(2);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = new g(this, f2, f3);
            this.f35113j.sendMessage(obtain);
        }
        this.q = f2;
        this.r = f3;
        if (this.f35108e.isEmpty() || (handler = this.f35113j) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(0, 300L);
    }

    private void r(MotionEvent motionEvent, float f2, float f3) {
        this.f35104a.u("touch_x", "" + (f2 / this.f35104a.P));
        this.f35104a.u("touch_y", "" + (f3 / this.f35104a.P));
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
        if (cVar.W) {
            cVar.u("touch_pressure", "" + motionEvent.getPressure());
        }
        if (this.f35107d.isEmpty() || this.f35108e.isEmpty()) {
            for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : this.f35105b) {
                aVar.h(f2, f3);
                aVar.k(f2, f3);
            }
        }
    }

    public int a() {
        ArrayList<View> arrayList = this.s;
        return arrayList != null ? arrayList.size() : super.getChildCount();
    }

    public View b(int i2) {
        ArrayList<View> arrayList = this.s;
        return (arrayList == null || i2 >= arrayList.size()) ? super.getChildAt(i2) : this.s.get(i2);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f35110g.computeScrollOffset()) {
            setTranslationY(this.f35110g.getCurrY());
            setTranslationX(this.f35110g.getCurrX());
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f35104a.X) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f35112i = motionEvent.getPointerId(0);
        } else if (motionEvent.getAction() == 1) {
            d(motionEvent);
        }
        if (motionEvent.findPointerIndex(this.f35112i) != 0) {
            return true;
        }
        if (motionEvent.getAction() == 6) {
            motionEvent.setAction(1);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect = this.f35111h;
        if (rect != null) {
            canvas.clipRect(rect);
        }
        super.draw(canvas);
    }

    public void f(View.OnTouchListener onTouchListener) {
        this.f35109f.add(onTouchListener);
    }

    public void g(View view) {
        this.s.add(view);
        Thread currentThread = Thread.currentThread();
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
        if (currentThread == cVar.S) {
            addView(view);
        } else {
            cVar.U.post(new c(view));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        if ((bVar instanceof com.zk_oaction.adengine.lk_view.b) || (bVar instanceof TextView)) {
            g((View) bVar);
        } else if (bVar instanceof com.zk_oaction.adengine.lk_view.f) {
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = ((com.zk_oaction.adengine.lk_view.f) bVar).z().iterator();
            while (it.hasNext()) {
                h(it.next());
            }
        }
    }

    public void m(View view) {
        try {
            this.s.remove(view);
            Thread currentThread = Thread.currentThread();
            com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
            if (currentThread == cVar.S) {
                removeView(view);
            } else {
                cVar.U.post(new RunnableC0820d(view));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            com.zk_oaction.adengine.lk_sdk.c cVar = this.f35104a;
            float f2 = cVar.P;
            float f3 = x / f2;
            float f4 = y / f2;
            cVar.u("touch_x", "" + f3);
            this.f35104a.u("touch_y", "" + f4);
            this.f35104a.u("touch_begin_x", "" + f3);
            this.f35104a.u("touch_begin_y", "" + f4);
            this.f35107d.clear();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.k == 0) {
                this.k = uptimeMillis;
            }
            Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it = this.f35104a.M.iterator();
            while (it.hasNext()) {
                com.zk_oaction.adengine.lk_sdk.interfaces.a next = it.next();
                if (next.c() || !next.a(x, y)) {
                    this.f35105b.remove(next);
                    this.f35106c.remove(next);
                } else {
                    if (this.f35105b.contains(next) && uptimeMillis - this.f35106c.get(next).longValue() <= 300) {
                        this.f35107d.add(next);
                        this.f35108e.remove(next);
                    }
                    this.f35106c.put(next, Long.valueOf(uptimeMillis));
                    if (!this.f35105b.contains(next)) {
                        this.f35105b.add(next);
                    }
                }
            }
            if (this.f35107d.isEmpty()) {
                Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.a> it2 = this.f35105b.iterator();
                while (it2.hasNext()) {
                    it2.next().f(x, y);
                }
                return false;
            }
            for (com.zk_oaction.adengine.lk_sdk.interfaces.a aVar : this.f35107d) {
                this.f35108e.remove(aVar);
                aVar.a();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                e(motionEvent, x, y);
            } else if (action == 1) {
                p(motionEvent, x, y);
            } else if (action == 2) {
                l(motionEvent, x, y);
            } else if (action == 3) {
                r(motionEvent, x, y);
            }
            Iterator<View.OnTouchListener> it = this.f35109f.iterator();
            while (it.hasNext()) {
                it.next().onTouch(null, motionEvent);
            }
        } catch (Throwable unused) {
        }
        return true;
    }
}
