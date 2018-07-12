package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.jdInfo;
import customer.tcrj.com.zsproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class jrAdapter extends BaseQuickAdapter<jdInfo.ContentBean, BaseViewHolder> {
    private Context mContext;

    public jrAdapter(@Nullable List<jdInfo.ContentBean> data, Context context) {
        super(R.layout.item_jr, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, jdInfo.ContentBean item) {
        TextView name = helper.getView(R.id.cpname);
        TextView ywys = helper.getView(R.id.ywys);
        TextView zgqx = helper.getView(R.id.zgqx);
        TextView nll = helper.getView(R.id.nll);
        TextView zged = helper.getView(R.id.zged);

        name.setText(item.getWorkType());
        ywys.setText("业务要素："+item.getYwgjys());
        zgqx.setText("最高期限："+item.getLimit());
        nll.setText("年利率："+item.getNll());
        zged.setText("最高额度："+item.getQuota()+"万");





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
