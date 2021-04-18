package ru.vgtrofimov.rsv.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Vector;

import ru.vgtrofimov.rsv.Banner;
import ru.vgtrofimov.rsv.Courses;
import ru.vgtrofimov.rsv.MainActivity;
import ru.vgtrofimov.rsv.Quest;
import ru.vgtrofimov.rsv.R;
import ru.vgtrofimov.rsv.adapters.RvAdapter;

public class FragmentQuest extends Fragment {
    MainActivity mainActivity;
    View view;
    Vector<Quest> quests;
    Vector<Banner> banners;
    Vector<Courses> courses;
    int current_quest;
    int current_banner;
    CountDownTimer cdt;
    CountDownTimer cdtBanner;

    String promocode = "РОССИЯ - СТРАНА ВОЗМОЖНОСТЕЙ";

    public FragmentQuest() {

    }

    public FragmentQuest(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        current_quest = 0;
        current_banner = 0;

        courses = new Vector<>();
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course01), "Саморазвитие", "Люди постоянно нуждаются в саморазвитии, этот процесс длится на протяжении всей жизни. С самого детства мы развиваем свои навыки и компетенции, получаем новые знания и формируем личность. Но наступает момент, когда человек не понимает, в каком именно направлении ему начать развиваться. Из онлайн-курса вы узнаете, что необходимо предусмотреть, чтобы начать движение к саморазвитию, какие могут быть препятствия на вашем пути, какие есть практические инструменты, которые помогут продвинуться."));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course02), "Мышление лидера", "Запись межмодульного вебинара \"Мышление лидера\". Спикер - Наталья Матусова."));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course03), "Ориентация на результат", "Условно специалистов можно разделить на тех, кто ориентирован на процесс, и тех, кто нацелен на результат. Именно ориентация на конечный результат помогает лучше выстраивать работу, организовывать личное время и быстрее достигать поставленных целей. Это важнейший навык для специалистов и руководителей всех уровней, которые стремятся к карьерному росту. Для развития результативного мышления существуют специальные упражнения и техники, о которых подробнее можно узнать в бесплатном онлайн-курсе."));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course04), "Планирование и организация", "Без планирования и организации любое дело может превратиться в хаос и беспорядок. Чем лучше спланированы действия, время, расставлены приоритеты в задачах, рассчитаны ресурсы и организован рабочий процесс, тем быстрее будут достигнуты поставленные цели. Развитие данного навыка необходимо как молодым специалистам, так и руководителям во всех сферах деятельности. В дистанционном курсе содержатся полезные рекомендации и универсальные упражнения по планированию и организации различных задач."));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course05), "Клиентоориентированность", "В мире высокой конкуренции главным человеком в компании становится сам клиент. От него напрямую зависит развитие и успех бизнеса. Предоставляемый сервис в фирме также ценится наравне с качеством товаров или услуг. Чем лучше и быстрее будут удовлетворены потребности клиента, тем больше вероятности, что он обратится в компанию повторно. Существуют специальные тренинги, упражнения и технологии, позволяющие быстро обучить сотрудников клиентоориентированности, и получить рекордные результаты в короткие сроки"));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course06), "Устная и письменная коммуникация", "Работа в любой сфере деятельности невозможна без владения навыками устной и письменной коммуникации. Данные способности необходимы для выбора стратегии общения с собеседником, стиля написания делового письма, глубокого и осмысленного понимания информации или устной речи. Деловая коммуникация — это эффективный инструмент, который помогает быстрее наладить контакт с человеком, договориться о главном и прийти к конечному результату. В этом лучше всего помогут знания правил создания текстов, теории коммуникаций, речевых стратегий и другие техники, о которых подробнее можно узнать из бесплатного онлайн-курса"));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course07), "Профессии будущего", "Профессиональный мир стремительно меняется, регулярно появляются новые профессии, трансформируются или исчезают старые специальности. По всему миру проводятся исследования рынка труда и разрабатываются прогнозы потребностей в кадрах. Поэтому важно понимать, как меняется экономика, какие люди будут востребованы в 21 веке, какими навыками должны обладать сотрудники, чтобы быть эффективными"));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course08), "Руководитель или предприниматель", "Практически каждый человек, который развивается профессионально, приходит к мысли о том, чтобы стать руководителем или открыть свое дело и стать предпринимателем. Управленец — это не простая должность, которая требует развития не только профессиональных компетенций, но и других гибких навыков"));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course09), "Карьерный рост", "Карьерный рост — это не удача или случайное стечение обстоятельств, а упорный труд и работа над собой. Если вы нацелены вырасти до руководящей должности и достигнуть больших результатов в работе, то первое, что стоит сделать, — это разработать стратегию построения карьерной лестницы. В современном обществе достаточно легко просчитать необходимые шаги для проработки пути личностного и профессионального роста"));
        courses.add(new Courses(mainActivity.getDrawable(R.drawable.course10), "Удаленная работа: способы мотивации", "Удаленный формат работы является одной из самых частых причин снижения мотивации и эффективности команды в целом. Нарушение коммуникаций с коллегами, отсутствие постоянного контакта с руководителем, потеря уверенности и стабильности в отношении заработной платы привело к сильному стрессу и снижению результативности. Из бесплатного онлайн-курса вы узнаете основные причины снижения работоспособности сотрудников и способы мотивации, как внедрить специальные условия для снятия барьеров коммуникации и создать атмосферу доверия внутри группы"));

        quests = new Vector<>();
        //                           Вопрос    Учиться баллов   Технарь баллов      Онлайн баллов
        quests.add(new Quest("Вы хотите учиться?", 10, 0, 0));
        quests.add(new Quest("Вы хотите увеличить свои лидерские качества?", 7, 3, 0));
        quests.add(new Quest("Вам удобно учиться онлайн?", 0, 0, 10));
        quests.add(new Quest("Вам нравится работать с людьми?", 5, 3, 0));
        quests.add(new Quest("Вы хотите овладеть технической профессией?", 7, 7, 0));
        quests.add(new Quest("Вы отличаете озеро от пруда?", 3, 4, 0));
        quests.add(new Quest("Вы смогли бы посещать очные мероприятия?", 0, 0, 6));
        quests.add(new Quest("Хотели бы Вы найти себе наставника?", 0, 0, 5));
        quests.add(new Quest("Вы много читаете?", 10, 0, 2));
        quests.add(new Quest("Вы любите телесериалы?", 3, 5, 8));

        banners = new Vector<>();
        banners.add(new Banner(mainActivity.getDrawable(R.drawable.face01), "Дарья Аббасова", "Дарья Аббасова — студентка второго курса магистратуры ТГУ — смело может назвать себя профессионалом, ведь она доказала гордое звание настоящего профи дважды."));
        banners.add(new Banner(mainActivity.getDrawable(R.drawable.face02), "Катрин Каташвили", "Катрин Каташвили удалось не только освоить новую профессию и стать датасаентистом, но и пройти в финал конкурса «Цифровой прорыв». За 36 часов онлайн-хакатона команда под руководством Катрин решила кейс для компании «Росатом»."));
        banners.add(new Banner(mainActivity.getDrawable(R.drawable.face03), "Анна Якубенко", "Не перестаем восхищаться участниками наших проектов! Ведь некоторым из них удается одинаково талантливо проявлять себя в диаметрально противоположных сферах."));
        banners.add(new Banner(mainActivity.getDrawable(R.drawable.face04), "Маргарита Лодягина", "Как получить стажировку в крупной российской компании, не имея опыта работы?На этот вопрос ответит Маргарита Лодягина, студентка Псковского государственного университета и будущий строитель. Маргарита победила в конкурсе Профстажировки 2.0, предложив эффективное решение кейса от компании «Россети», где следующим летом девушка пройдет оплачиваемую стажировку."));
        banners.add(new Banner(mainActivity.getDrawable(R.drawable.face05), "Софья Юдина", "Софья Юдина - студентка Российского государственного социального университета и активный волонтер чемпионатов \"Абилимпикс\". Софья Юдина потеряла возможность ходить в результате неудачной операции в раннем детстве. 11 лет она училась на дому, закончила школу на \"отлично\" и решила исполнить свою мечту - стать психологом. "));
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
        view = inflater.inflate(R.layout.fragment_quest, container, false);

        createMechanics();
        goQuest();
        goBannerSlide();
        return view;
    }

    @Override
    public void onPause() {
        if (cdt != null) {
            cdt.cancel();
            cdt = null;
        }

        if (cdtBanner != null) {
            cdtBanner.cancel();
            cdtBanner = null;
        }

        createMechanics();
        goQuest();
        super.onPause();
    }

    private void goBannerSlide() {
        if (cdtBanner != null) {
            cdtBanner.cancel();
            cdtBanner = null;
        }

        ImageView image_history = (ImageView) view.findViewById(R.id.image_history);
        TextView name_history = (TextView) view.findViewById(R.id.name_history);
        TextView text_history = (TextView) view.findViewById(R.id.text_history);

        if (current_banner >= banners.size()) {
            current_banner = 0;
        }

        Animation anim01 = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.linear_alpha01);
        Animation anim02 = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.linear_alpha01);
        Animation anim03 = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.linear_alpha01);

        image_history.setImageDrawable(banners.elementAt(current_banner).getImg());
        name_history.setText(banners.elementAt(current_banner).getName());

        int max_length = banners.elementAt(current_banner).getText().length() - 1;
        if (max_length >= 95) max_length = 95;
        text_history.setText(banners.elementAt(current_banner).getText().substring(0, max_length) + "...");

        image_history.startAnimation(anim01);
        name_history.startAnimation(anim02);
        text_history.startAnimation(anim03);

        cdtBanner = new CountDownTimer(10500, 10000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                current_banner += 1;
                goBannerSlide();
            }
        }.start();

    }

    private void createMechanics() {
        ImageView image_no = (ImageView) view.findViewById(R.id.image_no);
        ImageView image_yes = (ImageView) view.findViewById(R.id.image_yes);
        SeekBar progress_answer = (SeekBar) view.findViewById(R.id.progress_answer);

        progress_answer.setAlpha(1.0f);
        image_no.setAlpha(1.0f);
        image_yes.setAlpha(1.0f);

        progress_answer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float alpha_no = 1.0f - i / 100.0f;
                float alpha_yes = i / 100.0f;
                image_no.setAlpha(alpha_no);
                image_yes.setAlpha(alpha_yes);
                if (cdt != null) removeCDT();
                Log.e("RSV", "onProgressChanged: " + i + " " + alpha_yes + " " + alpha_no);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                createCDT();
            }
        });

    }
    private void removeCDT() {
        if (cdt != null) {
            cdt.cancel();
            cdt = null;
        }
        restore_view();
    }

    private void createCDT() {
        if (cdt != null) {
            cdt.cancel();
            cdt = null;
        }

        TextView text_otvet_zaschitaetsya = (TextView) view.findViewById(R.id.text_otvet_zaschitaetsya);
        text_otvet_zaschitaetsya.setVisibility(View.VISIBLE);

        cdt = new CountDownTimer(3500, 1000) {
            int time = 3;
            @Override
            public void onTick(long l) {
                float decrease_alpha = 0.2f;
                ImageView image_no = (ImageView) view.findViewById(R.id.image_no);
                ImageView image_yes = (ImageView) view.findViewById(R.id.image_yes);
                SeekBar progress_answer = (SeekBar) view.findViewById(R.id.progress_answer);
                float no_alpha = image_no.getAlpha();
                no_alpha -= decrease_alpha;
                if (no_alpha >= 0) {
                    image_no.setAlpha(no_alpha);
                } else {
                    image_no.setAlpha(0.01f);
                }

                float yes_alpha = image_yes.getAlpha();
                yes_alpha -= decrease_alpha;
                if (yes_alpha >= 0) {
                    image_yes.setAlpha(yes_alpha);
                } else {
                    image_yes.setAlpha(0.01f);
                }

                float p_alpha = progress_answer.getAlpha();
                p_alpha -= decrease_alpha;
                if (p_alpha >= 0) {
                    progress_answer.setAlpha(p_alpha);
                } else {
                    progress_answer.setAlpha(0);
                }

                TextView text_otvet_zaschitaetsya = (TextView) view.findViewById(R.id.text_otvet_zaschitaetsya);
                text_otvet_zaschitaetsya.setText("Ответ засчитается через " + okonchanie(time, "секунду", "секунды", "секунды", true) );
                time -= 1;
            }

            @Override
            public void onFinish() {
                current_quest += 1;
                createMechanics();
                restore_view();
                goQuest();
                removeCDT();
            }
        }.start();
    }

    private String okonchanie(long number, String caseOne, String caseTwo, String caseFive, boolean space) {
        String str = Long.toString(number);
        if (space)
            str += " ";
        number = Math.abs(number);

        if (number % 10 == 1 && number % 100 != 11) {
            str += caseOne;
        } else if (number % 10 >= 2 && number % 10 <= 4 && (number % 100 < 10 || number % 100 >= 20)) {
            str += caseTwo;
        } else {
            str += caseFive;
        }

        return str;
    }

    private void restore_view() {
        ImageView image_no = (ImageView) view.findViewById(R.id.image_no);
        ImageView image_yes = (ImageView) view.findViewById(R.id.image_yes);
        SeekBar progress_answer = (SeekBar) view.findViewById(R.id.progress_answer);
        TextView text_otvet_zaschitaetsya = (TextView) view.findViewById(R.id.text_otvet_zaschitaetsya);
        text_otvet_zaschitaetsya.setVisibility(View.GONE);

        progress_answer.setProgress(50);
        progress_answer.setAlpha(1.0f);
        image_no.setAlpha(1.0f);
        image_yes.setAlpha(1.0f);

    }

    private void goQuest() {
        restore_view();
        TextView text_promocode = (TextView) view.findViewById(R.id.text_promocode);
        String toPromo = promocode.substring(0, current_quest);
        for (int i = 0; i < (promocode.length() - current_quest); i++) {
            toPromo += ".";
        }
        text_promocode.setText("ВАШ ПРОМОКОД: " + toPromo);
        if (current_quest < quests.size()) {
            TextView text_quest = (TextView) view.findViewById(R.id.text_quest);
            text_quest.setText(quests.elementAt(current_quest).getCaption());
        } else {
            current_quest = 0;
            goQuest();
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setItemViewCacheSize(courses.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity.getApplicationContext()));

        if (current_quest > 0)
            Collections.shuffle(courses);

        RvAdapter rvAdapter = new RvAdapter(courses, mainActivity.getApplicationContext());
        recyclerView.setAdapter(rvAdapter);

    }

}
