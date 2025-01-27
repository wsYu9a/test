package com.wbl.ad.yzz.ms.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.c.b;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public abstract class b<T extends b<T>> implements com.wbl.ad.yzz.ms.c.c.a {

    /* renamed from: a */
    public View f33050a;

    /* renamed from: b */
    public Activity f33051b;

    /* renamed from: c */
    public Context f33052c;

    /* renamed from: d */
    public View f33053d;

    static {
        Class cls = Integer.TYPE;
        Class cls2 = Long.TYPE;
        new WeakHashMap();
    }

    public b(Activity activity) {
        this.f33051b = activity;
    }

    public ImageView a() {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12784, this, null);
    }

    public T a(int i2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12783, this, Integer.valueOf(i2));
    }

    public T a(int i2, Animation.AnimationListener animationListener) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12778, this, Integer.valueOf(i2), animationListener);
    }

    public T a(View.OnClickListener onClickListener) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12777, this, onClickListener);
    }

    public T a(View view) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12780, this, view);
    }

    public T a(Animation animation) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12779, this, animation);
    }

    public T a(CharSequence charSequence) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12774, this, charSequence);
    }

    public T a(String str) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12773, this, str);
    }

    public T a(String str, boolean z, boolean z2, int i2, int i3) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12776, this, str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public T a(String str, boolean z, boolean z2, int i2, int i3, Bitmap bitmap, int i4) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12775, this, str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), bitmap, Integer.valueOf(i4));
    }

    public T a(String str, boolean z, boolean z2, int i2, int i3, Bitmap bitmap, int i4, float f2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12770, this, str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), bitmap, Integer.valueOf(i4), Float.valueOf(f2));
    }

    public T a(String str, boolean z, boolean z2, int i2, int i3, Bitmap bitmap, int i4, float f2, int i5, String str2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12769, this, str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), bitmap, Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5), str2);
    }

    public final View b(int i2) {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12772, this, Integer.valueOf(i2));
    }

    public ProgressBar b() {
        return (ProgressBar) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12771, this, null);
    }

    public TextView c() {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12798, this, null);
    }

    public T c(int i2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12797, this, Integer.valueOf(i2));
    }

    public View d() {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12800, this, null);
    }

    public T d(int i2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12799, this, Integer.valueOf(i2));
    }

    public WebView e() {
        return (WebView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12794, this, null);
    }

    public T f() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12793, this, null);
    }

    public T g() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12796, this, null);
    }

    public Context getContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12795, this, null);
    }

    public void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12790, this, null);
    }

    public final T i() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12789, this, null);
    }

    public T j() {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12792, this, null);
    }

    public b(View view) {
        this.f33050a = view;
        this.f33053d = view;
    }

    public b(Context context) {
        this.f33052c = context;
    }
}
