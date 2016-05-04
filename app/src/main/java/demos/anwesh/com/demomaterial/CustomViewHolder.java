package demos.anwesh.com.demomaterial;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by anweshmishra on 04/05/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    private View view;
    private Context context;
    private TextView textView;
    private ImageView imageView;
    private LinearLayout linearLayout;
    public CustomViewHolder(View view, final Context context) {
        super(view);
        this.context = context;
        textView = (TextView)view.findViewById(R.id.custom_text);
        imageView = (ImageView)view.findViewById(R.id.custom_image);
        linearLayout = (LinearLayout)view.findViewById(R.id.cc_container);
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width = linearLayout.getWidth();
                int height = linearLayout.getHeight();
                textView.setX(width/20);
                textView.setY(50);
                imageView.setX(width-200);
                imageView.setY(50);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                        dialog.setTitle("List content");
                        dialog.setMessage(textView.getText());
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.show();
                    }
                });
            }
        });
    }
    public void buildView(CustomObject customObject) {
        textView.setText(customObject.getName());
        Picasso.with(context).load(customObject.getUrl()).resize(100,100).into(imageView);
    }
}
