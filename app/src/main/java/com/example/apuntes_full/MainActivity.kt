package com.example.apuntes_full

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putString("PRUEBA","WHUT")
            commit()
        }
    }
    /*
    * - - - - CICLOS DE VIDA - - - - -
    *   onCreate() -> este siempre esta hecho
    *   onStart() -> Se ejecuta después del onCreate cuando se crea por primera vez o cuando una Activity ha sido sacada de memoria y quiere volverse a mostrar.
    *   onResume() -> Se ejecuta después del onStart o cuando una Activity que estaba en segundo plano vuelve a estar en primer plano.
    *   onPause() -> Se ejecuta cuando el usuario manda una Activity al segundo plano.
    *   onStop() -> Se ejecuta cuando la Activity deja de ser visible.
    *   onDestroy() -> Se ejecuta cuando el usuario elimina la Activity del segundo plano o Android requiere memoria. No siempre se ejecuta
    *
    *  - - - - SAVED INSTANCE - - - -
    * al destruirse una activity se pierden todos los datos, para obtener datos y que no desaparezcan
    * usamos las saveInstance
    *
    * para guardar necesitamos la funcion:
    * override fun onSaveInstanceState(outState: Bundle){
    *   Log.d("miTag","se ha guardado correctamente")
    *   outState("NOMBRE_TAG_GUARDADO","valor", o bien sacado de un edit text o a lo bestia)
    *   super.onSaveInstanceState(outState)
    *   }
    *
    * Para recuperarlo cuando se ejecuta el oncreate
    *   savedInstanceState?.run{ lo hago en un run con ? para evitar que este vacio
    *       getString("TAG")?.let{
    *           etText.setText(it)
    *       }
    *   }
    *
    * - - - - SHARED PREFERENCES - - - -
    *   Sirve para almacenar datos de manera persistente.
    *       val sharedPref = getPreferences(context.MODE_PRIVATE)
    *
    *   Para guardar datos en las SharedPreferences
    *       with(sharedPref.edit()){
    *           putString(TAG_USUARIO,string)
    *           commit()
    *       }
    *   Para cargar el valor
    *       return sharedPref.getString(TAG_USUARIO,"")
    *
    *
    * - - - - TOAST - - - -
    * Saca por pantalla un toast, como los de bootstrap, pues asi
    *   Toast.makeText(this,"texto",duracion).show()
    *                               - - duraciones - -
    *                                   -> Toast.LENGTH_LONG
    *                                   ->Toast.LENGHT_SHORT
    *
    *  - - - LISTENERS - - -
    *   Los listener basicamente son funciones que nos mantienen a la espera de algun evento
    *   para ralizar acciones
    *
    *   boton-texto-etc.setOnClickListener {
    *
    *   }
    *
    *   boton-texto-etc.setOnLongClickListener {
    *
    *   }
    *
    *   boton-texto-etc.addTextChangedListener( object : TextWrcher {
    *       override fun afterTextChanged(s: Editable?){
    *       }
    *       override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    *       }
    *       override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    *       }
    *   })
    *   editText.setOnFocusChangeListener{v , hasFocus ->
    *       if(hasFocus){
    *
    *       }else{
    *
    *       }
    *   }
    *
    * - - - - MODIFICAR - - - -
    *
    * para acceder a una vista
    *   idVista.text = "cambiartexto"
    *       -> funciona con editText, textView etc...
    *
    *
    *
    * - - - - INTENTS (crear nuevas activitys) - - - -
    * definir nuevo activity en fichero a parte
    * class SecondActivity : AppCompatActivity(){
    *   override fun onCreate(savedInstanceState:Bundle?){
    *           super.onCreate(savedInstanceState)
    *           setContentView(R.layout.nombre_layout)
    *       }
    *
    *   }
    *
    * se debe actualizar el manifest
    * <activity android:name=".NombreActivity" />
    *
    *   Para acceder a esa nueva activity tenemos que "llamarla"
    *
    *   val intent = Intent(this,NombreActividad::Class.java) aqui asignamos a una variable esa actividad
    *   startActivity(intent) <- esto la llama
    *
    * - - - - Pasar datos entre activitys - - - -
    *
    * val intent = Intent(this,NombreActividad::Class.java)
    * se pasa informacion mediante putExtra
    * intent.putExtra("clave","valor")
    * startActivity(intent)
    *
    * se recibe en la actividad de la siguiente manera
    *   val nombre = intent.getStringExtra("clave")
    *
    *       - Buena practica -
    *           Es buena practica declarar las claves como un companion object en la actividad de donde
    *           sean esas claves
    *
    *           companion object{
    *               const val CLAVE_1 = "ClaveSecondActivity"
    *           }
    *
    *           nombre?.let{ <- esto nos permitiria realizar acciones si nombre no es nulo.
    *
    *           }
    * */



}