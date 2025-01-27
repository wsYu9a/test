package com.martian.libmars.widget.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import l9.m0;

/* loaded from: classes3.dex */
public class ViewHolderHelper extends RecyclerView.ViewHolder {

    /* renamed from: b */
    public final SparseArray<View> f12816b;

    /* renamed from: c */
    public int f12817c;

    /* renamed from: d */
    public final View f12818d;

    /* renamed from: e */
    public final Context f12819e;

    /* renamed from: f */
    public int f12820f;

    /* renamed from: g */
    public Object f12821g;

    public ViewHolderHelper(Context context, View view, int i10) {
        super(view);
        this.f12819e = context;
        this.f12817c = i10;
        this.f12816b = new SparseArray<>();
        this.f12818d = view;
    }

    public static ViewHolderHelper b(Context context, ViewGroup viewGroup, int i10) {
        ViewHolderHelper viewHolderHelper = new ViewHolderHelper(context, LayoutInflater.from(context).inflate(i10, viewGroup, false), -1);
        viewHolderHelper.f12820f = i10;
        return viewHolderHelper;
    }

    public ViewHolderHelper A(int i10, String str) {
        ((TextView) g(i10)).setText(str);
        return this;
    }

    public ViewHolderHelper B(int i10, int i11) {
        ((TextView) g(i10)).setTextColor(i11);
        return this;
    }

    public ViewHolderHelper C(int i10, int i11) {
        ((TextView) g(i10)).setTextColor(ContextCompat.getColor(this.f12819e, i11));
        return this;
    }

    public ViewHolderHelper D(Typeface typeface, int... iArr) {
        for (int i10 : iArr) {
            TextView textView = (TextView) g(i10);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public ViewHolderHelper E(int i10, boolean z10) {
        g(i10).setVisibility(z10 ? 0 : 8);
        return this;
    }

    public void F(int i10) {
        this.f12817c = i10;
    }

    public ViewHolderHelper a(int i10, String str, int i11, int i12) {
        m0.z(this.f12819e, str, (ImageView) g(i10), i11, i12);
        return this;
    }

    public View c() {
        return this.f12818d;
    }

    public Object d() {
        return this.f12821g;
    }

    public int e() {
        return this.f12817c;
    }

    public int f() {
        return this.f12820f;
    }

    public <T extends View> T g(int i10) {
        T t10 = (T) this.f12816b.get(i10);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) this.f12818d.findViewById(i10);
        this.f12816b.put(i10, t11);
        return t11;
    }

    public ViewHolderHelper h(int i10) {
        Linkify.addLinks((TextView) g(i10), 15);
        return this;
    }

    @SuppressLint({"NewApi"})
    public ViewHolderHelper i(int i10, float f10) {
        g(i10).setAlpha(f10);
        return this;
    }

    public ViewHolderHelper j(int i10, int i11) {
        g(i10).setBackgroundColor(i11);
        return this;
    }

    public ViewHolderHelper k(int i10, int i11) {
        g(i10).setBackgroundResource(i11);
        return this;
    }

    public ViewHolderHelper l(int i10, boolean z10) {
        ((Checkable) g(i10)).setChecked(z10);
        return this;
    }

    public void m(Object obj) {
        this.f12821g = obj;
    }

    public ViewHolderHelper n(int i10, Bitmap bitmap) {
        ((ImageView) g(i10)).setImageBitmap(bitmap);
        return this;
    }

    public ViewHolderHelper o(int i10, int i11) {
        ((ImageView) g(i10)).setImageResource(i11);
        return this;
    }

    public ViewHolderHelper p(int i10, String str, int i11) {
        m0.l(this.f12819e, str, (ImageView) g(i10), i11);
        return this;
    }

    public ViewHolderHelper q(int i10, int i11) {
        ((ProgressBar) g(i10)).setMax(i11);
        return this;
    }

    public ViewHolderHelper r(int i10, View.OnClickListener onClickListener) {
        g(i10).setOnClickListener(onClickListener);
        return this;
    }

    public ViewHolderHelper s(int i10, View.OnLongClickListener onLongClickListener) {
        g(i10).setOnLongClickListener(onLongClickListener);
        return this;
    }

    public ViewHolderHelper t(int i10, View.OnTouchListener onTouchListener) {
        g(i10).setOnTouchListener(onTouchListener);
        return this;
    }

    public ViewHolderHelper u(int i10, int i11) {
        ((ProgressBar) g(i10)).setProgress(i11);
        return this;
    }

    public ViewHolderHelper v(int i10, int i11, int i12) {
        ProgressBar progressBar = (ProgressBar) g(i10);
        progressBar.setMax(i12);
        progressBar.setProgress(i11);
        return this;
    }

    public ViewHolderHelper w(int i10, float f10) {
        ((RatingBar) g(i10)).setRating(f10);
        return this;
    }

    public ViewHolderHelper x(int i10, float f10, int i11) {
        RatingBar ratingBar = (RatingBar) g(i10);
        ratingBar.setMax(i11);
        ratingBar.setRating(f10);
        return this;
    }

    public ViewHolderHelper y(int i10, int i11, Object obj) {
        g(i10).setTag(i11, obj);
        return this;
    }

    public ViewHolderHelper z(int i10, Object obj) {
        g(i10).setTag(obj);
        return this;
    }
}
