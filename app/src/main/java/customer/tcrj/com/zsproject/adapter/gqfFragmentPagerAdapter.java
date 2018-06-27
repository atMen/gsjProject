package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.fgdtj.gqfFregment;
import customer.tcrj.com.zsproject.first.fgdtj.gqfxjFregment;
import customer.tcrj.com.zsproject.first.zcgs.flfwFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class gqfFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"省级", "市级", "县级"};

    public gqfFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 2){
            return new gqfxjFregment();
        }else if(position == 0){
            return new gqfFregment(0);
        }
        return new gqfFregment(1);
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

