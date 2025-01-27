package com.wbl.ad.yzz.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.Keep;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u001b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002H\u0017¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u0006*\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0010\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0013J#\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J#\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0013J#\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0013J#\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\u0013J#\u0010$\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\u0013J!\u0010'\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010)\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010(J!\u0010,\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010+\u001a\u00020%H\u0016¢\u0006\u0004\b,\u0010(R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "B", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "viewId", "getView", "(I)Landroid/view/View;", "getViewOrNull", "findView", "", Downloads.RequestHeaders.COLUMN_VALUE, "setText", "(ILjava/lang/CharSequence;)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "strId", "(II)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "color", "setTextColor", "colorRes", "setTextColorRes", "imageResId", "setImageResource", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(ILandroid/graphics/drawable/Drawable;)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Landroid/graphics/Bitmap;", "bitmap", "setImageBitmap", "(ILandroid/graphics/Bitmap;)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "setBackgroundColor", "backgroundRes", "setBackgroundResource", "", "isVisible", "setVisible", "(IZ)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "isGone", "setGone", "isEnabled", "setEnabled", "Landroid/util/SparseArray;", OapsKey.KEY_VIEWS, "Landroid/util/SparseArray;", "view", "<init>", "(Landroid/view/View;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(@d View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.views = new SparseArray<>();
    }

    public <T extends View> T findView(int i2) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16013, this, Integer.valueOf(i2));
    }

    public <B extends ViewDataBinding> B getBinding() {
        return (B) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16016, this, null);
    }

    public <T extends View> T getView(int viewId) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16015, this, Integer.valueOf(viewId));
    }

    public <T extends View> T getViewOrNull(int viewId) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16010, this, Integer.valueOf(viewId));
    }

    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16009, this, Integer.valueOf(viewId), Integer.valueOf(color));
    }

    public BaseViewHolder setBackgroundResource(int viewId, int backgroundRes) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16012, this, Integer.valueOf(viewId), Integer.valueOf(backgroundRes));
    }

    public BaseViewHolder setEnabled(int viewId, boolean isEnabled) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16011, this, Integer.valueOf(viewId), Boolean.valueOf(isEnabled));
    }

    public BaseViewHolder setGone(int viewId, boolean isGone) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16006, this, Integer.valueOf(viewId), Boolean.valueOf(isGone));
    }

    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16005, this, Integer.valueOf(viewId), bitmap);
    }

    public BaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16008, this, Integer.valueOf(viewId), drawable);
    }

    public BaseViewHolder setImageResource(int viewId, int imageResId) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16007, this, Integer.valueOf(viewId), Integer.valueOf(imageResId));
    }

    public BaseViewHolder setText(int viewId, int strId) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16002, this, Integer.valueOf(viewId), Integer.valueOf(strId));
    }

    public BaseViewHolder setText(int viewId, CharSequence r4) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16001, this, Integer.valueOf(viewId), r4);
    }

    public BaseViewHolder setTextColor(int viewId, int color) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16004, this, Integer.valueOf(viewId), Integer.valueOf(color));
    }

    public BaseViewHolder setTextColorRes(int viewId, int colorRes) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16003, this, Integer.valueOf(viewId), Integer.valueOf(colorRes));
    }

    public BaseViewHolder setVisible(int viewId, boolean isVisible) {
        return (BaseViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16030, this, Integer.valueOf(viewId), Boolean.valueOf(isVisible));
    }
}
