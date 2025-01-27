package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a */
    private static final String f847a = "ListPopupWindow";

    /* renamed from: b */
    private static final boolean f848b = false;

    /* renamed from: c */
    static final int f849c = 250;

    /* renamed from: d */
    private static Method f850d;

    /* renamed from: e */
    private static Method f851e;

    /* renamed from: f */
    private static Method f852f;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    final ResizePopupRunnable D;
    private final PopupTouchInterceptor E;
    private final PopupScrollListener F;
    private final ListSelectorHider G;
    private Runnable H;
    final Handler I;
    private final Rect J;
    private Rect K;
    private boolean L;
    PopupWindow M;

    /* renamed from: g */
    private Context f853g;

    /* renamed from: h */
    private ListAdapter f854h;

    /* renamed from: i */
    DropDownListView f855i;

    /* renamed from: j */
    private int f856j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    int v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$1 */
    class AnonymousClass1 extends ForwardingListener {
        AnonymousClass1(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View anchorView = ListPopupWindow.this.getAnchorView();
            if (anchorView == null || anchorView.getWindowToken() == null) {
                return;
            }
            ListPopupWindow.this.show();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$3 */
    class AnonymousClass3 implements AdapterView.OnItemSelectedListener {
        AnonymousClass3() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            DropDownListView dropDownListView;
            if (i2 == -1 || (dropDownListView = ListPopupWindow.this.f855i) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 1 || ListPopupWindow.this.isInputMethodNotNeeded() || ListPopupWindow.this.M.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.I.removeCallbacks(listPopupWindow.D);
            ListPopupWindow.this.D.run();
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.M) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.M.getWidth() && y >= 0 && y < ListPopupWindow.this.M.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.I.postDelayed(listPopupWindow.D, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.I.removeCallbacks(listPopupWindow2.D);
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f855i;
            if (dropDownListView == null || !ViewCompat.isAttachedToWindow(dropDownListView) || ListPopupWindow.this.f855i.getCount() <= ListPopupWindow.this.f855i.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f855i.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.v) {
                listPopupWindow.M.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f850d = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i(f847a, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f852f = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i(f847a, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f851e = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i(f847a, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    private int a() {
        int i2;
        int i3;
        int makeMeasureSpec;
        int i4;
        if (this.f855i == null) {
            Context context = this.f853g;
            this.H = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView == null || anchorView.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            DropDownListView b2 = b(context, !this.L);
            this.f855i = b2;
            Drawable drawable = this.A;
            if (drawable != null) {
                b2.setSelector(drawable);
            }
            this.f855i.setAdapter(this.f854h);
            this.f855i.setOnItemClickListener(this.B);
            this.f855i.setFocusable(true);
            this.f855i.setFocusableInTouchMode(true);
            this.f855i.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                AnonymousClass3() {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i22, long j2) {
                    DropDownListView dropDownListView;
                    if (i22 == -1 || (dropDownListView = ListPopupWindow.this.f855i) == null) {
                        return;
                    }
                    dropDownListView.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f855i.setOnScrollListener(this.F);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
            if (onItemSelectedListener != null) {
                this.f855i.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f855i;
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.x;
                if (i5 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i5 != 1) {
                    Log.e(f847a, "Invalid hint position " + this.x);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i6 = this.k;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i2 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i2 = 0;
            }
            this.M.setContentView(view);
        } else {
            View view3 = this.w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i2 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.getPadding(this.J);
            Rect rect = this.J;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.o) {
                this.m = -i7;
            }
        } else {
            this.J.setEmpty();
            i3 = 0;
        }
        int c2 = c(getAnchorView(), this.m, this.M.getInputMethodMode() == 2);
        if (this.t || this.f856j == -1) {
            return c2 + i3;
        }
        int i8 = this.k;
        if (i8 == -2) {
            int i9 = this.f853g.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.J;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f853g.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.J;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int measureHeightOfChildrenCompat = this.f855i.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, c2 - i2, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i2 += i3 + this.f855i.getPaddingTop() + this.f855i.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i2;
    }

    private int c(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.M.getMaxAvailableHeight(view, i2, z);
        }
        Method method = f851e;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.M, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i(f847a, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.M.getMaxAvailableHeight(view, i2);
    }

    private static boolean d(int i2) {
        return i2 == 66 || i2 == 23;
    }

    private void e() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private void g(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.M.setIsClippedToScreen(z);
            return;
        }
        Method method = f850d;
        if (method != null) {
            try {
                method.invoke(this.M, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i(f847a, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    @NonNull
    DropDownListView b(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.f855i;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) { // from class: androidx.appcompat.widget.ListPopupWindow.1
            AnonymousClass1(View view2) {
                super(view2);
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.M.dismiss();
        e();
        this.M.setContentView(null);
        this.f855i = null;
        this.I.removeCallbacks(this.D);
    }

    void f(int i2) {
        this.v = i2;
    }

    @Nullable
    public View getAnchorView() {
        return this.z;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.M.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.M.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.K != null) {
            return new Rect(this.K);
        }
        return null;
    }

    public int getHeight() {
        return this.f856j;
    }

    public int getHorizontalOffset() {
        return this.l;
    }

    public int getInputMethodMode() {
        return this.M.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.f855i;
    }

    public int getPromptPosition() {
        return this.x;
    }

    @Nullable
    public Object getSelectedItem() {
        if (isShowing()) {
            return this.f855i.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.f855i.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.f855i.getSelectedItemPosition();
        }
        return -1;
    }

    @Nullable
    public View getSelectedView() {
        if (isShowing()) {
            return this.f855i.getSelectedView();
        }
        return null;
    }

    public int getSoftInputMode() {
        return this.M.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.o) {
            return this.m;
        }
        return 0;
    }

    public int getWidth() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.t;
    }

    public boolean isInputMethodNotNeeded() {
        return this.M.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.L;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.M.isShowing();
    }

    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (isShowing() && i2 != 62 && (this.f855i.getSelectedItemPosition() >= 0 || !d(i2))) {
            int selectedItemPosition = this.f855i.getSelectedItemPosition();
            boolean z = !this.M.isAboveAnchor();
            ListAdapter listAdapter = this.f854h;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                int lookForSelectablePosition = areAllItemsEnabled ? 0 : this.f855i.lookForSelectablePosition(0, true);
                int count = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.f855i.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                i3 = lookForSelectablePosition;
                i4 = count;
            }
            if ((z && i2 == 19 && selectedItemPosition <= i3) || (!z && i2 == 20 && selectedItemPosition >= i4)) {
                clearListSelection();
                this.M.setInputMethodMode(1);
                show();
                return true;
            }
            this.f855i.setListSelectionHidden(false);
            if (this.f855i.onKeyDown(i2, keyEvent)) {
                this.M.setInputMethodMode(2);
                this.f855i.requestFocusFromTouch();
                show();
                if (i2 == 19 || i2 == 20 || i2 == 23 || i2 == 66) {
                    return true;
                }
            } else if (z && i2 == 20) {
                if (selectedItemPosition == i4) {
                    return true;
                }
            } else if (!z && i2 == 19 && selectedItemPosition == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 4 || !isShowing()) {
            return false;
        }
        View view = this.z;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        if (!isShowing() || this.f855i.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f855i.onKeyUp(i2, keyEvent);
        if (onKeyUp && d(i2)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i2) {
        if (!isShowing()) {
            return false;
        }
        if (this.B == null) {
            return true;
        }
        DropDownListView dropDownListView = this.f855i;
        this.B.onItemClick(dropDownListView, dropDownListView.getChildAt(i2 - dropDownListView.getFirstVisiblePosition()), i2, dropDownListView.getAdapter().getItemId(i2));
        return true;
    }

    public void postShow() {
        this.I.post(this.H);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f854h;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f854h = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        DropDownListView dropDownListView = this.f855i;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f854h);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.z = view;
    }

    public void setAnimationStyle(@StyleRes int i2) {
        this.M.setAnimationStyle(i2);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.M.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i2) {
        Drawable background = this.M.getBackground();
        if (background == null) {
            setWidth(i2);
            return;
        }
        background.getPadding(this.J);
        Rect rect = this.J;
        this.k = rect.left + rect.right + i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z) {
        this.t = z;
    }

    public void setDropDownGravity(int i2) {
        this.s = i2;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        this.K = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.u = z;
    }

    public void setHeight(int i2) {
        if (i2 < 0 && -2 != i2 && -1 != i2) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f856j = i2;
    }

    public void setHorizontalOffset(int i2) {
        this.l = i2;
    }

    public void setInputMethodMode(int i2) {
        this.M.setInputMethodMode(i2);
    }

    public void setListSelector(Drawable drawable) {
        this.A = drawable;
    }

    public void setModal(boolean z) {
        this.L = z;
        this.M.setFocusable(z);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.M.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.C = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z) {
        this.r = true;
        this.q = z;
    }

    public void setPromptPosition(int i2) {
        this.x = i2;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            e();
        }
        this.w = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i2) {
        DropDownListView dropDownListView = this.f855i;
        if (!isShowing() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i2);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i2, true);
        }
    }

    public void setSoftInputMode(int i2) {
        this.M.setSoftInputMode(i2);
    }

    public void setVerticalOffset(int i2) {
        this.m = i2;
        this.o = true;
    }

    public void setWidth(int i2) {
        this.k = i2;
    }

    public void setWindowLayoutType(int i2) {
        this.n = i2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int a2 = a();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.M, this.n);
        if (this.M.isShowing()) {
            if (ViewCompat.isAttachedToWindow(getAnchorView())) {
                int i2 = this.k;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = getAnchorView().getWidth();
                }
                int i3 = this.f856j;
                if (i3 == -1) {
                    if (!isInputMethodNotNeeded) {
                        a2 = -1;
                    }
                    if (isInputMethodNotNeeded) {
                        this.M.setWidth(this.k == -1 ? -1 : 0);
                        this.M.setHeight(0);
                    } else {
                        this.M.setWidth(this.k == -1 ? -1 : 0);
                        this.M.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    a2 = i3;
                }
                this.M.setOutsideTouchable((this.u || this.t) ? false : true);
                this.M.update(getAnchorView(), this.l, this.m, i2 < 0 ? -1 : i2, a2 < 0 ? -1 : a2);
                return;
            }
            return;
        }
        int i4 = this.k;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = getAnchorView().getWidth();
        }
        int i5 = this.f856j;
        if (i5 == -1) {
            a2 = -1;
        } else if (i5 != -2) {
            a2 = i5;
        }
        this.M.setWidth(i4);
        this.M.setHeight(a2);
        g(true);
        this.M.setOutsideTouchable((this.u || this.t) ? false : true);
        this.M.setTouchInterceptor(this.E);
        if (this.r) {
            PopupWindowCompat.setOverlapAnchor(this.M, this.q);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f852f;
            if (method != null) {
                try {
                    method.invoke(this.M, this.K);
                } catch (Exception e2) {
                    Log.e(f847a, "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.M.setEpicenterBounds(this.K);
        }
        PopupWindowCompat.showAsDropDown(this.M, getAnchorView(), this.l, this.m, this.s);
        this.f855i.setSelection(-1);
        if (!this.L || this.f855i.isInTouchMode()) {
            clearListSelection();
        }
        if (this.L) {
            return;
        }
        this.I.post(this.G);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this.f856j = -2;
        this.k = -2;
        this.n = 1002;
        this.p = true;
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = Integer.MAX_VALUE;
        this.x = 0;
        this.D = new ResizePopupRunnable();
        this.E = new PopupTouchInterceptor();
        this.F = new PopupScrollListener();
        this.G = new ListSelectorHider();
        this.J = new Rect();
        this.f853g = context;
        this.I = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, i3);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.m = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.o = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.M = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
