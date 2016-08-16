package com.example.completetextview;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2016/8/2.
 */
public class FibExplain {

       public static void fibExplain(Activity  activity){

//          Class<? extends Activity> clazz = activity.getClass();
//           Field[] fields= clazz.getDeclaredFields();
           Class<? extends Activity> clazz = activity.getClass();
           Field[] fields = clazz.getDeclaredFields();
           for (Field f : fields) {
               if(View.class.isAssignableFrom(f.getType())&& !Modifier.isStatic(f.getModifiers())){ //View.class.isAssignableFrom(f.getType())&& !Modifier.isStatic(f.getModifiers())){//

                   getFidObject(activity, clazz, f);
               }
           }
       }

    private static void getFidObject(Activity activity, Class<? extends Activity> clazz, Field field) {
        //是 view 类型的变量，并且不是静态修饰的
        FibAnnotation fib = field.getAnnotation(FibAnnotation.class);
        //调用findViewById 方法
        int  id=fib.value();
        try {
            Method findViewById = clazz.getMethod("findViewById", int.class);

            Object invoke = findViewById.invoke(activity, id);


            field.setAccessible(true);
            field.set(activity,invoke);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
