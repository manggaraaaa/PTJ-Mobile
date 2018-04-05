package com.muhammadaa.ptj.views;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.muhammadaa.ptj.R;
import com.muhammadaa.ptj.components.PenawaranItemAdapter;
import com.muhammadaa.ptj.models.ItemsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.slider)
    SliderLayout mSlider;
    @BindView(R.id.rv_penawaran)
    RecyclerView vPenawaran;

    private BroadcastReceiver _broadcastReceiver;
    private final SimpleDateFormat _sdfWatchTime = new SimpleDateFormat("HH:mm");
    private final SimpleDateFormat _sdfWatchDate = new SimpleDateFormat("dd MMMM yyyy");

    private List<ItemsModel> dataEvent = new ArrayList<>();
    private static final Integer[] images = {R.drawable.ptj_1, R.drawable.ptj_2, R.drawable.ptj_3, R.drawable.ptj_4};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        // initialisasi Date & Time
        Date currentTime = Calendar.getInstance().getTime();
        mDate.setText(_sdfWatchDate.format(currentTime));
        mTime.setText(_sdfWatchTime.format(currentTime));

        // resource slider Image
//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Proses memberi media Polibag pada tanaman", R.drawable.ptj_4);
        file_maps.put("Bahan untuk media tanaman", R.drawable.ptj_3);
        file_maps.put("Bibit Durian", R.drawable.ptj_2);
        file_maps.put("Proses Stek tanaman", R.drawable.ptj_1);

        initSlider(v, file_maps);
        
        initItemPenawaran();

        return v;
    }

    private void initItemPenawaran() {
        String img1 = String.valueOf(images[0]);
        String img2 = String.valueOf(images[1]);
        String img3 = String.valueOf(images[2]);
        String img4 = String.valueOf(images[3]);

        dataEvent.add(new ItemsModel("1", "Seminar Nasional Rekam Medis", img1, "04 Maret 2018", "Tema: Peran Perekam Medis dan Informasi Kesehatan dalam Menunjang Keberhasilan Standar Nasional Akreditasi Rumah Sakit (SNARS) Edisi 1"));
        dataEvent.add(new ItemsModel("2", "Pelatihan Perawat ICU Gelombang IV", img2, "05 Februari - 23 Maret 2018", "Teori:\n1. Basic Cardiac Life Support (BCLS)\n" +
                "\n2. Monitoring Hemodinamika (Update)\n" +
                "\n3. Terapi Cairan Pada Pasien Kritis (Update)\n" +
                "\n4. Pengelolaan Pasien Dengan Gangguan Elektrolit Dan Asam Basa Metoda Stewart\n" +
                "\n5. Pengelolaan Dan Perawatan Pasien Nyeri di ICU\n" +
                "\n6. Recent Critical Care Nursing"));
        dataEvent.add(new ItemsModel("3", "Bincang Sehat Kolesterol", img3, "16 Desember 2017", "Kolesterol Darah dan Permasalahannya"));
        dataEvent.add(new ItemsModel("4", "Seminar Awam Brainspotting", img4, "18 November 2017", "Aktivitas Otak dan Perilaku Mekanisme dan Intervensi"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        PenawaranItemAdapter adapter = new PenawaranItemAdapter(getContext(), dataEvent, new PenawaranItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemsModel item) {
                Toast.makeText(getContext(), item.getTitleEvent(), Toast.LENGTH_SHORT).show();
                /*Dialog settingsDialog = new Dialog(getContext());
                settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                View v = getLayoutInflater().inflate(R.layout.image_layout, null);
                ImageView img = (ImageView) v.findViewById(R.id.img_full);
                img.setImageResource(Integer.parseInt(item.getImgEvent()));
                settingsDialog.setContentView(v);
                settingsDialog.show();*/
            }
        });
        vPenawaran.setLayoutManager(gridLayoutManager);
        vPenawaran.setHasFixedSize(true);
        vPenawaran.setAdapter(adapter);
    }

    private void initSlider(View view, HashMap<String, Integer> url_maps) {
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Toast.makeText(getContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mSlider.addSlider(textSliderView);
        }

        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mSlider.setCustomIndicator((PagerIndicator) view.findViewById(R.id.custom_indicator));
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
    }

    @Override
    public void onStart() {
        super.onStart();
        _broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctx, Intent intent) {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0)
                    mTime.setText(_sdfWatchTime.format(new Date()));
            }
        };

        getActivity().registerReceiver(_broadcastReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    public void onStop() {
        mSlider.stopAutoCycle();
        super.onStop();
        if (_broadcastReceiver != null)
            getActivity().unregisterReceiver(_broadcastReceiver);
    }

}
