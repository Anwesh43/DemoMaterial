package demos.anwesh.com.demomaterial;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 04/05/16.
 */
public class ImageUtils {
    public static Bitmap createCircularImage(Bitmap bitmap) {
        int w = bitmap.getWidth(),h  = bitmap.getHeight();
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Path path = new Path();
        path.addCircle(w/2,h/2,(float)Math.sqrt(Math.pow(w/2,2)+Math.pow(h/2,2))/2, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0,0,new Paint(Paint.ANTI_ALIAS_FLAG));
        return bitmap1;
    }
}
