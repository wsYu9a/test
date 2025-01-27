package com.shu.priory.conn;

import android.content.Context;
import com.shu.priory.b.c;
import com.shu.priory.bean.AdAudio;
import com.shu.priory.bean.AdImage;
import com.shu.priory.bean.AudioMonitor;
import com.shu.priory.download.DialogListener;
import com.shu.priory.g.b;
import com.shu.priory.param.AdParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class NativeDataRef extends c {
    public NativeDataRef(Context context, b bVar, AdParam adParam, DialogListener dialogListener) {
        super(context, bVar, adParam, dialogListener);
    }

    public abstract AdAudio getAdAudio();

    public abstract List<AdImage> getAdImgList();

    public abstract String getAddress();

    public abstract String getAppName();

    public abstract double getAppSize();

    public abstract String getAppVer();

    public abstract AudioMonitor getAudioMonitor();

    public abstract double getCurrentPrice();

    public abstract ArrayList<String> getDisplayLabels();

    public abstract int getDownloads();

    public abstract List<String> getImgList();

    public abstract int getLikes();

    public abstract double getOriginalPrice();

    public abstract String getPhone();

    public abstract String getRating();

    public abstract String getSponsored();
}
