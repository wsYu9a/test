package com.martian.mibook.mvvm.read.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ReaderPostBookCommentFragmentBinding;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class ReaderPostBookCommentFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: q */
    public static final String f14649q = "TAG_POST_BOOK_COMMENT";

    /* renamed from: r */
    public static final String f14650r = "INTENT_COMMENT_STRING";

    /* renamed from: s */
    public static final String f14651s = "INTENT_COMMENT_TYPE";

    /* renamed from: t */
    public static final int f14652t = 1;

    /* renamed from: u */
    public static final int f14653u = 2;

    /* renamed from: v */
    public static final String f14654v = "INTENT_BOOK_INFO";

    /* renamed from: w */
    public static final String f14655w = "INTENT_SCORE";

    /* renamed from: x */
    public static final String f14656x = "INTENT_COMMENT_CID";

    /* renamed from: y */
    public static final String f14657y = "INTENT_SOURCE_NICKNAME";

    /* renamed from: f */
    public ReaderPostBookCommentFragmentBinding f14658f;

    /* renamed from: g */
    public e f14659g;

    /* renamed from: h */
    public String f14660h;

    /* renamed from: i */
    public int f14661i;

    /* renamed from: j */
    public boolean f14662j = false;

    /* renamed from: k */
    public BookInfo f14663k;

    /* renamed from: l */
    public int f14664l;

    /* renamed from: m */
    public int f14665m;

    /* renamed from: n */
    public Integer f14666n;

    /* renamed from: o */
    public String f14667o;

    /* renamed from: p */
    public AppViewModel f14668p;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ReaderPostBookCommentFragment.this.f14658f.postCommentButton.setAlpha(!l.q(String.valueOf(charSequence)) ? 1.0f : 0.4f);
            if (ReaderPostBookCommentFragment.this.f14659g != null) {
                ReaderPostBookCommentFragment.this.f14659g.c(ReaderPostBookCommentFragment.this.b0() ? ReaderPostBookCommentFragment.this.f14663k.getSourceString() : String.valueOf(ReaderPostBookCommentFragment.this.f14666n), String.valueOf(charSequence));
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public boolean f14670b;

        /* renamed from: c */
        public final /* synthetic */ View f14671c;

        public b(View view) {
            this.f14671c = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Rect rect = new Rect();
            this.f14671c.getWindowVisibleDisplayFrame(rect);
            int height = this.f14671c.getHeight();
            int i10 = height - rect.bottom;
            double d10 = height;
            boolean z10 = ((double) i10) > 0.15d * d10 || ((double) (this.f14671c.getRootView().getHeight() - height)) > d10 * 0.25d;
            if (z10 != this.f14670b) {
                if (!z10) {
                    ReaderPostBookCommentFragment.this.dismiss();
                } else if (i10 > 0) {
                    this.f14671c.setPadding(0, 0, 0, i10);
                }
            }
            this.f14670b = z10;
            return true;
        }
    }

    public class c implements MiBookManager.e0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f14673a;

        public c(Activity activity) {
            this.f14673a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void a(x8.c cVar) {
            ReaderPostBookCommentFragment.this.f14662j = false;
            Activity activity = this.f14673a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ReaderPostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void b(Comment comment) {
            ReaderPostBookCommentFragment.this.f14662j = false;
            ReaderPostBookCommentFragment readerPostBookCommentFragment = ReaderPostBookCommentFragment.this;
            readerPostBookCommentFragment.f14665m = readerPostBookCommentFragment.f14664l;
            Activity activity = this.f14673a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f14673a, "发表章评");
            if (ReaderPostBookCommentFragment.this.f14659g != null) {
                ReaderPostBookCommentFragment.this.f14659g.b(comment);
                ReaderPostBookCommentFragment.this.f14659g.c(ReaderPostBookCommentFragment.this.f14663k.getSourceString(), "");
            }
            ReaderPostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f14673a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                ReaderPostBookCommentFragment.this.f14658f.postCommentButton.setText(this.f14673a.getString(R.string.post));
                return;
            }
            ReaderPostBookCommentFragment.this.f14658f.postCommentButton.setText(this.f14673a.getString(R.string.post) + "中...");
        }
    }

    public class d implements MiBookManager.g0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f14675a;

        public d(Activity activity) {
            this.f14675a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void a(x8.c cVar) {
            ReaderPostBookCommentFragment.this.f14662j = false;
            Activity activity = this.f14675a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ReaderPostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void b(CommentReply commentReply) {
            String str;
            ReaderPostBookCommentFragment.this.f14662j = false;
            Activity activity = this.f14675a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f14675a, "发表章评");
            if (ReaderPostBookCommentFragment.this.f14659g != null) {
                ReaderPostBookCommentFragment.this.f14659g.a(commentReply);
                e eVar = ReaderPostBookCommentFragment.this.f14659g;
                if (ReaderPostBookCommentFragment.this.f14666n == null) {
                    str = "";
                } else {
                    str = ReaderPostBookCommentFragment.this.f14666n + "";
                }
                eVar.c(str, "");
            }
            ReaderPostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f14675a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                ReaderPostBookCommentFragment.this.f14658f.postCommentButton.setText(this.f14675a.getString(R.string.post));
                return;
            }
            ReaderPostBookCommentFragment.this.f14658f.postCommentButton.setText(this.f14675a.getString(R.string.post) + "中...");
        }
    }

    public interface e {
        void a(CommentReply commentReply);

        void b(Comment comment);

        void c(String str, String str2);
    }

    private AppViewModel Y() {
        if (this.f14668p == null) {
            this.f14668p = lc.b.a(getActivity());
        }
        return this.f14668p;
    }

    private String Z(Activity activity, int i10) {
        return i10 != 20 ? i10 != 40 ? i10 != 60 ? i10 != 80 ? activity.getString(R.string.post_comment_status_5) : activity.getString(R.string.post_comment_status_4) : activity.getString(R.string.post_comment_status_3) : activity.getString(R.string.post_comment_status_2) : activity.getString(R.string.post_comment_status_1);
    }

    private boolean a0() {
        return this.f14661i == 0 || (b0() && this.f14663k == null) || (d0() && this.f14666n == null);
    }

    public boolean b0() {
        return this.f14661i == 1;
    }

    private boolean d0() {
        return this.f14661i == 2;
    }

    public static /* synthetic */ void e0(DialogFragment dialogFragment) {
        boolean s10 = MiConfigSingleton.b2().h2().s();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public static /* synthetic */ void f0(DialogFragment dialogFragment) {
        boolean s10 = MiConfigSingleton.b2().h2().s();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(MiConfigSingleton.b2().h2().k().getNavigationBarBackgroundColor(false), 0.0f).a1();
    }

    public /* synthetic */ void g0(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.f14658f.bdEditComment.getText() != null && l.q(this.f14658f.bdEditComment.getText().toString())) {
            this.f14658f.postCommentButton.setAlpha(0.4f);
            t0.b(activity, "评论内容不能为空");
            return;
        }
        if (this.f14662j) {
            t0.b(activity, "评论发表中，请稍候");
            return;
        }
        if (MiConfigSingleton.b2().G1().f(activity)) {
            this.f14662j = true;
            String obj = this.f14658f.bdEditComment.getText().toString();
            if (b0()) {
                n0(activity, obj);
            } else {
                o0(activity, obj);
            }
        }
    }

    public /* synthetic */ void h0(Activity activity, View view) {
        s0(activity, 20);
    }

    public /* synthetic */ void i0(Activity activity, View view) {
        s0(activity, 40);
    }

    public /* synthetic */ void j0(Activity activity, View view) {
        s0(activity, 60);
    }

    public /* synthetic */ void k0(Activity activity, View view) {
        s0(activity, 80);
    }

    public /* synthetic */ void l0(Activity activity, View view) {
        s0(activity, 100);
    }

    public /* synthetic */ void m0(View view) {
        dismiss();
    }

    private void n0(Activity activity, String str) {
        MiConfigSingleton.b2().V1().g(5, this.f14663k.getSourceName(), this.f14663k.getSourceId(), this.f14663k.getRecommendId(), this.f14663k.getRecommend(), "评论");
        MiConfigSingleton.b2().M1().r2(activity, this.f14663k.getSourceName(), this.f14663k.getSourceId(), "", "", str, this.f14664l, 1, null, "", new c(activity));
    }

    private void o0(Activity activity, String str) {
        MiConfigSingleton.b2().M1().u2(activity, this.f14666n, null, str, new d(activity));
    }

    public static void q0(FragmentActivity fragmentActivity, BookInfo bookInfo, int i10, String str, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.reader_post_book_comment_fragment, (ViewGroup) null)).k0(true).j0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: ed.s
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                ReaderPostBookCommentFragment.e0(dialogFragment);
            }
        });
        ReaderPostBookCommentFragment readerPostBookCommentFragment = new ReaderPostBookCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_BOOK_INFO", GsonUtils.b().toJson(bookInfo));
        bundle.putString("INTENT_COMMENT_STRING", str);
        bundle.putInt("INTENT_SCORE", i10);
        bundle.putInt("INTENT_COMMENT_TYPE", 1);
        readerPostBookCommentFragment.setArguments(bundle);
        readerPostBookCommentFragment.p0(eVar);
        a10.b0(fragmentActivity, readerPostBookCommentFragment, "TAG_POST_BOOK_COMMENT");
    }

    public static void r0(FragmentActivity fragmentActivity, Integer num, String str, String str2, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.reader_post_book_comment_fragment, (ViewGroup) null)).k0(true).j0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: ed.t
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                ReaderPostBookCommentFragment.f0(dialogFragment);
            }
        });
        ReaderPostBookCommentFragment readerPostBookCommentFragment = new ReaderPostBookCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("INTENT_COMMENT_CID", num.intValue());
        bundle.putString("INTENT_COMMENT_STRING", str2);
        bundle.putString("INTENT_SOURCE_NICKNAME", str);
        bundle.putInt("INTENT_COMMENT_TYPE", 2);
        readerPostBookCommentFragment.setArguments(bundle);
        readerPostBookCommentFragment.p0(eVar);
        a10.b0(fragmentActivity, readerPostBookCommentFragment, "TAG_POST_BOOK_COMMENT");
    }

    private void s0(Activity activity, int i10) {
        this.f14664l = i10;
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int textColorThirdly = k10.getTextColorThirdly();
        int itemColorPrimary = k10.getItemColorPrimary();
        this.f14658f.bdVote2.setAlpha(i10 < 40 ? 0.3f : 1.0f);
        this.f14658f.bdVote3.setAlpha(i10 < 60 ? 0.3f : 1.0f);
        this.f14658f.bdVote4.setAlpha(i10 < 80 ? 0.3f : 1.0f);
        this.f14658f.bdVote5.setAlpha(i10 < 100 ? 0.3f : 1.0f);
        this.f14658f.bdVote1.setColorFilter(itemColorPrimary);
        this.f14658f.bdVote2.setColorFilter(i10 < 40 ? textColorThirdly : itemColorPrimary);
        this.f14658f.bdVote3.setColorFilter(i10 < 60 ? textColorThirdly : itemColorPrimary);
        this.f14658f.bdVote4.setColorFilter(i10 < 80 ? textColorThirdly : itemColorPrimary);
        ImageView imageView = this.f14658f.bdVote5;
        if (i10 >= 100) {
            textColorThirdly = itemColorPrimary;
        }
        imageView.setColorFilter(textColorThirdly);
        this.f14658f.postCommentStatus.setText(Z(activity, i10));
        this.f14658f.postCommentStatus.setTag(Integer.valueOf(i10));
        BookInfo bookInfo = this.f14663k;
        if (bookInfo == null || TextUtils.isEmpty(bookInfo.getSourceString())) {
            return;
        }
        Y().B0(this.f14663k.getSourceString(), i10);
    }

    private void t0() {
        if (a0()) {
            return;
        }
        this.f14658f.bdEditComment.requestFocus();
        i0.L0(getActivity(), this.f14658f.bdEditComment);
        this.f14658f.bdEditComment.addTextChangedListener(new a());
        if (!l.q(this.f14660h)) {
            this.f14658f.bdEditComment.setText(this.f14660h);
            this.f14658f.bdEditComment.setSelection(this.f14660h.length());
        }
        if (d0()) {
            this.f14658f.postCommentTitle.setText(ConfigSingleton.D().s("回复评论"));
            this.f14658f.postCommentStars.setVisibility(8);
            this.f14658f.postCommentStatus.setVisibility(8);
        }
        if (!l.q(this.f14667o)) {
            this.f14658f.bdEditComment.setHint("回复@" + this.f14667o);
        }
        this.f14658f.postCommentButton.setOnClickListener(new View.OnClickListener() { // from class: ed.u
            public /* synthetic */ u() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.g0(view);
            }
        });
        FragmentActivity activity = getActivity();
        s0(activity, this.f14664l);
        this.f14658f.bdVote1.setOnClickListener(new View.OnClickListener() { // from class: ed.v

            /* renamed from: c */
            public final /* synthetic */ Activity f25888c;

            public /* synthetic */ v(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.h0(activity, view);
            }
        });
        this.f14658f.bdVote2.setOnClickListener(new View.OnClickListener() { // from class: ed.w

            /* renamed from: c */
            public final /* synthetic */ Activity f25891c;

            public /* synthetic */ w(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.i0(activity, view);
            }
        });
        this.f14658f.bdVote3.setOnClickListener(new View.OnClickListener() { // from class: ed.x

            /* renamed from: c */
            public final /* synthetic */ Activity f25894c;

            public /* synthetic */ x(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.j0(activity, view);
            }
        });
        this.f14658f.bdVote4.setOnClickListener(new View.OnClickListener() { // from class: ed.y

            /* renamed from: c */
            public final /* synthetic */ Activity f25897c;

            public /* synthetic */ y(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.k0(activity, view);
            }
        });
        this.f14658f.bdVote5.setOnClickListener(new View.OnClickListener() { // from class: ed.z

            /* renamed from: c */
            public final /* synthetic */ Activity f25899c;

            public /* synthetic */ z(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.l0(activity, view);
            }
        });
        this.f14658f.postCommentClose.setOnClickListener(new View.OnClickListener() { // from class: ed.a0
            public /* synthetic */ a0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPostBookCommentFragment.this.m0(view);
            }
        });
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new b(view));
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        BookInfo bookInfo = this.f14663k;
        if (bookInfo != null && !TextUtils.isEmpty(bookInfo.getSourceString())) {
            Y().B0(this.f14663k.getSourceString(), this.f14665m);
        }
        super.dismiss();
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("INTENT_BOOK_INFO");
            if (!l.q(string)) {
                this.f14663k = (BookInfo) GsonUtils.b().fromJson(string, BookInfo.class);
            }
            this.f14661i = arguments.getInt("INTENT_COMMENT_TYPE");
            this.f14660h = arguments.getString("INTENT_COMMENT_STRING");
            this.f14664l = arguments.getInt("INTENT_SCORE");
            this.f14666n = Integer.valueOf(arguments.getInt("INTENT_COMMENT_CID"));
            this.f14667o = arguments.getString("INTENT_SOURCE_NICKNAME");
        }
        if (a0()) {
            dismiss();
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        View m10 = m();
        if (m10 != null) {
            this.f14658f = ReaderPostBookCommentFragmentBinding.bind(m10);
            t0();
        }
    }

    public void p0(e eVar) {
        this.f14659g = eVar;
    }
}
