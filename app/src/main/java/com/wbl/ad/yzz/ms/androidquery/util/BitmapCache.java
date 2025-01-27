package com.wbl.ad.yzz.ms.androidquery.util;

import android.graphics.Bitmap;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class BitmapCache extends LinkedHashMap<String, Bitmap> {
    private static final long serialVersionUID = 1;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;

    public BitmapCache(int i2, int i3, int i4) {
        super(8, 0.75f, true);
        this.maxCount = i2;
        this.maxPixels = i3;
        this.maxTotalPixels = i4;
    }

    public final int a(Bitmap bitmap) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12702, this, bitmap);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12701, this, null);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12704, this, null);
    }

    public Bitmap put(String str, Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12703, this, str, bitmap);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12698, this, obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Bitmap remove(Object obj) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12697, this, obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12700, this, obj);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12699, this, entry);
    }
}
