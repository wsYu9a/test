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
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12827a;

    /* renamed from: b */
    @NonNull
    public final ThemeEditText f12828b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12829c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12830d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12831e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12832f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12833g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12834h;

    /* renamed from: i */
    @NonNull
    public final View f12835i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12836j;

    @NonNull
    public final ThemeImageView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final ThemeLinearLayout m;

    private v4(@NonNull RelativeLayout rootView, @NonNull ThemeEditText bdEditComment, @NonNull ThemeLinearLayout bdInputView, @NonNull ImageView bdVote1, @NonNull ImageView bdVote2, @NonNull ImageView bdVote3, @NonNull ImageView bdVote4, @NonNull ImageView bdVote5, @NonNull View bottom, @NonNull ThemeTextView postCommentButton, @NonNull ThemeImageView postCommentClose, @NonNull TextView postCommentStatus, @NonNull ThemeLinearLayout postCommentView) {
        this.f12827a = rootView;
        this.f12828b = bdEditComment;
        this.f12829c = bdInputView;
        this.f12830d = bdVote1;
        this.f12831e = bdVote2;
        this.f12832f = bdVote3;
        this.f12833g = bdVote4;
        this.f12834h = bdVote5;
        this.f12835i = bottom;
        this.f12836j = postCommentButton;
        this.k = postCommentClose;
        this.l = postCommentStatus;
        this.m = postCommentView;
    }

    @NonNull
    public static v4 a(@NonNull View rootView) {
        int i2 = R.id.bd_edit_comment;
        ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.bd_edit_comment);
        if (themeEditText != null) {
            i2 = R.id.bd_input_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bd_input_view);
            if (themeLinearLayout != null) {
                i2 = R.id.bd_vote_1;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.bd_vote_1);
                if (imageView != null) {
                    i2 = R.id.bd_vote_2;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bd_vote_2);
                    if (imageView2 != null) {
                        i2 = R.id.bd_vote_3;
                        ImageView imageView3 = (ImageView) rootView.findViewById(R.id.bd_vote_3);
                        if (imageView3 != null) {
                            i2 = R.id.bd_vote_4;
                            ImageView imageView4 = (ImageView) rootView.findViewById(R.id.bd_vote_4);
                            if (imageView4 != null) {
                                i2 = R.id.bd_vote_5;
                                ImageView imageView5 = (ImageView) rootView.findViewById(R.id.bd_vote_5);
                                if (imageView5 != null) {
                                    i2 = R.id.bottom;
                                    View findViewById = rootView.findViewById(R.id.bottom);
                                    if (findViewById != null) {
                                        i2 = R.id.post_comment_button;
                                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.post_comment_button);
                                        if (themeTextView != null) {
                                            i2 = R.id.post_comment_close;
                                            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.post_comment_close);
                                            if (themeImageView != null) {
                                                i2 = R.id.post_comment_status;
                                                TextView textView = (TextView) rootView.findViewById(R.id.post_comment_status);
                                                if (textView != null) {
                                                    i2 = R.id.post_comment_view;
                                                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.post_comment_view);
                                                    if (themeLinearLayout2 != null) {
                                                        return new v4((RelativeLayout) rootView, themeEditText, themeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, findViewById, themeTextView, themeImageView, textView, themeLinearLayout2);
                                                    }
                                                }
                                            }
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
    public static v4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_post_comment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12827a;
    }
}
