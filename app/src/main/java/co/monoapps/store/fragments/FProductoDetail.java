package co.monoapps.store.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.monoapps.store.R;
import co.monoapps.store.StoreApp;
import co.monoapps.store.models.MProducto;

public class FProductoDetail extends Fragment {


    private MProducto mProducto;

    public FProductoDetail() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProducto = ((StoreApp) this.getActivity().getApplication()).getItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Context context = rootView.getContext();

        if (mProducto != null) {
            ((TextView) rootView.findViewById(R.id.wrine_name)).setText(mProducto.nombre);
        }

        return rootView;
    }
}
