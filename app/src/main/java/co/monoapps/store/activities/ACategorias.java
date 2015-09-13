package co.monoapps.store.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import co.monoapps.store.R;
import co.monoapps.store.adapters.ProductAdapter;
import co.monoapps.store.models.MProducto;
import co.monoapps.store.tasks.TProducto;

public class ACategorias extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        final ListView listview = (ListView) findViewById(R.id.productsView);
        List<MProducto> products = new ArrayList<>();
        try{
            products = new TProducto().execute().get();
        } catch (ExecutionException b) {
            b.printStackTrace();
        } catch (InterruptedException a) {
            a.printStackTrace();
        }

        final List<MProducto> items = products;

        final ProductAdapter adapter = new ProductAdapter(getApplicationContext(), items);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                final Integer pos = position;
                view.animate()
                        .setDuration(1000)
                        .alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                items.remove(pos);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acategorias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
