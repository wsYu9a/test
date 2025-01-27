package com.kwad.sdk.widget.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class HorizontalSwipeLayout extends FrameLayout {
    private int aDw;
    private int aDx;
    private com.kwad.sdk.widget.swipe.a aDy;
    private List<a> aDz;
    private float fM;
    private float fN;

    public interface a {
        void dI();

        void dJ();
    }

    public HorizontalSwipeLayout(@NonNull Context context) {
        super(context);
        this.aDx = 0;
        this.aDz = new CopyOnWriteArrayList();
        init(context);
    }

    public HorizontalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDx = 0;
        this.aDz = new CopyOnWriteArrayList();
        init(context);
    }

    public HorizontalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aDx = 0;
        this.aDz = new CopyOnWriteArrayList();
        init(context);
    }

    private synchronized void FE() {
        Iterator<a> it = this.aDz.iterator();
        while (it.hasNext()) {
            it.next().dJ();
        }
    }

    private synchronized void FF() {
        Iterator<a> it = this.aDz.iterator();
        while (it.hasNext()) {
            it.next().dI();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            java.lang.String r1 = "HorizontalSwipeLayout"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L58
            if (r0 == r2) goto L53
            r4 = 2
            if (r0 == r4) goto L16
            r8 = 3
            if (r0 == r8) goto L13
            goto L79
        L13:
            r7.aDx = r3
            goto L79
        L16:
            float r0 = r8.getX()
            float r5 = r7.fM
            float r0 = r0 - r5
            float r5 = java.lang.Math.abs(r0)
            float r8 = r8.getY()
            float r6 = r7.fN
            float r8 = r8 - r6
            float r8 = java.lang.Math.abs(r8)
            int r6 = r7.aDw
            float r6 = (float) r6
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L41
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 <= 0) goto L41
            r8 = 0
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L3f
            r7.aDx = r2
            goto L41
        L3f:
            r7.aDx = r4
        L41:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r4 = "onInterceptTouchEvent ACTION_MOVE mDragState="
            r8.<init>(r4)
            int r4 = r7.aDx
            r8.append(r4)
            java.lang.String r4 = "--dx="
            r8.append(r4)
            goto L6f
        L53:
            r7.aDx = r3
            java.lang.String r8 = "onInterceptTouchEvent ACTION_UP"
            goto L76
        L58:
            float r0 = r8.getX()
            r7.fM = r0
            float r8 = r8.getY()
            r7.fN = r8
            r7.aDx = r3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "onInterceptTouchEvent ACTION_DOWN mInitialMotionX="
            r8.<init>(r0)
            float r0 = r7.fM
        L6f:
            r8.append(r0)
            java.lang.String r8 = r8.toString()
        L76:
            com.kwad.sdk.core.d.b.d(r1, r8)
        L79:
            int r8 = r7.aDx
            if (r8 == 0) goto L7e
            return r2
        L7e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.c(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r0 != 3) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 0
            java.lang.String r2 = "HorizontalSwipeLayout"
            r3 = 1
            if (r0 == 0) goto L86
            r4 = 2
            if (r0 == r3) goto L59
            if (r0 == r4) goto L18
            r8 = 3
            if (r0 == r8) goto L14
            goto L99
        L14:
            r7.aDx = r1
            goto L99
        L18:
            float r0 = r8.getX()
            float r5 = r7.fM
            float r0 = r0 - r5
            float r5 = java.lang.Math.abs(r0)
            float r8 = r8.getY()
            float r6 = r7.fN
            float r8 = r8 - r6
            float r8 = java.lang.Math.abs(r8)
            int r6 = r7.aDx
            if (r6 != 0) goto L47
            int r6 = r7.aDw
            float r6 = (float) r6
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L47
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 <= 0) goto L47
            r8 = 0
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L45
            r7.aDx = r3
            goto L47
        L45:
            r7.aDx = r4
        L47:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r4 = "onTouchEvent ACTION_MOVE mDragState="
            r8.<init>(r4)
            int r4 = r7.aDx
            r8.append(r4)
            java.lang.String r4 = "--dx="
            r8.append(r4)
            goto L8f
        L59:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "onTouchEvent ACTION_UP mDragState="
            r8.<init>(r0)
            int r0 = r7.aDx
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.kwad.sdk.core.d.b.d(r2, r8)
            java.util.List<com.kwad.sdk.widget.swipe.HorizontalSwipeLayout$a> r8 = r7.aDz
            if (r8 == 0) goto L14
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L14
            int r8 = r7.aDx
            if (r8 == 0) goto L14
            if (r8 != r3) goto L80
            r7.FF()
            goto L14
        L80:
            if (r8 != r4) goto L14
            r7.FE()
            goto L14
        L86:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "onTouchEvent ACTION_DOWN mInitialMotionX="
            r8.<init>(r0)
            float r0 = r7.fM
        L8f:
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.kwad.sdk.core.d.b.d(r2, r8)
        L99:
            int r8 = r7.aDx
            if (r8 == 0) goto L9e
            return r3
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.d(android.view.MotionEvent):boolean");
    }

    private void init(Context context) {
        this.aDw = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public final synchronized void a(@NonNull a aVar) {
        this.aDz.add(aVar);
    }

    public final synchronized void b(a aVar) {
        this.aDz.remove(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        List<a> list = this.aDz;
        if (list != null && !list.isEmpty()) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action == 0) {
                parent = getParent();
            } else if (action == 1 || action == 3) {
                parent = getParent();
                z = false;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public synchronized List<a> getOnSwipedListeners() {
        return this.aDz;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.aDy;
        if (aVar == null || !aVar.b(this, motionEvent)) {
            List<a> list = this.aDz;
            return (list == null || list.isEmpty()) ? super.onInterceptTouchEvent(motionEvent) : c(motionEvent);
        }
        b.d("HorizontalSwipeLayout", "onInterceptTouchEvent true");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.aDy;
        if (aVar == null || !aVar.c(this, motionEvent)) {
            List<a> list = this.aDz;
            return (list == null || list.isEmpty()) ? super.onTouchEvent(motionEvent) : d(motionEvent);
        }
        b.d("HorizontalSwipeLayout", "handlerTouchEvent true");
        return true;
    }

    public void setTouchDetector(com.kwad.sdk.widget.swipe.a aVar) {
        this.aDy = aVar;
    }
}
