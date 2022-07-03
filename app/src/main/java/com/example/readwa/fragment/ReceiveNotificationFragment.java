package com.example.readwa.fragment;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.provider.Settings;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.readwa.R;
import com.example.readwa.broadcast.HelperBroadCast;
import com.example.readwa.models.CustomerWA;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReceiveNotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReceiveNotificationFragment extends Fragment {

   private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ReceiveNotificationFragment() {
        // Required empty public constructor
    }
    public void showPermissionDialog() {
        getActivity().getApplicationContext().startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    // TODO: Rename and change types and number of parameters
    public static ReceiveNotificationFragment newInstance(String param1, String param2) {
        ReceiveNotificationFragment fragment = new ReceiveNotificationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    TextView textViewContentMessage , textViewFromNumberMessage;

    void initializeId( View v){
        textViewContentMessage = v.findViewById(R.id.id_tv_content_text);
        textViewFromNumberMessage = v.findViewById(R.id.id_tv_from_number);
    }
    public class ReceiveBroadcastReceiver extends BroadcastReceiver {

        List<CustomerWA> customerWAList;
        SharedPreferences sharedPreferences;
        public List<CustomerWA> getCustomerWAList(){
            sharedPreferences = getActivity().getSharedPreferences("shared_pref_customer",Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String data = gson.toJson(sharedPreferences.getString("LIST_CUSTOMER",""));
            if(data.length() == 2){
                customerWAList = new ArrayList<>();
                saveCustomerWAList(customerWAList);
                return customerWAList;
            }else{
                System.out.println(data);
                Type TypeCategory = new TypeToken<List<CustomerWA>>(){}.getType();
                List<CustomerWA> listCustom = gson.fromJson(data,TypeCategory);
                return listCustom;
            }
        }
        public void saveCustomerWAList(List<CustomerWA> customerWAList){
            sharedPreferences = getActivity().getSharedPreferences("shared_pref_customer",Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String data = gson.toJson(customerWAList);;
            System.out.println("Data saved = " + data);
            sharedPreferences.edit().putString("LIST_CUSTOMER",data);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
         //   customerWAList = getCustomerWAList();
            String tittle = intent.getStringExtra("title");
            String content = intent.getStringExtra("text");
            System.out.println("title = " + tittle);
            System.out.println("text = " + content);

/*

            int receivedNotificationCode = intent.getIntExtra("Notification Code",-1);
            String title = intent.getStringExtra("title");
            String text = intent.getStringExtra("text");
            System.out.println("Anjing titlte = " + title);


            if(customerWAList == null){
                List<String> listChat = new ArrayList<>();
             //   customerWAList.add(new CustomerWA());
                saveCustomerWAList(customerWAList);
            }

            for(CustomerWA custWa : customerWAList){
                if(custWa.getNamaCustomer().equals(from)){
                    System.out.println("Customer Sudah Ada di Database ");
                    System.out.println("dari = " + from);;
                } else{
                    System.out.println("dari = " + from);;
                    System.out.println("Customer Belum Ada di Database ");

                    List<String> listChat = new ArrayList<>();
                    customerWAList.add(new CustomerWA(from));
                }
            }
 */
            }
        }

    ReceiveBroadcastReceiver imageChangeBroadcastReceiver;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeId(view);
        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        startActivity(intent);
        imageChangeBroadcastReceiver = new ReceiveBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFICATION_DATA");
        getActivity().registerReceiver(imageChangeBroadcastReceiver,intentFilter);

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)
                != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("RESPONSE : ", "permission denied");
        }
        else
            Log.d("RESPONSE : ", "permission granted");
    }

    private BroadcastReceiver onNotice = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_notification, container, false);
    }
}