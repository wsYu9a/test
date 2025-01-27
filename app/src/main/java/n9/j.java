package n9;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class j implements xk.c {

    /* renamed from: a */
    public boolean f28813a = false;

    /* renamed from: b */
    public final ScrollView f28814b;

    public j(ScrollView scrollView) {
        this.f28814b = scrollView;
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: n9.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c10;
                c10 = j.this.c(view, motionEvent);
                return c10;
            }
        });
    }

    @Override // xk.c
    public boolean a(View view, float f10, float f11) {
        if (view.getScrollY() > 0) {
            return false;
        }
        if (this.f28814b.getScrollY() <= 0 || !this.f28813a) {
            return true;
        }
        this.f28813a = false;
        return false;
    }

    public final /* synthetic */ boolean c(View view, MotionEvent motionEvent) {
        this.f28813a = true;
        return false;
    }
}
