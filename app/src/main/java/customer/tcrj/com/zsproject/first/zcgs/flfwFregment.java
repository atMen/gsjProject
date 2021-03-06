package customer.tcrj.com.zsproject.first.zcgs;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.FreshNewsAdapter;
import customer.tcrj.com.zsproject.adapter.flfwAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.bean.flInfo;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class flfwFregment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

//    @BindView(R.id.btnback)
//    public ImageView btnback;
//
//    @BindView(R.id.txtTitle)
//    public TextView title_tv;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private flfwAdapter detailAdapter;
    private List<flInfo.DataBean.LawyersBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    String lawyerHouseId;
    public flfwFregment(String lawyerHouseId) {
        this.lawyerHouseId = lawyerHouseId;
    }

    @Override
    protected int setLayout() {
        return R.layout.dy_fregment;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);

        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                if(!canPull){
                    return false;
                }
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pageNum = 1;
                getData(pageNum);

            }
        });
        beanList = new ArrayList<>();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(detailAdapter = new flfwAdapter(beanList, mContext));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
                getData(pageNum);
            }
        }, mRecyclerView);

//        showSuccess();

    }

    /**
     * 错误页面的点击回调，重新加载数据
     */
    @Override
    public void onRetry() {
        getData(pageNum);
    }

    @Override
    protected void setData() {
        getData(pageNum);
    }


    //获取网络数据
    private void getData(final int num) {

        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("page", num+"");
            jsonObject.put("size", "20");
            jsonObject.put("lawyerHouseId", lawyerHouseId);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.fwzx_fl_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<flInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, flInfo response) {

                        if("SUCCESS".equals(response.getErrorCode())){

                            if(num > 1){
                                loadMoreData(response,false);
                            }else{
                                loadData(response.getData().get(0).getLawyers(),false);
                            }

                        }



                    }
                });

    }

    /**
     * 上拉加载更多数据
     * @param response
     * @param isError
     */
    private void loadMoreData(flInfo response,boolean isError) {
        Log.e("TAG","loadMoreData");
        if (response == null) {
            Log.e("TAG","response == null:");
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(mContext, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(response.getData().get(0).getLawyers() != null && response.getData().get(0).getLawyers().size() <= 0){
                //没有更多数据



                    detailAdapter.loadMoreFail();


            }else{
                List<flInfo.DataBean.LawyersBean> content = response.getData().get(0).getLawyers();
                Log.e("TAG","content:"+content.size());
                pageNum++;

                    detailAdapter.addData(content);


                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<flInfo.DataBean.LawyersBean> response, boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
                showFaild();
            }else{
                showEmptyView();
            }
            canPull = false;

        } else {

            canPull = true;
            pageNum++;
            detailAdapter.setNewData(response);
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            showSuccess();
            disableLoadMoreIfNotFullPage(mRecyclerView,response.size());
        }
    }


    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView, final int size) {
        detailAdapter.setEnableLoadMore(false);
        if (recyclerView == null) return;
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null) return;
        if (manager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //要等到列表显示出来才可以去获取：findLastCompletelyVisibleItemPosition
                        if ((linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) != size) {
                            detailAdapter.setEnableLoadMore(true);
                        }

                        Log.e("TAG","测试："+(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1));
                    }
                }, 1000);



        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
