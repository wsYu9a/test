package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {

    /* renamed from: m */
    private static final String f7100m = "getScrollState";

    /* renamed from: n */
    private static final String f7101n = "getCurrentItem";

    /* renamed from: o */
    private static final String f7102o = "setCurrentItem";

    /* renamed from: p */
    private static final String f7103p = "setOrientation";

    /* renamed from: q */
    private static final String f7104q = "setAdapter";

    /* renamed from: r */
    private static final String f7105r = "setOffscreenPageLimit";

    /* renamed from: s */
    private static final String f7106s = "setUserInputEnabled";

    /* renamed from: t */
    private final c f7107t;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$1 */
    class AnonymousClass1 implements ViewPager2.OnOverScrollListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollEnd() {
            ViewPager2Delegate.this.f7107t.a("onOverScrollEnd");
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollStart() {
            ViewPager2Delegate.this.f7107t.a("onOverScrollStart");
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$2 */
    class AnonymousClass2 extends ViewPager2.OnPageChangeCallback {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            ViewPager2Delegate.this.f7107t.a("onPageScrollStateChanged", Integer.valueOf(i10));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            ViewPager2Delegate.this.f7107t.a("onPageScrolled", Integer.valueOf(i10), Float.valueOf(f10), Integer.valueOf(i11));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            ViewPager2Delegate.this.f7107t.a("onPageSelected", Integer.valueOf(i10));
        }
    }

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f7107t = c.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f7107t.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f7107t.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            public AnonymousClass2() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                ViewPager2Delegate.this.f7107t.a("onPageScrollStateChanged", Integer.valueOf(i10));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i10, float f10, int i11) {
                ViewPager2Delegate.this.f7107t.a("onPageScrolled", Integer.valueOf(i10), Float.valueOf(f10), Integer.valueOf(i11));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2Delegate.this.f7107t.a("onPageSelected", Integer.valueOf(i10));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f7107t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f7107t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f7107t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f7107t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f7107t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f7107t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f7100m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (f7101n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (f7102o.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f7103p.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f7104q.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{RecyclerView.Adapter.class})) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (f7105r.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOffscreenPageLimit(((Integer) objArr[0]).intValue());
            return null;
        }
        if (!f7106s.equals(str2) || !c.a(objArr, (Class<?>[]) new Class[]{Boolean.class})) {
            return null;
        }
        setUserInputEnabled(((Boolean) objArr[0]).booleanValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f7107t.setTarget(obj);
    }
}
