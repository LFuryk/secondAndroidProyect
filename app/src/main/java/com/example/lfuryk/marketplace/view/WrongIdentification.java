package com.example.lfuryk.marketplace.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.lfuryk.marketplace.R;

public class WrongIdentification extends DialogFragment {

    private Button mButton;

    public WrongIdentification(){}

    public static WrongIdentification newInstance() {
        WrongIdentification frag = new WrongIdentification();
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modal_fragment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.modal_button);

        mButton.setOnClickListener(mButtonListener);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private View.OnClickListener mButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            getDialog().dismiss();
        }
    };

}
