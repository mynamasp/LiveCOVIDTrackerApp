package com.sprasanna.trackcovid19.ui.country;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.widget.TextView;

import com.sprasanna.trackcovid19.R;

public class CovidCountryDetail extends AppCompatActivity {

    TextView tvDetailCountryName, tvDetailTotalCases, tvDetailTodayCases, tvDetailTotalDeaths,
            tvDetailTodayDeaths, tvDetailTotalRecovered, tvDetailTotalActive, tvDetailTotalCritical,tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_country_detail);

        // call view
        tvDetailCountryName = findViewById(R.id.tvDetailCountryName);
        tvDetailTotalCases = findViewById(R.id.tvDetailTotalCases);
        tvDetailTodayCases = findViewById(R.id.tvDetailTodayCases);
        tvDetailTotalDeaths = findViewById(R.id.tvDetailTotalDeaths);
        tvDetailTodayDeaths = findViewById(R.id.tvDetailTodayDeaths);
        tvDetailTotalRecovered = findViewById(R.id.tvDetailTotalRecovered);
        tvDetailTotalActive = findViewById(R.id.tvDetailTotalActive);
        tvDetailTotalCritical = findViewById(R.id.tvDetailTotalCritical);
        tip=findViewById(R.id.tip2);


        // call Covid Country
        CovidCountry covidCountry = getIntent().getParcelableExtra("EXTRA_COVID");

        // set text view
        tvDetailCountryName.setText(covidCountry.getmCovidCountry());
        tvDetailTotalCases.setText(covidCountry.getmCases());
        tvDetailTodayCases.setText(covidCountry.getmTodayCases());
        tvDetailTotalDeaths.setText(covidCountry.getmDeaths());
        tvDetailTodayDeaths.setText(covidCountry.getmTodayDeaths());
        tvDetailTotalRecovered.setText(covidCountry.getmRecovered());
        tvDetailTotalActive.setText(covidCountry.getmActive());
        tvDetailTotalCritical.setText(covidCountry.getmCritical());

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
            tip.setText(tip4);

        }else if (random==4) {
            tip.setText(tip5);

        }else if (random==5) {
            tip.setText(tip6);

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


    }
}
