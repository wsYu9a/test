package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12157a;

    /* renamed from: b */
    @NonNull
    public final View f12158b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12159c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12160d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12161e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12162f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12163g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12164h;

    /* renamed from: i */
    @NonNull
    public final ThemeLinearLayout f12165i;

    /* renamed from: j */
    @NonNull
    public final ThemeView f12166j;

    private j1(@NonNull RelativeLayout rootView, @NonNull View batchShadeView, @NonNull ThemeTextView bookrackBatchArchive, @NonNull ThemeTextView bookrackBatchBookInfo, @NonNull LinearLayout bookrackBatchBookInfoView, @NonNull ThemeTextView bookrackBatchCoverChange, @NonNull ThemeTextView bookrackBatchNameChange, @NonNull LinearLayout bookrackBatchNameView, @NonNull ThemeLinearLayout bookrackBatchShade, @NonNull ThemeView bookrackBatchTop) {
        this.f12157a = rootView;
        this.f12158b = batchShadeView;
        this.f12159c = bookrackBatchArchive;
        this.f12160d = bookrackBatchBookInfo;
        this.f12161e = bookrackBatchBookInfoView;
        this.f12162f = bookrackBatchCoverChange;
        this.f12163g = bookrackBatchNameChange;
        this.f12164h = bookrackBatchNameView;
        this.f12165i = bookrackBatchShade;
        this.f12166j = bookrackBatchTop;
    }

    @NonNull
    public static j1 a(@NonNull View rootView) {
        int i2 = R.id.batch_shade_view;
        View findViewById = rootView.findViewById(R.id.batch_shade_view);
        if (findViewById != null) {
            i2 = R.id.bookrack_batch_archive;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bookrack_batch_archive);
            if (themeTextView != null) {
                i2 = R.id.bookrack_batch_book_info;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bookrack_batch_book_info);
                if (themeTextView2 != null) {
                    i2 = R.id.bookrack_batch_book_info_view;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bookrack_batch_book_info_view);
                    if (linearLayout != null) {
                        i2 = R.id.bookrack_batch_cover_change;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bookrack_batch_cover_change);
                        if (themeTextView3 != null) {
                            i2 = R.id.bookrack_batch_name_change;
                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.bookrack_batch_name_change);
                            if (themeTextView4 != null) {
                                i2 = R.id.bookrack_batch_name_view;
                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.bookrack_batch_name_view);
                                if (linearLayout2 != null) {
                                    i2 = R.id.bookrack_batch_shade;
                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bookrack_batch_shade);
                                    if (themeLinearLayout != null) {
                                        i2 = R.id.bookrack_batch_top;
                                        ThemeView themeView = (ThemeView) rootView.findViewById(R.id.bookrack_batch_top);
                                        if (themeView != null) {
                                            return new j1((RelativeLayout) rootView, findViewById, themeTextView, themeTextView2, linearLayout, themeTextView3, themeTextView4, linearLayout2, themeLinearLayout, themeView);
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
    public static j1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_batch_more_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12157a;
    }
}
