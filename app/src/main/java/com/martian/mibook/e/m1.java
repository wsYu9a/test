package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12337a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12338b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12339c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12340d;

    /* renamed from: e */
    @NonNull
    public final View f12341e;

    /* renamed from: f */
    @NonNull
    public final TextView f12342f;

    /* renamed from: g */
    @NonNull
    public final TextView f12343g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12344h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12345i;

    private m1(@NonNull ThemeLinearLayout rootView, @NonNull ImageView bgBookrackPromote, @NonNull ThemeTextView bookrackGridBookname, @NonNull ThemeImageView bookrackGridCover, @NonNull View bookrackGridShade, @NonNull TextView bookrackGridTitleName, @NonNull TextView bookrackGridUpdateSign, @NonNull ImageView bpItemSelect, @NonNull ThemeTextView tvReadingRecord) {
        this.f12337a = rootView;
        this.f12338b = bgBookrackPromote;
        this.f12339c = bookrackGridBookname;
        this.f12340d = bookrackGridCover;
        this.f12341e = bookrackGridShade;
        this.f12342f = bookrackGridTitleName;
        this.f12343g = bookrackGridUpdateSign;
        this.f12344h = bpItemSelect;
        this.f12345i = tvReadingRecord;
    }

    @NonNull
    public static m1 a(@NonNull View rootView) {
        int i2 = R.id.bg_bookrack_promote;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_bookrack_promote);
        if (imageView != null) {
            i2 = R.id.bookrack_grid_bookname;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bookrack_grid_bookname);
            if (themeTextView != null) {
                i2 = R.id.bookrack_grid_cover;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bookrack_grid_cover);
                if (themeImageView != null) {
                    i2 = R.id.bookrack_grid_shade;
                    View findViewById = rootView.findViewById(R.id.bookrack_grid_shade);
                    if (findViewById != null) {
                        i2 = R.id.bookrack_grid_title_name;
                        TextView textView = (TextView) rootView.findViewById(R.id.bookrack_grid_title_name);
                        if (textView != null) {
                            i2 = R.id.bookrack_grid_update_sign;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.bookrack_grid_update_sign);
                            if (textView2 != null) {
                                i2 = R.id.bp_item_select;
                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bp_item_select);
                                if (imageView2 != null) {
                                    i2 = R.id.tv_reading_record;
                                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tv_reading_record);
                                    if (themeTextView2 != null) {
                                        return new m1((ThemeLinearLayout) rootView, imageView, themeTextView, themeImageView, findViewById, textView, textView2, imageView2, themeTextView2);
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
    public static m1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_grid_book_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12337a;
    }
}
