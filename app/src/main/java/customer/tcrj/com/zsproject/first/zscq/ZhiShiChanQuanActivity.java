package customer.tcrj.com.zsproject.first.zscq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.ldjhAdapter;
import customer.tcrj.com.zsproject.adapter.leftZSCQAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class ZhiShiChanQuanActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerlayout;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.tv_kqcd)
    TextView tvkqcd;
    @BindView(R.id.left_drawer)
    RecyclerView left_drawer;



    leftZSCQAdapter adapter;


    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private ldjhAdapter detailAdapter;
    private List<qyListInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_zhi_shi_chan_quan;
    }

    @Override
    protected void setView() {
        left_drawer.setLayoutManager(new LinearLayoutManager(this));

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
//              getData(pageNum);
            }
        });
        beanList = new ArrayList<>();

        for(int i = 0;i< 30;i++){
            beanList.add(new qyListInfo.DataBean.ContentBean());
        }

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(detailAdapter = new ldjhAdapter(beanList, this));

        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
//                getData(pageNum);
            }
        }, mRecyclerView);

        showSuccess();
    }


    @Override
    protected void setData() {

    }

    List<String> stringdata = new ArrayList<>();
    @OnClick({R.id.tv_kqcd,R.id.btnback})
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tv_kqcd:

                for(int i = 0;i < 10;i++){
                    stringdata.add(i+"左侧数据");
                }
                setLsftData(stringdata);

                showDrawerLayout();
                break;

            case R.id.btnback:
                finish();
                break;


            default:
                break;
        }
    }

    private void setLsftData(List<String> data){
        adapter = new leftZSCQAdapter(data);
        adapter.setOnItemClickListener(this);
        left_drawer.setAdapter(adapter);
    }

    private void showDrawerLayout() {
        if (!drawerlayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerlayout.openDrawer(Gravity.RIGHT);
        } else {
            drawerlayout.closeDrawer(Gravity.RIGHT);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }






}
