package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;

/* loaded from: classes.dex */
public class KeyParser {

    public interface DataType {
        int get(int i10);
    }

    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i10 = 0; i10 < size; i10++) {
                CLKey cLKey = (CLKey) parse.get(i10);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i11 = ids.get(content);
                if (i11 == -1) {
                    System.err.println("unknown type " + content);
                } else {
                    int i12 = dataType.get(i11);
                    if (i12 == 1) {
                        typedBundle.add(i11, parse.getBoolean(i10));
                    } else if (i12 == 2) {
                        typedBundle.add(i11, value.getInt());
                        System.out.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i12 == 4) {
                        typedBundle.add(i11, value.getFloat());
                        System.out.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i12 == 8) {
                        typedBundle.add(i11, value.content());
                        System.out.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
            }
        } catch (CLParsingException e10) {
            e10.printStackTrace();
        }
        return typedBundle;
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new Ids() { // from class: androidx.constraintlayout.core.motion.parse.a
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
            public final int get(String str2) {
                return l.a.a(str2);
            }
        }, new DataType() { // from class: androidx.constraintlayout.core.motion.parse.b
            @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
            public final int get(int i10) {
                return l.a.b(i10);
            }
        });
    }
}
