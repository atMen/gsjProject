package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.zcgs.flfwFregment;
import customer.tcrj.com.zsproject.first.zcgs.pxfwFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class pxfwFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"创业服务", "社保服务", "税务服务", "财务服务"
            };

    public pxfwFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new pxfwFregment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}

