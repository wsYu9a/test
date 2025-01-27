package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {
    private static final String m = "getScrollState";
    private static final String n = "getCurrentItem";
    private static final String o = "setCurrentItem";
    private static final String p = "setOrientation";
    private static final String q = "setAdapter";
    private static final String r = "setOffscreenPageLimit";
    private final b s;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$1 */
    class AnonymousClass1 implements ViewPager2.OnOverScrollListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollEnd() {
            ViewPager2Delegate.this.s.a("onOverScrollEnd");
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollStart() {
            ViewPager2Delegate.this.s.a("onOverScrollStart");
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$2 */
    class AnonymousClass2 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            ViewPager2Delegate.this.s.a("onPageScrollStateChanged", Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            ViewPager2Delegate.this.s.a("onPageScrolled", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            ViewPager2Delegate.this.s.a("onPageSelected", Integer.valueOf(i2));
        }
    }

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.s = b.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.s.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.s.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            AnonymousClass2() {
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                ViewPager2Delegate.this.s.a("onPageScrollStateChanged", Integer.valueOf(i2));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i2, float f2, int i3) {
                ViewPager2Delegate.this.s.a("onPageScrolled", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2Delegate.this.s.a("onPageSelected", Integer.valueOf(i2));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.s.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.s.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.s.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.s.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.s.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.s.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (o.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        }
        if (p.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        }
        if (q.equals(str2) && b.a(objArr, (Class<?>[]) new Class[]{RecyclerView.Adapter.class})) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (!r.equals(str2) || !b.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            return null;
        }
        setOffscreenPageLimit(((Integer) objArr[0]).intValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.s.setTarget(obj);
    }
}
