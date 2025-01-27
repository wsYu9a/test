package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a */
    private static final int f565a = 48;

    /* renamed from: b */
    private final Context f566b;

    /* renamed from: c */
    private final MenuBuilder f567c;

    /* renamed from: d */
    private final boolean f568d;

    /* renamed from: e */
    private final int f569e;

    /* renamed from: f */
    private final int f570f;

    /* renamed from: g */
    private View f571g;

    /* renamed from: h */
    private int f572h;

    /* renamed from: i */
    private boolean f573i;

    /* renamed from: j */
    private MenuPresenter.Callback f574j;
    private MenuPopup k;
    private PopupWindow.OnDismissListener l;
    private final PopupWindow.OnDismissListener m;

    /* renamed from: androidx.appcompat.view.menu.MenuPopupHelper$1 */
    class AnonymousClass1 implements PopupWindow.OnDismissListener {
        AnonymousClass1() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MenuPopupHelper.this.b();
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    @NonNull
    private MenuPopup a() {
        Display defaultDisplay = ((WindowManager) this.f566b.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        MenuPopup cascadingMenuPopup = Math.min(point.x, point.y) >= this.f566b.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f566b, this.f571g, this.f569e, this.f570f, this.f568d) : new StandardMenuPopup(this.f566b, this.f567c, this.f571g, this.f569e, this.f570f, this.f568d);
        cascadingMenuPopup.addMenu(this.f567c);
        cascadingMenuPopup.setOnDismissListener(this.m);
        cascadingMenuPopup.setAnchorView(this.f571g);
        cascadingMenuPopup.setCallback(this.f574j);
        cascadingMenuPopup.setForceShowIcon(this.f573i);
        cascadingMenuPopup.setGravity(this.f572h);
        return cascadingMenuPopup;
    }

    private void c(int i2, int i3, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.f572h, ViewCompat.getLayoutDirection(this.f571g)) & 7) == 5) {
                i2 -= this.f571g.getWidth();
            }
            popup.setHorizontalOffset(i2);
            popup.setVerticalOffset(i3);
            int i4 = (int) ((this.f566b.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        popup.show();
    }

    protected void b() {
        this.k = null;
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.k.dismiss();
        }
    }

    public int getGravity() {
        return this.f572h;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    public MenuPopup getPopup() {
        if (this.k == null) {
            this.k = a();
        }
        return this.k;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.k;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void setAnchorView(@NonNull View view) {
        this.f571g = view;
    }

    public void setForceShowIcon(boolean z) {
        this.f573i = z;
        MenuPopup menuPopup = this.k;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i2) {
        this.f572h = i2;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.f574j = callback;
        MenuPopup menuPopup = this.k;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f571g == null) {
            return false;
        }
        c(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2) {
        this(context, menuBuilder, view, z, i2, 0);
    }

    public void show(int i2, int i3) {
        if (!tryShow(i2, i3)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2, @StyleRes int i3) {
        this.f572h = 8388611;
        this.m = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            AnonymousClass1() {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.b();
            }
        };
        this.f566b = context;
        this.f567c = menuBuilder;
        this.f571g = view;
        this.f568d = z;
        this.f569e = i2;
        this.f570f = i3;
    }

    public boolean tryShow(int i2, int i3) {
        if (isShowing()) {
            return true;
        }
        if (this.f571g == null) {
            return false;
        }
        c(i2, i3, true, true);
        return true;
    }
}
