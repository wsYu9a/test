package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: b */
    private static final int f480b = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: c */
    static final int f481c = 0;

    /* renamed from: d */
    static final int f482d = 1;

    /* renamed from: e */
    static final int f483e = 200;
    private boolean A;
    private MenuPresenter.Callback B;
    ViewTreeObserver C;
    private PopupWindow.OnDismissListener D;
    boolean E;

    /* renamed from: f */
    private final Context f484f;

    /* renamed from: g */
    private final int f485g;

    /* renamed from: h */
    private final int f486h;

    /* renamed from: i */
    private final int f487i;

    /* renamed from: j */
    private final boolean f488j;
    final Handler k;
    private View s;
    View t;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private final List<MenuBuilder> l = new ArrayList();
    final List<CascadingMenuInfo> m = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener n = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.isShowing() || CascadingMenuPopup.this.m.size() <= 0 || CascadingMenuPopup.this.m.get(0).window.isModal()) {
                return;
            }
            View view = CascadingMenuPopup.this.t;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator<CascadingMenuInfo> it = CascadingMenuPopup.this.m.iterator();
            while (it.hasNext()) {
                it.next().window.show();
            }
        }
    };
    private final View.OnAttachStateChangeListener o = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.C = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.C.removeGlobalOnLayoutListener(cascadingMenuPopup.n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener p = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3

        /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CascadingMenuInfo f492a;

            /* renamed from: b */
            final /* synthetic */ MenuItem f493b;

            /* renamed from: c */
            final /* synthetic */ MenuBuilder f494c;

            AnonymousClass1(CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem, MenuBuilder menuBuilder) {
                cascadingMenuInfo = cascadingMenuInfo;
                menuItem = menuItem;
                menuBuilder = menuBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                if (cascadingMenuInfo != null) {
                    CascadingMenuPopup.this.E = true;
                    cascadingMenuInfo.menu.close(false);
                    CascadingMenuPopup.this.E = false;
                }
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    menuBuilder.performItemAction(menuItem, 4);
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.k.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.m.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.m.get(i2).menu) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            CascadingMenuPopup.this.k.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1

                /* renamed from: a */
                final /* synthetic */ CascadingMenuInfo f492a;

                /* renamed from: b */
                final /* synthetic */ MenuItem f493b;

                /* renamed from: c */
                final /* synthetic */ MenuBuilder f494c;

                AnonymousClass1(CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem2, MenuBuilder menuBuilder2) {
                    cascadingMenuInfo = cascadingMenuInfo;
                    menuItem = menuItem2;
                    menuBuilder = menuBuilder2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                    if (cascadingMenuInfo != null) {
                        CascadingMenuPopup.this.E = true;
                        cascadingMenuInfo.menu.close(false);
                        CascadingMenuPopup.this.E = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, 4);
                    }
                }
            }, menuBuilder2, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.k.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private int q = 0;
    private int r = 0;
    private boolean z = false;
    private int u = i();

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.isShowing() || CascadingMenuPopup.this.m.size() <= 0 || CascadingMenuPopup.this.m.get(0).window.isModal()) {
                return;
            }
            View view = CascadingMenuPopup.this.t;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator<CascadingMenuInfo> it = CascadingMenuPopup.this.m.iterator();
            while (it.hasNext()) {
                it.next().window.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$2 */
    class AnonymousClass2 implements View.OnAttachStateChangeListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.C;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.C = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.C.removeGlobalOnLayoutListener(cascadingMenuPopup.n);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$3 */
    class AnonymousClass3 implements MenuItemHoverListener {

        /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ CascadingMenuInfo f492a;

            /* renamed from: b */
            final /* synthetic */ MenuItem f493b;

            /* renamed from: c */
            final /* synthetic */ MenuBuilder f494c;

            AnonymousClass1(CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem2, MenuBuilder menuBuilder2) {
                cascadingMenuInfo = cascadingMenuInfo;
                menuItem = menuItem2;
                menuBuilder = menuBuilder2;
            }

            @Override // java.lang.Runnable
            public void run() {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                if (cascadingMenuInfo != null) {
                    CascadingMenuPopup.this.E = true;
                    cascadingMenuInfo.menu.close(false);
                    CascadingMenuPopup.this.E = false;
                }
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    menuBuilder.performItemAction(menuItem, 4);
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder2, @NonNull MenuItem menuItem2) {
            CascadingMenuPopup.this.k.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.m.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (menuBuilder2 == CascadingMenuPopup.this.m.get(i2).menu) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            CascadingMenuPopup.this.k.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1

                /* renamed from: a */
                final /* synthetic */ CascadingMenuInfo f492a;

                /* renamed from: b */
                final /* synthetic */ MenuItem f493b;

                /* renamed from: c */
                final /* synthetic */ MenuBuilder f494c;

                AnonymousClass1(CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem22, MenuBuilder menuBuilder22) {
                    cascadingMenuInfo = cascadingMenuInfo;
                    menuItem = menuItem22;
                    menuBuilder = menuBuilder22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                    if (cascadingMenuInfo != null) {
                        CascadingMenuPopup.this.E = true;
                        cascadingMenuInfo.menu.close(false);
                        CascadingMenuPopup.this.E = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, 4);
                    }
                }
            }, menuBuilder22, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.k.removeCallbacksAndMessages(menuBuilder);
        }
    }

    private static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i2) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i2;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i2, @StyleRes int i3, boolean z) {
        this.f484f = context;
        this.s = view;
        this.f486h = i2;
        this.f487i = i3;
        this.f488j = z;
        Resources resources = context.getResources();
        this.f485g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.k = new Handler();
    }

    private MenuPopupWindow e() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f484f, null, this.f486h, this.f487i);
        menuPopupWindow.setHoverListener(this.p);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.s);
        menuPopupWindow.setDropDownGravity(this.r);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int f(@NonNull MenuBuilder menuBuilder) {
        int size = this.m.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (menuBuilder == this.m.get(i2).menu) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem g(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menuBuilder.getItem(i2);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    private View h(@NonNull CascadingMenuInfo cascadingMenuInfo, @NonNull MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i2;
        int firstVisiblePosition;
        MenuItem g2 = g(cascadingMenuInfo.menu, menuBuilder);
        if (g2 == null) {
            return null;
        }
        ListView listView = cascadingMenuInfo.getListView();
        ListAdapter adapter = listView.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i2 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (g2 == menuAdapter.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - listView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listView.getChildCount()) {
            return listView.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int i() {
        return ViewCompat.getLayoutDirection(this.s) == 1 ? 0 : 1;
    }

    private int j(int i2) {
        List<CascadingMenuInfo> list = this.m;
        ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.t.getWindowVisibleDisplayFrame(rect);
        return this.u == 1 ? (iArr[0] + listView.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void k(@NonNull MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View view;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f484f);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f488j, f480b);
        if (!isShowing() && this.z) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(MenuPopup.c(menuBuilder));
        }
        int b2 = MenuPopup.b(menuAdapter, null, this.f484f, this.f485g);
        MenuPopupWindow e2 = e();
        e2.setAdapter(menuAdapter);
        e2.setContentWidth(b2);
        e2.setDropDownGravity(this.r);
        if (this.m.size() > 0) {
            List<CascadingMenuInfo> list = this.m;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = h(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            e2.setTouchModal(false);
            e2.setEnterTransition(null);
            int j2 = j(b2);
            boolean z = j2 == 1;
            this.u = j2;
            if (Build.VERSION.SDK_INT >= 26) {
                e2.setAnchorView(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.s.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.r & 7) == 5) {
                    iArr[0] = iArr[0] + this.s.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.r & 5) == 5) {
                if (!z) {
                    b2 = view.getWidth();
                    i4 = i2 - b2;
                }
                i4 = i2 + b2;
            } else {
                if (z) {
                    b2 = view.getWidth();
                    i4 = i2 + b2;
                }
                i4 = i2 - b2;
            }
            e2.setHorizontalOffset(i4);
            e2.setOverlapAnchor(true);
            e2.setVerticalOffset(i3);
        } else {
            if (this.v) {
                e2.setHorizontalOffset(this.x);
            }
            if (this.w) {
                e2.setVerticalOffset(this.y);
            }
            e2.setEpicenterBounds(getEpicenterBounds());
        }
        this.m.add(new CascadingMenuInfo(e2, menuBuilder, this.u));
        e2.show();
        ListView listView = e2.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.A && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            e2.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    protected boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f484f);
        if (isShowing()) {
            k(menuBuilder);
        } else {
            this.l.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.m.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.m.toArray(new CascadingMenuInfo[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i2];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.m.isEmpty()) {
            return null;
        }
        return this.m.get(r0.size() - 1).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.m.size() > 0 && this.m.get(0).window.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int f2 = f(menuBuilder);
        if (f2 < 0) {
            return;
        }
        int i2 = f2 + 1;
        if (i2 < this.m.size()) {
            this.m.get(i2).menu.close(false);
        }
        CascadingMenuInfo remove = this.m.remove(f2);
        remove.menu.removeMenuPresenter(this);
        if (this.E) {
            remove.window.setExitTransition(null);
            remove.window.setAnimationStyle(0);
        }
        remove.window.dismiss();
        int size = this.m.size();
        if (size > 0) {
            this.u = this.m.get(size - 1).position;
        } else {
            this.u = i();
        }
        if (size != 0) {
            if (z) {
                this.m.get(0).menu.close(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.B;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.C;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.C.removeGlobalOnLayoutListener(this.n);
            }
            this.C = null;
        }
        this.t.removeOnAttachStateChangeListener(this.o);
        this.D.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.m.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.m.get(i2);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            } else {
                i2++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
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
        for (CascadingMenuInfo cascadingMenuInfo : this.m) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.getListView().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.B;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@NonNull View view) {
        if (this.s != view) {
            this.s = view;
            this.r = GravityCompat.getAbsoluteGravity(this.q, ViewCompat.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.B = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.z = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            this.r = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this.s));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i2) {
        this.v = true;
        this.x = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.D = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.A = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i2) {
        this.w = true;
        this.y = i2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing()) {
            return;
        }
        Iterator<MenuBuilder> it = this.l.iterator();
        while (it.hasNext()) {
            k(it.next());
        }
        this.l.clear();
        View view = this.s;
        this.t = view;
        if (view != null) {
            boolean z = this.C == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.C = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.n);
            }
            this.t.addOnAttachStateChangeListener(this.o);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        Iterator<CascadingMenuInfo> it = this.m.iterator();
        while (it.hasNext()) {
            MenuPopup.d(it.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
