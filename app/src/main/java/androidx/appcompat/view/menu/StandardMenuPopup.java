package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* renamed from: b */
    private static final int f577b = R.layout.abc_popup_menu_item_layout;

    /* renamed from: c */
    private final Context f578c;

    /* renamed from: d */
    private final MenuBuilder f579d;

    /* renamed from: e */
    private final MenuAdapter f580e;

    /* renamed from: f */
    private final boolean f581f;

    /* renamed from: g */
    private final int f582g;

    /* renamed from: h */
    private final int f583h;

    /* renamed from: i */
    private final int f584i;

    /* renamed from: j */
    final MenuPopupWindow f585j;
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private MenuPresenter.Callback p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean v;
    final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.1
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.isShowing() || StandardMenuPopup.this.f585j.isModal()) {
                return;
            }
            View view = StandardMenuPopup.this.o;
            if (view == null || !view.isShown()) {
                StandardMenuPopup.this.dismiss();
            } else {
                StandardMenuPopup.this.f585j.show();
            }
        }
    };
    private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.2
        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.q = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.q.removeGlobalOnLayoutListener(standardMenuPopup.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int u = 0;

    /* renamed from: androidx.appcompat.view.menu.StandardMenuPopup$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.isShowing() || StandardMenuPopup.this.f585j.isModal()) {
                return;
            }
            View view = StandardMenuPopup.this.o;
            if (view == null || !view.isShown()) {
                StandardMenuPopup.this.dismiss();
            } else {
                StandardMenuPopup.this.f585j.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.StandardMenuPopup$2 */
    class AnonymousClass2 implements View.OnAttachStateChangeListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.q = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.q.removeGlobalOnLayoutListener(standardMenuPopup.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i2, int i3, boolean z) {
        this.f578c = context;
        this.f579d = menuBuilder;
        this.f581f = z;
        this.f580e = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, f577b);
        this.f583h = i2;
        this.f584i = i3;
        Resources resources = context.getResources();
        this.f582g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.f585j = new MenuPopupWindow(context, null, i2, i3);
        menuBuilder.addMenuPresenter(this, context);
    }

    private boolean e() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.f585j.setOnDismissListener(this);
        this.f585j.setOnItemClickListener(this);
        this.f585j.setModal(true);
        View view2 = this.o;
        boolean z = this.q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.q = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.f585j.setAnchorView(view2);
        this.f585j.setDropDownGravity(this.u);
        if (!this.s) {
            this.t = MenuPopup.b(this.f580e, null, this.f578c, this.f582g);
            this.s = true;
        }
        this.f585j.setContentWidth(this.t);
        this.f585j.setInputMethodMode(2);
        this.f585j.setEpicenterBounds(getEpicenterBounds());
        this.f585j.show();
        ListView listView = this.f585j.getListView();
        listView.setOnKeyListener(this);
        if (this.v && this.f579d.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f578c).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f579d.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.f585j.setAdapter(this.f580e);
        this.f585j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing()) {
            this.f585j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f585j.getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.r && this.f585j.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f579d) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.p;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f579d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f578c, subMenuBuilder, this.o, this.f581f, this.f583h, this.f584i);
            menuPopupHelper.setPresenterCallback(this.p);
            menuPopupHelper.setForceShowIcon(MenuPopup.c(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.m);
            this.m = null;
            this.f579d.close(false);
            int horizontalOffset = this.f585j.getHorizontalOffset();
            int verticalOffset = this.f585j.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.u, ViewCompat.getLayoutDirection(this.n)) & 7) == 5) {
                horizontalOffset += this.n.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.p;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.p = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.f580e.setForceShowIcon(z);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i2) {
        this.u = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i2) {
        this.f585j.setHorizontalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i2) {
        this.f585j.setVerticalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (!e()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.s = false;
        MenuAdapter menuAdapter = this.f580e;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
