package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.internal.h;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a implements MenuPresenter {

    /* renamed from: a */
    private MenuBuilder f6822a;

    /* renamed from: b */
    private BottomNavigationMenuView f6823b;

    /* renamed from: c */
    private boolean f6824c = false;

    /* renamed from: d */
    private int f6825d;

    /* renamed from: com.google.android.material.bottomnavigation.a$a */
    static class C0081a implements Parcelable {
        public static final Parcelable.Creator<C0081a> CREATOR = new C0082a();

        /* renamed from: a */
        int f6826a;

        /* renamed from: b */
        @Nullable
        h f6827b;

        /* renamed from: com.google.android.material.bottomnavigation.a$a$a */
        static class C0082a implements Parcelable.Creator<C0081a> {
            C0082a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public C0081a createFromParcel(@NonNull Parcel parcel) {
                return new C0081a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public C0081a[] newArray(int i2) {
                return new C0081a[i2];
            }
        }

        C0081a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.f6826a);
            parcel.writeParcelable(this.f6827b, 0);
        }

        C0081a(@NonNull Parcel parcel) {
            this.f6826a = parcel.readInt();
            this.f6827b = (h) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f6823b = bottomNavigationMenuView;
    }

    public void b(int i2) {
        this.f6825d = i2;
    }

    public void c(boolean z) {
        this.f6824c = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f6825d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.f6823b;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f6822a = menuBuilder;
        this.f6823b.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0081a) {
            C0081a c0081a = (C0081a) parcelable;
            this.f6823b.m(c0081a.f6826a);
            this.f6823b.setBadgeDrawables(com.google.android.material.badge.a.b(this.f6823b.getContext(), c0081a.f6827b));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        C0081a c0081a = new C0081a();
        c0081a.f6826a = this.f6823b.getSelectedItemId();
        c0081a.f6827b = com.google.android.material.badge.a.c(this.f6823b.getBadgeDrawables());
        return c0081a;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.f6824c) {
            return;
        }
        if (z) {
            this.f6823b.c();
        } else {
            this.f6823b.n();
        }
    }
}
