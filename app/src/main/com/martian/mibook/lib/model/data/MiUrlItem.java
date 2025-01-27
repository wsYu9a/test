package com.martian.mibook.lib.model.data;

import com.martian.mibook.lib.model.data.abs.UrlItem;

/* loaded from: classes3.dex */
public class MiUrlItem implements UrlItem {
    public String title;
    public String url;

    public MiUrlItem(String str, String str2) {
        this.title = str;
        this.url = str2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MiUrlItem) {
            return this.url.equals(((MiUrlItem) obj).url);
        }
        return false;
    }

    @Override // com.martian.mibook.lib.model.data.abs.UrlItem
    public String getTitle() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.UrlItem
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
