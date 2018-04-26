package fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abc.khoaluan.DangNhapActivity;
import com.example.abc.khoaluan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import constants.Constants;
import util.StringEncryption;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangNhapFragment extends Fragment implements View.OnClickListener {

    private View view;
    @BindView(R.id.dangNhap_editTxtSoDienThoai)
    public EditText edSoDienThoai;
    @BindView(R.id.dangNhap_editTxtMatKhau)
    public EditText edMatKhau;
    @BindView(R.id.dangNhap_buttonDangNhap)
    public Button buttonDangNhap;
    private FirebaseFirestore db;
    private Activity activity;
    private DangKyFragment.callBackData cbd;

    public DangNhapFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public DangNhapFragment(Activity activity) {
        // Required empty public constructor
        this.activity = activity;
        cbd = (DangNhapActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        ButterKnife.bind(this,view);
        db = FirebaseFirestore.getInstance();

        buttonDangNhap.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.dangNhap_buttonDangNhap: doDangNhap();
                                                break;
        }
    }

    private void doDangNhap() {
        db.collection(Constants.CUSTOMER)
            .whereEqualTo(Constants.CONTACT, edSoDienThoai.getText().toString())
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        for(DocumentSnapshot document : task.getResult()){
                            if(document.exists()){
                                try {
                                    String password = StringEncryption.SHA1(edMatKhau.getText().toString());
                                    String serverPass = document.get(Constants.PASSWORD).toString();
                                    if(password.equals(serverPass)){
                                        String cusName = document.get(Constants.NAME).toString();
                                        cbd.onReturnData(cusName);

                                    }
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                            }
                            else{

                            }
                        }
                    }
                }
            });
    }

}
