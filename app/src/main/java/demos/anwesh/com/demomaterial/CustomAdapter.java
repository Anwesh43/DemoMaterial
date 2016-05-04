package demos.anwesh.com.demomaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 04/05/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    Context context;
    List<CustomObject> customObjects = new ArrayList<>();
    public CustomAdapter(Context context,List<CustomObject> customObjects) {
        this.context = context;
        this.customObjects = customObjects;
    }
    public CustomViewHolder onCreateViewHolder(ViewGroup root,int flag) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view,root,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view,context);
        return customViewHolder;
    }
    public void onBindViewHolder(CustomViewHolder customViewHolder,int position) {
        customViewHolder.buildView(customObjects.get(position));
    }
    public int getItemCount() {
        return customObjects.size();
    }
}
