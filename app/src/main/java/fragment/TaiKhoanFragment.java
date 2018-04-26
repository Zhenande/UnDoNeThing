package fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.abc.khoaluan.DangNhapActivity;
import com.example.abc.khoaluan.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import constants.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaiKhoanFragment extends Fragment {


    private Button buttonDangNhap;
    @BindView(R.id.taiKhoan_txtTBDangNhap)
    TextView txtTaiKhoan;
    private View view;
    private FirebaseAuth auth;

    public TaiKhoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        ButterKnife.bind(this,view);

        buttonDangNhap = view.findViewById(R.id.taiKhoan_buttonDangNhap);
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DangNhapActivity.class);
                startActivityForResult(i, Constants.REQUEST_ACCOUNT_SIGN_IN);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_ACCOUNT_SIGN_IN
                && resultCode == Activity.RESULT_OK){
            String name = data.getStringExtra(Constants.NAME);
            if(TextUtils.isEmpty(name)){
               name = view.getContext().getResources().getString(R.string.new_user);
            }
            txtTaiKhoan.setText(view.getContext().getResources().getString(R.string.hello_text,name));
            setLayoutAfterSignIn();
        }
    }

    private void setLayoutAfterSignIn() {
        buttonDangNhap.setText(view.getContext().getResources().getString(R.string.sign_out));
    }

    private void setLayoutAfterSignOut(){
        buttonDangNhap.setText(view.getContext().getResources().getString(R.string.sign_in));
        auth.signOut();
    }
}
