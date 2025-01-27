package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.universalchardet.prober.n.c;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;

    /* renamed from: d */
    private static final String f2238d = "android.view.View";

    /* renamed from: e */
    private static final Rect f2239e = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: f */
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> f2240f = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        AnonymousClass1() {
        }

        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };

    /* renamed from: g */
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> f2241g = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        AnonymousClass2() {
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i2) {
            return sparseArrayCompat.valueAt(i2);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final AccessibilityManager l;
    private final View m;
    private MyNodeProvider n;

    /* renamed from: h */
    private final Rect f2242h = new Rect();

    /* renamed from: i */
    private final Rect f2243i = new Rect();

    /* renamed from: j */
    private final Rect f2244j = new Rect();
    private final int[] k = new int[2];
    int o = Integer.MIN_VALUE;
    int p = Integer.MIN_VALUE;
    private int q = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$1 */
    class AnonymousClass1 implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
        AnonymousClass1() {
        }

        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    }

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$2 */
    class AnonymousClass2 implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        AnonymousClass2() {
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i2) {
            return sparseArrayCompat.valueAt(i2);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    }

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i2) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.t(i2));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i2) {
            int i3 = i2 == 2 ? ExploreByTouchHelper.this.o : ExploreByTouchHelper.this.p;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i3);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i2, int i3, Bundle bundle) {
            return ExploreByTouchHelper.this.A(i2, i3, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.m = view;
        this.l = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
    }

    private boolean B(int i2, int i3, Bundle bundle) {
        return i3 != 1 ? i3 != 2 ? i3 != 64 ? i3 != 128 ? u(i2, i3, bundle) : e(i2) : D(i2) : clearKeyboardFocusForVirtualView(i2) : requestKeyboardFocusForVirtualView(i2);
    }

    private boolean C(int i2, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.m, i2, bundle);
    }

    private boolean D(int i2) {
        int i3;
        if (!this.l.isEnabled() || !this.l.isTouchExplorationEnabled() || (i3 = this.o) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            e(i3);
        }
        this.o = i2;
        this.m.invalidate();
        sendEventForVirtualView(i2, 32768);
        return true;
    }

    private void E(int i2) {
        int i3 = this.q;
        if (i3 == i2) {
            return;
        }
        this.q = i2;
        sendEventForVirtualView(i2, 128);
        sendEventForVirtualView(i3, 256);
    }

    private boolean e(int i2) {
        if (this.o != i2) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        this.m.invalidate();
        sendEventForVirtualView(i2, 65536);
        return true;
    }

    private boolean f() {
        int i2 = this.p;
        return i2 != Integer.MIN_VALUE && u(i2, 16, null);
    }

    private AccessibilityEvent g(int i2, int i3) {
        return i2 != -1 ? h(i2, i3) : i(i3);
    }

    private AccessibilityEvent h(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        AccessibilityNodeInfoCompat t = t(i2);
        obtain.getText().add(t.getText());
        obtain.setContentDescription(t.getContentDescription());
        obtain.setScrollable(t.isScrollable());
        obtain.setPassword(t.isPassword());
        obtain.setEnabled(t.isEnabled());
        obtain.setChecked(t.isChecked());
        w(i2, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(t.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.m, i2);
        obtain.setPackageName(this.m.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent i(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.m.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat j(int i2) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(f2238d);
        Rect rect = f2239e;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.m);
        y(i2, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f2243i);
        if (this.f2243i.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(this.m.getContext().getPackageName());
        obtain.setSource(this.m, i2);
        if (this.o == i2) {
            obtain.setAccessibilityFocused(true);
            obtain.addAction(128);
        } else {
            obtain.setAccessibilityFocused(false);
            obtain.addAction(64);
        }
        boolean z = this.p == i2;
        if (z) {
            obtain.addAction(2);
        } else if (obtain.isFocusable()) {
            obtain.addAction(1);
        }
        obtain.setFocused(z);
        this.m.getLocationOnScreen(this.k);
        obtain.getBoundsInScreen(this.f2242h);
        if (this.f2242h.equals(rect)) {
            obtain.getBoundsInParent(this.f2242h);
            if (obtain.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                for (int i3 = obtain.mParentVirtualDescendantId; i3 != -1; i3 = obtain2.mParentVirtualDescendantId) {
                    obtain2.setParent(this.m, -1);
                    obtain2.setBoundsInParent(f2239e);
                    y(i3, obtain2);
                    obtain2.getBoundsInParent(this.f2243i);
                    Rect rect2 = this.f2242h;
                    Rect rect3 = this.f2243i;
                    rect2.offset(rect3.left, rect3.top);
                }
                obtain2.recycle();
            }
            this.f2242h.offset(this.k[0] - this.m.getScrollX(), this.k[1] - this.m.getScrollY());
        }
        if (this.m.getLocalVisibleRect(this.f2244j)) {
            this.f2244j.offset(this.k[0] - this.m.getScrollX(), this.k[1] - this.m.getScrollY());
            if (this.f2242h.intersect(this.f2244j)) {
                obtain.setBoundsInScreen(this.f2242h);
                if (q(this.f2242h)) {
                    obtain.setVisibleToUser(true);
                }
            }
        }
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat k() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.m);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.m, obtain);
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            obtain.addChild(this.m, ((Integer) arrayList.get(i2)).intValue());
        }
        return obtain;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> l() {
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sparseArrayCompat.put(arrayList.get(i2).intValue(), j(arrayList.get(i2).intValue()));
        }
        return sparseArrayCompat;
    }

    private void m(int i2, Rect rect) {
        t(i2).getBoundsInParent(rect);
    }

    private static Rect p(@NonNull View view, int i2, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean q(Rect rect) {
        if (rect == null || rect.isEmpty() || this.m.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.m.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int r(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 == 21) {
            return 17;
        }
        if (i2 != 22) {
            return c.m;
        }
        return 66;
    }

    private boolean s(int i2, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> l = l();
        int i3 = this.p;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i3 == Integer.MIN_VALUE ? null : l.get(i3);
        if (i2 == 1 || i2 == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(l, f2241g, f2240f, accessibilityNodeInfoCompat2, i2, ViewCompat.getLayoutDirection(this.m) == 1, false);
        } else {
            if (i2 != 17 && i2 != 33 && i2 != 66 && i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i4 = this.p;
            if (i4 != Integer.MIN_VALUE) {
                m(i4, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                p(this.m, i2, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(l, f2241g, f2240f, accessibilityNodeInfoCompat2, rect2, i2);
        }
        return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat != null ? l.keyAt(l.indexOfValue(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    boolean A(int i2, int i3, Bundle bundle) {
        return i2 != -1 ? B(i2, i3, bundle) : C(i3, bundle);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        if (this.p != i2) {
            return false;
        }
        this.p = Integer.MIN_VALUE;
        z(i2, false);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.l.isEnabled() || !this.l.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int n = n(motionEvent.getX(), motionEvent.getY());
            E(n);
            return n != Integer.MIN_VALUE;
        }
        if (action != 10 || this.q == Integer.MIN_VALUE) {
            return false;
        }
        E(Integer.MIN_VALUE);
        return true;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return s(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return s(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int r = r(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i2 < repeatCount && s(r, null)) {
                        i2++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        f();
        return true;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.o;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.n == null) {
            this.n = new MyNodeProvider();
        }
        return this.n;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.p;
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i2) {
        invalidateVirtualView(i2, 0);
    }

    protected abstract int n(float f2, float f3);

    protected abstract void o(List<Integer> list);

    public final void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        int i3 = this.p;
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (z) {
            s(i2, rect);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        v(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        x(accessibilityNodeInfoCompat);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        int i3;
        if ((!this.m.isFocused() && !this.m.requestFocus()) || (i3 = this.p) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.p = i2;
        z(i2, true);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.l.isEnabled() || (parent = this.m.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.m, g(i2, i3));
    }

    @NonNull
    AccessibilityNodeInfoCompat t(int i2) {
        return i2 == -1 ? k() : j(i2);
    }

    protected abstract boolean u(int i2, int i3, @Nullable Bundle bundle);

    protected void v(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void w(int i2, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void x(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void y(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void z(int i2, boolean z) {
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.l.isEnabled() || (parent = this.m.getParent()) == null) {
            return;
        }
        AccessibilityEvent g2 = g(i2, 2048);
        AccessibilityEventCompat.setContentChangeTypes(g2, i3);
        parent.requestSendAccessibilityEvent(this.m, g2);
    }
}
