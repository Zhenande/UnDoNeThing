package Utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.abc.khoaluan.R;

import fragment.DangKyFragment;
import fragment.DangNhapFragment;
import fragment.DanhMucFragment;
import fragment.TaiKhoanFragment;
import fragment.TrangChuFragment;

/**
 * Created by ABC on 2/8/2018.
 */

public class FragmentDangNhapPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{


    private Context mContext;

    public FragmentDangNhapPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }


    // This determine what tab will show
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new DangNhapFragment();
            case 1: return new DangKyFragment();
            default: return new DangNhapFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.dangNhap);
            case 1:
                return mContext.getString(R.string.dangKy);
            default:
                return null;
        }
    }


}
