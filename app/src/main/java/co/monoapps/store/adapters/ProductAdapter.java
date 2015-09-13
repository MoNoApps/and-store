package co.monoapps.store.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.monoapps.store.R;
import co.monoapps.store.models.MProducto;
import co.monoapps.store.tasks.TDownloadImage;

public class ProductAdapter extends ArrayAdapter<MProducto> {
    private final Context context;
    private final List<MProducto> values;

    public ProductAdapter(Context context, List<MProducto> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Bitmap defaultIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.abc_ab_share_pack_mtrl_alpha);
        View rowView = inflater.inflate(R.layout.adapter_product, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.product_image);
        TextView textView = (TextView) rowView.findViewById(R.id.product_name);

        textView.setText(values.get(position).nombre);

        MProducto p = values.get(position);
        //imageView.setImageResource(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
        //new TDownloadImage((ImageView) rowView.findViewById(R.id.product_image), defaultIcon)
        //        .execute(values.get(position).imagen);
        // imageView.setImageResource(R.drawable.abc_btn_check_to_on_mtrl_000);

        return rowView;
    }
}
