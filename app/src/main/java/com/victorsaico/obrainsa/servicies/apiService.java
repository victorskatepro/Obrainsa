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
            @Part MultipartBody.Part foto1
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3

    );
    @Multipart
    @POST("/registrar-reporte")
    Call<responseMessage> createInform14(
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5,
            @Part("foto6")RequestBody foto6
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5,
            @Part("foto6")RequestBody foto6,
            @Part("foto7")RequestBody foto7
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5,
            @Part("foto6")RequestBody foto6,
            @Part("foto7")RequestBody foto7,
            @Part("foto8")RequestBody foto8
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5,
            @Part("foto6")RequestBody foto6,
            @Part("foto7")RequestBody foto7,
            @Part("foto8")RequestBody foto8,
            @Part("foto9")RequestBody foto9
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
            @Part("foto1")RequestBody foto1,
            @Part("foto2")RequestBody foto2,
            @Part("foto3")RequestBody foto3,
            @Part("foto4")RequestBody foto4,
            @Part("foto5")RequestBody foto5,
            @Part("foto6")RequestBody foto6,
            @Part("foto7")RequestBody foto7,
            @Part("foto8")RequestBody foto8,
            @Part("foto9")RequestBody foto9,
            @Part("foto10")RequestBody foto10
    );
}
