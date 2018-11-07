package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.tpxwInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class hRecycleviewAdapter extends BaseQuickAdapter<tpxwInfo.ListinfoBean, BaseViewHolder> {
    private Context mContext;
    private int selected = -1;

    public hRecycleviewAdapter(@Nullable List<tpxwInfo.ListinfoBean> data, Context context) {
        super(R.layout.item_hrecycleview, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, tpxwInfo.ListinfoBean item) {
        TextView name = helper.getView(R.id.tv_title);
        name.setText(item.getTitle());

        if(selected == helper.getPosition()){
            name.setSelected(true);
        } else {
            name.setSelected(false);
        }

        if (mOnItemClickLitener != null)
        {
            name.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mOnItemClickLitener.OnItemClick(helper.getPosition());
                }
            });
        }
    }

    public void setSelection(int position){
        this.selected = position;
        notifyDataSetChanged();
    }


    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {//定义接口，实现Recyclerview点击事件
        void OnItemClick(int position);
    }

}
