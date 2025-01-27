package com.martian.mibook.fragment.dialog;

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
import com.martian.mibook.databinding.PopupwindowPostBookCommentBinding;
import com.martian.mibook.fragment.dialog.PostBookCommentFragment;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import l9.i0;
import l9.t0;

/* loaded from: classes3.dex */
public class PostBookCommentFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: q */
    public static final String f13725q = "TAG_POST_BOOK_COMMENT";

    /* renamed from: r */
    public static final String f13726r = "INTENT_COMMENT_STRING";

    /* renamed from: s */
    public static final String f13727s = "INTENT_COMMENT_TYPE";

    /* renamed from: t */
    public static final int f13728t = 1;

    /* renamed from: u */
    public static final int f13729u = 2;

    /* renamed from: v */
    public static final String f13730v = "INTENT_BOOK_INFO";

    /* renamed from: w */
    public static final String f13731w = "INTENT_SCORE";

    /* renamed from: x */
    public static final String f13732x = "INTENT_COMMENT_CID";

    /* renamed from: y */
    public static final String f13733y = "INTENT_SOURCE_NICKNAME";

    /* renamed from: f */
    public PopupwindowPostBookCommentBinding f13734f;

    /* renamed from: g */
    public e f13735g;

    /* renamed from: h */
    public String f13736h;

    /* renamed from: i */
    public int f13737i;

    /* renamed from: k */
    public BookInfo f13739k;

    /* renamed from: l */
    public int f13740l;

    /* renamed from: n */
    public Integer f13742n;

    /* renamed from: o */
    public String f13743o;

    /* renamed from: p */
    public AppViewModel f13744p;

    /* renamed from: j */
    public boolean f13738j = false;

    /* renamed from: m */
    public int f13741m = 0;

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
            PostBookCommentFragment.this.f13734f.postCommentButton.setAlpha(!l.q(String.valueOf(charSequence)) ? 1.0f : 0.4f);
            if (PostBookCommentFragment.this.f13735g != null) {
                PostBookCommentFragment.this.f13735g.c(PostBookCommentFragment.this.b0() ? PostBookCommentFragment.this.f13739k.getSourceString() : String.valueOf(PostBookCommentFragment.this.f13742n), String.valueOf(charSequence));
            }
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b */
        public boolean f13746b;

        /* renamed from: c */
        public final /* synthetic */ View f13747c;

        public b(View view) {
            this.f13747c = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Rect rect = new Rect();
            this.f13747c.getWindowVisibleDisplayFrame(rect);
            int height = this.f13747c.getHeight();
            int i10 = height - rect.bottom;
            double d10 = height;
            boolean z10 = ((double) i10) > 0.15d * d10 || ((double) (this.f13747c.getRootView().getHeight() - height)) > d10 * 0.25d;
            if (z10 != this.f13746b) {
                if (!z10) {
                    PostBookCommentFragment.this.dismiss();
                } else if (i10 > 0) {
                    this.f13747c.setPadding(0, 0, 0, i10);
                }
            }
            this.f13746b = z10;
            return true;
        }
    }

    public class c implements MiBookManager.e0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f13749a;

        public c(Activity activity) {
            this.f13749a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void a(x8.c cVar) {
            PostBookCommentFragment.this.f13738j = false;
            Activity activity = this.f13749a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            PostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        public void b(Comment comment) {
            PostBookCommentFragment.this.f13738j = false;
            Activity activity = this.f13749a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f13749a, "发表章评");
            if (PostBookCommentFragment.this.f13735g != null) {
                PostBookCommentFragment.this.f13735g.b(comment);
                PostBookCommentFragment.this.f13735g.c(PostBookCommentFragment.this.f13739k.getSourceString(), "");
            }
            PostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.e0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f13749a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                PostBookCommentFragment.this.f13734f.postCommentButton.setText(this.f13749a.getString(R.string.post));
                return;
            }
            PostBookCommentFragment.this.f13734f.postCommentButton.setText(this.f13749a.getString(R.string.post) + "中...");
        }
    }

    public class d implements MiBookManager.g0 {

        /* renamed from: a */
        public final /* synthetic */ Activity f13751a;

        public d(Activity activity) {
            this.f13751a = activity;
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void a(x8.c cVar) {
            PostBookCommentFragment.this.f13738j = false;
            Activity activity = this.f13751a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            PostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        public void b(CommentReply commentReply) {
            String str;
            PostBookCommentFragment.this.f13738j = false;
            PostBookCommentFragment postBookCommentFragment = PostBookCommentFragment.this;
            postBookCommentFragment.f13741m = postBookCommentFragment.f13740l;
            Activity activity = this.f13751a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ac.a.L(this.f13751a, "发表章评");
            if (PostBookCommentFragment.this.f13735g != null) {
                PostBookCommentFragment.this.f13735g.a(commentReply);
                e eVar = PostBookCommentFragment.this.f13735g;
                if (PostBookCommentFragment.this.f13742n == null) {
                    str = "";
                } else {
                    str = PostBookCommentFragment.this.f13742n + "";
                }
                eVar.c(str, "");
            }
            PostBookCommentFragment.this.dismiss();
        }

        @Override // com.martian.mibook.application.MiBookManager.g0
        @SuppressLint({"SetTextI18n"})
        public void onLoading(boolean z10) {
            Activity activity = this.f13751a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (!z10) {
                PostBookCommentFragment.this.f13734f.postCommentButton.setText(this.f13751a.getString(R.string.post));
                return;
            }
            PostBookCommentFragment.this.f13734f.postCommentButton.setText(this.f13751a.getString(R.string.post) + "中...");
        }
    }

    public interface e {
        void a(CommentReply commentReply);

        void b(Comment comment);

        void c(String str, String str2);
    }

    private AppViewModel Y() {
        if (this.f13744p == null) {
            this.f13744p = lc.b.a(getActivity());
        }
        return this.f13744p;
    }

    public static /* synthetic */ void e0(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public static /* synthetic */ void f0(DialogFragment dialogFragment) {
        boolean A0 = MiConfigSingleton.b2().A0();
        com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public static void q0(FragmentActivity fragmentActivity, BookInfo bookInfo, int i10, String str, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.popupwindow_post_book_comment, (ViewGroup) null)).k0(true).j0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.f0
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                PostBookCommentFragment.e0(dialogFragment);
            }
        });
        PostBookCommentFragment postBookCommentFragment = new PostBookCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_BOOK_INFO", GsonUtils.b().toJson(bookInfo));
        bundle.putString("INTENT_COMMENT_STRING", str);
        bundle.putInt("INTENT_SCORE", i10);
        bundle.putInt("INTENT_COMMENT_TYPE", 1);
        postBookCommentFragment.setArguments(bundle);
        postBookCommentFragment.p0(eVar);
        a10.b0(fragmentActivity, postBookCommentFragment, "TAG_POST_BOOK_COMMENT");
    }

    public static void r0(FragmentActivity fragmentActivity, Integer num, String str, String str2, e eVar) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        a10.y0(fragmentActivity.getLayoutInflater().inflate(R.layout.popupwindow_post_book_comment, (ViewGroup) null)).k0(true).j0(true).o0(false).m0(false).x0(com.martian.libmars.R.style.BottomSheetEdit).q0(ConfigSingleton.i(16.0f)).s0(new MartianBottomSheetDialogFragment.b() { // from class: eb.x
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public final void a(DialogFragment dialogFragment) {
                PostBookCommentFragment.f0(dialogFragment);
            }
        });
        PostBookCommentFragment postBookCommentFragment = new PostBookCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("INTENT_COMMENT_CID", num.intValue());
        bundle.putString("INTENT_COMMENT_STRING", str2);
        bundle.putString("INTENT_SOURCE_NICKNAME", str);
        bundle.putInt("INTENT_COMMENT_TYPE", 2);
        postBookCommentFragment.setArguments(bundle);
        postBookCommentFragment.p0(eVar);
        a10.b0(fragmentActivity, postBookCommentFragment, "TAG_POST_BOOK_COMMENT");
    }

    private void t0() {
        if (a0()) {
            return;
        }
        this.f13734f.bdEditComment.requestFocus();
        i0.L0(getActivity(), this.f13734f.bdEditComment);
        this.f13734f.bdEditComment.addTextChangedListener(new a());
        if (!l.q(this.f13736h)) {
            this.f13734f.bdEditComment.setText(this.f13736h);
            this.f13734f.bdEditComment.setSelection(this.f13736h.length());
        }
        if (d0()) {
            this.f13734f.postCommentTitle.setText(ConfigSingleton.D().s("回复评论"));
            this.f13734f.postCommentStars.setVisibility(8);
            this.f13734f.postCommentStatus.setVisibility(8);
        }
        if (!l.q(this.f13743o)) {
            this.f13734f.bdEditComment.setHint("回复@" + this.f13743o);
        }
        this.f13734f.postCommentButton.setOnClickListener(new View.OnClickListener() { // from class: eb.y
            public /* synthetic */ y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.g0(view);
            }
        });
        FragmentActivity activity = getActivity();
        s0(activity, this.f13740l);
        this.f13734f.bdVote1.setOnClickListener(new View.OnClickListener() { // from class: eb.z

            /* renamed from: c */
            public final /* synthetic */ Activity f25842c;

            public /* synthetic */ z(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.h0(activity, view);
            }
        });
        this.f13734f.bdVote2.setOnClickListener(new View.OnClickListener() { // from class: eb.a0

            /* renamed from: c */
            public final /* synthetic */ Activity f25801c;

            public /* synthetic */ a0(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.i0(activity, view);
            }
        });
        this.f13734f.bdVote3.setOnClickListener(new View.OnClickListener() { // from class: eb.b0

            /* renamed from: c */
            public final /* synthetic */ Activity f25804c;

            public /* synthetic */ b0(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.j0(activity, view);
            }
        });
        this.f13734f.bdVote4.setOnClickListener(new View.OnClickListener() { // from class: eb.c0

            /* renamed from: c */
            public final /* synthetic */ Activity f25807c;

            public /* synthetic */ c0(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.k0(activity, view);
            }
        });
        this.f13734f.bdVote5.setOnClickListener(new View.OnClickListener() { // from class: eb.d0

            /* renamed from: c */
            public final /* synthetic */ Activity f25810c;

            public /* synthetic */ d0(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.l0(activity, view);
            }
        });
        this.f13734f.postCommentClose.setOnClickListener(new View.OnClickListener() { // from class: eb.e0
            public /* synthetic */ e0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBookCommentFragment.this.m0(view);
            }
        });
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new b(view));
    }

    public final String Z(Activity activity, int i10) {
        return i10 != 20 ? i10 != 40 ? i10 != 60 ? i10 != 80 ? activity.getString(R.string.post_comment_status_5) : activity.getString(R.string.post_comment_status_4) : activity.getString(R.string.post_comment_status_3) : activity.getString(R.string.post_comment_status_2) : activity.getString(R.string.post_comment_status_1);
    }

    public final boolean a0() {
        return this.f13737i == 0 || (b0() && this.f13739k == null) || (d0() && this.f13742n == null);
    }

    public final boolean b0() {
        return this.f13737i == 1;
    }

    public final boolean d0() {
        return this.f13737i == 2;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        BookInfo bookInfo = this.f13739k;
        if (bookInfo != null && !TextUtils.isEmpty(bookInfo.getSourceString())) {
            Y().B0(this.f13739k.getSourceString(), this.f13741m);
        }
        super.dismiss();
    }

    public final /* synthetic */ void g0(View view) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.f13734f.bdEditComment.getText() != null && l.q(this.f13734f.bdEditComment.getText().toString())) {
            this.f13734f.postCommentButton.setAlpha(0.4f);
            t0.b(activity, "评论内容不能为空");
            return;
        }
        if (this.f13738j) {
            t0.b(activity, "评论发表中，请稍候");
            return;
        }
        if (MiConfigSingleton.b2().G1().f(activity)) {
            this.f13738j = true;
            String obj = this.f13734f.bdEditComment.getText().toString();
            if (b0()) {
                n0(activity, obj);
            } else {
                o0(activity, obj);
            }
        }
    }

    public final /* synthetic */ void h0(Activity activity, View view) {
        s0(activity, 20);
    }

    public final /* synthetic */ void i0(Activity activity, View view) {
        s0(activity, 40);
    }

    public final /* synthetic */ void j0(Activity activity, View view) {
        s0(activity, 60);
    }

    public final /* synthetic */ void k0(Activity activity, View view) {
        s0(activity, 80);
    }

    public final /* synthetic */ void l0(Activity activity, View view) {
        s0(activity, 100);
    }

    public final /* synthetic */ void m0(View view) {
        dismiss();
    }

    public final void n0(Activity activity, String str) {
        MiConfigSingleton.b2().V1().g(5, this.f13739k.getSourceName(), this.f13739k.getSourceId(), this.f13739k.getRecommendId(), this.f13739k.getRecommend(), "评论");
        MiConfigSingleton.b2().M1().r2(activity, this.f13739k.getSourceName(), this.f13739k.getSourceId(), "", "", str, this.f13740l, 1, null, "", new c(activity));
    }

    public final void o0(Activity activity, String str) {
        MiConfigSingleton.b2().M1().u2(activity, this.f13742n, null, str, new d(activity));
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("INTENT_BOOK_INFO");
            if (!l.q(string)) {
                this.f13739k = (BookInfo) GsonUtils.b().fromJson(string, BookInfo.class);
            }
            this.f13737i = arguments.getInt("INTENT_COMMENT_TYPE");
            this.f13736h = arguments.getString("INTENT_COMMENT_STRING");
            this.f13740l = arguments.getInt("INTENT_SCORE");
            this.f13742n = Integer.valueOf(arguments.getInt("INTENT_COMMENT_CID"));
            this.f13743o = arguments.getString("INTENT_SOURCE_NICKNAME");
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
            this.f13734f = PopupwindowPostBookCommentBinding.bind(m10);
            t0();
        }
    }

    public void p0(e eVar) {
        this.f13735g = eVar;
    }

    public final void s0(Activity activity, int i10) {
        this.f13740l = i10;
        this.f13734f.bdVote1.setImageResource(R.drawable.vote_star_red);
        int j02 = ConfigSingleton.D().j0();
        this.f13734f.bdVote2.setAlpha(i10 < 40 ? 0.3f : 1.0f);
        this.f13734f.bdVote3.setAlpha(i10 < 60 ? 0.3f : 1.0f);
        this.f13734f.bdVote4.setAlpha(i10 < 80 ? 0.3f : 1.0f);
        this.f13734f.bdVote5.setAlpha(i10 < 100 ? 0.3f : 1.0f);
        this.f13734f.bdVote2.setColorFilter(i10 < 40 ? j02 : 0);
        this.f13734f.bdVote3.setColorFilter(i10 < 60 ? j02 : 0);
        this.f13734f.bdVote4.setColorFilter(i10 < 80 ? j02 : 0);
        ImageView imageView = this.f13734f.bdVote5;
        if (i10 >= 100) {
            j02 = 0;
        }
        imageView.setColorFilter(j02);
        this.f13734f.bdVote2.setImageResource(i10 < 40 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.f13734f.bdVote3.setImageResource(i10 < 60 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.f13734f.bdVote4.setImageResource(i10 < 80 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.f13734f.bdVote5.setImageResource(i10 < 100 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        this.f13734f.postCommentStatus.setText(Z(activity, i10));
        this.f13734f.postCommentStatus.setTag(Integer.valueOf(i10));
        BookInfo bookInfo = this.f13739k;
        if (bookInfo == null || TextUtils.isEmpty(bookInfo.getSourceString())) {
            return;
        }
        Y().B0(this.f13739k.getSourceString(), i10);
    }
}
