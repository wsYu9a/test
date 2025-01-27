package o1;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class a extends CountDownLatch {
    public a(int i10) {
        super(i10);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
