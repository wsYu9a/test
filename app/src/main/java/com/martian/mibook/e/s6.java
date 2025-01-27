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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12692a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12693b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12694c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12695d;

    /* renamed from: e */
    @NonNull
    public final TextView f12696e;

    /* renamed from: f */
    @NonNull
    public final TextView f12697f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12698g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12699h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12700i;

    private s6(@NonNull LinearLayout rootView, @NonNull LinearLayout remoteviewMainView, @NonNull ImageView ttsClose, @NonNull ImageView ttsCover, @NonNull TextView ttsDesc, @NonNull TextView ttsName, @NonNull ImageView ttsNextChapter, @NonNull ImageView ttsPlay, @NonNull ImageView ttsPreChapter) {
        this.f12692a = rootView;
        this.f12693b = remoteviewMainView;
        this.f12694c = ttsClose;
        this.f12695d = ttsCover;
        this.f12696e = ttsDesc;
        this.f12697f = ttsName;
        this.f12698g = ttsNextChapter;
        this.f12699h = ttsPlay;
        this.f12700i = ttsPreChapter;
    }

    @NonNull
    public static s6 a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.tts_close;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.tts_close);
        if (imageView != null) {
            i2 = R.id.tts_cover;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tts_cover);
            if (imageView2 != null) {
                i2 = R.id.tts_desc;
                TextView textView = (TextView) rootView.findViewById(R.id.tts_desc);
                if (textView != null) {
                    i2 = R.id.tts_name;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.tts_name);
                    if (textView2 != null) {
                        i2 = R.id.tts_next_chapter;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tts_next_chapter);
                        if (imageView3 != null) {
                            i2 = R.id.tts_play;
                            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.tts_play);
                            if (imageView4 != null) {
                                i2 = R.id.tts_pre_chapter;
                                ImageView imageView5 = (ImageView) rootView.findViewById(R.id.tts_pre_chapter);
                                if (imageView5 != null) {
                                    return new s6((LinearLayout) rootView, linearLayout, imageView, imageView2, textView, textView2, imageView3, imageView4, imageView5);
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
    public static s6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.remoteview_book_tts_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12692a;
    }
}
