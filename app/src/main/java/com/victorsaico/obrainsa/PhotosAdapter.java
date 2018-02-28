package com.victorsaico.obrainsa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;

import io.realm.Realm;

import static com.victorsaico.obrainsa.Util.bitmapToBase64Jpge;
import static com.victorsaico.obrainsa.Util.dpToPx;

/**
 * Created by JARVIS on 25/02/2018.
 */

public class PhotosAdapter extends PagerAdapter {

    private Context context;
    private int NumPhotos;
    private Realm realm;
    private LayoutInflater layoutInflater;
    private final int PICK_IMAGE = 666;
    private String image64;
    private ImageView imgPhoto;
    public ArrayList<String> urlImage;
    public PhotosAdapter(Context context, int NumPhotos)
    {
        this.context = context;
        this.NumPhotos = NumPhotos;
        realm = Realm.getDefaultInstance();

    }

    @Override
    public int getCount() {
        return NumPhotos;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_photo, container, false);
        RelativeLayout contentImage = view.findViewById(R.id.contentPhoto);
        EditText edtTitle = view.findViewById(R.id.edtTitle);
        imgPhoto  = view.findViewById(R.id.imgPhoto);
        container.addView(view);
        contentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.create((Activity) context)
                        .returnAfterFirst(true) // set whether pick or camera action should return immediate result or not. For pick image only work on single mode
                        .folderMode(true) // folder mode (false by default)
                        .folderTitle("Imagenes") // folder selection title
                        .imageTitle("Seleccione una imagen") // image selection title
                        .single() // single mode
                        //.multi() // multi mode (default mode)
                        //.limit(10) // max images can be selected (99 by default)
                        .showCamera(true) // show camera or not (true by default)
                        .imageDirectory("Camera") // directory name for captured image  ("Camera" folder by default)
                        //.origin(images) // original selected images, used in multi mode
                        //.theme(R.style.CustomImagePickerTheme) // must inherit ef_BaseTheme. please refer to sample
                        //.enableLog(false) // disabling log
                        //.imageLoader(new GrayscaleImageLoder()) // custom image loader, must be serializeable
                        .start(PICK_IMAGE);
            }
        });
        return view;
    }
    private void savePhoto(final String base64, final String title)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Photo photo = new Photo();
                photo.setBase64Image(base64);
                photo.setTitle(title);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK
                && data != null) {
            //Uri selectedImageUri = data.getData();

            Image image = ImagePicker.getImages(data).get(0);

            int targetW = dpToPx(150);
            int targetH = dpToPx(150);

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();

            bmOptions.inJustDecodeBounds = true;

            BitmapFactory.decodeFile(image.getPath(), bmOptions);

            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;
            int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;
            Bitmap bitmap = BitmapFactory.decodeFile(image.getPath(), bmOptions);

            image64 = bitmapToBase64Jpge(bitmap);
            imgPhoto.setImageBitmap(bitmap);
        }
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
