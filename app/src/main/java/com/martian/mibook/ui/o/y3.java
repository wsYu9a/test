package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.Comment;
import com.martian.mibook.data.book.CommentReply;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.j.v2;
import com.martian.ttbookhd.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class y3 extends com.martian.libmars.widget.recyclerview.e.c<Comment> {

    /* renamed from: g */
    private final com.martian.libmars.activity.j1 f14782g;

    /* renamed from: h */
    private final Map<String, String> f14783h;

    /* renamed from: i */
    private final boolean f14784i;

    class a implements MiBookManager.l0 {

        /* renamed from: a */
        final /* synthetic */ Comment f14785a;

        a(final Comment val$comment) {
            this.f14785a = val$comment;
        }

        @Override // com.martian.mibook.application.MiBookManager.l0
        public void a(b.d.c.b.c errorResult) {
            y3.this.f14782g.k1(errorResult.toString());
        }

        @Override // com.martian.mibook.application.MiBookManager.l0
        public void b(VoteResult voteResult) {
            this.f14785a.setHasUp(Boolean.valueOf(voteResult.getHasUp()));
            this.f14785a.setUpCount(voteResult.getUpCount());
            y3.this.f14782g.setResult(-1);
            y3.this.notifyDataSetChanged();
        }
    }

    class b extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ CommentReply f14787a;

        b(final CommentReply val$commentReply) {
            this.f14787a = val$commentReply;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            com.martian.mibook.j.s2.o0(y3.this.f14782g, 1, this.f14787a.getCuid());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setColor(com.martian.libmars.d.h.F().r0());
        }
    }

    class c extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ CommentReply f14789a;

        c(final CommentReply val$commentReply) {
            this.f14789a = val$commentReply;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            com.martian.mibook.j.s2.o0(y3.this.f14782g, 1, this.f14789a.getToUid());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setColor(com.martian.libmars.d.h.F().r0());
        }
    }

    class d implements v2.c0 {

        /* renamed from: a */
        final /* synthetic */ Comment f14791a;

        d(final Comment val$comment) {
            this.f14791a = val$comment;
        }

        @Override // com.martian.mibook.j.v2.c0
        public void a(String tag, String comment) {
            y3.this.f14783h.put(tag, comment);
        }

        @Override // com.martian.mibook.j.v2.c0
        public void b(CommentReply commentReply) {
            this.f14791a.getReplyList().add(0, commentReply);
            Comment comment = this.f14791a;
            comment.setReplyCount(Integer.valueOf(comment.getReplyCount() + 1));
            y3.this.notifyDataSetChanged();
        }
    }

    public y3(com.martian.libmars.activity.j1 activity, final List<Comment> datas, boolean limit) {
        super(activity, R.layout.reader_comment_item, datas);
        this.f14783h = new HashMap();
        this.f14782g = activity;
        this.f14784i = limit;
    }

    private Integer R() {
        if (getItemCount() > 0) {
            return ((Comment) this.f10476c.get(getItemCount() - 1)).getCid();
        }
        return null;
    }

    static /* synthetic */ void T(final TextView bd_reader_comment, final LinearLayout bd_reader_comment_more, View v) {
        bd_reader_comment.setMaxLines(Integer.MAX_VALUE);
        bd_reader_comment_more.setVisibility(8);
    }

    /* renamed from: U */
    public /* synthetic */ void V(final Comment comment, View v) {
        com.martian.mibook.j.s2.W(this.f14782g, false, comment);
    }

    /* renamed from: W */
    public /* synthetic */ void X(final LinearLayout bd_reader_comment_more, final Comment comment, View v) {
        if (bd_reader_comment_more.getVisibility() == 0) {
            bd_reader_comment_more.performClick();
        } else {
            n0(comment);
        }
    }

    /* renamed from: Y */
    public /* synthetic */ void Z(final Comment comment, View v) {
        MiConfigSingleton.V3().l3().v3(this.f14782g, comment.getCid(), 0, comment.getHasUp(), new a(comment));
    }

    /* renamed from: a0 */
    public /* synthetic */ void b0(final com.martian.libmars.widget.recyclerview.d holder, final Comment comment, View v) {
        com.martian.mibook.j.v2.X0(this.f14782g, holder.getView(R.id.bd_report), null, null, comment.getCid());
    }

    /* renamed from: c0 */
    public /* synthetic */ void d0(final Comment comment, View v) {
        n0(comment);
    }

    /* renamed from: e0 */
    public /* synthetic */ void f0(final Comment comment, View v) {
        if (comment.getReplyCount() > 3) {
            com.martian.mibook.j.s2.W(this.f14782g, false, comment);
        } else {
            n0(comment);
        }
    }

    /* renamed from: g0 */
    public /* synthetic */ void h0(final Comment comment, View v) {
        if (comment.getReplyCount() > 3) {
            com.martian.mibook.j.s2.W(this.f14782g, false, comment);
        } else {
            n0(comment);
        }
    }

    /* renamed from: i0 */
    public /* synthetic */ void j0(final Comment comment, View v) {
        com.martian.mibook.j.s2.W(this.f14782g, false, comment);
    }

    /* renamed from: k0 */
    public /* synthetic */ void l0(final Comment comment, View v) {
        com.martian.mibook.j.s2.o0(this.f14782g, 1, comment.getCuid());
    }

    @SuppressLint({"SetTextI18n"})
    private void m0(final com.martian.libmars.widget.recyclerview.d holder, final Comment comment) {
        int i2;
        if (comment == null) {
            return;
        }
        final TextView textView = (TextView) holder.getView(R.id.bd_reader_comment);
        final LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.bd_reader_comment_more);
        ImageView imageView = (ImageView) holder.getView(R.id.bd_vip_tag);
        ImageView imageView2 = (ImageView) holder.getView(R.id.bd_sift);
        TextView textView2 = (TextView) holder.getView(R.id.bd_tag);
        TextView textView3 = (TextView) holder.getView(R.id.bd_read_time);
        ImageView imageView3 = (ImageView) holder.getView(R.id.comment_reply_more_icon);
        TextView textView4 = (TextView) holder.getView(R.id.bd_reply_num);
        if (!TextUtils.isEmpty(comment.getContent())) {
            textView.setText(com.martian.libsupport.k.v(comment.getContent()));
        }
        if (!TextUtils.isEmpty(comment.getNickname())) {
            holder.W(R.id.bd_nickname, comment.getNickname());
        }
        if (comment.getUpCount() > 0) {
            holder.W(R.id.bd_vote_upcount, comment.getUpCount() + "");
        } else {
            holder.W(R.id.bd_vote_upcount, this.f14782g.getString(R.string.vote));
        }
        if (comment.getCreatedOn() != null) {
            try {
                holder.W(R.id.bd_comment_time, com.martian.libsupport.d.i(comment.getCreatedOn().longValue(), "yyyy-MM-dd HH:mm"));
            } catch (Exception unused) {
            }
        }
        holder.a0(R.id.bd_vip_tag, comment.getVip());
        if (comment.getHasUp()) {
            holder.K(R.id.bd_vote_upcount_image, R.drawable.vote_upcount_selected);
            holder.X(R.id.bd_vote_upcount, ContextCompat.getColor(this.f14782g, R.color.theme_default));
        } else {
            holder.K(R.id.bd_vote_upcount_image, R.drawable.vote_upcount);
            holder.X(R.id.bd_vote_upcount, com.martian.libmars.d.h.F().r0());
        }
        imageView.setVisibility(comment.getVip() ? 0 : 8);
        if (comment.getTopTime() > 0) {
            textView2.setVisibility(0);
            textView2.setText(this.f10474a.getString(R.string.book_top));
            textView2.setBackgroundResource(R.drawable.mark_green);
        } else if (MiConfigSingleton.V3().w3().equalsIgnoreCase(comment.getCuid())) {
            textView2.setVisibility(0);
            textView2.setText(this.f10474a.getString(R.string.mine));
            textView2.setBackgroundResource(R.drawable.border_button_round_default);
        } else {
            textView2.setVisibility(8);
        }
        imageView2.setVisibility(comment.getSiftTime() > 0 ? 0 : 8);
        if (comment.getReadDuration() > 0) {
            textView3.setVisibility(0);
            textView3.setText("阅读" + com.martian.rpauth.d.i.i(comment.getReadDuration()) + "点评");
        } else {
            textView3.setVisibility(8);
        }
        if (this.f14784i) {
            linearLayout.post(new Runnable() { // from class: com.martian.mibook.ui.o.p0
                @Override // java.lang.Runnable
                public final void run() {
                    LinearLayout linearLayout2 = linearLayout;
                    TextView textView5 = textView;
                    linearLayout2.setVisibility(bd_reader_comment.getLineCount() > 4 ? 0 : 8);
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y3.T(textView, linearLayout, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y3.this.X(linearLayout, comment, view);
                }
            });
        } else {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
        imageView3.setColorFilter(ContextCompat.getColor(this.f10474a, R.color.theme_default_blue));
        com.martian.libmars.utils.n0.o(this.f14782g, comment.getHeader(), (ImageView) holder.getView(R.id.bd_user_header), R.drawable.day_img_heads, MiConfigSingleton.V3().e2());
        int score = comment.getScore();
        int i3 = R.drawable.vote_star_red;
        holder.K(R.id.bd_vote_1, R.drawable.vote_star_red);
        holder.K(R.id.bd_vote_2, score < 40 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        holder.K(R.id.bd_vote_3, score < 60 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        holder.K(R.id.bd_vote_4, score < 80 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
        if (score < 100) {
            i3 = R.drawable.vote_star_grey;
        }
        holder.K(R.id.bd_vote_5, i3);
        holder.N(R.id.bd_vote_view, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.Z(comment, view);
            }
        });
        holder.N(R.id.bd_report, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.b0(holder, comment, view);
            }
        });
        holder.N(R.id.comment_root_view, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.d0(comment, view);
            }
        });
        holder.N(R.id.bd_reply_view, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.f0(comment, view);
            }
        });
        holder.N(R.id.comment_reply_view, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.h0(comment, view);
            }
        });
        holder.N(R.id.comment_reply, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.j0(comment, view);
            }
        });
        holder.N(R.id.bd_user_header, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y3.this.l0(comment, view);
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) holder.getView(R.id.comment_reply_view);
        if (comment.getReplyList().isEmpty()) {
            linearLayout2.setVisibility(8);
            textView4.setText(this.f14782g.getString(R.string.reply));
        } else {
            linearLayout2.setVisibility(0);
            TextView textView5 = (TextView) holder.getView(R.id.comment_reply);
            textView5.setText("");
            if (comment.getReplyCount() > 0) {
                textView4.setText(comment.getReplyCount() + "");
            } else {
                textView4.setText(this.f14782g.getString(R.string.reply));
            }
            int i4 = 0;
            for (CommentReply commentReply : comment.getReplyList()) {
                String content = commentReply.getContent();
                String nickname = commentReply.getNickname();
                if (!com.martian.libsupport.k.p(content) && !com.martian.libsupport.k.p(nickname)) {
                    if (i4 > 0) {
                        textView5.append("\n");
                    }
                    SpannableString spannableString = new SpannableString(nickname);
                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                    spannableString.setSpan(new b(commentReply), 0, nickname.length(), 17);
                    textView5.append(spannableString);
                    String toNickname = commentReply.getToNickname();
                    if (!com.martian.libsupport.k.p(toNickname) && !toNickname.equalsIgnoreCase(comment.getNickname())) {
                        SpannableString spannableString2 = new SpannableString(" " + this.f14782g.getString(R.string.reply) + " " + toNickname);
                        spannableString2.setSpan(new c(commentReply), 0, toNickname.length(), 17);
                        textView5.append(spannableString2);
                    }
                    textView5.append("：" + com.martian.libsupport.k.v(content));
                    i4++;
                    i2 = 3;
                    if (i4 >= 3) {
                        break;
                    }
                } else {
                    i2 = 3;
                }
                if (comment.getReplyCount() > i2) {
                    holder.a0(R.id.comment_reply_more, true);
                    holder.W(R.id.comment_reply_more_content, "查看共" + comment.getReplyCount() + "条回复");
                    holder.N(R.id.comment_reply_more, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.i0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            y3.this.V(comment, view);
                        }
                    });
                } else {
                    holder.a0(R.id.comment_reply_more, false);
                }
            }
        }
        holder.a0(R.id.bd_comment_line, !comment.getCid().equals(R()));
    }

    private void n0(@NonNull final Comment comment) {
        String str = "";
        if (comment.getCid() != null) {
            str = comment.getCid() + "";
        }
        com.martian.mibook.j.v2.e1(this.f14782g, comment.getCid(), this.f14783h.get(str), comment.getNickname(), new d(comment));
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: Q */
    public void b(com.martian.libmars.widget.recyclerview.d helper, Comment comment) {
        m0(helper, comment);
    }
}
