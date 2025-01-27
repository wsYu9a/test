package n9;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class n implements View.OnTouchListener {

    /* renamed from: h */
    public static final int f28816h = 0;

    /* renamed from: i */
    public static final int f28817i = 1;

    /* renamed from: j */
    public static final int f28818j = 2;

    /* renamed from: b */
    public Matrix f28819b = new Matrix();

    /* renamed from: c */
    public Matrix f28820c = new Matrix();

    /* renamed from: d */
    public int f28821d = 0;

    /* renamed from: e */
    public PointF f28822e = new PointF();

    /* renamed from: f */
    public PointF f28823f = new PointF();

    /* renamed from: g */
    public float f28824g = 1.0f;

    public final void a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    public final float b(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x10 * x10) + (y10 * y10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r0 != 6) goto L56;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof android.widget.ImageView
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r0 == 0) goto L7f
            if (r0 == r2) goto L7c
            r3 = 1092616192(0x41200000, float:10.0)
            r4 = 2
            if (r0 == r4) goto L39
            r5 = 5
            if (r0 == r5) goto L20
            r8 = 6
            if (r0 == r8) goto L7c
            goto L9e
        L20:
            float r0 = r6.b(r8)
            r6.f28824g = r0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9e
            android.graphics.Matrix r0 = r6.f28820c
            android.graphics.Matrix r1 = r6.f28819b
            r0.set(r1)
            android.graphics.PointF r0 = r6.f28823f
            r6.a(r0, r8)
            r6.f28821d = r4
            goto L9e
        L39:
            int r0 = r6.f28821d
            if (r0 != r2) goto L5c
            android.graphics.Matrix r0 = r6.f28819b
            android.graphics.Matrix r1 = r6.f28820c
            r0.set(r1)
            android.graphics.Matrix r0 = r6.f28819b
            float r1 = r8.getX()
            android.graphics.PointF r3 = r6.f28822e
            float r3 = r3.x
            float r1 = r1 - r3
            float r8 = r8.getY()
            android.graphics.PointF r3 = r6.f28822e
            float r3 = r3.y
            float r8 = r8 - r3
            r0.postTranslate(r1, r8)
            goto L9e
        L5c:
            if (r0 != r4) goto L9e
            float r8 = r6.b(r8)
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9e
            android.graphics.Matrix r0 = r6.f28819b
            android.graphics.Matrix r1 = r6.f28820c
            r0.set(r1)
            float r0 = r6.f28824g
            float r8 = r8 / r0
            android.graphics.Matrix r0 = r6.f28819b
            android.graphics.PointF r1 = r6.f28823f
            float r3 = r1.x
            float r1 = r1.y
            r0.postScale(r8, r8, r3, r1)
            goto L9e
        L7c:
            r6.f28821d = r1
            goto L9e
        L7f:
            android.graphics.Matrix r0 = r6.f28819b
            android.graphics.Matrix r1 = r7.getImageMatrix()
            r0.set(r1)
            android.graphics.Matrix r0 = r6.f28820c
            android.graphics.Matrix r1 = r6.f28819b
            r0.set(r1)
            android.graphics.PointF r0 = r6.f28822e
            float r1 = r8.getX()
            float r8 = r8.getY()
            r0.set(r1, r8)
            r6.f28821d = r2
        L9e:
            android.graphics.Matrix r8 = r6.f28819b
            r7.setImageMatrix(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.n.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
