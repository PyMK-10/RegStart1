package ru.vgtrofimov.rsv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import ru.vgtrofimov.rsv.fragments.FragmentHelper;
import ru.vgtrofimov.rsv.fragments.FragmentQuest;

public class MainActivity extends AppCompatActivity {

    // Состояние приложения
    public enum APP_STATE {
        HELPER_PAGE,
        QUEST_PAGE
    }

    private APP_STATE app_state;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        app_factory(APP_STATE.HELPER_PAGE);
    }

    // Вычисляет, какой фрагмент установить
    public boolean app_factory(APP_STATE app_state) {
        this.app_state = app_state;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (app_state) {
            case HELPER_PAGE:
                FragmentHelper fragmentHelper = new FragmentHelper(this);
                if (!fragmentHelper.isVisible()) {
                    fragmentTransaction.setCustomAnimations(R.anim.opacity_up, R.anim.opacity_down);
                    fragmentTransaction.replace(R.id.fragment_container, fragmentHelper);
                }
                break;
            case QUEST_PAGE:
                FragmentQuest fragmentQuest = new FragmentQuest(this);
                if (!fragmentQuest.isVisible()) {
                    fragmentTransaction.setCustomAnimations(R.anim.opacity_up, R.anim.opacity_down);
                    fragmentTransaction.replace(R.id.fragment_container, fragmentQuest);
                }
                break;
        }
        fragmentTransaction.commit();
        return true;
    }

    @Override
    public void onBackPressed() {
        app_factory(APP_STATE.HELPER_PAGE);
    }
}