package c.a.a.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import c.a.a.a.a.o;

/* loaded from: classes5.dex */
public class v extends o {

    /* renamed from: a */
    protected static final String f5158a = "message";

    /* renamed from: b */
    protected static final String f5159b = "title";

    /* renamed from: c */
    protected static final String f5160c = "positive_button";

    /* renamed from: d */
    protected static final String f5161d = "negative_button";

    /* renamed from: e */
    protected static final String f5162e = "neutral_button";

    /* renamed from: f */
    protected int f5163f;

    public static class a extends n<a> {
        private String o;
        private CharSequence p;
        private String q;
        private String r;
        private String s;
        private boolean t;

        protected a(Context context, FragmentManager fragmentManager) {
            super(context, fragmentManager, v.class);
            this.t = true;
        }

        @Override // c.a.a.a.a.n
        protected Bundle c() {
            if (this.t && this.q == null && this.r == null) {
                this.q = "关闭";
            }
            Bundle bundle = new Bundle();
            bundle.putCharSequence("message", this.p);
            bundle.putString("title", this.o);
            bundle.putString(v.f5160c, this.q);
            bundle.putString(v.f5161d, this.r);
            bundle.putString(v.f5162e, this.s);
            return bundle;
        }

        public a m(boolean hide) {
            this.t = !hide;
            return this;
        }

        @Override // c.a.a.a.a.n
        /* renamed from: n */
        public a d() {
            return this;
        }

        public a o(int messageResourceId) {
            this.p = this.f5140f.getText(messageResourceId);
            return this;
        }

        public a p(int resourceId, Object... formatArgs) {
            this.p = Html.fromHtml(String.format(Html.toHtml(new SpannedString(this.f5140f.getText(resourceId))), formatArgs));
            return this;
        }

        public a q(CharSequence message) {
            this.p = message;
            return this;
        }

        public a r(int textResourceId) {
            this.r = this.f5140f.getString(textResourceId);
            return this;
        }

        public a s(String text) {
            this.r = text;
            return this;
        }

        public a t(int textResourceId) {
            this.s = this.f5140f.getString(textResourceId);
            return this;
        }

        public a u(String text) {
            this.s = text;
            return this;
        }

        public a v(int textResourceId) {
            this.q = this.f5140f.getString(textResourceId);
            return this;
        }

        public a w(String text) {
            this.q = text;
            return this;
        }

        public a x(int titleResourceId) {
            this.o = this.f5140f.getString(titleResourceId);
            return this;
        }

        public a y(String title) {
            this.o = title;
            return this;
        }
    }

    public static a f(Context context, FragmentManager fragmentManager) {
        return new a(context, fragmentManager);
    }

    /* renamed from: n */
    public /* synthetic */ void o(DialogInterface dialog, int which) {
        t h2 = h();
        if (h2 != null) {
            h2.c(this.f5163f);
        }
    }

    /* renamed from: p */
    public /* synthetic */ void q(DialogInterface dialog, int which) {
        t h2 = h();
        if (h2 != null) {
            h2.b(this.f5163f);
        }
    }

    /* renamed from: r */
    public /* synthetic */ void s(DialogInterface dialog, int which) {
        t h2 = h();
        if (h2 != null) {
            h2.a(this.f5163f);
        }
    }

    @Override // c.a.a.a.a.o
    protected o.a a(o.a builder) {
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            builder.c0(m);
        }
        CharSequence i2 = i();
        if (!TextUtils.isEmpty(i2)) {
            builder.Q(i2);
        }
        String l = l();
        if (!TextUtils.isEmpty(l)) {
            builder.W(l, new DialogInterface.OnClickListener() { // from class: c.a.a.a.a.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    v.this.o(dialogInterface, i3);
                }
            });
        }
        String j2 = j();
        if (!TextUtils.isEmpty(j2)) {
            builder.S(j2, new DialogInterface.OnClickListener() { // from class: c.a.a.a.a.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    v.this.q(dialogInterface, i3);
                }
            });
        }
        String k = k();
        if (!TextUtils.isEmpty(k)) {
            builder.U(k, new DialogInterface.OnClickListener() { // from class: c.a.a.a.a.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    v.this.s(dialogInterface, i3);
                }
            });
        }
        return builder;
    }

    protected s g() {
        LifecycleOwner targetFragment = getTargetFragment();
        if (targetFragment != null) {
            if (targetFragment instanceof s) {
                return (s) targetFragment;
            }
            return null;
        }
        if (getActivity() instanceof s) {
            return (s) getActivity();
        }
        return null;
    }

    protected t h() {
        LifecycleOwner targetFragment = getTargetFragment();
        if (targetFragment != null) {
            if (targetFragment instanceof t) {
                return (t) targetFragment;
            }
            return null;
        }
        if (getActivity() instanceof t) {
            return (t) getActivity();
        }
        return null;
    }

    protected CharSequence i() {
        return getArguments() == null ? "" : getArguments().getCharSequence("message");
    }

    protected String j() {
        return getArguments() == null ? "" : getArguments().getString(f5161d);
    }

    protected String k() {
        return getArguments() == null ? "" : getArguments().getString(f5162e);
    }

    protected String l() {
        return getArguments() == null ? "" : getArguments().getString(f5160c);
    }

    protected String m() {
        return getArguments() == null ? "" : getArguments().getString("title");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getTargetFragment() != null) {
            this.f5163f = getTargetRequestCode();
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f5163f = arguments.getInt(n.f5135a, 0);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        s g2 = g();
        if (g2 != null) {
            g2.a(this.f5163f);
        }
    }
}
