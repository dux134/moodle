package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nikhil.ayush.aditi.moodleana.R;

public class ThreeFragment extends Fragment{
    /** This class populates the Notifications Tab on the main page.**/
public TextView msg ;
    public ThreeFragment() {
        /** Required empty public constructor **/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /** This function receives the bundle containing arrays of title and time of notifications, and passes them to the CustomAdapter_Thread object,which populates the ListView.**/
        View ret_view = inflater.inflate(R.layout.fragment_three, container, false);
        msg=(TextView) ret_view.findViewById(R.id.three);
        Bundle bundle = this.getArguments();
        //TextView contentView = (TextView)view.findViewById(R.id.contentPreview);
//        String htmlEncodedString = Html.toHtml(contentText);
//        String decodedString = StringEscapeUtils.unescapeHtml4(htmlEncodedString);
       // myTextView.setText(Html.fromHtml("<h2>Title</h2><br><p>Description here</p>"));
        TextView notific=(TextView) ret_view.findViewById(R.id.three);

        ArrayList<String > noti_text =bundle.getStringArrayList("noti_text");
        ArrayList<String> noti_time = bundle.getStringArrayList("noti_time");
        ArrayList<String> noti_html=new ArrayList<String>();
        for(int i=0;i<noti_text.size();i++)
        {  String str=noti_text.get(i);
            Spanned spannedText=Html.fromHtml(str);
            notific.setText(spannedText);
            String htmlString = notific.getText().toString();
           // htmlString=Html.fromHtml(Html.fromHtml(str).toString());
            noti_html.add(htmlString);
        }
        if(noti_text.isEmpty())
        {
            msg.setText("No New Notifications");
        }
//        list view needed.
        else
        {

            ListView notif_list = (ListView) ret_view.findViewById(R.id.notif_list);
            CustomAdapter_Thread adap = new CustomAdapter_Thread(getActivity().getApplicationContext(), noti_html, noti_time);
            notif_list.setAdapter(adap);
        }
        return ret_view;


    }

}


