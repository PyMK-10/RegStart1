package ru.vgtrofimov.rsv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.vgtrofimov.rsv.MainActivity;
import ru.vgtrofimov.rsv.R;

public class FragmentHelper extends Fragment {
    MainActivity mainActivity;
    View view;

    public FragmentHelper() {

    }

    public FragmentHelper(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_helper, container, false);

        createMechanics();
        return view;
    }

    private void createMechanics() {
        ImageView woman_image = (ImageView) view.findViewById(R.id.woman_image);
        woman_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.app_factory(MainActivity.APP_STATE.QUEST_PAGE);
            }
        });

        TextView woman = (TextView) view.findViewById(R.id.woman);
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.app_factory(MainActivity.APP_STATE.QUEST_PAGE);
            }
        });

    }

}
