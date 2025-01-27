package com.wbl.ad.yzz.wigdet;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewSwitcher;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public class AutoVerticalScrollTextView extends e implements ViewSwitcher.ViewFactory {

    /* renamed from: a */
    public Context f34396a;

    /* renamed from: b */
    public f f34397b;

    /* renamed from: c */
    public f f34398c;

    /* renamed from: d */
    public c f34399d;

    /* renamed from: e */
    public List<String> f34400e;

    /* renamed from: f */
    public int f34401f;

    /* renamed from: g */
    public int f34402g;

    /* renamed from: h */
    public int f34403h;

    /* renamed from: i */
    public b f34404i;

    /* renamed from: j */
    public float f34405j;
    public float k;
    public int l;
    public String m;
    public com.wbl.ad.yzz.innerconfig.d.d n;
    public boolean o;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8405, this, view);
        }
    }

    public interface b {
        void a(int i2);

        void b(int i2);
    }

    public static class c extends Handler {

        /* renamed from: a */
        public WeakReference<AutoVerticalScrollTextView> f34407a;

        public c(AutoVerticalScrollTextView autoVerticalScrollTextView) {
            this.f34407a = null;
            this.f34407a = new WeakReference<>(autoVerticalScrollTextView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8408, this, message);
        }
    }

    public AutoVerticalScrollTextView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ Context a(AutoVerticalScrollTextView autoVerticalScrollTextView) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8493, null, autoVerticalScrollTextView);
    }

    public static /* synthetic */ c a(AutoVerticalScrollTextView autoVerticalScrollTextView, c cVar) {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8496, null, autoVerticalScrollTextView, cVar);
    }

    public static /* synthetic */ c b(AutoVerticalScrollTextView autoVerticalScrollTextView) {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8495, null, autoVerticalScrollTextView);
    }

    public static /* synthetic */ String c(AutoVerticalScrollTextView autoVerticalScrollTextView) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8490, null, autoVerticalScrollTextView);
    }

    public static /* synthetic */ b e(AutoVerticalScrollTextView autoVerticalScrollTextView) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8492, null, autoVerticalScrollTextView);
    }

    public final f a(boolean z, boolean z2) {
        return (f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8485, this, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public String a(int i2) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8488, this, Integer.valueOf(i2));
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8487, this, null);
    }

    public void a(float f2, int i2, int i3, int i4) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8482, this, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8481, this, dVar);
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8484, this, str);
    }

    public void a(List<String> list, Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8483, this, list, activity);
    }

    public int b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8510, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8509, this, null);
    }

    public void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8512, this, null);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8511, this, null);
    }

    public void setClickLisener(b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8506, this, bVar);
    }

    public void setList(List<String> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8505, this, list);
    }

    public void setSingleData(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8508, this, str);
    }

    public void setTextColor(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8507, this, Integer.valueOf(i2));
    }

    public AutoVerticalScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34401f = 0;
        this.f34402g = 1;
        this.f34403h = 10000;
        this.f34405j = 10.0f;
        this.k = 0.0f;
        this.l = 1;
        this.m = "2倍";
        this.o = false;
        this.f34396a = context;
        this.f34397b = a(true, true);
        this.f34398c = a(false, true);
        setInAnimation(this.f34397b);
        setOutAnimation(this.f34398c);
    }
}
