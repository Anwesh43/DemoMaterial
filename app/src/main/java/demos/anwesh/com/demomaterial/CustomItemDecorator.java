package demos.anwesh.com.demomaterial;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by anweshmishra on 04/05/16.
 */
public class CustomItemDecorator extends RecyclerView.ItemDecoration {
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        for(int i=0;i<parent.getChildCount();i++) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.BLACK);
            canvas.drawRect(0,parent.getChildAt(i).getBottom()+5,parent.getChildAt(i).getWidth(),parent.getChildAt(i).getBottom()+10,paint);
        }
    }
}
