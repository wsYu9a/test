package b.d.e.c.a.l;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public class a extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, View.OnClickListener {

    /* renamed from: a */
    private View f4669a;

    /* renamed from: b */
    private b.d.e.c.a.f.c f4670b;

    /* renamed from: c */
    private InterfaceC0031a f4671c;

    /* renamed from: d */
    private GestureDetector f4672d;

    /* renamed from: b.d.e.c.a.l.a$a */
    public interface InterfaceC0031a {
        void a(View view, b.d.e.c.a.f.c cVar);
    }

    public a(InterfaceC0031a interfaceC0031a) {
        this.f4671c = interfaceC0031a;
    }

    public static a b(View view, InterfaceC0031a interfaceC0031a) {
        a aVar = new a(interfaceC0031a);
        aVar.f4669a = view;
        aVar.f4670b = new b.d.e.c.a.f.c();
        aVar.f4672d = new GestureDetector(view.getContext(), aVar);
        view.setOnTouchListener(aVar);
        view.setFocusable(true);
        view.setClickable(true);
        return aVar;
    }

    private boolean c() {
        InterfaceC0031a interfaceC0031a = this.f4671c;
        if (interfaceC0031a == null) {
            return false;
        }
        interfaceC0031a.a(this.f4669a, this.f4670b);
        this.f4671c = null;
        return true;
    }

    public b.d.e.c.a.f.c a() {
        return this.f4670b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        b.d.e.c.a.d.k("AdTouchCollector", "onSingleTapUp enter");
        return c();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        StringBuilder sb;
        int i2;
        String sb2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4670b.f4585a = (int) motionEvent.getX();
            this.f4670b.f4586b = (int) motionEvent.getY();
            this.f4670b.f4591g = System.currentTimeMillis();
            sb = new StringBuilder();
            sb.append("touch dx = ");
            sb.append(this.f4670b.f4585a);
            sb.append(" , dy = ");
            i2 = this.f4670b.f4586b;
        } else {
            if (action != 1) {
                if (action == 2) {
                    sb2 = "touch mx = " + ((int) motionEvent.getX()) + " , my = " + ((int) motionEvent.getY());
                    b.d.e.c.a.d.k("AdTouchCollector", sb2);
                }
                this.f4672d.onTouchEvent(motionEvent);
                return false;
            }
            this.f4670b.f4587c = (int) motionEvent.getX();
            this.f4670b.f4588d = (int) motionEvent.getY();
            this.f4670b.f4592h = System.currentTimeMillis();
            this.f4670b.f4589e = this.f4669a.getWidth();
            this.f4670b.f4590f = this.f4669a.getHeight();
            sb = new StringBuilder();
            sb.append("touch ux = ");
            sb.append(this.f4670b.f4587c);
            sb.append(" , uy = ");
            i2 = this.f4670b.f4588d;
        }
        sb.append(i2);
        sb2 = sb.toString();
        b.d.e.c.a.d.k("AdTouchCollector", sb2);
        this.f4672d.onTouchEvent(motionEvent);
        return false;
    }
}
