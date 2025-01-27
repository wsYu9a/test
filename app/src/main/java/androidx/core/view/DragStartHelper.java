package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class DragStartHelper {

    /* renamed from: a */
    private final View f2014a;

    /* renamed from: b */
    private final OnDragStartListener f2015b;

    /* renamed from: c */
    private int f2016c;

    /* renamed from: d */
    private int f2017d;

    /* renamed from: e */
    private boolean f2018e;

    /* renamed from: f */
    private final View.OnLongClickListener f2019f = new View.OnLongClickListener() { // from class: androidx.core.view.DragStartHelper.1
        AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    };

    /* renamed from: g */
    private final View.OnTouchListener f2020g = new View.OnTouchListener() { // from class: androidx.core.view.DragStartHelper.2
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    };

    /* renamed from: androidx.core.view.DragStartHelper$1 */
    class AnonymousClass1 implements View.OnLongClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    }

    /* renamed from: androidx.core.view.DragStartHelper$2 */
    class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    }

    public interface OnDragStartListener {
        boolean onDragStart(View view, DragStartHelper dragStartHelper);
    }

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.f2014a = view;
        this.f2015b = onDragStartListener;
    }

    public void attach() {
        this.f2014a.setOnLongClickListener(this.f2019f);
        this.f2014a.setOnTouchListener(this.f2020g);
    }

    public void detach() {
        this.f2014a.setOnLongClickListener(null);
        this.f2014a.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.f2016c, this.f2017d);
    }

    public boolean onLongClick(View view) {
        return this.f2015b.onDragStart(view, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r2 != 3) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r2 = r8.getAction()
            r3 = 0
            if (r2 == 0) goto L49
            r4 = 1
            if (r2 == r4) goto L46
            r5 = 2
            if (r2 == r5) goto L1b
            r7 = 3
            if (r2 == r7) goto L46
            goto L4d
        L1b:
            r2 = 8194(0x2002, float:1.1482E-41)
            boolean r2 = androidx.core.view.MotionEventCompat.isFromSource(r8, r2)
            if (r2 == 0) goto L4d
            int r8 = r8.getButtonState()
            r8 = r8 & r4
            if (r8 != 0) goto L2b
            goto L4d
        L2b:
            boolean r8 = r6.f2018e
            if (r8 == 0) goto L30
            goto L4d
        L30:
            int r8 = r6.f2016c
            if (r8 != r0) goto L39
            int r8 = r6.f2017d
            if (r8 != r1) goto L39
            goto L4d
        L39:
            r6.f2016c = r0
            r6.f2017d = r1
            androidx.core.view.DragStartHelper$OnDragStartListener r8 = r6.f2015b
            boolean r7 = r8.onDragStart(r7, r6)
            r6.f2018e = r7
            return r7
        L46:
            r6.f2018e = r3
            goto L4d
        L49:
            r6.f2016c = r0
            r6.f2017d = r1
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DragStartHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
