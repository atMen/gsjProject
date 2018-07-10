package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.zcgsInfo;
import customer.tcrj.com.zsproject.bean.zcgssInfo;


/**
 * 首页菜单适配器
 * Created by leict on 2017/10/25.
 */

public class zcgssAdapter extends BaseAdapter {
    private List<zcgssInfo.ListinfoBean> itemList = new ArrayList<>();
    private final Context context;
    private final LayoutInflater inflater;

    public zcgssAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<zcgssInfo.ListinfoBean> list) {
        this.itemList.clear();
        this.itemList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (itemList == null)
            return 0;
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
        final zcgssInfo.ListinfoBean entity = (zcgssInfo.ListinfoBean) itemList.get(id);
        if (entity == null)
            return null;
        final ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_zcgs_gridview, null);
            viewHolder = new ViewHolder();
            viewHolder.nameView = (TextView) view.findViewById(R.id.cpname);
            view.setTag(viewHolder);
            view.setId(id);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nameView.setText(entity.getName());
        return view;
    }

    private class ViewHolder {
        TextView nameView = null;
    }
}
