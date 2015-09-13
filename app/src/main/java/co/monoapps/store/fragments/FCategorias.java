package co.monoapps.store.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import co.monoapps.store.StoreApp;
import co.monoapps.store.models.MCategoria;
import co.monoapps.store.tasks.TCategoria;

/**
 * A placeholder fragment containing a simple view.
 */
public class FCategorias extends ListFragment {

    public FCategorias() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<MCategoria> items = new ArrayList<>();
        try{
            items = new TCategoria().execute().get();
        } catch (ExecutionException b) {
            b.printStackTrace();
        } catch (InterruptedException a) {
            a.printStackTrace();
        }

        setListAdapter(new ArrayAdapter<>(
                        getActivity(),
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1,
                        items)
        );
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        ((StoreApp) getActivity().getApplication())
                .setItem(
                        ((StoreApp) getActivity().getApplication()).getWrines().get(position)
                );

    }

}
