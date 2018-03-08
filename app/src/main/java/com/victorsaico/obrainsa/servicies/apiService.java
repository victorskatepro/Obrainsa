package com.victorsaico.obrainsa.servicies;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by JARVIS on 27/02/2018.
 */

public interface apiService {
    String API_BASE_URL = "https://obrainsa-excel-fernando19.c9users.io";

    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform1(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1
            );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform2(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform3(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3

    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform4(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform5(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform6(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5,
            @Part MultipartBody.Part photo6
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform7(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5,
            @Part MultipartBody.Part photo6,
            @Part MultipartBody.Part photo7
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform8(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5,
            @Part MultipartBody.Part photo6,
            @Part MultipartBody.Part photo7,
            @Part MultipartBody.Part photo8
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform9(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5,
            @Part MultipartBody.Part photo6,
            @Part MultipartBody.Part photo7,
            @Part MultipartBody.Part photo8,
            @Part MultipartBody.Part photo9
    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform10(
            @Part("proyecto")RequestBody proyecto,
            @Part("motivo")RequestBody motivo,
            @Part("codigo_eam")RequestBody codigoEam,
            @Part("fecha_fotos")RequestBody date,
            @Part("descripcion")RequestBody descripcion,
            @Part("marca")RequestBody marca,
            @Part("modelo")RequestBody modelo,
            @Part("n_serie")RequestBody nserie,
            @Part("horometro") RequestBody horometro,
            @Part("fecha_salida")RequestBody dateout,
            @Part("numero_fotos") RequestBody numero_fotos,
            @Part MultipartBody.Part photo1,
            @Part MultipartBody.Part photo2,
            @Part MultipartBody.Part photo3,
            @Part MultipartBody.Part photo4,
            @Part MultipartBody.Part photo5,
            @Part MultipartBody.Part photo6,
            @Part MultipartBody.Part photo7,
            @Part MultipartBody.Part photo8,
            @Part MultipartBody.Part photo9,
            @Part MultipartBody.Part photo10
    );
}
