package com.muhammadaa.ptj.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.muhammadaa.ptj.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    @BindView(R.id.edt_query_search)
    EditText vQuery;
    @BindView(R.id.lv_artikel)
    ListView lArticle;


    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, v);

        ArrayList<HashMap<String, String>> vArticle = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 22; i++) {

            HashMap<String, String> absensiInfo = new HashMap<>();
            absensiInfo.put("title", "title " + i);
            absensiInfo.put("desc", "Lorem ipsum dolor sit amet, et illum dolores duo. Mea postea maiorum ne. Te sea regione singulis corrumpit. Prima mundi deserunt at pri, facilis alienum at mel, ut sed debet appetere. Illum quidam ne nec, ius ullum decore soluta id. Omnium periculis usu ea, pri detracto molestie ea.\n" +
                    "\n" +
                    "Ut primis appareat per, sit cu legimus consequuntur. Mel eu mundi quando. Mel nonumy periculis accusamus ad, eu sed virtute voluptua recteque, eum minimum voluptaria an. At ius dolore reprimique, dicunt iriure signiferumque his et, vim et cetero utroque. Ex est alii altera, sed an primis vivendo. Ea usu suas choro, wisi erroribus id cum, justo ponderum sea ne.\n" +
                    "\n" +
                    "Ei his error molestie. Fierent tacimates cum no. Movet elitr percipit ad quo, ea omittam copiosae vim. Eros simul intellegam ius ei, pro tota vituperata et.\n" +
                    "\n" +
                    "Ut suscipit vulputate cum, odio exerci everti vis ne, vel partem denique principes ad. Id aeque audiam facilisis cum, error graeci eirmod an his. Ea habemus vivendum iudicabit eum, ea placerat legendos liberavisse usu. Sit justo cotidieque ad, id sint eius blandit sed, sit no justo invidunt quaerendum. Ut sale mutat deserunt duo, iudico graecis habemus ei nec. Mei eu illum nusquam philosophia, cum ex menandri rationibus vituperata.\n" +
                    "\n" +
                    "No vim illud concludaturque. At atqui audiam has, ut elitr dolorem contentiones vix. Quo dicant efficiendi delicatissimi in, dicta blandit vis at, ea eius lorem copiosae ius. Nec minim intellegebat cu, nam errem audire ne. Mei no tation vidisse, erant omnes vituperata an pri, ut delectus quaerendum duo. Labore legendos te qui, quem exerci apeirian et vim. " + i);

            vArticle.add(absensiInfo);
        }

        ListAdapter adapter = new SimpleAdapter(
                getContext(), vArticle, R.layout.content_article,
                new String[]{"title", "desc"},
                new int[]{R.id.title_article, R.id.desc_article});

        lArticle.setAdapter(adapter);

        return v;
    }

}
