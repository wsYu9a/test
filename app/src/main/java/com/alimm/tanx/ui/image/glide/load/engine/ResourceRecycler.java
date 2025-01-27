package com.alimm.tanx.ui.image.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alimm.tanx.ui.image.glide.util.Util;

/* loaded from: classes.dex */
class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback(null));
    private boolean isRecycling;

    public static class ResourceRecyclerCallback implements Handler.Callback {
        public static final int RECYCLE_RESOURCE = 1;

        private ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }

        public /* synthetic */ ResourceRecyclerCallback(AnonymousClass1 anonymousClass1) {
        }
    }

    public void recycle(Resource<?> resource) {
        Util.assertMainThread();
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.isRecycling = true;
        resource.recycle();
        this.isRecycling = false;
    }
}
