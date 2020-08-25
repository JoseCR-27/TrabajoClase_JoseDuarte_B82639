package cr.ac.ucr.primeraapp.utis;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    private final String PREFERENCES = "myapp_preferences";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static AppPreferences preferences;

    public static class Keys {
        //Todas las contantes tienen que ser con mayuscula y guiones bajos
        public static final String IS_LOGGED_IN = "is_logged_in";
        public static final String IS_REGISTERED_IN = "is_registered_in";
        public static final String ITEMS = "items";
    }

    private AppPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public static AppPreferences getInstance(Context context){
        if(preferences == null){
            preferences = new AppPreferences(context);
        }
        return preferences;
    }

    //------------------------- Metodos PUT -------------------------------
    public void put(String key, String value){
        doEdit();

        editor.putString(key, value);

        commit();
    }

    public void put(String key, int value){
        doEdit();

        editor.putInt(key, value);

        commit();
    }

    public void put(String key, long value){
        doEdit();

        editor.putLong(key, value);

        commit();
    }

    public void put(String key, boolean value){
        doEdit();

        editor.putBoolean(key, value);

        commit();
    }

    public void put(String key, double value){

        put(key, String.valueOf(value));

    }

    public void put(String key, float value){
        doEdit();

        editor.putFloat(key, value);

        commit();
    }

    //------------------------- FIN Metodos PUT -------------------------------

    //------------------------- Metodos GET -------------------------------

    public String getString(String key){
        return sharedPreferences.getString(key, "");
    }

    public String getString(String key, String defValue){
        return sharedPreferences.getString(key, defValue);
    }

    public int getInt(String key){
        return sharedPreferences.getInt(key, 0);
    }

    public int getInt(String key, int defValue){
        return sharedPreferences.getInt(key, defValue);
    }

    public double getDouble(String key){
        try{
            return Double.parseDouble(sharedPreferences.getString(key, "0"));
        } catch (NumberFormatException e){
            return 0;
        }

    }

    public double getDouble(String key, double defValue){
        try{
            return Double.parseDouble(sharedPreferences.getString(key, String.valueOf(defValue)));
        } catch (NumberFormatException e){
            return defValue;
        }

    }

    public boolean getBoolean(String key, boolean defValue){
        return sharedPreferences.getBoolean(key, defValue);
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public long getLong(String key, long defValue){
        return sharedPreferences.getLong(key, defValue);
    }

    public long getLong(String key){
        return sharedPreferences.getLong(key, 0);
    }

    public Float getFloat(String key, float defValue){
        return sharedPreferences.getFloat(key, defValue);
    }

    public float getFloat(String key){
        return sharedPreferences.getFloat(key, 0);
    }

    //------------------------- FIN Metodos GET -------------------------------


    public void clear(){
        doEdit();

        editor.clear();

        commit();
    }

    //String[] list = new String[]
    //ArrayList<string> list = new ArrayList()
    //String ... args

    //Para usarlo remove("key1", "...")
    public void remove(String ... keys){
        doEdit();

        for(String key: keys){
            editor.remove(key);
        }

        commit();
    }

    //Iniciar o revisar variable del editor
    private void doEdit(){
        if(editor == null){
            editor = sharedPreferences.edit();
        }
    }

    //Modificar la variable editor
    private void commit(){
        if(editor != null){
            editor.commit();
            editor = null;
        }
    }
}
