package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.bean.tzInfo;

import static android.R.attr.data;


/**
 * 首页火热消息适配器
 * Created by leict on 2017/10/25.
 */

public class MainMenuListAdapter extends BaseAdapter {
    private List<tpxwInfo.ListinfoBean> itemList;
    private final Context context;
    private final LayoutInflater inflater;

    public MainMenuListAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setData(tpxwInfo list) {

        if(list != null){
            itemList = list.getListinfo();

        }

    }

    @Override
    public int getCount() {


        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int id, View view, ViewGroup parent) {

        if(itemList == null)
        return null;

        tpxwInfo.ListinfoBean data = itemList.get(id);
        if (data == null)
            return null;
        final ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_message, null);
            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) view.findViewById(R.id.tv_title);


            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.name.setText(data.getTitle());


        return view;
    }

    private class ViewHolder {
        TextView name;

    }
}
