package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11988a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11989b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f11990c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11991d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f11992e;

    /* renamed from: f */
    @NonNull
    public final RecyclerView f11993f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f11994g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f11995h;

    private g1(@NonNull LinearLayout rootView, @NonNull LinearLayout bookCategoryBottomView, @NonNull LinearLayout bookCategoryItem, @NonNull LinearLayout bookCategoryTopView, @NonNull LinearLayout bookRankView, @NonNull RecyclerView rankCategoryIrc, @NonNull LinearLayout rankItemLeftView, @NonNull LinearLayout rankItemRightView) {
        this.f11988a = rootView;
        this.f11989b = bookCategoryBottomView;
        this.f11990c = bookCategoryItem;
        this.f11991d = bookCategoryTopView;
        this.f11992e = bookRankView;
        this.f11993f = rankCategoryIrc;
        this.f11994g = rankItemLeftView;
        this.f11995h = rankItemRightView;
    }

    @NonNull
    public static g1 a(@NonNull View rootView) {
        int i2 = R.id.book_category_bottom_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.book_category_bottom_view);
        if (linearLayout != null) {
            i2 = R.id.book_category_item;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.book_category_item);
            if (linearLayout2 != null) {
                i2 = R.id.book_category_top_view;
                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.book_category_top_view);
                if (linearLayout3 != null) {
                    i2 = R.id.book_rank_view;
                    LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.book_rank_view);
                    if (linearLayout4 != null) {
                        i2 = R.id.rank_category_irc;
                        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rank_category_irc);
                        if (recyclerView != null) {
                            i2 = R.id.rank_item_left_view;
                            LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.rank_item_left_view);
                            if (linearLayout5 != null) {
                                i2 = R.id.rank_item_right_view;
                                LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.rank_item_right_view);
                                if (linearLayout6 != null) {
                                    return new g1((LinearLayout) rootView, linearLayout, linearLayout2, linearLayout3, linearLayout4, recyclerView, linearLayout5, linearLayout6);
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
    public static g1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookmall_category_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11988a;
    }
}
