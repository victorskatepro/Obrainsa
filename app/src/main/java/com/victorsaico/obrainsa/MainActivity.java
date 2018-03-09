package com.victorsaico.obrainsa;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
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
                selecPhoto();
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

        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Generando Excel","Espere por favor",false);
        progressDialog.show();
        RequestBody proyecto;
        RequestBody motivo;
        RequestBody codigo_eam;
        RequestBody date;
        RequestBody descripcion;
        RequestBody marca;
        RequestBody modelo;
        RequestBody nserie;
        RequestBody horometro;
        RequestBody dateout;
        RequestBody numero_fotos;
        File file,file1,file2,file3,file4,file5,file6,file7,file8,file9,file10;
        ByteArrayOutputStream stream,stream1,stream2,stream3,stream4,stream5,stream6,stream7,stream8,stream9,stream10;
        RequestBody requestFile;
        RequestBody requestFile2;
        RequestBody requestFile3;
        RequestBody requestFile4;
        RequestBody requestFile5;
        RequestBody requestFile6;
        RequestBody requestFile7;
        RequestBody requestFile8;
        RequestBody requestFile9;
        RequestBody requestFile10;
        byte[] byteArray;
        byte[] byteArray2;
        byte[] byteArray3;
        byte[] byteArray4;
        byte[] byteArray5;
        byte[] byteArray6;
        byte[] byteArray7;
        byte[] byteArray8;
        byte[] byteArray9;
        byte[] byteArray10;
        MultipartBody.Part imagenPart = null;
        MultipartBody.Part imagenPart2 = null;
        MultipartBody.Part imagenPart3 = null;
        MultipartBody.Part imagenPart4 = null;
        MultipartBody.Part imagenPart5 = null;
        MultipartBody.Part imagenPart6 = null;
        MultipartBody.Part imagenPart7 = null;
        MultipartBody.Part imagenPart8 = null;
        MultipartBody.Part imagenPart9 = null;
        MultipartBody.Part imagenPart10 = null;
        Bitmap bitmap,bitmap2,bitmap3,bitmap4,bitmap5,bitmap6,bitmap7,bitmap8,bitmap9,bitmap10;
        if( validar)
        {
            
            switch (uris.size())
            {
                case 1:

                        file = new File(mediaFileUri.getPath());
                        bitmap = BitmapFactory.decodeFile(file.getPath());
                        bitmap = scaleBitmapDown(bitmap, 450);
                        stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byteArray = stream.toByteArray();

                        requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
                        imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "1");
                    call = service.createInform1(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart);
                    break;
                case 2:

                    file = new File(uris.get(0).getPath());
                        bitmap = BitmapFactory.decodeFile(file.getPath());
                        bitmap = scaleBitmapDown(bitmap, 450);
                         stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byteArray = stream.toByteArray();

                        requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                        imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                   file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "2");
                    call = service.createInform2(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2);
                    break;
                case 3:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "3");
                    call = service.createInform3(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3);
                    break;
                case 4:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap4, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "4");
                    call = service.createInform4(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4);
                    break;
                case 5:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap4, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                    bitmap5 = scaleBitmapDown(bitmap5, 450);
                    stream5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                    byteArray5 = stream5.toByteArray();

                    requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                    imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);


                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "5");
                    call = service.createInform5(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5);
                    break;
                case 6:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap4, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                    bitmap5 = scaleBitmapDown(bitmap5, 450);
                    stream5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                    byteArray5 = stream5.toByteArray();

                    requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                    imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);

                    file6 = new File(uris.get(5).getPath());
                    bitmap6 = BitmapFactory.decodeFile(file6.getPath());
                    bitmap6 = scaleBitmapDown(bitmap6, 450);
                    stream6 = new ByteArrayOutputStream();
                    bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                    byteArray6 = stream6.toByteArray();

                    requestFile6 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray6);
                    imagenPart6 = MultipartBody.Part.createFormData("photo"+"6", file6.getName(), requestFile6);


                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "6");
                    call = service.createInform6(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5,imagenPart6);
                    break;
                case 7:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap4, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                    bitmap5 = scaleBitmapDown(bitmap5, 450);
                    stream5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                    byteArray5 = stream5.toByteArray();

                    requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                    imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);

                    file6 = new File(uris.get(5).getPath());
                    bitmap6 = BitmapFactory.decodeFile(file6.getPath());
                    bitmap6 = scaleBitmapDown(bitmap6, 450);
                    stream6 = new ByteArrayOutputStream();
                    bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                    byteArray6 = stream6.toByteArray();

                    requestFile6 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray6);
                    imagenPart6 = MultipartBody.Part.createFormData("photo"+"6", file6.getName(), requestFile6);

                    file7 = new File(uris.get(6).getPath());
                    bitmap7 = BitmapFactory.decodeFile(file7.getPath());
                    bitmap7 = scaleBitmapDown(bitmap7, 450);
                    stream7 = new ByteArrayOutputStream();
                    bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
                    byteArray7 = stream7.toByteArray();

                    requestFile7 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray7);
                    imagenPart7 = MultipartBody.Part.createFormData("photo"+"7", file7.getName(), requestFile7);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "6");
                    call = service.createInform7(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5,imagenPart6,imagenPart7);
                    break;
                case 8:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap4, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                    bitmap5 = scaleBitmapDown(bitmap5, 450);
                    stream5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                    byteArray5 = stream5.toByteArray();

                    requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                    imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);

                    file6 = new File(uris.get(5).getPath());
                    bitmap6 = BitmapFactory.decodeFile(file6.getPath());
                    bitmap6 = scaleBitmapDown(bitmap6, 450);
                    stream6 = new ByteArrayOutputStream();
                    bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                    byteArray6 = stream6.toByteArray();

                    requestFile6 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray6);
                    imagenPart6 = MultipartBody.Part.createFormData("photo"+"6", file6.getName(), requestFile6);

                    file7 = new File(uris.get(6).getPath());
                    bitmap7 = BitmapFactory.decodeFile(file7.getPath());
                    bitmap7 = scaleBitmapDown(bitmap7, 450);
                    stream7 = new ByteArrayOutputStream();
                    bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
                    byteArray7 = stream7.toByteArray();

                    requestFile7 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray7);
                    imagenPart7 = MultipartBody.Part.createFormData("photo"+"7", file7.getName(), requestFile7);

                    file8 = new File(uris.get(7).getPath());
                    bitmap8 = BitmapFactory.decodeFile(file8.getPath());
                    bitmap8 = scaleBitmapDown(bitmap8, 450);
                    stream8 = new ByteArrayOutputStream();
                    bitmap8.compress(Bitmap.CompressFormat.JPEG, 100, stream8);
                    byteArray8 = stream8.toByteArray();

                    requestFile8 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray8);
                    imagenPart8 = MultipartBody.Part.createFormData("photo"+"8", file8.getName(), requestFile8);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "8");
                    call = service.createInform8(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5,imagenPart6,imagenPart7,imagenPart8);
                    break;
                case  9:
                file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                bitmap = scaleBitmapDown(bitmap, 450);
                stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byteArray = stream.toByteArray();

                requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                bitmap2 = scaleBitmapDown(bitmap, 450);
                stream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                byteArray2 = stream2.toByteArray();

                requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                bitmap3 = scaleBitmapDown(bitmap3, 450);
                stream3 = new ByteArrayOutputStream();
                bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                byteArray3 = stream3.toByteArray();

                requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                bitmap4 = scaleBitmapDown(bitmap4, 450);
                stream4 = new ByteArrayOutputStream();
                bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                byteArray4 = stream4.toByteArray();

                requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                bitmap5 = scaleBitmapDown(bitmap5, 450);
                stream5 = new ByteArrayOutputStream();
                bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                byteArray5 = stream5.toByteArray();

                requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);

                file6 = new File(uris.get(5).getPath());
                    bitmap6 = BitmapFactory.decodeFile(file6.getPath());
                bitmap6 = scaleBitmapDown(bitmap6, 450);
                stream6 = new ByteArrayOutputStream();
                bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                byteArray6 = stream6.toByteArray();

                requestFile6 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray6);
                imagenPart6 = MultipartBody.Part.createFormData("photo"+"6", file6.getName(), requestFile6);

                file7 = new File(uris.get(6).getPath());
                    bitmap7 = BitmapFactory.decodeFile(file7.getPath());
                bitmap7 = scaleBitmapDown(bitmap, 450);
                stream7 = new ByteArrayOutputStream();
                bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
                byteArray7 = stream7.toByteArray();

                requestFile7 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray7);
                imagenPart7 = MultipartBody.Part.createFormData("photo"+"7", file7.getName(), requestFile7);

                file8 = new File(uris.get(7).getPath());
                    bitmap8 = BitmapFactory.decodeFile(file8.getPath());
                bitmap8 = scaleBitmapDown(bitmap8, 450);
                stream8 = new ByteArrayOutputStream();
                bitmap8.compress(Bitmap.CompressFormat.JPEG, 100, stream8);
                byteArray8 = stream8.toByteArray();

                requestFile8 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray8);
                imagenPart8 = MultipartBody.Part.createFormData("photo"+"8", file8.getName(), requestFile8);

                file9 = new File(uris.get(8).getPath());
                    bitmap9 = BitmapFactory.decodeFile(file9.getPath());
                bitmap9 = scaleBitmapDown(bitmap9, 450);
                stream9 = new ByteArrayOutputStream();
                bitmap9.compress(Bitmap.CompressFormat.JPEG, 100, stream9);
                byteArray9 = stream9.toByteArray();

                requestFile9 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray9);
                imagenPart9 = MultipartBody.Part.createFormData("photo"+"9", file9.getName(), requestFile9);

                proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                numero_fotos = RequestBody.create(MultipartBody.FORM, "9");
                call = service.createInform9(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5,imagenPart6,imagenPart7,imagenPart8,imagenPart9);
                    break;
                case 10:
                    file = new File(uris.get(0).getPath());
                    bitmap = BitmapFactory.decodeFile(file.getPath());
                    bitmap = scaleBitmapDown(bitmap, 450);
                    stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();

                    requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
                    imagenPart = MultipartBody.Part.createFormData("photo"+"1", file.getName(), requestFile);


                    file2 = new File(uris.get(1).getPath());
                    bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bitmap2 = scaleBitmapDown(bitmap2, 450);
                    stream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
                    byteArray2 = stream2.toByteArray();

                    requestFile2 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray2);
                    imagenPart2 = MultipartBody.Part.createFormData("photo"+"2", file2.getName(), requestFile2);

                    file3 = new File(uris.get(2).getPath());
                    bitmap3 = BitmapFactory.decodeFile(file3.getPath());
                    bitmap3 = scaleBitmapDown(bitmap3, 450);
                    stream3 = new ByteArrayOutputStream();
                    bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
                    byteArray3 = stream3.toByteArray();

                    requestFile3 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray3);
                    imagenPart3 = MultipartBody.Part.createFormData("photo"+"3", file3.getName(), requestFile3);

                    file4 = new File(uris.get(3).getPath());
                    bitmap4 = BitmapFactory.decodeFile(file4.getPath());
                    bitmap4 = scaleBitmapDown(bitmap, 450);
                    stream4 = new ByteArrayOutputStream();
                    bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
                    byteArray4 = stream4.toByteArray();

                    requestFile4 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray4);
                    imagenPart4 = MultipartBody.Part.createFormData("photo"+"4", file4.getName(), requestFile4);

                    file5 = new File(uris.get(4).getPath());
                    bitmap5 = BitmapFactory.decodeFile(file5.getPath());
                    bitmap5 = scaleBitmapDown(bitmap5, 450);
                    stream5 = new ByteArrayOutputStream();
                    bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
                    byteArray5 = stream5.toByteArray();

                    requestFile5 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray5);
                    imagenPart5 = MultipartBody.Part.createFormData("photo"+"5", file5.getName(), requestFile5);

                    file6 = new File(uris.get(5).getPath());
                    bitmap6 = BitmapFactory.decodeFile(file6.getPath());
                    bitmap6 = scaleBitmapDown(bitmap6, 450);
                    stream6 = new ByteArrayOutputStream();
                    bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
                    byteArray6 = stream6.toByteArray();

                    requestFile6 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray6);
                    imagenPart6 = MultipartBody.Part.createFormData("photo"+"6", file6.getName(), requestFile6);

                    file7 = new File(uris.get(6).getPath());
                    bitmap7 = BitmapFactory.decodeFile(file7.getPath());
                    bitmap7 = scaleBitmapDown(bitmap7, 450);
                    stream7 = new ByteArrayOutputStream();
                    bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
                    byteArray7 = stream7.toByteArray();

                    requestFile7 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray7);
                    imagenPart7 = MultipartBody.Part.createFormData("photo"+"7", file7.getName(), requestFile7);

                    file8 = new File(uris.get(7).getPath());
                    bitmap8 = BitmapFactory.decodeFile(file8.getPath());
                    bitmap8 = scaleBitmapDown(bitmap8, 450);
                    stream8 = new ByteArrayOutputStream();
                    bitmap8.compress(Bitmap.CompressFormat.JPEG, 100, stream8);
                    byteArray8 = stream8.toByteArray();

                    requestFile8 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray8);
                    imagenPart8 = MultipartBody.Part.createFormData("photo"+"8", file8.getName(), requestFile8);

                    file9 = new File(uris.get(8).getPath());
                    bitmap9 = BitmapFactory.decodeFile(file9.getPath());
                    bitmap9 = scaleBitmapDown(bitmap9, 450);
                    stream9 = new ByteArrayOutputStream();
                    bitmap9.compress(Bitmap.CompressFormat.JPEG, 100, stream9);
                    byteArray9 = stream9.toByteArray();

                    requestFile9 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray9);
                    imagenPart9 = MultipartBody.Part.createFormData("photo"+"9", file9.getName(), requestFile9);

                    file10 = new File(uris.get(9).getPath());
                    bitmap10 = BitmapFactory.decodeFile(file10.getPath());
                    bitmap10 = scaleBitmapDown(bitmap10, 450);
                    stream10 = new ByteArrayOutputStream();
                    bitmap10.compress(Bitmap.CompressFormat.JPEG, 100, stream10);
                    byteArray10 = stream10.toByteArray();

                    requestFile10 = RequestBody.create(MediaType.parse("image/jpeg"), byteArray10);
                    imagenPart10 = MultipartBody.Part.createFormData("photo"+"10", file10.getName(), requestFile10);

                    proyecto = RequestBody.create(MultipartBody.FORM, edtProyecto.getText().toString());
                    motivo = RequestBody.create(MultipartBody.FORM, edtMotivo.getText().toString());
                    codigo_eam = RequestBody.create(MultipartBody.FORM, edtCodeEam.getText().toString());
                    date = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    descripcion = RequestBody.create(MultipartBody.FORM, edtDescription.getText().toString());
                    marca = RequestBody.create(MultipartBody.FORM, edtMarca.getText().toString());
                    modelo = RequestBody.create(MultipartBody.FORM, edtModelo.getText().toString());
                    nserie = RequestBody.create(MultipartBody.FORM, edtSerie.getText().toString());
                    horometro = RequestBody.create(MultipartBody.FORM, edtHorometro.getText().toString());
                    dateout = RequestBody.create(MultipartBody.FORM, edtDate.getText().toString());
                    numero_fotos = RequestBody.create(MultipartBody.FORM, "10");
                    call = service.createInform10(proyecto, motivo, codigo_eam, date, descripcion,modelo, marca, nserie, horometro,dateout,numero_fotos,imagenPart,imagenPart2,imagenPart3,imagenPart4,imagenPart5,imagenPart6,imagenPart7,imagenPart8,imagenPart9,imagenPart10);

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
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this,"respuesta"+responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("MainActivity", "onError: " + responseMessage.getMessage().toString());
                        } else {

                            //hideDialog();
                            progressDialog.dismiss();
                            Log.e("MainActivity", "onError: " +response.errorBody().string());
                            throw new Exception("Error en el servicio");
                        }

                    } catch (Throwable t) {
                        try {
                            //hideDialog();
                            //Log.e(TAG, "onThrowable: " + t.toString(), t);
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        } catch (Throwable x) {
                        }
                    }
                }

                @Override
                public void onFailure(Call<responseMessage> call, Throwable t) {
                    //Log.e(TAG, "onFailure: " + t.toString());
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            });
        }
    }
}
