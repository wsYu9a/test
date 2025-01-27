package c.a.a.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import c.a.a.a.a.o;
import com.martian.dialog.R;

/* loaded from: classes5.dex */
public class u extends o {

    /* renamed from: a */
    protected static final String f5155a = "message";

    /* renamed from: b */
    protected static final String f5156b = "title";

    /* renamed from: c */
    protected int f5157c;

    public static class a extends n<a> {
        private String o;
        private String p;

        protected a(Context context, FragmentManager fragmentManager) {
            super(context, fragmentManager, u.class);
        }

        @Override // c.a.a.a.a.n
        protected Bundle c() {
            Bundle bundle = new Bundle();
            bundle.putString("message", this.p);
            bundle.putString("title", this.o);
            return bundle;
        }

        @Override // c.a.a.a.a.n
        /* renamed from: m */
        public a d() {
            return this;
        }

        public a n(int messageResourceId) {
            this.p = this.f5140f.getString(messageResourceId);
            return this;
        }

        public a o(String message) {
            this.p = message;
            return this;
        }

        public a p(int titleResourceId) {
            this.o = this.f5140f.getString(titleResourceId);
            return this;
        }

        public a q(String title) {
            this.o = title;
            return this;
        }
    }

    public static a f(Context context, FragmentManager fragmentManager) {
        return new a(context, fragmentManager);
    }

    @Override // c.a.a.a.a.o
    protected o.a a(o.a builder) {
        if (getActivity() == null) {
            return builder;
        }
        int color = getResources().getColor(R.color.sdl_message_text_dark);
        TypedArray obtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.DialogStyle, R.attr.sdlDialogStyle, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.DialogStyle_messageTextColor, color);
        obtainStyledAttributes.recycle();
        View inflate = builder.l().inflate(R.layout.dialog_part_progress, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.sdl__message);
        if (getArguments() != null) {
            textView.setText(getArguments().getString("message"));
            builder.c0(getArguments().getString("title"));
        }
        textView.setTextColor(color2);
        builder.d0(inflate);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() == null) {
            throw new IllegalArgumentException("use ProgressDialogBuilder to construct this dialog");
        }
        this.f5157c = getTargetFragment() != null ? getTargetRequestCode() : getArguments().getInt(n.f5135a, 0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        s g2 = g();
        if (g2 != null) {
            g2.a(this.f5157c);
        }
    }
}
