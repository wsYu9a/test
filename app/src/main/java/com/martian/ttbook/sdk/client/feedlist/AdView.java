package com.martian.ttbook.sdk.client.feedlist;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.sdk.client.AdExtras;
import com.martian.ttbook.sdk.client.data.AdData;

/* loaded from: classes4.dex */
public interface AdView extends AdData {
    AdExtras getAdExtras();

    View getView();

    void render();

    void render(Activity activity);
}
