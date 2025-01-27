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
import com.martian.libmars.utils.n0;

/* loaded from: classes2.dex */
public class d extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final SparseArray<View> f10463a;

    /* renamed from: b */
    private int f10464b;

    /* renamed from: c */
    private final View f10465c;

    /* renamed from: d */
    private final Context f10466d;

    /* renamed from: e */
    private int f10467e;

    public d(Context context, View itemView, int position) {
        super(itemView);
        this.f10466d = context;
        this.f10464b = position;
        this.f10463a = new SparseArray<>();
        this.f10465c = itemView;
    }

    public static d b(Context context, ViewGroup parent, int layoutId) {
        d dVar = new d(context, LayoutInflater.from(context).inflate(layoutId, parent, false), -1);
        dVar.f10467e = layoutId;
        return dVar;
    }

    public View B() {
        return this.f10465c;
    }

    public int C() {
        return this.f10467e;
    }

    public int D() {
        return this.f10464b;
    }

    public d E(int viewId) {
        Linkify.addLinks((TextView) getView(viewId), 15);
        return this;
    }

    @SuppressLint({"NewApi"})
    public d F(int viewId, float value) {
        getView(viewId).setAlpha(value);
        return this;
    }

    public d G(int viewId, int color) {
        getView(viewId).setBackgroundColor(color);
        return this;
    }

    public d H(int viewId, int backgroundRes) {
        getView(viewId).setBackgroundResource(backgroundRes);
        return this;
    }

    public d I(int viewId, boolean checked) {
        ((Checkable) getView(viewId)).setChecked(checked);
        return this;
    }

    public d J(int viewId, Bitmap bitmap) {
        ((ImageView) getView(viewId)).setImageBitmap(bitmap);
        return this;
    }

    public d K(int viewId, int resId) {
        ((ImageView) getView(viewId)).setImageResource(resId);
        return this;
    }

    public d L(int viewId, String url, int defaultResId) {
        n0.l(this.f10466d, url, (ImageView) getView(viewId), defaultResId);
        return this;
    }

    public d M(int viewId, int max) {
        ((ProgressBar) getView(viewId)).setMax(max);
        return this;
    }

    public d N(int viewId, View.OnClickListener listener) {
        getView(viewId).setOnClickListener(listener);
        return this;
    }

    public d O(int viewId, View.OnLongClickListener listener) {
        getView(viewId).setOnLongClickListener(listener);
        return this;
    }

    public d P(int viewId, View.OnTouchListener listener) {
        getView(viewId).setOnTouchListener(listener);
        return this;
    }

    public d Q(int viewId, int progress) {
        ((ProgressBar) getView(viewId)).setProgress(progress);
        return this;
    }

    public d R(int viewId, int progress, int max) {
        ProgressBar progressBar = (ProgressBar) getView(viewId);
        progressBar.setMax(max);
        progressBar.setProgress(progress);
        return this;
    }

    public d S(int viewId, float rating) {
        ((RatingBar) getView(viewId)).setRating(rating);
        return this;
    }

    public d T(int viewId, float rating, int max) {
        RatingBar ratingBar = (RatingBar) getView(viewId);
        ratingBar.setMax(max);
        ratingBar.setRating(rating);
        return this;
    }

    public d U(int viewId, int key, Object tag) {
        getView(viewId).setTag(key, tag);
        return this;
    }

    public d V(int viewId, Object tag) {
        getView(viewId).setTag(tag);
        return this;
    }

    public d W(int viewId, String text) {
        ((TextView) getView(viewId)).setText(text);
        return this;
    }

    public d X(int viewId, int textColor) {
        ((TextView) getView(viewId)).setTextColor(textColor);
        return this;
    }

    public d Y(int viewId, int textColorRes) {
        ((TextView) getView(viewId)).setTextColor(ContextCompat.getColor(this.f10466d, textColorRes));
        return this;
    }

    public d Z(Typeface typeface, int... viewIds) {
        for (int i2 : viewIds) {
            TextView textView = (TextView) getView(i2);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public d a(int viewId, String url, int radius, int defaultResId) {
        n0.z(this.f10466d, url, (ImageView) getView(viewId), radius, defaultResId);
        return this;
    }

    public d a0(int viewId, boolean visible) {
        getView(viewId).setVisibility(visible ? 0 : 8);
        return this;
    }

    public void b0(int position) {
        this.f10464b = position;
    }

    public <T extends View> T getView(int i2) {
        T t = (T) this.f10463a.get(i2);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.f10465c.findViewById(i2);
        this.f10463a.put(i2, t2);
        return t2;
    }
}
