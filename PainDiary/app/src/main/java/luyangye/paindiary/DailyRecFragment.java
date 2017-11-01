package luyangye.paindiary;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.Date;

import luyangye.paindiary.RESTful.Users;

/**
 * Created by YLY on 22/04/2016.
 */
public class DailyRecFragment extends Fragment {
    View vDailyRec;
    private SeekBar seekBarPainlvl;
    private TextView Painlvltext;
    private Spinner painloc_sp;
    private Spinner paintrig_sp;
    private TextView paintrigtxt;
    private RadioGroup moodgroup;
    private String moodlvl;
    private Button subRec;


    private int Painlvl;
    private String Painloc;
    private String Paintrig;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vDailyRec = inflater.inflate(R.layout.fragment_dailyrec, container, false);
        this.seekBarPainlvl = (SeekBar) vDailyRec.findViewById(R.id.seekBarPain);
        this.Painlvltext = (TextView) vDailyRec.findViewById(R.id.painlvltext);
        Painlvltext.setText(seekBarPainlvl.getProgress() + "/" + seekBarPainlvl.getMax());
        seekBarPainlvl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                                                      int progress;

                                                      public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                                                          progress = progresValue;
                                                          Painlvltext.setText(progress + "/" + seekBar.getMax());
                                                      }

                                                      @Override
                                                      public void onStartTrackingTouch(SeekBar seekBar) {

                                                      }

                                                      public void onStopTrackingTouch(SeekBar seekBar) {
                                                          Painlvltext.setText(progress + "/" + seekBar.getMax());
                                                          Painlvl = progress;

                                                      }

                                                  }

        );
        painloc_sp = (Spinner) vDailyRec.findViewById(R.id.painloc_spinner);
        Painloc = painloc_sp.getSelectedItem().toString();


        paintrig_sp = (Spinner) vDailyRec.findViewById(R.id.paintrig_sp);
        paintrigtxt = (TextView) vDailyRec.findViewById(R.id.pain_triggertxt);
        String paintrigtemp = paintrig_sp.getSelectedItem().toString();
//        if(paintrigtxt.getText().toString().equals("") && !paintrig_sp.getSelectedItem().toString().equals("Others"))
//            Paintrig =  paintrig_sp.getSelectedItem().toString();
//        if(!paintrigtxt.getText().toString().equals("") && paintrig_sp.getSelectedItem().toString().equals("Others"))
//            Paintrig = paintrigtxt.getText().toString();
//        else{
//            Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();
//        }
        moodgroup = (RadioGroup) vDailyRec.findViewById(R.id.moodgroup);

        moodgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup moodgroup, int checkedId) {
                if (checkedId == R.id.verylowR) {
                    DailyRecFragment.this.moodlvl = "very low";
                }

                if (checkedId == R.id.lowR) {
                    DailyRecFragment.this.moodlvl = "low";
                }

                if (checkedId == R.id.averageR) {
                    DailyRecFragment.this.moodlvl = "average";
                }

                if (checkedId == R.id.goodR) {
                    DailyRecFragment.this.moodlvl = "good";
                }

                if (checkedId == R.id.verygoodR) {
                    DailyRecFragment.this.moodlvl = "very good";
                }


            }
        });

        subRec = (Button) vDailyRec.findViewById(R.id.recordSub);
        subRec.setOnClickListener(subReclistener);




        return vDailyRec;


    }

    private View.OnClickListener subReclistener = new View.OnClickListener() {

        public void onClick(View v) {
            try {
                final Integer recId;
                final Date recDate;
                final Date recTime;
                final int painLvl = Painlvl;

                if(paintrigtxt.getText().toString().equals("") && !paintrig_sp.getSelectedItem().toString().equals("Others"))
                    Paintrig =  paintrig_sp.getSelectedItem().toString();
                else if(!paintrigtxt.getText().toString().equals("") && paintrig_sp.getSelectedItem().toString().equals("Others"))
                    Paintrig = paintrigtxt.getText().toString();
                else{
                    Paintrig = "";
                }
                final String painTrigger = Paintrig;
                final String painLoc = Painloc;
                final String moodLvl = moodlvl;

                final String latitude;
                final String longitude;
                final String climaticTemp;
                final String climaticHumidity;
                final String climaticWindsp;
                final String climaticPress;
                final Users userId;

                System.out.println(Painlvl + Paintrig + Painloc + moodlvl);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    };
}

