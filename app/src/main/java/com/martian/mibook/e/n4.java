package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class n4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12423a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12424b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12425c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12426d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeItemTextView f12427e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12428f;

    /* renamed from: g */
    @NonNull
    public final TextView f12429g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12430h;

    private n4(@NonNull LinearLayout rootView, @NonNull ImageView tfPreview, @NonNull ThemeTextView tfStatus, @NonNull ImageView tfUseChecked, @NonNull ReaderThemeItemTextView tfUseStatus, @NonNull LinearLayout typeFaceItem, @NonNull TextView typeFaceName, @NonNull ReaderThemeTextView typeFaceSize) {
        this.f12423a = rootView;
        this.f12424b = tfPreview;
        this.f12425c = tfStatus;
        this.f12426d = tfUseChecked;
        this.f12427e = tfUseStatus;
        this.f12428f = typeFaceItem;
        this.f12429g = typeFaceName;
        this.f12430h = typeFaceSize;
    }

    @NonNull
    public static n4 a(@NonNull View rootView) {
        int i2 = R.id.tf_preview;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.tf_preview);
        if (imageView != null) {
            i2 = R.id.tf_status;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tf_status);
            if (themeTextView != null) {
                i2 = R.id.tf_use_checked;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tf_use_checked);
                if (imageView2 != null) {
                    i2 = R.id.tf_use_status;
                    ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.tf_use_status);
                    if (readerThemeItemTextView != null) {
                        i2 = R.id.type_face_item;
                        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.type_face_item);
                        if (linearLayout != null) {
                            i2 = R.id.type_face_name;
                            TextView textView = (TextView) rootView.findViewById(R.id.type_face_name);
                            if (textView != null) {
                                i2 = R.id.type_face_size;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.type_face_size);
                                if (readerThemeTextView != null) {
                                    return new n4((LinearLayout) rootView, imageView, themeTextView, imageView2, readerThemeItemTextView, linearLayout, textView, readerThemeTextView);
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
    public static n4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.page_item_typeface, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12423a;
    }
}
