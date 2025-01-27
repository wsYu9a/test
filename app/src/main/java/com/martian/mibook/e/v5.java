package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.colorpicker.LineColorPicker;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12837a;

    /* renamed from: b */
    @NonNull
    public final LineColorPicker f12838b;

    /* renamed from: c */
    @NonNull
    public final LineColorPicker f12839c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeLinearLayout f12840d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeItemTextView f12841e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeItemTextView f12842f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeItemTextView f12843g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeItemTextView f12844h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12845i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12846j;

    private v5(@NonNull RelativeLayout rootView, @NonNull LineColorPicker colorPickerPrimary, @NonNull LineColorPicker colorPickerPrimary2, @NonNull ReaderThemeLinearLayout cpBackground, @NonNull ReaderThemeItemTextView cpBd1, @NonNull ReaderThemeItemTextView cpBd2, @NonNull ReaderThemeItemTextView cpClose, @NonNull ReaderThemeItemTextView cpConfirm, @NonNull ImageView cpImage1, @NonNull ImageView cpImage2) {
        this.f12837a = rootView;
        this.f12838b = colorPickerPrimary;
        this.f12839c = colorPickerPrimary2;
        this.f12840d = cpBackground;
        this.f12841e = cpBd1;
        this.f12842f = cpBd2;
        this.f12843g = cpClose;
        this.f12844h = cpConfirm;
        this.f12845i = cpImage1;
        this.f12846j = cpImage2;
    }

    @NonNull
    public static v5 a(@NonNull View rootView) {
        int i2 = R.id.color_picker_primary;
        LineColorPicker lineColorPicker = (LineColorPicker) rootView.findViewById(R.id.color_picker_primary);
        if (lineColorPicker != null) {
            i2 = R.id.color_picker_primary_2;
            LineColorPicker lineColorPicker2 = (LineColorPicker) rootView.findViewById(R.id.color_picker_primary_2);
            if (lineColorPicker2 != null) {
                i2 = R.id.cp_background;
                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.cp_background);
                if (readerThemeLinearLayout != null) {
                    i2 = R.id.cp_bd1;
                    ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.cp_bd1);
                    if (readerThemeItemTextView != null) {
                        i2 = R.id.cp_bd2;
                        ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.cp_bd2);
                        if (readerThemeItemTextView2 != null) {
                            i2 = R.id.cp_close;
                            ReaderThemeItemTextView readerThemeItemTextView3 = (ReaderThemeItemTextView) rootView.findViewById(R.id.cp_close);
                            if (readerThemeItemTextView3 != null) {
                                i2 = R.id.cp_confirm;
                                ReaderThemeItemTextView readerThemeItemTextView4 = (ReaderThemeItemTextView) rootView.findViewById(R.id.cp_confirm);
                                if (readerThemeItemTextView4 != null) {
                                    i2 = R.id.cp_image1;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.cp_image1);
                                    if (imageView != null) {
                                        i2 = R.id.cp_image2;
                                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.cp_image2);
                                        if (imageView2 != null) {
                                            return new v5((RelativeLayout) rootView, lineColorPicker, lineColorPicker2, readerThemeLinearLayout, readerThemeItemTextView, readerThemeItemTextView2, readerThemeItemTextView3, readerThemeItemTextView4, imageView, imageView2);
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
    public static v5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_colorpicker, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12837a;
    }
}
