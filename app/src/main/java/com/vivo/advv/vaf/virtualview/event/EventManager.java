package com.vivo.advv.vaf.virtualview.event;

import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class EventManager {
    private static final String TAG = "EventManager_TMTEST";
    public static final int TYPE_COUNT = 6;
    public static final int TYPE_Click = 0;
    public static final int TYPE_Exposure = 1;
    public static final int TYPE_FlipPage = 3;
    public static final int TYPE_Load = 2;
    public static final int TYPE_LongCLick = 4;
    public static final int TYPE_Touch = 5;
    private Object[] mProcessor = new Object[6];

    public boolean emitEvent(int i2, EventData eventData) {
        List list;
        boolean z = false;
        z = false;
        if (((i2 < 6) & (i2 >= 0)) && (list = (List) this.mProcessor[i2]) != null) {
            int size = list.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                z2 = ((IEventProcessor) list.get(i3)).process(eventData);
            }
            z = z2;
        }
        if (eventData != null) {
            eventData.recycle();
        }
        return z;
    }

    public void register(int i2, IEventProcessor iEventProcessor) {
        if (iEventProcessor != null && i2 >= 0 && i2 < 6) {
            List list = (List) this.mProcessor[i2];
            if (list == null) {
                list = new ArrayList();
                this.mProcessor[i2] = list;
            }
            list.add(iEventProcessor);
            return;
        }
        VVLog.e(TAG, "register failed type:" + i2 + "  processor:" + iEventProcessor);
    }

    public void unregister(int i2, IEventProcessor iEventProcessor) {
        if (iEventProcessor != null && i2 >= 0 && i2 < 6) {
            List list = (List) this.mProcessor[i2];
            if (list != null) {
                list.remove(iEventProcessor);
                return;
            }
            return;
        }
        VVLog.e(TAG, "unregister failed type:" + i2 + "  processor:" + iEventProcessor);
    }
}
