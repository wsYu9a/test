package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12865a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12866b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12867c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12868d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12869e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12870f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12871g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12872h;

    /* renamed from: i */
    @NonNull
    public final a2 f12873i;

    private w1(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout gridItemBottomView, @NonNull LinearLayout gridItemLeftView, @NonNull LinearLayout gridItemRightView, @NonNull ThemeLinearLayout gridItemRoot, @NonNull LinearLayout gridItemTopView, @NonNull LinearLayout gridItemVerticalView, @NonNull LinearLayout gridParentView, @NonNull a2 titleView) {
        this.f12865a = rootView;
        this.f12866b = gridItemBottomView;
        this.f12867c = gridItemLeftView;
        this.f12868d = gridItemRightView;
        this.f12869e = gridItemRoot;
        this.f12870f = gridItemTopView;
        this.f12871g = gridItemVerticalView;
        this.f12872h = gridParentView;
        this.f12873i = titleView;
    }

    @NonNull
    public static w1 a(@NonNull View rootView) {
        int i2 = R.id.grid_item_bottom_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.grid_item_bottom_view);
        if (linearLayout != null) {
            i2 = R.id.grid_item_left_view;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.grid_item_left_view);
            if (linearLayout2 != null) {
                i2 = R.id.grid_item_right_view;
                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.grid_item_right_view);
                if (linearLayout3 != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                    i2 = R.id.grid_item_top_view;
                    LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.grid_item_top_view);
                    if (linearLayout4 != null) {
                        i2 = R.id.grid_item_vertical_view;
                        LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.grid_item_vertical_view);
                        if (linearLayout5 != null) {
                            i2 = R.id.grid_parent_view;
                            LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.grid_parent_view);
                            if (linearLayout6 != null) {
                                i2 = R.id.title_view;
                                View findViewById = rootView.findViewById(R.id.title_view);
                                if (findViewById != null) {
                                    return new w1(themeLinearLayout, linearLayout, linearLayout2, linearLayout3, themeLinearLayout, linearLayout4, linearLayout5, linearLayout6, a2.a(findViewById));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_grid, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12865a;
    }
}
