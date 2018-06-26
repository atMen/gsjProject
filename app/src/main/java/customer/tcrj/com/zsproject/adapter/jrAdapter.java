package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class jrAdapter extends BaseQuickAdapter<qyListInfo.DataBean.ContentBean, BaseViewHolder> {
    private Context mContext;

    public jrAdapter(@Nullable List<qyListInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_jr, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, qyListInfo.DataBean.ContentBean item) {
//        TextView name = helper.getView(R.id.name);
//        TextView time = helper.getView(R.id.time);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
        Button btnsq = helper.getView(R.id.btn_sq);

        btnsq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.OnItemClick(helper.getAdapterPosition());
                }
            }
        });



    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
        void OnItemClick(int helperPosition);
    }


    public void setOnItemXGClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
