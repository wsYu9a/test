package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\b\u0007\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB+\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\n\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010%J/\u0010)\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u001aH\u0016¢\u0006\u0004\b)\u0010*J/\u0010,\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u001aH\u0016¢\u0006\u0004\b,\u0010*J\u000f\u0010-\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010.J\u000f\u00102\u001a\u00020\u0011H\u0016¢\u0006\u0004\b2\u0010\u0013J\u000f\u00103\u001a\u00020\u0011H\u0014¢\u0006\u0004\b3\u0010\u0013J\u000f\u00104\u001a\u00020\u0011H\u0014¢\u0006\u0004\b4\u0010\u0013R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00106R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u00108R\u0014\u00109\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u00108R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010:R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010;R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010;R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010;R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010A¨\u0006C"}, d2 = {"Lcom/martian/libmars/utils/tablayout/ImagePagerTitleView;", "Landroid/widget/RelativeLayout;", "Lcom/martian/libmars/utils/tablayout/CommonNavigator$b;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageWith", "imageHeight", "", "mMaxScale", "(Landroid/content/Context;IIF)V", "", "a", "()V", "dayUnSelectedIconRes", "daySelectedIconRes", "nightUnSelectedIconRes", "nightSelectedIconRes", "g", "(IIII)V", "", "minScaleType", "setMinScaleType", "(Z)V", "defaultColorFilter", "selectColorFilter", "f", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "index", "totalCount", "d", "(II)V", "b", "leavePercent", "leftToRight", e.TAG, "(IIFZ)V", "enterPercent", "c", "getContentLeft", "()I", "getContentTop", "getContentRight", "getContentBottom", "p", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mImageView", "F", "mMinScale", "Z", "I", "h", "i", "j", "k", t.f11204d, "Ljava/lang/Integer;", "m", "libmars_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nImagePagerTitleView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImagePagerTitleView.kt\ncom/martian/libmars/utils/tablayout/ImagePagerTitleView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,190:1\n1#2:191\n*E\n"})
/* loaded from: classes3.dex */
public final class ImagePagerTitleView extends RelativeLayout implements CommonNavigator.b, k9.a {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public ImageView mImageView;

    /* renamed from: c, reason: from kotlin metadata */
    public float mMaxScale;

    /* renamed from: d, reason: from kotlin metadata */
    public final float mMinScale;

    /* renamed from: e */
    public boolean minScaleType;

    /* renamed from: f, reason: from kotlin metadata */
    public int imageWith;

    /* renamed from: g, reason: from kotlin metadata */
    public int imageHeight;

    /* renamed from: h, reason: from kotlin metadata */
    public int dayUnSelectedIconRes;

    /* renamed from: i, reason: from kotlin metadata */
    public int daySelectedIconRes;

    /* renamed from: j, reason: from kotlin metadata */
    public int nightUnSelectedIconRes;

    /* renamed from: k, reason: from kotlin metadata */
    public int nightSelectedIconRes;

    /* renamed from: l */
    @l
    public Integer defaultColorFilter;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public Integer selectColorFilter;

    @JvmOverloads
    public ImagePagerTitleView(@l Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a() {
        setGravity(17);
        ImageView imageView = new ImageView(getContext());
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.imageWith, this.imageHeight);
        layoutParams.addRule(12);
        ImageView imageView2 = this.mImageView;
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams);
        }
        addView(this.mImageView);
    }

    @Override // m9.g
    public void b(int index, int totalCount) {
        Integer num;
        setSelected(false);
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setScaleX(1.0f);
        }
        ImageView imageView2 = this.mImageView;
        if (imageView2 != null) {
            imageView2.setScaleY(1.0f);
        }
        ImageView imageView3 = this.mImageView;
        if (imageView3 != null) {
            imageView3.setTranslationY(0.0f);
        }
        if (ConfigSingleton.D().A0()) {
            ImageView imageView4 = this.mImageView;
            if (imageView4 != null) {
                imageView4.setImageResource(this.nightUnSelectedIconRes);
            }
        } else {
            ImageView imageView5 = this.mImageView;
            if (imageView5 != null) {
                imageView5.setImageResource(this.dayUnSelectedIconRes);
            }
        }
        if (isSelected() || (num = this.defaultColorFilter) == null) {
            return;
        }
        int intValue = num.intValue();
        ImageView imageView6 = this.mImageView;
        if (imageView6 != null) {
            imageView6.setColorFilter(intValue);
        }
    }

    @Override // m9.g
    public void c(int index, int totalCount, float enterPercent, boolean leftToRight) {
        if (this.minScaleType) {
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                float f10 = this.mMinScale;
                imageView.setScaleX(f10 + ((1.0f - f10) * enterPercent));
            }
            ImageView imageView2 = this.mImageView;
            if (imageView2 == null) {
                return;
            }
            float f11 = this.mMinScale;
            imageView2.setScaleY(f11 + ((1.0f - f11) * enterPercent));
            return;
        }
        ImageView imageView3 = this.mImageView;
        if (imageView3 != null) {
            imageView3.setTranslationY(((-(this.mMaxScale - 1)) * this.imageHeight) / 2);
        }
        ImageView imageView4 = this.mImageView;
        if (imageView4 != null) {
            imageView4.setScaleX(((this.mMaxScale - 1.0f) * enterPercent) + 1.0f);
        }
        ImageView imageView5 = this.mImageView;
        if (imageView5 == null) {
            return;
        }
        imageView5.setScaleY(((this.mMaxScale - 1.0f) * enterPercent) + 1.0f);
    }

    @Override // m9.g
    public void d(int index, int totalCount) {
        Integer num;
        setSelected(true);
        if (this.minScaleType) {
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setScaleX(this.mMinScale);
            }
            ImageView imageView2 = this.mImageView;
            if (imageView2 != null) {
                imageView2.setScaleY(this.mMinScale);
            }
        } else {
            ImageView imageView3 = this.mImageView;
            if (imageView3 != null) {
                imageView3.setScaleX(this.mMaxScale);
            }
            ImageView imageView4 = this.mImageView;
            if (imageView4 != null) {
                imageView4.setScaleY(this.mMaxScale);
            }
            ImageView imageView5 = this.mImageView;
            if (imageView5 != null) {
                imageView5.setTranslationY(((-(this.mMaxScale - 1)) * this.imageHeight) / 2);
            }
        }
        if (ConfigSingleton.D().A0()) {
            ImageView imageView6 = this.mImageView;
            if (imageView6 != null) {
                imageView6.setImageResource(this.nightSelectedIconRes);
            }
        } else {
            ImageView imageView7 = this.mImageView;
            if (imageView7 != null) {
                imageView7.setImageResource(this.daySelectedIconRes);
            }
        }
        if (!isSelected() || (num = this.selectColorFilter) == null) {
            return;
        }
        int intValue = num.intValue();
        ImageView imageView8 = this.mImageView;
        if (imageView8 != null) {
            imageView8.setColorFilter(intValue);
        }
    }

    @Override // m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
        if (this.minScaleType) {
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setScaleX(((this.mMinScale - 1.0f) * f10) + 1.0f);
            }
            ImageView imageView2 = this.mImageView;
            if (imageView2 == null) {
                return;
            }
            imageView2.setScaleY(((this.mMinScale - 1.0f) * f10) + 1.0f);
            return;
        }
        ImageView imageView3 = this.mImageView;
        if (imageView3 != null) {
            imageView3.setTranslationY(0.0f);
        }
        ImageView imageView4 = this.mImageView;
        if (imageView4 != null) {
            float f11 = this.mMaxScale;
            imageView4.setScaleX(f11 + ((1.0f - f11) * f10));
        }
        ImageView imageView5 = this.mImageView;
        if (imageView5 == null) {
            return;
        }
        float f12 = this.mMaxScale;
        imageView5.setScaleY(f12 + ((1.0f - f12) * f10));
    }

    public final void f(@l Integer defaultColorFilter, @l Integer selectColorFilter) {
        this.defaultColorFilter = defaultColorFilter;
        this.selectColorFilter = selectColorFilter;
    }

    public final void g(int dayUnSelectedIconRes, int daySelectedIconRes, int nightUnSelectedIconRes, int nightSelectedIconRes) {
        this.dayUnSelectedIconRes = dayUnSelectedIconRes;
        this.daySelectedIconRes = daySelectedIconRes;
        this.nightUnSelectedIconRes = nightUnSelectedIconRes;
        this.nightSelectedIconRes = nightSelectedIconRes;
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentBottom() {
        return getBottom();
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentLeft() {
        return getLeft();
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentRight() {
        return getRight();
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentTop() {
        return getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (ConfigSingleton.D().A0()) {
            if (isSelected()) {
                ImageView imageView = this.mImageView;
                if (imageView != null) {
                    imageView.setImageResource(this.nightSelectedIconRes);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.mImageView;
            if (imageView2 != null) {
                imageView2.setImageResource(this.nightUnSelectedIconRes);
                return;
            }
            return;
        }
        if (isSelected()) {
            ImageView imageView3 = this.mImageView;
            if (imageView3 != null) {
                imageView3.setImageResource(this.daySelectedIconRes);
                return;
            }
            return;
        }
        ImageView imageView4 = this.mImageView;
        if (imageView4 != null) {
            imageView4.setImageResource(this.dayUnSelectedIconRes);
        }
    }

    public final void setMinScaleType(boolean minScaleType) {
        this.minScaleType = minScaleType;
    }

    @JvmOverloads
    public ImagePagerTitleView(@l Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ImagePagerTitleView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @JvmOverloads
    public ImagePagerTitleView(@l Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMaxScale = 1.15f;
        this.mMinScale = 0.89f;
    }

    public ImagePagerTitleView(@l Context context, int i10, int i11, float f10) {
        this(context, null, 0, 6, null);
        this.mMaxScale = f10;
        float f11 = i10;
        float f12 = f10 - 1;
        this.imageWith = (int) (f11 + (f11 * f12 * 4));
        float f13 = i11;
        this.imageHeight = (int) (f13 + (f12 * f13 * 2));
        a();
    }
}
