package com.martian.mibook.mvvm.read.dialog;

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
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogReaderCommentLongClickBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.dialog.ReaderCommentLongClickDialog;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002(\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001b\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/martian/mibook/mvvm/read/dialog/ReaderCommentLongClickDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "g", "()V", "h", "Landroid/view/ViewGroup;", "viewGroup", t.f11211k, "(Landroid/view/ViewGroup;)V", "Landroid/widget/FrameLayout;", "nightMask", "", "backgroundColor", "topCornerRadius", "o", "(Landroid/widget/FrameLayout;II)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "Lcom/martian/mibook/mvvm/read/dialog/ReaderCommentLongClickDialog$b;", "onClickListener", "n", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;Lcom/martian/mibook/mvvm/read/dialog/ReaderCommentLongClickDialog$b;)V", "b", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "c", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "d", "Lcom/martian/mibook/mvvm/read/dialog/ReaderCommentLongClickDialog$b;", "Lcom/martian/mibook/databinding/DialogReaderCommentLongClickBinding;", e.TAG, "Lcom/martian/mibook/databinding/DialogReaderCommentLongClickBinding;", "binding", "f", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderCommentLongClickDialog extends BottomSheetDialog {

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
    public DialogReaderCommentLongClickBinding binding;

    /* renamed from: com.martian.mibook.mvvm.read.dialog.ReaderCommentLongClickDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@k Context context, @l Comment comment, @l CommentReply commentReply, @k b onClickListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            ReaderCommentLongClickDialog readerCommentLongClickDialog = new ReaderCommentLongClickDialog(context);
            boolean s10 = MiConfigSingleton.b2().h2().s();
            int navigationBarBackgroundColor = MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false);
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                d.r3(activity, readerCommentLongClickDialog).T2(!s10).G1(!s10).B1(navigationBarBackgroundColor, 0.0f).a1();
            }
            readerCommentLongClickDialog.n(comment, commentReply, onClickListener);
            readerCommentLongClickDialog.show();
        }

        public Companion() {
        }
    }

    public interface b {
        void a(@l Integer num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderCommentLongClickDialog(@k Context context) {
        super(context, R.style.BottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        g();
        h();
    }

    @SuppressLint({"InflateParams"})
    private final void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_reader_comment_long_click, (ViewGroup) null);
        setContentView(inflate);
        this.binding = DialogReaderCommentLongClickBinding.bind(inflate);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
        }
        r(inflate instanceof ViewGroup ? (ViewGroup) inflate : null);
    }

    private final void h() {
        ReaderThemeTextView readerThemeTextView;
        ReaderThemeTextView readerThemeTextView2;
        ReaderThemeTextView readerThemeTextView3;
        ReaderThemeTextView readerThemeTextView4;
        ReaderThemeLinearLayout readerThemeLinearLayout;
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding = this.binding;
        if (dialogReaderCommentLongClickBinding != null && (readerThemeLinearLayout = dialogReaderCommentLongClickBinding.llClose) != null) {
            readerThemeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: dd.f
                public /* synthetic */ f() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentLongClickDialog.i(ReaderCommentLongClickDialog.this, view);
                }
            });
        }
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding2 = this.binding;
        if (dialogReaderCommentLongClickBinding2 != null && (readerThemeTextView4 = dialogReaderCommentLongClickBinding2.tvReply) != null) {
            readerThemeTextView4.setOnClickListener(new View.OnClickListener() { // from class: dd.g
                public /* synthetic */ g() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentLongClickDialog.j(ReaderCommentLongClickDialog.this, view);
                }
            });
        }
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding3 = this.binding;
        if (dialogReaderCommentLongClickBinding3 != null && (readerThemeTextView3 = dialogReaderCommentLongClickBinding3.tvVote) != null) {
            readerThemeTextView3.setOnClickListener(new View.OnClickListener() { // from class: dd.h
                public /* synthetic */ h() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentLongClickDialog.k(ReaderCommentLongClickDialog.this, view);
                }
            });
        }
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding4 = this.binding;
        if (dialogReaderCommentLongClickBinding4 != null && (readerThemeTextView2 = dialogReaderCommentLongClickBinding4.tvCopy) != null) {
            readerThemeTextView2.setOnClickListener(new View.OnClickListener() { // from class: dd.i
                public /* synthetic */ i() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentLongClickDialog.l(ReaderCommentLongClickDialog.this, view);
                }
            });
        }
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding5 = this.binding;
        if (dialogReaderCommentLongClickBinding5 == null || (readerThemeTextView = dialogReaderCommentLongClickBinding5.tvReport) == null) {
            return;
        }
        readerThemeTextView.setOnClickListener(new View.OnClickListener() { // from class: dd.j
            public /* synthetic */ j() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderCommentLongClickDialog.m(ReaderCommentLongClickDialog.this, view);
            }
        });
    }

    public static final void i(ReaderCommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void j(ReaderCommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(0);
        }
    }

    public static final void k(ReaderCommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(1);
        }
    }

    public static final void l(ReaderCommentLongClickDialog this$0, View view) {
        ReaderThemeTextView readerThemeTextView;
        CharSequence text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding = this$0.binding;
        ba.l.f(context, (dialogReaderCommentLongClickBinding == null || (readerThemeTextView = dialogReaderCommentLongClickBinding.tvCommentContent) == null || (text = readerThemeTextView.getText()) == null) ? null : text.toString());
        t0.b(this$0.getContext(), "已复制到剪贴板");
        this$0.dismiss();
    }

    public static final void m(ReaderCommentLongClickDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        b bVar = this$0.onClickListener;
        if (bVar != null) {
            bVar.a(3);
        }
    }

    private final void o(FrameLayout nightMask, int backgroundColor, int topCornerRadius) {
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

    public static /* synthetic */ void p(ReaderCommentLongClickDialog readerCommentLongClickDialog, FrameLayout frameLayout, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 16;
        }
        readerCommentLongClickDialog.o(frameLayout, i10, i11);
    }

    @JvmStatic
    public static final void q(@k Context context, @l Comment comment, @l CommentReply commentReply, @k b bVar) {
        INSTANCE.a(context, comment, commentReply, bVar);
    }

    private final void r(ViewGroup viewGroup) {
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

    @SuppressLint({"SetTextI18n"})
    public final void n(@l Comment comment, @l CommentReply commentReply, @k b onClickListener) {
        ReaderThemeTextView readerThemeTextView;
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.comment = comment;
        this.commentReply = commentReply;
        this.onClickListener = onClickListener;
        if (commentReply != null) {
            DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding = this.binding;
            ReaderThemeTextView readerThemeTextView2 = dialogReaderCommentLongClickBinding != null ? dialogReaderCommentLongClickBinding.tvVote : null;
            if (readerThemeTextView2 != null) {
                readerThemeTextView2.setText(ExtKt.c(commentReply.getHasUp() ? "取消点赞" : "点赞"));
            }
            DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding2 = this.binding;
            readerThemeTextView = dialogReaderCommentLongClickBinding2 != null ? dialogReaderCommentLongClickBinding2.tvCommentContent : null;
            if (readerThemeTextView == null) {
                return;
            }
            readerThemeTextView.setText("@" + commentReply.getNickname() + "：" + commentReply.getContent());
            return;
        }
        if (comment != null) {
            DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding3 = this.binding;
            ReaderThemeTextView readerThemeTextView3 = dialogReaderCommentLongClickBinding3 != null ? dialogReaderCommentLongClickBinding3.tvVote : null;
            if (readerThemeTextView3 != null) {
                readerThemeTextView3.setText(ExtKt.c(comment.getHasUp() ? "取消点赞" : "点赞"));
            }
            DialogReaderCommentLongClickBinding dialogReaderCommentLongClickBinding4 = this.binding;
            readerThemeTextView = dialogReaderCommentLongClickBinding4 != null ? dialogReaderCommentLongClickBinding4.tvCommentContent : null;
            if (readerThemeTextView == null) {
                return;
            }
            readerThemeTextView.setText("@" + comment.getNickname() + "：" + comment.getContent());
        }
    }
}
