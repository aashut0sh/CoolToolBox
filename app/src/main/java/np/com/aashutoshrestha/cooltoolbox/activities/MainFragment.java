package np.com.aashutoshrestha.cooltoolbox.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import np.com.aashutoshrestha.cooltoolbox.R;

/**
 * Created by user on 8/3/2017.
 */

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_home_page, container, false);
    }
}
