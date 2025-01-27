package android.support.v4.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes7.dex */
public final class PathUtils {
    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, ((Float) new Object[]{new Float(0.5f)}[0]).floatValue());
    }

    public static Collection<PathSegment> flatten(Path path, float f2) {
        Object[] objArr = {new Integer(7041349), new Integer(2336333), new Integer(2678061), new Integer(678770), new Integer(8240544), new Integer(-4067798), new Integer(5256652), new Integer(8094041), new Integer(5962487)};
        float[] approximate = path.approximate(f2);
        int length = approximate.length / (((Integer) objArr[6]).intValue() ^ 5256655);
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 1; i2 < length; i2 = (((Integer) objArr[4]).intValue() ^ 8240545) + i2) {
            int intValue = i2 * (((Integer) objArr[1]).intValue() ^ 2336334);
            int intValue2 = (i2 + (((Integer) objArr[5]).intValue() ^ 4067797)) * (((Integer) objArr[8]).intValue() ^ 5962484);
            float f3 = approximate[intValue];
            float f4 = approximate[(((Integer) objArr[3]).intValue() ^ 678771) + intValue];
            float f5 = approximate[(((Integer) objArr[7]).intValue() ^ 8094043) + intValue];
            float f6 = approximate[intValue2];
            float f7 = approximate[(((Integer) objArr[0]).intValue() ^ 7041348) + intValue2];
            float f8 = approximate[(((Integer) objArr[2]).intValue() ^ 2678063) + intValue2];
            if (f3 != f6 && (f4 != f7 || f5 != f8)) {
                arrayList.add(new PathSegment(new PointF(f7, f8), f6, new PointF(f4, f5), f3));
            }
        }
        return arrayList;
    }
}
