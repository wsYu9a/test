package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final CoordinatorLayout f12886a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12887b;

    /* renamed from: c */
    @NonNull
    public final CoordinatorLayout f12888c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12889d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f12890e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f12891f;

    /* renamed from: g */
    @NonNull
    public final ThemeLinearLayout f12892g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12893h;

    /* renamed from: i */
    @NonNull
    public final ThemeLinearLayout f12894i;

    /* renamed from: j */
    @NonNull
    public final View f12895j;

    @NonNull
    public final FrameLayout k;

    @NonNull
    public final ThemeTextView l;

    @NonNull
    public final ListView m;

    private w4(@NonNull CoordinatorLayout rootView, @NonNull ThemeTextView bookChapterNumber, @NonNull CoordinatorLayout bookDetail, @NonNull ThemeImageView bookDetailClose, @NonNull RelativeLayout bookDetailHeader, @NonNull ThemeImageView bookDetailLeft, @NonNull ThemeLinearLayout bookDetailView, @NonNull ThemeTextView bookOrder, @NonNull ThemeLinearLayout bookOrderView, @NonNull View bookShadeView, @NonNull FrameLayout dirFragmentContainers, @NonNull ThemeTextView emptyText, @NonNull ListView list) {
        this.f12886a = rootView;
        this.f12887b = bookChapterNumber;
        this.f12888c = bookDetail;
        this.f12889d = bookDetailClose;
        this.f12890e = bookDetailHeader;
        this.f12891f = bookDetailLeft;
        this.f12892g = bookDetailView;
        this.f12893h = bookOrder;
        this.f12894i = bookOrderView;
        this.f12895j = bookShadeView;
        this.k = dirFragmentContainers;
        this.l = emptyText;
        this.m = list;
    }

    @NonNull
    public static w4 a(@NonNull View rootView) {
        int i2 = R.id.book_chapter_number;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_chapter_number);
        if (themeTextView != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
            i2 = R.id.book_detail_close;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.book_detail_close);
            if (themeImageView != null) {
                i2 = R.id.book_detail_header;
                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.book_detail_header);
                if (relativeLayout != null) {
                    i2 = R.id.book_detail_left;
                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.book_detail_left);
                    if (themeImageView2 != null) {
                        i2 = R.id.book_detail_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.book_detail_view);
                        if (themeLinearLayout != null) {
                            i2 = R.id.book_order;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.book_order);
                            if (themeTextView2 != null) {
                                i2 = R.id.book_order_view;
                                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.book_order_view);
                                if (themeLinearLayout2 != null) {
                                    i2 = R.id.book_shade_view;
                                    View findViewById = rootView.findViewById(R.id.book_shade_view);
                                    if (findViewById != null) {
                                        i2 = R.id.dir_fragmentContainers;
                                        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.dir_fragmentContainers);
                                        if (frameLayout != null) {
                                            i2 = R.id.empty_text;
                                            ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.empty_text);
                                            if (themeTextView3 != null) {
                                                i2 = android.R.id.list;
                                                ListView listView = (ListView) rootView.findViewById(android.R.id.list);
                                                if (listView != null) {
                                                    return new w4(coordinatorLayout, themeTextView, coordinatorLayout, themeImageView, relativeLayout, themeImageView2, themeLinearLayout, themeTextView2, themeLinearLayout2, findViewById, frameLayout, themeTextView3, listView);
                                                }
                                            }
                                        }
                                    }
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
    public static w4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_reader_dir, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f12886a;
    }
}
