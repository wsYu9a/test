package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12644a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12645b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f12646c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12647d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f12648e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12649f;

    /* renamed from: g */
    @NonNull
    public final TextView f12650g;

    private s0(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout gridItemView, @NonNull RelativeLayout gridViewCover, @NonNull ThemeTextView rdBookAuthorName, @NonNull ThemeImageView rdBookCover, @NonNull ThemeTextView rdBookName, @NonNull TextView rdBookScore) {
        this.f12644a = rootView;
        this.f12645b = gridItemView;
        this.f12646c = gridViewCover;
        this.f12647d = rdBookAuthorName;
        this.f12648e = rdBookCover;
        this.f12649f = rdBookName;
        this.f12650g = rdBookScore;
    }

    @NonNull
    public static s0 a(@NonNull View rootView) {
        int i2 = R.id.grid_item_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.grid_item_view);
        if (linearLayout != null) {
            i2 = R.id.grid_view_cover;
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.grid_view_cover);
            if (relativeLayout != null) {
                i2 = R.id.rd_book_author_name;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.rd_book_author_name);
                if (themeTextView != null) {
                    i2 = R.id.rd_book_cover;
                    ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.rd_book_cover);
                    if (themeImageView != null) {
                        i2 = R.id.rd_book_name;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.rd_book_name);
                        if (themeTextView2 != null) {
                            i2 = R.id.rd_book_score;
                            TextView textView = (TextView) rootView.findViewById(R.id.rd_book_score);
                            if (textView != null) {
                                return new s0((ThemeLinearLayout) rootView, linearLayout, relativeLayout, themeTextView, themeImageView, themeTextView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_cover_reading_grid_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12644a;
    }
}
