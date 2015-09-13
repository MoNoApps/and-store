package co.monoapps.store.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;


public class TDownloadImage extends AsyncTask<String, Void, Bitmap> {
    private ImageView image;
    private Bitmap bitmap;

    public TDownloadImage(ImageView image, Bitmap bitmap) {
        this.image = image;
        this.bitmap = bitmap;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        try {
            InputStream in = new java.net.URL(url).openStream();
             bitmap = BitmapFactory.decodeStream(in);
        }  catch (RuntimeException a) {
            //Do nothing. Just prevent app kill
        } catch (Exception e){
            //Do nothing. Just prevent app kill
        }

        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        image.setImageBitmap(result);
    }
}
