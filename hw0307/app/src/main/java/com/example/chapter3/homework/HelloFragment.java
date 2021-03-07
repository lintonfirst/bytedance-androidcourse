package com.example.chapter3.homework;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class HelloFragment extends Fragment {

    private static final String TAG = "HelloFragment";
    private LottieAnimationView animationView;
    private TextView textview;
    private Button button;

    public static HelloFragment newInstance(int index) {
        HelloFragment hf = new HelloFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        hf.setArguments(args);
        return hf;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        Integer index = args.getInt("index", 0);
        Log.d(TAG,"oncreateview"+String.valueOf(index));
        View x = inflater.inflate(R.layout.fragment_hello, container, false);


        textview= x.findViewById(R.id.fragment_text);
        button=x.findViewById(R.id.btn);

        animationView=x.findViewById(R.id.animation);

        animationView.playAnimation();
        animationView.loop(true);


        return x;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        Integer index = args.getInt("index", 0);
        Log.d(TAG,"onactivitycreated"+String.valueOf(index));

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                animationView.pauseAnimation();
                animationView.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(null);
                Bundle args = getArguments();
                Integer index = args.getInt("index", 0);
                textview.setText("This is page " + String.valueOf(index));
                button.setVisibility(View.VISIBLE);
            }
        }, 5000);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
