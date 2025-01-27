package aa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class d extends c {

    /* renamed from: y */
    public int f114y = 0;

    public d() {
        x();
    }

    @Override // aa.c, aa.a, aa.f
    public boolean b(Canvas canvas) {
        int i10;
        int i11 = -n();
        int n10 = n();
        int i12 = this.f97h;
        if (i12 > 0) {
            int i13 = -n();
            i12 = this.f97h;
            i11 = i13 + i12;
            i10 = 1;
        } else if (i12 < 0) {
            n10 = n() + this.f97h;
            i10 = 0;
        } else {
            i12 = 0;
            i10 = 4;
        }
        boolean z10 = !canvas.isHardwareAccelerated() || v();
        if (z10) {
            q(i10);
        }
        if (i10 == 4) {
            k().e().draw(canvas);
            return true;
        }
        View B = B();
        if (B != null && i11 >= (-n())) {
            canvas.translate(i11, 0.0f);
            if (this.f97h == 0 || !z10 || t() == null) {
                B.draw(canvas);
            } else {
                canvas.drawBitmap(t(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i11, 0.0f);
        }
        View A = A();
        if (A != null) {
            canvas.translate(i12, 0.0f);
            if (this.f97h == 0 || !z10 || s() == null) {
                A.draw(canvas);
            } else {
                canvas.drawBitmap(s(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-i12, 0.0f);
        }
        View z11 = z();
        if (z11 != null && n10 <= n()) {
            canvas.translate(n10, 0.0f);
            if (this.f97h == 0 || !z10 || t() == null) {
                z11.draw(canvas);
            } else {
                canvas.drawBitmap(t(), 0.0f, 0.0f, (Paint) null);
            }
            canvas.translate(-n10, 0.0f);
        }
        return true;
    }

    @Override // aa.c, aa.f
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        G(motionEvent);
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            if (C()) {
                this.f98i.abortAnimation();
                i();
            }
            this.f114y = (int) motionEvent.getX();
            return false;
        }
        boolean z11 = true;
        if (action != 1) {
            if (action == 2) {
                if (C()) {
                    this.f98i.abortAnimation();
                    i();
                    this.f114y = 0;
                }
                if (this.f114y == 0) {
                    this.f114y = (int) motionEvent.getX();
                }
                if (this.f104o == 0 && Math.abs(motionEvent.getX() - this.f114y) < this.f110u * 10.0f) {
                    return false;
                }
                int x10 = (int) (motionEvent.getX() - this.f114y);
                if (this.f103n == 4) {
                    if (k().p() && x10 < 0) {
                        this.f103n = 0;
                        m().F(0);
                    } else if (k().q() && x10 > 0) {
                        this.f103n = 1;
                        m().F(1);
                    }
                }
                if (this.f104o == 0 && ((this.f103n == 0 && k().p()) || (this.f103n == 1 && k().q()))) {
                    this.f104o = 1;
                }
                if (this.f104o == 1 && (((i10 = this.f103n) == 0 && x10 >= 0) || (i10 == 1 && x10 <= 0))) {
                    this.f104o = 0;
                }
                if (this.f103n != 4 && this.f104o == 1) {
                    this.f99j.computeCurrentVelocity(1000);
                    K(x10);
                    z10 = true;
                }
                o();
                return z10;
            }
            if (action != 3) {
                return false;
            }
        }
        int i11 = this.f97h;
        float abs = (int) Math.abs(this.f99j.getXVelocity());
        int min = (int) Math.min(this.f107r, this.f109t + ((this.f110u * abs) / 20.0f));
        int i12 = this.f104o;
        if (i12 == 1 && this.f103n == 0) {
            int i13 = -i11;
            if (i13 > this.f100k || abs > this.f110u * 100.0f) {
                this.f102m = 0;
                this.f98i.startScroll(i11, 0, (-n()) - i11, 0, ((n() - Math.abs(i11)) * 1000) / min);
            } else {
                this.f102m = 4;
                this.f98i.startScroll(i11, 0, i13, 0, (Math.abs(i11) * 1000) / min);
            }
        } else if (i12 != 1 || this.f103n != 1) {
            z11 = false;
        } else if (i11 > this.f100k || abs > this.f110u * 100.0f) {
            this.f102m = 1;
            this.f98i.startScroll(i11, 0, n() - i11, 0, ((n() - Math.abs(i11)) * 1000) / min);
        } else {
            this.f102m = 4;
            this.f98i.startScroll(i11, 0, -i11, 0, (Math.abs(i11) * 1000) / min);
        }
        J();
        this.f114y = 0;
        o();
        return z11;
    }
}
