package com.sprasanna.trackcovid19.ui.india;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sprasanna.trackcovid19.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class IndiaFragment extends Fragment {

    private TextView tvTotalConfirmed,errort,tip, tvTotalDeaths, tvTotalRecovered, tvLastUpdated,tvActiveCases,label1,label2,label3,label4;
    private ProgressBar progressBar;
    private ImageView error1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_india, container, false);

        // call view
        tvTotalConfirmed = root.findViewById(R.id.tvTotalConfirmedIN);
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeathsIN);
        tvTotalRecovered = root.findViewById(R.id.tvTotalRecoveredIN);
        tvLastUpdated = root.findViewById(R.id.tvLastUpdated);
        tvActiveCases=root.findViewById(R.id.tvActiveCasesIN);
        progressBar = root.findViewById(R.id.progress_circular_home);
        label1= root.findViewById(R.id.tvLabelActiveCasesIN);
        label2= root.findViewById(R.id.tvLabelTotalConfirmedIN);
        label3= root.findViewById(R.id.tvLabelTotalDeathsIN);
        label4= root.findViewById(R.id.tvLabelTotalRecoveredIN);
        error1=root.findViewById(R.id.error2);
        errort=root.findViewById(R.id.errort2);
        tip=root.findViewById(R.id.tip3);
        label1.setVisibility(View.INVISIBLE);
        label2.setVisibility(View.INVISIBLE);
        label3.setVisibility(View.INVISIBLE);
        label4.setVisibility(View.INVISIBLE);



        // call Volley
        getData();

        return root;
    }

    private String getDate(long milliSecond){
        // Mon, 23 Mar 2020 02:01:04 PM
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss aaa");

        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(milliSecond);
        return formatter.format(calendar.getTime());
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/countries/india";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                label1.setVisibility(View.VISIBLE);
                label2.setVisibility(View.VISIBLE);
                label3.setVisibility(View.VISIBLE);
                label4.setVisibility(View.VISIBLE);
                String tip1 = "Regularly and thoroughly clean your hands with an alcohol-based hand rub or wash them with soap and water.";
                String tip2 ="Maintain at least 1 metre distance between yourself and anyone who is coughing or sneezing.";
                String tip3 = "Avoid touching eyes, nose and mouth";
                String tip4 ="cover your mouth and nose with your bent elbow or tissue when you cough or sneeze and dispose of the used tissue immediately.";
                String tip5 ="If you have a fever, cough and difficulty breathing, seek medical attention and call in advance. Follow the directions of your local health authority.";
                String tip6 ="Follow advice given by your healthcare provider, your national and local public health authority or your employer on how to protect yourself and others from COVID-19.";
                String tip7 ="Your essential needs will be taken care of by the government in a timely manner. Please do not hoard. ";
                String tip8 ="Call up your loved ones during the lockdown, support each other through these times.";
                String tip9 ="If you have any medical queries, reach out to your state helpline, district administration or trusted doctors!";
                String tip10 ="Plan ahead! Take a minute and check how much supplies you have at home. Planning lets you buy exactly what you need.";
                String tip11 ="STAY AT HOME.Avoid going untill Absolutely necessary";

                Random rand = new Random();
                int random = rand.nextInt(11);
                if (random ==0) {
                    tip.setText(tip1);
                }
                else if (random==1) {
                    tip.setText(tip2);
                }
                else if (random==2) {
                    tip.setText(tip3);

                }else if (random==3) {
                    tip.setText(tip11);

                }else if (random==4) {
                    tip.setText(tip11);

                }else if (random==5) {
                    tip.setText(tip11);

                }else if (random==6) {
                    tip.setText(tip7);

                }else if (random==7) {
                    tip.setText(tip8);

                }else if (random==8) {
                    tip.setText(tip9);

                }else if (random==9) {
                    tip.setText(tip10);

                }else  {
                    tip.setText(tip11);

                }

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    tvActiveCases.setText(jsonObject.getString("active"));
                    tvLastUpdated.setText("Last Updated"+"\n"+getDate(jsonObject.getLong("updated")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                error1.setVisibility(View.VISIBLE);
                errort.setVisibility(View.VISIBLE);

                Log.d("Error Response", error.toString());
            }
        });

        queue.add(stringRequest);
    }
}
