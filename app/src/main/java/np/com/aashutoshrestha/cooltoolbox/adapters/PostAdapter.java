package np.com.aashutoshrestha.cooltoolbox.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

import np.com.aashutoshrestha.cooltoolbox.R;
import np.com.aashutoshrestha.cooltoolbox.models.DataModel;

/**
 * Created by user on 8/25/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>{

    private final LayoutInflater inflater;
    List<DataModel> data = Collections.emptyList();

    public PostAdapter(Context context, List<DataModel> data){

             inflater = LayoutInflater.from(context);
         }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            DataModel dm = data.get(position);

            holder.title.setText(dm.getTitle());
            holder.icon.setImageResource(dm.getImg());
            holder.content.setText(dm.getContent());
            holder.date.setText(dm.getDate());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView content;
        TextView date;
        ImageView icon;

        public MyViewHolder(View itemView){

            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titlecontent);
            content = (TextView) itemView.findViewById(R.id.content);
            date = (TextView) itemView.findViewById(R.id.cdate);
            icon = (ImageView) itemView.findViewById(R.id.icon);

        }

    }
}
