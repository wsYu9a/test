package com.vivo.mobilead.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class TextDelegate {
    private final LottieAnimationView animationView;
    private boolean cacheText;
    private final c drawable;
    private final Map<String, String> stringMap;

    TextDelegate() {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = null;
        this.drawable = null;
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = lottieAnimationView;
        this.drawable = null;
    }

    public TextDelegate(c cVar) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.drawable = cVar;
        this.animationView = null;
    }

    private String getText(String str) {
        return str;
    }

    private void invalidate() {
        LottieAnimationView lottieAnimationView = this.animationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        c cVar = this.drawable;
        if (cVar != null) {
            cVar.invalidateSelf();
        }
    }

    public final String getTextInternal(String str) {
        if (this.cacheText && this.stringMap.containsKey(str)) {
            return this.stringMap.get(str);
        }
        String text = getText(str);
        if (this.cacheText) {
            this.stringMap.put(str, text);
        }
        return text;
    }

    public void invalidateAllText() {
        this.stringMap.clear();
        invalidate();
    }

    public void invalidateText(String str) {
        this.stringMap.remove(str);
        invalidate();
    }

    public void setCacheText(boolean z) {
        this.cacheText = z;
    }

    public void setText(String str, String str2) {
        this.stringMap.put(str, str2);
        invalidate();
    }
}
