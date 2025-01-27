package com.martian.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannedString;
import android.view.View;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* loaded from: classes2.dex */
public class g extends e {

    /* renamed from: c */
    protected static final String f9695c = "arg_tag";

    /* renamed from: d */
    private String f9696d;

    public static class a extends d<a> {
        protected a(Context context, FragmentManager fragmentManager) {
            super(context, fragmentManager, g.class);
        }

        public a A(CharSequence message) {
            this.o.Q(message);
            return d();
        }

        public a B(int textResourceId, DialogInterface.OnClickListener listener) {
            this.o.R(textResourceId, listener);
            return d();
        }

        public a C(DialogInterface.OnClickListener listener) {
            return B(R.string.cancel, listener);
        }

        public a D(String text, DialogInterface.OnClickListener listener) {
            this.o.S(text, listener);
            return d();
        }

        public a E(int textResourceId, DialogInterface.OnClickListener listener) {
            this.o.T(textResourceId, listener);
            return d();
        }

        public a F(String text, DialogInterface.OnClickListener listener) {
            this.o.U(text, listener);
            return d();
        }

        public a G(int textResourceId, DialogInterface.OnClickListener listener) {
            this.o.V(textResourceId, listener);
            return d();
        }

        public a H(DialogInterface.OnClickListener listener) {
            G(R.string.confirm, listener);
            return d();
        }

        public a I(String text, DialogInterface.OnClickListener listener) {
            this.o.W(text, listener);
            return d();
        }

        public a J(ListAdapter adapter, int checkedItemIdx, final DialogInterface.OnClickListener l) {
            this.o.X(adapter, checkedItemIdx, true, l);
            return d();
        }

        public a K(ListAdapter adapter, int checkedItemIdx, boolean autoDismiss, final DialogInterface.OnClickListener l) {
            this.o.X(adapter, checkedItemIdx, autoDismiss, l);
            return d();
        }

        public a L(List objects, int checkedItemIdx, final DialogInterface.OnClickListener listener) {
            if (objects == null) {
                throw new IllegalStateException();
            }
            this.o.Y(objects, checkedItemIdx, true, listener);
            return d();
        }

        public a M(List objects, int checkedItemIdx, boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            if (objects == null) {
                throw new IllegalStateException();
            }
            this.o.Y(objects, checkedItemIdx, autoDismiss, listener);
            return d();
        }

        public <T> a N(T[] items, int checkedItemIdx, final DialogInterface.OnClickListener listener) {
            this.o.Z(items, checkedItemIdx, true, listener);
            return d();
        }

        public <T> a O(T[] items, int checkedItemIdx, boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.o.Z(items, checkedItemIdx, autoDismiss, listener);
            return d();
        }

        public a P(String[] items, int checkedItemIdx, final DialogInterface.OnClickListener listener) {
            this.o.a0(items, checkedItemIdx, true, listener);
            return d();
        }

        public a Q(String[] items, int checkedItemIdx, boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.o.a0(items, checkedItemIdx, autoDismiss, listener);
            return d();
        }

        public a R(View view) {
            this.o.d0(view);
            return d();
        }

        public a S(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
            this.o.e0(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
            return d();
        }

        @Override // c.a.a.a.a.n
        protected Bundle c() {
            Bundle bundle = new Bundle();
            bundle.putString(g.f9695c, this.m);
            return bundle;
        }

        @Override // c.a.a.a.a.n
        /* renamed from: s */
        public a d() {
            return this;
        }

        public a t(int resourceId) {
            this.o.J(resourceId);
            return d();
        }

        public a u(Drawable drawable) {
            this.o.K(drawable);
            return d();
        }

        public a v(ListAdapter listAdapter, int checkedItemIdx, final DialogInterface.OnClickListener l) {
            this.o.L(listAdapter, checkedItemIdx, l);
            return d();
        }

        public a w(List objects, final DialogInterface.OnClickListener l) {
            this.o.N(objects, l);
            return d();
        }

        public a x(String[] items, final DialogInterface.OnClickListener l) {
            this.o.O(items, l);
            return d();
        }

        public a y(int messageResourceId) {
            this.o.P(messageResourceId);
            return d();
        }

        public a z(int resourceId, Object... formatArgs) {
            this.o.Q(Html.fromHtml(String.format(Html.toHtml(new SpannedString(this.f5140f.getText(resourceId))), formatArgs)));
            return d();
        }
    }

    public static a h(Context context, FragmentManager fragmentManager) {
        return new a(context, fragmentManager);
    }

    public static a i(FragmentActivity context) {
        return new a(context, context.getSupportFragmentManager());
    }

    public String j() {
        return this.f9696d;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            this.f9696d = savedInstanceState.getString(f9695c);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f9696d = arguments.getString(f9695c);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(f9695c, this.f9696d);
    }
}
