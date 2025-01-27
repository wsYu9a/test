package com.aggmoread.sdk.z.b.s;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class a extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, View.OnClickListener {

    /* renamed from: a */
    private View f4844a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.g.c f4845b;

    /* renamed from: c */
    private InterfaceC0091a f4846c;

    /* renamed from: d */
    private GestureDetector f4847d;

    /* renamed from: com.aggmoread.sdk.z.b.s.a$a */
    public interface InterfaceC0091a {
        void a(View view, com.aggmoread.sdk.z.b.g.c cVar);
    }

    public a(InterfaceC0091a interfaceC0091a) {
        this.f4846c = interfaceC0091a;
    }

    private boolean b() {
        InterfaceC0091a interfaceC0091a = this.f4846c;
        if (interfaceC0091a == null) {
            return false;
        }
        interfaceC0091a.a(this.f4844a, this.f4845b);
        this.f4846c = null;
        return true;
    }

    public com.aggmoread.sdk.z.b.g.c a() {
        return this.f4845b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        com.aggmoread.sdk.z.b.d.c("AdTouchCollector", "onSingleTapUp enter");
        return b();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        StringBuilder sb2;
        int i10;
        String sb3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4845b.f4469a = (int) motionEvent.getX();
            this.f4845b.f4470b = (int) motionEvent.getY();
            this.f4845b.f4475g = System.currentTimeMillis();
            sb2 = new StringBuilder();
            sb2.append("touch dx = ");
            sb2.append(this.f4845b.f4469a);
            sb2.append(" , dy = ");
            i10 = this.f4845b.f4470b;
        } else {
            if (action != 1) {
                if (action == 2) {
                    sb3 = "touch mx = " + ((int) motionEvent.getX()) + " , my = " + ((int) motionEvent.getY());
                    com.aggmoread.sdk.z.b.d.c("AdTouchCollector", sb3);
                }
                this.f4847d.onTouchEvent(motionEvent);
                return false;
            }
            this.f4845b.f4471c = (int) motionEvent.getX();
            this.f4845b.f4472d = (int) motionEvent.getY();
            this.f4845b.f4476h = System.currentTimeMillis();
            this.f4845b.f4473e = this.f4844a.getWidth();
            this.f4845b.f4474f = this.f4844a.getHeight();
            sb2 = new StringBuilder();
            sb2.append("touch ux = ");
            sb2.append(this.f4845b.f4471c);
            sb2.append(" , uy = ");
            i10 = this.f4845b.f4472d;
        }
        sb2.append(i10);
        sb3 = sb2.toString();
        com.aggmoread.sdk.z.b.d.c("AdTouchCollector", sb3);
        this.f4847d.onTouchEvent(motionEvent);
        return false;
    }

    public static a a(View view, InterfaceC0091a interfaceC0091a) {
        a aVar = new a(interfaceC0091a);
        aVar.f4844a = view;
        aVar.f4845b = new com.aggmoread.sdk.z.b.g.c();
        aVar.f4847d = new GestureDetector(view.getContext(), aVar);
        view.setOnTouchListener(aVar);
        view.setFocusable(true);
        view.setClickable(true);
        return aVar;
    }
}
