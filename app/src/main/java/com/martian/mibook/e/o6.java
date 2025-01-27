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
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12491a;

    /* renamed from: b */
    @NonNull
    public final View f12492b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeLinearLayout f12493c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12494d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeLinearLayout f12495e;

    /* renamed from: f */
    @NonNull
    public final TextView f12496f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeLinearLayout f12497g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12498h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeImageView f12499i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeLinearLayout f12500j;

    private o6(@NonNull RelativeLayout rootView, @NonNull View actionbarTopView, @NonNull ReaderThemeLinearLayout moreItemView, @NonNull LinearLayout topView, @NonNull ReaderThemeLinearLayout tvCacheMode, @NonNull TextView tvReadingTitle, @NonNull ReaderThemeLinearLayout tvTtsMode, @NonNull ReaderThemeTextView tvVip, @NonNull ReaderThemeImageView tvVipIcon, @NonNull ReaderThemeLinearLayout tvVipView) {
        this.f12491a = rootView;
        this.f12492b = actionbarTopView;
        this.f12493c = moreItemView;
        this.f12494d = topView;
        this.f12495e = tvCacheMode;
        this.f12496f = tvReadingTitle;
        this.f12497g = tvTtsMode;
        this.f12498h = tvVip;
        this.f12499i = tvVipIcon;
        this.f12500j = tvVipView;
    }

    @NonNull
    public static o6 a(@NonNull View rootView) {
        int i2 = R.id.actionbar_top_view;
        View findViewById = rootView.findViewById(R.id.actionbar_top_view);
        if (findViewById != null) {
            i2 = R.id.more_item_view;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.more_item_view);
            if (readerThemeLinearLayout != null) {
                i2 = R.id.top_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.top_view);
                if (linearLayout != null) {
                    i2 = R.id.tv_cache_mode;
                    ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.tv_cache_mode);
                    if (readerThemeLinearLayout2 != null) {
                        i2 = R.id.tv_reading_title;
                        TextView textView = (TextView) rootView.findViewById(R.id.tv_reading_title);
                        if (textView != null) {
                            i2 = R.id.tv_tts_mode;
                            ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.tv_tts_mode);
                            if (readerThemeLinearLayout3 != null) {
                                i2 = R.id.tv_vip;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_vip);
                                if (readerThemeTextView != null) {
                                    i2 = R.id.tv_vip_icon;
                                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.tv_vip_icon);
                                    if (readerThemeImageView != null) {
                                        i2 = R.id.tv_vip_view;
                                        ReaderThemeLinearLayout readerThemeLinearLayout4 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.tv_vip_view);
                                        if (readerThemeLinearLayout4 != null) {
                                            return new o6((RelativeLayout) rootView, findViewById, readerThemeLinearLayout, linearLayout, readerThemeLinearLayout2, textView, readerThemeLinearLayout3, readerThemeTextView, readerThemeImageView, readerThemeLinearLayout4);
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
    public static o6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_top_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12491a;
    }
}
