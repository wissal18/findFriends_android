package com.example.findfriends.ui.dashboard;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.findfriends.MainActivity;
import com.example.findfriends.R;
import com.example.findfriends.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {


    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.idBtnEnv.setOnClickListener(v->{
            String numero=binding.edPhoneText.getText().toString();
            if(MainActivity.send_permission){
                SmsManager manager=SmsManager.getDefault();
                manager.sendTextMessage(numero,null,"#findFriends:Envoyer moi votre position!",null,null);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}