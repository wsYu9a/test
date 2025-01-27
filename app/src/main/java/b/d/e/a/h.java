package b.d.e.a;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.sdk.client.AdLoadListener;
import com.martian.ttbook.sdk.client.NativeAdData;
import com.martian.ttbook.sdk.client.data.AdDataListener;
import com.martian.ttbook.sdk.client.data.BindParameters;

/* loaded from: classes4.dex */
public class h implements NativeAdData {
    @Override // com.martian.ttbook.sdk.client.data.AdDataBinder
    /* renamed from: a */
    public View bindAdData(BindParameters bindParameters, AdDataListener adDataListener) {
        return null;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdData
    public void attach(Activity activity) {
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdDataComm
    public int getDataSource() {
        return 0;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdLoader
    public boolean isLoaded() {
        return true;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdLoader
    public boolean load(AdLoadListener adLoadListener) {
        adLoadListener.onLoadCompleted();
        return true;
    }
}
