package com.martian.mibook.lib.model.data;

import com.martian.mibook.lib.model.data.abs.UrlItem;

/* loaded from: classes3.dex */
public class MiUrlItem implements UrlItem {
    public String title;
    public String url;

    public MiUrlItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public boolean equals(Object o) {
        if (o instanceof MiUrlItem) {
            return this.url.equals(((MiUrlItem) o).url);
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
        return this.url.hashCode();
    }
}
