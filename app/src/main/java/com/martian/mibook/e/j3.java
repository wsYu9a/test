package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12177a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12178b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeImageView f12179c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeLinearLayout f12180d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12181e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12182f;

    /* renamed from: g */
    @NonNull
    public final ListView f12183g;

    private j3(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView dirCategory, @NonNull ReaderThemeImageView dirCategoryIconLeft, @NonNull ReaderThemeLinearLayout dirCategoryView, @NonNull ReaderThemeTextView dirNumbers, @NonNull ThemeTextView emptyText, @NonNull ListView list) {
        this.f12177a = rootView;
        this.f12178b = dirCategory;
        this.f12179c = dirCategoryIconLeft;
        this.f12180d = dirCategoryView;
        this.f12181e = dirNumbers;
        this.f12182f = emptyText;
        this.f12183g = list;
    }

    @NonNull
    public static j3 a(@NonNull View rootView) {
        int i2 = R.id.dir_category;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.dir_category);
        if (readerThemeTextView != null) {
            i2 = R.id.dir_category_icon_left;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.dir_category_icon_left);
            if (readerThemeImageView != null) {
                i2 = R.id.dir_category_view;
                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.dir_category_view);
                if (readerThemeLinearLayout != null) {
                    i2 = R.id.dir_numbers;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.dir_numbers);
                    if (readerThemeTextView2 != null) {
                        i2 = R.id.empty_text;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.empty_text);
                        if (themeTextView != null) {
                            i2 = android.R.id.list;
                            ListView listView = (ListView) rootView.findViewById(android.R.id.list);
                            if (listView != null) {
                                return new j3((LinearLayout) rootView, readerThemeTextView, readerThemeImageView, readerThemeLinearLayout, readerThemeTextView2, themeTextView, listView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_reading_dir, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12177a;
    }
}
