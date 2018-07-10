package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.zsproject.bean.flInfo;
import customer.tcrj.com.zsproject.first.gridbtn.gzggFregment;
import customer.tcrj.com.zsproject.first.gridbtn.ldjhFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdeTPFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdtFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zxwjFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zyhdFregment;
import customer.tcrj.com.zsproject.first.zcgs.flfwFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class flfwFragmentPagerAdapter extends FragmentPagerAdapter {

            private List<flInfo.DataBean> data = new ArrayList<>();

    public flfwFragmentPagerAdapter(FragmentManager fm, List<flInfo.DataBean> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {

        return new flfwFregment(data.get(position).getLawyerHouseId());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getLawyerHouseName();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}

