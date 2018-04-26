package fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.abc.khoaluan.DangNhapActivity;
import com.example.abc.khoaluan.MainActivity;
import com.example.abc.khoaluan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import constants.Constants;
import util.GlobalVariable;
import util.StringEncryption;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangKyFragment extends Fragment implements View.OnClickListener {


    private View view;
    @BindView(R.id.dangKy_editTxtSoDienThoai)
    public EditText edSoDienThoai;
    @BindView(R.id.dangKy_editTxtMatKhau)
    public EditText edMatKhau;
    @BindView(R.id.dangKy_editTxtNhapLaiMatKhau)
    public EditText edNhapLaiMatKhau;
    @BindView(R.id.dangKy_buttondangKy)
    public Button buttonDangKy;
    @BindView(R.id.linear_input_code)
    public LinearLayout llInputCode;
    @BindView(R.id.linear_sign_up_infor)
    public LinearLayout llSignUpInfor;
    @BindView(R.id.dangKy_edVerifyCode)
    public EditText edVerifyCode;
    private Activity activity;
    private FirebaseAuth mAuth;
    private String mVerificationID;
    private PhoneAuthProvider.ForceResendingToken tokenResend;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private MaterialDialog dialog;
    private FirebaseFirestore db;
    private String TAG = "DangKyFragment";
    private callBackData cbd;

    public interface callBackData{
        void onReturnData(String name);
    }

    public DangKyFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public DangKyFragment(Activity activity) {
        // Required empty public constructor
        this.activity = activity;
        cbd = (DangNhapActivity)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dang_ky, container, false);

        ButterKnife.bind(this,view);
        showLayoutSignUp();
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

//        edSoDienThoai.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s.length() < 3){
//                    retext = false;
//                }
//                if(s.length() >= 3){
//                    String namePhoneProvider = getNameProvider(s.toString().substring(0,4));
//
//                    if(retext) {
//                        edSoDienThoai.removeTextChangedListener(this);
//                        edSoDienThoai.setText(s + " (" + namePhoneProvider + ")");
//                        edSoDienThoai.requestFocus(s.length());
//                        edSoDienThoai.addTextChangedListener(this);
//                    }
//                    retext = true;
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String password = "";
//                try {
//                    password = StringEncryption.SHA1(edMatKhau.getText().toString());
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                Log.i(TAG,"SHA-1: " + password);
//            }
//        });

        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneNumber(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.i(TAG,e.getMessage());
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                showLayoutInputCode();
                closeLoadingDialog();
                mVerificationID = s;
                tokenResend = forceResendingToken;
                edVerifyCode.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(s.length() == 6){
                            showLoadingDialog();
                            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationID, s.toString());
                            signInWithPhoneNumber(credential);
                        }
                    }
                });
            }
        };

        buttonDangKy.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.dangKy_buttondangKy: doRegistCustomer();
                                            break;
        }
    }

    /*
    * @author: ManhLD
    * Process after click button Sign Up
    * */
    private void doRegistCustomer() {
        if(validInput()){
            showLoadingDialog();
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    getPhoneNumberSend(),
                    60,
                    TimeUnit.SECONDS,
                    activity,
                    mCallback);
        }
    }

    private void showLoadingDialog(){
        dialog = new MaterialDialog.Builder(view.getContext())
                .backgroundColor(view.getContext().getResources().getColor(R.color.primary))
                .customView(R.layout.loading_dialog, true)
                .build();
        dialog.show();
    }

    private void closeLoadingDialog(){
        dialog.dismiss();
    }

    private String getPhoneNumberSend() {
        String phone = edSoDienThoai.getText().toString();
        String phoneSend = "+84" + phone.substring(1,phone.length());
        return phoneSend;
    }

//    private String getNameProvider(String inputPhone) {
//      String result = "";
//      if(!retext){
//          String[] compare = Constants.VIETTEL_PROVIDER;
//          for(String s : compare){
//              if(s.equals(inputPhone)){
//                  return "Viettel";
//              }
//          }
//          compare = Constants.MOBIFONE_PROVIDER;
//          for(String s : compare){
//              if(s.equals(inputPhone)){
//                  return "Mobifone";
//              }
//          }
//          compare = Constants.VINAPHONE_PROVIDER;
//          for(String s : compare){
//              if(s.equals(inputPhone)){
//                  return "Vinaphone";
//              }
//          }
//          compare = Constants.VIETNAMOBILE_PROVIDER;
//          for(String s : compare){
//              if(s.equals(inputPhone)){
//                  return "Vietnamobile";
//              }
//          }
//          compare = Constants.GMOBILE_PROVIDER;
//          for(String s : compare){
//              if(s.equals(inputPhone)){
//                  return "GMobile";
//              }
//          }
//      }
//      return result;
//    }

    /*
    * @author: ManhLD
    * Display the layout of enter verify code
    * */
    private void showLayoutInputCode() {
        llInputCode.setVisibility(View.VISIBLE);
        llSignUpInfor.setVisibility(View.GONE);
    }

    private void showLayoutSignUp(){
        llInputCode.setVisibility(View.GONE);
        llSignUpInfor.setVisibility(View.VISIBLE);
    }

    private void signInWithPhoneNumber(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        GlobalVariable.sign_in = true;
                        Log.i("DangKy", "SignInSuccess: " + task.getResult().getUser().getPhoneNumber());
                        createNewCustomer();
                    }
                }
            });
    }

    private void createNewCustomer() {
        try {
            String password = StringEncryption.SHA1(edMatKhau.getText().toString());
            Map<String, Object> customer = new HashMap<>();
            customer.put(Constants.ADDRESS,"");
            customer.put(Constants.CITY,"");
            customer.put(Constants.CONTACT,edSoDienThoai.getText().toString());
            customer.put(Constants.DISTRICT,"");
            customer.put(Constants.NAME,"");
            customer.put(Constants.PASSWORD,password);
            db.collection(Constants.CUSTOMER)
                    .add(customer)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            closeLoadingDialog();
//                            Intent i = new Intent(view.getContext(), MainActivity.class);
//                            startActivity(i);
                            cbd.onReturnData("");
                        }
                    });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private boolean validInput() {

        String phoneNumber = edSoDienThoai.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            edSoDienThoai.setError(getResources().getString(R.string.required));
            return false;
        } else {
            edSoDienThoai.setError(null);
        }

        String password = edMatKhau.getText().toString();
        if (TextUtils.isEmpty(password)) {
            edMatKhau.setError(getResources().getString(R.string.required));
            return false;
        } else {
            edMatKhau.setError(null);
        }

        String rePassword = edNhapLaiMatKhau.getText().toString();
        if (TextUtils.isEmpty(rePassword)) {
            edNhapLaiMatKhau.setError(getResources().getString(R.string.required));
            return false;
        } else {
            edNhapLaiMatKhau.setError(null);
        }

        if(!phoneNumber.matches("[0-9]{10,11}")){
            edSoDienThoai.setError(getResources().getString(R.string.wrong_phone_number_type));
            return false;
        }

        if(!password.equals(rePassword)){
            edNhapLaiMatKhau.setError(getResources().getString(R.string.not_match_password));
            return false;
        }

        return true;
    }

}
