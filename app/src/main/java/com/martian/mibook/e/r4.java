package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12611a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12612b;

    /* renamed from: c */
    @NonNull
    public final TextView f12613c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12614d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12615e;

    /* renamed from: f */
    @NonNull
    public final TextView f12616f;

    /* renamed from: g */
    @NonNull
    public final TextView f12617g;

    private r4(@NonNull RelativeLayout rootView, @NonNull ImageView bgFresh, @NonNull TextView grabMoney, @NonNull ImageView rdClose, @NonNull ImageView rdGrab, @NonNull TextView rdHint, @NonNull TextView rdTitle) {
        this.f12611a = rootView;
        this.f12612b = bgFresh;
        this.f12613c = grabMoney;
        this.f12614d = rdClose;
        this.f12615e = rdGrab;
        this.f12616f = rdHint;
        this.f12617g = rdTitle;
    }

    @NonNull
    public static r4 a(@NonNull View rootView) {
        int i2 = R.id.bg_fresh;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bg_fresh);
        if (imageView != null) {
            i2 = R.id.grab_money;
            TextView textView = (TextView) rootView.findViewById(R.id.grab_money);
            if (textView != null) {
                i2 = R.id.rd_close;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.rd_close);
                if (imageView2 != null) {
                    i2 = R.id.rd_grab;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.rd_grab);
                    if (imageView3 != null) {
                        i2 = R.id.rd_hint;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.rd_hint);
                        if (textView2 != null) {
                            i2 = R.id.rd_title;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.rd_title);
                            if (textView3 != null) {
                                return new r4((RelativeLayout) rootView, imageView, textView, imageView2, imageView3, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_freshgrabed_background, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12611a;
    }
}
