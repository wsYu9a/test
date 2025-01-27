package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: classes.dex */
public class PopupMenu {

    /* renamed from: a */
    private final Context f865a;

    /* renamed from: b */
    private final MenuBuilder f866b;

    /* renamed from: c */
    private final View f867c;

    /* renamed from: d */
    final MenuPopupHelper f868d;

    /* renamed from: e */
    OnMenuItemClickListener f869e;

    /* renamed from: f */
    OnDismissListener f870f;

    /* renamed from: g */
    private View.OnTouchListener f871g;

    /* renamed from: androidx.appcompat.widget.PopupMenu$1 */
    class AnonymousClass1 implements MenuBuilder.Callback {
        AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f869e;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$2 */
    class AnonymousClass2 implements PopupWindow.OnDismissListener {
        AnonymousClass2() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupMenu popupMenu = PopupMenu.this;
            OnDismissListener onDismissListener = popupMenu.f870f;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(popupMenu);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$3 */
    class AnonymousClass3 extends ForwardingListener {
        AnonymousClass3(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return PopupMenu.this.f868d.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }
    }

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    ListView a() {
        if (this.f868d.isShowing()) {
            return this.f868d.getListView();
        }
        return null;
    }

    public void dismiss() {
        this.f868d.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.f871g == null) {
            this.f871g = new ForwardingListener(this.f867c) { // from class: androidx.appcompat.widget.PopupMenu.3
                AnonymousClass3(View view) {
                    super(view);
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.f868d.getPopup();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.f871g;
    }

    public int getGravity() {
        return this.f868d.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.f866b;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f865a);
    }

    public void inflate(@MenuRes int i2) {
        getMenuInflater().inflate(i2, this.f866b);
    }

    public void setGravity(int i2) {
        this.f868d.setGravity(i2);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.f870f = onDismissListener;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.f869e = onMenuItemClickListener;
    }

    public void show() {
        this.f868d.show();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i2) {
        this(context, view, i2, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i2, @AttrRes int i3, @StyleRes int i4) {
        this.f865a = context;
        this.f867c = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f866b = menuBuilder;
        menuBuilder.setCallback(new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.PopupMenu.1
            AnonymousClass1() {
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder2, MenuItem menuItem) {
                OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f869e;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder2) {
            }
        });
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i3, i4);
        this.f868d = menuPopupHelper;
        menuPopupHelper.setGravity(i2);
        menuPopupHelper.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.PopupMenu.2
            AnonymousClass2() {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupMenu popupMenu = PopupMenu.this;
                OnDismissListener onDismissListener = popupMenu.f870f;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(popupMenu);
                }
            }
        });
    }
}
