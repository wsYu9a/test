package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11712a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11713b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11714c;

    /* renamed from: d */
    @NonNull
    public final TextView f11715d;

    private a7(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout searchTagBooks, @NonNull ThemeTextView searchTagName, @NonNull TextView searchTagType) {
        this.f11712a = rootView;
        this.f11713b = searchTagBooks;
        this.f11714c = searchTagName;
        this.f11715d = searchTagType;
    }

    @NonNull
    public static a7 a(@NonNull View rootView) {
        int i2 = R.id.search_tag_books;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.search_tag_books);
        if (themeLinearLayout != null) {
            i2 = R.id.search_tag_name;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.search_tag_name);
            if (themeTextView != null) {
                i2 = R.id.search_tag_type;
                TextView textView = (TextView) rootView.findViewById(R.id.search_tag_type);
                if (textView != null) {
                    return new a7((ThemeLinearLayout) rootView, themeLinearLayout, themeTextView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_tag_books, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11712a;
    }
}
