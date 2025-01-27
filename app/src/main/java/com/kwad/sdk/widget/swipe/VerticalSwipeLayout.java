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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class VerticalSwipeLayout extends FrameLayout {
    private int aDw;
    private int aDx;
    private com.kwad.sdk.widget.swipe.a aDy;
    private List<a> aDz;
    private float fM;
    private float fN;

    public interface a {
        void ee();

        void ef();
    }

    public VerticalSwipeLayout(@NonNull Context context) {
        super(context);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    public VerticalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    public VerticalSwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    private synchronized void FI() {
        Iterator<a> it = this.aDz.iterator();
        while (it.hasNext()) {
            it.next().ef();
        }
    }

    private synchronized void FJ() {
        Iterator<a> it = this.aDz.iterator();
        while (it.hasNext()) {
            it.next().ee();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            java.lang.String r1 = "VerticalSwipeLayout"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L58
            if (r0 == r2) goto L53
            r4 = 2
            if (r0 == r4) goto L16
            r9 = 3
            if (r0 == r9) goto L13
            goto L79
        L13:
            r8.aDx = r3
            goto L79
        L16:
            float r0 = r9.getX()
            float r5 = r8.fM
            float r0 = r0 - r5
            float r5 = java.lang.Math.abs(r0)
            float r9 = r9.getY()
            float r6 = r8.fN
            float r9 = r9 - r6
            float r6 = java.lang.Math.abs(r9)
            int r7 = r8.aDw
            float r7 = (float) r7
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L41
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L41
            r5 = 0
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 <= 0) goto L3f
            r8.aDx = r2
            goto L41
        L3f:
            r8.aDx = r4
        L41:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = "onInterceptTouchEvent ACTION_MOVE mDragState="
            r9.<init>(r4)
            int r4 = r8.aDx
            r9.append(r4)
            java.lang.String r4 = "--dx="
            r9.append(r4)
            goto L6f
        L53:
            r8.aDx = r3
            java.lang.String r9 = "onInterceptTouchEvent ACTION_UP"
            goto L76
        L58:
            float r0 = r9.getX()
            r8.fM = r0
            float r9 = r9.getY()
            r8.fN = r9
            r8.aDx = r3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "onInterceptTouchEvent ACTION_DOWN mInitialMotionX="
            r9.<init>(r0)
            float r0 = r8.fM
        L6f:
            r9.append(r0)
            java.lang.String r9 = r9.toString()
        L76:
            com.kwad.sdk.core.d.b.d(r1, r9)
        L79:
            int r9 = r8.aDx
            if (r9 == 0) goto L7e
            return r2
        L7e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.VerticalSwipeLayout.c(android.view.MotionEvent):boolean");
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
    private boolean d(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            r1 = 0
            java.lang.String r2 = "VerticalSwipeLayout"
            r3 = 1
            if (r0 == 0) goto L86
            r4 = 2
            if (r0 == r3) goto L59
            if (r0 == r4) goto L18
            r9 = 3
            if (r0 == r9) goto L14
            goto L99
        L14:
            r8.aDx = r1
            goto L99
        L18:
            float r0 = r9.getX()
            float r5 = r8.fM
            float r0 = r0 - r5
            float r5 = java.lang.Math.abs(r0)
            float r9 = r9.getY()
            float r6 = r8.fN
            float r9 = r9 - r6
            float r6 = java.lang.Math.abs(r9)
            int r7 = r8.aDx
            if (r7 != 0) goto L47
            int r7 = r8.aDw
            float r7 = (float) r7
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L47
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L47
            r5 = 0
            int r9 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r9 <= 0) goto L45
            r8.aDx = r3
            goto L47
        L45:
            r8.aDx = r4
        L47:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = "onTouchEvent ACTION_MOVE mDragState="
            r9.<init>(r4)
            int r4 = r8.aDx
            r9.append(r4)
            java.lang.String r4 = "--dx="
            r9.append(r4)
            goto L8f
        L59:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "onTouchEvent ACTION_UP mDragState="
            r9.<init>(r0)
            int r0 = r8.aDx
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.kwad.sdk.core.d.b.d(r2, r9)
            java.util.List<com.kwad.sdk.widget.swipe.VerticalSwipeLayout$a> r9 = r8.aDz
            if (r9 == 0) goto L14
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L14
            int r9 = r8.aDx
            if (r9 == 0) goto L14
            if (r9 != r3) goto L80
            r8.FJ()
            goto L14
        L80:
            if (r9 != r4) goto L14
            r8.FI()
            goto L14
        L86:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "onTouchEvent ACTION_DOWN mInitialMotionX="
            r9.<init>(r0)
            float r0 = r8.fM
        L8f:
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.kwad.sdk.core.d.b.d(r2, r9)
        L99:
            int r9 = r8.aDx
            if (r9 == 0) goto L9e
            return r3
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.VerticalSwipeLayout.d(android.view.MotionEvent):boolean");
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
        b.d("VerticalSwipeLayout", "onInterceptTouchEvent true");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.aDy;
        if (aVar == null || !aVar.c(this, motionEvent)) {
            List<a> list = this.aDz;
            return (list == null || list.isEmpty()) ? super.onTouchEvent(motionEvent) : d(motionEvent);
        }
        b.d("VerticalSwipeLayout", "handlerTouchEvent true");
        return true;
    }

    public void setTouchDetector(com.kwad.sdk.widget.swipe.a aVar) {
        this.aDy = aVar;
    }
}
