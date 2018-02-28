package com.victorsaico.obrainsa;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.victorsaico.obrainsa.servicies.apiService;
import com.victorsaico.obrainsa.servicies.apiServiceGenerator;
import com.victorsaico.obrainsa.servicies.responseMessage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.victorsaico.obrainsa.Util.bitmapToBase64Jpge;

public class MainActivity extends AppCompatActivity {
    private ViewPager vprPhotos;
    private EditText edtNumPhotos;
    private PhotosAdapter photosAdapter;
    private SharedPreferences sharedPreferences;
    private SlidingTabLayout slidingTabLayout;
    private ImageView photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8,photo9,photo10;
    private SparseArray<String> photoStrings = new SparseArray<>();
    private Bitmap bitmap1,bitmap2,bitmap3,bitmap4,bitmap5,bitmap6,bitmap7,bitmap8,bitmap9,bitmap10;
    private final int PICK_IMAGE = 666;
    private Uri mediaFileUri;
    private EditText edtCode,edtVersion,edtVigencia,edtProyecto,edtMotivo,edtCodeEam,edtDescription,edtMarca,edtSerie,edtHorometro,edtDate,edtModelo;
    private ArrayList<Bitmap> bitmaps;
    private ArrayList<Uri> uris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        photo1 = findViewById(R.id.photo1);
        photo2 = findViewById(R.id.photo2);
        photo3 = findViewById(R.id.photo3);
        photo4 = findViewById(R.id.photo4);
        photo5 = findViewById(R.id.photo5);
        photo6 = findViewById(R.id.photo6);
        photo7 = findViewById(R.id.photo7);
        photo8 = findViewById(R.id.photo8);
        photo9 = findViewById(R.id.photo9);
        photo10 = findViewById(R.id.photo10);
        edtCode = findViewById(R.id.edtCode);
        edtVersion = findViewById(R.id.edtVersion);
        edtVigencia = findViewById(R.id.edtVigencia);
        edtProyecto = findViewById(R.id.edtProyecto);
        edtMotivo = findViewById(R.id.edtMotivo);
        edtCodeEam = findViewById(R.id.edtCodeEam);
        edtDescription = findViewById(R.id.edtDescription);
        edtMarca = findViewById(R.id.edtMarca);
        edtSerie = findViewById(R.id.edtSerie);
        edtHorometro = findViewById(R.id.edtHorometro);
        edtModelo = findViewById(R.id.edtModelo);
        edtDate = findViewById(R.id.edtDate);
        bitmaps = new ArrayList<>();
        uris = new ArrayList<>();
        //setViewPager(3);
        setButtons();
    }

    private boolean validate()
    {
        boolean validar = true;
        if(TextUtils.isEmpty(edtCode.getText().toString()))
        {
            validar = false;
            edtCode.setError("Ingresar código");
        }else if (TextUtils.isEmpty(edtVersion.getText().toString()))
        {
            validar = false;
            edtVersion.setError("Ingresar versión");
        }else if(TextUtils.isEmpty(edtVigencia.getText().toString()))
        {
            validar = false;
            edtVigencia.setError("Ingresar vigencia");
        }else if(TextUtils.isEmpty(edtProyecto.getText().toString()))
        {
            validar = false;
            edtProyecto.setError("Ingresar proyecto");
        }else if (TextUtils.isEmpty(edtMotivo.getText().toString()))
        {
           validar = false;
           edtMotivo.setError("Ingresar motivo");
        }else if (TextUtils.isEmpty(edtCodeEam.getText().toString()))
        {
           validar = false;
           edtCodeEam.setError("Ingresar código eam");
        }else if (TextUtils.isEmpty(edtDescription.getText().toString()))
        {
            validar = false;
            edtDescription.setError("Ingresar descripción");
        }else  if (TextUtils.isEmpty(edtMarca.getText().toString()))
        {
           validar = false;
           edtMarca.setError("Ingresar marca");
        }else if (TextUtils.isEmpty(edtSerie.getText().toString()))
        {
         validar = false;
         edtSerie.setError("Ingresar serie");
        }else if (TextUtils.isEmpty(edtHorometro.getText().toString()))
        {
            validar = false;
            edtHorometro.setError("Ingresar horometro");
        }else if (TextUtils.isEmpty(edtDate.getText().toString()))
        {
            validar = false;
            edtDate.setError("Ingresar día");
        }
            return validar;
    }
    private void setButtons()
    {
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 1).apply();
                selecPhoto();
            }
        });
        photo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 2).apply();
                selecPhoto();
            }
        });
        photo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 3).apply();
                selecPhoto();
            }
        });
        photo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 4).apply();
            }
        });
        photo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 5).apply();
                selecPhoto();
            }
        });
        photo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 6).apply();
                selecPhoto();
            }
        });
        photo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 7).apply();
                selecPhoto();
            }
        });
        photo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 8).apply();
                selecPhoto();
            }
        });
        photo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 9).apply();
                selecPhoto();
            }
        });
        photo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt("positionPhoto", 10).apply();
                selecPhoto();
            }
        });
    }

    public void selecPhoto() {
        try {

            if (!permissionsGranted()) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_LIST, PERMISSIONS_REQUEST);
                return;
            }

            // Creando el directorio de imágenes (si no existe)
            File mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    throw new Exception("Failed to create directory");
                }
            }

            // Definiendo la ruta destino de la captura (Uri)
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
            mediaFileUri = Uri.fromFile(mediaFile);
            uris.add(mediaFileUri);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mediaFileUri);
            startActivityForResult(intent, PICK_IMAGE);

        } catch (Exception e) {
            Log.e("Exception", e.toString());
            Toast.makeText(this, "Error en captura: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    //<--!! //Registrar los permisos --!>
    private static final int PERMISSIONS_REQUEST = 200;

    private static String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private boolean permissionsGranted() {
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                for (int i = 0; i < grantResults.length; i++) {
                    Log.d("asda", "" + grantResults[i]);
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, PERMISSIONS_LIST[i] + " permiso rechazado!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(this, "Permisos concedidos, intente nuevamente.", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            //Uri selectedImageUri = data.getData();

            try {
                Context applicationContext = this.getApplicationContext();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), mediaFileUri);
                bitmap = scaleBitmapDown(bitmap, 800);
                if (sharedPreferences.getInt("positionPhoto", 0) != 0) {
                    photoStrings.append(sharedPreferences.getInt("positionPhoto", 0),
                            bitmapToBase64Jpge(bitmap));

                    if (sharedPreferences.getInt("positionPhoto", 0) == 1) {
                        photo1.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 2) {
                        photo2.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 3) {
                        photo3.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 4) {
                        photo4.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 5) {
                        photo5.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 6) {
                        photo6.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 7) {
                        photo7.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 8) {
                        photo8.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 9) {
                        photo9.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    } else if (sharedPreferences.getInt("positionPhoto", 0) == 10) {
                        photo10.setImageBitmap(bitmap);
                        bitmaps.add(bitmap);
                    }
                }

            } catch (Exception e) {
                Toast.makeText(this, "Error al procesar imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private Bitmap scaleBitmapDown(Bitmap bitmap, int maxDimension) {

        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }


    private void selecPhoto(View view)
    {

    }

    public void sendInform (View view){
        boolean validar = validate();

        apiService service = apiServiceGenerator.createService(apiService.class);
        Call<responseMessage> call = null;
        Bitmap bitmap = BitmapFactory.decodeFile(mediaFileUri.getPath());

        if( validar)
        {


            File file = new File(mediaFileUri.getPath());
            //Log.d(TAG, "File: " + file.getPath() + " - exists: " + file.exists());

            // Podemos enviar la imagen con el tamaño original, pero lo mejor será comprimila antes de subir (byteArray)
            // RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);


            // Reducir la imagen a 800px solo si lo supera

            bitmap = scaleBitmapDown(bitmap, 800);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
            MultipartBody.Part imagenPart = MultipartBody.Part.createFormData("imagen", file.getName(), requestFile);

            RequestBody proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
            RequestBody motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
            RequestBody codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
            RequestBody date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
            RequestBody descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
            RequestBody marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
            RequestBody modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
            RequestBody nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
            RequestBody horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
            RequestBody dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
            RequestBody numero_fotos = RequestBody.create(MultipartBody.FORM, "1");
            call = service.createInform1(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart);

            switch (bitmaps.size())
            {
                case 1:
                    for (int i =0; i < bitmaps.size();i++)
                    {

                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }
            call.enqueue(new Callback<responseMessage>() {
                @Override
                public void onResponse(Call<responseMessage> call, Response<responseMessage> response) {
                    try {

                        int statusCode = response.code();
                        //Log.d(TAG, "HTTP status code: " + statusCode);

                        if (response.isSuccessful()) {

                            responseMessage responseMessage = response.body();
                           // Log.d(TAG, "responseMessage: " + responseMessage);

                            Toast.makeText(MainActivity.this,"respuesta"+responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("MainActivity", "onError: " + responseMessage.getMessage().toString());
                        } else {

                            //hideDialog();

                            Log.e("MainActivity", "onError: " +response.errorBody().string());
                            throw new Exception("Error en el servicio");
                        }

                    } catch (Throwable t) {
                        try {
                            //hideDialog();
                            //Log.e(TAG, "onThrowable: " + t.toString(), t);
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        } catch (Throwable x) {
                        }
                    }
                }

                @Override
                public void onFailure(Call<responseMessage> call, Throwable t) {
                    //Log.e(TAG, "onFailure: " + t.toString());
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }

            });
        }
    }
}
