package com.martian.mibook.fragment.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogCommentLongClickBinding;
import com.martian.mibook.fragment.dialog.CommentLongClickDialog;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002(\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/martian/mibook/fragment/dialog/CommentLongClickDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "h", "()V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "Lcom/martian/mibook/fragment/dialog/CommentLongClickDialog$b;", "onClickListener", "n", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;Lcom/martian/mibook/fragment/dialog/CommentLongClickDialog$b;)V", "g", "Landroid/view/ViewGroup;", "viewGroup", t.f11211k, "(Landroid/view/ViewGroup;)V", "Landroid/widget/FrameLayout;", "nightMask", "", "backgroundColor", "topCornerRadius", "o", "(Landroid/widget/FrameLayout;II)V", "b", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "c", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "d", "Lcom/martian/mibook/fragment/dialog/CommentLongClickDialog$b;", "Lcom/martian/mibook/databinding/DialogCommentLongClickBinding;", e.TAG, "Lcom/martian/mibook/databinding/DialogCommentLongClickBinding;", "binding", "f", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class CommentLongClickDialog extends BottomSheetDialog {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public Comment comment;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public CommentReply commentReply;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public b onClickListener;

    /* renamed from: e */
    @l
    public DialogCommentLongClickBinding binding;

    /* renamed from: com.martian.mibook.fragment.dialog.CommentLongClickDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@k Context context, @l Comment comment, @l CommentReply commentReply, @k b onClickListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            CommentLongClickDialog commentLongClickDialog = new CommentLongClickDialog(context);
            boolean A0 = MiConfigSingleton.b2().A0();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                d.r3(activity, commentLongClickDialog).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
            commentLongClickDialog.n(comment, commentReply, onClickListener);
            commentLongClickDialog.show();
        }

        public Companion() {
        }
    }

    public interface b {
        void a(@l Integer num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentLongClickDialog(@k Context context) {
        super(context, R.style.BottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        g();
        h();
    }

    private final void h() {
        ThemeTextView themeTextView;
        ThemeTextView themeTextView2;
        ThemeTextView themeTextView3;
        ThemeTextView themeTextView4;
        ThemeLinearLayout themeLinearLayout;
        DialogCommentLongClickBinding dialogCommentLongClickBinding = this.binding;
        if (dialogCommentLongClickBinding != null && (themeLinearLayout = dialogCommentLongClickBinding.llClose) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: eb.s
                public /* synthetic */ s() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentLongClickDialog.i(CommentLongClickDialog.this, view);
                }
            });
        }
        DialogCommentLongClickBinding dialogCommentLongClickBinding2 = this.binding;
        if (dialogCommentLongClickBinding2 != null && (themeTextView4 = dialogCommentLongClickBinding2.tvReply) != null) {
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: eb.t
                public /* synthetic */ t() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentLongClickDialog.j(CommentLongClickDialog.this, view);
                }
            });
        }
        DialogCommentLongClickBinding dialogCommentLongClickBinding3 = this.binding;
        if (dialogCommentLongClickBinding3 != null && (themeTextView3 = dialogCommentLongClickBinding3.tvVote) != null) {
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: eb.u
                public /* synthetic */ u() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentLongClickDialog.k(CommentLongClickDialog.this, view);
                }
            });
        }
        DialogCommentLongClickBinding dialogCommentLongClickBinding4 = this.binding;
        if (dialogCommentLongClickBinding4 != null && (themeTextView2 = dialogCommentLongClickBinding4.tvCopy) != null) {
            themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: eb.v
                public /* synthetic */ v() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentLongClickDialog.l(CommentLongClickDialog.this, view);
                }
            });
        }
        DialogCommentLongClickBinding dialogCommentLongClickBinding5 = this.binding;
        if (dialogCommentLongClickBinding5 == null || (themeTextView = dialogCommentLongClickBinding5.tvReport) == null) {
            return;
        }
        themeTextView.setOnClickListener(new View.OnClickListener() { // from class: eb.w
            public /* synthetic */ w() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentLongClickDialog.m(CommentLongClickDialog.this, view);
            }
        });
    }

    public static final void i(CommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void j(CommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(0);
        }
    }

    public static final void k(CommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(1);
        }
    }

    public static final void l(CommentLongClickDialog this$0, View view) {
        ThemeTextView themeTextView;
        CharSequence text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        DialogCommentLongClickBinding dialogCommentLongClickBinding = this$0.binding;
        ba.l.f(context, (dialogCommentLongClickBinding == null || (themeTextView = dialogCommentLongClickBinding.tvCommentContent) == null || (text = themeTextView.getText()) == null) ? null : text.toString());
        t0.b(this$0.getContext(), "已复制到剪贴板");
        this$0.dismiss();
    }

    public static final void m(CommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(3);
        }
    }

    public static /* synthetic */ void p(CommentLongClickDialog commentLongClickDialog, FrameLayout frameLayout, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 16;
        }
        commentLongClickDialog.o(frameLayout, i10, i11);
    }

    @JvmStatic
    public static final void q(@k Context context, @l Comment comment, @l CommentReply commentReply, @k b bVar) {
        INSTANCE.a(context, comment, commentReply, bVar);
    }

    @SuppressLint({"InflateParams"})
    public final void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_comment_long_click, (ViewGroup) null);
        setContentView(inflate);
        this.binding = DialogCommentLongClickBinding.bind(inflate);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
        }
        r(inflate instanceof ViewGroup ? (ViewGroup) inflate : null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void n(@l Comment comment, @l CommentReply commentReply, @k b onClickListener) {
        ThemeTextView themeTextView;
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.comment = comment;
        this.commentReply = commentReply;
        this.onClickListener = onClickListener;
        if (commentReply != null) {
            DialogCommentLongClickBinding dialogCommentLongClickBinding = this.binding;
            ThemeTextView themeTextView2 = dialogCommentLongClickBinding != null ? dialogCommentLongClickBinding.tvVote : null;
            if (themeTextView2 != null) {
                themeTextView2.setText(ExtKt.c(commentReply.getHasUp() ? "取消点赞" : "点赞"));
            }
            DialogCommentLongClickBinding dialogCommentLongClickBinding2 = this.binding;
            themeTextView = dialogCommentLongClickBinding2 != null ? dialogCommentLongClickBinding2.tvCommentContent : null;
            if (themeTextView == null) {
                return;
            }
            themeTextView.setText("@" + commentReply.getNickname() + "：" + commentReply.getContent());
            return;
        }
        if (comment != null) {
            DialogCommentLongClickBinding dialogCommentLongClickBinding3 = this.binding;
            ThemeTextView themeTextView3 = dialogCommentLongClickBinding3 != null ? dialogCommentLongClickBinding3.tvVote : null;
            if (themeTextView3 != null) {
                themeTextView3.setText(ExtKt.c(comment.getHasUp() ? "取消点赞" : "点赞"));
            }
            DialogCommentLongClickBinding dialogCommentLongClickBinding4 = this.binding;
            themeTextView = dialogCommentLongClickBinding4 != null ? dialogCommentLongClickBinding4.tvCommentContent : null;
            if (themeTextView == null) {
                return;
            }
            themeTextView.setText("@" + comment.getNickname() + "：" + comment.getContent());
        }
    }

    public final void o(FrameLayout nightMask, int backgroundColor, int topCornerRadius) {
        if (topCornerRadius == 0) {
            nightMask.setBackgroundColor(backgroundColor);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f10 = topCornerRadius;
        gradientDrawable.setCornerRadii(new float[]{f10, f10, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(backgroundColor);
        nightMask.setBackground(gradientDrawable);
    }

    public final void r(ViewGroup viewGroup) {
        Context context = getContext();
        FrameLayout frameLayout = viewGroup != null ? (FrameLayout) viewGroup.findViewById(R.id.night_mask) : null;
        FrameLayout frameLayout2 = frameLayout instanceof FrameLayout ? frameLayout : null;
        if (!ConfigSingleton.D().H0()) {
            if (frameLayout2 == null) {
                return;
            }
            frameLayout2.setVisibility(8);
            return;
        }
        if (frameLayout2 == null) {
            frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(R.id.night_mask);
            p(this, frameLayout2, ContextCompat.getColor(context, R.color.semi_transparent_dark), 0, 4, null);
            if (viewGroup != null) {
                viewGroup.addView(frameLayout2, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        frameLayout2.setVisibility(0);
    }
}
