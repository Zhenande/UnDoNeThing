package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.abc.khoaluan.R;

import fragment.DanhMucFragment;
import fragment.TaiKhoanFragment;
import fragment.TrangChuFragment;

/**
 * Created by ABC on 2/8/2018.
 */

public class FragmentMainPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{


    private Context mContext;

    public FragmentMainPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }


    // This determine what tab will show
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TrangChuFragment();
            case 1: return new DanhMucFragment();
            case 2: return new TaiKhoanFragment();
            default: return new TrangChuFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.trangChu);
            case 1:
                return mContext.getString(R.string.danhMuc);
            case 2:
                return mContext.getString(R.string.taiKhoan);
            default:
                return null;
        }
    }


}
